package lk.nexus.client.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import lk.nexus.client.conf.NexusClientConf;
import lk.nexus.client.dto.Abc;
import lk.nexus.client.dto.ClientlogingDto;
import lk.nexus.client.dto.DashboardResults;
import lk.nexus.client.dto.TrackingId;
import lk.nexus.client.models.Branchdemaction;
import lk.nexus.client.models.Clientloging;
import lk.nexus.client.models.Clientorder;
import lk.nexus.client.models.Districts;
import lk.nexus.client.models.Pickuprequest;
import lk.nexus.client.models.Ratecode;
import lk.nexus.client.models.Register;
import lk.nexus.client.service.BranchdetailsService;
import lk.nexus.client.service.ClientorderService;
import lk.nexus.client.service.NexusFileReadingService;
import lk.nexus.client.service.PDFService;
import lk.nexus.client.service.PDFService2;
import lk.nexus.client.service.PDFService3;
import lk.nexus.client.service.PickuprequestService;
import lk.nexus.client.service.RegisterService;
import lk.nexus.client.service.SearchService;
import lk.nexus.client.util.NexusClientUtil;
import lk.nexus.client.util.ZXingHelper;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JRDataSource;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.lowagie.text.DocumentException;

@Controller
public class NexusClientContoller {

	@Autowired
	private PickuprequestService pickupService;

	@Autowired
	private ClientorderService clientorderservice;

	@Autowired
	private NexusFileReadingService nexusFileReadingService;

	@Autowired
	private NexusClientConf nexusClientConf;
	
	@Autowired
	SearchService searchservice;

	@Autowired
	PDFService3 pdfService;

	@Autowired
	PDFService2 pdfService2;

	
	@Autowired
	BranchdetailsService branchService;
	
	@Autowired
	RegisterService registerService;
	
	
	// private static final Logger logger =
	// LogManager.getLogger(NexusClientContoller.class);

	private static final String EXTERNAL_FILE_PATH = "C:/fileDownloadExample/";

	@GetMapping("/pickuprequest")
	public String loadpickupReuestpage(Model model, HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		Clientloging client = (Clientloging) session.getAttribute("loggeduser");
		model.addAttribute("loggeduser", client);
		model.addAttribute("pickupdetails", new Pickuprequest());

		// return "client_pickuprequest";
		return "xclient_pickuprequest";
	}

	@PostMapping("/Pickuprequest")
	public String getPickupRequest(@ModelAttribute Pickuprequest picupreq, Model model, HttpServletRequest request) {
		model.addAttribute("pickupdetails", picupreq);
		HttpSession session = request.getSession(false);
		ClientlogingDto client = (ClientlogingDto) session.getAttribute("loggeduser");
		model.addAttribute("loggeduser", client);

		picupreq.setClientid(client.getClientid());
		picupreq.setClientname(client.getClientbusinessname());

		pickupService.sendPickupRequest(picupreq);

		Pickuprequest pickupReq = new Pickuprequest();
		pickupReq.setIspickuprequestsuccess("Y");
		model.addAttribute("pickupdetails", pickupReq);
		// return "client_pickuprequest";

		return "xclient_pickuprequest";
	}
	// @ModelAttribute Clientloging logingdata, Model model,HttpServletRequest
	// request

	@PostMapping("/Addorder")
	// @RequestMapping(value="/Addorder", method=RequestMethod.POST,
	// params="action=AddOrder")
	public String addOrder(@ModelAttribute Clientorder clientorder, Model model, HttpServletRequest request) {
		// model.addAttribute("clientorder", clientorder);
		HttpSession session = request.getSession(false);
		System.out.println("#######1111111111111111111111111111");
		ClientlogingDto client = (ClientlogingDto) session.getAttribute("loggeduser");
		model.addAttribute("loggeduser", client);
		System.out.println("#######22222222222222222222");
		// picupreq.setClientid(client.getClientid());
		// picupreq.setClientname(client.getClientbusinessname());
		clientorder.setClientid(client.getClientid());
		//clientorder.setClientname(client.getClientbusinessname());
		// pickupService.sendPickupRequest(picupreq);
		model.addAttribute("dashboard", clientorderservice.getOrderDetailstoDashboardService(client.getClientid()));
		System.out.println("#######333333333333333333333");

		// if(!validateClientOrder(clientorder)) {
		if (validateClientOrder(clientorder).size() > 0) {

			System.out.println("#######4444444444444");
			clientorder.setErrorflag("Y");
			StringBuffer sb = new StringBuffer();
			for (String s : validateClientOrder(clientorder)) {
				sb.append(s + " | ");

			}
			clientorder.setDisplayemessage(sb.toString());
			model.addAttribute("maincategorylist", clientorderservice.getMainCatgoryList());
			model.addAttribute("clientorder", clientorder);
		} else {
			System.out.println("#######555555555555555555555555555555555");
			//clientorder = clientorderservice.createClientOrder(clientorder);
			String pickupBr = clientorderservice.getClientPickupBranch(client.getClientid());
			List<Ratecode> ratelist =	registerService.getRatecodeList(pickupBr, "d");
			clientorder = clientorderservice.addClientOrder(clientorder,pickupBr,ratelist);
			model.addAttribute("maincategorylist", clientorderservice.getMainCatgoryList());
			model.addAttribute("clientorder", clientorder);
		}
		// validateClientOrder

		// return "client_addorder";
		return "xclient_addorder";
	}

	@GetMapping("/clientorder")
	public String loadaddClientOrderpage(Model model, HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		ClientlogingDto client = (ClientlogingDto) session.getAttribute("loggeduser");

		;
		model.addAttribute("provincelist", clientorderservice.getProvincelist());
		model.addAttribute("maincategorylist", clientorderservice.getMainCatgoryList());
		model.addAttribute("branchlist", branchService.getBranchList());

		model.addAttribute("loggeduser", client);
		model.addAttribute("clientorder", new Clientorder());

		// return "client_addorder";
		return "xclient_addorder";
	}

