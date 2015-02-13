package ru.main;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.shape.Rectangle;

public class EnemyRectangle extends Rectangle {
	int x;
	int y;
	static int targetX;
	static int targetY;


	public EnemyRectangle(double width, double height, int e) {

		setWidth(width);
		setHeight(height);

		this.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				if(getFill()==javafx.scene.paint.Color.GREEN){
					setFill(javafx.scene.paint.Color.RED);
					targetX=x;
					targetY=y;
					
				}
				else{
					setFill(javafx.scene.paint.Color.GREEN);
					targetX=999;
					targetY=999;
				}
			}

		});

	}
}
