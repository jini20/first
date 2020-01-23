<!DOCTYPE HTML>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
</head>
<body>
<h2>String divider!!</h2>
<form id="StringDivider">
<p>
URL : <textarea id="targetUrl" name="targetUrl" rows="1" cols="150"></textarea>
</p>
<br><br>
<p>
Type :
<select id="removeTags" name="removeTags">
  <option value="onlyText">태그 제외</option>
  <option value="tagInclude">텍스트 전체</option>
</select>
</p>
<p>
출력 묶음 단위 : <input type="number" name="quantity" min="1" max="1000000">
<input type="submit" id="divideSubmit" value="제출"/><input type="reset" value="취소">
</p>
</form>
<p>
몫 : <span id="divided"></span>
<br>
나머지:<span id="remainder"></span>
</p>
</body>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="js/main.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		$("#StringDivider").on("submit", function(event) {
			event.preventDefault();
			StringDivider.request();
		});
	});
</script>
</html>
