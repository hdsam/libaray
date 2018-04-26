<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>图书管理系统</title>
    <link href="../css/navbar.css" rel="stylesheet" type="text/css">
</head>
<style>

    .content form {
        margin: 0 auto;
        width: 50%;
        display: block;
    }

    .content form .row {
        height: 30px;
        width: 600px;
        margin: 20px auto;
        font-size: 16px;
        font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
    }

    .content form .row > input {
        width: 300px;
        height: 30px;
        font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
        text-indent: 10px;
        font-size: 16px;
    }

    .content form .row > label {
        display: inline-block;
        width: 90px;
    }

    .content form .row > label > input  {
        width: 60px;
        margin: 0 40px;
        height: 30px;

    }
    select{
        width: 60px;
        height: 30px;
    }
    .btn{

    }
</style>
<body>
<div class="header">
    <div class="brand">长江大学图书馆</div>
    <div class="username">你好！<span>${reader.rdName}</span></div>
</div>
<div class="navbar">
        	<ul>
		<c:if test="${reader.rdAdminRoles >= 8 }">
				<!-- <span>系统管理8</span> -->
				<li><a href="#">用户管理</a></li>
			</c:if>
			<c:if test="${reader.rdAdminRoles mod 8>=4 }">
				<!-- <span>借阅管理4</span> -->
				<li><a href="lendBook.jsp">借书</a></li>
				<li><a href="keepBook.jsp">续借</a></li>
				<li><a href="payBack.jsp">还书</a></li>
			</c:if>
			<c:if test="${reader.rdAdminRoles mod 4 >=2}">
				<!-- <span>图书管理2</span>-->
				<li><a href="sortBook.jsp">图书编目</a></li>
				<li><a href="addBook.jsp">新书入库</a></li>
				<li><a href="updateBook.jsp">图书信息维护</a></li>
			</c:if>
			<c:if test="${reader.rdAdminRoles mod 2 == 1}">
				<!--<span>借书证管理1</span> -->
				<li><a href="generateCard.jsp">办理借书证</a>
				<li><a href="updateCard.jsp">变更借书证</a>
			</c:if>

			<!--<span>用户管理0</span>-->
			<li><a href="loginSuccess.jsp">个人信息查询</a></li>
			<li><a href="changePassword.jsp">个人密码修改</a></li>
		</ul>
</div>
<div class="content">
	<form action="queryUserExist.action?uri=generateCard" method="post">
			<div class="row">
				<input type="text" name="rdID" placeholder="请先验证该用户是否存在"> <input type="submit" 
					value="查询" style="width: 60px;">
			</div>
		</form>
    <form role="form" class="form-horizontal" action="generateCard.action" method="post">
        <!--读者编号-->
        <div class="row">
            <label class="control-label col-sm-2 ">读者编号：</label>
            <input type="text" name="rdID"   />
        </div>
        <div class="row">
            <!--读者姓名-->
            <label class="control-label col-sm-2 ">读者姓名：</label>
            <input type="text" name="rdName" />
        </div>
        <div class="row">
            <!--性别-->
            <label class="control-label col-sm-2 ">性别：</label>
            <select class="form-control" name="rdSex">
                <option value="男" >男</option>
                <option value="女">女</option>
            </select>
        </div>
        <div class="row">
            <!--所在单位-->
            <label class="control-label col-sm-2">所在单位：</label>
            <input type="text" name="rdDept" placeholder=""/>
        </div>
        <div class="row">
            <!--电话-->
            <label class="control-label col-sm-2">电话：</label>
            <input type="text" name="rdPhone"  placeholder=""/>
        </div>
        <div class="row">
            <!--电子邮箱-->
            <label class="control-label col-sm-2">电子邮箱：</label>
            <input type="text" name="rdEmail"  placeholder=""/>
        </div>
        <div class="row">
            <!--登记日期-->
            <label class="control-label col-sm-2">登记日期：</label>
            <input type="date" name="rdDateReg"  value=""/>
        </div>

        <div class="row">
            <!-- 证件状态-->
            <label class="control-label col-sm-2">证件状态：</label>
            <select class="form-control" name="rdStatus">
                <option value="有效" class="active">有效</option>
            </select>
        </div>

        <div class="row">
            <!-- 用户类型-->
            <label class="control-label col-sm-2">用户类型：</label>
            <select class="form-control" name="rdType">
                <option value="10" class="active">教师</option>
                <option value="20" >本科生</option>
                <option value="21" >专科生</option>
                <option value="30" >硕士研究生</option>
                <option value="31" >博士研究生</option>
            </select>
        </div>
        <div class="row">
            <input type="submit" width="120px" style="margin-left: 40px" value="确认"/>
        </div>
    </form>
</div>
</body>
</html>