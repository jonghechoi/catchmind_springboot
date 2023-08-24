/*$(document).ready(function(){
    $(".drow").show();
    $(".box").click(function(){
       $(".drow").toggle();
    $('.drow').animate({width:'toggle'});
    })

})*/
$(document).ready(function(){
		$(".box").click(function(){
			let aid = $(this).attr("id");
			$("#d_"+aid).slideToggle();
			return false;
		});
		
	});

/*$(document).ready(function(){
	$("#cityInput").click(function(){
		$("#iconsContainer").slideToggle();
		return false;
	});
});*/

$(document).ready(function(){
	$("#t1").click(function(){
		let tid = $(this).attr("id");
		$("#d_"+tid).slideToggle();
		return false;
	});
	
});




