<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8" import="com.google.gson.*, trailer_view.domain.*"%>
    <%
   	 Trailer_view tmp  = (Trailer_view)request.getAttribute("mvo");
    
    	Gson gson = new Gson();
    	String result = gson.toJson(tmp);
    	System.out.println(result);
    	
    %>
<%=result%>