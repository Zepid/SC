package view;

import java.util.Scanner;

import dao.StudentDao;
import entity.Student;

public class MainUI {
	public static void main(String[] args) throws Exception {
		MainUI.show();
	}
	public static void show() throws Exception {
		System.out.println("1 ע��\n2 ��¼\n0 �˳�");
		Scanner in = new Scanner(System.in);
		int option = in.nextInt();
		
		switch (option) {
		case 1:
			RegisterUI.show();
			break;
		case 2:
			LoginUI.show();
			break;
		case 0:
			in.close();
			StudentDao.getInstance().update();			
			System.exit(0);
		}
	}
	public static void show(Student stu) throws Exception {
		System.out.println("1 �޸�����\n2 ѡ��\n0 �˳���¼");
		Scanner in = new Scanner(System.in);
		int option = in.nextInt();
		in.close();
		
		switch (option) {
		case 1:
			ModifyPasswordUI.show(stu);
			break;
		case 2:
			CourseSelection.show(stu);
			break;
		default:
			MainUI.show();
		}
	}
}
