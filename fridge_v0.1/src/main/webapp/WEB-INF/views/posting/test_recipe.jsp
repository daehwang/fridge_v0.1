<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">

$(document).ready(function(){
    $("#btn").click(function(){
  	 /*  var formData = new FormData();
  	  formData.append("test2", $("input[name=test2]").val());
  	  formData.append("test3", $("textarea[name=test3]").text());
  	  formData.append("test4", $("input[name=test4]")[0].files[0]); 
  	
  	  $.ajax({
  	    url: "saveFileTest.do",
  	    data: formData,
  	    processData: false,
  	    contentType: false,
  	    type: "post",
  	    success: function(data){
  	    	alert(data);
  	    }
  	  }); */
  	var test2=$("#test2").val();
  	var test3=$("#test3").val();
  	var test4=$("#test4").;
		alert(test2);
		alert(test3);
		alert(test4);
    });
});
</script>


<form id="ajaxform" action="saveFileTest.do" method="post" enctype="multipart/form-data">
		<input type="text" name="test2" id="test2"/><br/>
		<textarea rows="10" cols="10" name="test3" id=test3></textarea><br/>
		<input type="file" name="test4" id=test4/>
		<input type="button" id="btn" value="전송" />
</form>
 