<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<c:set var="pageTitle" value="회원가입"/>

<%@include file="/view/usr/common/header.jsp" %>
	
	<script>
		const submitForm = function(form) {
			form.loginId.value = form.loginId.value.trim();
			form.loginPw.value = form.loginPw.value.trim();
			form.loginPwChk.value = form.loginPwChk.value.trim();
			form.name.value = form.name.value.trim();
			
			if(form.loginId.value.length == 0) {
				alert("아이디 입력해 주세요");
				form.loginId.focus();
				return false;
			}
			if(form.loginPw.value.length == 0) {
				alert("비밀번호를 입력해 주세요");
				form.loginPw.focus();
				return false;
			}
			if(form.loginPw.value != form.loginPwChk.value) {
				alert("비밀번호가 틀립니다");
				form.loginPw.value = '';
				form.loginPw.focus();
				return false;
			}
			
			
			if(form.name.value.length == 0) {
				alert("이름 입력해 주세요");
				form.name.focus();
				return false;
			}
			
			return true;
		}

	</script>
	
	<form action="/usr/member/doJoin" method="post" onsubmit="return submitForm(this)">
		<table border="1">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="loginId"/></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="text" name="loginPw"/></td>
			</tr>
			<tr>
				<th>비밀번호 확인</th>
				<td><input type="text" name="loginPwChk"/></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<button>회원가입</button>
				</td>
			</tr>
		</table>
	</form>


<%@include file="/view/usr/common/footer.jsp" %>