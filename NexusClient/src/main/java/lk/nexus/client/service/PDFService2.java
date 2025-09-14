package lk.nexus.client.service;


import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;

import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;



@Service
@Transactional
public class PDFService2 {

	public void aaaaaa() {

		try {
			 //Document doc1 = new Document();
			String dest = "F:\\AE\\addingNestedTable.pdf";
			PdfWriter writer = new PdfWriter(dest);

			// Creating a PdfDocument object
			PdfDocument pdfDoc = new PdfDocument(writer);

			// Creating a Document object
			Document doc = new Document(pdfDoc);

			// Creating a table
			float[] pointColumnWidths1 = { 150f, 150f };
			Table table = new Table(pointColumnWidths1);

			// Populating row 1 and adding it to the table
			Cell cell1 = new Cell();
			cell1.add("Name");
			table.addCell(cell1);

			Cell cell2 = new Cell();
			cell2.add("Raju");
			table.addCell(cell2);

			// Populating row 2 and adding it to the table
			Cell cell3 = new Cell();
			cell3.add("Id");
			table.addCell(cell3);

			Cell cell4 = new Cell();
			cell4.add("1001");
			table.addCell(cell4);

			// Populating row 3 and adding it to the table
			Cell cell5 = new Cell();
			cell5.add("Designation");
			table.addCell(cell5);

			Cell cell6 = new Cell();
			cell6.add("Programmer");
			table.addCell(cell6);

			// Creating nested table for contact
			float[] pointColumnWidths2 = { 150f, 150f };
			Table nestedTable = new Table(pointColumnWidths2);

			// Populating row 1 and adding it to the nested table
			Cell nested1 = new Cell();
			nested1.add("Phone");
			nestedTable.addCell(nested1);

			Cell nested2 = new Cell();
			nested2.add("9848022338");
			nestedTable.addCell(nested2);

			// Populating row 2 and adding it to the nested table
			Cell nested3 = new Cell();
			nested3.add("email");
			nestedTable.addCell(nested3);

			Cell nested4 = new Cell();
			nested4.add("Raju123@gmail.com");
			nestedTable.addCell(nested4);

			// Populating row 3 and adding it to the nested table
			Cell nested5 = new Cell();
			nested5.add("Address");
			nestedTable.addCell(nested5);

			Cell nested6 = new Cell();
			nested6.add("Hyderabad");
			nestedTable.addCell(nested6);

			// Adding table to the cell
			Cell cell7 = new Cell();
			cell7.add("Contact");
			table.addCell(cell7);

			Cell cell8 = new Cell();
			cell8.add(nestedTable);
			table.addCell(cell8);

			// Adding table to the document
			doc.add(table);

			// Closing the document
			doc.close();
			
			System.out.println("Nested Table Added successfully..");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	//HttpServletResponse response

	public void bbbbbbbb(HttpServletResponse response) {

		try {
			 //Document doc1 = new Document();
			//Document document = new Docume
			//PdfWriter y = new PdfWriter(response.getOutputStream());
			//String dest = "F:\\AE\\addingNestedTable.pdf";
			PdfWriter writer = new PdfWriter(response.getOutputStream());

			// Creating a PdfDocument object
			PdfDocument pdfDoc = new PdfDocument(writer);

			// Creating a Document object
			Document doc = new Document(pdfDoc);

			// Creating a table
			float[] pointColumnWidths1 = { 150f, 150f };
			Table table = new Table(pointColumnWidths1);

			// Populating row 1 and adding it to the table
			Cell cell1 = new Cell();
			cell1.add("Name");
			table.addCell(cell1);

			Cell cell2 = new Cell();
			cell2.add("Raju");
			table.addCell(cell2);

			// Populating row 2 and adding it to the table
			Cell cell3 = new Cell();
			cell3.add("Id");
			table.addCell(cell3);

			Cell cell4 = new Cell();
			cell4.add("1001");
			table.addCell(cell4);

			// Populating row 3 and adding it to the table
			Cell cell5 = new Cell();
			cell5.add("Designation");
			table.addCell(cell5);

			Cell cell6 = new Cell();
			cell6.add("Programmer");
			table.addCell(cell6);

			// Creating nested table for contact
			float[] pointColumnWidths2 = { 150f, 150f };
			Table nestedTable = new Table(pointColumnWidths2);

			// Populating row 1 and adding it to the nested table
			Cell nested1 = new Cell();
			nested1.add("Phone");
			nestedTable.addCell(nested1);

			Cell nested2 = new Cell();
			nested2.add("9848022338");
			nestedTable.addCell(nested2);

			// Populating row 2 and adding it to the nested table
			Cell nested3 = new Cell();
			nested3.add("email");
			nestedTable.addCell(nested3);

			Cell nested4 = new Cell();
			nested4.add("Raju123@gmail.com");
			nestedTable.addCell(nested4);

			// Populating row 3 and adding it to the nested table
			Cell nested5 = new Cell();
			nested5.add("Address");
			nestedTable.addCell(nested5);

			Cell nested6 = new Cell();
			nested6.add("Hyderabad");
			nestedTable.addCell(nested6);

			// Adding table to the cell
			Cell cell7 = new Cell();
			cell7.add("Contact");
			table.addCell(cell7);

			Cell cell8 = new Cell();
			cell8.add(nestedTable);
			table.addCell(cell8);

			// Adding table to the document
			doc.add(table);

			// Closing the document
			doc.close();
			System.out.println("Nested Table Added successfully..");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	
	public void cccccccccc(HttpServletResponse response) {

		try {
			 //Document doc1 = new Document();
			//Document document = new Docume
			//PdfWriter y = new PdfWriter(response.getOutputStream());
			//String dest = "F:\\AE\\addingNestedTable.pdf";
			PdfWriter writer = new PdfWriter(response.getOutputStream());

			// Creating a PdfDocument object
			PdfDocument pdfDoc = new PdfDocument(writer);

			// Creating a Document object
			Document doc = new Document(pdfDoc);

			// Creating a table
			float[] pointColumnWidths0 = { 150f, 150f };
			Table table0 = new Table(pointColumnWidths0);
			Cell cell1_0 = new Cell();
			cell1_0.add("");
			table0.addCell(cell1_0);
			
			doc.add(table0);
			float[] pointColumnWidths1 = { 150f, 150f };
			Table table = new Table(pointColumnWidths1);

			
			// Populating row 1 and adding it to the table
			Cell cell1 = new Cell();
			cell1.add("");
			table.addCell(cell1);

			Cell cell2 = new Cell();
			cell2.add("Raju");
			table.addCell(cell2);

			// Populating row 2 and adding it to the table
			Cell cell3 = new Cell();
			cell3.add("Id");
			table.addCell(cell3);

			Cell cell4 = new Cell();
			cell4.add("1001");
			table.addCell(cell4);

			// Populating row 3 and adding it to the table
			Cell cell5 = new Cell();
			cell5.add("Designation");
			table.addCell(cell5);

			Cell cell6 = new Cell();
			cell6.add("Programmer");
			table.addCell(cell6);

//			// Creating nested table for contact
//			float[] pointColumnWidths2 = { 150f, 150f };
//			Table nestedTable = new Table(pointColumnWidths2);
//
//			// Populating row 1 and adding it to the nested table
//			Cell nested1 = new Cell();
//			nested1.add("Phone");
//			nestedTable.addCell(nested1);
//
//			Cell nested2 = new Cell();
//			nested2.add("9848022338");
//			nestedTable.addCell(nested2);
//
//			// Populating row 2 and adding it to the nested table
//			Cell nested3 = new Cell();
//			nested3.add("email");
//			nestedTable.addCell(nested3);
//
//			Cell nested4 = new Cell();
//			nested4.add("Raju123@gmail.com");
//			nestedTable.addCell(nested4);
//
//			// Populating row 3 and adding it to the nested table
//			Cell nested5 = new Cell();
//			nested5.add("Address");
//			nestedTable.addCell(nested5);
//
//			Cell nested6 = new Cell();
//			nested6.add("Hyderabad");
//			nestedTable.addCell(nested6);
//
//			// Adding table to the cell
//			Cell cell7 = new Cell();
//			cell7.add("Contact");
//			table.addCell(cell7);
//
//			Cell cell8 = new Cell();
//			cell8.add(nestedTable);
//			table.addCell(cell8);

			// Adding table to the document
			doc.add(table);

			// Closing the document
			doc.close();
			System.out.println("Nested Table Added successfully..");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public void ddddddd(HttpServletResponse response) {

		try {
		
			PdfWriter writer = new PdfWriter(response.getOutputStream());

			// Creating a PdfDocument object
			PdfDocument pdfDoc = new PdfDocument(writer);

			// Creating a Document object
			Document doc = new Document(pdfDoc);

			// Creating a table
		
			float[] pointColumnWidths0 = { 500f };
			Table table0 = new Table(pointColumnWidths0);
			
			/**
			 * 
			 */
			
			//--- A new ROW 
			float[] tableTitleWidths1 = {495f};
			Table tableTitle = new Table(tableTitleWidths1);

			Cell cell_title = new Cell();
			Paragraph titleText = new Paragraph("Nexus Delivery Way bill "); 
			titleText.setTextAlignment(TextAlignment.CENTER);
			
			
			cell_title.add(titleText);
			tableTitle.addCell(cell_title);
				
			Cell cell0_title = new Cell();
			cell0_title.add(tableTitle);
			
			//------------------------------------------------------------
			
			/**
			 * 
			 */
	
			float[] pointColumnWidths1 = { 245f,245f};
			Table table1 = new Table(tableTitleWidths1);

			//---- First Row
//			Cell tbl1_cell1 = new Cell();
//			tbl1_cell1.add("Image");
//			table1.addCell(tbl1_cell1);
			
			String imageFile = "F:\\AE\\nexus111.jpeg"; 
			ImageData data = ImageDataFactory.create(imageFile); 
			Image img = new Image(data); 
			
			Cell tbl1_cell2 = new Cell();
			tbl1_cell2.add(img.setAutoScale(true)); 
			table1.addCell(tbl1_cell2);
			
			
			Cell cell1 = new Cell();
			cell1.add(table1);
			
			//---- First Row
			//--- A new ROW 
			Table table2 = new Table(pointColumnWidths1);

			Cell tbl1_cell3 = new Cell();
			tbl1_cell3.add("Tracking No");
			table2.addCell(tbl1_cell3);
			
			
			Cell tbl1_cell4 = new Cell();
			tbl1_cell4.add(""); 
			table2.addCell(tbl1_cell4);
			
			
			Cell cell2 = new Cell();
			cell2.add(table2);
			
			
			//--------------------------------
			
			//--- A new ROW 
			Table tableFrom = new Table(pointColumnWidths1);

			Cell tbl1_fromdetails = new Cell();
			tbl1_fromdetails.add("From ");
			tableFrom.addCell(tbl1_fromdetails);
			
			
			Cell tbl1_fromdetailsVal = new Cell();
			Paragraph p1 = new Paragraph("aaaaaaaaaaaaaaaa");
			Paragraph p2 = new Paragraph("bbbbbbbbbbbbbbbbbbbbbbb");
			tbl1_fromdetailsVal.add(p1); 
			tbl1_fromdetailsVal.add(p2); 
			tableFrom.addCell(tbl1_fromdetailsVal);
			
			
			Cell cell3 = new Cell();
			cell3.add(tableFrom);
			
			//------------------------------------------------------------
			
			//--- A new ROW 
			Table tableTo = new Table(pointColumnWidths1);

			Cell cell_todetails1 = new Cell();
			cell_todetails1.add("To ");
			tableTo.addCell(cell_todetails1);
			
			
			Cell cell_todetailsVal = new Cell();
			Paragraph name = new Paragraph("aaaaaaaaaaaaaaaa");
			Paragraph address = new Paragraph("bbbbbbbbbbbbbbbbbbbbbbb");
			Paragraph contactno = new Paragraph(" bbbbbbbbbbbbbbbbbbbbbbb");
			cell_todetailsVal.add(name); 
			cell_todetailsVal.add(address); 
			cell_todetailsVal.add(contactno);
			tableTo.addCell(cell_todetailsVal);
			
			
			Cell cell4_to = new Cell();
			cell4_to.add(tableTo);
			
			//------------------------------------------------------------
			
			//--- A new ROW 
			Table tableOrderdet = new Table(pointColumnWidths1);

			Cell cell_Orderdet1 = new Cell();
			cell_Orderdet1.add("Order details ");
			tableOrderdet.addCell(cell_Orderdet1);
			
			
			Cell cell_OrderdetVal = new Cell();
			Paragraph cod = new Paragraph("COD Amount:- " );
			Paragraph orderno = new Paragraph("Order No:-");
			Paragraph weight = new Paragraph("Weight :- ");
			cell_OrderdetVal.add(cod); 
			cell_OrderdetVal.add(orderno); 
			cell_OrderdetVal.add(weight);
			tableOrderdet.addCell(cell_OrderdetVal);
			
			
			Cell cell5_Orderdet = new Cell();
			cell5_Orderdet.add(tableOrderdet);
			
			//------------------------------------------------------------
			
			
			
			//--- A new ROW 
			Table tablelast = new Table(pointColumnWidths1);

			Cell cell_last1 = new Cell();
			cell_last1.add("");
			tablelast.addCell(cell_last1);
			
			
			Cell cell_lastVal = new Cell();
			Paragraph namel = new Paragraph("Name:- ");
			Paragraph addressl = new Paragraph("Address:- ");
			Paragraph nic = new Paragraph("NIC:- ");
			Paragraph signateure = new Paragraph("NIC:- ");
			Paragraph date = new Paragraph("Date:- ");
			cell_lastVal.add(namel); 
			cell_lastVal.add(addressl); 
			cell_lastVal.add(nic); 
			cell_lastVal.add(signateure);
			cell_lastVal.add(date);
			
			tablelast.addCell(cell_lastVal);
			
			
			Cell cell6_Orderdet = new Cell();
			cell6_Orderdet.add(tablelast);
			
			//------------------------------------------------------------
			
			
			//table0.addCell(cell0_title);
			table0.addCell(cell1);
			table0.addCell(cell2);
			table0.addCell(cell3);
			table0.addCell(cell4_to);
			table0.addCell(cell5_Orderdet);
			table0.addCell(cell6_Orderdet);
			
			
			doc.add(table0);

			// Closing the document
			doc.close();
			System.out.println("Nested Table Added successfully..");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
