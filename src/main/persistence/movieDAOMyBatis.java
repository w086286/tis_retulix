package main.persistence;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class movieDAOMyBatis {

	private final String NS="main.persistence.movieMapper";
	
	private SqlSession ses;
	
	public SqlSessionFactory getSessionFactory() {
		SqlSessionFactoryBuilder builder=null;
		String resource="common/config/mybatis-config.xml";
		try {
			InputStream is=Resources.getResourceAsStream(resource);
			builder=new SqlSessionFactoryBuilder();
			SqlSessionFactory factory=builder.build(is);
			return factory;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	//boarddao 바티스에서 getTotalCount 참고

	
	
	
}
