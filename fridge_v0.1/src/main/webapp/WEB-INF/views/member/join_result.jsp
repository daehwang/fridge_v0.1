<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="cover">
      <div class="cover-image"></div>
      <div class="container">
        <div class="row">
          <div class="col-md-12 text-center">
          <br><br><br><br>
            <h1>가입성공!</h1>
            <br>
           <h4>${sessionScope.mvo.nick }님 <br>
			회원가입을 진심으로 환영합니다~</h4>
			<br>
            <a class="btn btn-lg btn-success" href="${initParam.root}home.do">home</a>
          </div>
        </div>
      </div>
    </div>
