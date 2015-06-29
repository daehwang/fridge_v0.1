<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="section">
	<div class="container">
		<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;My Page</h2>
		<hr class="nomalHr">
		<div class="row">
			<div class="col-md-12" style="position:relative; top:0px; left:200px;">
				<form class="form-horizontal" role="form">
					<div class="form-group">
						<div class="col-sm-2">
							<label for="inputEmail3" class="control-label">Id</label>
						</div>
						<div class="col-sm-2">${sessionScope.mvo.id }</div>
					</div>
					<hr class="style-one">
					<div class="form-group">
						<div class="col-sm-2">
							<label for="inputPassword3" class="control-label">이름</label>
						</div>
						<div class="col-sm-2">${sessionScope.mvo.name }</div>
					</div>
					<hr class="style-one">
					<div class="form-group">
						<div class="col-sm-2">
							<label for="inputPassword3" class="control-label">닉네임</label>
						</div>
						<div class="col-sm-2">${sessionScope.mvo.nick }</div>
					</div>
					<hr class="style-one">
					<div class="form-group">
						<div class="col-sm-2">
							<label for="inputPassword3" class="control-label">성별</label>
						</div>
						<div class="col-sm-2">
							<c:choose>
								<c:when test="${sessionScope.mvo.gender==1}">
						     	 남자
				     	 	 </c:when>
							 <c:otherwise>
						      	여자
						      </c:otherwise>
							</c:choose>
						</div>
					</div>
					<hr class="style-one">
					<div class="form-group">
						<div class="col-sm-2">
							<label for="inputEmail3" class="control-label">e-mail</label>
						</div>
						<div class="col-sm-4">${sessionScope.mvo.email }</div>
					</div>
					<hr class="style-one">
					<div class="form-group">
						<div class="col-sm-2">
							<label for="inputPassword3" class="control-label">질문</label>
						</div>
						<div class="col-sm-2">가장 좋아하는 요리는?</div>
					</div>
					<div class="form-group">
						<div class="col-sm-2">
							<label for="inputPassword3" class="control-label">답변</label>
						</div>
						<div class="col-sm-7">${sessionScope.mvo.answer }</div>
					</div>
					<hr class="style-one">
					<div class="form-group">
						<div class="col-sm-2">
							<label for="inputPassword3" class="control-label">레벨 </label>
						</div>
						<div class="col-sm-2"><c:choose>
						   <c:when test="${sessionScope.mvo.level==6}">
						      관리자
						   </c:when>
						   <c:when test="${sessionScope.mvo.level==5}">
						      ★★★★★
						   </c:when>
						   <c:when test="${sessionScope.mvo.level==4}">
						      ★★★★
						   </c:when>
						   <c:when test="${sessionScope.mvo.level==3}">
						      ★★★
						   </c:when>
						   <c:when test="${sessionScope.mvo.level==2}">
						      ★★
						   </c:when>
						   <c:otherwise>
						      ★
						   </c:otherwise>
						</c:choose>
						</div>
					</div>
					<hr class="style-one">
					<div class="form-group">
						<div class="col-sm-2">
							<label for="inputPassword3" class="control-label">추천수 </label>
						</div>

						<div class="col-sm-2">${sessionScope.mvo.love }</div>
					</div>
					<hr class="style-one">
					
				</form>
				
			</div>
			<div class="col-md-12 text-center">
			<br><br>
						<a class="btn btn-sm btn-primary" data-toggle="modal" data-target="#updateModal"
									data-whatever="@getbootstrap">회원정보 수정</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a class="btn btn-danger btn-sm"  data-toggle="modal" data-target="#deleteModal"
									data-whatever="@getbootstrap">탈퇴</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a class="btn btn-info btn-sm" id="gobackBtn">돌아가기</a><br><br><br><br>
					</div>
		</div>
	</div>
</div>

<!-- udpate modal -->
<div class="modal fade" id="updateModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="exampleModalLabel">비밀번호 확인</h4>
			</div>
			<div class="modal-body">
				<form method="get" action="${initParam.root}member_passwordCheck_update.do" id="registerForm">					
					<div class="form-group">
						<label for="message-text" class="control-label">Password:</label>
						<input type="hidden" name="id" value="${sessionScope.mvo.id}">
						<input type="password" name="password" class="form-control">
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary">OK</button>
					</div>			
				</form>
			</div>			
		</div>
	</div>
</div>

<!-- deleteModal -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="exampleModalLabel">비밀번호 확인</h4>
			</div>
			<div class="modal-body">
				<form method="get" action="${initParam.root}member_passwordCheck_delete.do">
							
					<div class="form-group">
						<label for="message-text" class="control-label">Password:</label>
						<input type="hidden" name="id" value="${sessionScope.mvo.id}">
						<input type="password" name="password" class="form-control">
					</div>	
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary">OK</button>						
					</div>	
				</form>			
			</div>
			
		</div>
	</div>
</div>