<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>情報参照</title>
		<link rel="stylesheet" type="text/css" href="css/UserReference.css">
	</head>
<body>
	<div class="form-wrapper">
	   	 <header><h1>${userInfo.name}　さん  <a href="LogoutServlet">ログアウト</a></h1></header>
		   <h2>ユーザ情報詳細参照</h2>
		 <div class="con">
		   <div class="text">
		   	<h3>ログインID</h3>
		   	<span>${user.loginId}</span>
		   </div>
		   <div class="text">
		   	<h3>ユーザ名</h3>
		   	<span>${user.name}</span>
		   </div>
		   <div class="text">
		   	<h3>生年月日</h3>
		   	<span>${user.birthDate}</span>
		   </div>
		   <div class="text">
		   	<h3>登録日時</h3>
		   	<span>${user.createDate}</span>
		   </div>
		   <div class="text">
		   	<h3>更新日時</h3>
		   	<span>${user.updateDate}</span>
		   </div>
		  </div>
		   <div class="戻る">
		  	<p><a href="UserListServlet">戻る</a></p>
	  	   </div>
	</div>
	</body>
</html>