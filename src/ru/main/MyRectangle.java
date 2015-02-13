package ru.main;

import ru.main.Hui;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.shape.Rectangle;

class MyRectangle extends Rectangle {

	int x;
	int y;
	int veto = 0;
	int type = 0;

	// int oneAmount = 4;
	// int twoAmount = 3;

	public MyRectangle(double width, double height, int e) {
		setWidth(width);
		setHeight(height);

		this.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {

				if (Hui.no.isSelected()) {
					// System.out.println("i="+i+" numLine="+numLine);
					if (getFill() == javafx.scene.paint.Color.RED) {

						setFill(javafx.scene.paint.Color.GREEN);
					} else {
						setFill(javafx.scene.paint.Color.RED);
					}

					System.out.println("FF");
				}

				if (Hui.ranking.isSelected()
						&& Hui.one.isSelected()
						&& Hui.oneAmount == 0
						&& (getFill() != javafx.scene.paint.Color.YELLOW && getFill() != javafx.scene.paint.Color.GREEN)) {

					System.out.println("tuur");
					if (getFill() == javafx.scene.paint.Color.BLUE) {

						setFill(javafx.scene.paint.Color.GREEN);
						Hui.oneAmount++;
						Function.marketGreen(x, y);
					}

				}

				else if (Hui.ranking.isSelected() && Hui.one.isSelected()
						&& Hui.oneAmount != 0
						&& (getFill() != javafx.scene.paint.Color.YELLOW)) {

					System.out.println("!!!!!!!!!!!!!!!!!");
					switch (Hui.oneAmount) {
					case 4:
						System.out.println(Hui.oneAmount);

						System.out.println("i+1 " + Hui.rectMY[1].veto);
						System.out.println("i+10 " + Hui.rectMY[10].veto);
						System.out.println("i+11 " + Hui.rectMY[11].veto);

						type = 1;
						// o1.x = x;
						// o1.y = y;

						if (getFill() == javafx.scene.paint.Color.GREEN) {

							setFill(javafx.scene.paint.Color.BLUE);
							Function.marketYellow(x, y);

							System.out.println("if i+1 " + Hui.rectMY[1].veto);
							System.out
									.println("if i+10 " + Hui.rectMY[10].veto);
							System.out
									.println("if i+11 " + Hui.rectMY[11].veto);
							Hui.oneAmount--;
						} else {
							Function.marketGreen(x, y);
							setFill(javafx.scene.paint.Color.GREEN);
							System.out
									.println("else i+1 " + Hui.rectMY[1].veto);
							System.out.println("else i+10 "
									+ Hui.rectMY[10].veto);
							System.out.println("else i+11 "
									+ Hui.rectMY[11].veto);
							Hui.oneAmount++;
						}
						;
						break;

					case 3:
						System.out.println(Hui.oneAmount);
						// o2.x = x;
						// o2.y = y;
						type = 1;

						if (getFill() == javafx.scene.paint.Color.GREEN) {
							Function.marketYellow(x, y);
							setFill(javafx.scene.paint.Color.BLUE);

							Hui.oneAmount--;
						} else {

							System.out
									.println("else i+1 " + Hui.rectMY[1].veto);
							System.out.println("else i+10 "
									+ Hui.rectMY[10].veto);
							System.out.println("else i+11 "
									+ Hui.rectMY[11].veto);
							Function.marketGreen(x, y);

							setFill(javafx.scene.paint.Color.GREEN);
							Hui.oneAmount++;
						}
						;
						break;

					case 2:
						System.out.println(Hui.oneAmount);
						// o3.x = x;
						// o3.y = y;
						type = 1;

						if (getFill() == javafx.scene.paint.Color.GREEN) {
							Function.marketYellow(x, y);

							setFill(javafx.scene.paint.Color.BLUE);
							Hui.oneAmount--;
						} else {
							Function.marketGreen(x, y);
							setFill(javafx.scene.paint.Color.GREEN);
							Hui.oneAmount++;
						}
						;
						break;
					case 1:

						System.out.println(Hui.oneAmount);
						//Hui.o1.x = x;
						//Hui.o1.y = y;

						if (getFill() == javafx.scene.paint.Color.GREEN) {
							System.out.println("oneAmount");
							Function.marketYellow(x, y);
							setFill(javafx.scene.paint.Color.BLUE);
							Hui.oneAmount--;
						} else {
							Function.marketGreen(x, y);
							setFill(javafx.scene.paint.Color.GREEN);
							Hui.oneAmount++;
						}
						;
						break;

					}

				}

				// ///////////////////////////////////////////////////
				else if (Hui.ranking.isSelected() && Hui.two.isSelected()
						&& (getFill() != javafx.scene.paint.Color.YELLOW)
						&& Hui.twoAmount != 0) {

					if (Hui.count2 == 0) {
						Hui.saveX = x;
						Hui.saveY = y;
						setFill(javafx.scene.paint.Color.BLUE);
						++Hui.count2;
					}

					else if ((Hui.saveX == x || Hui.saveY == y)
							&& Hui.count2 != 0
							&& (Hui.saveX == x + 1 || Hui.saveY == y + 1
									|| Hui.saveX == x - 1 || Hui.saveY == y - 1)) {
						setFill(javafx.scene.paint.Color.BLUE);
						Function.marketYellow(x, y);
						if (Hui.saveX == x) {
							Function.marketYellow(x, y - 1);
							Function.marketYellow(x, y + 1);

						} else if (Hui.saveY == y) {
							Function.marketYellow(x - 1, y);
							Function.marketYellow(x + 1, y);
						}
						Hui.count2 = 0;
						Hui.twoAmount--;

					}

				}
				// ////////////////////////////////////////////////////////////

				else if (Hui.ranking.isSelected() && Hui.three.isSelected()
						&& (getFill() != javafx.scene.paint.Color.YELLOW)
						&& Hui.threeAmount != 0) {

					if (Hui.count3 == 0) {
						Hui.saveX = x;
						Hui.saveY = y;
						setFill(javafx.scene.paint.Color.BLUE);
						++Hui.count3;
					}

					else if ((Hui.saveX == x || Hui.saveY == y)
							&& Hui.count3 == 1
							&& (Hui.saveX == x + 1 || Hui.saveY == y + 1
									|| Hui.saveX == x - 1 || Hui.saveY == y - 1)
							&& Hui.threeAmount != 0) {
						setFill(javafx.scene.paint.Color.BLUE);
						Hui.saveX1 = x;
						Hui.saveY1 = y;

						++Hui.count3;

					}

					else if ((Hui.saveX == x || Hui.saveY == y) && Hui.count3 == 2
							&& Hui.threeAmount != 0) {

						if (Hui.saveX1 == x
								&& (Hui.saveY1 == y + 1 || Hui.saveY1 == y - 1)) {
							setFill(javafx.scene.paint.Color.BLUE);
							Function.marketYellow(Hui.saveX, Hui.saveY);
							Function.marketYellow(Hui.saveX1, Hui.saveY1);
							Function.marketYellow(x, y);
							Hui.count3 = 0;
							Hui.threeAmount--;

						} else if (Hui.saveY == y
								&& (Hui.saveX1 == x + 1 || Hui.saveX1 == x - 1)
								&& Hui.threeAmount != 0) {
							setFill(javafx.scene.paint.Color.BLUE);
							Function.marketYellow(Hui.saveX, Hui.saveY);
							Function.marketYellow(Hui.saveX1, Hui.saveY1);
							Function.marketYellow(x, y);
							Hui.count3 = 0;
							Hui.threeAmount--;

						}

					}

				}

				// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

				else if (Hui.ranking.isSelected() && Hui.four.isSelected()
						&& (getFill() != javafx.scene.paint.Color.YELLOW)
						&& Hui.fourAmount != 0) {

					if (Hui.count4 == 0) {
						Hui.saveX = x;
						Hui.saveY = y;
						setFill(javafx.scene.paint.Color.BLUE);
						++Hui.count4;
					}

					else if ((Hui.saveX == x || Hui.saveY == y)
							&& Hui.count4 == 1
							&& (Hui.saveX == x + 1 || Hui.saveY == y + 1
									|| Hui.saveX == x - 1 || Hui.saveY == y - 1)
							&& Hui.fourAmount != 0) {
						setFill(javafx.scene.paint.Color.BLUE);
						Hui.saveX1 = x;
						Hui.saveY1 = y;

						++Hui.count4;

					}

					else if ((Hui.saveX == x || Hui.saveY == y) && Hui.fourAmount != 0
							&& Hui.count4 == 2) {

						if (Hui.saveX1 == x
								&& (Hui.saveY1 == y + 1 || Hui.saveY1 == y - 1)) {
							setFill(javafx.scene.paint.Color.BLUE);
							Hui.saveX2 = x;
							Hui.saveY2 = y;

							++Hui.count4;

						} else if (Hui.saveY == y
								&& (Hui.saveX1 == x + 1 ||Hui.saveX1 == x - 1)
								&& Hui.fourAmount != 0) {
							setFill(javafx.scene.paint.Color.BLUE);
							Hui.saveX2 = x;
							Hui.saveY2 = y;

							++Hui.count4;

						}

					}

					else if ((Hui.saveX == x || Hui.saveY == y) && Hui.count4 == 3
							&& Hui.fourAmount != 0) {

						if (Hui.saveX2 == x
								&& (Hui.saveY2 == y + 1 || Hui.saveY2 == y - 1)) {
							setFill(javafx.scene.paint.Color.BLUE);
							Function.marketYellow(Hui.saveX, Hui.saveY);
							Function.marketYellow(Hui.saveX1, Hui.saveY1);
							Function.marketYellow(Hui.saveX2, Hui.saveY2);
							Function.marketYellow(x, y);
							Hui.count4 = 0;
							Hui.fourAmount--;

						} else if (Hui.saveY2 == y
								&& (Hui.saveX2 == x + 1 || Hui.saveX2 == x - 1)
								&& Hui.threeAmount != 0) {
							setFill(javafx.scene.paint.Color.BLUE);
							Function.marketYellow(Hui.saveX, Hui.saveY);
							Function.marketYellow(Hui.saveX1, Hui.saveY1);
							Function.marketYellow(Hui.saveX2, Hui.saveY2);
							Function.marketYellow(x, y);
							Hui.count4 = 0;
							Hui.fourAmount--;

						}

					}

				}

			}

		});

		// Слушатель на кнопку старт

	}

}