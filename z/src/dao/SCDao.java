package dao;
import entity.Course;
import entity.IEntity;
import entity.SC;
import entity.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class SCDao implements IDao {
	
	private static SCDao instance = null;
	private static HashMap<String, SC> scs ;
//	private Student student ;	
//	private Course course ;
	private SC sc ;
	
	private SCDao() throws Exception {

		HashMap<String, SC> scs = new HashMap<String, SC>();
		
		FileReader r = new FileReader("选课信息.txt");
		BufferedReader br = new BufferedReader(r);
		String str;
		try {
			while((str=br.readLine()) != null) {
				sc = new SC();
				String[] sA = str.split(" ");
				sc.setStudentNo(sA[1]);
				sc.setCourseNo(sA[2]);
				scs.put(sA[0], sc);
			}
			br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		Set<String> keySet = scs.keySet();
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String key=it.next();
			SC value=scs.get(key);
			System.out.println("读取后:"+key+" "+value.getStudentNo()+" "+value.getCourseNo());
		}
		
	}
	public static SCDao getInstance() {
		if(instance == null) {
				if(instance == null) {
					try {
						instance = new SCDao();
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
		sc = (SC)entity;
		HashMap<String, SC> scs = new HashMap<String, SC>();
		
		SCDao.getInstance().delete(entity);
		scs.put();
	}

	@Override
	public void delete(IEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}


	@Override
	public IEntity getEntity(String Id) {
		// TODO Auto-generated method stub		
		return scs.get(Id);
	}
}
