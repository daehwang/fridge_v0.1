<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="resources/editor/js/HuskyEZCreator.js" charset="utf-8"></script>
          <center>
<form method=post action="updateBoard.do" id="updateBoard" >
         <table class="content">
            <tr>
               <td>
               <br><br>
               <b>글번호: <input type="textarea" name=boardNo value=${bvo.boardNo } size="2" readonly></input>
           카테고리 : 
                     <select name="category" id="category">
                      <option value="${bvo.category}">${bvo.category}</option>
                     <option value="">----</option>
                     <option value="요리후기">요리 후기</option>
                     <option value="자유게시판">자유게시판</option>
                   <c:choose>
                        <c:when test="${sessionScope.mvo.level==6 }">
                     <option value="공지사항">공지사항</option>   
                        </c:when>
                     </c:choose>
                  </select>
               
              
                타이틀:<input type=text name=title value=${bvo.title }></input></b>
               </td></tr><tr>   <td>
                작성자: <input type="textarea" name=nick 
                  value="${bvo.nick}" size="8" readonly></input> 
            작성일시:  ${bvo.postDate } 
                   
         </table>   
         <br>
<textarea name="contents" id="contents" rows="24" style="width:100%;"> ${bvo.contents }</textarea><br>  
<input type="button" id="updateBoardBtn" value="수정하기">&nbsp;
<input type="button" id="cancleBoardBtn" value="취소"> &nbsp;<br><br><br><br><br>
</form>
          </center>
<script type="text/javascript">
    //전역변수
    var obj = [];               
    //스마트에디터 프레임생성
    nhn.husky.EZCreator.createInIFrame({
        oAppRef: obj,
        elPlaceHolder:"contents",
        sSkinURI: "resources/editor/SmartEditor2Skin.html", 
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