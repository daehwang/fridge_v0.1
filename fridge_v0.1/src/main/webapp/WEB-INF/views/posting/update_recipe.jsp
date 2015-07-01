<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="resources/editor/js/HuskyEZCreator.js" charset="utf-8"></script>
          <center>
          <br>
	<hr class="style-four">
	<form method=post action="updateRecipe.do" id="updateForm">
		<table class="content">
			<tr>
				<td><b>글번호 : ${updateInfo.rvo.recipeNo } </b> 
				<input type="hidden"	name="recipeNo" value=${updateInfo.rvo.recipeNo } /></td>
				<td colspan="2"><b>
				&nbsp;&nbsp;타이틀 : <input type="text" name="title" value=${updateInfo.rvo.title } size="40"/></b></td>
			</tr>
			<tr>
				<td><font size="2">작성자 : <input type=text name=nick
						value="${updateInfo.rvo.nick}" readonly /></font></td>
				<td>&nbsp;&nbsp;작성일시 : ${updateInfo.rvo.postDate }</td>
				<td  align="right">
				요리시간 : <select name="cookingTime" id="cookingTime">
						<option value="${requestScope.updateInfo.rvo.cookingTime}">${requestScope.updateInfo.rvo.cookingTime}</option>
						<option value="10">10분</option>
						<option value="15">15분</option>
						<option value="20">20분</option>
						<option value="20">30분</option>
						<option value="20">40분</option>
						<option value="20">50분</option>
				</select>
				</td>
			</tr>
			<tr>
				<td colspan="3"><br> <textarea name="contents"
						id="contents" rows="24" style="width: 100%;"> ${updateInfo.rvo.contents }</textarea>
					<br> 태그 : <input type="text" name="items" id="items" size="65"
					value="${updateInfo.tag}"></td>
			</tr>
			<tr>
				<td colspan="3"><br>
					<center>
						<input type="button" id="updateRecipeBtn" value="수정하기">&nbsp;
						<input type="button" id="cancleBtn" value="취소">
					</center> <br></td>
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