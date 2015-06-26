<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <center>   
 <br>
<h2>${requestScope.rvo.title}</h2><br>
${requestScope.rvo.nick}<br>
${requestScope.tag}<br><br>

<p>${requestScope.rvo.cookingTime}분</p><br>

${requestScope.rvo.contents}<br>
<br>
<a class="btn btn-danger" href="updateForm.do?recipeNo=${requestScope.rvo.recipeNo}">수정하기</a>
<a class="btn btn-danger" href="deleteRecipe.do?recipeNo=${requestScope.rvo.recipeNo}">삭제</a>
<a class="btn btn-primary" href="${initParam.root}home.do">홈으로</a><br><br><br><br><br>
</center>
