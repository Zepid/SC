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

	private static CourseDao instance = null;
	private static HashMap<String, Course> courses ;
	private Course course ;
	
	private CourseDao() throws Exception {
		courses = new HashMap<String, Course>();
		FileReader r = new FileReader("课程.txt");
		BufferedReader br = new BufferedReader(r);
		String str ;
		try {
		while((str=br.readLine()) != null) {
			String[] sA = str.split(" ");
			course = new Course();
			course.setCourseNo(sA[0]);
			course.setCourseName(sA[1]);
			Double a=Double.valueOf(sA[2]);
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
		if(instance == null) {
				if(instance == null) {
					try {
						instance = new CourseDao();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					return instance;
				}
		}
		return instance;
	}
	@Override
	public void insert(IEntity entity) {
		// TODO Auto-generated method stub

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
		while(it.hasNext()) {
			String key=it.next();
			Course value=courses.get(key);
//			System.out.println("sb"+key+" "+value.getStudentName()+value.getStudentPassword());
		
			String text = value.getCourseNo()+" "+value.getCourseName()+" "+ 
			value.getCourseCredit()+" "+value.getCourseTeacher()+" "+
			value.getCourseNumber()+" \r\n";
			try {
				FileWriter r = new FileWriter("课程.txt");
				BufferedWriter br = new BufferedWriter(r);
				br.write(text);
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public HashMap<String, Course> getCourses(){
		
		return courses;
		
	}

	@Override
	public IEntity getEntity(String Id) {
		// TODO Auto-generated method stub
		return courses.get(Id);
	}

}
