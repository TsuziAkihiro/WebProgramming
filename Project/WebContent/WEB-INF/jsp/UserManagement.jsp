<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
	<head>
		<meta charset="UTF-8">
		<title>ログイン</title>
		<link rel="stylesheet" type="text/css" href="css/UserManagement.css">
	</head>
<body>
<div class="form-wrapper">
	  <h1>ユーザ管理システム</h1>
	  <form>
	    <div class="form-item">
	      <label for="text"></label>
	      <input type="text" name="ログインID" placeholder="ログインID"></input>
	    </div>
	    <div class="form-item">
	      <label for="password"></label>
	      <input type="password" name="パスワード" placeholder="パスワード"></input>
	    </div>
	    <div class="button-panel">
	      <input type="submit" class="button" title="ログイン" value="ログイン"></input>
	    </div>
	  </form>
</div>
</body>
</html>