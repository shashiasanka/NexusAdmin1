package lk.nexus.client.util;

import java.util.Date;

import lk.nexus.client.service.NexusBarCodeService;

class Test {
	public static void main(String asa[]) {
		
		System.out.println("asdasd");
		System.out.println("====START===="+new Date().toString());
		NexusBarCodeService n = new NexusBarCodeService();
	
		
		for(int i=0; i<=100; i++) {
			int aNumber = 0;
//			//aNumber = (int)((Math.random() * 9000000)+1000000);
			aNumber = (int)((Math.random() * 90000000)+10000000);
			System.out.println((aNumber));
		//n.createImage(Integer.toString(aNumber) , Integer.toString(aNumber));
			System.out.println("======");
//			
		}
		
		System.out.println("====END===="+new Date().toString());
		
	}
	

}
