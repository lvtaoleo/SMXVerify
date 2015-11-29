<%@page import="com.yinwenqi.db.DataBase"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	System.out.println(request.getSession().getId());
System.out.println(request.getSession().getLastAccessedTime());
System.out.println(request.getSession().toString());
	String path = request.getContextPath(); 
	String lastLoginTime = DataBase.lastLoginTime;
	String cryptMode = DataBase.cryptMode;
	// 获得项目完全路径（假设你的项目叫MyApp，那么获得到的地址就是 http://localhost:8080/MyApp/）: 
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
    System.out.println(basePath);
%> 
<html dir="ltr" lang="zh_CN">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
		<title>JavaScript版国密算法的实现</title>
	
		<!--- CSS --->
		<link rel="stylesheet" href="<%=basePath%>/views/css/style.css" type="text/css" />

	</head>

	<body>
<%-- 		<div class="username-field">
			<input type="text" name="aaa" value="${key}" />
		</div>
	    <div class="username-field">
			<input type="text" name="bbb" value="CCCCCCCCCCCCCCC" />
		</div> --%>
		<div id="container">
			<div class="welcome">
				<div class="welcome-user">欢迎回来，yinwenqi</div>
				<div class="welcome-text">--这是一个WEB程序，用来验证SSL VPN的实现，本次登陆时间为<%=lastLoginTime%>,--您使用的登陆验证算法是<%=cryptMode%></div>
				<div class="home"><a href="login.jsp">退出</a></div>
			</div>
		</div>
		<div id="footer">
			基于国密算法的SSL VPN安全通信协议的设计与实现   <a href="http://www.mycodes.net/" target="_blank" title="关于"></a>
		</div>
	</body>
</html>
