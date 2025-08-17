package lk.nexus.home.nexusportal.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import lk.nexus.home.nexusportal.conf.AbcConf;
import lk.nexus.home.nexusportal.dto.RegisterDto;
import lk.nexus.home.nexusportal.models.Clientregister;
import lk.nexus.home.nexusportal.models.Register;
import lk.nexus.home.nexusportal.models.VerificationToken;
import lk.nexus.home.nexusportal.repository.ClientregisterRepository;
import lk.nexus.home.nexusportal.repository.RegisterDataRepository;
import lk.nexus.home.nexusportal.rowmapper.RegisterRowMapper;

@Service
@Transactional
public class RegisterService {

	@Autowired
	private RegisterDataRepository registerRepo;

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	VerificationTokenService verificationservice;

	@Autowired
	AbcConf abc;

	@Autowired
	ClientregisterRepository clientRegister;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void registerClient(Register registerData) {

		registerRepo.save(registerData);
		System.out.println("RegisterService" + registerData.getEmailaddress());
		sendEmail(registerData.getEmailaddress());

	}

	public List<Register> listPendingRegisterrequestService() {

		return registerRepo.listPendingRegisterrequest("P");

	}

	void sendEmail(String emailaddress) {

		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(emailaddress);

		msg.setSubject("Testing from Spring Boot");
		msg.setText("Hello World \n Spring Boot Email");

		javaMailSender.send(msg);

	}

