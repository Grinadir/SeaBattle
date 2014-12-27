package ru.main;

import java.io.DataInputStream;


import java.io.DataOutputStream;
import java.io.IOException;


import java.util.Date;

import javafx.concurrent.Task;

public class SendingMessage extends Task {

	String line;
	Date currentDate=new Date();
	
	@Override
	protected Void call() throws Exception {
		

		if (StartClientServer.sr.serS!=null) {
			// DataInputStream in = new DataInputStream(Server.inS);
			DataOutputStream out = new DataOutputStream(Server.outS);
			try {
				updateMessage("Client "+"("+currentDate+")"+":"+Hui.sendingMessage.getText());
				out.writeUTF("Client "+"("+currentDate+")"+":"+Hui.sendingMessage.getText());
				//Hui.commonChat.setText(Hui.commonChat.getText() +"\n"+"Server: "+Hui.sendingMessage.getText());
				//Hui.sendingMessage.setText("");
				updateMessage("");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else {
			DataOutputStream out = new DataOutputStream(Client.outC);
			try {
				updateMessage("Client "+"("+currentDate+")"+":"+Hui.sendingMessage.getText());
				out.writeUTF("Server "+"("+currentDate+")"+":"+Hui.sendingMessage.getText());
				//Hui.commonChat.setText(Hui.commonChat.getText() +"\n"+"Client: "+Hui.sendingMessage.getText());
				//Hui.sendingMessage.setText("");
				updateMessage("");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		
		
		return null;
	}

}
