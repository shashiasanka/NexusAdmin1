package lk.nexus.client.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import lk.nexus.client.events.OnRegistrationSuccessEvent;
import lk.nexus.client.models.VerificationToken;
import lk.nexus.client.service.VerificationTokenService;


@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationSuccessEvent> {
	@Autowired
	VerificationTokenService verifyService;
	
	@Autowired
	  private JavaMailSender javaMailSender;
	
	@Autowired
	TemplateEngine templateEngine;
	
	@Override
	public void onApplicationEvent(OnRegistrationSuccessEvent event) {
		try {
			System.out.println("@@@@@@@@@Sucesss  @@@@@@@@@@"+event.getUser().toString());
			//VerificationToken v = verifyService.createVerificationTokenforUser(event.getUser().getClientloging().getUsername(),event.getUser().getEmailaddress(),event.getUser().getAccountid());
			VerificationToken v = verifyService.createVerificationTokenforUser("shashi",event.getUser().getEmailaddress(),event.getUser().getAccountid());

			//String recipient = user.getEmail();
			String subject = "Registration Confirmation";
	        String url = event.getAppUrl() + "/confirmRegistration?token=" + v.getToken();
	        String message ="message.registrationSuccessConfimationLink";// messages.getMessage("message.registrationSuccessConfimationLink", null, event.getLocale());
	         
//	        SimpleMailMessage email = new SimpleMailMessage();
//	        
//	        email.setTo(event.getUser().getEmailaddress());
//	        email.setSubject(subject);
	        //String x = "";
	        //String content="<a href=\"www.abc.com/activation?hash="+i+"\">click here</a>";
	        String content="<a href=\"http://localhost:8080="+url+">click here</a>";
	        
	        String html = "<!doctype html>\n" +
	                "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\"\n" +
	                "      xmlns:th=\"http://www.thymeleaf.org\">\n" +
	                "<head>\n" +
	                "    <meta charset=\"UTF-8\">\n" +
	                "    <meta name=\"viewport\"\n" +
	                "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
	                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
	                "    <title>Email</title>\n" +
	                "</head>\n" +
	                "<body>\n" +
	                "<div>Welcome <b>" + "WelCome to  Nexus Dilevery " + "</b></div>\n" +
	                "\n" +
	                "<div> " +"Dear Customer, " + "</div>\n" +
	                "<div> " + "<a href=http://localhost:8080"+url+">click here</a>" + "</div>\n" +
	                "</body>\n" +
	                "</html>\n";
	        
	        javax.mail.internet.MimeMessage mimeMessage = javaMailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
	        helper.setSubject("Welcome " );

	       // Context context = new Context();
	      //  context.setVariable("message", html);
	        
	       // String process = templateEngine.process("welcome222", context);
	        //email.setText(message + " http://localhost:8080" + url);
	      //  email.setText(html);
//	        javax.mail.internet.MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//	        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
//	        helper.setSubject("Welcome " );
//	        helper.setText(process, true);
//	        helper.setTo(event.getUser().getEmailaddress());
	       // javaMailSender.createMimeMessage(contentStream)
	      //  email.set
	       // System.out.println(url);
	        helper.setText(html, true);
	        helper.setTo(event.getUser().getEmailaddress());
	        javaMailSender.send(mimeMessage);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//System.out.println("@@@@@@@@@Sucesss  @@@@@@@@@@");
		
	}

}
