package biz;

import java.util.Scanner;

import dao.*;
import entity.*;

public class SCBiz {
	StudentDao studentDao;
	Student student;
	CourseDao courseDao;
	Course course;
	static SCDao scDao;
	static SC sc ;

	Scanner scanner = new Scanner(System.in);
	
	public SCBiz(){
		studentDao = StudentDao.getInstance();
		
		courseDao = CourseDao.getInstance();
		
	}
	public void show(Student stu) {
		
		scDao = SCDao.getInstance();
		student = stu;		
		
		System.out.println("请输入课程编号:");
		
		CourseBiz.show();
		String cn= scanner.nextLine();
		
		if((course=(Course) courseDao.getEntity(cn))==null) {
			
			System.out.println("课程不存在!");	
			
		}else {
			if(SCBiz.stage(course)==false) {
				System.out.println("课程人数达到上限!");	
			}else if(repeat(stu,course)) {
				System.out.println("课程重复选择!");	
			}else {
				System.out.println("正在选课...");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sc = new SC();
				sc.setStudentNo(stu.getStudentName());
				if((sc.getCourseNo()).isEmpty()) {
					sc.setCourseNo(course.getCourseName());
				}else {
					sc.setCourseNo(sc.getCourseNo()+"_"+course.getCourseName());
				}
				scDao.insert(sc);
			}
		}
		
	}
	//课程人数状态
	private static boolean stage(Course c) {
			boolean state = true;
			if(c.getCourseNumber()==0) {
				state = false;
			}
			return state;
	}
	//重复选择状态
	private static boolean repeat(Student stu ,Course cou) {
		scDao = SCDao.getInstance();
		sc =  (SC) scDao.getEntity(stu.getStudentName());
		if((sc.getCourseNo()).contains(cou.getCourseName())) {
			return true;
		}else return false;
	}
}
