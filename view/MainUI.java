package view;

import java.util.Scanner;

import dao.StudentDao;
import entity.Student;

public class MainUI {
	private static Scanner in= new Scanner(System.in);
	
	public static void main(String[] args) throws Exception {
		MainUI.show();
	}
	
	
	public static void show() throws Exception {
		System.out.println("1 注册\n2 登录\n0 退出");
		int option = in.nextInt();
		
		switch (option) {
		case 1:
			RegisterUI.show();
			break;
		case 2:
			LoginUI.show();
			break;
		default:
			System.out.println("感谢使用！");
			StudentDao.getInstance().update();	

			in.close();
			System.exit(0);
		}
	}
	public static void show(Student stu) throws Exception {
		System.out.println("1 修改密码\n2 进行选课\n0 退出登录");
		
		int option = in.nextInt();
		
		switch (option) {
		case 1:
			ModifyPasswordUI.show(stu);
			break;
		case 2:
			CourseSelection.show(stu);
			break;
		default:
			in.close();
			MainUI.show();
		}
		
	}
		
}

