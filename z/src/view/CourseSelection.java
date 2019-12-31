package view;

import java.util.Scanner;

import biz.*;
import entity.Student;

public class CourseSelection {
	public static void show(Student stu) throws Exception {
		
		while(true) {
			System.out.println("1 查看课程信息\n2 选课\n0 退出选课");
			Scanner in = new Scanner(System.in);
			int option = in.nextInt();	
			
			switch (option) {
			case 1:
				
				System.out.println("1 查看所有课程\n2 查看详细信息\n");
				int c = in.nextInt();
				if(c==1) {
					CourseBiz.show();
				}else {		
					System.out.println("请输入课程编号:");
					String s = in.nextLine();
					CourseBiz.show(s);
				}
				break;
			case 2:
				
				new SCBiz().show(stu);
				break;
				
			default:
				in.close();
				MainUI.show(stu);
			}
		}
	}
}
