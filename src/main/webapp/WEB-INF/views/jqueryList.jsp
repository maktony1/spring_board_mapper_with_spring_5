<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script type="text/javascript">
	function makeList() {
			var htmls="";
			
        	$("#list-table").html(""); // 

			$("<tr>" , {
				html : "<td>" + "번호" + "</td>"+  // 컬럼명들
						"<td>" + "이름" + "</td>"+
						"<td>" + "제목" + "</td>"+
						"<td>" + "날짜" + "</td>"+				
						"<td>" + "히트" + "</td>"
			}).appendTo("#list-table") // 이것을 테이블에붙임
			
			//jsp 값을 javascript 에서 쓸수 있는 방법
			
				//javascript 안에 jstl 문법이 들어 갔음
				<c:forEach var="boardVO" items="${list}" >
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
				</c:forEach>                       	
				
				
			$("#list-table").append(htmls);					
	        	
	}//end	getList()	
	</script>
	
	<script>
		$(document).ready(function(){
			makeList();
		});
	</script>

</head>
<body>
	<table id="list-table" width="500" cellpadding="0" cellspacing="0" border="1">
	</table>
</body>
</html>



<%-- 

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>Insert title here</title>
	       <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	       <script type="text/javascript">
		      function makeList() {
		         
		         var htmls = "";   
		   
		         $("#table_list").html("");  //자식 태그 가져오는거
		         
		         $("<tr>", {
		             html : "<td>" +"번호"+ "</td>"+
		                    "<td>" +"이름" + "</td>" +
		                    "<td>" +"제목" + "</td>" +
		                    "<td>" +"날짜" + "</td>" +
		                    "<td>" +"조회수" + "</td>" 
		          }).appendTo("#table_list")      //이것을 테이블에 붙임
		         
		         //jsp 값을 javascipt 에서 쓸 수 있는 방법
		         
		         //javascript 안에 jstl 문법이 들어감??
		            <c:forEach var= "vo" items="${list}">
	               htmls += '<tr>';
	               htmls += '<td>' + '${vo.bId}'+ '</td>';
	               htmls += '<td>' + '${vo.bName}'+ '</td>';
	               htmls += '<td>';
	               <c:forEach begin="1" end="${vo.bIndent}">
	                  htmls += '-';
	               </c:forEach>
	               htmls += '<a href = "${pageContext.request.contextPath}/content_view?bId=${vo.bId}">${vo.bTitle}</a>';
	               htmls += '</td>';
	               htmls += '<td>' +'${vo.bDate}' +'</td>';
	               htmls += '<td>' + '${vo.bHit}'+ '</td>'; 
	            </c:forEach>
	            
	            $("#table_list").append(htmls);
	      }
	      </script>
		      
	      <script>
	         $(document).ready(function(){           
	        	 makeList();
	         });
	      </script>
		</head>
			<table id="list-table" width="500" cellpadding="0" cellspacing="0" border="1">
			</table>
		<body>
		</body>
	</html> 
	
--%>