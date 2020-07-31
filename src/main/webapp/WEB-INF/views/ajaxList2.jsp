<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script type="text/javascript">
		
		
		
		
		
		function getAjaxList() {
			
				/* var url = "restful/after.json"; */
				var url = "${pageContext.request.contextPath}/restful/after.json";
				console.log(url);
			
				$.ajax({  				/* jQuery 안에 ajax 함수 */
					url: url,
					type: 'GET', 		/* 반드시 대문자로 들어가야함 GET 이나 POST */
					cache: false, //이걸 안쓰거나 true 하면 수정해도 값 반영이 잘 안될 때가 있음
					dataTypa: 'json',
					//data: "id: "abcd"",   //지금은 데이터가 없으니깐 삭제(주석처리)
					success: function (result) { //성공하면 result로 데이터 받아옴
						console.log(result);
					
					
					
					
						var htmls="";
			        	$("#list-table").append($('<tr>')); // 
						$("<tr>" , {
							html : "<td>" + "번호" + "</td>"+  // 컬럼명들
									"<td>" + "이름" + "</td>"+
									"<td>" + "제목" + "</td>"+
									"<td>" + "날짜" + "</td>"+				
									"<td>" + "히트" + "</td>"
						}).appendTo("#list-table") // 이것을 테이블에붙임
						
						$(result).each(function () { /* 가지고 올 수 있는 만큼 돔 $(result).each(function (index,items) 이렇게 써줘도되고 뒤에 삭제해줘도댐  저거 할거면 this.bid 말고 item.bid 로해도됨*/
							htmls += '<tr>';
			            	htmls += '<td>'+ this.bId + '</td>';
			            	htmls += '<td>'+ this.bName+ '</td>';
			            	htmls += '<td>';
						
			            	for(var i=0; i < this.bIndent; i++){
			            		htmls += '-'
			            	}
			            	
			            	htmls += '<a href="${pageContext.request.contextPath}/content_view?bId=' + this.bId + '">' + this.bTitle + '</a></td>';
				            htmls += '<td>'+ this.bDate + '</td>';
				            htmls += '<td>'+ this.bHit + '</td>';
				            htmls += '</tr>';
				            /* ajax에서는 jstl 안됨 EL로 안넘어옴 foreach는 */
						});
						
						htmls += '<tr>';
						htmls += '<tr>';
						htmls += '</tr>';
						//jsp 값을 javascript 에서 쓸수 있는 방법
						
							//javascript 안에 jstl 문법이 들어 갔음
/* 							<c:forEach var="boardVO" items="${list}" >
								htmls += '<tr>';
				            	htmls += '<td>'+ '${boardVO.bId}' + '</td>';
				            	htmls += '<td>'+ '${boardVO.bName}'+ '</td>';
				            	htmls += '<td>';
				            	<c:forEach begin="1" end="${boardVO.bIndent}">
				            		htmls += '-';
				            	</c:forEach>
				            	htmls += '<a href="${pageContext.request.contextPath}/content_view?bId=' + '${boardVO.bIndent}' + '">' + '${boardVO.bTitle}' + '</a></td>';
					            htmls += '/<td>';
					            htmls += '${boardVO.bDate}';
					            htmls += '${boardVO.bHit}';
							</c:forEach>      */                  	
							
							
						$("#list-table").append(htmls);					
						
					
					
					
					
					
					},
					error: function(request,status,error){
			        	alert("실패");
			        	console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
					}
				});
				
				/* 파일을 가져오기 전까지 이 함수(ajax)에서 멈추는게아님 뒤에 이렇게 있으면 */
				/* 기다리지 않고  */
				/* 
				for(var i=0; i<100000000000; i++){
					console.log("이렇게 뒤에 뭐가 있으면")
				} 
				*/
		</script>
		
		<script>
			$(document).ready(function () {
				getAjaxList();
			});
		</script>
		
	</head>
		<body>
		
		
			<table id="list-table" width="500" cellpadding="0" cellspacing="0" border="1">

			</table> 

			
		</body>
		
</html>

