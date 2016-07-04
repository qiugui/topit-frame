<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/icon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function(){
		$('#files').combobox({
			url : '${pageContext.request.contextPath}/fileupload/listAllFiles.do',
			valueField:'id',    
		    textField:'fileName',
		    width : 200
		});
		
		
		
		$('#downloadbtn').click(function(){
			var fileName=$('#files').combobox('getText');
			fileName=encodeURIComponent(fileName);
			if (fileName==''){
				$.messager.show ({
					title:'提示信息',
					msg : '请选择一个文件！'
				});
			} else {
				window.location.href='${pageContext.request.contextPath}/fileupload/download.do?fileName='+fileName;
				
			}
			
		});
		
	});
	
	
</script>
<title>Insert title here</title>
</head>
<body>
<p>选择模版进行下载</p>
<select id="files" class="easyui-combobox" ></select><br/>
<a id="downloadbtn" class="easyui-linkbutton">下载</a>
<p>上传用户信息表</p>
<form action="${pageContext.request.contextPath }/fileupload/upload.do" method="post" enctype="multipart/form-data">

	<input type="file" name="theFile" />
	<!-- 隐藏域，用来标记当前页面上传文档模版的名称 -->
	<input type="hidden" name="fileflag" value="userinfo" />
	<input type="submit" value="提交" />
</form>
<p>上传组织信息表</p>
<form action="${pageContext.request.contextPath }/fileupload/upload.do" method="post" enctype="multipart/form-data">

	<input type="file" name="theFile" />
	<!-- 隐藏域，用来标记当前页面上传文档模版的名称 -->
	<input type="hidden" name="fileflag" value="orginfo" />

</form>
</body>
</html>