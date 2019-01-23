<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>情報更新</title>
		<link rel="stylesheet" type="text/css" href="css/UserUpdate.css">
	</head>
	<body>
	   <div class="form-wrapper">
	   	   	<c:if test="${errMsg != null}" >
		    <div class="alert alert-danger" role="alert">
			  ${errMsg}
			</div>
		</c:if>
	       <header><h1>${userInfo.name}　さん  <a href="LogoutServlet">ログアウト</a></h1></header>
		   <h2>ユーザ情報更新</h2>
		   	<form>
			   <div class="form-item">
			    <h3>ログインID:${userInfo.loginId}</h3>
			   </div>
			   <div class="form-item">
			      <label for="password1"></label>
			      <input type="password" name="パスワード" required="required" placeholder="パスワード"></input>
			   </div>
			   <div class="form-item">
				<label for="password2"></label>
				<input type="password" name="パスワード(確認)" required="required" placeholder="パスワード(確認)"></input>
			   </div>
			   <div class="form-item">
			     <label for="user_name"></label>
			     <input type="text" name="ユーザ名" required="required" placeholder="ユーザ名"></input>
			   </div>
			   <div class="form-item">
			     <label for="Birthday"></label>
			     <input type="text" name="生年月日" required="required" placeholder="生年月日"></input>
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