package biz;

import java.util.*;

import dao.*;
import entity.*;

public class CourseBiz {
	private static CourseDao courseDao = CourseDao.getInstance();
	private static Course course ;
	
	Scanner scanner = new Scanner(System.in);
	
	
	
	//�鿴���пγ�
	public static void show() {

		Set<String> keySet = courseDao.getCourses().keySet();
		Iterator<String> it = keySet.iterator();
		System.out.println("�γ̱�� �γ�����");
		while(it.hasNext()) {
			String key=it.next();
			Course value=courseDao.getCourses().get(key);
			System.out.println(key+"   "+value.getCourseName());
		}
		
	}


	//�鿴�γ���ϸ��Ϣ
	public static int show(String s) {
		course = (Course) courseDao.getEntity(course.getCourseNo());
		if (course == null) {
			System.out.println("�γ̲�����");				
			return 0;
		} else {
			
			System.out.println("�γ̱��     �γ�����     ѧ��     ��ʦ      ��ѡ����");
			System.out.println(course.getCourseNo()+"     "+course.getCourseName()+"    "
			+course.getCourseCredit()+"  "+course.getCourseTeacher()+"   "+course.getCourseNumber());
			
			return 1;
		}
		
	}
	
}
