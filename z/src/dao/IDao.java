package dao;
import java.util.HashMap;
import entity.IEntity;
import entity.Student;;

public interface IDao {
	void insert(IEntity entity) throws Exception;
	void delete();
	void update();
	public HashMap<String, IEntity> getAllEntities(); 
	public IEntity getEntity(String Id);
}
