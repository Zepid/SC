package biz;

import java.util.Scanner;

import dao.StudentDao;
//import entity.IEntity;
import entity.Student;
import view.MainUI;

public class StudentBiz {
	StudentDao studentDao;
	private Student student;
	Scanner scanner = new Scanner(System.in);
	public StudentBiz() throws Exception {
		
	}
	//��¼
	public void login(String studentNo, String studentPassword) throws Exception {

		studentDao = StudentDao.getInstance();
		student = (Student) studentDao.getEntity(studentNo);
		if (student == null) {
			System.out.println("�û�������");
			return;
		} else if (student.getStudentPassword().equals(studentPassword)) {
			System.out.println("��¼�ɹ�");
			MainUI.show();
		} else {
			System.out.println("���벻��ȷ");
			MainUI.show();
		}

	}
	//ע�ᣬҵ���߼�ʵ��
	public void register(String studentNo, 
						String studentName, 
						String studentGender, 
						int studentAge, 
						String studentDepartment, 
						String firstPassword, 
						String secondPassword) throws Exception {
		if(firstPassword.equals(secondPassword)) {
			student = new Student();
			student.setStudentNo(studentNo);
			student.setStudentName(studentName);
			student.setStudentAge(studentAge);
			student.setStudentDepartment(studentDepartment);
			student.setStudentPassword(firstPassword);
			studentDao = StudentDao.getInstance();
			studentDao.insert(student);
			System.out.println("ע��ɹ���");
			MainUI.show();
		}else {
			System.out.println("�����������벻ͬ����\n�������������룺");
			String fp = scanner.nextLine();
			System.out.println("���ٴ��������룺");
			String sp= scanner.nextLine();
			StudentBiz sc = new StudentBiz();
			sc.register(studentNo, 
					studentName, 
					studentGender, 
					studentAge, 
					studentDepartment, 
					fp, 
					sp);	
		}
	}
}
