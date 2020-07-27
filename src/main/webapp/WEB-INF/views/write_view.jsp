<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		 <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  	<form action="write.do" method="post">
						<tr>
							<td> 이름 </td>
							<td> <input type="text" name="bName" size = "50"> </td>
						</tr>
						<tr>
							<td> 제목 </td>
							<td> <input type="text" name="bTitle" size = "50"> </td>
						</tr>
						<tr>
							<td> 내용 </td>
							<td> <textarea name="bContent" rows="10" ></textarea> </td>
						</tr>
						<tr >
							<td colspan="2"> <input type="submit" value="입력"> &nbsp;&nbsp; <a href="list.do">목록보기</a></td>
						</tr>
					</form>
                </table>
	</body>
</html>