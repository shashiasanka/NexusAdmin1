package lk.nexus.client.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lk.nexus.client.conf.NexusClientConf;
import lk.nexus.client.dto.ClientlogingDto;
import lk.nexus.client.models.Clientloging;
import lk.nexus.client.models.Clientorder;
import lk.nexus.client.models.Ratecode;
import lk.nexus.client.service.ClientorderService;
import lk.nexus.client.service.NexusBarCodeService;
import lk.nexus.client.service.NexusFileReadingService;
import lk.nexus.client.service.RegisterService;
import lk.nexus.client.util.NexusClientUtil;

@Controller
public class NexusFileController {
	
	
	@Autowired
	private NexusFileReadingService nexusFileReadingService;
	
	@Autowired
	private NexusClientConf nexusClientConf;
	
	@Autowired
	private ClientorderService clientorderservice;
	
	@Autowired
	RegisterService registerService;
	
	@Autowired
	NexusBarCodeService barcodeService;
	
	@PostMapping("/uploadorders") // //new annotation since 4.3
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

			String pickupBr = clientorderservice.getClientPickupBranch(client.getClientid());
			
			System.out.println("pickupBr :::::"+ pickupBr);
			
			List<Ratecode> ratelist =	registerService.getRatecodeList(pickupBr, "d");
			System.out.println(ratelist.toString());
			ArrayList<Clientorder> x = nexusFileReadingService.excelToTutorials5(filepath, client.getClientid());

			System.out.println("Upload List Cout " + x.size());
			ArrayList<String> orderErrList = validateClientOrderUploadList(x);
			
			System.out.println("UPLOAD ERRORR LIST " + orderErrList.toString());
			if(orderErrList.size() > 0) {
				model.addAttribute("errorflag", "Y");
				model.addAttribute("displayemessage", orderErrList.toString());
			}else {
				
				for(Clientorder or : x) {
					
					//Clientorder clientorder = clientorderservice.createClientOrder(or);
					Clientorder clientorder = clientorderservice.addClientOrder(or,pickupBr,ratelist);
				}
				
				model.addAttribute("errorflag", "N");
			}
			

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
			String errFilename = NexusClientUtil.createErrorFileExcel(UPLOADED_FOLDER, client.getClientid(),orderErrList);

			
			model.addAttribute("displayemessage", "Sucesfully uploaded");
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
	

	@RequestMapping(value = "/file", method = RequestMethod.POST)
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
			System.out.println("******************* FILE *****************************************************");
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
	

	@RequestMapping(value = "/downloadfile", method = RequestMethod.POST)
	public void downloadExcel(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("fileName") String fileName) throws IOException {
		
		HttpSession session = request.getSession(false);
		System.out.println("#######1111111111111111111111111111");
		ClientlogingDto client = (ClientlogingDto) session.getAttribute("loggeduser");
		//String UPLOADED_FOLDER = nexusClientConf.getNexclient_generate_file_path();
		//String UPLOADED_FOLDER = nexusClientConf.getNexclient_generate_file_path()+client.getClientid()+"_order_upload.xlsx";
		
		String UPLOADED_FILE_FORMAT = nexusClientConf.getNexclient_generate_file();
		String destFileAndPath = nexusClientConf.getNexclient_generate_file_path()+client.getClientid()+".xlsx";
		
		try {
			 File src = new File(UPLOADED_FILE_FORMAT);
			 
			 //File dest = new File(nexusClientConf.getNexclient_generate_file_path()+client.getClientid()+".xlsx");
			 File dest = new File(destFileAndPath);
			FileUtils.copyFile(src, dest);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		
		
		ArrayList<String> numberlist  = clientorderservice.getOrderTrackingList();
		NexusClientUtil nu = new NexusClientUtil();
		barcodeService.generateBarCode(numberlist); 
		
		//fileName = nu.createUploadFileExcel2(nexusClientConf.getNexclient_generate_file_path()+client.getClientid()+".xlsx", client.getClientid(),numberlist);
		fileName = nu.createUploadFileExcel2(destFileAndPath, client.getClientid(),numberlist,nexusClientConf.getNexclient_generate_file_path());
		
		
		//File file = new File(UPLOADED_FOLDER + fileName);
		//File file = new File(UPLOADED_FOLDER );
		//File file = new File(nexusClientConf.getNexclient_generate_file_path()+client.getClientid()+".xlsx" );
		File file = new File(fileName);
		if (file.exists()) {

			// get the mimetype
			String mimeType = URLConnection.guessContentTypeFromName(file.getName());
			if (mimeType == null) {
				// unknown mimetype so set the mimetype to application/octet-stream
				mimeType = "application/octet-stream";
			}
			System.out.println("******************* FILE downloadfile*****************************************************" + UPLOADED_FILE_FORMAT + fileName);
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
	

	
	
	
	
	private ArrayList<String> validateClientOrderUploadList(ArrayList<Clientorder> clientOrderList) {

		boolean res = false;
		// Clientorder clientOrder
		ArrayList<String> orderErrList = new ArrayList<String>();
		int i = 1;
		for (Clientorder clientOrder : clientOrderList) {

			// String trackingid ="Row No "+ i+ " Tracking ID :
			// "+clientOrder.getOrdertrackingid() +" ";
			StringBuffer sb = new StringBuffer();
			//sb.append("Row No " + i + " Tracking ID : " + clientOrder.getOrdertrackingid() + " ");

			if (clientOrder.getOrdertrackingid().length() != 8) {
				sb.append("Row No " + (i +1) + " Tracking Id should be 8 digit ");

				res = true;
			}

			
			if (NexusClientUtil.isNullOrEmpty(clientOrder.getCustomerphone())) {
				sb.append("Row No " +  (i +1)  + " Customerphone Cannot empty ");

				res = true;
			}

			if (clientOrder.getCustomerphone().length() != 10) {
				orderErrList.add("Row No " + i + " Customerphone should be 10 digit ");
				
				res = true;
			}

			if (clientOrder.getCustomerphone2().length() != 10) {
				sb.append("Row No " +  (i +1)  + " Customerphone should be 10 digit ");
				res = true;
			}

			System.out.println("getCustomeraddress():" + clientOrder.getCustomeraddress());
			if (clientOrder.getCustomername().isEmpty()) {
				sb.append("Row No " +  (i +1)  + " Customername Cannot empty ");
				res = true;
			}

//		if( clientOrder.getCustomeraddress().isEmpty()) {
//			sb.append( " Customer Address Cannot empty ");
//			res =true;
//		}

			if (NexusClientUtil.isNullOrEmpty(clientOrder.getCustomeraddress())) {

				sb.append("Row No " +  (i +1)  + " Customer Address Cannot empty ");
				res = true;
			}

			if (clientOrder.getOrderid().isEmpty()) {
				sb.append("Row No " +  (i +1)  + " Orderid Cannot empty ");
				res = true;
			}

			if (clientOrder.getPaymenttype().isEmpty()) {
				sb.append("Row No " +  (i +1)  + " Payment type Cannot empty ");
				res = true;
			}

			if (clientOrder.getPaymenttype().equals("C")) {

				if (clientOrder.getCodamount() > 0) {

				} else {
					sb.append("Row No " +  (i +1)  + " Payment type Cannot empty ");
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
