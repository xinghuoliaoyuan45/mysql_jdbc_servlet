<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
    <form action="${pageContext.request.contextPath}/servlet/Addperson">
   name:<input type="text" name="name" id="name" /><br>
   age:<input type="text" name="age" id="age" /><br>
   description:<input type="text" name="description" id="description" /><br>
   <input type="submit" value="提交增加"/>
  </form>
   <hr>
   <a href="http://localhost:8080/mysql_jdbc_servlet/index.html">首页</a>

  </body>
</html>
