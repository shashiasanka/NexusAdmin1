package lk.nexus.client.service;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.transaction.Transactional;

import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.nexus.client.conf.NexusClientConf;

//https://www.chillyfacts.com/generate-barcodes-dynamically-using-java#google_vignette
@Service
@Transactional
public class NexusBarCodeService {

	@Autowired
	private NexusClientConf nexusClientConf;
	
	public void generateBarCode(ArrayList<String> numberlist) {
		
		for(String s : numberlist) {
			createImage(s,s);
			
		}
		
	}
	
	
	private  void createImage(String image_name,String myString)  {
		try {
		Code128Bean code128 = new Code128Bean();
		code128.setHeight(15f);
		code128.setModuleWidth(0.3);
		code128.setQuietZone(10);
		code128.doQuietZone(true);		
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ByteArrayOutputStream baosN = new ByteArrayOutputStream();
		String text = "Today is a beautiful day";
        byte[] mybytes = text.getBytes();
		baosN.write(mybytes);
		//BitmapCanvasProvider canvas = new BitmapCanvasProvider(baos, "image/x-png", 300, BufferedImage.TYPE_BYTE_BINARY, false, 0);
		BitmapCanvasProvider canvas = new BitmapCanvasProvider(baos, "image/png", 600, BufferedImage.TYPE_BYTE_BINARY, false, 0);
		//canvas.getDimensions().getHeight(100);
		//canvas.getDimensions().getWidth(300);
		//BitmapCanvasProvider canvas2 = new BitmapCanvasProvider(baosN, "image/x-png", 300, BufferedImage.TYPE_BYTE_BINARY, false, 0);
	//	canvas.deviceText("Nexus", 20, 25, 50, "", 12, "");
		code128.generateBarcode(canvas, myString);
		//canvas.deviceCenteredText("QQQQQ", 0, 10, 50, "Arial", 20);
		canvas.finish();
		
		//write to png file F://AE//
		//FileOutputStream fos = new FileOutputStream("C:\\Users\\MIRITPC\\Desktop\\jas\\New folder\\"+image_name);
		
		FileOutputStream fos = new FileOutputStream(nexusClientConf.getNexclient_generate_file_path()+image_name+".png");
		fos.write(baos.toByteArray());
		//fos.write(mybytes);
		fos.flush();
		fos.close();
		
		
		final BufferedImage image = ImageIO.read(new File(nexusClientConf.getNexclient_generate_file_path()+image_name+".png"));

		    Graphics g = image.getGraphics();
		    g.setFont(g.getFont().deriveFont(30f));
		    g.setColor(Color.BLACK);
		    g.drawString("© Nexus Dileviery ", 10, 320);
		    g.dispose();

		    ImageIO.write(image, "png", new File(nexusClientConf.getNexclient_generate_file_path()+image_name+"x.png"));
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
