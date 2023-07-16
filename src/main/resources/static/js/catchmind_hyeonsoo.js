$(document).ready(function(){

/*************************
	예약 취소 처리 폼
*************************/
$("#btn_cancleReservation").click(function(){

		if($("input[id='chk1']:checked").length == 0){
			alert("Please check the terms and conditions of cancellation of the reservation");
			return false;
			
		}else if($("input[name='cancle']:checked").length == 0) {
			alert("Please check one reason for cancellation of reservation");
			return false;
		
		}else{
			cancelReservationForm.submit();
		}
	});
	$("#conset_disagree").click(function(){
		window.close();
	});

/*************************
	예약 취소 페이지 open
**************************/
	$('.btn_cancel').click(function() {
	    var value = $(this).val();
	    window.open('/cancle_reservation/'+value, '_blank', 'width=460,height=700');
	});

/***************************
	비밀번호 찾기 - 비밀번호 재설정
***************************/
	$("#btnResetPassword").click(function(){
		var updatePass = $("#updatePass");
		var updateConPass = $("#updatecPass");
		var beforemPass = $("input[name='beforemPass']");
		
		if(updatePass.val() == "") {
			alert("Please check the password to reset");
			updatePass.focus();
			return false;
			
		}else if(updateConPass.val() == "") {
			alert("Please check the Confirm password to reset");
			updateConPass.focus();
			return false;
			
		}else if(updatePass.val() != updateConPass.val()) {
			alert("The values of the two passwords are different, so please check");
			updatePass.val("").focus(); 
			updateConPass.val("");
			return false;
			
		}else {
			findPassUpdateForm.submit();
		}
		
		/*else if(updatePass.val() == beforemPass.val()) {
			alert("You can't use the password you used before");
			updatePass.val("").focus();
			updateConPass.val("");
			return false;
			
		}*/
		
	});


/***************************
	비밀번호찾기 - 이메일 전송
****************************/
	$("#btnRequest").click(function(){
		const memail = $('#email1').val() +"@"+ $('#email2').val(); //
				console.log('완성된 이메일 : ' + memail); // 이메일 오는지 확인
				const checkInput = $('#find_request') // 인증번호 text
				
				$.ajax({
					type : 'get',
					url : "/find_pass_emailCheck/"+memail,
					success : function (data) {
						console.log("data : " +  data);
						checkInput.attr('disabled',false);
						code = data;
						alert('Authentication number sent.')
					}			
		}); // ajax
	});

/**************************
 비밀번호 찾기 폼 - 유효성 체크
 **************************/
$("#btnFindPass_p").click(function(){
	if($("#textId").val() === ""){
		alert("Please enter your ID");
		$("#textId").focus();
		return false;

	}else if($("#email1").val() == ""){
		alert("Please enter your Email");
		$("#email1").focus();
		return false;

	}else if($("#email2").val() == ""){
		alert("Please enter your Email");
		$("#email2").focus();
		return false;

	}else if($("#find_request").val() === ""){
		alert("Please enter Request Number");
		$("#find_request").focus();
		return false;

	}else if($("#find_request").val() != code) {
		const inputCode = $("#find_request").val();
		const $resultMsg = $('#mail-check-warn');
		$resultMsg.html('The authentication number does not match. Please check again');
		$resultMsg.css('color','red');
		return false;

	}else {
		findPassForm.submit();
	}
});

/**************************
	아이디 찾기 폼 - 유효성 체크
**************************/
	$("#btnFindId").click(function(){
		
		if($("#findName").val() === ""){
			alert("Please enter your Name");
			$("#findName").focus();
			return false;
				
		}else if($("#email1").val() == ""){
			alert("Please enter your Email");
			$("#email1").focus();
			return false;
			
		}else if($("#email2").val() == ""){
			alert("Please enter your Email");
			$("#email2").focus();
			return false;
			
		}else if($("#phone1").val() == "default"){
			alert("Please enter your PhoneNumber");
			$("#phone1").focus();
			return false;
			
		}else if($("#phone2").val() == ""){
			alert("Please enter your PhoneNumber");
			$("#phone2").focus();
			return false;
			
		}else if($("#phone3").val() == ""){
			alert("Please enter your PhoneNumber");
			$("#phone3").focus();
			return false;
		
		}else {
			findIdForm.submit();
		}
	});

/******************************
	로그인 폼 - 유효성 체크
******************************/
	$("#btnLogin").click(function(){
		
		if($("#id").val() === ""){
			alert("Please enter your ID");
			$("#id").focus();
			return false;
				
		}else if($("#pass").val() === ""){
			alert("Please enter your Password");
			$("#pass").focus();
			return false;
			
		}else {
			loginForm.submit();
		}
	});
/******************************
	관리자 / 오너 로그인 폼 - 유효성 체크
******************************/
	$("#btnLoginRole").click(function(){
		console.log("idCheck ---> " + $("input[name='roleid']:checked").val())
		if($("input[name='roleid']:checked").length === 0){
			alert("User and Owner Check");
			return false;
			
		}else if($("#id").val() === ""){
			alert("Please enter your ID");
			$("#id").focus();
			return false;
				
		}else if($("#pass").val() === ""){
			alert("Please enter your Password");
			$("#pass").focus();
			return false;
			
		}else {
			if($("input[name='roleid']:checked").val() == "SHOP") {
				$("#id").prop('name','sid');
				$("#pass").prop('name','spass');
				
				loginRoleForm.submit();

			}else if($("input[name='roleid']:checked").val() == "ADMIN") {
				$("#adminLogin").prop('name','roleId');
				loginRoleForm.submit();
			}
		}
	});

/******************************
	회원가입,아이디,비밀번호 찾기 창 띄우기
******************************/
	$("#btnFindID").click(function(){
		window.open("find_id", "_blank", "width=800,height=600");
	});
	$("#btnFindPass").click(function(){
		window.open("find_pass", "_blank", "width=800,height=650");
	});
	$("#btnSignUp").click(function(){
   	 	window.open("join_consent", "_blank", "width=460,height=700");
	});
	$("#btnFindPass1").click(function(){
		window.open("find_pass", "_self", "width=800,height=650");
	});
	$(".a_find_ownerIdPass").click(function(){
		alert("Contact the manager");
	});


/**************************
	회원가입 - 유효성 체크
**************************/
	$("#btnJoin").click(function(){
		console.log($("#idCheck_msg").text());
		if($("#id").val() == ""){
			alert("Please enter your ID");
			$("#id").focus();
			return false;
		}else if($("#idCheck_msg1").text() == "X" || $("#idCheck_msg1").text() == "") {
			alert("Please Duplication Check");
			$("#btnIdCheck").css("border","1px solid tomato");
			return false;
		}else if($("#pass").val() == ""){
			alert("Please enter your Password");
			$("#pass").focus();
			return false;
		}else if($("#cpass").val() == ""){
			alert("Please enter your Password");
			$("#cpass").focus();
			return false;
		}else if($("#name").val() == ""){
			alert("Please enter your Name");
			$("#name").focus();
			return false;
		}else if($("#email1").val() == ""){
			alert("Please enter your Email");
			$("#email1").focus();
			return false;
		}else if($("#email2").val() == ""){
			alert("Please enter your Email");
			$("#email3").focus();
			return false;
		}else if($("input[name='tel']:checked").length == 0){
			alert("Please enter your Tel");
			return false;
		}else if($("#phone1").val() == "default"){
			alert("Please enter your PhoneNumber");
			$("#phone1").focus();
			return false;
		}else if($("#phone2").val() == ""){
			alert("Please enter your PhoneNumber");
			$("#phone2").focus();
			return false;
		}else if($("#phone3").val() == ""){
			alert("Please enter your PhoneNumber");
			$("#phone3").focus();
			return false;
		}else{
			joinForm.submit();
		}
	});	//btnJoin
}); //ready