	// LoadOrdersbyStatus?statusid

	@GetMapping("/LoadOrdersbyStatus")
	public String loadaddClientOrderDetails(Model model, HttpServletRequest request,
			@RequestParam("statusid") String statusid) {

		System.out.println("CCCC" + statusid);
		HttpSession session = request.getSession(false);
		ClientlogingDto client = (ClientlogingDto) session.getAttribute("loggeduser");

		// System.out.println("EE"+clientorderservice.listOfClientOrdersByStatus(client.getClientid(),
		// statusid).toString());;
		model.addAttribute("clientorderlist",
				clientorderservice.listOfClientOrdersByStatus(client.getClientid(), statusid));
		model.addAttribute("dashboard", clientorderservice.getOrderDetailstoDashboardService(client.getClientid()));
		model.addAttribute("loggeduser", client);
		// model.addAttribute("clientorder", new Clientorder());

		// return "client_addorder";
		return "client_dashboard";
	}

	@PostMapping("/LoadOrder")
	// @RequestMapping(value="/Addorder", method=RequestMethod.POST,
	// params="action=AddOrder")
	public String addOrder1(Model model, HttpServletRequest request,
			@RequestParam("ordertrackingid") String ordertrackingid) {

		System.out.println("##########LoadOrder################");
		System.out.println("##########LoadOrder################" + ordertrackingid);
		HttpSession session = request.getSession(false);

		model.addAttribute("clientorder", clientorderservice.getOrderDetailsbyTrackingId(ordertrackingid));
		ClientlogingDto client = (ClientlogingDto) session.getAttribute("loggeduser");
		model.addAttribute("loggeduser", client);

		return "client_vieworder";
	}

	@GetMapping("/Home")
	public String loadHome(Model model, HttpServletRequest request) {
		//
		// System.out.println("CCCC"+statusid);
		HttpSession session = request.getSession(false);
		ClientlogingDto client = (ClientlogingDto) session.getAttribute("loggeduser");

		// System.out.println("EE"+clientorderservice.listOfClientOrdersByStatus(client.getClientid(),
		// statusid).toString());;
		model.addAttribute("clientorderlist",
				clientorderservice.listOfClientOrdersByStatus(client.getClientid(), "NEWO"));
		model.addAttribute("dashboard", clientorderservice.getOrderDetailstoDashboardService(client.getClientid()));
		model.addAttribute("loggeduser", client);
		// model.addAttribute("clientorder", new Clientorder());

		// return "client_addorder";
		return "client_dashboard";
	}

