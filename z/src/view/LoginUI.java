package view;

import java.util.Scanner;

import biz.StudentBiz;

public class LoginUI {	

	public static void show() throws Exception {
		Scanner scanner;
		String Name;
		String Password;
		StudentBiz studentBiz = new StudentBiz();
		System.out.println("«Î ‰»Î—ß∫≈£∫");
		scanner = new Scanner(System.in);
		Name = scanner.nextLine();
		System.out.println("«Î ‰»Î√‹¬Î£∫");
		Password = scanner.nextLine();
		scanner.close();
		
		studentBiz.login(Name, Password);
	}
}
