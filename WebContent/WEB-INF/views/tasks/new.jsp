<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../layout/app.jsp">
	<c:param name ="naiyou">
		<h2>新規登録ページ</h2>

		<form method="POST" action="${pageContext.request.contextPath}/create">
			<c:import url="form.jsp"/>
		</form>

	</c:param>
</c:import>