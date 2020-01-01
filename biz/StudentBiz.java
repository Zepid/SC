package biz;

import java.util.Scanner;

import dao.StudentDao;
import entity.Student;
import view.MainUI;
import view.ModifyPasswordUI;

public class StudentBiz {
	StudentDao studentDao;
	private Student student;
	Scanner scanner = new Scanner(System.in);

	//登录
	public void login(String studentNo, String studentPassword) throws Exception {

		studentDao = StudentDao.getInstance();
		student = (Student) studentDao.getEntity(studentNo);
		if (student == null) {
			System.out.println("用户不存在");
			MainUI.show();
		} else if (student.getStudentPassword().equals(studentPassword)) {
			System.out.println("登录成功");
			MainUI.show(student);
		} else {
			System.out.println(student.getStudentPassword()+"!密码不正确!"+studentPassword);
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
		try {
			
		
		if(firstPassword.equals(secondPassword)) {
			student = new Student();
			student.setStudentNo(studentNo);
			student.setStudentName(studentName);
			student.setStudentGender(studentGender);
			student.setStudentPassword(firstPassword);
			student.setStudentAge(studentAge);
			student.setStudentDepartment(studentDepartment);
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
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//修改密码
	public void modifyPassword(Student stu) {
		System.out.println("请输入修改后密码：");
		String mp1 = scanner.nextLine();
		System.out.println("请再次输入修改后密码：");
		String mp2 = scanner.nextLine();
		if(mp1.equals(mp2)) {
			studentDao = StudentDao.getInstance();
			stu.setStudentPassword(mp1);
			studentDao.delete(stu);
			studentDao.insert(stu);
			System.out.println("修改成功!");
			
			try {
				MainUI.show(stu);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("两次输入不同!");
			ModifyPasswordUI.show(stu);
		}
		} 
	}

