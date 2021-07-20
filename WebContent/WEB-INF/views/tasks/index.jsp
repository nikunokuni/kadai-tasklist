<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--テンプレートを取りこむ --%>
<c:import url="../layout/app.jsp">
<%--nameがapp.jspの同じ名前の所に入る --%>
  <c:param name = "naiyou">
	<c:if test="${flush != null}">
		<div id = "flush_success">
			<c:out value="${flush}"/>
		</div>
	</c:if>
	<h2>タスク一覧</h2>
      <ul>
		<c:forEach var="task" items="${tasks}">
			<li>
			<a href="${pageContext.request.contextPath}/show?id=${task.id }">
				<c:out value="${task.id}"/>
			</a>
				:<c:out value="${task.content}"/>
			</li>
		</c:forEach>
	  </ul>
    <p><a href="${pageContext.request.contextPath}/new">新規登録</a></p>
  </c:param>
</c:import>