	// @GetMapping("/TrackingId")
	@RequestMapping(value = "/TrackingId", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody TrackingId loadTrackingIddfd(Model model, HttpServletRequest request) {

		System.out.println("wrwerretertrtertr");
		model.addAttribute("trackid", "23234324");

		TrackingId t = new TrackingId();
		t.setTrackingId("asdadadad");
		// Clientloging client= new Clientloging();
		// ReturObjectJson returJsonObject = new ReturObjectJson();
		return t;
		// return "client_pickuprequest";
	}

	@RequestMapping(value = "/TrackingId23", method = RequestMethod.GET)
	public void loadTrackingIddfd2(Model model, HttpServletResponse response) {

//https://memorynotfound.com/convert-bufferedimage-byte-array-java/
//https://learningprogramming.net/java/spring-mvc/barcode-in-spring-mvc-framework-and-spring-data-jpa/
//https://www.baeldung.com/java-generating-barcodes-qr-codes
		response.setContentType("image/png");
		OutputStream outputStream;
		try {
			outputStream = response.getOutputStream();
			outputStream.write(ZXingHelper.getBarCodeImage("12345678", 200, 200));
			// outputStream.write(ZXingHelper.generateEAN138BarcodeImagebyte("12345678"));

			// outputStream.write(ZXingHelper.generateEAN13BarcodeImage1("123456789012").toString().getBytes());
			outputStream.write("sdfsdf".getBytes());
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		

		// Clientloging client= new Clientloging();
		// ReturObjectJson returJsonObject = new ReturObjectJson();
		// return t;
		// return "client_pickuprequest";
	}

	@RequestMapping(value = "/districtList", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Districts> getDistrictList(Model model, HttpServletRequest request,
			@RequestParam("provinceid") String provinceid) {

		List<Districts> dislist = clientorderservice.listOfDistrictsoFaProvinceService(provinceid);

		return dislist;
		// return "client_pickuprequest";
	}

	@PostMapping("/uploadorders123") // //new annotation since 4.3
	public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes attributes,
			HttpServletRequest request, Model model) {

		// String UPLOADED_FOLDER = "F://AE//";
		String UPLOADED_FOLDER = nexusClientConf.getNexclientuploadpath();
		if (file.isEmpty()) {
			// redirectAttributes.addFlashAttribute("message", "Please select a file to
			// upload");
			return "xclient_uploadorders";
		}
		ArrayList<String> msglist = new ArrayList<String>();
		try {

			HttpSession session = request.getSession(false);
			System.out.println("#######1111111111111111111111111111");
			ClientlogingDto client = (ClientlogingDto) session.getAttribute("loggeduser");
			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);

			File initialFile = new File(UPLOADED_FOLDER + file.getOriginalFilename());
			String filepath = UPLOADED_FOLDER + file.getOriginalFilename();
			InputStream targetStream = new FileInputStream(initialFile);

			ArrayList<Clientorder> x = nexusFileReadingService.excelToTutorials5(filepath, client.getClientid());

			System.out.println("Upload List Cout " + x.size());
			ArrayList<String> orderErrList = validateClientOrderUploadList(x);

			/*
			 * for( Clientorder clientorder: x ) {
			 * 
			 * if(validateClientOrderUpload(clientorder).size() >0) {
			 * 
			 * System.out.println("#######4444444444444"); clientorder.setErrorflag("Y");
			 * StringBuffer sb = new StringBuffer(); for(String s :
			 * validateClientOrder(clientorder)) { sb.append(s+" | ");
			 * 
			 * } clientorder.setDisplayemessage(sb.toString());
			 * model.addAttribute("errorflag", "Y"); model.addAttribute("displayemessage",
			 * sb.toString());
			 * 
			 * 
			 * }else { System.out.println("#######555555555555555555555555555555555");
			 * //clientorder = clientorderservice.createClientOrder(clientorder);
			 * if(clientorder.getErrorflag().equals("Y")) {
			 * 
			 * msglist.add(clientorder.getDisplayemessage() +"|"); } //
			 * //order.setErrorflag("Y"); }
			 * 
			 * }
			 */

			// String errFilename =
			// NexusClientUtil.createErrorFile(UPLOADED_FOLDER,client.getClientid(),
			// orderErrList.toString());
			String errFilename = NexusClientUtil.createErrorFileExcel(UPLOADED_FOLDER, client.getClientid(),
					orderErrList);

			model.addAttribute("errorflag", "Y");
			model.addAttribute("displayemessage", orderErrList.toString());
			model.addAttribute("errfilename", errFilename);
//            if(msglist.size() > 0) {
//            	
//            model.addAttribute("errorflag", "Y");
//   	    	model.addAttribute("displayemessage", msglist.toString());
//            }else {
//            	 for( Clientorder clientorder: x ) {
//                     
//            	clientorder = clientorderservice.createClientOrder(clientorder);
//            	 }
//            }

		} catch (Exception e) {
			// e.printStackTrace();
			// logger.info("::::: singleFileUpload ::::::: error11");
			// logger.error(e.getMessage());
			e.printStackTrace();
			// logger.info("::::: singleFileUpload ::::::: error22");
		}

		return "xclient_uploadorders";
	}

//	//@RequestMapping(value="/TrackingId3", method = RequestMethod.GET,  produces = MediaType.IMAGE_PNG_VALUE)
//	 @GetMapping(value = "/TrackingId3", produces = MediaType.IMAGE_PNG_VALUE)
//	public BufferedImage loadTrackingIddfd3(Model model, HttpServletResponse response) {
//		
//		 return ZXingHelper.generateEAN13BarcodeImage("123456789012");
////		//return ZXingHelper.generateEAN13BarcodeImage("123456789012");
////		response.setContentType("image/png");
////		OutputStream outputStream;
////		try {
////			
////		} catch (Exception e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		
//		
//		//Clientloging client= new Clientloging();
//		//ReturObjectJson returJsonObject = new ReturObjectJson();
//	   // return t;
//		//return "client_pickuprequest";
//	}
//
//
//	
//	
	@RequestMapping(value = "/TrackingId3", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
//	 @GetMapping(value = "/TrackingId3", produces = MediaType.IMAGE_PNG_VALUE)
	public BufferedImage loadTrackingIddfd3(Model model, HttpServletResponse response) {
//		
		return ZXingHelper.generateEAN13BarcodeImage("123456789012");
	}

	@RequestMapping(value = "/Trackin3", method = RequestMethod.GET)
	public void loadTrackingIddfd24(Model model, HttpServletResponse response) {
		System.out.println("===23=====" + new Date().toString());
		response.setContentType("image/png");
		OutputStream outputStream;
		try {

			outputStream = response.getOutputStream();
			// outputStream.write(ZXingHelper.getBarCodeImage("18345678", 200, 200));

			// outputStream.write(ZXingHelper.generateCustomBarcode("44445555"));
			// outputStream.write(ZXingHelper.generateEAN138BarcodeImagebyte("9224446"));

			// outputStream.write(ZXingHelper.generateEAN13BarcodeImage1("123456789012").toString().getBytes());
			// outputStream.write("sdfsdf".getBytes());
			outputStream.flush();
			outputStream.close();

			System.out.println("========" + new Date().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@GetMapping("/loaduploadpage")
	public String loadUploadOrderpage(Model model, HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		ClientlogingDto client = (ClientlogingDto) session.getAttribute("loggeduser");

		;
		model.addAttribute("provincelist", clientorderservice.getProvincelist());
		model.addAttribute("maincategorylist", clientorderservice.getMainCatgoryList());

		model.addAttribute("loggeduser", client);
		model.addAttribute("clientorder", new Clientorder());

		// return "client_addorder";
		// return "xclient_addorder";
		return "xclient_uploadorders";
	}

	// @RequestMapping("/file/{fileName:.+}")
	@RequestMapping(value = "/file123", method = RequestMethod.POST)
	public void downloadPDFResource(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("fileName") String fileName) throws IOException {
		String UPLOADED_FOLDER = nexusClientConf.getNexclientuploadpath();
		File file = new File(UPLOADED_FOLDER + fileName);
		if (file.exists()) {

			// get the mimetype
			String mimeType = URLConnection.guessContentTypeFromName(file.getName());
			if (mimeType == null) {
				// unknown mimetype so set the mimetype to application/octet-stream
				mimeType = "application/octet-stream";
			}

			response.setContentType(mimeType);

			/**
			 * In a regular HTTP response, the Content-Disposition response header is a
			 * header indicating if the content is expected to be displayed inline in the
			 * browser, that is, as a Web page or as part of a Web page, or as an
			 * attachment, that is downloaded and saved locally.
			 * 
			 */

			/**
			 * Here we have mentioned it to show inline
			 */
			response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));

			// Here we have mentioned it to show as attachment
			// response.setHeader("Content-Disposition", String.format("attachment;
			// filename=\"" + file.getName() + "\""));

			response.setContentLength((int) file.length());

			InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

			FileCopyUtils.copy(inputStream, response.getOutputStream());

		}
	}

	@GetMapping("/usersexportpdf")
	public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		pdfService.export(response);
		// pdfService2.aaaaaa();

	}

	@GetMapping("/usersexportpdf123")
	public void exportToPDF1(HttpServletResponse response) throws DocumentException, IOException {

		
		try {
			JasperReport report = JasperCompileManager
					.compileReport(new FileInputStream("src/main/resources/test3.jrxml"));
			// JasperReport report = JasperCompileManager.compileReport(new
			// FileInputStream("src/main/resources/test1.jasper"));

			JRBeanCollectionDataSource abc = new JRBeanCollectionDataSource(null);

//			HashMap<String, Object> map1 = new HashMap<String, Object>();
//			HashMap<String, Object> map2 = new HashMap<String, Object>();
//			map1.put("abc", "shashiasanka");
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("username", "Employee Report");
			// JasperPrint print = JasperFillManager.fillReport(report, parameters, new
			// JREmptyDataSource());
			JasperPrint print = JasperFillManager.fillReport(report, parameters, abc);
			 //JasperViewer.viewReport(print);
			JasperExportManager.exportReportToPdfFile(print, "ssss1123.pdf");
			
			
			System.out.println("------------------------------------------------");
		} catch (Exception e) {
			System.out.println("----eeeeeee-------------------------------------------");
			e.printStackTrace();
		}
	

		/*
		try {
			 File reportFile = new File("src/main/resources/uuuu1.jasper");
			 HashMap<String, Object> map = new HashMap<String, Object>(); 
			 JasperPrint print = JasperFillManager.fillReport(reportFile.getPath(), map, new JREmptyDataSource());
			 //JasperExportManager.exportReportToPdfFile(print, "ssss.pdf");
	         JasperViewer.viewReport(print);
		} catch (Exception e) {
			System.out.println("----eeeeeee-------------------------------------------");
			e.printStackTrace();
		}

		*/
	}

	@GetMapping("/usersexportpdf3")
	public String exportToPDF3(Model model, HttpSession session) {

		model.addAttribute("logingData", new Clientloging());
		return "pdftest1";

	}

	@GetMapping("/exportToPDF4")
	public void exportToPDF4(Model model, HttpServletRequest request, HttpServletResponse response) {

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		pdfService2.bbbbbbbb(response);

//pdfService2.aaaaaa();
		// return "client_pickuprequest";
		// return "";
	}

	@GetMapping("/pdfexport5")
	public void exportToPDF5555(Model model, HttpServletRequest request, HttpServletResponse response) {

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		pdfService2.bbbbbbbb(response);

	}

	@GetMapping("/pdfexport6/{trackingid}")
	public void exportToPDF6666(@PathVariable("trackingid") String trackingid, Model model, HttpServletRequest request,
			HttpServletResponse response) {

		System.out.println("pdfexport6 :" + trackingid);
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		pdfService2.ddddddd(response);

	}

	@GetMapping("/jasper1/{trackingid}")
	public void jasper1(@PathVariable("trackingid") String trackingid, Model model, HttpServletRequest request,
			HttpServletResponse response) {

		System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
//		String sourceFileName = "src/main/resources/abc1.jasper";
//		 Map parameters = new HashMap();
//		 
//		 
//		 try {		
//					 JasperFillManager.fillReportToFile(sourceFileName, parameters, new JREmptyDataSource());
//					 
//					
//	      } catch (JRException e) {
//	         e.printStackTrace();
//	      }

		try {
			JasperReport report = JasperCompileManager
					.compileReport(new FileInputStream("src/main/resources/abc1.jrxml"));
			// JasperReport report = JasperCompileManager.compileReport(new
			// FileInputStream("src/main/resources/test1.jasper"));

			JRBeanCollectionDataSource abc = new JRBeanCollectionDataSource(null);

			Map<String, Object> parameters = new HashMap<>();
			parameters.put("xyz", "Employee Report");
			// JasperPrint print = JasperFillManager.fillReport(report, parameters, new
			// JREmptyDataSource());
			JasperPrint print = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());

			JasperExportManager.exportReportToPdfFile(print, "sss28.pdf");
			System.out.println("------------------------------------------------");
		} catch (Exception e) {
			System.out.println("----eeeeeee-------------------------------------------");
			e.printStackTrace();
		}

//		try {
//		 File reportFile = new File("src/main/resources/abc1.jasper");
//		 HashMap<String, Object> map = new HashMap<String, Object>(); 
//		 map.put("xyz", "shashi");
//		 JasperPrint print = JasperFillManager.fillReport(reportFile.getPath(), map, new JREmptyDataSource(1));
//		 JasperExportManager.exportReportToPdfFile(print, "ssss123.pdf");
//           //JasperViewer.viewReport(print);
//	} catch (Exception e) {
//		System.out.println("----eeeeeee-------------------------------------------");
//		e.printStackTrace();
//	}
//		 System.out.println("++++++444444++++++++++++++++++++++++++++++++++++");
	}

	@GetMapping("/exportToPDF2")
	public void exportToPDF2(HttpServletResponse response) throws DocumentException, IOException {

		try {
			JasperReport report = JasperCompileManager
					.compileReport(new FileInputStream("src/main/resources/test4.jrxml"));
			// JasperReport report = JasperCompileManager.compileReport(new
			// FileInputStream("src/main/resources/test1.jasper"));

			// Abc a = new Abc();
			// a.setField_1("adasd");
			// JRBeanCollectionDataSource abc = new JRBeanCollectionDataSource(a);

			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("Field_1", "Employee Report");
			report.setProperty("Field_1", "Employee Report");
			// JasperPrint print = JasperFillManager.fillReport(report, parameters, new
			// JREmptyDataSource());
			// JasperPrint print = JasperFillManager.fillReport(report, parameters, null);
			JasperPrint print = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource(1));
			JasperExportManager.exportReportToPdfFile(print, "sss2022.pdf");
			System.out.println("--------------------------111-zxxxcvd---------------------");
		} catch (Exception e) {
			System.out.println("----eeeeeee-------------------------------------------");
			e.printStackTrace();
		}

//		try {
//			 File reportFile = new File("src/main/resources/test1.jasper");
//			 HashMap<String, Object> map = new HashMap<String, Object>(); 
//			 JasperPrint print = JasperFillManager.fillReport(reportFile.getPath(), map, new JREmptyDataSource());
//			 JasperExportManager.exportReportToPdfFile(print, "ssss.pdf");
//	            //JasperViewer.viewReport(print);
//		} catch (Exception e) {
//			System.out.println("----eeeeeee-------------------------------------------");
//			e.printStackTrace();
//		}

	}

