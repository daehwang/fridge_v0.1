<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-8" style="position:relative; top:0px; left:200px;">
          <br><br><br>
            <form:form action="${initParam.root}member_update.do" commandName="memberVO" id="updForm" class="form-horizontal" role="form">
               <input type="hidden" name="id" value="${sessionScope.mvo.id }">
  				<input type="hidden" name="gender" value="${sessionScope.mvo.gender }">
   				  <input type="hidden" name="level" value="${sessionScope.mvo.level }">
              <div class="form-group">
                <div class="col-sm-3">
                  <label for="inputEmail3" class="control-label">Id</label>
                </div>
                <div class="col-sm-2">
					  <h4>${sessionScope.mvo.id }</h4>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-3">
                  <label for="inputPassword3" class="control-label">변경할 패스워드</label>
                </div>
                <div class="col-sm-3">                  
                   <form:password class="form-control" path="password" id="password3" placeholder="Password"/>
  					 <font color="red"><form:errors id="pass_error" path="password"></form:errors></font>
  						<span id="passwordSizeView"></span>
                </div>
                 
              </div>
              
              <div class="form-group">
                <div class="col-sm-3">
                  <label for="inputPassword3" class="control-label">변경할 패스워드 확인</label>
                </div>
                <div class="col-sm-3">
                  <input type="password" class="form-control" id="password4" placeholder="Password Check">
                </div>
                <font color="red"><form:errors id="pass_error" path="password"></form:errors></font>
   				<span id="passwordCheckView"></span>
              </div>
              <div class="form-group">
                <div class="col-sm-3">
                  <label for="inputPassword3" class="control-label">이름</label>
                </div>
                <div class="col-sm-2">
                	<form:input path="name" id="name" class="form-control" placeholder="Name" disabled="disabled"
                	value="${sessionScope.mvo.name }"/>                 
                </div>
                <font color="red"><form:errors id="id_error" path="name"></form:errors></font>
              </div>
              <div class="form-group">
                <div class="col-sm-3">
                  <label for="inputPassword3" class="control-label">닉네임</label>
                </div>
                <div class="col-sm-2">
                 <form:input path="nick" value="${sessionScope.mvo.nick }" class="form-control" id="nick" placeholder="Nick name"
                  disabled="disabled"/>
                </div>
                <font color="red"><form:errors path="nick"></form:errors></font>
              </div>
              <div class="form-group">
                <div class="col-sm-3">
                  <label for="inputEmail3" class="control-label">e-mail</label>
                </div>
                <div class="col-sm-4">
                 <form:input path="email" id="email" value="${sessionScope.mvo.email }" class="form-control"  placeholder="Email"
                  disabled="disabled"/>
                </div>
                  <font color="red"><form:errors path="email"></form:errors></font>
              </div>
              <div class="form-group">
                <div class="col-sm-3">
                  <label for="inputPassword3" class="control-label">질문</label>
                </div>
                <div class="col-sm-3">가장 좋아하는 요리는?</div>
              </div>
              <div class="form-group">
                <div class="col-sm-3">
                  <label for="inputPassword3" class="control-label">답변</label>
                </div>
                <div class="col-sm-7">
                   <form:input path="answer" id="answer" value="${sessionScope.mvo.answer }" class="form-control"  placeholder="Password"
                  disabled="disabled"/>
                </div>
                <font color="red"><form:errors path="email"></form:errors></font>
              </div>
              <div class="col-md-12 text-center">
                <a class="btn btn-info btn-sm" id="updateFinishBtn">수정완료</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a class="btn btn-danger btn-sm" id="resetBtn">초기화</a><br><br><br><br>
              </div>
              </form:form>
          </div>
        </div>
      </div>
    </div>