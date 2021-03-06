package main.persistence;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import main.domain.TrailerVO;
import main.domain.subscribeVO;

public class mainDAOMyBatis {
	
	private final String NS="main.persistence.mainMapper";
	
	private SqlSession ses;
	
	public SqlSessionFactory getSessionFactory() {
		SqlSessionFactoryBuilder builder=null;
		String resource="common/config/mybatis-config.xml";
		try {
			InputStream is=Resources.getResourceAsStream(resource);
			builder=new SqlSessionFactoryBuilder();
			SqlSessionFactory factory=builder.build(is);
			return factory;
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
	}

	private void close() {
		if(ses!=null) ses.close();
		
	}//------------------------------------
	

	//구독자 리스트 나중에 수정필요 product 바티스 리스트로 바꿀것
	public List<subscribeVO> listMain(String email_subs){
		try {
		ses=this.getSessionFactory().openSession(true);
		
		//Map<String,String> map=new HashMap<>();
		//map.put("email_subs", email_subs);
		List<subscribeVO> arr=ses.selectList(NS+".testsubMapper", email_subs);
		return arr;
	}finally {
		close();
	}		
	}
	
	
	public List<TrailerVO> most_Good(String url) {
		try {
			ses=this.getSessionFactory().openSession(true);
			
			
			Map<String, String> map=new HashMap<>();
			map.put("url", url);
			
			List<TrailerVO> arr=ses.selectList(NS+".most_good",map);
			
			Collections.shuffle(arr); 
			
			return arr;
			
		}finally {
			close();
		}
	}
	
	public List<TrailerVO> SF_Movie(String MS_title){
		try {
			ses=this.getSessionFactory().openSession(true);
			Map<String, String> map=new HashMap<>();
			map.put("title",MS_title);
			List<TrailerVO> arr=ses.selectList(NS+".SF_Movie",map);
			Collections.shuffle(arr);
			return arr;
		}finally {
			close();
		}
	}
	
	public List<TrailerVO> CO_Movie(String MC_title){
		try {
			ses=this.getSessionFactory().openSession(true);
			Map<String, String> map=new HashMap<>();
			map.put("title",MC_title);
			List<TrailerVO> arr=ses.selectList(NS+".CO_Movie",map);
			Collections.shuffle(arr);
			return arr;
		}finally {
			close();
		}
	}
	
	public List<TrailerVO> AC_Movie(String MA_title){
		try {
			ses=this.getSessionFactory().openSession(true);
			Map<String, String> map=new HashMap<>();
			map.put("title",MA_title);
			List<TrailerVO> arr=ses.selectList(NS+".AC_Movie",map);
			Collections.shuffle(arr);
			return arr;
		}finally {
			close();
		}
	}
	
	public List<TrailerVO> HO_Movie(String MH_title){
		try {
			ses=this.getSessionFactory().openSession(true);
			Map<String, String> map=new HashMap<>();
			map.put("title",MH_title);
			List<TrailerVO> arr=ses.selectList(NS+".HO_Movie",map);
			Collections.shuffle(arr);
			return arr;
		}finally {
			close();
		}
	}
	
	public List<TrailerVO> RO_Movie(String MR_title){
		try {
			ses=this.getSessionFactory().openSession(true);
			Map<String, String> map=new HashMap<>();
			map.put("title",MR_title);
			List<TrailerVO> arr=ses.selectList(NS+".RO_Movie",map);
			Collections.shuffle(arr);
			return arr;
		}finally {
			close();
		}
	}
	

	public List<TrailerVO> Drama(String D_title){
		try {
			ses=this.getSessionFactory().openSession(true);
			Map<String, String> map=new HashMap<>();
			map.put("title",D_title);
			List<TrailerVO> arr=ses.selectList(NS+".Drama",map);
			Collections.shuffle(arr);
			return arr;
		}finally {
			close();
		}
	}
	
	

}
