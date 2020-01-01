package view;

import java.util.Scanner;

import biz.*;
import dao.CourseDao;
import entity.Student;

public class CourseSelection {
	public static void show(Student stu) throws Exception {
		SCBiz sc = new SCBiz();
		while(true) {
			CourseDao.getInstance().update();
			System.out.println("1 查看课程信息\n2 选课\n3 查看已选课程\n0 退出选课");
			Scanner in = new Scanner(System.in);
			int option = Integer.parseInt(in.nextLine());	
			
			switch (option) {
			case 1:
				
				System.out.println("1 查看所有课程\n2 查看详细信息\n");
				int c = Integer.parseInt(in.nextLine());
				if(c==1) {
					CourseBiz.show();
				}else if(c==2){		
					System.out.println("请输入课程编号:");
					String s = in.nextLine();
					CourseBiz.show(s);
				}
				break;
			case 2:
				
				sc.show(stu);
				break;
			case 3:	
				
				sc.showI(stu);
				
			default:
				MainUI.show(stu);
			}
		}
	}
}
