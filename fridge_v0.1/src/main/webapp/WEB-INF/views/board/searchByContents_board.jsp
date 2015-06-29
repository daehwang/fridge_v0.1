<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글목록</title>
<link rel="stylesheet" href="${initParam.root}/css/board.css" type="text/css">
</head>
<body>
<br><br>
    <div class="section">
      <div class="container" >
        <div class="row">
          <div class="col-md-8 text-center"  style="position:relative; top:0px; left:200px;">
          <h2 class="text-center">자유 게시판</h2><br><br><br>
          <form class="text-left" name="categoryForm">
                    <select name="category" id="category">
                     <option value="">----</option>
                     <option value="요리후기">요리 후기</option>
                     <option value="자유게시판">자유게시판</option>
                     <option value="공지사항">공지사항</option>
                      <option value="all">전체보기</option>
                  </select>
                  <input type="button" id="searchByCategoryBtn" value="검색">
                  </form>
            <table class="table table-bordered table-hover">
            
              <thead>
                <tr>
                  <th class="active text-center">No</th>
                  <th class="info text-center">제목</th>
                  <th class="info text-center">닉네임</th>
                  <th class="info text-center">작성일</th>
                  <th class="info text-center">HITS</th>
               
              </thead>
              <tbody>
                <tr>
             <c:forEach var="bvo" items="${requestScope.lvo.list}">      
         <tr>
         <c:if test="${bvo.category=='공지사항'}">
             <td>${bvo.boardNo }</td>               
            <td>               
                     <a href="${initParam.root}showContent.do?boardNo=${bvo.boardNo }">★[${bvo.category}] ${bvo.title}</a>
            </td>
            <td>${bvo.nick }</td>
            <td>${bvo.postDate }</td>
            <td>${bvo.hits }</td>
            </c:if>
         </tr>      
         </c:forEach>
         <c:forEach var="bvo" items="${requestScope.lvo.list}">      
         <tr>
         <c:if test="${bvo.category!='공지사항'}">
             <td>${bvo.boardNo }</td>               
            <td>               
                     <a href="${initParam.root}showContent.do?boardNo=${bvo.boardNo }">[${bvo.category}] ${bvo.title}</a>
            </td>
            <td>${bvo.nick }</td>
            <td>${bvo.postDate }</td>
            <td>${bvo.hits }</td>
               </c:if>
         </tr>      
         </c:forEach>
             
             

              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>

   <div class="col-md-12 text-center">
             <ul class="pagination">

               <c:if test="${requestScope.lvo.pagingBean.previousPageGroup}">
                  <li><a
                     href="${initParam.root}searchByContents.do?pageNo=${requestScope.lvo.pagingBean.startPageOfPageGroup-1}">Prev</a>
                  </li>
               </c:if>
               <c:forEach var="i"
                  begin="${requestScope.lvo.pagingBean.startPageOfPageGroup}"
                  end="${requestScope.lvo.pagingBean.endPageOfPageGroup}">
                  <c:choose>
                     <c:when test="${requestScope.lvo.pagingBean.nowPage!=i}">
                        <li><a              
                           href="${initParam.root}searchByContents.do?pageNo=${i}">${i}</a>
                        </li>
                     </c:when>
                     <c:otherwise>
                        <li><a href="#">${i}</a></li>
                     </c:otherwise>
                  </c:choose>
               </c:forEach>
               <c:if test="${requestScope.lvo.pagingBean.nextPageGroup}">
                  <li><a
                     href="${initParam.root}searchByContents.do?pageNo=${requestScope.lvo.pagingBean.endPageOfPageGroup+1}">Next</a>
                  </li>
               </c:if>
            </ul>
            </div>
            <br><br>
            <div class="col-md-12 text-center">
     <form name="searchForm">
   	 <select name="searchCategory" id="searchCategory">
   	 	<option value="">----</option>
   	 	<option value="title">제목</option>
   	 	<option value="writer">글쓴이</option>
   	 	<option value="contents">내용</option>
   	 </select>
   	 <input type="text" id="searchContent">
   	 <input type="button" value="검색"  id="searchBtn">
   	 </form>
	<br><br>
     <a class="btn btn-primary" href="${initParam.root}registerBoardForm.do?BoardNo=${requestScope.vo.boardNo}">글쓰기 </a>
   </div>
</body>
</html>

