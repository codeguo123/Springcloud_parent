<%--<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Title</title>
</head>
<%-- <base href="<%=basePath%>"> --%>
<%--<meta http-equiv="Content-Type" content="text/html charset=gb2312">--%>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<script>

    function jump(){

        var username = document.getElementById("form-username").value;
        var password = document.getElementById("form-password").value;

        $.ajax({
            url : "loginGzy", //登录接口
            type : 'POST',   //
            dataType : 'json',
            data : {"username":username,"password":password},

            success : function(result) {
                if(result==2){
                    alert("账号密码不能为空");
                }else if(result==1){
                    alert("账号或密码不正确");
                }else if(result==3)
                {
                    alert("登录成功");
                    window.location.href = "index";  //进入到下一个网页
                    //window.open("index"); //重新弹出一个网页
                }
            },
            /*XMLHttpRequest, textStatus, errorThrown*/
            error : function() {
                alert('error')
            }
        })

    }

</script>
<body>
帐号：<input type="text" name="username" id="form-username"  /><br/>
密码：<input type="password" name="password" id="form-password"  /><br/>
<button onclick="jump()"class="btn">登录</button>
</body>
</html>