	@GetMapping("/exportToPDF5555")
	public void exportToPDF5555(HttpServletResponse response) throws DocumentException, IOException {
//https://www.techgeeknext.com/spring-boot/spring-boot-jasper-report		
		try {
			String sourceFileName = "src/main/resources/uuuu1.jasper";
			JasperReport jasperReport = JasperCompileManager.compileReport("src/main/resources/uuuu1.jrxml");

			// Parameters for report
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("name", "Shashi");

			JRDataSource dataSource = new JREmptyDataSource();
			// JasperPrint jasperPrint =
			// JasperFillManager.fillReport(jasperReport,parameters, dataSource);
			// JasperExportManager.exportReportToPdfFile(jasperPrint,"F:\\chesslogin\\StyledTextReport.pdf");
			// JasperPrint print = JasperFillManager.fillReport(reportFile.getPath(), map,
			// new JREmptyDataSource());
			JasperFillManager.fillReportToFile(sourceFileName, parameters, dataSource);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@GetMapping("/exportToPDF6666")
	public void exportToPDF6666(HttpServletResponse response) {
//https://www.techgeeknext.com/spring-boot/spring-boot-jasper-report	

//		HttpHeaders headers = new HttpHeaders();
//		//set the PDF format
//		headers.setContentType(MediaType.APPLICATION_PDF);
//		headers.setContentDispositionFormData("filename", "employees-details.pdf");
		JasperPrint empReport = null;

		try {
			String sourceFileName = "src/main/resources/uuuu1.jasper";
			JasperReport jasperReport = JasperCompileManager.compileReport("src/main/resources/uuuu1.jrxml");

			// Parameters for report
			
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("from_name", "from_name");
			parameters.put("from_contactno", "from_contactno");
			parameters.put("from_issueddate", "from_issueddate");
			parameters.put("to_name", "to_name");
			parameters.put("to_address", "to_address");
			parameters.put("to_phone", "to_phone");
			parameters.put("x_name", "x_name");
			parameters.put("x_address", "x_address");
			parameters.put("x_nicno", "x_nicno");
			parameters.put("cod_amount", "cod_amount");
			parameters.put("orderno", "orderno");
			parameters.put("weight", "weight");
			
			
			
			/*
			 * from_name
			from_contactno
			from_issueddate
			to_name
			to_address
			to_phone
			x_name
			x_address
			x_nicno
			cod_amount
			orderno
			weight
			*/

			JRDataSource dataSource = new JREmptyDataSource();

			JasperReport report = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/waybill1.jrxml"));
			empReport = JasperFillManager.fillReport(report, parameters, dataSource);

			JasperExportManager.exportReportToPdfFile(empReport, "sss02022022_1.pdf");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@GetMapping("/exportToPDF777777")
	public void getRpt1(HttpServletResponse response) throws JRException, IOException {
		try {
			//new FileInputStream("src/main/resources/test4.jrxml")
			//InputStream jasperStream = this.getClass().getResourceAsStream("/src/main/resources/uuuu1.jasper");
			InputStream jasperStream = new FileInputStream("src/main/resources/uuuu1.jasper");
			Map<String, Object> params = new HashMap<>();
			params.put("name", "Shashi");
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());

			response.setContentType("application/x-pdf");
			response.setHeader("Content-disposition", "inline; filename=helloWorldReport.pdf");

			final OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	@GetMapping("/exportToPDF88888")
	public void exportToPDF88888(HttpServletResponse response) throws DocumentException, IOException {

		JasperPrint empReport = null;
		try {
			
			Map<String, Object> parameters = new HashMap<>();

			parameters.put("from_name", "from_name");
			parameters.put("from_contactno", "from_contactno");
			parameters.put("from_issueddate", "from_issueddate");
			parameters.put("to_name", "to_name");
			parameters.put("to_address", "to_address");
			parameters.put("to_phone", "to_phone");
			parameters.put("x_name", "x_name");
			parameters.put("x_address", "x_address");
			parameters.put("x_nicno", "x_nicno");
			parameters.put("cod_amount", "cod_amount");
			parameters.put("orderno", "orderno");
			parameters.put("weight", "weight");
			
			
			JRDataSource dataSource = new JREmptyDataSource();

			JasperReport report = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/waybill1.jrxml"));
			empReport = JasperFillManager.fillReport(report, parameters, dataSource);


			response.setContentType("application/x-pdf");
			response.setHeader("Content-disposition", "inline; filename=helloWorldReport07022022.pdf");

			final OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(empReport, outStream);
		
			
			System.out.println("------------------------------------------------");
		} catch (Exception e) {
			System.out.println("----eeeeeee-------------------------------------------");
			e.printStackTrace();
		}
	

		/*
		try {
			 File reportFile = new File("src/main/resources/uuuu1.jasper");
			 HashMap<String, Object> map = new HashMap<String, Object>(); 
			 JasperPrint print = JasperFillManager.fillReport(reportFile.getPath(), map, new JREmptyDataSource());
			 //JasperExportManager.exportReportToPdfFile(print, "ssss.pdf");
	         JasperViewer.viewReport(print);
		} catch (Exception e) {
			System.out.println("----eeeeeee-------------------------------------------");
			e.printStackTrace();
		}

		*/
	}

	
	
	@GetMapping("/WayBillPrint")
	public byte[]  getWayBillPrint(HttpServletResponse response,@RequestParam("ordertrackingid") String ordertrackingid)  {

		JasperPrint empReport = null;
		byte ar[] =  null;
		try {
			System.out.println("-----------------------------WayBillPrint-------------------"+ordertrackingid);
			/*
			Map<String, Object> parameters = new HashMap<>();
			Clientorder clientOrder = clientorderservice.getClientOrderByClientId(ordertrackingid);
			
			parameters.put("from_name", "dfgdfg");
			parameters.put("from_contactno", "from_contactno");
			parameters.put("from_issueddate", "from_issueddate");
			parameters.put("to_name", clientOrder.getClientname());
			parameters.put("to_address", clientOrder.getCustomeraddress() + clientOrder.getCustomeraddress2());
			parameters.put("to_phone", clientOrder.getCustomerphone() +"|"+clientOrder.getCustomerphone2());
			parameters.put("x_name", "x_name");
			parameters.put("x_address", "x_address");
			parameters.put("x_nicno", "x_nicno");
			parameters.put("cod_amount", "clientOrder.getCodamount()" );
			parameters.put("orderno", ordertrackingid);
			parameters.put("weight", "clientOrder.getWeight()");
			
			
			JRDataSource dataSource = new JREmptyDataSource();

			JasperReport report = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/waybill1.jrxml"));
			empReport = JasperFillManager.fillReport(report, parameters, dataSource);
			
			response.setContentType("application/x-pdf");
		
			response.setHeader("Content-disposition", "inline; filename=Waybill"+ ordertrackingid+".pdf");

			final OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(empReport, outStream);
			*/
			
			Map<String, Object> parameters = new HashMap<>();

			parameters.put("from_name", "from_name");
			parameters.put("from_contactno", "from_contactno");
			parameters.put("from_issueddate", "from_issueddate");
			parameters.put("to_name", "to_name");
			parameters.put("to_address", "to_address");
			parameters.put("to_phone", "to_phone");
			parameters.put("x_name", "x_name");
			parameters.put("x_address", "x_address");
			parameters.put("x_nicno", "x_nicno");
			parameters.put("cod_amount", "cod_amount");
			parameters.put("orderno", "orderno");
			parameters.put("weight", "weight");
			
			
			JRDataSource dataSource = new JREmptyDataSource();

			JasperReport report = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/waybill1.jrxml"));
			empReport = JasperFillManager.fillReport(report, parameters, dataSource);


			response.setContentType("application/x-pdf");
			response.setHeader("Content-disposition", "inline; filename=helloWorldReport07022022.pdf");

			final OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(empReport, outStream);
			//ar = JasperExportManager.exportReportToPdf(empReport);
		   
		   
			System.out.println("------------------------------------------------");
			
			return ar;
		} catch (Exception e) {
			System.out.println("----eeeeeee-------------------------------------------");
			e.printStackTrace();
		}
	

		/*
		try {
			 File reportFile = new File("src/main/resources/uuuu1.jasper");
			 HashMap<String, Object> map = new HashMap<String, Object>(); 
			 JasperPrint print = JasperFillManager.fillReport(reportFile.getPath(), map, new JREmptyDataSource());
			 //JasperExportManager.exportReportToPdfFile(print, "ssss.pdf");
	         JasperViewer.viewReport(print);
		} catch (Exception e) {
			System.out.println("----eeeeeee-------------------------------------------");
			e.printStackTrace();
		}

		*/
		
		return ar;
	}
	
		
	@RequestMapping(value = "/WayBillPrint2", method = RequestMethod.POST)
	public void getWayBillPrint2(HttpServletResponse response,@RequestParam("ordertrackingid") String ordertrackingid)  {

		JasperPrint empReport = null;
		
		String UPLOADED_FOLDER = nexusClientConf.getNexclientuploadpath();
		try {
			System.out.println("--------WayBillPrint22222-------------------"+ordertrackingid);
			Clientorder clientOrder = clientorderservice.getClientOrderByClientId(ordertrackingid);
			Map<String, Object> parameters = new HashMap<>();

			parameters.put("from_name", clientOrder.getFrom_name());
			parameters.put("from_contactno", clientOrder.getFrom_phone());
			parameters.put("from_issueddate", "");
			parameters.put("to_name", clientOrder.getCustomername());
			parameters.put("to_address", clientOrder.getCustomeraddress());
			parameters.put("to_phone", clientOrder.getCustomerphone() +" | "+clientOrder.getCustomerphone2());
			parameters.put("x_name", "");
			parameters.put("x_address", "");
			parameters.put("x_nicno", "");
			parameters.put("cod_amount", Double.toString(clientOrder.getCodamount()) );
			parameters.put("orderno", clientOrder.getOrderid());
			parameters.put("weight",  Double.toString(clientOrder.getWeight()));
			
			
			JRDataSource dataSource = new JREmptyDataSource();

			JasperReport report = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/waybill1.jrxml"));
			empReport = JasperFillManager.fillReport(report, parameters, dataSource);


			

			final OutputStream outStream = response.getOutputStream();
			//JasperExportManager.exportReportToPdfStream(empReport, outStream);
			String filepath = UPLOADED_FOLDER + ordertrackingid +".pdf";
			JasperExportManager.exportReportToPdfFile(empReport, filepath);

			File file = new File(filepath);
			if (file.exists()) {

				// get the mimetype
				String mimeType = URLConnection.guessContentTypeFromName(file.getName());
				if (mimeType == null) {
					// unknown mimetype so set the mimetype to application/octet-stream
					mimeType = "application/octet-stream";
				}
				System.out.println("******************* FILE downloadfile*****************************************************" + filepath);
				response.setContentType(mimeType);

				/**
				 * In a regular HTTP response, the Content-Disposition response header is a
				 * header indicating if the content is expected to be displayed inline in the
				 * browser, that is, as a Web page or as part of a Web page, or as an
				 * attachment, that is downloaded and saved locally.
				 * 
				 */

				/**
				 * Here we have mentioned it to show inline
				 */
				response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));

				// Here we have mentioned it to show as attachment
				// response.setHeader("Content-Disposition", String.format("attachment;
				// filename=\"" + file.getName() + "\""));

				response.setContentLength((int) file.length());

				InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

				FileCopyUtils.copy(inputStream, response.getOutputStream());

			}
			
			
			System.out.println("------------------------------------------------");
			
			
		} catch (Exception e) {
			System.out.println("----eeeeeee-------------------------------------------");
			e.printStackTrace();
		}
	

		/*
		try {
			 File reportFile = new File("src/main/resources/uuuu1.jasper");
			 HashMap<String, Object> map = new HashMap<String, Object>(); 
			 JasperPrint print = JasperFillManager.fillReport(reportFile.getPath(), map, new JREmptyDataSource());
			 //JasperExportManager.exportReportToPdfFile(print, "ssss.pdf");
	         JasperViewer.viewReport(print);
		} catch (Exception e) {
			System.out.println("----eeeeeee-------------------------------------------");
			e.printStackTrace();
		}

		*/
		
		
	}
	
	
	@PostMapping(value = "/Readytosend")
	public String readyToSendHO( @RequestParam("trackingid") String trackingid,Model model,HttpServletRequest request) throws IOException {
		
		System.out.println("$$$$$$$$$$$$readyToSendHO"+trackingid);
		
		HttpSession session = request.getSession(false);
		ClientlogingDto client = (ClientlogingDto) session.getAttribute("loggeduser");
		clientorderservice.readyTosendHO( client.getClientid(), trackingid);
		
		model.addAttribute("orderlist", searchservice.getClientOrderList(client.getClientid()));
		// return "client_search";
		return "xclient_search";
		//String clientid, String ordertrackingid
		
	}
	
	
	@PostMapping(value = "/removetosendHO")
	public String removeToSendHO( @RequestParam("trackingid") String trackingid,Model model,HttpServletRequest request) throws IOException {
		
		System.out.println("$$$$$$$$$$$$removeToSendHO"+trackingid);
		
		HttpSession session = request.getSession(false);
		ClientlogingDto client = (ClientlogingDto) session.getAttribute("loggeduser");
		clientorderservice.removeTosend( client.getClientid(), trackingid);
		
		model.addAttribute("orderlist", searchservice.getClientOrderList(client.getClientid()));
		// return "client_search";
		return "xclient_search";
		//String clientid, String ordertrackingid
		
	}
	
	
	
	@PostMapping("/updateorder")
	// @RequestMapping(value="/Addorder", method=RequestMethod.POST,
	// params="action=AddOrder")
	public String updateOrder(@ModelAttribute Clientorder clientorder, Model model, HttpServletRequest request) {
		// model.addAttribute("clientorder", clientorder);
		HttpSession session = request.getSession(false);
		System.out.println("#######1111111111111111111111111111");
		ClientlogingDto client = (ClientlogingDto) session.getAttribute("loggeduser");
		model.addAttribute("loggeduser", client);
		System.out.println("#######22222222222222222222");
		// picupreq.setClientid(client.getClientid());
		// picupreq.setClientname(client.getClientbusinessname());
		clientorder.setClientid(client.getClientid());
		//clientorder.setClientname(client.getClientbusinessname());
		// pickupService.sendPickupRequest(picupreq);
		model.addAttribute("dashboard", clientorderservice.getOrderDetailstoDashboardService(client.getClientid()));
		System.out.println("#######333333333333333333333");

		// if(!validateClientOrder(clientorder)) {
		if (validateClientOrder(clientorder).size() > 0) {

			System.out.println("#######4444444444444");
			clientorder.setErrorflag("Y");
			StringBuffer sb = new StringBuffer();
			for (String s : validateClientOrder(clientorder)) {
				sb.append(s + " | ");

			}
			clientorder.setDisplayemessage(sb.toString());
			model.addAttribute("maincategorylist", clientorderservice.getMainCatgoryList());
			model.addAttribute("clientorder", clientorder);
		} else {
			System.out.println("#######555555555555555555555555555555555");
			//clientorder = clientorderservice.updateClientOrder(clientorder);
			String pickupBr = clientorderservice.getClientPickupBranch(client.getClientid());
			List<Ratecode> ratelist =	registerService.getRatecodeList(pickupBr, "d");
			clientorder = clientorderservice.updateClientOrder(clientorder,pickupBr,ratelist);
			
			model.addAttribute("maincategorylist", clientorderservice.getMainCatgoryList());
			model.addAttribute("clientorder", clientorder);
		}
		// validateClientOrder

		// return "client_addorder";
		return "xclient_addorder";
	}
	
	
	private ArrayList<String> validateClientOrder(Clientorder clientOrder) {

		boolean res = true;
		ArrayList<String> orderErrList = new ArrayList<String>();
		try {
			System.out.println("#######validateClientOrderString:" + clientOrder.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		
		if (clientOrder.getCustomerphone().isEmpty()) {
			orderErrList.add(" Customerphone Cannot empty ");
			
			res = false;
		}

		if (clientOrder.getCustomerphone().length() != 10) {
			orderErrList.add(" Customerphone should be 10 digit ");
			
			res = false;
		}

//		if (clientOrder.getCustomername().isEmpty()) {
//			orderErrList.add(" Customername Cannot empty ");
//			System.out.println("#######validateClientOrder empty" + clientOrder.getContactno());
//			res = false;
//		}

		if (clientOrder.getCustomername().isEmpty()) {
			orderErrList.add(" Customername Cannot empty ");
			
			res = false;
		}

		if (clientOrder.getOrderid().isEmpty()) {
			orderErrList.add(" Orderid Cannot empty ");
			
			res = false;
		}

		if (clientOrder.getOrdertrackingid().length() != 8) {
			orderErrList.add(" Tracking Id should be 8 digit ");
			// System.out.println("#######validateClientOrder
			// empty"+clientOrder.getOrdertrackingid());
			res = false;
		}
		return orderErrList;
	}

	private ArrayList<String> validateClientOrderUpload(Clientorder clientOrder) {

		boolean res = true;
		ArrayList<String> orderErrList = new ArrayList<String>();
		String trackingid = "TRacking ID : " + clientOrder.getOrdertrackingid() + " ";
		try {
			System.out.println("#######validateClientOrderString:" + clientOrder.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		if (clientOrder.getOrdertrackingid().length() != 8) {
			orderErrList.add(" Tracking Id should be 8 digit ");

			res = false;
		}

		
		if (clientOrder.getCustomerphone().isEmpty()) {
			orderErrList.add(trackingid + " Customerphone Cannot empty ");

			res = false;
		}

		if (clientOrder.getCustomerphone().length() != 10) {
			orderErrList.add(trackingid + " Customerphone should be 10 digit ");
			
			res = false;
		}

		if (clientOrder.getCustomerphone2().length() != 10) {
			orderErrList.add(trackingid + " Customerphone should be 10 digit ");
			res = false;
		}

		if (clientOrder.getCustomername().isEmpty()) {
			orderErrList.add(trackingid + " Customername Cannot empty ");
			res = false;
		}

		if (clientOrder.getCustomeraddress().isEmpty()) {
			orderErrList.add(trackingid + " Customer Address Cannot empty ");
			res = false;
		}

		if (clientOrder.getOrderid().isEmpty()) {
			orderErrList.add(trackingid + " Orderid Cannot empty ");
			res = false;
		}

		if (clientOrder.getPaymenttype().isEmpty()) {
			orderErrList.add(trackingid + " Payment type Cannot empty ");
			res = false;
		}

		if (clientOrder.getPaymenttype().equals("C")) {

			if (clientOrder.getCodamount() > 0) {

			} else {
				orderErrList.add(trackingid + " Payment type Cannot empty ");
				res = false;
			}
		}

		return orderErrList;
	}

	private ArrayList<String> validateClientOrderUploadList(ArrayList<Clientorder> clientOrderList) {

		boolean res = false;
		// Clientorder clientOrder
		ArrayList<String> orderErrList = new ArrayList<String>();
		int i = 1;
		for (Clientorder clientOrder : clientOrderList) {

			// String trackingid ="Row No "+ i+ " Tracking ID :
			// "+clientOrder.getOrdertrackingid() +" ";
			StringBuffer sb = new StringBuffer();
			sb.append("Row No " + i + " Tracking ID : " + clientOrder.getOrdertrackingid() + " ");

			if (clientOrder.getOrdertrackingid().length() != 8) {
				sb.append(" Tracking Id should be 8 digit ");

				res = true;
			}

			
			if (NexusClientUtil.isNullOrEmpty(clientOrder.getCustomerphone())) {
				sb.append(" Customerphone Cannot empty ");

				res = true;
			}

			if (clientOrder.getCustomerphone().length() != 10) {
				orderErrList.add(" Customerphone should be 10 digit ");
				
				res = true;
			}

			if (clientOrder.getCustomerphone2().length() != 10) {
				sb.append(" Customerphone should be 10 digit ");
				res = true;
			}

			System.out.println("getCustomeraddress():" + clientOrder.getCustomeraddress());
			if (clientOrder.getCustomername().isEmpty()) {
				sb.append(" Customername Cannot empty ");
				res = true;
			}

//		if( clientOrder.getCustomeraddress().isEmpty()) {
//			sb.append( " Customer Address Cannot empty ");
//			res =true;
//		}

			if (NexusClientUtil.isNullOrEmpty(clientOrder.getCustomeraddress())) {

				sb.append(" Customer Address Cannot empty ");
				res = true;
			}

			if (clientOrder.getOrderid().isEmpty()) {
				sb.append(" Orderid Cannot empty ");
				res = true;
			}

			if (clientOrder.getPaymenttype().isEmpty()) {
				sb.append(" Payment type Cannot empty ");
				res = true;
			}

			if (clientOrder.getPaymenttype().equals("C")) {

				if (clientOrder.getCodamount() > 0) {

				} else {
					sb.append(" Payment type Cannot empty ");
					res = true;
				}
			}

			System.out.println(res + "validateClientOrderUploadList:" + sb.toString());
			if (res) {

				orderErrList.add(sb.toString());
			}

			i++;
		}
		return orderErrList;
	}

}
