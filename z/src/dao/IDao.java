package dao;
import java.util.HashMap;
import entity.IEntity;
import entity.Student;;

public interface IDao {
	void insert(IEntity entity);
	void delete(IEntity entity);
	void update();
	public IEntity getEntity(String Id);

}
