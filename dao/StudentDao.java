package dao;
import entity.IEntity;
import entity.Student;
import java.io.*;
import java.util.*;


public class StudentDao implements IDao {

	private static StudentDao instance = null;
	static HashMap<String, Student> students;
	private Student student ;
	private StringBuffer text;
	
	private StudentDao() throws Exception {
		students= new HashMap<String, Student>();
		FileReader r = new FileReader("学生信息.txt");
		BufferedReader br = new BufferedReader(r);
		String str ;
		try {
		while((str=br.readLine()) != null) {
			System.out.println(str);
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
		}catch(Exception e) {
			e.printStackTrace();
		}
		Set<String> keySet = students.keySet();
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String key=it.next();
			Student value=students.get(key);
			System.out.println("读取后"+key+" "+value.getStudentName()+value.getStudentPassword());
		}
		
	}
	public static StudentDao getInstance() {
		if(instance == null) {
//			synchronized(StudentDao.class){
				if(instance == null) {
					try {
						instance = new StudentDao();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					return instance;
				}
			}
//		}
		return instance;
	}
	@Override
	public void insert(IEntity entity) {
		// TODO Auto-generated method stub
		Student st = (Student)entity;
		student = st;
//		System.out.println("插入"+student.getStudentNo()+" "+student.getStudentAge()+" "+student.getStudentName());
		students.put(student.getStudentNo(),student);
		
		Set<String> keySet = students.keySet();
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String key=it.next();
			Student value=students.get(key);
			System.out.println("插入后"+key+" "+value.getStudentName()+value.getStudentPassword());
		}
	}
	@Override
	public void delete(IEntity entity) {
		// TODO Auto-generated method stub
		Student st = (Student)entity;
		student = st;
		students.remove(student.getStudentNo());
		
		Set<String> keySet = students.keySet();
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String key=it.next();
			Student value=students.get(key);
			System.out.println("删除后"+key+" "+value.getStudentName()+value.getStudentPassword());
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		Set<String> keySet = students.keySet();
		Iterator<String> it = keySet.iterator();
		text = new StringBuffer();
		while(it.hasNext()) {
			String key=it.next();
			Student value=students.get(key);
//			System.out.println("sb"+key+" "+value.getStudentName()+value.getStudentPassword());
		
			text.append(value.getStudentNo()+" "+value.getStudentName()+" "+ 
			value.getStudentGender()+" "+value.getStudentPassword()+" "+
			value.getStudentAge()+" "+value.getStudentDepartment()+" \r\n");
		}	
		try {
			FileWriter r = new FileWriter("学生信息.txt");
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
		return students.get(Id);
	}

}
