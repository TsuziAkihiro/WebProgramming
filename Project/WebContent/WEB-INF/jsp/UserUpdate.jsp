<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.User" %>
<!DOCTYPE html>
<html lang="ja">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>情報更新</title>
		<link rel="stylesheet" type="text/css" href="css/UserUpdate.css">
	</head>
	<body>
<%
// リクエストスコープからインスタンスを取得
User u = (User) request.getAttribute("user");
%>
	   <div class="form-wrapper">
	       <header><h1>${userInfo.name}　さん  <a href="LogoutServlet">ログアウト</a></h1></header>
		   <h2>ユーザ情報更新</h2>
		   		<c:if test="${errMsg != null}" >
		  			  <div class="alert alert-danger" role="alert">
		    			<FONT color="#ff0000">${errMsg}</FONT>
					  </div>
				</c:if>
		   	<form>
			   <div class="form-item">
			    <h3>ログインID:<%= u.getLoginId() %></h3>
			   </div>
			   <div class="form-item">
			      <label for="password1"></label>
			      <input type="password" name="passworda" required="required" placeholder="パスワード"></input>
			   </div>
			   <div class="form-item">
				<label for="password2"></label>
				<input type="password" name="passwordb" required="required" placeholder="パスワード(確認)"></input>
			   </div>
			   <div class="form-item">
			     <label for="user_name"></label>
			     <input type="text" name="name" required="required" placeholder="ユーザ名"></input>
			   </div>
			   <div class="form-item">
			     <label for="Birthday"></label>
			     <input type="text" name="birthday" required="required" placeholder="生年月日"></input>
			   </div>
			   	<div class="button-panel">
			     <input type="submit" class="button" title="更新" value="更新"></input>
			   </div>
			   <div class="戻る">
		  		 <p><a href="UserListServlet">戻る</a></p>
	  		   </div>
		   </form>
	   </div>
	</body>
</html>