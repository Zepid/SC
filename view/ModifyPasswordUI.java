package view;

import java.util.Scanner;
import biz.*;
import dao.StudentDao;
import entity.Student;

public class ModifyPasswordUI {
	static StudentBiz studentBiz = new StudentBiz();
	static Scanner in = new Scanner(System.in);
	public static void show(Student stu) {
		System.out.println("请输入原有密码：");
		
		String mp1 = in.nextLine();
		if (stu.getStudentPassword().equals(mp1)) {
			studentBiz.modifyPassword(stu);
			
		}else {
			System.out.println("密码不正确！");
			//添加一个是否继续输入密码的条件判断语句
			ModifyPasswordUI.show(stu);
		}
	}
}
