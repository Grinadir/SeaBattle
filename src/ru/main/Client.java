package ru.main;

import java.io.*;
import java.net.*;
import java.util.concurrent.TimeUnit;



public class Client {

	InetAddress ip;
	Socket clS;
	int port = 8080;
	static public InputStream inC;
	static public OutputStream outC;
	
	//static public OutputStream infoOutputC;

	public Client() throws IOException {
		//ip = InetAddress.getLocalHost();
		ip=InetAddress.getByName("192.168.100.6");
		//ip=InetAddress.getByAddress(192.168.100.2);

	}

	public void clientWorking() throws IOException, InterruptedException {
		System.out.println("Attetion! clientWorking");
		DataInputStream in = new DataInputStream(Server.inS);
		clS = new Socket(ip, port);
		inC=clS.getInputStream();
		outC=clS.getOutputStream();
		//Hui.commonChat.setText(Hui.commonChat.getText() + "\n"
		//		+ "������: ������\n" + "�������� �������\n" + clS);
		
		//GameWindow.textArea.setText(GameWindow.textArea.getText() + "\n"
		//		+ "������: ������\n" + "�������� �������\n" + clS);
		//inC = clS.getInputStream();
		//outC = clS.getOutputStream();
		TimeUnit.SECONDS.sleep(5);
		if (clS.isConnected() == true) {
			//GameWindow.textArea.setText(GameWindow.textArea.getText() + "\n"
			//		+ "������ �����������");
			//Hui.commonChat.setText(Hui.commonChat.getText() + "\n"
				//	+ "������ �����������");
			System.out.println("cls.isConnected: "+clS.isConnected());
		} else {

			clS.close();
			//GameWindow.textArea.setText(GameWindow.textArea.getText() + "\n"
			//		+ "������ ������\n" + "�������� clS" + clS);
			//Hui.commonChat.setText(Hui.commonChat.getText() + "\n"
				//	 + "������ ������\n" + "�������� clS" + clS);
			System.out.println("��������� ������� close, cls.isClose: "+clS.isClosed());
		}
	}

}
