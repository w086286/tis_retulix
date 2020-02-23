package user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDAO
{
	private DataSource ds;//dbcp 커넥션풀 이용하기 위한 프로퍼티
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public UserDAO() 
	{
		try 
		{
			Context ctx=new InitialContext();
			ds=(DataSource)ctx.lookup("java:comp/env/myoracle/retulix");
			System.out.println("ds룩업 성공: "+ds);
		} 
		catch (NamingException e) 
		{
			System.out.println("ds룩업 실패..");
			e.printStackTrace();
		}
	}
	
	
	/** 아이디 중복을 체크하는 메서드 */
	public boolean idCheck(String email) throws SQLException
	{
		System.out.println("aaa");
		con = ds.getConnection();
		String sql = "select idx from member where email=?";
		ps = con.prepareStatement(sql);
		ps.setString(1, email);
		rs = ps.executeQuery();
		
		// 회원 번호가 있는 경우 >> 이미 사용중인 아이디.
		if(rs.next())
		{
			return false;
		}
		// 회원 번호가 없는 경우 >> 사용할 수 있는 아이디.
		return true;
	}
	
	
	/** 회원가입 처리를 하는 메서드. - insert문 */
	public int insertUser(UserVO user) throws SQLException
	{
		try
		{
			con = ds.getConnection();
			String sql = "insert into member idx, email, pwd, name, age, point, state "
					   + "values(member_seq.nextval, ?, ?, ?, ?, 1000, 0)";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPwd());
			ps.setString(3, user.getName());
			ps.setString(4, user.getAge());
			
			int n = ps.executeUpdate();
			return n;
		} 
		finally
		{
			close();
		}
	}
	
	
	/** 회원 정보를 가져와서 리스트를 만드는 메서드. 
	 * @throws SQLException */
	public List<UserVO> makeList(ResultSet rs) throws SQLException
	{
		List<UserVO> arr = new ArrayList<>();
		
		while(rs.next())
		{
			int idx = rs.getInt("idx");
			String email = rs.getString("email");
			String pwd = rs.getString("pwd");
			String name = rs.getString("name");
			String age = rs.getString("age");
			int point = rs.getInt("point");
			int subs = rs.getInt("subs");
			String icon = rs.getString("icon");
			String chimg = rs.getString("chimg");
			int state = rs.getInt("state");
			
			UserVO user = new UserVO(idx, email, pwd, name, age, point, subs, icon, chimg, state);
			arr.add(user);
		}
		return arr;
	}
	
	
	/** email(UK)로 회원정보를 가져오는 메서드. */
	public UserVO selectByUserid(String email) throws SQLException, NotUserException
	{
		try
		{
			con = ds.getConnection();
			String sql = "select idx, email, pwd, name, age, point, subs, icon, chimg, state from member "
					   + "where email = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			List<UserVO> arr = makeList(rs);
			
			if(arr != null && arr.size() == 1)
			{
				return arr.get(0);
			}
			else
			{
				// 예외 발생
				throw new NotUserException(email + "라는 아이디는 존재하지 않습니다.");
			}
		} 
		finally
		{
			close();
		}
	}


	/** 로그인을 처리하는 메서드. */
	public UserVO loginCheck(String email, String pwd) throws SQLException, NotUserException
	{
		// 아이디로 DB에서 회원 정보 가져오기.
		UserVO user = selectByUserid(email);
		
		// DB에서 가져온 비번과 사용자가 입력한 비번이 일치하지 않으면 예외 발생.
		if(user != null)
		{
			String dbPwd = user.getPwd();
			
			// DB에서 가져온 비번과 사용자가 입력한 비번이 일치하면 해당 UserVO를 반환.
			if(dbPwd.equals(pwd))
			{
				return user;
			}
		}
		throw new NotUserException("비밀번호가 틀립니다.");
	}
	
	
	
	


	public void close()
	{
		try
		{
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) con.close();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
