package ru.main;

import ru.main.Hui;
import ru.main.Hui.MyRectangle;

public class Function {
	
	
	public void marketYellow(int x, int y) {

		
		
		int i = y * 10 + x;
		try {

			if (x == 0 && y == 0) {
				Hui.rectMY[i + 1].setFill(javafx.scene.paint.Color.YELLOW);
				Hui.rectMY[i + 10].setFill(javafx.scene.paint.Color.YELLOW);
				Hui.rectMY[i + 11].setFill(javafx.scene.paint.Color.YELLOW);
				Hui.rectMY[i + 1].veto++;
				Hui.rectMY[i + 10].veto++;
				Hui.rectMY[i + 11].veto++;
				System.out.println("i+1 "+Hui.rectMY[i + 1].veto);
				System.out.println("i+10 "+Hui.rectMY[i + 10].veto);
				System.out.println("i+11 "+Hui.rectMY[i + 11].veto);

			}

			else if (x == 0 && y == 9) {
				Hui.rectMY[i + 1].setFill(javafx.scene.paint.Color.YELLOW);
				Hui.rectMY[i - 10].setFill(javafx.scene.paint.Color.YELLOW);
				Hui.rectMY[i - 9].setFill(javafx.scene.paint.Color.YELLOW);
				Hui.rectMY[i + 1].veto++;
				Hui.rectMY[i - 10].veto++;
				Hui.rectMY[i - 9].veto++;

			}

			else if (x == 9 && y == 9) {
				Hui.rectMY[i - 1].setFill(javafx.scene.paint.Color.YELLOW);
				Hui.rectMY[i - 10].setFill(javafx.scene.paint.Color.YELLOW);
				Hui.rectMY[i - 11].setFill(javafx.scene.paint.Color.YELLOW);

				Hui.rectMY[i - 1].veto++;
				Hui.rectMY[i - 10].veto++;
				Hui.rectMY[i - 11].veto++;

			}

			else if (x == 9 && y == 0) {
				Hui.rectMY[i - 1].setFill(javafx.scene.paint.Color.YELLOW);
				Hui.rectMY[i + 10].setFill(javafx.scene.paint.Color.YELLOW);
				Hui.rectMY[i + 9].setFill(javafx.scene.paint.Color.YELLOW);

				Hui.rectMY[i - 1].veto++;
				Hui.rectMY[i + 10].veto++;
				Hui.rectMY[i + 9].veto++;

			}

			else if (x == 0) {
				Hui.rectMY[i + 1].setFill(javafx.scene.paint.Color.YELLOW);
				Hui.rectMY[i + 10].setFill(javafx.scene.paint.Color.YELLOW);
				Hui.rectMY[i - 10].setFill(javafx.scene.paint.Color.YELLOW);
				Hui.rectMY[i - 9].setFill(javafx.scene.paint.Color.YELLOW);
				Hui.rectMY[i + 11].setFill(javafx.scene.paint.Color.YELLOW);

				Hui.rectMY[i + 1].veto++;
				Hui.rectMY[i + 10].veto++;
				Hui.rectMY[i - 10].veto++;
				Hui.rectMY[i - 9].veto++;
				Hui.rectMY[i + 11].veto++;

			}

			else if (x == 9) {
				Hui.rectMY[i - 1].setFill(javafx.scene.paint.Color.YELLOW);
				Hui.rectMY[i + 10].setFill(javafx.scene.paint.Color.YELLOW);
				Hui.rectMY[i - 10].setFill(javafx.scene.paint.Color.YELLOW);
				Hui.rectMY[i + 9].setFill(javafx.scene.paint.Color.YELLOW);
				Hui.rectMY[i - 11].setFill(javafx.scene.paint.Color.YELLOW);

				Hui.rectMY[i - 1].veto++;
				Hui.rectMY[i + 10].veto++;
				Hui.rectMY[i - 10].veto++;
				Hui.rectMY[i + 9].veto++;
				Hui.rectMY[i - 11].veto++;

			}

			else if (y == 0) {
				Hui.rectMY[i - 1].setFill(javafx.scene.paint.Color.YELLOW);
				Hui.rectMY[i + 1].setFill(javafx.scene.paint.Color.YELLOW);
				Hui.rectMY[i + 10].setFill(javafx.scene.paint.Color.YELLOW);
				Hui.rectMY[i + 9].setFill(javafx.scene.paint.Color.YELLOW);
				Hui.rectMY[i + 11].setFill(javafx.scene.paint.Color.YELLOW);

				Hui.rectMY[i - 1].veto++;
				Hui.rectMY[i + 1].veto++;
				Hui.rectMY[i + 10].veto++;
				Hui.rectMY[i + 9].veto++;
				Hui.rectMY[i + 11].veto++;

			}

			else if (y == 9) {
				Hui.rectMY[i - 1].setFill(javafx.scene.paint.Color.YELLOW);
				Hui.rectMY[i + 1].setFill(javafx.scene.paint.Color.YELLOW);
				Hui.rectMY[i - 10].setFill(javafx.scene.paint.Color.YELLOW);
				Hui.rectMY[i - 9].setFill(javafx.scene.paint.Color.YELLOW);
				Hui.rectMY[i - 11].setFill(javafx.scene.paint.Color.YELLOW);

				Hui.rectMY[i - 1].veto++;
				Hui.rectMY[i + 1].veto++;
				Hui.rectMY[i - 10].veto++;
				Hui.rectMY[i - 9].veto++;
				Hui.rectMY[i - 11].veto++;
			}

			else {
				Hui.rectMY[i + 1].setFill(javafx.scene.paint.Color.YELLOW);
				Hui.rectMY[i - 1].setFill(javafx.scene.paint.Color.YELLOW);
				Hui.rectMY[i + 10].setFill(javafx.scene.paint.Color.YELLOW);
				Hui.rectMY[i - 10].setFill(javafx.scene.paint.Color.YELLOW);

				Hui.rectMY[i + 11].setFill(javafx.scene.paint.Color.YELLOW);
				Hui.rectMY[i - 11].setFill(javafx.scene.paint.Color.YELLOW);
				Hui.rectMY[i + 9].setFill(javafx.scene.paint.Color.YELLOW);
				Hui.rectMY[i - 9].setFill(javafx.scene.paint.Color.YELLOW);

				Hui.rectMY[i + 1].veto++;
				Hui.rectMY[i - 1].veto++;
				Hui.rectMY[i + 10].veto++;
				Hui.rectMY[i - 10].veto++;

				Hui.rectMY[i + 11].veto++;
				Hui.rectMY[i - 11].veto++;
				Hui.rectMY[i + 9].veto++;
				Hui.rectMY[i - 9].veto++;
				System.out.println("asdf");
			}
		} catch (ArrayIndexOutOfBoundsException e) {

		}
	}

