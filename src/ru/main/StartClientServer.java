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

		updateMessage("���� ������ �������");
		sr = new Server();
		cl = new Client();
		boolean cw = true;
		String mess;
		if (cw == true) {
			// �����������
			do {

				sr.serverWorking();
				mess = "����� ������� ���������� sr.serSv=" + sr.serS + "\n";
				updateMessage(mess);
				System.out.print("����� ������� ���������� sr.serSv=" + sr.serS
						+ "\n");
				try {
					mess = "����� ������� ���������� sr.serSv.isClosed()="
							+ sr.serS.isClosed() + "\n";
					updateMessage(mess);
					System.out
							.print("����� ������� ���������� sr.serSv.isClosed()="
									+ sr.serS.isClosed() + "\n");
				} catch (NullPointerException e) {

				}

				if ((sr.serS != null && sr.serS.isClosed()) || sr.serS == null) {
					try {
						System.out.println("������� ������� ������");
						cl.clientWorking();
					} catch (SocketException e) {
						System.out.println("������� ������� ������ ��� ���");
						sr.serverWorking();

					}

				}

				System.out.print("����\n");
				System.out.print("sr.serSv=" + sr.serS + "\n");
				try {
					System.out.print("sr.serS.isClosed()" + sr.serS.isClosed()
							+ "\n");
				} catch (NullPointerException e) {
					System.out.println("catch sr.serS=" + sr.serS + "\n");
				}
				System.out.print("cl.clS=" + cl.clS + "\n");

			} while (sr.serS != null && sr.serS.isClosed() && cl.clS == null);
			
			System.out.println("��� �� ��������� ������");

			if (StartClientServer.sr.serS != null) {
				System.out.println("������ ��������� ������ �������");
				DataInputStream in = new DataInputStream(Server.inS);
				while (true) {
					
					line = in.readUTF(); // ������� ���� ������ ������� ������
											// ������.
					// g.textArea.setText(g.textArea.getText()+"\n"+ "Client: "
					// + line);
					System.out.println("������ ��������� ������ �������");
					System.out.println(line);
					updateMessage(line);
					

				}

			} else {
				DataInputStream in = new DataInputStream(StartClientServer.cl.inC);
				System.out.println("������ ��������� ������ ������");

				while (true) {
					
					line = in.readUTF(); // ������� ���� ������ ������� ������
											// ������.

					// g.textArea.setText(g.textArea.getText() +"\n"+
					// "Server: "+line);
					System.out.println("������ ��������� ������ �������");
					System.out.println(line);
					updateMessage(line);
					
				}

			}

		}
		return null;

	}
}
