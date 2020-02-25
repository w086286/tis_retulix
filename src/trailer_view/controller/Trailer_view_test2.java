package trailer_view.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import common.controller.AbstractAction;
import trailer_view.domain2.Trailer_view2;
import trailer_view.persistence.Trailer_view_DAOMyBatis;

import java.lang.reflect.Type;
public class Trailer_view_test2 extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Gson gson = new Gson(); 
		String mm =	req.getParameter("test");
  
		  Type userListType = new TypeToken<List<Trailer_view2>>(){}.getType();
		  List<Trailer_view2> Array = gson.fromJson(mm, userListType);  
		  Trailer_view_DAOMyBatis dao = new Trailer_view_DAOMyBatis();
		  int result =  dao.updateIdx(Array);
		  
		  this.setViewPage("dbRefresh.jsp");
			this.setRedirect(false);

	}

}
