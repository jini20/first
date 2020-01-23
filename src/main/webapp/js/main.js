var StringDivider = {};

StringDivider.request = function(){
	var url = "submit.do"
	var param = $("#StringDivider").serialize()
	$.post(url, param, function(data) {
		//alert("Data: " + data);
		$("#divided").text(data.dividedStr[0]);
		$("#remainder").text(data.dividedStr[1]);
	}, "json")
	.fail(function() {
		
	});
};