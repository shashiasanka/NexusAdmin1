package lk.nexus.client.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import org.krysalis.barcode4j.impl.code128.EAN128;
import org.krysalis.barcode4j.impl.code128.EAN128Bean;
import org.krysalis.barcode4j.impl.upcean.EAN13Bean;
import org.krysalis.barcode4j.impl.upcean.EAN8;
import org.krysalis.barcode4j.impl.upcean.EAN8Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

import com.aspose.barcode.EncodeTypes;
import com.aspose.barcode.generation.BarcodeGenerator;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.oned.EAN13Writer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
public class ZXingHelper {
	
	//https://blog.aspose.com/2020/04/07/generate-or-scan-barcodes-qr-codes-in-java-using-java-barcode-library/
	public static byte[] getBarCodeImage(String text, int width, int height) {
		try {
			Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<>();
			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
			Writer writer = new Code128Writer();
			
			BitMatrix bitMatrix = writer.encode(text, BarcodeFormat.CODE_128, width, height);
			
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			
			MatrixToImageWriter.writeToStream(bitMatrix, "png", byteArrayOutputStream);
			return byteArrayOutputStream.toByteArray();
		} catch (Exception e) {
			return null;
		}
	}

	
	
	public static BufferedImage generateEAN13BarcodeImage(String barcodeText) {
	    EAN13Bean barcodeGenerator = new EAN13Bean();
	    BitmapCanvasProvider canvas = 
	      new BitmapCanvasProvider(160, BufferedImage.TYPE_BYTE_BINARY, false, 0);
	    
	    barcodeGenerator.generateBarcode(canvas, barcodeText);
	    return canvas.getBufferedImage();
	}

	
	
	public static BufferedImage generateEAN13BarcodeImage1(String barcodeText) throws Exception {
	    EAN13Writer barcodeWriter = new EAN13Writer();
	    BitMatrix bitMatrix = barcodeWriter.encode(barcodeText, BarcodeFormat.EAN_13, 300, 150);

	   
	    return MatrixToImageWriter.toBufferedImage(bitMatrix);
	}
	
	
	public static byte[]  generateEAN138BarcodeImagebyte(String barcodeText) {
	    EAN13Bean barcodeGenerator = new EAN13Bean();
	  //  EAN128Bean barcode128 = new EAN128Bean();  
	  //  EAN13Bean barcode13 = new EAN13Bean();
	    EAN8Bean ean8 = new EAN8Bean();
	   
	    
	    byte[] bytes = null;
	    BitmapCanvasProvider canvas = 
	      new BitmapCanvasProvider(160, BufferedImage.TYPE_BYTE_BINARY, false, 0);
	    System.out.println("generateEAN13BarcodeImagebyte "+barcodeText);
	    
	 //  barcodeGenerator.generateBarcode(canvas, barcodeText);
	   // barcode128.generateBarcode(canvas, barcodeText);
	   ean8.generateBarcode(canvas, barcodeText);
	    try {
	    	ByteArrayOutputStream baos = new ByteArrayOutputStream();
		    ImageIO.write( canvas.getBufferedImage(), "png", baos);
		     bytes = baos.toByteArray();
	    	
	    	//byte[] bytes = toByteArrayAutoClosable(barcodeGenerator.generateBarcode(canvas, barcodeText),"png");
		} catch (Exception e1) {
			e1.printStackTrace();
			// TODO: handle exception
		}
	    
	    
	    return bytes;
	}
	
	
	private static byte[] toByteArrayAutoClosable(BufferedImage image, String type) throws IOException {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()){
            ImageIO.write(image, type, out);
            return out.toByteArray();
        }
    }
	
	
	
	public static byte[]  generateCustomBarcode(String barcodeText) {
	   //https://blog.aspose.com/2020/04/07/generate-or-scan-barcodes-qr-codes-in-java-using-java-barcode-library/
		byte[] bytes = null;
	    try {
	    
	    	//BarcodeGenerator generator = new BarcodeGenerator(EncodeTypes.CODE_128, barcodeText);
	    	BarcodeGenerator generator = new BarcodeGenerator(EncodeTypes.CODE_128, barcodeText);
	    	// set resolution
	    	generator.getParameters().setResolution(250);
	    	// generate barcode
	    	//generator.save("generate-barcode.png");
	    	//BarcodeGenerator generator = new BarcodeGenerator(EncodeTypes.CODE_128, barcodeText);
	    	generator.getParameters().getCaptionAbove().setText("Nexus Deliver(Pvt)Ltd");
	    	generator.getParameters().getCaptionAbove().setVisible(true);
	    	//generator.getParameters().se
	    	generator.getParameters().getCaptionBelow().setText("");
	    	generator.getParameters().getCaptionBelow().setVisible(true);
	    	
	    	ByteArrayOutputStream baos = new ByteArrayOutputStream();
		    ImageIO.write(generator.generateBarCodeImage(), "png", baos);
		     bytes = baos.toByteArray();
		     
		     
		     generator.save("F:\\barcode\\generate-barcode.png");
		  

		} catch (Exception e1) {
			e1.printStackTrace();
			// TODO: handle exception
		}
	    
	    
	    return bytes;
	}
	
}
