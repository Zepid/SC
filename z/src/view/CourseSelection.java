package view;

import java.util.Scanner;

import biz.*;
import entity.Student;

public class CourseSelection {
	public static void show(Student stu) throws Exception {
		
		while(true) {
			System.out.println("1 �鿴�γ���Ϣ\n2 ѡ��\n0 �˳�ѡ��");
			Scanner in = new Scanner(System.in);
			int option = in.nextInt();	
			
			switch (option) {
			case 1:
				
				System.out.println("1 �鿴���пγ�\n2 �鿴��ϸ��Ϣ\n");
				int c = in.nextInt();
				if(c==1) {
					CourseBiz.show();
				}else {		
					System.out.println("������γ̱��:");
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
