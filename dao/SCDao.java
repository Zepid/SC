package dao;
import entity.Course;
import entity.IEntity;
import entity.SC;
import entity.Student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class SCDao implements IDao {
	
	private static SCDao instance = null;
	private static HashMap<String, SC> scs ;
//	private Student student ;	
//	private Course course ;
	private SC sc ;
	private StringBuffer text;
	
	private SCDao() throws Exception {

		scs = new HashMap<String, SC>();
		
		FileReader r = new FileReader("选课信息.txt");
		BufferedReader br = new BufferedReader(r);
		String str;
		try {
			while((str=br.readLine()) != null) {
				sc = new SC();
				String[] sA = str.split(" ");
				if(sA.length!=0) {
				sc.setStudentName(sA[0]);
				sc.setStudentNo(sA[1]);
				sc.setCourseName(sA[2]);
				scs.put(sA[0], sc);
				}
//				System.out.println("读取后1:"+sA.length+sA[0]+" ww"+sA[1]+"qq "+sA[2]);
			}
		
			br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
//		Set<String> keySet = scs.keySet();
//		Iterator<String> it = keySet.iterator();
//		while(it.hasNext()) {
//			String key=it.next();
//			SC value=scs.get(key);
//			System.out.println("读取后:"+key+" "+value.getStudentNo()+" "+value.getCourseName());
//		}
		
	}
	public static SCDao getInstance() {
		if(instance == null) {
					try {
						instance = new SCDao();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					return instance;
				
			}
		return instance;
	}
	@Override
	public void insert(IEntity entity) {
		// TODO Auto-generated method stub
		sc = (SC)entity;
		
		instance = SCDao.getInstance();
//		instance.delete(entity);
		Set<String> keySet = scs.keySet();
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String key=it.next();
			SC value=scs.get(key);
			System.out.println("cha入前"+key+" "+value.getStudentNo()+" "+value.getCourseName());
		}
		scs.put(sc.getStudentName(),sc);
//		Set<String> keySet = scs.keySet();
//		Iterator<String> it = keySet.iterator();
		
		instance.update();
	}

	@Override
	public void delete(IEntity entity) {
		// TODO Auto-generated method stub
//		SC sc = (SC)entity;
//		this.sc = sc;
//		scs.remove(sc.getStudentName());
//		
//		Set<String> keySet = scs.keySet();
//		Iterator<String> it = keySet.iterator();
//		while(it.hasNext()) {
//			String key=it.next();
//			SC value=scs.get(key);
//			System.out.println("删除后"+key+" "+value.getStudentNo()+value.getCourseName());
//		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

				Set<String> keySet = scs.keySet();
				Iterator<String> it = keySet.iterator();
				text = new StringBuffer();
				while(it.hasNext()) {
					String key=it.next();
					SC value=scs.get(key);
//					System.out.println(" ?"+key+" "+value.getStudentName()+value.getStudentPassword());
				
					text.append(key+" "+value.getStudentNo()+" "+value.getCourseName()+" \n");
				}	
				try {
						FileWriter r = new FileWriter("选课信息.txt");
						BufferedWriter br = new BufferedWriter(r);
						String s = text.toString();
						br.write(s);
						br.newLine();
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
	}


	@Override
	public IEntity getEntity(String Id) {
		// TODO Auto-generated method stub		
		return scs.get(Id);
	}
	
	public void show(String Id) {
		
		System.out.println(Id+" "+scs.get(Id).getStudentNo()+" "+scs.get(Id).getCourseName());
		
	}
}
