<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>新規登録</title>
		<link rel="stylesheet" type="text/css" href="css/UserSignUp.css">
	</head>
	<body>
	   <div class="form-wrapper">
	       <header><h1>${userInfo.name}　さん  <a href="LogoutServlet">ログアウト</a></h1></header>
		   <h2>ユーザ新規登録</h2>
		   	   	<c:if test="${errMsg != null}" >
		  			  <div class="alert alert-danger" role="alert">
		    			<FONT color="#ff0000" >${errMsg}</FONT>
					  </div>
				</c:if>
		   	<form action="UserSignUpServlet" method="post">
			   <div class="form-item">
			     <label for="ID"></label>
			     <input type="text" name="loginID" placeholder="ログインID"></input>
			   </div>
			   <div class="form-item">
			      <label for="passworda"></label>
			      <input type="password" name="passworda" placeholder="パスワード"></input>
			   </div>
			   <div class="form-item">
				<label for="passwordb"></label>
				<input type="password" name="passwordb" placeholder="パスワード(確認)"></input>
			   </div>
			   <div class="form-item">
			     <label for="user_name"></label>
			     <input type="text" name="name" placeholder="ユーザ名"></input>
			   </div>
			   <div class="form-item">
			     <label for="birthday"></label>
			     <input type="text" name="birthday" placeholder="生年月日"></input>
			   </div>
			   	<div class="button-panel">
			     <input type="submit" class="button" title="登録" value="登録"></input>
			   </div>
			   <div class="戻る">
		  		 <p><a href="UserListServlet">戻る</a></p>
	  		   </div>
		   </form>
	   </div>
	</body>
</html>