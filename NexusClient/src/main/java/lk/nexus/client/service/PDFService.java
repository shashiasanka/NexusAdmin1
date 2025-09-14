package lk.nexus.client.service;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import com.itextpdf.kernel.pdf.PdfDocument; 
import com.itextpdf.kernel.pdf.PdfWriter; 

import com.itextpdf.layout.Document; 
import com.itextpdf.layout.element.Cell; 
import com.itextpdf.layout.element.Table; 

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;


@Service
@Transactional
public class PDFService {

	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);

		cell.setPhrase(new Phrase("User ID", font));

		table.addCell(cell);

		cell.setPhrase(new Phrase("E-mail", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Full Name", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Roles", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Enabled", font));
		table.addCell(cell);
	}

	private void writeTableData(PdfPTable table) {
		// for (User user : listUsers) {
		table.addCell("shashi1");
		table.addCell("shashi1");
		table.addCell("shashi1");
		table.addCell("shashi1");
		table.addCell("shashi1");
		// }
	}

	//public void export(HttpServletResponse response) throws DocumentException, IOException {}
	
	public void export(HttpServletResponse response) throws DocumentException, IOException {
//		Document document = new Document(PageSize.A4);
//		PdfWriter.getInstance(document, response.getOutputStream());
//
//		document.open();
//		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		font.setSize(18);
//		font.setColor(Color.BLUE);
//
//		Paragraph p = new Paragraph("List of Users", font);
//		p.setAlignment(Paragraph.ALIGN_CENTER);
//
//		document.add(p);
//
//		PdfPTable table = new PdfPTable(5);
//		table.setWidthPercentage(100f);
//		table.setWidths(new float[] { 1.5f, 3.5f, 3.0f, 3.0f, 1.5f });
//		table.setSpacingBefore(10);
//
//		writeTableHeader(table);
//		writeTableData(table);
//		writeTableData(table);
//		writeTableData(table);
//
//		for (int i = 0; i < 200; i++) {
//
//			writeTableData(table);
//		}
//
//		document.add(table);
//
//		document.close();

	}

	/*
	public void export2(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		// PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);

		Paragraph p = new Paragraph("List of Users", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

//        PdfPTable table = new PdfPTable(5);
//        table.setWidthPercentage(100f);
//        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
//        table.setSpacingBefore(10);
		// https://coderedirect.com/questions/180764/adding-table-to-existing-pdf-on-the-same-page-itext
		Rectangle rect = new Rectangle(36, 36, 559, 806);
		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 1.5f, 3.5f, 3.0f, 3.0f, 1.5f });
		table.setSpacingBefore(10);

		// writeTableHeader(table);
		writeTableData(table);

		document.add(table);

		document.close();

	}
	
	*/
	
	/*
	public void export3(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		//PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		
		float llx = 36;
        float lly = 700;
        float urx = 200;
        float ury = 806;
        PdfContentByte canvas = writer.getDirectContent();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);

		Paragraph p = new Paragraph("List of Users", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 1.5f, 3.5f, 3.0f, 3.0f, 1.5f });
		table.setSpacingBefore(10);

		writeTableHeader(table);
		writeTableData(table);
		
		
		document.add(table);

		document.close();

	}
	*/
	
	public void export4(HttpServletResponse response) throws DocumentException, IOException {
		/*
		Document document = new Document();
		
		PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());

		 // Creating a PdfDocument object       
	      PdfDocument pdfDoc = new PdfDocument(writer);                      
	   
	      // Creating a Document object       
	      Document doc = new Document(pdfDoc);                            
	   
	      // Creating a table       
	      float [] pointColumnWidths1 = {150f, 150f};       
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
	      float [] pointColumnWidths2 = {150f, 150f};       
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
	      */

	}
}
