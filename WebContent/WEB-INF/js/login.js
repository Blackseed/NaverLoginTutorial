$("#term").click(function(){
	if(this.checked){
		nextStep(1);
	}
})

$("#btn-join").click(function(){
	$("#joinForm").submit();
})


function nextStep(step){
	$(".stepwizard-step>a").removeClass("btn-info").addClass("btn-default").attr("disabled",true)
	$($(".stepwizard-step>a").get(step)).removeClass("btn-default").addClass("btn-info").removeAttr("disabled");
	hideAll();
	switch(step){
		case 0: $("#termbox").show();
		break;
		case 1: $("#joinformbox").show();
		break;
		case 2: $("#joinconfirmbox").show();
		break;
		case 3: $("#joincompletebox").show();
		brea;
	}
}
function hideAll(){
	$("#termbox").hide();
	$("#joinformbox").hide();
	$("#joinconfirmbox").hide();
	$("#joincompletebox").hide();
}
