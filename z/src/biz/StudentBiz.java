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
	//登录
	public void login(String studentNo, String studentPassword) throws Exception {

		studentDao = StudentDao.getInstance();
		student = (Student) studentDao.getEntity(studentNo);
		if (student == null) {
			System.out.println("用户不存在");
			return;
		} else if (student.getStudentPassword().equals(studentPassword)) {
			System.out.println("登录成功");
			MainUI.show();
		} else {
			System.out.println("密码不正确");
			MainUI.show();
		}

	}
	//注册，业务逻辑实现
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
			System.out.println("注册成功！");
			MainUI.show();
		}else {
			System.out.println("两次输入密码不同！：\n请重新输入密码：");
			String fp = scanner.nextLine();
			System.out.println("请再次输入密码：");
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
