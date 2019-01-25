<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.User" %>
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>ユーザ削除</title>
	<link rel="stylesheet" type="text/css" href="css/UserDelete.css">
</head>
<body>
<%
// リクエストスコープからインスタンスを取得
User u = (User) request.getAttribute("user");
%>
	   <div class="form-wrapper">
	       <header><h1>${userInfo.name}　さん  <a href="LogoutServlet">ログアウト</a></h1></header>
		   <h2>ユーザ削除確認</h2>
		   	<form action="UserDeleteServlet" method="post">
			   <div class="削除">
				   <p>ログインID:<%= u.getLoginId() %>を</p>
				   		本当に削除してよろしいでしょうか
			   </div>
			   <div class="button-panel">
			     <a type="submit" class="button" href="UserListServlet">キャンセル</a>
			   </div>
			   <div class="button-panel">
			     <input type="submit" class="button" title="OK" value="OK"></input>
			   </div>
			   <input type="hidden" name="id" value="<%= u.getId() %>">
		   </form>
	   </div>
	</body>
</html>