<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
function loginCheck() {
	if("${sessionScope.mvo}"==""){
		alert("로그인후 이용하실 수 있습니다.");		
		return false;
	}	
}
</script>
<header>
	<div class="header-content">
		<div class="header-content-inner">
			<div class="container">
				<div class="row">
					<div class="col-lg-12 text-center">
						<h2 class="section-heading">
						<br><br>
						 <a href="${initParam.root}home.do">
						 <img src="img/투명3.jpg" width="250px"><br>
						 <font face="billabong" size="7">Take care of my table</font>
						 </a>
							<%-- <a class="Headtitle" href="${initParam.root}home.do">Take care of my table</a> --%>
						</h2>
				<!-- 		<hr class="primary"> -->
					</div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-lg-3 col-md-6 text-center">
						<div class="service-box">
						<c:choose>
								<c:when test="${sessionScope.mvo==null}">
								<a href="#" onclick="loginCheck();return false;">
								<i class="fa fa-2x fa-spoon wow bounceIn" style="color:#FBFF94"
									data-wow-delay=".2s"></i></a>
								<h5><a href="#" onclick="loginCheck();return false;">레시피 등록</a></h5>
								</c:when>
								<c:otherwise>
								<a href="${initParam.root}registerRecipeForm.do">
								<i class="fa fa-2x fa-spoon wow bounceIn" style="color:#FBFF94"
									data-wow-delay=".2s"></i></a>
								<h5><a href="${initParam.root}registerRecipeForm.do">레시피 등록</a></h5>
								</c:otherwise>
							</c:choose>
							
						</div>
					</div>
					<div class="col-lg-3 col-md-6 text-center">
						<div class="service-box">
							<i class="fa fa-2x fa-paper-plane wow bounceIn" style="color:#42FDFF"
								data-wow-delay=".1s"></i>
							<h5>자유 게시판</h5>
						</div>
					</div>

					<div class="col-lg-3 col-md-6 text-center">
						<div class="service-box">
                  <c:choose>
                        <c:when test="${sessionScope.mvo==null}">
                           <!-- <a href="#" onclick="loginCheck();return false;"> -->
                           <i class="fa fa-2x fa-heart wow bounceIn" style="color:#FF5651"
                           data-wow-delay=".3s"></i>
                        <h5><a href="#" onclick="loginCheck();return false;">즐겨찾기</a></h5>
                        </c:when>
                        <c:otherwise>
                           <%-- <a href="${initParam.root}registerRecipeForm.do"> --%>
                           <i class="fa fa-2x fa-heart wow bounceIn" style="color:#FF5651"
                           data-wow-delay=".3s"></i>
                           <h5><a href="favoriteView.do">즐겨찾기</a></h5>
                        
                        </c:otherwise>
                  </c:choose>
                  </div>
					</div>
					<div class="col-lg-3 col-md-6 text-center">
						<div class="service-box">

							<c:choose>
								<c:when test="${sessionScope.mvo==null}">
									<a href="#" data-toggle="modal" data-target="#exampleModal"
											data-whatever="@getbootstrap">											
									<i class="fa fa-2x fa-sign-in wow bounceIn text-inverse"></i>
									</a>
									<h5>
										<a href="#" data-toggle="modal" data-target="#exampleModal"
											data-whatever="@getbootstrap">Login</a>
									</h5>
								</c:when>
								<c:otherwise>
									<a href="${initParam.root}member_logout.do">
									<i class="fa fa-2x fa-sign-out wow bounceIn text-inverse"></i>
									</a>
									<h5>
										<a href="${initParam.root}member_logout.do">Logout</a>
									</h5>
								</c:otherwise>
							</c:choose>

						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
</header>

<br>
<br>
<!--     </section> -->

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="exampleModalLabel">Login</h4>
			</div>
			<div class="modal-body">
				<form method="get" action="member_login.do" id="loginForm">
					<div class="form-group">
						<label for="recipient-name" class="control-label">ID:</label> <input
							type="text" name="id" class="form-control" id="memberId">
					</div>
					<div class="form-group">
						<label for="message-text" class="control-label">Password:</label>
						<input type="password" name="password" class="form-control" id="password">
					</div>					
					<div style="text-align:right">					
						<a href="${initParam.root}member_findMyInfo.do"><font color=black>id/password 찾기</font></a>		
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary" id="loginBtn">Login</button>
			</div>
		</div>
	</div>
</div>