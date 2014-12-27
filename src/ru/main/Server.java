package ru.main;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.util.concurrent.TimeUnit;

import javax.swing.SwingUtilities;

public class Server {
	InetAddress ip;
	ServerSocket serS;
	int port = 8080;
	public static InputStream inS;
	public static OutputStream outS;
	
	public Server() throws IOException {
		ip = InetAddress.getLocalHost();

	}

	public void serverWorking() throws IOException {
		try {
			serS = new ServerSocket(port);
			serS.setSoTimeout(5000);
			
			String line = "������: ������, ����������� ����� �������� 5 ��� \n"
					+ "�������� �������" + serS + "\n";
			
			//Info.infoTrans(Hui.line);
			//Hui.inputInfo(line);
			// Hui.commonChat.setText(Hui.commonChat.getText() + "\n"
			// + "������: ������, ����������� ����� �������� 5 ��� \n"
			// + "�������� �������" + serS+"\n");
			// Hui.commonChat.setText(Hui.commonChat.getText() + "\n"
			// + "���� �������...\n");
			Socket s = serS.accept();
			// Hui.commonChat.setText(Hui.commonChat.getText() + "\n"
			// + "������ ������!!!\n");
			System.out.println("������ ������!!");

			Server.inS = s.getInputStream();
			Server.outS = s.getOutputStream();
		} catch (SocketTimeoutException e) {
			serS.close();
			// Hui.commonChat.setText(Hui.commonChat.getText() + "\n"
			// +
			// "��������� ������� �� �������, ��������� ������\n"+"�������� �������"+serS+"\n");
		} catch (BindException e) {

		}

	}
}
