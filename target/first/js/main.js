var StringDivider = {};

StringDivider.request = function(){
	var url = "submit.do"
	var param = $("#StringDivider").serialize()
	$.post(url, param, function(data) {
		//alert("Data: " + data);
		console.log(data);
	}, "json")
	.fail(function() {
		
	});
};