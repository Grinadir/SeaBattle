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
	//	if (cw == true) {
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

				System.out.println("Прошел цикл, Итоги:");
				
				System.out.println("sr.serSv: " + sr.serS);
				
				try {
					System.out.println("sr.serS.isClosed()"
							+ sr.serS.isClosed());
				} catch (NullPointerException e) {
					System.out.println("catch sr.serS=" + sr.serS + "\n");
				}
				System.out.println("cl.clS: " + cl.clS);
				

			} while (sr.serS != null && sr.serS.isClosed() && cl.clS == null);
			//cw=false;
			
			try{
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
				
			}
			catch(NullPointerException e){
				System.out.println("Срыв входящего потока сервера");
				
			}
			
			
			try{
				System.out.println("Запуск входящего потока клиента");
				DataInputStream in = new DataInputStream(Client.inC);

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
			catch(NullPointerException e){
				System.out.println("Срыв входящего потока клиента");
				
			}

			System.out.println("_____________________");
			System.out.println("Произошло подключение");
			System.out.println("sr.s: " + sr.s);
			System.out.println("cl.clS: " + cl.clS);
			System.out.println("sr.serS.isClosed(): " + sr.serS.isClosed());
			System.out.println("cl.clS.isClosed(): " + cl.clS.isClosed());

		return null;

	}
}
