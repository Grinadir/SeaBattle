package ru.main;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Info {
	String sd;
	public static InputStream inINFOS;
	public static OutputStream outINFOS;
	
	synchronized static void infoTrans(String s){
		DataOutputStream outINFO = new DataOutputStream(outINFOS);
		
		try {
			Hui.line = s;
			outINFO.writeUTF(Hui.line);
		} catch (IOException e) {
			System.out.println("Îרטבךא גגמהא גגûמהא");
		}

		
	}


}
