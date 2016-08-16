<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>上传</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function addfile() {
			var div = document.getElementById("content");
			div.innerHTML+="<div><input type='file' name='upload_file' /><input type='button' onclick='removefile(this)' value='移除文件'/><br></div>";
		}
		function removefile(btn){
			var div = document.getElementById("content");
			div.removeChild(btn.parentNode);
		}
	</script>
  </head>
  
  <body>
  	<h1>上传</h1>
    <form action="${pageContext.request.contextPath }/upload.do" method="post" enctype="multipart/form-data">
    	<div id="content">
	    	<div><input type="file" name="upload_file" /><input type="button" onclick="removefile(this)" value="移除文件"/><br></div>
    	</div>
    	<br>
    	<input type="button" value="添加文件" onclick="addfile()" ><input type="submit" value="上传"/>
    	
    </form>
  </body>
</html>
