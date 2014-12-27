package ru.main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.text.AbstractDocument.Content;

import com.sun.javafx.property.adapter.PropertyDescriptor.Listener;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.binding.StringBinding;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Hui extends Application {

	static boolean forCircle = false;
	int i = 0;
	int a = 0;
	static public String line = "НАЧАЛО";
	static TextArea commonChat = new TextArea();
	static TextArea sendingMessage = new TextArea();
	static Button bStart = new Button("Start");
	static Button sendMessage = new Button("Send");

	class MyRectangle extends Rectangle {

		public MyRectangle(double width, double height, int i) {
			setWidth(width);
			setHeight(height);
			this.setOnMouseClicked(new EventHandler<Event>() {

				@Override
				public void handle(Event event) {

					// System.out.println("i="+i+" numLine="+numLine);
					if (getFill() == javafx.scene.paint.Color.RED) {

						setFill(javafx.scene.paint.Color.GREEN);
					} else {
						setFill(javafx.scene.paint.Color.RED);
					}

				}
			});

			// Слушатель на кнопку старт

		}
	}

	@Override
	public void start(Stage primaryStage) throws IOException,
			InterruptedException {

		MyRectangle[] rect = new MyRectangle[100];
		bStart.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// Создание класса Task, существующий для работы с JavaFX
				final StartClientServer taskClSr = new StartClientServer();
				// Делаем слушателя на текстовое свойство
				
				

				taskClSr.messageProperty().addListener(
						new ChangeListener<String>() {

							@Override
							public void changed(
									ObservableValue<? extends String> observable,
									String oldValue, String newValue) {
								commonChat.setText(commonChat.getText() + "\n"
										+ taskClSr.getMessage());

							}
						});

				Service service = new Service<Void>() {

					@Override
					protected Task<Void> createTask() {
						// TODO Auto-generated method stub
						return taskClSr;
					}

				};
				service.start();
			}

		});

		sendMessage.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				final SendingMessage sendMess = new SendingMessage();
				
				
				sendMess.messageProperty().addListener(
						new ChangeListener<String>() {

							@Override
							public void changed(
									ObservableValue<? extends String> observable,
									String oldValue, String newValue) {
								commonChat.setText(commonChat.getText() + "\n"
										+ sendMess.getMessage());

							}
						});

				Service service = new Service<Void>() {

					@Override
					protected Task<Void> createTask() {
						// TODO Auto-generated method stub
						return sendMess;
					}

				};
				service.start();
			}
		});
		commonChat.setEditable(false);
		commonChat.selectEndOfNextWord();

		commonChat.setPrefSize(200, 500);
		commonChat.setTooltip(new Tooltip("Чат Окно"));
		commonChat.setWrapText(true);

		// DataInputStream inINFO = new DataInputStream(Server.INFOS);
		// line = inINFO.readUTF();

		try {
			commonChat.setText(commonChat.getText() + "\n" + line);
		} catch (NullPointerException e) {

		}

		GridPane chatPain = new GridPane();

		// mainPane.add(myPane, 0, 0);
		GridPane myPane = new GridPane();
		// myPane.setBackground(new Background();
		myPane.setAlignment(Pos.CENTER_LEFT);
		// chatPain.setAlignment(Pos.BOTTOM_LEFT);
		myPane.setHgap(10);
		myPane.setVgap(10);
		myPane.setPadding(new Insets(25, 25, 25, 25));

		for (i = 0; i <= 99; ++i) {
			rect[i] = new MyRectangle(10, 10, i);
			rect[i].setFill(javafx.scene.paint.Color.GREEN);
			// rect[i].getFill();

			int numLine = (int) (10 - (10 - i * 0.1));
			System.out.println("i=" + i + " numLine=" + numLine);
			// int numCol=(int)(i-numLine);

			myPane.add(rect[i], (i - numLine * 10), numLine);

		}

		myPane.add(commonChat, 0, 11, 10, 1);
		myPane.add(sendingMessage, 0, 12, 10, 1);
		myPane.add(sendMessage, 0, 13, 10, 1);
		myPane.add(bStart, 0, 14, 5, 1);
		Scene scene = new Scene(myPane, 700, 700);

		scene.getStylesheets().add(
				getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) throws Exception {

		launch(args);

	}
}
