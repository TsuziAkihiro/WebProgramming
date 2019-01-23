<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<meta charset="UTF-8">
		<title>ログイン</title>
		<link rel="stylesheet" type="text/css" href="css/Login.css">
	</head>
<body>
<div class="form-wrapper">
	<h1>ユーザ管理システム</h1>
		<c:if test="${errMsg != null}" >
	    <div class="alert alert-danger" role="alert">
		  <FONT color="#ff0000">${errMsg}</FONT>
		</div>
	</c:if>
	<form action="LoginServlet" method="post">
	    <div class="form-item">
	      <label for="text"></label>
	      <input type="text" name="loginId" placeholder="ログインID"></input>
	    </div>
	    <div class="form-item">
	      <label for="password"></label>
	      <input type="password" name="password" placeholder="パスワード"></input>
	    </div>
	    <div class="button-panel">
	      <input type="submit" class="button" title="ログイン" value="ログイン"></input>
	    </div>
	</form>
</div>
</body>
</html>