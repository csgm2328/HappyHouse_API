$(document).ready(function() {
	var cur = getCookie("curLogin");
	console.log(cur);
	if (cur != "") {
		$('#in').css("display", "none");
		$('#out').css("display", "block");
		$('#edit-information').css("display", "block");
		$('#info').css("display", "block");
		$('#join').css("display", "none");
		$('#findpass').css("display", "none");
		
		$('#showId').css("display", "block");
		$('#showId').children().css("color", "white");
		$('#showId').children().css("padding", "8px 200px 0");
		
		$("#modal-id").val(cur);
		$("#showId").children().append(cur+"님 환영합니다");
	} else {
		$('#in').css("display", "block");
		$('#out').css("display", "none");
		$('#edit-information').css("display", "none");
		$('#info').css("display", "none");
		$('#join').css("display", "block");
		$('#showId').css("display", "none");
		$('#findpass').css("display", "blcok");
		
	}
	function getCookie(cName) {
		cName = cName + '=';
		var cookieData = document.cookie;
		var start = cookieData.indexOf(cName);
		var cValue = '';
		if (start != -1) {
			start += cName.length;
			var end = cookieData.indexOf(';', start);
			if (end == -1)
				end = cookieData.length;
			cValue = cookieData.substring(start, end);
		}
		return unescape(cValue);
	}
	
})