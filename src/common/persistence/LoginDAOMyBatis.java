package common.persistence;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import common.domain.*;

public class LoginDAOMyBatis {
	
	private final String NS="common.persistence.LoginMapper";
	private SqlSession ses;
	public SqlSessionFactory getSessionFactory() {
		SqlSessionFactoryBuilder builder=null;
		String resource="common/config/mybatis-config.xml";
		try {
			InputStream is=Resources.getResourceAsStream(resource);
			builder=new SqlSessionFactoryBuilder();
			SqlSessionFactory factory=builder.build(is);
			return factory;
		} catch(Exception evt) {
			evt.printStackTrace();
			return null;
		}
	}//getSessionFactory()-----------------------------------------
	
	public void close() {
		if(ses!=null) ses.close();
	}
	
	/** 회원 여부 판별 */
	public MemberVO loginCheck(String email, String pwd) {
		try {
			ses=this.getSessionFactory().openSession(true);
			Map<String, String> map=new HashMap<>();
			map.put("email", email);
			map.put("pwd", pwd);
			MemberVO vo=ses.selectOne(NS+".loginCheck", map);
			return vo;
		} finally {
			close();
		}
	}

}
