package channel.persistence;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import channel.domain.StatVO;
import common.domain.*;

public class ChannelDAOmybatis {
	
	private final String NS="channel.persistence.ChannelMapper";
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
	
	/** 회원 정보 출력 */
	public MemberVO showUserInfo(String email) {
		try {
			ses=this.getSessionFactory().openSession(true);
			MemberVO vo=ses.selectOne(NS+".showUserInfo", email);
			return vo;
		} finally {
			close();
		}
	}

	/** 회원 정보 수정 */
	public int updateUserInfo(MemberVO vo) {
		try {
			ses=this.getSessionFactory().openSession(true);
			int n=ses.update(NS+".updateUserInfo", vo);
			return n;
		} finally {
			close();
		}
	}
	

	/** 업로드 영상 갯수 연산 */
	public int getTotalCount(String email, String type, String keyword) {
		try {
			ses=this.getSessionFactory().openSession(true);
			Map<String, String> map=new HashMap<>();
			map.put("email", email);
			map.put("type", type);
			map.put("keyword", keyword);
			int n=ses.selectOne(NS+".totalCount", map);
			return n;
		} finally {
			close();
		}
	}
	/** 채널 정보 출력*/
	public List<StatVO> showUserStat(String email, int start, int end, String type, String keyword) {
		try {
			ses=this.getSessionFactory().openSession(true);
			Map<String, String> map=new HashMap<>();
			map.put("email", email);
			map.put("start", start+"");
			map.put("end", end+"");
			map.put("type", type);
			map.put("keyword", keyword);
			List<StatVO> arr=ses.selectList(NS+".showUserStat", map);
			return arr;
		} finally {
			close();
		}
	}
	/*
	public List<StatVO> showUserStat(String email) {
		try {
			ses=this.getSessionFactory().openSession(true);
			List<StatVO> arr=ses.selectList(NS+".showUserStat", email);
			return arr;
		} finally {
			close();
		}
	}*/
	
}
