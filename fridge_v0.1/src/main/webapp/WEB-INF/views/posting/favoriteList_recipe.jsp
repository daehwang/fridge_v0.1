<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<h3>${sessionScope.mvo.nick} 님의 favoriteList</h3>
${requestScope.result }
<table border="1" style="width: 100%">
      <tr align="center">
         <td width="5%"></td>
         <td width="15%"><b>번호</b></td>
         <td width="80%"><b>레시피</b></td>
         <!-- <td width="15%"></td> -->
      </tr>
   <tbody id="favoriteView" align="center">   
   <c:forEach items="${requestScope.lvo.list }" var="frList" varStatus="status">
      <tr>
         <td><input type="checkbox" id="chkBox" name="chkBox" value="${frList.recipeNo }"></td>
         <td>${status.count }</td>
         <td>${frList.recipeTitle}</td>
         <!-- <td><input type="button"  id="delBtn"  value="삭제"></td> -->
      </tr>

   </c:forEach>
   </tbody>
</table>
<c:set var="pb" value="${requestScope.lvo.pagingBean}"></c:set>
    <%-- 페이징빈의 getNowPage에 접근하여 출력 --%>
<!-- 
         step2 1) 이전 페이지 그룹이 있으면 이미지 보여준다. (img/left_arrow_btn.gif)
                     페이징빈의 previousPageGroup 이용 
               2)  이미지에 이전 그룹의 마지막 페이지번호를 링크한다. 
                      hint)   startPageOfPageGroup-1 하면 됨        
    -->      
   <c:if test="${pb.previousPageGroup}">
   <a href="favoriteRecipeList.do?pageNo=${pb.startPageOfPageGroup-1}">
   <!-- <img src="img/left_arrow_btn.gif"> -->
   ◀&nbsp; </a>   
   </c:if>
   <!-- step1. 1)현 페이지 그룹의 startPage부터 endPage까지 forEach 를 이용해 출력한다
               2) 현 페이지가 아니면 링크를 걸어서 서버에 요청할 수 있도록 한다.
                  현 페이지이면 링크를 처리하지 않는다.  
                  PagingBean의 nowPage
                  jstl choose 를 이용  
                  예) <a href="DispatcherServlet?command=list&pageNo=...">               
    -->      
   <c:forEach var="i" begin="${pb.startPageOfPageGroup}" 
   end="${pb.endPageOfPageGroup}">
   <c:choose>
   <c:when test="${pb.nowPage!=i}">
   <a href="favoriteRecipeList.do?pageNo=${i}">${i}</a> 
   </c:when>
   <c:otherwise>
   ${i}
   </c:otherwise>
   </c:choose>
   &nbsp;
   </c:forEach>    
   <!-- 
         step3 1) 다음 페이지 그룹이 있으면 이미지(img/right_arrow_btn.gif) 보여준다. 
                     페이징빈의 nextPageGroup 이용 
               2)  이미지에 이전 그룹의 마지막 페이지번호를 링크한다. 
                      hint)   endPageOfPageGroup+1 하면 됨        
    -->   
   <c:if test="${pb.nextPageGroup}">
   <a href="favoriteRecipeList.do?pageNo=${pb.endPageOfPageGroup+1}">
   ▶<!-- <img src="img/right_arrow_btn.gif"> --></a>
   </c:if>
<br>
<div style="float:right;">
<input type="button" id="allCheckBtn" value="전체선택">
<input type="button" id="resetBtn" value="초기화">
<input type="button" id="delBtn" value="삭제">
</div>