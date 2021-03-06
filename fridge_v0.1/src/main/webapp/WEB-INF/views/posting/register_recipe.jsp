<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript" src="resources/editor/js/HuskyEZCreator.js" charset="utf-8"></script>


 <center>
   <br>
	<hr class="style-four">
	<form method="post" action="${initParam.root}registerRecipe.do" id="registerForm">
		<table>
			<tr>
				<td>제목 <input type="text" name="title" id="title" size="50">
				</td>
				<!-- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -->
				<%-- 닉네임 : ${sessionScope.mvo.nick} &nbsp;&nbsp;&nbsp; 아이디 : ${sessionScope.mvo.id} <br> --%>
				<td>요리시간 : <select name="cookingTime" id="cookingTime">
						<option value="">----</option>
						<option value="10">10분</option>
						<option value="15">15분</option>
						<option value="20">20분</option>
						<option value="20">30분</option>
						<option value="20">40분</option>
						<option value="20">50분</option>
				</select></td>
			</tr>
			<!--   <br>   <br> -->
			<tr>
				<td colspan='2'><textarea rows="24" style="width: 100%;"
						id="contents" name="contents"></textarea><br></td>
			</tr>
			<tr>
				<td colspan='2'>태그:<input type="text" name="items" id="items" size=80> 
				<input type="hidden" name="memberId" value="${sessionScope.mvo.id}">
				 <input type="hidden" name="nick" value="${sessionScope.mvo.nick}">
				 </td>
				 <tr>
				 <td colspan='2'>
				 <br>
				 <center>
				  <input type="button" id="register" value="등록">
				  </center>
				  <br>				<br>				<br>				<br>				<br>
				</td>
			</tr>
		</table>
	</form>
</center>
<script type="text/javascript">
	//전역변수
	var obj = [];
	//스마트에디터 프레임생성
	nhn.husky.EZCreator.createInIFrame({
		oAppRef : obj,
		elPlaceHolder : "contents",
		sSkinURI : "resources/editor/SmartEditor2Skin.html",
		htParams : {
			// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseToolbar : true,
			// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseVerticalResizer : true,
			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
			bUseModeChanger : true,
		}
	});
</script>  