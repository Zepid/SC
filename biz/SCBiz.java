package biz;

import java.util.Scanner;

import dao.*;
import entity.*;
import view.CourseSelection;

public class SCBiz {
	StudentDao studentDao;
	Student student;
	CourseDao courseDao;
	Course course;
	SCDao scDao;
	SC sc ;

	
	Scanner scanner = new Scanner(System.in);
	
	public SCBiz(){
		studentDao = StudentDao.getInstance();
		
	
		
	}
	public void showI(Student stu) {
		scDao = SCDao.getInstance();
		scDao.show(stu.getStudentName());
		try {
			CourseSelection.show(stu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void show(Student stu) {
		
		courseDao = CourseDao.getInstance();
		scDao = SCDao.getInstance();
		
		sc=((SC)scDao.getEntity(stu.getStudentName()));
		System.out.println("请输入课程编号:");
		
		CourseBiz.show();
		String cn= scanner.nextLine();
		
		if((course=(Course) courseDao.getEntity(cn))==null) {
			
			System.out.println("课程不存在!");	
			
		}else if( sc!=null ) {
			if(SCBiz.stage(course)==false) {
				System.out.println("课程人数达到上限!选课失败!");	
			}else if( sc.getCourseName().contains(course.getCourseName())) {
							
					System.out.println("课程重复选择!选课失败!");	
			}else {
				System.out.println("正在选课...");
				course.select();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sc.setStudentName(stu.getStudentName());
				sc.setStudentNo(stu.getStudentNo());
				
				sc.setCourseName(sc.getCourseName()+course.getCourseName());
				
				scDao.insert(sc);
				
				System.out.println("选课成功!");
			}
		}else {
				System.out.println("正在选课...");
				course.select();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sc = new SC();
				sc.setStudentName(stu.getStudentName());
				sc.setStudentNo(stu.getStudentNo());
				
				sc.setCourseName(course.getCourseName());
				
				scDao.insert(sc);
				
				System.out.println("选课成功!");
		}
		 CourseDao.getInstance().update();
			try {
				CourseSelection.show(stu);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
	//课程人数状态
	private static boolean stage(Course c) {
			boolean state = true;
			if(c.getCourseNumber()<=0) {
				state = false;
			}
			return state;
	}
	//重复选择状态
//	public static boolean repeat(Student stu ,Course cou,SCDao scDao) {
//		SC sce;
//		sce =  (SC) scDao.getEntity(stu.getStudentName());
//		System.out.print(sce.getCourseName()+"rz");
//		return (sce.getCourseName()).contains(cou.getCourseName());
//	}
}
