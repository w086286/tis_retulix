package trailer_view.persistence;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession; //mybatis jar�ȿ� ����
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.google.gson.Gson;

import common.domain.ReviewVO;
import trailer_view.domain.Trailer_view;
import trailer_view.domain2.Trailer_view2;

public class Trailer_view_DAOMyBatis {
	
	private final String NS = "trailer_view.persistence.Trailer_view_Mapper";

	private SqlSession ses;

	public SqlSessionFactory getSessionFactory() {
		SqlSessionFactoryBuilder builder = null;
		String resource = "common/config/mybatis-config.xml";

		try {
			InputStream is = Resources.getResourceAsStream(resource);
			builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory factory =builder.build(is);
			is.close();
			return factory;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}//-----------------------------------

	public Trailer_view selectTest()
	{
		try {
			ses=this.getSessionFactory().openSession(true);
			Trailer_view vo= ses.selectOne(NS+".test");
			
			System.out.println("get api idx"+vo.getApi_idx());
			return vo;
		
		} finally {
			close();
		}
	}
	public Trailer_view selectTest(String pp)
	{
		try {
			ses=this.getSessionFactory().openSession(true);
			Trailer_view vo= ses.selectOne(NS+".selectMv",pp);
			return vo;
		
		} finally {
			close();
		}
	}
	

	public List<Trailer_view> selectPoster(String idx) {
		try {
			ses=getSessionFactory().openSession(true);
			String checking_range = idx.substring(0,2);
			Map<String,String> map = new HashMap<>();
			map.put("not", idx);
			map.put("end","%"+checking_range+"%");
		System.out.println("asdasd : "+checking_range);
			List<Trailer_view> arr=ses.selectList(NS+".randomList",map);
			
			return arr;
		} finally {
			close();
		}
	}
	private void close()
	{
		if(ses!=null)ses.close();
	}

	public Trailer_view selectOne() {
		try {
			ses=getSessionFactory().openSession(true);
			Trailer_view vo= ses.selectOne(NS+".selerandom");
			return vo;
			
		} finally {
			close();
		}
	}

	public String selectAll() { 
		try {
			ses=getSessionFactory().openSession(true);
			Gson gson= new Gson();
			
			List<Trailer_view2> vo= ses.selectList(NS+".selectAllDb");
			String json=gson.toJson(vo);
			System.out.println(json);
			return json;
			
		} finally {
			close();
		}
		
	}

	public int updateIdx(List<Trailer_view2> array) {
		try {
			ses=getSessionFactory().openSession(true);
			int num=array.size();
			Map<String,String> map = new HashMap<>();
			System.out.println(array.get(0).getIdx()+"  "+array.get(0).getTitle());
			
			for(int i =0;i<num;i++)
			{
				map.put("i", array.get(i).getIdx());
				if(array.get(i).getTitle()==null||array.get(i).getTitle().trim().isEmpty())
				{
					String tmp ="null";
					map.put("a",tmp);
			
				}
				else
				{
					map.put("a",array.get(i).getTitle());
				
				}
				
				ses.update(NS+".updateDB_api",map);
			}
			
			return 0;
			
		} finally {
			close();
		}
	}

	public List<ReviewVO> selectReview(String idx) {
		try {
			ses=getSessionFactory().openSession(true);
			List<ReviewVO>arr = ses.selectList(NS+".selectReview",idx);
			return arr;
		} finally {
			close();
		}
	
	}

	public int find_update(String args[]) {
		try {
			ses=getSessionFactory().openSession(true);
			Map<String,String> map = new HashMap<>();
			map.put("title", args[0]);
			map.put("api_num", args[1]);
			map.put("idx", args[2]);
			int result= ses.update(NS+".update_seleted",map);
			return result;
			
		} finally {
			close();
		}
	}

	
}
