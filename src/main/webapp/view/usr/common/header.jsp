<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"
	integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<a href="/">홈</a>
	<a href="/usr/article/list">리스트</a>
	
	<c:if test="${sessionScope.loginedMemberId == null }">
		<a href="/usr/member/join">회원가입</a>
		<a href="/usr/member/login">로그인</a>
	</c:if>
	<c:if test="${sessionScope.loginedMemberId != null }">
		<a href="/usr/member/logout">로그아웃</a>
	</c:if>