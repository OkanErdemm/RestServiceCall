<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rest Service Call</title>
</head>
<body>
	<br>
	<br>
	<div align="center">
		<h3 style="color: blue;">172.20.27.70 Tomcat Sunucundan Rest Servise İstek Atma</h3>
	<img src="/ivr-restservice-call/Tomcat.jpg" alt="Tomcat"/>	
</a>
	</div>

	<br>
	<br>
	<br>
	<br>
	<form:form action="curl" method="post" modelAttribute="propertys">

		<form:label path="url"><b>URL:</b></form:label>
		<br>
		<form:input path="url" />
		<p style="color: red;">
			<small>istek atılacak web servis url bilgisi içermelidir</small>
		</p>
		<br>
		<form:label path="token"><b>Token:</b></form:label>
		<br>
		<form:input path="token" />
		<p style="color: red;">
			<small>web servis token istemiyorsa bos bırakılmalı!!!</small>
		</p>
		<br>
		<form:label path="method"><b>Method:</b></form:label>
		<br>
		<form:input path="method" />
		<p style="color: red;">
			<small>web servis hangi method'u kullanıyor Get veya Post?</small>
		</p>
		<br>
		<form:label path="header"><b>Parameters:</b></form:label>
		<br>
		<form:input path="header" />
		<p style="color: red;">
			<small>header da gönderilecek parametre bilgileri.</small>
		</p>
		<br>
		<form:label path="body"><b>Body:</b></form:label>
		<br>
		<form:input path="body" />
		<p style="color: red;">
			<small>body de gönderilecek bilgiler.</small>
		</p>
		<br>
		<form:button><b>Send</b></form:button>
		<br>
		<br>
	</form:form>
	<h2></h2>
</body>
</html>