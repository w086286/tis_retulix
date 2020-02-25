<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reTuLix</title>
<link rel="stylesheet" href="./css/whole.css" /> <!-- 전체 기본 스타일 -->
<style>
    .login{
        text-align: center;
        line-height: 3em;
    }
    .login table{
        display: inline-table;
        text-align: center;
    }
    .login img{
        margin-top: 10em;
        height: 5em;
    }
    .login a:hover{
        color: rgb(209, 0, 0);
    }
</style>
</head>

<body>
    <div class="login">
	<form name="loginF" id="loginF" action="loginCheck.do" method="post">
        <img src="./images/logo-01.png"><br><br>
        <table>
            <tr>
                <td>아이디</td>
                <td>
                    <input type="email" id="email" name="email" placeholder="아이디를 입력하세요" required>
                </td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td>
                    <input type="password" id="pwd" name="pwd" placeholder="비밀번호를 입력하세요" required>
                </td>
            </tr>
        </table><br>
        <input type="checkbox" name="saveId" id="saveId" class="form-check-input"> 아이디 저장
        <input type="checkbox" name="savePwd" id="savePwd" class="form-check-input"> 비밀번호 저장<br>
        <button type="button" onclick="loginCheck()" id="btLogin" name="btLogin" class="button-active">로그인</button>
        <button type="button" onclick="loginCheck()" id="btLogin" name="btLogin">회원가입</button><br><br>
        <a href="#">아이디/비밀번호를 분실하셨습니까?</a>
    </form>
    </div>
</body>
</html>

<script>
	function loginCheck() {
		if (!loginF.email.value) {
			alert("아이디를 입력하세요");
			loginF.userid.focus();
			return;
		}
		if (!loginF.pwd.value) {
			alert("비밀번호 입력하세요");
			loginF.pwd.focus();
			return;
		}
		loginF.submit();
	}
</script>

<%
 	String key="";
 	String saveId="";
 	boolean ckflag=false;
 	
 	Cookie[] cks=request.getCookies();
 	if(cks!=null){
 		for(Cookie c:cks){
 			key=c.getName();
 			if(key.equals("saveId")){
	 			saveId=c.getValue();
	 			ckflag=true;
	 			break;
 			} else {
 				ckflag=false;
 			}
 		}
 	}
 %>