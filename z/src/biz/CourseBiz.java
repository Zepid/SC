package biz;

import java.util.*;

import dao.*;
import entity.*;

public class CourseBiz {
	private static CourseDao courseDao = CourseDao.getInstance();
	private static Course course ;
	
	Scanner scanner = new Scanner(System.in);
	
	
	
	//查看所有课程
	public static void show() {

		Set<String> keySet = courseDao.getCourses().keySet();
		Iterator<String> it = keySet.iterator();
		System.out.println("课程编号 课程名称");
		while(it.hasNext()) {
			String key=it.next();
			Course value=courseDao.getCourses().get(key);
			System.out.println(key+"   "+value.getCourseName());
		}
		
	}


	//查看课程详细信息
	public static int show(String s) {
		course = (Course) courseDao.getEntity(course.getCourseNo());
		if (course == null) {
			System.out.println("课程不存在");				
			return 0;
		} else {
			
			System.out.println("课程编号     课程名称     学分     老师      可选人数");
			System.out.println(course.getCourseNo()+"     "+course.getCourseName()+"    "
			+course.getCourseCredit()+"  "+course.getCourseTeacher()+"   "+course.getCourseNumber());
			
			return 1;
		}
		
	}
	
}
