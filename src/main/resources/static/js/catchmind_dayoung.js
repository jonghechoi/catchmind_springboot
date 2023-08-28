$(document).ready(function() {
	var rdate = null;
	var sid = null;
	var rtabletype = null;
	var guestnumber = null;
	var rtime = null;
	var smealfee = null;
	var sdeposit = null;
	var rrequest = null;


	/*
	 * 카카오 공유하기
	 */
	// 카카오 JavaScript 키 설정
	Kakao.init('adacb7319ef90251f888ca7acb9c479d');

	$("#kakao-share-btn").on('click', shareKakao);

	function shareKakao() {
		Kakao.Link.sendDefault({
			objectType: 'feed',
			content   : {
				title      : '카카오 공유하기',
				description: '캐치마인드!.',
				imageUrl   : '이미지 URL',
				link       : {
					webUrl      : '웹사이트 URL',
					mobileWebUrl: '모바일 웹사이트 URL'
				}
			}
		});
	}


	/*
	 Information - 식당 주소 복사
	 */
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



	// 모든 nice-select 초기화
	$('select').niceSelect();

	/*
	 * date picker
	 */
	$("#rdate").change(function () {
		sid = $("#sid").val();
		rdate = $("#rdate").val();

		var objParams = {
			"sid"  : sid,
			"rdate": rdate
		};

		$.ajax({
			url: "/select_rtabletype",
			type: "POST",
			data: objParams,
			dataType: "json",
			cache: false,
			success : function (result) {
				let output = "";

				if (result.rooftop > 0) {
					output += "<option name = 'rtabletype' value='ROOFTOP'>Rooftop</option>";
				}
				if (result.terrace > 0) {
					output += "<option name = 'rtabletype' value='TERRACE'>Terrace</option>";
				}
				if (result.bar > 0) {
					output += "<option name = 'rtabletype' value='BAR'>Bar</option>";
				}
				if (result.dininghall > 0) {
					output += "<option name = 'rtabletype' value='DININGHALL'>Dining Hall</option>";
				}
				if (result.windowseat > 0) {
					output += "<option name = 'rtabletype' value='WINDOWSEAT'>Window Seat</option>";
				}
				if (result.privateroom > 0) {
					output += "<option name = 'rtabletype' value='PRIVATEROOM'>Private room</option>";
				}
				if (result.rental > 0) {
					output += "<option name = 'rtabletype' value='RENTAL'>Rental</option>";
				}

				// $("#rtabletype").append(output);
				// $("#rtabletype").niceSelect('destroy');
				// $("#rtabletype").niceSelect();

				// 뒤에 옵션들 전부 디폴트 값으로 변경
				rtabletype = "default";
				guestnumber = "default";
				rtime = "default";

				// 선택 상자 내부의 기존 옵션을 삭제
				$("#rtabletype").empty();
				$("#guestnumber").empty();
				$("#rtime").empty();

				// 새로운 옵션 추가
				$("#rtabletype").append(output);
				$("#guestnumber").append("<option data-display='Party Size' value='default'>Party Size</option>");
				$("#rtime").append("<option value='default' data-display='Time'>Time</option>");

				// Nice Select 업데이트
				$("#rtabletype").niceSelect('update');
				$("#guestnumber").niceSelect('update');
				$("#rtime").niceSelect('update');

			},
			error   : function () {
				console("datepicker error");
			}
		});


	});



	$("#rtabletype").on('change', selectBoxRtabletype);

	/*
	 * select rtabletype
	 */
	function selectBoxRtabletype() {
		if (rdate === null) {
			alert("Please select a date first");
			return false;
		} else {
			rtabletype = $("#rtabletype").val();
			var objParams = {
				"sid"       : sid,
				"rdate"     : rdate,
				"rtabletype": rtabletype
			};
			//alert(sid);
			//alert(rtabletype);

			$.ajax({
				url: "/select_guestnumber",
				type: "POST",
				data: objParams,
				dataType: "json",
				cache: false,
				success : function (result) {
					var minOccupiedTableNum = result.minOccupiedTableNum;
					var rtabletypeNum = result.rtabletypeNum;
					//alert(minOccupiedTableNum);
					//alert(rtabletypeNum);

					let output = "";
					for (var i = 1; i <= (rtabletypeNum - minOccupiedTableNum) * 2; i++) {
						output += "<option name = 'guestnumber' value = '" + i + "'>" + i + "</option>";
					}

					// $("#guestnumber").append(output);
					// $("#guestnumber").niceSelect('destroy');
					// $("#guestnumber").niceSelect();

					// 뒤에 옵션들 전부 디폴트 값으로 변경
					guestnumber = "default";
					rtime = "default";

					// 선택 상자 내부의 기존 옵션을 삭제
					$("#guestnumber").empty();
					$("#rtime").empty();

					// 새로운 옵션 추가
					$("#guestnumber").append(output);
					$("#rtime").append("<option value='default' data-display='Time'>Time</option>");

					// Nice Select 업데이트
					$("#guestnumber").niceSelect('update');
					$("#rtime").niceSelect('update');
				},
				error   : function () {
					console("tabletype error");
				}
			});
		}

		$('.nice-select').removeClass('open');
	}



	$("#guestnumber").on('change', selectBoxGuestnumber);

	/*
	 * select guestnumber
	 */
	function selectBoxGuestnumber(){
		if(rdate === null){
			alert("Please select a date first");
			return false;
		}
		else if(rtabletype=="default"){
			alert("Please select a 'Seating Options' first");
			return false;
		}
		else {
			guestnumber = $("#guestnumber").val();

			var objParams = {
				"sid"        : sid,
				"rdate"      : rdate,
				"rtabletype" : rtabletype,
				"guestnumber": guestnumber
			}

			//alert(guestnumber);

			$.ajax({
				url: "/select_rtime",
				type: "POST",
				data: objParams,
				dataType: "json",
				cache: false,
				success : function (result) {
					let output = "";

					$(result).each(function(){
						output += "<option name='rtime' value='" + this + "'>" + this + "</option>"
					});

					// $("#rtime").append(output);
					// $("#rtime").niceSelect('destroy');
					// $("#rtime").niceSelect();

					// 뒤에 옵션들 전부 디폴트 값으로 변경
					rtime = "default";

					// 선택 상자 내부의 기존 옵션을 삭제
					$("#rtime").empty();

					// 새로운 옵션 추가
					$("#rtime").append(output);

					// Nice Select 업데이트
					$("#rtime").niceSelect('update');
				},
				error   : function () {
					console("guestnumber error");
				}
			}); //ajax
		}

		$('.nice-select').removeClass('open');
	} //function




	$("#rtime").on('change', selectBoxRtime);

	/*
	 * select rtime
	 */
	function selectBoxRtime() {
		if (rdate === null) {
			alert("Please select a date first");
			return false;
		}
		else if(rtabletype=="default") {
			alert("Please select a 'Seating Options' first");
			return false;
		}
		else if(guestnumber=="default"){
			alert("Please select a 'Party Size' first");
			return false;
		}
		else{
			$('.nice-select').removeClass('open');
			return true;
		}

	}


	/*
	 * 예약버튼
	 */
	$("#btnReservation").click(function(){
		rtime = $("#rtime").val();

		if(rdate === null){
			alert("Please select a date");
			$("#rdate").focus();
			return false;
		}else if(rtabletype == "default"){
			alert("Please select a 'Seating Options'");
			$("#rtabletype").focus();
			return false;
		}else if(guestnumber == "default"){
			alert("Please select a 'Party Size'");
			$("#guestnumber").focus();
			return false;
		}else if(rtime == "default"){
			alert("Please select a 'Time'");
			$("#rtime").focus();
			return false;
		}
		else{
			reservationForm.submit();
		}
	});



	/*
	 * requestBooking btn - booking without payment
	 */

	$("#requestBooking").click(function() {
		alert("booking without payment");
		// var mid = $("#mid").val();
		// var contact = $("#contact").val();
		// var kemail = $("#kemail").val();

		//notes 유효성검사
		if($("input:checkbox[name='notes']:checked").length !== $("input:checkbox[name='notes']").length){
			alert('Please check notes if you want to proceed');
			return false;
		}
		else{
			bookingForm.submit();
		}
	});

	/*
	function orderProcess(rsp){
		alert("sid--->" + sid);
		alert("rdate--->" + rdate);
		alert("rtime--->" + rtime);
		alert("rtabletype--->" + rtabletype);
		alert("guestnumber--->" + guestnumber);
		alert("rrequest--->" + rrequest);
		alert("amount--->" + rsp.amount);
		alert("contact--->" + rsp.buyer_tel);
		alert("imp_uid--->" + rsp.imp_uid);
		alert("merchant_uid--->" + rsp.merchant_uid);
		alert("name--->" + rsp.name);
		$.ajax({
			url: "booking_with_payment.do",
			type: 'POST',
			dataType: 'json',
			data: {
				sid : sid,
				rdate : rdate,
				rtime : rtime,
				rtabletype : rtabletype,
				guestnumber : guestnumber,
				amount : rsp.amount,
				rrequest : rrequest,
				contact : rsp.buyer_tel,
				imp_uid : rsp.imp_uid, // 결제 고유번호
				merchant_uid : rsp.merchant_uid, // 주문번호
				name : rsp.name
				//기타 필요한 데이터가 있으면 추가 전달
			},
			success: function (result) {
				alert("결제되었습니다.");
				location.href = "http://localhost:9000/catchmind/mydining_scheduled.do";
			},
			error: function(){
				alert("errorrrrr on saving data into DB");
				// 결제 취소 요청
				//cancelPayment(rsp.imp_uid);
			}
		}); //ajax
	}
	*/





	/*
	* requestPay btn - booking with payment
	*/
	// $("#requestPay").click(function(){
	// 	alert("payment?????");
	// 	var mid = $("#mid").val();
	// 	rrequest = $("#rrequest").val();
	// 	var contact = $("#contact").val();
	// 	var kemail = $("#kemail").val();
	// 	var paymentAmount = $("#paymentAmount").val();
	// 	alert(paymentAmount);
	//
	// 	//notes 유효성검사
	// 	if($("input:checkbox[name='notes']:checked").length !== $("input:checkbox[name='notes']").length){
	// 		alert('Please check notes if you want to proceed');
	// 		return false;
	// 	}
	// 	//Email / rphone 유효성 검사
	// 	else if(contact.trim().length === 0){
	// 		alert('Please write down your email address or phone number if you want to proceed');
	// 		return false;
	// 	}
	// 	//Agreement with Order details & Payment 유효성검사
	// 	else if($("input:checkbox[name='orderDetailsRequired']:checked").length != $("input:checkbox[name='orderDetailsRequired']").length){
	// 		alert('Please check payment details if you want to proceed');
	// 		return false;
	// 	}
	// 	else{
	// 		var IMP = window.IMP;
	// 		IMP.init("imp65513454");
	// 		let uuid = window.crypto.randomUUID();
	//
	// 		IMP.request_pay({
	// 			pg: "html5_inicis",
	// 			pay_method: "card",
	// 			merchant_uid: mid + "_" + rdate + "_" + uuid,
	// 			name: "결제테스트 : " + mid + "_" + rdate + "_" + uuid,
	// 			amount: 500,
	// 			buyer_email: kemail,
	// 			buyer_name: mid,
	// 			buyer_tel: contact,
	// 			buyer_addr: " ",
	// 			buyer_postcode: " ",
	// 		}, function (rsp) {
	// 			if (rsp.success) {
	// 				alert("rsp.success");
	// 				$.ajax({
	// 					type: 'POST',
	// 					url: "/verifyIamport/" + rsp.imp_uid
	// 				}).done(function(data) {
	// 					alert("data.success");
	// 					if (rsp.paid_amount == data.response.amount) {
	// 						var msg = '결제가 완료되었습니다.';
	// 						msg += '\n고유ID : ' + rsp.imp_uid;
	// 						msg += '\n상점 거래ID : ' + rsp.merchant_uid;
	// 						msg += '\n결제 금액 : ' + rsp.amount;
	// 						//msg += '카드 승인번호 : ' + rsp.apply_num;
	// 						alert(msg);
	//
	// 						payForm.submit();
	// 					}
	// 					else {
	// 						alert("An error occurred, please try again later");
	// 					}
	// 				});
	//
	// 				payForm.submit();
	// 			}
	// 			else {
	// 				var msg = '결제에 실패하였습니다.';
	// 				msg += '에러내용 : ' + rsp.error_msg;
	//
	// 				alert(msg);
	// 			}
	// 		});
	// 	}
	// });
	
	
	
	/*
	 * requestPay btn - booking with payment
	 */

/*	$("#requestPay").click(function(){
		alert("들어는 오네??");
		var mid = $("#mid").val();
		var sid = $("#sid").val();
		var rdate = $("#rdate").val();
		var rtime = $("#rtime").val();
		var rtabletype = $("#rtabletype").val();
		var guestnumber = $("#guestnumber").val();
		rrequest = $("#rrequest").val();
		var contact = $("#contact").val();
		var kemail = $("#kemail").val();
		var paymentAmount = $("#paymentAmount").val();
		alert(paymentAmount);
		
		//notes 유효성검사	
		if($("input:checkbox[name='notes']:checked").length !== $("input:checkbox[name='notes']").length){
			alert('Please check notes if you want to proceed');
			return false;
		}
		//Email / rphone 유효성 검사
		else if(contact.trim().length === 0){
			alert('Please write down your email address or phone number if you want to proceed');
			return false;
		}
		//Agreement with Order details & Payment 유효성검사	
		else if($("input:checkbox[name='orderDetailsRequired']:checked").length != $("input:checkbox[name='orderDetailsRequired']").length){
			alert('Please check payment details if you want to proceed');
			return false;
		}
		else{
			var IMP = window.IMP; // 생략 가능
			IMP.init("imp65513454"); // 예: imp00000000a
			let uuid = window.crypto.randomUUID();
			//alert(uuid);
			//alert(mid + "_" + rdate + "_" + uuid);
			
			IMP.request_pay({
				pg: "html5_inicis",
				pay_method: "card",
				merchant_uid: mid + "_" + rdate + "_" + uuid,
				name: "결제테스트 : " + mid + "_" + rdate + "_" + uuid,
				amount: 500,
				buyer_email: kemail,
				buyer_name: mid,
				buyer_tel: contact,
				buyer_addr: " ",
				buyer_postcode: " ",				
			}, function (rsp) {
			    if (rsp.success) {
			    	alert("rsp.success");
	    			$.ajax({
			    		type: 'POST',
			    		url: "/verifyIamport/" + rsp.imp_uid  
			    	}).done(function(data) {
			    		alert("data.success");
			    		if (rsp.paid_amount == data.response.amount) {
			    			var msg = '결제가 완료되었습니다.';
			    			msg += '\n고유ID : ' + rsp.imp_uid;
			    			msg += '\n상점 거래ID : ' + rsp.merchant_uid;
			    			msg += '\n결제 금액 : ' + rsp.amount;
			    			//msg += '카드 승인번호 : ' + rsp.apply_num;
			    			alert(msg);
			    			
	    					payForm.submit();	
			    		} 
			    		else {
			    			alert("An error occurred, please try again later");
			    		}
			    	});
	    			
	    			
	    			payForm.submit();	
			    } 
			    else {
			        var msg = '결제에 실패하였습니다.';
			        msg += '에러내용 : ' + rsp.error_msg;
			        
			        alert(msg);
				}
			});
		}
	});
*/	
	
	
	
	/*
	$("#requestPay").click(function(){
		var mid = $("#mid").val();
		var sid = $("#sid").val();
		var rdate = $("#rdate").val();
		var rtime = $("#rtime").val();
		var rtabletype = $("#rtabletype").val();
		var guestnumber = $("#guestnumber").val();
		rrequest = $("#rrequest").val();
		var contact = $("#contact").val();
		var kemail = $("#kemail").val();
		var paymentAmount = $("#paymentAmount").val();
		//alert(paymentAmount);
		
		//notes 유효성검사	
		if($("input:checkbox[name='notes']:checked").length !== $("input:checkbox[name='notes']").length){
			alert('Please check notes if you want to proceed');
			return false;
		}
		//Email / rphone 유효성 검사
		else if(contact.trim().length === 0){
			alert('Please write down your email address or phone number if you want to proceed');
			return false;
		}
		//Agreement with Order details & Payment 유효성검사	
		else if($("input:checkbox[name='orderDetailsRequired']:checked").length != $("input:checkbox[name='orderDetailsRequired']").length){
			alert('Please check payment details if you want to proceed');
			return false;
		}
		else{
			var IMP = window.IMP; // 생략 가능
			IMP.init("imp65513454"); // 예: imp00000000a
			let uuid = window.crypto.randomUUID();
			//alert(uuid);
			//alert(mid + "_" + rdate + "_" + uuid);
			
			IMP.request_pay({
				pg: "html5_inicis",
				pay_method: "card",
				merchant_uid: mid + "_" + rdate + "_" + uuid,
				name: "결제테스트 : " + mid + "_" + rdate + "_" + uuid,
				amount: 500,
				buyer_email: kemail,
				buyer_name: mid,
				buyer_tel: contact,
				buyer_addr: " ",
				buyer_postcode: " ",
				
			}, function (rsp) {
			    if (rsp.success) {
			    	alert("rsp.success");
			    	var msg = '결제가 완료되었습니다.';
	    			msg += '\n고유ID : ' + rsp.imp_uid;
	    			msg += '\n상점 거래ID : ' + rsp.merchant_uid;
	    			msg += '\n결제 금액 : ' + rsp.amount;
	    			//msg += '카드 승인번호 : ' + rsp.apply_num;
	    			alert(msg);
	    			
	    			payForm.submit();	
			    } 
			    else {
			        var msg = '결제에 실패하였습니다.';
			        msg += '에러내용 : ' + rsp.error_msg;
			        
			        alert(msg);
				}
			});
		}
	});
	*/
	
	
	
	
	
	/*
	$("#requestPay").click(function(){
		var mid = $("#mid").val();
		var sid = $("#sid").val();
		var rdate = $("#rdate").val();
		var rtime = $("#rtime").val();
		var rtabletype = $("#rtabletype").val();
		var guestnumber = $("#guestnumber").val();
		var rrequest = $("#rrequest").val();
		var contact = $("#contact").val();
		var kemail = $("#kemail").val();
		var paymentAmount = $("#paymentAmount").val();
		//alert(paymentAmount);
		
		//notes 유효성검사	
		if($("input:checkbox[name='notes']:checked").length !== $("input:checkbox[name='notes']").length){
			alert('Please check notes if you want to proceed');
			return false;
		}
		//Email / rphone 유효성 검사
		else if(contact.trim().length === 0){
			alert('Please write down your email address or phone number if you want to proceed');
			return false;
		}
		//Agreement with Order details & Payment 유효성검사	
		else if($("input:checkbox[name='orderDetailsRequired']:checked").length != $("input:checkbox[name='orderDetailsRequired']").length){
			alert('Please check payment details if you want to proceed');
			return false;
		}
		else{
			var IMP = window.IMP; // 생략 가능
			IMP.init("imp65513454"); // 예: imp00000000a
			let uuid = window.crypto.randomUUID();
			//alert(uuid);
			//alert(mid + "_" + rdate + "_" + uuid);
			
			IMP.request_pay({
				pg: "html5_inicis",
				pay_method: "card",
				merchant_uid: mid + "_" + rdate + "_" + uuid,
				name: "결제테스트 : " + mid + "_" + rdate + "_" + uuid,
				amount: 500,
				buyer_email: kemail,
				buyer_name: mid,
				buyer_tel: contact,
				buyer_addr: " ",
				buyer_postcode: " ",
				m_redirect_url : "http://localhost:9000/catchmind/mydining_scheduled.do"
			}, function (rsp) {
			    if (rsp.success) {
			    	alert("rsp.success");
			    	//[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
			    	$.ajax({
			    		type: 'POST',
			    		url: "/verifyIamport/" + rsp.imp_uid  //cross-domain error가 발생하지 않도록 주의해주세요
			    	}).done(function(data) {
			    		//[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
			    		alert("data.success");
			    		if (rsp.paid_amount == data.response.amount) {
			    			var msg = '결제가 완료되었습니다.';
			    			msg += '\n고유ID : ' + rsp.imp_uid;
			    			msg += '\n상점 거래ID : ' + rsp.merchant_uid;
			    			msg += '\n결제 금액 : ' + rsp.amount;
			    			//msg += '카드 승인번호 : ' + rsp.apply_num;
			    			alert(msg);
			    			
			    			orderProcess(rsp);
			    		} 
			    		else {
			    			//[3] 아직 제대로 결제가 되지 않았습니다.
			    			//[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
			    			alert("An error occurred, please try again later");
			    		}
			    	});
			    } 
			    else {
			        var msg = '결제에 실패하였습니다.';
			        msg += '에러내용 : ' + rsp.error_msg;
			        
			        alert(msg);
				}
			});
		}
	});
	*/
});
