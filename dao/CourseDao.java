package dao;
import entity.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class CourseDao implements IDao {

	private static CourseDao instance  ;
	private static HashMap<String, Course> courses ;
	private Course course ;
	private StringBuffer text;
	
	private CourseDao() throws Exception {
		courses = new HashMap<String, Course>();
		FileReader r = new FileReader("课程.txt");
//		课程编号  课程名称      学分          老师           人数
		BufferedReader br = new BufferedReader(r);
		String str ;
		
		try {
		while((str=br.readLine()) != null) {
			
			String[] sA = str.split(" ");
//			System.out.println(sA[0]+"  "+sA[1]+sA[2]+sA[3]);
			try {
				course = new Course();
			}catch(Exception e) {
				e.printStackTrace();
			}
			course.setCourseNo(sA[0]);
			course.setCourseName(sA[1]);
			Integer a=Integer.valueOf(sA[2]);			
			course.setCourseCredit(a);
			course.setCourseTeacher(sA[3]);
			Integer b=Integer.valueOf(sA[4]);
			course.setCourseNumber(b);
			courses.put(course.getCourseNo(), course);
		}
		br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
//		Set<String> keySet = courses.keySet();
//		Iterator<String> it = keySet.iterator();
//		while(it.hasNext()) {
//			String key=it.next();
//			Course value=courses.get(key);
//			System.out.println("读取后"+key+" "+value.getCourseName()+value.getCourseTeacher());
//		}
		
	}
	public static CourseDao getInstance() {
		try {
				if(instance == null) {
					
					instance = new CourseDao();
				}
		}catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
		}
				
					return instance;
	

	}
	//查看所有课程
	public void show() {
	
		Set<String> keySet = courses.keySet();
		Iterator<String> it = keySet.iterator();
		System.out.println("课程编号 课程名称");
		while(it.hasNext()) {
			String key=it.next();
	    	Course value=courses.get(key);
			System.out.println(key+"    "+value.getCourseName());
		}
		
	}
	@Override
	public void insert(IEntity entity) {
		// TODO Auto-generated method stub
		Course cou = (Course)entity;
		course = cou;
//		System.out.println("插入"+student.getStudentNo()+" "+student.getStudentAge()+" "+student.getStudentName());
		courses.put(course.getCourseNo(),course);
		
		Set<String> keySet = courses.keySet();
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String key=it.next();
			Course value=courses.get(key);
			System.out.println("插入后"+key+" "+value.getCourseNumber()+value.getCourseName());
		}
	}
	
	@Override
	public void delete(IEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		Set<String> keySet = courses.keySet();
		Iterator<String> it = keySet.iterator();
		text = new StringBuffer();;
		while(it.hasNext()) {
			String key=it.next();
			Course value=courses.get(key);
//			System.out.println("sb"+key+" "+value.getStudentName()+value.getStudentPassword());
		
			
			text.append(value.getCourseNo()+" "+value.getCourseName()+" "+ 
			value.getCourseCredit()+" "+value.getCourseTeacher()+" "+
			value.getCourseNumber()+" \r\n");
		}	
		try {
				FileWriter r = new FileWriter("课程.txt");
				BufferedWriter br = new BufferedWriter(r);
				String s = text.toString();
				br.write(s);
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	@Override
	public IEntity getEntity(String Id) {
		// TODO Auto-generated method stub
		return courses.get(Id);
	}

}
