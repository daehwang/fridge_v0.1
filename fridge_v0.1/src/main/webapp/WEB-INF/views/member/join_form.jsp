<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- Spring Expression Language (SpEL) 선언부 --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12" style="position:relative; top:0px; left:200px;">
          <br><br><br>
            <form:form action="${initParam.root}member_register.do" commandName="memberVO" id="regForm" class="form-horizontal" role="form">
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputEmail3" class="control-label">Id</label>
                </div>
                <div class="col-sm-2">
                   <form:input path="id" id="id" class="form-control"  placeholder="Id"/>
                   					
                </div>
                <span id="idCheckView"></span>
                <div class="col-sm-offset-2 col-sm-10">
                  <p class="help-block">Id는 4자이상 10자 이하로 제한됩니다.</p>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputPassword3" class="control-label">비밀번호</label>
                </div>
                <div class="col-sm-2">
                  <form:password path="password" id="pass" class="form-control" placeholder="Password"/>
                </div>
                 <font color="red"><form:errors id="pass_error" path="password"></form:errors></font>
               <span id="passwordSizeView"></span>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputPassword3" class="control-label">비밀번호 확인</label>
                </div>
                <div class="col-sm-2">
                  <input type="password" class="form-control" id="password2" placeholder="Password Check">                  
                </div>
                <span id="passwordCheckView"></span>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputPassword3" class="control-label">이름</label>                  
                </div>
                <div class="col-sm-2">
                   <form:input path="name" id="name" class="form-control" placeholder="Name"/>                  
                </div>
                 <font color="red"><form:errors id="id_error" path="name"></form:errors></font>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputPassword3" class="control-label">닉네임</label>
                </div>
                <div class="col-sm-2">
                   <form:input path="nick" id="nick" class="form-control" placeholder="Nick name"/>
                </div>
                 <font color="red"><form:errors id="nick_error" path="nick"></form:errors></font>
                <span id="nickCheckView"></span>
                </div>
                <div class="form-group">
	                <div class="col-sm-2">
	                  <label for="inputEmail3" class="control-label">성별&nbsp;
	                    <br>
	                  </label>
	                </div>
                <div class="col-sm-5">
                	남   <input type="radio" value=1 name="gender" id="gender">
		            여   <input type="radio" value=2 name="gender" id="gender"> 
		            <font color="red"><form:errors path="gender"></form:errors></font>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputEmail3" class="control-label">e-mail&nbsp;
                    <br>
                  </label>
                </div>
                <div class="col-sm-4">
                   <form:input path="email" id="email" type="email" class="form-control" placeholder="Email"/>
                   <font color="red"><form:errors path="email"></form:errors></font>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputPassword3" class="control-label">질문</label>
                </div>
                <div class="col-sm-7">
                  가장 좋아하는 요리는?
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputPassword3" class="control-label">답변</label>
                </div>
                <div class="col-sm-7">
                   <form:input path="answer" id="answer" class="form-control" placeholder="Answer"/>
                   <font color="red"><form:errors path="answer"></form:errors></font><br>   
 					아이디/비밀번호 찾기에 사용됩니다.
                </div>
              </div>      
                  
           </form:form>
             
          </div>
          <div class="col-md-12 text-center">
                <button class="btn btn-info btn-sm" id="submitBtn">회원가입</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a class="btn btn-danger btn-sm" id="cancelBtn">취소</a>
              </div>  
        </div>
      </div>
    </div>