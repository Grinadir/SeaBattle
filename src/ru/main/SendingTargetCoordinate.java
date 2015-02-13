package ru.main;

import java.io.DataOutputStream;
import java.io.IOException;

import javafx.concurrent.Task;
import ru.main.EnemyRectangle;

import java.util.Date;

public class SendingTargetCoordinate extends Task {

	String line;
	Date currentDate = new Date();

	@Override
	protected Object call() throws Exception {
		if (StartClientServer.sr.serS != null
				&& !StartClientServer.sr.serS.isClosed()) {
			System.out.println("Тук");
			// DataInputStream in = new DataInputStream(Server.inS);
			DataOutputStream out = new DataOutputStream(Server.outS);
			try {
				updateMessage("Server " + "(" + currentDate + ")"
						+ " attacked coordinates: " + "("
						+ EnemyRectangle.targetX + ";" + EnemyRectangle.targetY
						+ ");");
				out.writeUTF("Server " + "(" + currentDate + ")"
						+ " attacked coordinates: " + "("
						+ EnemyRectangle.targetX + ";" + EnemyRectangle.targetY
						+ ");");
				// Hui.commonChat.setText(Hui.commonChat.getText()
				// +"\n"+"Server: "+Hui.sendingMessage.getText());
				// Hui.sendingMessage.setText("");
				updateMessage("");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else {
			DataOutputStream out = new DataOutputStream(Client.outC);
			try {

				updateMessage("Client " + "(" + currentDate + ")"
						+ " attacked coordinates: " + "("
						+ EnemyRectangle.targetX + ";" + EnemyRectangle.targetY
						+ ");");
				out.writeUTF("Client " + "(" + currentDate + ")"
						+ " attacked coordinates: " + "("
						+ EnemyRectangle.targetX + ";" + EnemyRectangle.targetY
						+ ");");
				// Hui.commonChat.setText(Hui.commonChat.getText()
				// +"\n"+"Client: "+Hui.sendingMessage.getText());
				// Hui.sendingMessage.setText("");
				updateMessage("");
				System.out.println("Отправлено сообщение");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		return null;
	}

}
