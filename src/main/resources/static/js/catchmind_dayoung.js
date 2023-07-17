$(document).ready(function(){
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
	    	content: {
				title: '카카오 공유하기',
				description: '캐치마인드!.',
		        imageUrl: '이미지 URL',
		        link: {
		        	webUrl: '웹사이트 URL',
		        	mobileWebUrl: '모바일 웹사이트 URL'
		        }
	    	}
		});
    }
	 
	
	/*
	 * date picker
	 */
	$("#rdate").change(function() {
		sid = $("#sid").val();
		rdate = $("#rdate").val();
		//alert(sid);
		//alert(rdate);
				
		var objParams = {	
							"sid" : sid,
							"rdate" : rdate 
	                    };	
	                    
		$.ajax({
	 		type: "POST",
	 		url: "select_rtabletype",
	 		dataType : "json",
	 		data: objParams,
	 		cache: false,
	 		success: function(result){
	 			let output = "";
	 			//alert(result.terrace);
				
	 			if(result.rooftop > 0){
					output += "<option name = 'rtabletype' value='ROOFTOP'>Rooftop</option>";
				}
				if(result.terrace > 0){
					output += "<option name = 'rtabletype' value='TERRACE'>Terrace</option>";
				}
				if(result.bar > 0){
					output += "<option name = 'rtabletype' value='BAR'>Bar</option>";
				}
				if(result.dininghall > 0){
					output += "<option name = 'rtabletype' value='DININGHALL'>Dining Hall</option>";
				}
				if(result.windowseat > 0){
					output += "<option name = 'rtabletype' value='WINDOWSEAT'>Window Seat</option>";
				}
				if(result.privateroom > 0){
					output += "<option name = 'rtabletype' value='PRIVATEROOM'>Private room</option>";
				}
				if(result.rental > 0){
					output += "<option name = 'rtabletype' value='RENTAL'>Rental</option>";
				}
	 			
	 			$("#rtabletype").append(output);
	 			$("#rtabletype").niceSelect('destroy');
				$("#rtabletype").niceSelect();
	 			
	 		},
	 		error: function() {
	 			alert("errorrrrr");
	 		}
 		});
	});
	
	
	$("#rtabletype").on('change', selectBoxRtabletype);	
	
	/*
	 * select rtabletype
	 */
	function selectBoxRtabletype(){
		rtabletype = $("#rtabletype").val();
		var objParams = {	
							"sid" : sid,
							"rdate" : rdate,
							"rtabletype" : rtabletype
	                    };	
	    
	    $.ajax({
	 		type: "POST",
	 		url: "select_guestnumber",
	 		dataType : "json",
	 		data: objParams,
	 		cache: false,
	 		success: function(result){
	 			var minOccupiedTableNum = parseInt(result.minOccupiedTableNum);
	 			var rtabletypeNum = parseInt(result.rtabletypeNum);
	 			//alert(minOccupiedTableNum);
	 			//alert(rtabletypeNum);
	 			
	 			let output = "";
	 			for(var i = 1; i <= (rtabletypeNum - minOccupiedTableNum) * 2; i++){
					output += "<option name = 'guestnumber' value = '" + i + "'>" + i + "</option>";
	 			}
	 			
	 			$("#guestnumber").append(output);
	 			$("#guestnumber").niceSelect('destroy');
				$("#guestnumber").niceSelect();
	 			
	 		},
	 		error: function() {
	 			alert("errorrrrr");
	 		}
 		});
	}
	
	
	
	$("#guestnumber").on('change', selectBoxRtime);	
	
	/*
	 * select guestnumber
	 */
	function selectBoxRtime(){
		guestnumber = $("#guestnumber").val();
		//alert(sid);
		//alert(rdate);
		//alert(rtabletype);
		//alert(guestnumber);

		var objParams = {
							"sid" : sid,
							"rdate" : rdate,
							"rtabletype" : rtabletype,
							"guestnumber" : guestnumber
						}
		
		$.ajax({
			type: "POST",
			url: "select_rtime",
			dataType: "json",
			data: objParams,
			cache: false,
			success: function(result){
				//alert(result.time);
	 			let output = "";
				
				for (var key in result) {
	                if (result.hasOwnProperty(key)) {
	                    var time = result[key];
	                    output += "<option name='rtime' value='" + time + "'>" + time + "</option>";
	                }
            	}
            	
	 			$("#rtime").append(output);
	 			$("#rtime").niceSelect('destroy');
				$("#rtime").niceSelect();
			},
			error: function(){
				 alert("errorrrrr");
			}
		}); //ajax
	} //function
	
	
	
	/*
	 * 예약버튼
	 */
	$("#btnReservation").click(function(){
		if($("#rdate").val() == ""){
			alert("Please select a date");
			$("#rdate").focus();
			return false;
		}else if($("#rtabletype").val() == "default"){
			alert("Please select a 'Seating Options'");
			$("#rtabletype").focus();
			return false;
		}else if($("#guestnumber").val() == "default"){
			alert("Please select a 'Party Size'");
			$("#guestnumber").focus();
			return false;
		}else if($("#rtime").val() == "default"){
			alert("Please select a 'Time'");
			$("#rtime").focus();
			return false;
		}
		else{
			reservationForm.submit();	
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
			url: "booking_with_payment", 
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
				location.href = "http://localhost:9000/catchmind/mydining_scheduled";
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
			    	})ne(function(data) {
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
				m_redirect_url : "http://localhost:9000/catchmind/mydining_scheduled"
			}, function (rsp) {
			    if (rsp.success) {
			    	alert("rsp.success");
			    	//[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
			    	$.ajax({
			    		type: 'POST',
			    		url: "/verifyIamport/" + rsp.imp_uid  //cross-domain error가 발생하지 않도록 주의해주세요
			    	})ne(function(data) {
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
