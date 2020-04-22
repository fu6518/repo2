<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎页面</title>
</head>
<body>
<div title="欢迎使用" style="padding:20px;overflow:hidden; color:red; " >
	<%-- <p style="font-size: 50px; line-height: 60px; height: 60px;">${admin.username}</p> --%>
	<p style="font-size: 25px; line-height: 30px; height: 30px;">欢迎使用订餐管理系统</p>
  	<p>开发人员：【小符同学】</p>
 <script type="text/javascript">
  $(function () {
       // show方法——欢迎框
        $.messager.show({
            title:'欢迎信息',
            msg:'欢迎 ${admin.username}登录系统',
            timeout:5000,
            showType:'slide'
        });
    });
  </script>
</div>
</body>
</html>