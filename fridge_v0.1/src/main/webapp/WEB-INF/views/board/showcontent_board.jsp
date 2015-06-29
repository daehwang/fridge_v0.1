<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<br><br>
<div class="section">
      <div class="container">
<div class="col-md-8 " style="position:relative; top:0px; left:200px;">

            <table class="table table-bordered" >
              <tbody>
                <tr>
                  <td colspan="4" class="info text-center">[${vo.category}] ${requestScope.vo.title}</td>
                </tr>
                <tr>
                  <td>글번호: ${requestScope.vo.boardNo}</td>
                  <td>글쓴이: ${requestScope.vo.nick}</td>
                  <td>조회수: ${requestScope.vo.hits }</td>
                  <td>${requestScope.vo.postDate}</td>
                </tr>
                <tr>
                   <td colspan="4">${requestScope.vo.contents }</td>
                </tr>
              </tbody>
              
            </table>
            
            
            <div class="col-md-12 text-center">
            <a class="btn btn-primary" href="${initParam.root}BoardList.do">목록</a>
         <c:choose>
            <c:when test="${sessionScope.mvo.nick==requestScope.vo.nick }">
       <a class="btn btn-danger" href="updateBoardForm.do?BoardNo=${requestScope.vo.boardNo}">수정 </a>
          <a class="btn btn-danger" href="deleteBoard.do?boardNo=${requestScope.vo.boardNo}">삭제</a>
           </c:when>
      </c:choose>
      <c:choose>
            <c:when test="${sessionScope.mvo.level=='6' }">
       <a class="btn btn-danger" href="updateBoardForm.do?BoardNo=${requestScope.vo.boardNo}">수정 </a>
          <a class="btn btn-danger" href="deleteBoard.do?boardNo=${requestScope.vo.boardNo}">삭제</a>
           </c:when>
      </c:choose>
      </div>

          </div></div></div>