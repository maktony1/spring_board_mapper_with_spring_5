<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script>
		function getAjaxList() {
			
			var url = "${pageContext.request.contextPath}/restful/after.json";
			
		}
		</script>
		
		
		
		
		<script>
		$(document).ready(function(){
			$('#a-delete').click(function(event){
				//prevendDefault()는 href로 연결해 주지 않고 단순히 click에 대한 처리를 하도록 해준다.
				
				event.preventDefault();//기존기능 끊을 때 여기서 이거 써야함 
				console.log("ajax 호출전 ");
				$.ajax({
				    type : "DELETE",
				    url : "${pageContext.request.contextPath}/rest/delete/" + "${content_view.bId}",
				    data:{"bId":"${content_view.bId}"},
				    success: function (result) {       
				           console.log(result); 
				           getList();               
				    },
				    error: function (e) {
				        console.log(e);
				    }
				})
				 
			});
				
		});
		</script>
	</head>
	<body>
		<table id="list" width="500" cellpadding="0" cellspacing="0" border="1">
			<form action="modify.do" method="post">
				<input type="hidden" name="bId" value="${content_view.bId}">
					<tr>
						<td> 번호</td>
						<td> ${content_view.bId}</td>
					</tr>
					<tr>
						<td> 히트</td>
						<td> ${content_view.bTitle}</td>
					</tr>
					<tr>
						<td> 이름 </td>
						<td> <input type="text" name="bName" value="${content_view.bName}"></td>
					</tr>
					<tr>
						<td> 제목 </td>
						<td> <input type="text" name="bTitle" value="${content_view.bTitle}"></td>
					</tr>
					<tr>
						<td> 내용 </td>
						<td> <textarea rows="10" name="bContent" >${content_view.bContent}</textarea></td>
					</tr>
					<tr >
						<td colspan="2"> <input type="submit" value="수정"> &nbsp;&nbsp; <a href="list.do">목록보기</a> &nbsp;&nbsp; <a id="a-delete" href="${pageContext.request.contextPath}/rest/delete?bId=${content_view.bId}">삭제</a> &nbsp;&nbsp; <a href="reply_view.do?bId=${content_view.bId}">답변</a></td>
					</tr>
			</form>
			
		</table>
	</body>
</html>