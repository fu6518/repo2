<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../common/header.jsp"%>
<body> 
<div id="submitView" class="viewer clearfix" style="">
    <section class="submit_title">
        <div class="container" id="">
           
            <div class="col-md-12 clearfix">
                <div class="now_submit clearfix" style="margin-left:0px;">
                    <form id="registe-form">
        
                       
                        <div class="form-group" id="form_info">
                            <label for="phone">
                                用户名
                            </label>
                            <span class="twitter-typeahead">
                                <input type="text" id="name" name="name" class="form-control tt-query" autocomplete="off"
                                spellcheck="false" dir="auto">
                            </span>
                            <label for="name" class="mgt10">
                                密码
                            </label>
                            <span class="twitter-typeahead">
                                <input type="password" id="password" name="password" class="form-control tt-query" autocomplete="off"
                                spellcheck="false" dir="auto">
                            </span>
                            <label for="name" class="mgt10">
                               确认密码
                            </label>
                            <span class="twitter-typeahead">
                                <input type="password" id="re-password" class="form-control tt-query" autocomplete="off"
                                spellcheck="false" dir="auto">
                            </span>
                           
                        </div>
                        <div class="form-group">
                            <div class="btn_control fr">
                                <a class="btn btn-default bottommargin" id="loginSubmit">
                                登录   
                                </a>
                                <a class="btn btn-info bottommargin" id="registerSubmit">
                                     注册
                                </a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
</div>
<!-- Le javascript
    ================================================== --> 
  <!-- Placed at the end of the document so the pages load faster --> 
<script src="${pageContext.servletContext.contextPath}/resources/home/layer/layer.js"></script>
<script>
$("#loginSubmit").click(function(){
	window.location.href = 'login';
});		
$("#registerSubmit").click(function(){
	var name = $("#name").val();
	var password = $("#password").val();
	var repassword = $("#re-password").val();
	if(name == ''){
		 layer.msg("用户注册账号不能为空，请输入", {time:700, icon:2, shift:2}, function(){/* 显示框的时间，笑脸表情，抖动效果 */
         	
         }); 
		return;
	}
	if(password == ''){
		layer.msg("用户注册密码不能为空，请输入", {time:700, icon:2, shift:2}, function(){/* 显示框的时间，笑脸表情，抖动效果 */
        	
        }); 
		return;
	}
	if(password != repassword){
		layer.msg("两次输入的密码不一致，请重新输入", {time:700, icon:2, shift:2}, function(){/* 显示框的时间，笑脸表情，抖动效果 */
        	
        }); 
		return;
	}
	$.ajax({
		url:'registe',
		data:$("#registe-form").serialize(),
		type:'post',
		dataType:'json',
		success:function(data){
			if(data.type == 'success'){
				layer.msg("注册成功，请前往登陆", {time:700, icon:2, shift:2}, function(){/* 显示框的时间，笑脸表情，抖动效果 */
				window.location.href = 'login';
	            	
	            }); 
			}else{
				alert(data.msg);
			}
		}
	});
});  
</script>  
 </body>
</html>