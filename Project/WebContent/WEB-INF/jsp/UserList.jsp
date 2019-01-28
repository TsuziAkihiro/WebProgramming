<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
	<html lang="ja">
	<head>
		<meta charset="UTF-8">
		<title>ユーザ一覧</title>
		<link rel="stylesheet" type="text/css" href="css/UserList.css">
	</head>
<body>
	<div class="form-wrapper">
	    <header><h1>${userInfo.name}　さん　<a href="LogoutServlet">ログアウト</a></h1></header>
		  <h2>ユーザ一覧</h2>
		  <form action="UserListServlet" method="post">
		    <div class="新規登録">
			  		 <p><a href="UserSignUpServlet">新規登録</a></p>
		  		   </div>
		    <div class="form-item">
		      <label for="ID"></label>
		      <input type="text" name="loginID" placeholder="ログインID"></input>
		    </div>
		    <div class="form-item">
				     <label for="user_name"></label>
				     <input type="text" name="name" placeholder="ユーザ名"></input>
			</div>
			<h3>生年月日</h3>
		    	<div class="Birthdays">
		    		<div class="form">
						     <label for="Birthday1"></label>
						     <input type="text" name="birthday1" placeholder="年/月/日"></input>
					</div>
					<h4>〜</h4>
					<div class="form">
						     <label for="Birthday2"></label>
						     <input type="text" name="birthday2" placeholder="年/月/日"></input>
					</div>
				</div>
		    <div class="button-panel">
		      <input type="submit" class="button" title="検索" value="検索"></input>
		    </div>
		  </form>
		  <hr>
			<table class="msr_table02">
			  <thead>
			    <tr>
			      <th>ログインID</th>
			      <th>ユーザ名</th>
			      <th>生年月日</th>
			      <th></th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach var="user" items="${userList}" >
			    <tr>
			      <td>${user.loginId}</td>
			      <td>${user.name}</td>
			      <td>${user.birthDate}</td>
			      <td><a href="UserReferenceServlet?id=${user.id}" class="square_btn1">詳細</a>
				  <c:if test = "${userInfo.loginId == 'admin'||userInfo.loginId == user.loginId}">
			     	　<a href="UserUpdateServlet?id=${user.id}" class="square_btn2">更新</a>
			        </c:if>
			      <c:if test = "${userInfo.loginId == 'admin'}">
			      	　<a href="UserDeleteServlet?id=${user.id}" class="square_btn3">削除</a>
			      </c:if>
			      </td>
			    </tr>
			    </c:forEach>
			  </tbody>
			</table>
		</div>
	</body>
</html>