<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>图书管理系统</title>
    <link href="css/navbar.css" rel="stylesheet" type="text/css" >
</head>
<style>

    .content form{
        margin: 0  auto;
        width: 50%;
        display: block;
    }
    .content form .row {
       height: 30px;
       width: 600px;
        margin: 20px auto ;
        font-size: 16px;
        font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
    }
    .content form .row>input{
        width: 300px;
        height:30px;
        font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
        text-indent: 10px;
        font-size: 16px;
    }
    .content form .row >label{
        display: inline-block;
        width: 80px;
    }
    .content form .row >label>input{
        width: 60px;
        margin:0 40px ;
        height: 30x;

    }
</style>
<body>
    <div class="header">
        <div class="brand">长江大学图书馆</div>
    </div>
        <div class="content">
            <form  action="login" method="post">
                <div class="row">
                    <label>编号：</label><input  type="text" name="username" placeholder="请输入借书证编号"/>
                </div>
                <div class="row">
                <label>密码：</label><input type="password" name="password" placeholder="请输入密码">
                </div>
                <div class="row">
                <label><input type="submit" value="登陆"/></label><label><input type="reset" value="重置"/></label>
                 </div>
            </form>
        </div>
</body>
</html>