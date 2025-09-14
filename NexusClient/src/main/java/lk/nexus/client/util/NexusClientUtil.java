package lk.nexus.client.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microsoft.schemas.office.visio.x2012.main.CellType;

import lk.nexus.client.conf.NexusClientConf;

import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

@Component
public class NexusClientUtil {

	@Autowired
	private NexusClientConf nexusClientConf;

	public static boolean isNullOrEmpty(String str) {
		if (str != null && !str.isEmpty())
			return false;
		return true;
	}

	public static String createErrorFile(String filepath, String clientId, String content) {

		String filename = clientId;
		try {
			File myObj = new File(filepath + filename + "_err.txt");
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (Exception e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		try {

			FileWriter myWriter = new FileWriter(filepath + filename + "_err.txt");
			if (content.contains(",")) {
				System.out.println(
						",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
				String ar[] = content.split("\\,");

				for (String s : ar) {

					System.out.println(s);
					myWriter.write(s);

				}

			} else {
				// FileWriter myWriter = new FileWriter(filepath+filename+"_err.txt");
				myWriter.write(content);
				// myWriter.close();
			}
			myWriter.close();

			System.out.println("Successfully wrote to the file.");
		} catch (Exception e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		return filename + "_err.txt";
	}

	public static String createErrorFileExcel(String filepath, String clientId, ArrayList<String> orderErrList) {

		String filename = clientId;
		try {
//		      File myObj = new File(filepath+filename+"_errex.xlsx");
//		      if (myObj.createNewFile()) {
//		        System.out.println("File created: " + myObj.getName());
//		      } else {
//		        System.out.println("File already exists.");
			Workbook workbook = new XSSFWorkbook();
			Sheet sheet = workbook.createSheet("My Sheet");

			for (int i = 0; i < orderErrList.size(); i++) {
				Row row = sheet.createRow(i);
				Cell cell = row.createCell(0);
				cell.setCellValue(orderErrList.get(i));
			}
			// cell.setCellType(CellType.STRING);
			File file = new File(filepath + filename + "_errex.xlsx");
			file.createNewFile();

			FileOutputStream outputStream = new FileOutputStream(file, false);
			workbook.write(outputStream);
//		      }
		} catch (Exception e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		return filename + "_errex.xlsx";
	}

	public String createUploadFileExcel(String filepath, String clientId, ArrayList<String> orderErrList) {

		System.out.println("createUploadFileExcel ====================" + filepath);
		String filename = clientId;
		try {

			Workbook workbook = new XSSFWorkbook();
			Sheet sheet = workbook.createSheet("SHASHISheet");

			for (int i = 1; i < orderErrList.size(); i++) {
				Row row = sheet.createRow(i);
				Cell cell = row.createCell(0);
				cell.setCellValue(orderErrList.get(i));
			}
			// cell.setCellType(CellType.STRING);
//		File file = new File(filepath+filename+"_order_upload.xlsx");
//		file.createNewFile();
			File file = new File(filepath);
//			file.createNewFile();	
			FileOutputStream outputStream = new FileOutputStream(file, false);
			workbook.write(outputStream);
//	      }
		} catch (Exception e) {
			System.out.println("An error occurred.123");
			e.printStackTrace();
		}

		// return filename+"_order_upload.xlsx";

		return filepath;
	}

	public String createUploadFileExcel2(String excelFilepath, String clientId, ArrayList<String> orderErrList, String barcodeFilePath) {

		System.out.println("createUploadFileExcel ====================" + excelFilepath);
		String filename = clientId;
		try {
			FileInputStream inputStream = new FileInputStream(new File(excelFilepath));
			// Workbook workbook = new XSSFWorkbook();
			Workbook workbook = WorkbookFactory.create(inputStream);

			// Sheet sheet = workbook.createSheet("SHASHISheet");
			Sheet sheet = workbook.getSheetAt(0);

			Sheet sheet2 = workbook.getSheetAt(2);

			for (int i = 1; i < orderErrList.size(); i++) {
				Row row = sheet.createRow(i);
				Cell cell = row.createCell(0);
				cell.setCellValue(orderErrList.get(i));


			}

			for (int i = 1; i < orderErrList.size(); i++) {
				
				//System.out.println("createUploadFileExcel2 IMAGE PATH "+ nexusClientConf.getNexclient_generate_file_path() + orderErrList.get(i) + "x.png");
				try {
					InputStream is = new FileInputStream(barcodeFilePath + orderErrList.get(i) + "x.png");
					byte[] bytes = IOUtils.toByteArray(is);
					int pictureIdx = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
					is.close();

					CreationHelper helper = workbook.getCreationHelper();

					Drawing drawing = sheet2.createDrawingPatriarch();

					// add a picture shape
					ClientAnchor anchor = helper.createClientAnchor();

					// set top-left corner of the picture,
					// subsequent call of Picture#resize() will operate relative to it
					anchor.setCol1(0);
					if(i==1) {
						anchor.setRow1((i*5));
					}else {
						anchor.setRow1((i*20));
					}
					
					Picture pict = drawing.createPicture(anchor, pictureIdx);

					// auto-size picture relative to its top-left corner
					pict.resize();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				

			}
//			is = new FileInputStream("F:\\AE\\93865039x.png");
//			bytes = IOUtils.toByteArray(is);
//			pictureIdx = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
//			is.close();
//
//			anchor = helper.createClientAnchor();
//			anchor.setCol1(3);
//			anchor.setRow1(14);
//			pict = drawing.createPicture(anchor, pictureIdx);
//
//			// auto-size picture relative to its top-left corner
//			pict.resize();
//	    	

			// cell.setCellType(CellType.STRING);
//		File file = new File(filepath+filename+"_order_upload.xlsx");
//		file.createNewFile();
			inputStream.close();
			// File file = new File(filepath);
//			file.createNewFile();	
			FileOutputStream outputStream = new FileOutputStream(new File(excelFilepath), false);
			// workbook.write(outputStream);
			workbook.write(outputStream);
			workbook.close();
			outputStream.close();
//	      }
		} catch (Exception e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		// return filename+"_order_upload.xlsx";

		return excelFilepath;
	}

}
