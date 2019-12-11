<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <%--jquery 注意版本--%>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script>
        function checkIt(){
            var username = document.getElementById("username").value;
            $.ajax({
                url : "register",
                type : 'POST',
                dataType : 'json',
                data : {"username":username},

                success : function(result) {
                    alert('进来咯')
                    if(result==1){
                        document.getElementById("errorAccount").innerText = "";
                        alert('账户已被注册，不可以使用');
                    } else if(result==2){
                        document.getElementById("errorAccount").innerText = "";
                        alert('账户不可以为空');
                    } else{
                        document.getElementById("errorAccount").innerText = "账户以可以使用";
                    }
                },
               /* error : function(result) {
                    console.log(result);
                    alert('请正确输入');
                }*/
            })
        }
        function checkpwd() {
            var chick=false;
            var password = document.getElementById("password1").value;
            if (password.length <= 0) {
                document.getElementById("errorAccount3").innerHTML = " 密码不能为空";
                chick=false;
            } else if(password.length<6) {
                document.getElementById("errorAccount3").innerHTML = " × 不要少于6位";
                chick=false;
            }else{
                document.getElementById("errorAccount3").innerHTML = " √";
                chick=true;
            }
            return chick;
        }
        function checkItPSW(){
            var chick=false;
            var password1 = document.getElementById("password1").value;
            var password2 = document.getElementById("password2").value;

            if(password2.length<=0){
                document.getElementById("errorAccount2").innerText = "密码不能为空";
                chick=false
            }else if(password1!=password2){
                document.getElementById("errorAccount2").innerText = "两次输入的密码不一致";
                chick=false
            }else{
                document.getElementById("errorAccount2").innerText = "√";
                chick=true;
            }
            return chick;
        }
        function chickup(){
            var chick=checkpwd()&&checkItPSW()&&checkIt();
            return chick;
        }
    </script>
</head>
<body>
<h3>注册账号</h3>
<form action="insert"  method="POST" onsubmit="return chickup()" >
    账号：<input type="text" name="username" id="username"  onchange="checkIt()" placeholder="输入用户名">
    <span id="errorAccount" style="color:red;display:inline;"></span><br/>

    密码：<input type="password" name="password1" id="password1" onchange="checkpwd()"  placeholder="输入密码">
    <span id="errorAccount3" style="color:red;display:inline;"></span><br/>

    密码：<input type="password" name="password" id="password2" onchange="checkItPSW()"  placeholder="输入密码">
    <span id="errorAccount2" style="color:red;display:inline;"></span><br/>

    邮箱：<input type="text" name="email" placeholder="输入邮箱"><br/>

    性别：男<input type="checkbox" name="gender" value="1">
    女<input type="checkbox" name="gender" value="2"><br/>

    <input type="submit"   value="提交">

</form>


</body>
</html>
