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
			
			String line = "Статус: сервер, установдено время ожидание 5 сек \n"
					+ "Значение сервера" + serS + "\n";
			
			//Info.infoTrans(Hui.line);
			//Hui.inputInfo(line);
			// Hui.commonChat.setText(Hui.commonChat.getText() + "\n"
			// + "Статус: сервер, установдено время ожидание 5 сек \n"
			// + "Значение сервера" + serS+"\n");
			// Hui.commonChat.setText(Hui.commonChat.getText() + "\n"
			// + "Ждем клиента...\n");
			Socket s = serS.accept();
			// Hui.commonChat.setText(Hui.commonChat.getText() + "\n"
			// + "Пришел клиент!!!\n");
			System.out.println("Пришел клиент!!");

			Server.inS = s.getInputStream();
			Server.outS = s.getOutputStream();
		} catch (SocketTimeoutException e) {
			serS.close();
			// Hui.commonChat.setText(Hui.commonChat.getText() + "\n"
			// +
			// "Дождаться клиента не удалось, закрываем сервер\n"+"Значение сервера"+serS+"\n");
		} catch (BindException e) {

		}

	}
}
