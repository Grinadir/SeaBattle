package ru.main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.text.AbstractDocument.Content;


import ru.main.MyRectangle;

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
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Hui extends Application {

	public static MyRectangle[] rectMY = new MyRectangle[100];
	public static EnemyRectangle[] rectENEMY = new EnemyRectangle[100];

	static boolean forCircle = false;
	int i = 0;
	int e = 0;
	int a = 0;
	static public String line = "НАЧАЛО";
	static TextArea commonChat = new TextArea();
	static TextArea sendingMessage = new TextArea();
	static Button bStart = new Button("Start");
	static Button sendMessage = new Button("Send");
	static Button fireButton=new Button("Огонь");

	static ToggleGroup group = new ToggleGroup();
	static RadioButton ranking = new RadioButton("Ranking");
	static RadioButton no = new RadioButton("NO");

	static ToggleGroup ships = new ToggleGroup();
	static RadioButton four = new RadioButton("Four 1 pcs.");
	static RadioButton three = new RadioButton("Three 2 pcs.");
	static RadioButton two = new RadioButton("Two 3 pcs.");
	static RadioButton one = new RadioButton("One 4 pcs.");
	static int count2 = 0;
	static int count3 = 0;
	static int count4 = 0;
	public static int saveX;
	public static int saveY;

	public static int saveX1;
	public static int saveY1;

	public static int saveX2;
	public static int saveY2;

	public static int saveX3;
	public static int saveY3;

	public static int saveX4;
	public static int saveY4;

	

	static int oneAmount = 4;
	static int twoAmount = 3;
	static int threeAmount = 2;
	static int fourAmount = 1;





	@Override
	public void start(Stage primaryStage) throws IOException,
			InterruptedException {

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
		
		
		fireButton.setOnMouseClicked(new EventHandler<Event>() {
			
			@Override
			public void handle(Event event){
				final SendingTargetCoordinate sendMess = new SendingTargetCoordinate();

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
		ranking.setToggleGroup(group);
		no.setToggleGroup(group);
		ranking.setSelected(true);

		four.setToggleGroup(ships);
		three.setToggleGroup(ships);
		two.setToggleGroup(ships);
		one.setToggleGroup(ships);
		one.setSelected(true);

		// mainPane.add(myPane, 0, 0);
		GridPane myPane = new GridPane();

		// myPane.setBackground(new Background();
		myPane.setAlignment(Pos.CENTER_LEFT);
		// chatPain.setAlignment(Pos.BOTTOM_LEFT);

		myPane.setHgap(10);
		myPane.setVgap(10);
		myPane.setPadding(new Insets(25, 25, 25, 25));

		GridPane mySeaField = new GridPane();
		mySeaField.setAlignment(Pos.CENTER_LEFT);
		mySeaField.setHgap(10);
		mySeaField.setVgap(10);

		mySeaField.setPadding(new Insets(10, 10, 10, 10));

		GridPane enemySeaField = new GridPane();
		enemySeaField.setAlignment(Pos.CENTER_RIGHT);
		enemySeaField.setVgap(10);
		enemySeaField.setHgap(10);
		enemySeaField.setPadding(new Insets(10, 10, 10, 10));

		GridPane shipType = new GridPane();

		shipType.setAlignment(Pos.CENTER_LEFT);
		shipType.setPadding(new Insets(0, 0, 0, 0));
		shipType.setHgap(50);
		shipType.add(four, 0, 0, 1, 1);
		shipType.add(three, 1, 0, 1, 1);
		shipType.add(two, 2, 0, 1, 1);
		shipType.add(one, 3, 0, 1, 1);

		ranking.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				if (ranking.isSelected()) {
					four.setDisable(false);
					three.setDisable(false);
					two.setDisable(false);
					one.setDisable(false);
					System.out.println("dd");
				} else if (!ranking.isSelected()) {
					four.setDisable(true);
					three.setDisable(true);
					two.setDisable(true);
					one.setDisable(true);
				}

			}
		});

		/*
		 * no.setOnMouseClicked(new EventHandler<Event>() {
		 * 
		 * @Override public void handle(Event event) { if (no.isSelected()) {
		 * four.setDisable(true); three.setDisable(true); two.setDisable(true);
		 * one.setDisable(true);
		 * 
		 * } else if (!ranking.isSelected()) { four.setDisable(false);
		 * three.setDisable(false); two.setDisable(false);
		 * one.setDisable(false); System.out.println("dd"); }
		 * 
		 * } });
		 */
		one.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				one.setSelected(true);

			}

		});

		two.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				two.setSelected(true);

			}

		});

		three.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				three.setSelected(true);

			}

		});

		four.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				four.setSelected(true);

			}

		});

		for (i = 0; i <= 99; ++i) {
			rectMY[i] = new MyRectangle(10, 10, i);
			rectMY[i].setFill(javafx.scene.paint.Color.GREEN);
			// rectMY[i].getFill();

			int numLine = (int) (10 - (10 - i * 0.1));
			System.out.println("i=" + i + " numLine=" + numLine);
			// int numCol=(int)(i-numLine);

			rectMY[i].x = (i - numLine * 10);
			rectMY[i].y = numLine;

			mySeaField.add(rectMY[i], (i - numLine * 10), numLine);

		}

		for (e = 0; e <= 99; ++e) {
			rectENEMY[e] = new EnemyRectangle(10, 10, e);
			rectENEMY[e].setFill(javafx.scene.paint.Color.GREEN);
			
			int numLine = (int) (10 - (10 - e * 0.1));
			rectENEMY[e].x = (e - numLine * 10);
			rectENEMY[e].y = numLine;
			// rectMY[i].getFill();

			System.out.println("e=" + e + " numLine=" + numLine);
			// int numCol=(int)(i-numLine);

			enemySeaField.add(rectENEMY[e], (e - numLine * 10), numLine);

		}

		myPane.add(mySeaField, 0, 0, 1, 1);
		myPane.add(enemySeaField, 1, 0, 1, 1);
		myPane.add(ranking, 0, 1, 1, 1);
		myPane.add(no, 1, 1, 1, 1);
		myPane.add(shipType, 0, 2, 2, 1);
		myPane.add(fireButton, 0, 3, 1, 1);
		myPane.add(commonChat, 0, 11, 2, 1);
		myPane.add(sendingMessage, 0, 12, 2, 1);
		myPane.add(sendMessage, 0, 13, 1, 1);
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
