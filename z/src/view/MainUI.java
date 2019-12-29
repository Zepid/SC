package view;

import java.util.Scanner;

public class MainUI {
	public static void main(String[] args) throws Exception {
		MainUI.show();
	}
	public static void show() throws Exception {
		System.out.println("1 ×¢²á\n2 ÐÞ¸ÄÃÜÂë\n3 Ñ¡¿Î\n4 µÇÂ¼\n0 ÍË³ö");
		Scanner in = new Scanner(System.in);
		int option = in.nextInt();
		
		switch (option) {
		case 1:
			RegisterUI.show();
			break;
		case 2:
			ModifyPasswordUI.show();
			break;
		case 3:
			//new CourseSelection().show();
			break;
		case 4:
			LoginUI.show();
			break;
		case 0:
			in.close();
			System.exit(0);
		}
	}
}
