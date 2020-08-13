<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Insert title here</title>
	</head>
	<body>
			<table width="500" cellpadding="0" cellspacing="0" border="1">
				<tr>
					<td>사원번호</td>
					<td>사원명</td>
					<td>직책</td>
					<td>매니저</td>
					<td>입사일</td>
					<td>연봉</td>
					<td>보너스</td>
					<td>부서번호</td>
				</tr>
				<c:forEach items="${emplist}" var="vo">
					<tr>
						<td>${vo.empno}</td>
						<td>${vo.ename}</td>
						<td>${vo.job}</td>
						<td>${vo.mgr}</td>
						<td>${vo.hiredate}</td>
						<td>${vo.sal}</td>
						<td>${vo.comm}</td>
						<td>${vo.deptno}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="8"> <a href="write_view">글작성</a> </td>
				</tr>
			</table>
	</body>
</html>