package biz;

import java.util.*;

import dao.*;
import entity.*;

public class CourseBiz {
	private static CourseDao courseDao ;
	private static Course course ;
	
	Scanner scanner = new Scanner(System.in);
	
	
	
	//查看所有课程
	public static void show() {
		courseDao = CourseDao.getInstance();
		courseDao.show();
	}

	//查看课程详细信息
	public static int show(String s) {
		courseDao = CourseDao.getInstance();
		course = (Course) courseDao.getEntity(s);
		if (course == null) {
			System.out.println("课程不存在!");				
			return 0;
		} else {
			
			System.out.println("课程编号     课程名称     学分     老师      可选人数");
			System.out.println(course.getCourseNo()+"     "+course.getCourseName()
			+"             "+course.getCourseCredit()+"          "+course.getCourseTeacher()
			+"        "+course.getCourseNumber());
			
			return 1;
		}
		
	}
	
}
