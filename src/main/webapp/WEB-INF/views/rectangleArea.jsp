<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<meta charset="utf-8">
		<title>Insert title here</title>
	</head>
	
	<body>
		
		<script type="text/javascript">
		
		<%
		String width=request.getParameter("width");
		out.print("width = "+width);
		String height=request.getParameter("height");
		out.print("height = "+height);
		%>
			function getArea(){
				var width  = document.getElementById('width').value;
				var height = document.getElementById('height').value;
				var area = width*height;
				console.log(area);
				
				var str="";
				str += "<p> "
			}
		
		</script>
		
		
		
		<script>
		$(document).ready(function(){
			getArea();
		});
		</script>
		
		
	</body>
</html>