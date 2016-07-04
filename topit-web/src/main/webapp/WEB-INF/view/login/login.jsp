<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>用户登录界面</title>
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/login/css/normalize.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/login/css/login.css" />
<%@ include file="../common/common.jspf"%>
<script type="text/javascript">  
$(function(){	
	// 在被嵌套时就刷新上级窗口
	if(window.parent != window){
		window.parent.location.reload(true);
	}
	$("#loginform").submit(function() {
		$.ajax({   
					type : 'post', //表单提交类型
					url : '${pageContext.request.contextPath}/login/login.do', //表单提交目标
					data : $('#loginform').serialize(), //表单数据
					success : function(result) {
						$.messager.show({
							title : '提示信息',
							msg : result.errorDetail
						});
						if (result.errorCode == 0) {
							window.location.href = "${pageContext.request.contextPath}/main/index.do";
						}

					}
				});
		return false; //阻止表单的默认提交事件
	});	  			
});
</script>
</head>
<body>

<body>
	<section class="login-form-wrap">
	<h1>TOPIT</h1>
	<form class="login-form" method="post" id="loginform" action=" ">
		<label><input type="username" name="loginname" id="loginName"
			required placeholder="用户名"></label> <br> <label><input
			type="password" name="password" id="password" required
			placeholder="密码"></label> <input type="submit" value="登录">
	</form>
	</section>
</body>
</html>