package dao;
import entity.IEntity;
import entity.Student;
import java.io.*;
import java.util.*;


public class StudentDao implements IDao {

	private static StudentDao instance;
	private HashMap<String, Student> students;
	private Student student;
	private StudentDao() throws Exception {
		student = new Student();
		students = new HashMap<String, Student>();	
		FileReader r = new FileReader("学生信息.txt");
		BufferedReader br = new BufferedReader(r);
		String str ;
		while((str=br.readLine())!=null) {
			String[] sA = str.split(" ");
			student = new Student();
			student.setStudentNo(sA[0]);
			student.setStudentName(sA[1]);
			student.setStudentGender(sA[2]);
			student.setStudentPassword(sA[3]);
			Integer a=Integer.valueOf(sA[4]);
			student.setStudentAge(a);
			student.setStudentDepartment(sA[5]);
			students.put(student.getStudentNo(), student);
		}
		br.close();
		Set<String> keySet = students.keySet();
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String key=it.next();
			Student value=students.get(key);
			System.out.println(key+" "+value.getStudentName()+value.getStudentGender());
		}
	}
	public static StudentDao getInstance() throws Exception {
		if(instance == null) {
				instance = new StudentDao();
					return instance;
				}
			
		
		return instance;
	}
	@Override
	public void insert(IEntity entity) {
		// TODO Auto-generated method stub
		Student st = (Student)entity;
		students.put(st.getStudentNo(), st);
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public HashMap<String, IEntity> getAllEntities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEntity getEntity(String Id) {
		// TODO Auto-generated method stub		
		return students.get(Id);
	}

}
