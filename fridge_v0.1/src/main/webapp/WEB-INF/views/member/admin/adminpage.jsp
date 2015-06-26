<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="section">
	<div class="container">
		<div class="row">
			<div class="col-md-12 text-center">
			<br><br>
			<h2 class="text-center">회원 목록</h2><br><br><br>
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
		                  <th class="info text-center">ID</th>
		                  <th class="info text-center">Name</th>
		                  <th class="info text-center">Nick</th>
		                  <th class="info text-center">Gender</th>
		                  <th class="info text-center">E-mail</th>
		                  <th class="info text-center">level</th>
		                  <th class="info text-center">registered date</th>
		                  <th class="info text-center"></th>
		                </tr>
					</thead>
					<tbody>
						<c:forEach var="mvo" items="${requestScope.lvo.list}">
							<tr>
								<td>${mvo.id }</td>
								<td>${mvo.name }</td>
								<td>${mvo.nick }</td>
								<td>
								<c:choose>
									<c:when test="${mvo.gender==1 }">
										남
									</c:when>
									<c:otherwise>
										여
									</c:otherwise>
								</c:choose>
								</td>
								<td>${mvo.email }</td>
								<td>
									<form name="levelForm">
										<select name="memberLevel" onchange="level_change(this)">
											<c:forEach var="index" begin="1" end="6" step="1">
												<c:choose>
													<c:when test="${index==mvo.level }">
														<option value="${mvo.id}" selected>
															<c:choose>
																<c:when test="${index==6}">관리자</c:when>
																<c:otherwise>
																	<c:forEach var="index3" begin="1" end="${index}"
																		step="1">★</c:forEach>
																</c:otherwise>
															</c:choose>
														</option>
													</c:when>
													<c:otherwise>
														<option value="${mvo.id}">
															<c:choose>
																<c:when test="${index==6}">관리자</c:when>
																<c:otherwise>
																	<c:forEach var="index3" begin="1" end="${index}"
																		step="1">★</c:forEach>
																</c:otherwise>
															</c:choose>
														</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</select>
									</form>
								</td>
								<td>${mvo.registerDate }</td>
								<td><c:choose>
										<c:when test="${mvo.level!=6 }">
											<input type="button" value="삭제"
												onclick="deleteMember('${mvo.id }')">
										</c:when>
									</c:choose></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<ul class="pagination">

					<c:if test="${requestScope.lvo.pagingBean.previousPageGroup}">
						<li><a
							href="${initParam.root}admin_adminpage.do?pageNo=${requestScope.lvo.pagingBean.startPageOfPageGroup-1}">Prev</a>
						</li>
					</c:if>
					<c:forEach var="i"
						begin="${requestScope.lvo.pagingBean.startPageOfPageGroup}"
						end="${requestScope.lvo.pagingBean.endPageOfPageGroup}">
						<c:choose>
							<c:when test="${requestScope.lvo.pagingBean.nowPage!=i}">
								<li><a
									href="${initParam.root}admin_adminpage.do?pageNo=${i}">${i}</a>
								</li>
							</c:when>
							<c:otherwise>
								<li><a href="#">${i}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${requestScope.lvo.pagingBean.nextPageGroup}">
						<li><a
							href="admin_adminpage.do?pageNo=${requestScope.lvo.pagingBean.endPageOfPageGroup+1}">Next</a>
						</li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
function deleteMember(id) {
	if(confirm("삭제하시겠습니까?")){
	location.href="${initParam.root}admin_outMember.do?id="+id;
	}
}

function level_change(level) {
	if(level.options[level.selectedIndex].value){
		var star = level.options[level.selectedIndex].text;
		var selectLevel=0;
		if(star=="관리자"){
			selectLevel=6;
		}else{
			selectLevel = star.length;
		}
		var memberId = level.options[level.selectedIndex].value;
		location.href="${initParam.root}admin_levelChange.do?id="+memberId+"&level="+selectLevel; 
		};
	}
</script>