/***********************************
	이메일 체크
************************************/
$(document).ready(function(){
	$("#email3").on("change", function(){
		if($("#email3").val() == "default"){
			alert("Please enter your Email");
			$("#email2").val("");
			$("#email3").focus();
		}else if($("#email3").val() == "self"){
			$("#email2").val("").focus();
		}else{
			$("#email2").val($("#email3").val());
		}		
		
	}); //email address change

/******************************************
	  	회원가입 폼 - ID중복체크
 *****************************************/
	$("#btnIdCheck").click(function(){
		var inputId = $("#id1").val();
		
		if (inputId == "") {
		    alert("Please enter your ID");
		    $("#id1").focus();
		    return false;
		}else {
			//ajax
			$.ajax({
				url :"/id_check/"+inputId ,
				success : function(result) {
					if(result == 0){
						$("#idCheck_msg1").text("O").css("color","mediumseagreen")
						.css("font-size","13px");
						$("#pass1").focus();
					}else {
						$("#idCheck_msg1").text("Duplicate ID").css("color","tomato")
						.css("font-size","11px");
						$("#id1").val("").focus();
					}
				}
			});
			
		}
	});
/***********************************
	회원가입 폼 체크 - 비밀번호 & 비밀번호 확인
************************************/
$("#pass1").on("blur", function(){
	var password = $(this).val();
	var passwordPattern = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,15}$/;

	if(passwordPattern.test(password)) {
		$('#pass_check').text('This password is available').css("color","mediumseagreen")
			.css("font-size","11px").css("display","block");

		$("#cpass").focus();
	}else {
		$('#pass_check').text('Password must be between 8 and 15 characters long and must contain all English, numeric, and special characters').css("color","red")
			.css("font-size","11px").css("display","block");

		$("#pass1").val("").focus();

	}
});

	$("#cpass").on("blur", function(){
		if($("#pass1").val() != "" && $("#cpass").val() != ""){
			if($("#pass1").val() == $("#cpass").val()){
				$("#cmsg").text("The password is the same").css("color","mediumseagreen")
					.css("font-size","11px").css("display","block");
				$("#name").focus();
			}else{
				$("#cmsg").text("Password is not the same. Please enter it again")
					.css("color","red").css("font-size","11px").css("display","block");

				$("#cpass").val("").focus();
			}
		}
	}); //cpass blur
/********************************
	회원가입 공백, 특수문자 체크
*********************************/
$('#id1').on('keyup', function() {
	var memberId = $(this).val();
	var regex = /^(?=.*[a-z0-9])[a-z0-9]{6,}$/g; // 6자 이상의 영문 또는 영문 + 숫자

	if (regex.test(memberId)) {
		$('#idCheck_msg').text("This ID is available").css("color","mediumseagreen").css("font-size","11px").css("display","block").css("padding","4px 0px");
		return false;

	}else {
		$('#idCheck_msg').text('6 or more characters in English or English + numbers').css("color","red").css("font-size","11px").css("display","block").css("padding","4px 0px");
		$("#id1").val(memberId.replace(regex, "")).focus();
		return false;
	}

});

	$("#name").on("keyup", function() {
		var name = $(this).val();
		var specialChars = /[`~!@#$%^&*|\\\'\";:\/?]/g;

		if (/\s/.test(name)) {
			$('#nameCheck').text("Name should not contain spaces between characters.").css("color","red").css("font-size","11px").css("display","block").css("padding","4px 0px");
			//alert("Name should not contain spaces between characters.");
			$(this).val(name.replace(specialChars, "")).focus();

		} else if (specialChars.test(name)) {
			$('#nameCheck').text("Name should not contain special characters.").css("color","red").css("font-size","11px").css("display","block").css("padding","4px 0px");
			//alert("Name should not contain special characters.");
			$(this).val(name.replace(specialChars, "")).focus();
		}
	});

	$("#email1, #email2").on("keyup", function() {
		var email1 = $("#email1").val();
		var email2 = $("#email2").val();
		var nonAlphanumericChars = /[^a-z0-9.@]/g;

		if (nonAlphanumericChars.test(email1)) {
			$('#emailCheck').text("Please enter a valid email format").css("color","red").css("font-size","11px").css("display","block").css("padding","4px 0px");
			//alert("Please enter a valid email format");
			$("#email1").val(email1.replace(nonAlphanumericChars, "")).focus();

		} else if (nonAlphanumericChars.test(email2)) {
			$('#emailCheck').text("Please enter a valid email format").css("color","red").css("font-size","11px").css("display","block").css("padding","4px 0px");
			//alert("Please enter a valid email format");
			$("#email2").val(email2.replace(nonAlphanumericChars, "")).focus();
		}

	});

	$("#phone2, #phone3").on("keyup", function() {
		var phone2 = $("#phone2").val();
		var phone3 = $("#phone3").val();
		var nonNumericChars = /[^0-9]/g;

		if(nonNumericChars.test(phone2)) {
			$('#phoneCheck').text("You can only enter numbers for phone numbers.").css("color","red").css("font-size","11px").css("display","block").css("padding","4px 0px");
			//alert("You can only enter numbers for phone numbers.");
			$("#phone2").val(phone2.replace(nonNumericChars, "")).focus();

		}else if (nonNumericChars.test(phone3)) {
			$('#phoneCheck').text("You can only enter numbers for phone numbers.").css("color","red").css("font-size","11px").css("display","block").css("padding","4px 0px");
			//alert("You can only enter numbers for phone numbers.");
			$("#phone3").val(phone3.replace(nonNumericChars, "")).focus();
		}
	});
/*********************************
	리뷰 유효성 체크
*********************************/
	$("#review_registe").click(function(){
		if($("#reviewcontent").val() === "") {
			alert("Please enter your Contents");
			$("#reviewcontent").focus();
			return false;
		}

		if($("input[name='tasteStar']:checked").length == 0) {
			alert("Please enter your TasteField Check");
			return false;
		}

		if($("input[name='moodStar']:checked").length == 0) {
			alert("Please enter your MoodField Check");
			return false;
		}

		if($("input[name='serviceStar']:checked").length == 0) { //.val 레거시 확인
			alert("Please enter your SeviceField Check");
			return false;
		}
		if($("#reviewcontent").val() != "" && $("input[name='tasteStar']:checked").length != 0 &&
			$("input[name='moodStar']:checked").length != 0 && $("input[name='serviceStar']:checked").length != 0){
			var tasteRating = $("input[name='tasteStar']:checked").val();
			var moodRating = $("input[name='moodStar']:checked").val();
			var serviceRating = $("input[name='serviceStar']:checked").val();

			console.log("맛 별점: " + tasteRating);
			console.log("분위기 별점: " + moodRating);
			console.log("서비스 별점: " + serviceRating);

			writeReviewForm.submit();
		}
	});


$(".review_label").click(function() {
		$(this).prev().prop("checked", true);
	});
/*********************************
	리뷰 작성 - 값 체크
*********************************/
 $("#review_registe").click(function() {
    var tasteRating = $("input[name='tasteStar']:checked").val();
    var moodRating = $("input[name='moodStar']:checked").val();
    var serviceRating = $("input[name='serviceStar']:checked").val();

    // 가져온 별점 값에 대한 추가적인 처리를 수행할 수 있습니다.
    console.log("맛 별점: " + tasteRating);
    console.log("분위기 별점: " + moodRating);
    console.log("서비스 별점: " + serviceRating);
  });
  
/****************************************
	write_review - FileUpload photo
*****************************************/
	$('#fileInput').change(function() {
      var file = this.files[0];
      var reader = new FileReader();

      reader.onload = function(e) {
        $('#previewImage').attr('src', e.target.result).css("width","150px");
      }

      reader.readAsDataURL(file);
    });
/******************************************
	join_consent - validation Check
******************************************/
	$("#btn_conset").click(function(){
		if($("input[id='chk1']:checked").length == 0){
			alert("Please check everything");
			return false;
		}else if($("input[id='chk2']:checked").length == 0){
			alert("Please check everything");
			return false;
		}else if($("input[id='chk3']:checked").length == 0){
			alert("Please check everything");
			return false;
		}else{
			window.close();
			window.open("join", "_blank", "width=900,height=800");
		}
	});
	$("#conset_disagree").click(function(){
		window.close();
	});
  


/*******************************************
	Information - 식당 주소 복사 
*******************************************/
	function copyToClipboard(text) {
	  var textField = $('<textarea>');
	  textField.text(text);
	  $('body').append(textField);
	  textField.select();
	  document.execCommand('copy');
	  textField.remove();
	}
	
	$('.btn-copy').on('click', function() {
	  var locationText = $('#locationText').text();
	  copyToClipboard(locationText);
	  alert('Address copied');
	});
});//ready