	public RegisterDto getRegisterDetails(Long id) {

		RegisterDto reg = new RegisterDto();
		System.out.println("#############getRegisterDetails " + id);
		// reg = registerRepo.getRegisterDetailsDao(id);
		try {
			// reg = getRegister(id);
			StringBuffer sb = new StringBuffer();
			sb.append(
					"SELECT *,(select branchdescription from branchdetails p where p.branchcode = r.pickupbranch ) AS brnamedesc, ");
			sb.append("(SELECT bankdescription FROM bankdetails bn where bn.bankcode = r.bankname) AS custbankdesc, ");
			sb.append(
					"(SELECT branchdescription FROM bankbranchdetails br where br.bankcode = r.bankname and br.barnchcode = r.bankaccountbranch) AS custbankbranchdesc ");
			sb.append("FROM register r WHERE r.id = ? ");

			reg = jdbcTemplate.queryForObject(sb.toString(), new Object[] { id }, new RegisterRowMapper());
			// List<RegisterDto> r = jdbcTemplate.query("select * from register" ,new
			// RegisterRowMapper());
			reg = getSMSalertoptions(reg);
			System.out.println("RegisterDto :::" + reg.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reg;
	}

	public void updateRateTypeService(String ratetype, Long regid) {
		Register reg = null;

		registerRepo.updateCustomerRateTypeDao(ratetype, regid);
	}

	public void sentLoggingRequestService(Long id) {
		Register reg = null;
		reg = registerRepo.getRegisterDetailsDao(id);

		VerificationToken v = verificationservice.createVerificationTokenforUser(reg.getEmailaddress(),
				reg.getEmailaddress(), reg.getAccountid(), id);

		String subject = "Registration Confirmation : ";
		// String url = event.getAppUrl() + "/confirmRegistration?token=" +
		// v.getToken();
		String url = abc.getNexusclientipurl() + "/NexusClient" + "/confirmRegistration?token=" + v.getToken();
		String message = "message.registrationSuccessConfimationLink";// messages.getMessage("message.registrationSuccessConfimationLink",
																		// null, event.getLocale());

//        SimpleMailMessage email = new SimpleMailMessage();
//        
//        email.setTo(event.getUser().getEmailaddress());
//        email.setSubject(subject);
		// String x = "";
		// String content="<a href=\"www.abc.com/activation?hash="+i+"\">click
		// here</a>";
		String content = "<a href=\"http://localhost:8080=" + url + ">click here</a>";

		String html = "<!doctype html>\n" + "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\"\n"
				+ "      xmlns:th=\"http://www.thymeleaf.org\">\n" + "<head>\n" + "    <meta charset=\"UTF-8\">\n"
				+ "    <meta name=\"viewport\"\n"
				+ "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" + "    <title>Email</title>\n"
				+ "</head>\n" + "<body>\n" + "<div>Welcome <b>" + "WelCome to  Nexus Dilevery " + "</b></div>\n" + "\n"
				+ "<div> " + "Dear Customer, " + "</div>\n" +
				// "<div> " + "<a href=http://localhost:8080"+url+">click here</a>" + "</div>\n"
				// +
				"<div> " + "<a href=" + url + ">click here</a>" + "</div>\n" + "</body>\n" + "</html>\n";

		try {
			javax.mail.internet.MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
			helper.setSubject("Welcome ");

			// Context context = new Context();
			// context.setVariable("message", html);

			// String process = templateEngine.process("welcome222", context);
			// email.setText(message + " http://localhost:8080" + url);
			// email.setText(html);
//            javax.mail.internet.MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
//            helper.setSubject("Welcome " );
//            helper.setText(process, true);
//            helper.setTo(event.getUser().getEmailaddress());
			// javaMailSender.createMimeMessage(contentStream)
			// email.set
			// System.out.println(url);
			helper.setText(html, true);
			helper.setTo(reg.getEmailaddress());
			javaMailSender.send(mimeMessage);

			registerRepo.updatePendingRegsterDetailsDao("Y", id);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void sentLoggingRequestServiceWithData(RegisterDto registerData) {

		try {
			System.out.println("sentLoggingRequestServiceWithData 1 **************************");

			Register regObj = convertRegisterDtoToRegisterObj(registerData);
			registerRepo.save(regObj);

			VerificationToken v = verificationservice.createVerificationTokenforUser(registerData.getEmailaddress(),
					registerData.getEmailaddress(), registerData.getAccountid(), registerData.getId());

			System.out.println("sentLoggingRequestServiceWithData 2 **************************");
			RegisterDto rd = getRegisterDetails(registerData.getId());
			String det = getEmaildata(rd);
			String subject = "Registration Confirmation : ";
			// String url = event.getAppUrl() + "/confirmRegistration?token=" +
			// v.getToken();
			String url = abc.getNexusclientipurl() + "/NexusClient" + "/confirmRegistration?token=" + v.getToken();
			String message = "message.registrationSuccessConfimationLink";// messages.getMessage("message.registrationSuccessConfimationLink",
																			// null, event.getLocale());
			System.out.println("sentLoggingRequestServiceWithData 3 **************************");
			String html = "<!doctype html>\n" + "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\"\n"
					+ "      xmlns:th=\"http://www.thymeleaf.org\">\n" + "<head>\n" + "    <meta charset=\"UTF-8\">\n"
					+ "    <meta name=\"viewport\"\n"
					+ "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n"
					+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" + "    <title>Email</title>\n"
					+ "</head>\n" + "<body>\n" + "<div><b>" + "WelCome to  Nexus Dilevery " + "</b></div>\n" + "\n"
					+ "<div> " + "Dear Customer, " + "</div>\n" + "<div> "
					+ " please check below details and click on the link to create the logging " + "</div>\n" + "<div> "
					+ det + "</div>\n" + "<div> " + "<a href=" + url + ">click here</a>" + "</div>\n" + "</body>\n"
					+ "</html>\n";

			System.out.println("sentLoggingRequestServiceWithData 4 **************************");
			try {
				javax.mail.internet.MimeMessage mimeMessage = javaMailSender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
				helper.setSubject("Welcome ");
				System.out.println("sentLoggingRequestServiceWithData 5 **************************");

				System.out.println("sentLoggingRequestServiceWithData 6 **************************");
				helper.setText(html, true);
				helper.setTo(registerData.getEmailaddress());
				javaMailSender.send(mimeMessage);

				registerRepo.updatePendingRegsterDetailsDao("Y", regObj.getId());

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private String getEmaildata(RegisterDto registerData) {

		StringBuffer sb = new StringBuffer();

		sb.append("<table>");
		sb.append("<tr><th></th><th></th></tr>");
		sb.append("<tr><td>Full Name: </td><td>" + registerData.getFullname_businessname() + "</td></tr>");
		sb.append("<tr><td>System name : </td><td>" + registerData.getWebstore() + "</td></tr>");
		sb.append("<tr><td>Address : </td><td>" + registerData.getAddress1() + "</td></tr>");
		sb.append("<tr><td>Email Address: </td><td>" + registerData.getEmailaddress() + "</td></tr>");
		sb.append("<tr><td>Pickup Branch : </td><td>" + registerData.getPickupbranchDesc() + "</td></tr>");
		sb.append("<tr><td>Account Type : </td><td>" + registerData.getAccouttypedesc() + "</td></tr>");
		sb.append("<tr><td>Nic </td><td>" + registerData.getNic_drivinglicence() + "</td></tr>");
		sb.append("<tr><td>Contact No </td><td>" + registerData.getContactno() + "</td></tr>");
		sb.append("<tr><td>Business Registration No: </td><td>" + registerData.getBrno() + "</td></tr>");
		sb.append("<tr><td>Contact Person : </td><td>" + registerData.getContactperson() + "</td></tr>");
		sb.append("<tr><td>Bussiness Name : </td><td>" + registerData.getBusinessName() + "</td></tr>");
		sb.append(
				"<tr><td>Relationship to business </td><td>" + registerData.getRelationshiptobusiness() + "</td></tr>");
		sb.append("<tr><td>Bank Name :</td><td>" + registerData.getBankNameDesc() + "</td></tr>");
		sb.append("<tr><td>Bank Branch Name </td><td>" + registerData.getBankAccountBranchDesc() + "</td></tr>");
		sb.append("<tr><td>Account Holder Name </td><td>" + registerData.getAccountHolderName() + "</td></tr>");
		sb.append("<tr><td>Account Type </td><td>" + registerData.getAccouttypedesc() + "</td></tr>");
		sb.append("<tr><td>Contact Person NIC </td><td>" + registerData.getContactpersonnic() + "</td></tr>");
		sb.append("<tr><td>Contact No 2 (Land Line) </td><td>" + registerData.getContactno2() + "</td></tr>");

		sb.append("<tr><td>System name </td><td>" + registerData.getAddress1() + "</td></tr>");
		sb.append("<tr><td>System name </td><td>" + registerData.getAddress1() + "</td></tr>");
		sb.append("<tr><td>System name </td><td>" + registerData.getAddress1() + "</td></tr>");
		sb.append("<tr><td>System name </td><td>" + registerData.getAddress1() + "</td></tr>");
		sb.append("<tr><td>System name </td><td>" + registerData.getAddress1() + "</td></tr>");
		sb.append("<tr><td>System name </td><td>" + registerData.getAddress1() + "</td></tr>");
		sb.append("<tr><td>System name </td><td>" + registerData.getAddress1() + "</td></tr>");
		sb.append("<tr><td>System name </td><td>" + registerData.getAddress1() + "</td></tr>");

		sb.append("</table>");

		return sb.toString();
	}

	private Register convertRegisterDtoToRegisterObj(RegisterDto dto) {

		Register r = new Register();

		r.setAccountholdername(dto.getAccountHolderName());
		r.setAccountid(dto.getAccountid());
		r.setAccouttype(dto.getAccouttype());
		r.setAddress1(dto.getAddress1());
		r.setAddress2(dto.getAddress2());
		r.setBankaccountbranch(dto.getBankAccountBranch());
		r.setBankaccounttype(dto.getBankAccountType());
		r.setBankname(dto.getBankName());
		r.setBrno(dto.getBrno());
		r.setBusinessname(dto.getBusinessName());
		r.setCity(dto.getCity());
		r.setClientreferential(dto.getClientreferential());
		r.setContactno(dto.getContactno());
		r.setContactno2(dto.getContactno2());
		r.setContactperson(dto.getContactperson());
		r.setContactpersonnic(dto.getContactpersonnic());
		r.setEmailaddress(dto.getEmailaddress());
		r.setFullname_businessname(dto.getFullname_businessname());
		r.setId(dto.getId());
		r.setNic_drivinglicence(dto.getNic_drivinglicence());
		r.setPayementtype(dto.getPayementtype());
		r.setPickupbranch(dto.getPickupbranch());
		r.setRatetype(dto.getRatetype());
		r.setRelationshiptobusiness(dto.getRelationshiptobusiness());
		r.setSmsalert(dto.getSmsalert());
		r.setSystemname(dto.getSystemName());
		r.setWebstore(dto.getWebstore());

		return r;

	}

	public boolean isExsistAccountId(String accountId) {
		boolean retFlag = false;
		Clientregister client = null;

		try {
			client = (Clientregister) clientRegister.findById(accountId).get();
		} catch (Exception e) {

			e.printStackTrace();
		}

		if (client == null) {

		} else {
			retFlag = true;

		}
		return retFlag;

	}

	public Register getRegister(long id) {
		Register reg = new Register();
		try {
			StringBuffer sb = new StringBuffer();
//			 sb.append("SELECT r.emailaddress,(select branchdescription from branchdetails p where p.branchcode = r.pickupbranch ) AS brname, ");
//			 sb.append("(SELECT bankdescription FROM bankdetails bn where bn.bankcode = r.bank_name) AS custbank, ");
//			 sb.append("(SELECT branchdescription FROM bankbranchdetails br where br.bankcode = r.bank_name and br.barnchcode = r.bank_account_branch) AS custbankbranch ");
//			 sb.append("FROM register r WHERE r.id = ? ");
			sb.append("SELECT * FROM register r WHERE r.id = ? ");

			return jdbcTemplate.query(sb.toString(), new Object[] { id }, new ResultSetExtractor<Register>() {
				@Override
				public Register extractData(ResultSet rs) throws SQLException {
					if (!rs.next()) {
						return null;
					}

					reg.setEmailaddress(rs.getString("emailaddress"));

					return reg;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}

		return reg;
	}
	// recv_pic_br
	// recv_ho

	private RegisterDto getSMSalertoptions(RegisterDto r) {
		try {
			String alertList = r.getSmsalert();
			String alertAr[] = alertList.split(",");

			for (String s : alertAr) {

				String str = s;
				switch (str) {
				case "1":
					r.setSms_recv_pic_br("1");
					break;
				case "2":
					r.setSms_recv_ho("2");
					break;
				case "3":
					r.setSms_disp_dest_br("3");
					break;
				case "4":
					r.setSms_recv_dest_br("4");
					break;
				case "5":
					r.setSms_out_dele("5");
					break;
				case "6":
					r.setSms_rech_1("6");
					break;
				case "7":
					r.setSms_rech_2("7");
					break;
				case "8":
					r.setSms_rech_3("8");
					break;
				case "9":
					r.setSms_returned("9");
					break;
				case "10":
					r.setSms_delivered("10");
					break;
				default:
					System.out.println("no match");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return r;
	}

//	 public Register getRegister(long id) {
//		 Register reg = new Register();
//		try {
//			StringBuffer sb = new StringBuffer();
////			 sb.append("SELECT r.emailaddress,(select branchdescription from branchdetails p where p.branchcode = r.pickupbranch ) AS brname, ");
////			 sb.append("(SELECT bankdescription FROM bankdetails bn where bn.bankcode = r.bank_name) AS custbank, ");
////			 sb.append("(SELECT branchdescription FROM bankbranchdetails br where br.bankcode = r.bank_name and br.barnchcode = r.bank_account_branch) AS custbankbranch ");
////			 sb.append("FROM register r WHERE r.id = ? ");
//			sb.append("SELECT * FROM register r WHERE r.id = ? ");
//			 
//			    return jdbcTemplate.query(sb.toString(), new Object[] {id},
//			        new ResultSetExtractor<Register>() {
//			            @Override
//			            public Register extractData(ResultSet rs) throws SQLException {
//			                if (!rs.next()) {
//			                    return null;
//			                }
//			                
//			                
//			                reg.setEmailaddress(rs.getString("emailaddress"));
//			                
//			                return reg;
//			            }
//			        });
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
//		
//		return reg;
//		}

}
