<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<br><br>
<div class="section">
	<div class="container">
		<div class="row">
			<div class="col-md-12" style="position:relative; top:0px; left:200px;">
				<form class="form-horizontal" role="form"
					action="${initParam.root}findMyId.do" id="findMyIdForm">
					<div class="form-group">
						<div class="col-sm-1">
							<label for="inputPassword3" class="control-label">이름</label>
						</div>
						<div class="col-sm-2">
							<input type="text" class="form-control" id="inputPassword3"
								name="name" placeholder="name">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-1">
							<label for="inputPassword3" class="control-label">이메일</label>
						</div>
						<div class="col-sm-2">
							<input type="email" class="form-control" name="email"
								placeholder="email">
						</div>
					</div>					
					가장 좋아하는 음식은?
					<div class="form-group">
						<div class="col-sm-1">
							<label for="inputPassword3" class="control-label">답</label>
						</div>
						<div class="col-sm-2">
							<input type="text" class="form-control" name="answer" placeholder="answer">
						</div>
					</div>
					<a class="btn btn-primary" id="findMyId">아이디 찾기</a>
				</form>
				<span id="findMyIdView"></span><br>
				<br>
				<form class="form-horizontal" role="form" text-align:="middle"
					action="${initParam.root}findMyPassword.do" id="findMyPasswordForm">
					<div class="form-group">
						<div class="col-sm-1">
							<label for="inputPassword3" class="control-label">ID <br>
							</label>
						</div>
						<div class="col-sm-2">
							<input type="text" class="form-control" id="inputPassword3"
								name="id" placeholder="ID">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-1">
							<label for="inputPassword3" class="control-label">이름 <br>
							</label>
						</div>
						<div class="col-sm-2">
							<input type="text" class="form-control" id="inputPassword3"
								name="name" placeholder="name">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-1">
							<label for="inputPassword3" class="control-label">이메일</label>
						</div>
						<div class="col-sm-2">
							<input type="email" class="form-control" id="inputPassword3"
								name="email" placeholder="email">
						</div>
					</div>
					가장 좋아하는 음식은?
					<div class="form-group">
						<div class="col-sm-1">
							<label for="inputPassword3" class="control-label">답</label>
						</div>
						<div class="col-sm-2">
							<input type="text" class="form-control" id="inputPassword3"
								name="answer" placeholder="answer">
						</div>
					</div>
					<a class="btn btn-primary" id="findMyPassBtn">비밀번호 찾기</a>
				</form>
				<span id="findMyPassView"></span>
			</div>
		</div>
	</div>
</div>

