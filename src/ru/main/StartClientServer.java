package ru.main;

import java.io.DataInputStream;
import java.net.SocketException;

import javafx.concurrent.Task;

public class StartClientServer extends Task {

	static Server sr;
	static Client cl;
	String line;

	@Override
	protected Void call() throws Exception {

		updateMessage("Пуск клиент сервера");
		sr = new Server();
		cl = new Client();
		boolean cw = true;
		String mess;
		if (cw == true) {
			// Подключение
			do {

				sr.serverWorking();
				mess = "После первого выполнения sr.serSv=" + sr.serS + "\n";
				updateMessage(mess);
				System.out.print("После первого выполнения sr.serSv=" + sr.serS
						+ "\n");
				try {
					mess = "После первого выполнения sr.serSv.isClosed()="
							+ sr.serS.isClosed() + "\n";
					updateMessage(mess);
					System.out
							.print("После первого выполнения sr.serSv.isClosed()="
									+ sr.serS.isClosed() + "\n");
				} catch (NullPointerException e) {

				}

				if ((sr.serS != null && sr.serS.isClosed()) || sr.serS == null) {
					try {
						System.out.println("Попытка создать клиент");
						cl.clientWorking();
					} catch (SocketException e) {
						System.out.println("Попытка создать сервер еще раз");
						sr.serverWorking();

					}

				}

				System.out.print("Цикл\n");
				System.out.print("sr.serSv=" + sr.serS + "\n");
				try {
					System.out.print("sr.serS.isClosed()" + sr.serS.isClosed()
							+ "\n");
				} catch (NullPointerException e) {
					System.out.println("catch sr.serS=" + sr.serS + "\n");
				}
				System.out.print("cl.clS=" + cl.clS + "\n");

			} while (sr.serS != null && sr.serS.isClosed() && cl.clS == null);
			
			System.out.println("Что то произошло удачно");

			if (StartClientServer.sr.serS != null) {
				System.out.println("Запуск входящего потока сервера");
				DataInputStream in = new DataInputStream(Server.inS);
				while (true) {
					
					line = in.readUTF(); // ожидаем пока клиент пришлет строку
											// текста.
					// g.textArea.setText(g.textArea.getText()+"\n"+ "Client: "
					// + line);
					System.out.println("Запуск входящего потока сервера");
					System.out.println(line);
					updateMessage(line);
					

				}

			} else {
				DataInputStream in = new DataInputStream(StartClientServer.cl.inC);
				System.out.println("Запуск входящего потока клиент");

				while (true) {
					
					line = in.readUTF(); // ожидаем пока клиент пришлет строку
											// текста.

					// g.textArea.setText(g.textArea.getText() +"\n"+
					// "Server: "+line);
					System.out.println("Запуск входящего потока клиента");
					System.out.println(line);
					updateMessage(line);
					
				}

			}

		}
		return null;

	}
}
