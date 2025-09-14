package lk.nexus.client.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lk.nexus.client.controller.LogingController;
import lk.nexus.client.models.Clientorder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@Service
@Transactional
public class NexusFileReadingService {

	private static final Logger logger = LogManager.getLogger(NexusFileReadingService.class);
	
	public ArrayList<Clientorder> excelToTutorials5(String excelFilePath, String clientid) {

		// String excelFilePath = "workbook.xlsx";
		System.out.println("######excelToTutorials53 excelFilePath::::" + excelFilePath);
		logger.info("excelToTutorials5 :::::: " + clientid +":::: Start :::::::::");
		ArrayList<Clientorder> orderList = new ArrayList<Clientorder>();
		try {
			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet firstSheet = workbook.getSheetAt(0);

			for (int i = 1; i <= 100; i++) {

				try {
					Clientorder clientOrder = new Clientorder();
					String customerAddress = "";
					String tracking_ID = "";
					System.out.println("***ROWID ::::::::" + i);

					try {
						tracking_ID = firstSheet.getRow(i).getCell(0).getStringCellValue();
						clientOrder.setClientid(clientid);						
						clientOrder.setOrdertrackingid(tracking_ID);
						
					} catch (Exception e) {
						//e.printStackTrace();
						logger.error(e.getMessage());
					}

					try {
						String order_ID = firstSheet.getRow(i).getCell(1).getStringCellValue();
						clientOrder.setOrderid(order_ID);
					} catch (Exception e) {
						//e.printStackTrace();
						logger.error(e.getMessage());
					}

					try {
						String descrip = firstSheet.getRow(i).getCell(2).getStringCellValue();
						clientOrder.setDescription(descrip);
					} catch (Exception e) {
						//e.printStackTrace();
						logger.error(e.getMessage());
					}

					try {
						String cod = firstSheet.getRow(i).getCell(3).getStringCellValue();
						clientOrder.setCodamount(Double.parseDouble(cod));
						
						System.out.println("clientOrder.getCodamount() : "+clientOrder.getCodamount());
						
					} catch (Exception e) {
						//e.printStackTrace();
						logger.error(e.getMessage());
					}

					try {
						String cashType = firstSheet.getRow(i).getCell(4).getStringCellValue();
						if (cashType.equals("COD")) {
							clientOrder.setPaymenttype("C");
						}
						if (cashType.equals("PAID")) {
							clientOrder.setPaymenttype("P");
						}

					} catch (Exception e) {
						//e.printStackTrace();
						logger.error(e.getMessage());
					}

					try {
						String weight = firstSheet.getRow(i).getCell(5).getStringCellValue();
						clientOrder.setWeight(Double.parseDouble(weight));
					} catch (Exception e) {
						//e.printStackTrace();
						logger.error(e.getMessage());
					}

					try {
						String mainCategory = firstSheet.getRow(i).getCell(6).getStringCellValue();
						String mcatAr[] = mainCategory.split("\\-");

						clientOrder.setMaincatcode(mcatAr[0]);
					} catch (Exception e) {
						//e.printStackTrace();
						logger.error(e.getMessage());
					}

					try {
						String customerName = firstSheet.getRow(i).getCell(7).getStringCellValue();
						clientOrder.setCustomername(customerName);
					} catch (Exception e) {
						//e.printStackTrace();
						logger.error(e.getMessage());
					}

					try {
						customerAddress = firstSheet.getRow(i).getCell(8).getStringCellValue();
						clientOrder.setCustomeraddress(customerAddress);
					} catch (Exception e) {
						//e.printStackTrace();
						logger.error(e.getMessage());
					}

					try {
						String customerphone1 = firstSheet.getRow(i).getCell(9).getStringCellValue();
						clientOrder.setCustomerphone(customerphone1);
						//clientOrder.setContactno(customerphone1);
					} catch (Exception e) {
						//e.printStackTrace();
						logger.error(e.getMessage());					
					}

					try {
						String customerphone2 = firstSheet.getRow(i).getCell(10).getStringCellValue();
						clientOrder.setCustomerphone2(customerphone2);
					} catch (Exception e) {
						//e.printStackTrace();
						logger.error(e.getMessage());
					}

					try {
						String district = firstSheet.getRow(i).getCell(11).getStringCellValue();
						String diAr[] = district.split("\\-");
						clientOrder.setDistrict(Integer.parseInt(diAr[0]));
					} catch (Exception e) {
						//e.printStackTrace();
						logger.error(e.getMessage());
					}

					try {
						String nearBranch = firstSheet.getRow(i).getCell(12).getStringCellValue();				
						
						String nearBranchAr[] = nearBranch.split("\\-");
						clientOrder.setTo_branch(nearBranchAr[0].trim());

					} catch (Exception e) {
						//e.printStackTrace();
						logger.error(e.getMessage());
					}

					try {
						String remark = firstSheet.getRow(i).getCell(13).getStringCellValue();
						clientOrder.setRemarks(remark);
					} catch (Exception e) {
						//e.printStackTrace();
						logger.error(e.getMessage());
					}
					
					try {
						String from_name = firstSheet.getRow(i).getCell(14).getStringCellValue();
						clientOrder.setFrom_name(from_name);
					} catch (Exception e) {
						//e.printStackTrace();
						logger.error(e.getMessage());
					}
					
					try {
						System.out.println("SENDER PHONE::: START");
						String from_phone = firstSheet.getRow(i).getCell(15).getStringCellValue();
						clientOrder.setFrom_phone(from_phone);
						
						System.out.println("SENDER PHONE:::"+clientOrder.getFrom_phone());
						
					} catch (Exception e) {
						//e.printStackTrace();
						logger.error("SENDER PHONE ERRRR:::"+e.getMessage());
					}
					
					
					try {
						System.out.println("SENDER from_address::: START");
						String from_address = firstSheet.getRow(i).getCell(16).getStringCellValue();
						clientOrder.setFrom_address(from_address);
						
						System.out.println("SENDER PHONE:::"+clientOrder.getFrom_phone());
						
					} catch (Exception e) {
						//e.printStackTrace();
						logger.error("SENDER PHONE ERRRR:::"+e.getMessage());
					}
					System.out.println("TRACKING ID :::::::::::::"+clientOrder.getOrdertrackingid());
					
					if(!clientOrder.getOrdertrackingid().isEmpty()) {
					orderList.add(clientOrder);

					}
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}

			
			System.out.println("NEW ROW END=======================");
			logger.info("excelToTutorials5 :::::: " + clientid +":::: End :::::::::");
			workbook.close();
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderList;

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

		if (clientOrder.getCustomername().isEmpty()) {
			orderErrList.add(" Customername Cannot empty ");
			
			res = false;
		}

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
			
			res = false;
		}
		return orderErrList;
	}

}
