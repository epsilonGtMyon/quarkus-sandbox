package epsilongtmyon.common.db.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;

import epsilongtmyon.common.db.InjectConfig;
import epsilongtmyon.common.db.entity.Hello;

@Dao
@InjectConfig
public interface HelloDao {

	@Insert
	int insert(Hello hello);

}