	public void m(int s) {
		System.out.println("Enter s.veto"+s+" "+ Hui.rectMY[s].veto );
		if (Hui.rectMY[s].veto == 1) {
			System.out.println("fffgggggrrrr");
			Hui.rectMY[s].setFill(javafx.scene.paint.Color.GREEN);
			Hui.rectMY[s].veto--;
			//Hui.rectMY[s].veto--;
			System.out.println("IF s.veto"+s+" "+ Hui.rectMY[s].veto );
		} else {
			
			System.out.println("1111fffgggggrrrr");
			System.out.println("else s.veto"+s+" "+ Hui.rectMY[s].veto );
			Hui.rectMY[s].veto--;
			//Hui.rectMY[s].veto--;
			System.out.println("bef else s.veto"+s+" "+ Hui.rectMY[s].veto );
			
		}
	}

	public void marketGreen(int x, int y) {

		int i = y * 10 + x;

		try {

			if (x == 0 && y == 0) {

				m(i + 1);
				m(i + 10);
				m(i + 11);
			}

			else if (x == 0 && y == 9) {
				m(i + 1);
				m(i - 10);
				m(i - 9);

			}

			else if (x == 9 && y == 9) {
				m(i - 1);
				m(i - 10);
				m(i - 11);

			}

			else if (x == 9 && y == 0) {
				m(i - 1);
				m(i + 10);
				m(i + 9);

			}

			else if (x == 0) {
				m(i + 1);
				m(i + 10);
				m(i - 10);
				m(i - 9);
				m(i + 11);

			}

			else if (x == 9) {
				m(i - 1);
				m(i + 10);
				m(i - 10);
				m(i + 9);
				m(i - 11);

			}

			else if (y == 0) {
				m(i - 1);
				m(i + 1);
				m(i + 10);
				m(i + 9);
				m(i + 11);

			}

			else if (y == 9) {
				m(i - 1);
				m(i + 1);
				m(i - 10);
				m(i - 9);
				m(i - 11);

			}

			else {
				m(i + 1);
				m(i - 1);
				m(i + 10);
				m(i - 10);

				m(i + 11);
				m(i - 11);
				m(i + 9);
				m(i - 9);
			}
		} catch (ArrayIndexOutOfBoundsException e) {

		}

	}

}
