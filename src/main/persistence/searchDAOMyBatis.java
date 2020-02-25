package main.persistence;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import main.domain.TrailerVO;

public class searchDAOMyBatis {

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
	private void close() {
		if(ses!=null) ses.close();
		
	}//------------------------------------
	
	public List<TrailerVO> searchList(String keyword){
		
		try {
			ses=getSessionFactory().openSession(true);
			Map<String,String> map=new HashMap<>();
			map.put("keyword", keyword);
			List<TrailerVO> arr=ses.selectList(NS+".searchList",map);
			return arr;
		} finally {
			close();
		}
		
		
	}
	
	
	
}
