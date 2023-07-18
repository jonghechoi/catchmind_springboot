$(document).ready(function() {
	/*======================= 네비게이션-바에서 메뉴 클릭시 관련 페이지 가져오기 =======================*/
	// 네이게이션바 active 변환
	function activeFunc(activeLi) {
		$(".active").css("color", "#777777");
		$(".active").toggleClass("active");
		$(activeLi).toggleClass("active");
		$(".active").css("color", "white");
	}

	// member
	var prevListOn = false;
	$("#li_MemberAdmin").click(function() {
		// 이미 올라가 있는 iframe 내리기
		$("#shopInformationIframe").css("display", "none");				
		$("#reserveIframe").css("display", "none");
		$("#reviewIframe").css("display", "none");
		$("#noticeIframe").css("display", "none");
		
		if(!prevListOn) {
			$("#memberIframe").css("display", "block");
			$("#memberIframe").contents().find("#memberList").css("display", "block");
		}else {
			var iframe = document.getElementById("memberIframe");
			if (iframe) {
			  iframe.parentNode.removeChild(iframe); // 기존의 iframe 제거
			}
			
			var newIframe = document.createElement("iframe");
			newIframe.src = "admin_member_list.do";
			newIframe.id = "memberIframe";
			newIframe.scrolling = "no";
			newIframe.width = "100%";
			newIframe.height = "400px";
			newIframe.frameBorder = "0";
			newIframe.style.display = "block";
			
			var memberDiv = document.querySelector(".member");
			memberDiv.append(newIframe);
		}
		prevListOn = true;
		
		// 네비게이션바 백그라운드 색깔 변환
		activeFunc(this);
	});
	
	// shop information
	$("#li_ShopInfoAdmin").click(function() {	
		$("#memberIframe").css("display", "none");
		$("#reserveIframe").css("display", "none");
		$("#reviewIframe").css("display", "none");
		$("#noticeIframe").css("display", "none");
		
		$("#shopInformationIframe").css("display", "block");
		
		// 네비게이션바 백그라운드 색깔 변환
		activeFunc(this);
	});
	
	// reservation
	$("#li_ReservAdmin").click(function() {	
		$("#memberIframe").css("display", "none");
		$("#shopInformationIframe").css("display", "none");
		$("#reviewIframe").css("display", "none");
		$("#noticeIframe").css("display", "none");
		
		$("#reserveIframe").css("display", "block");
		
		// 네비게이션바 백그라운드 색깔 변환
		activeFunc(this);
	});			
	
	// review
	$("#li_ReviewAdmin").click(function() {	
		$("#memberIframe").css("display", "none");
		$("#shopInformationIframe").css("display", "none");
		$("#reserveIframe").css("display", "none");
		$("#noticeIframe").css("display", "none");
		
		$("#reviewIframe").css("display", "block");
		
		// 네비게이션바 백그라운드 색깔 변환
		activeFunc(this);
	});
	
	// notification
	$("#li_NotiAdmin").click(function() {	
		$("#memberIframe").css("display", "none");
		$("#shopInformationIframe").css("display", "none");
		$("#reserveIframe").css("display", "none");
		$("#reviewIframe").css("display", "none");
		
		$("#noticeIframe").css("display", "block");
		
		// 네비게이션바 백그라운드 색깔 변환
		activeFunc(this);
	});
	/*======================= 네비게이션-바에서 메뉴 클릭시 관련 페이지 가져오기 =======================*/
	/*======================= member_info -> member_modify로 데이터 넘기기 =======================*/
	$("#btnMemberModification").click(function() {
		$.ajax({
			url:"member_modify_data.do?mid="+$("#memberId").text(),
			success: function(result) {
			  const popup = window.open("member_modify.do?mid="+result, 'Member Modification', 'width=700px,height=700px, scrollbars=yes');
			}
		});
  	});
	/*======================= member_info -> member_modify로 데이터 넘기기 =======================*/
	
	/*======================= member_modify에서 버튼 누르면 정보 업데이트 =======================*/
	$("#btnMemberModificationUpdate").click(function() {
		if($("#inputName").val() == "") {
			alert("이름을 입력하세요");
			$("#inputName").focus();
			return false;
		}else if($("#inputId").val() == "") {
			alert("ID를 입력하세요");
			$("#inputId").focus();
			return false;		
		}else if($("#inputEmail").val() == "") {
			alert("이메일을 입력하세요");
			$("#inputEmail").focus();
			return false;		
		}else if($("#inputPhone").val() == "") {
			alert("연락처를 입력하세요");
			$("#inputPhone").focus();
			return false;		
		}else { 
			//memberDetailModificationForm.submit();
			var queryString = $("form[name=memberDetailModificationForm]").serialize() ;
			$.ajax({
	            url: "member_modify_update.do",
	            method: "POST",
	            data: queryString,
	            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
	            dataType: "text",
	            success: function(response) {
	                if (response == 1) {
	                    alert("Success");
	                    window.close();
	                } else {
	                    alert("Fail - Member Update");
	                }
	            },
	            error: function() {
	                alert("서버와의 통신 중 오류가 발생했습니다.");
           		}
        	});
		}
	});
	/*======================= member_modify에서 버튼 누르면 정보 업데이트 =======================*/



	/*======================= member_info -> member_modify로 데이터 넘기기 =======================*/
//	$("#btnNoticeModificationUpdate").click(function() {
//		$.ajax({
//			url:"notice_update_data.do?nid="+$("#titleInputHidden").val(),
//			success: function(result) {
//			  const popup = window.open("member_modify.do?mid="+result, 'Member Modification', 'width=700px,height=700px, scrollbars=yes');
//			}
//		});
// 	});
	/*======================= member_info -> member_modify로 데이터 넘기기 =======================*/	
	
	
	
	/*======================= admin 페이지의 notice_update에서 업데이트 성공적으로 되면 확인 alert추가 =======================*/
	$("#btnNoticeModificationUpdate").click(function() {
		if($("#titleInput").val() == "") {
			alert("Please Check if Notice Title is written.");
			$("#titleInput").focus();
			return false;		
		}else if($("#contentTA").val() == "") {
			alert("Please Check if Notice Content is written.");
			$("#contentTA").focus();
			return false;		
		}else { 
			var queryString = $("form[name=adminNoticeModificationForm]").serialize() ;
			$.ajax({
	            url: "notice_update_proc.do",
	            method: "POST",
	            data: queryString,
//	            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
	            dataType: "text",
	            success: function(result) {
	                if (result == 1) {
	                    alert("Success!! - Notice Update");
	                    $(location).attr('href', 'notice_list.do');
	                } else {
	                    alert("Fail!! - Notice Update");
	                }
	            },
	            error: function() {
	                alert("Error Happend");
           		}
        	});
		}
	});	
	
	/*======================= admin 페이지의 notice_update에서 업데이트 성공적으로 되면 확인 alert추가 =======================*/


	
	/*======================= admin 페이지의 notice_update에서 페이지 뒤로가기&리스트로 돌아가기 =======================*/
	$(".toPrev").click(function() {
	    window.history.back();
	});

	$(".toList").click(function() {
	    window.history.go(-2);
	});
	/*======================= admin 페이지의 notice_update에서 페이지 뒤로가기&리스트로 돌아가기 =======================*/

	
	
	/*======================= admin 페이지의 shop_registeration_enter에서 등록 버튼  =======================*/
	$("#btnShopRegisteration").click(function() {
		if($("#inputShopName").val() == "") {
			alert("Please Check if Shop Name is written.");
			$("#inputShopName").focus();
			return false;		
		}else if($("#inputShopPhone").val() == "") {
			alert("Please Check if Shop Contact Number is written.");
			$("#inputShopPhone").focus();
			return false;	
		}else if($("#inputShopFoodStyle").val() == "") {
			alert("Please Check if Shop Food Style is written.");
			$("#inputShopFoodStyle").focus();
			return false;		
		}else if($("inputShopLocation").val() == "") {
			alert("Please Check if Location is written.");
			$("#inputShopLocation").focus();
			return false; 
		}else if($("inputShopAddress").val() == "") {
			alert("Please Check if Shop Address is written.");
			$("#inputShopAddress").focus();
			return false; 
		}else { 
			var queryString = $("form[name=shopRegisterationForm]").serialize() ;
			$.ajax({
	            url: "admin_shop_registeration_proc.do",
	            method: "POST",
	            data: queryString,
//	            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
	            dataType: "text",
	            success: function(result) {
	                if (result == 1) {
	                    alert("Success!! - Shop Registered");
	                    $(location).attr('href', 'admin_shop_registeration_enter.do');
	                } else {
	                    alert("Fail!! - Shop Registered Failed");
	                }
	            },
	            error: function() {
	                alert("Error Happend");
           		}
        	});
		}
	});
	/*======================= admin 페이지의 shop_registeration_enter에서 등록 버튼  =======================*/	



	/*======================= shop_information에 로그인한 shop의 sid값 체크해서 해당 가게의 메인정보 띄워지게  =======================*/
	
	
	
	/*======================= shop_information에 로그인한 shop의 sid값 체크해서 해당 가게의 메인정보 띄워지게  =======================*/



	/*======================= shop_information 페이지에서 shop 상세 정보 입력 버튼  =======================*/	
	var facilityData = {};
	$("#btnShopFacilityDetailUpdate").click(function() {
		facilityData.parkingdesc = $('#parkingdesc').val();
		facilityData.valetdesc = $('#valetdesc').val();
		facilityData.adultonlydesc = $('#adultonlydesc').val();
		facilityData.sommelierdesc = $('#sommelierdesc').val();
		facilityData.letteringdesc = $('#letteringdesc').val();
		facilityData.rentalsdesc = $('#rentalsdesc').val();
		
		localStorage.setItem('facilityData', JSON.stringify(facilityData));
		
		window.close();
	});
	
	
	$("#btnShopDetailInformation").click(function() {
		const depositValue = $("#sdeposit").val();
		const depositLength = depositValue.length;
		const mealfeeValue = $("#smealfee").val();
		const mealfeeLength = mealfeeValue.length;
		const lunchValue = $("#lunch").val();
		const lunchLength = lunchValue.length;
		const dinnerValue = $("#dinner").val();
		const dinnerLength = dinnerValue.length;
		
		if($("#sintro").val() == "") {
			alert("Please Check if Shop Intro is written.");
			$("#sintro").focus();
			return false;		
		}else if($("#sopeninghour").val() == "") {
			alert("Please Check if Shop Opening Hour is chosen.");
			$("#sopeninghour").focus();
			return false;		
		}else if($("sclosinghour").val() == "") {
			alert("Please Check if Shop Closing Hour is chosen.");
			$("#sclosinghour").focus();
			return false; 
		}else if($("sclosingdate").val() == "") {
			alert("Please Check if Shop Closing Date is written.");
			$("#sclosingdate").focus();
			return false; 
		}else if($("#sdeposit").val() == "" || depositLength > 8) {
			alert("Please Check if Shop Deposit is written or Amount is too big.");
			$("#inputDeposit").focus();
			return false;
		}else if($("#smealfee").val() == "" || mealfeeLength > 8) {
			alert("Please Check if Shop MealFee is written or Amount is too big.");
			$("#inputMealFee").focus();
			return false; 
		}else if($("#lunch").val() == "" || lunchLength > 8) {
			alert("Please Check if Shop Lunch is written or Amount is too big.");
			$("#inputLunch").focus();
			return false; 						 			
		}else if($("#dinner").val() == "" || dinnerLength > 8) {
			alert("Please Check if Shop Dinner is written or Amount is too big.");
			$("#inputDinner").focus();
			return false; 						 			
		}else { 
			var storedFacilityData = JSON.parse(localStorage.getItem('facilityData'));
			
			if(storedFacilityData == null) {
				var storedFacilityData = {};
			}
			
			// 체크박스 name, value(1,0) 매핑해서 객체에 넣음
			var facilitys = document.getElementsByClassName('facility');
			for(i=0; i<facilitys.length; i++) {
				var temp = facilitys[i].name;
				storedFacilityData[temp] = facilitys[i].checked ? 1 : 0;
			}
			storedFacilityData.sid = document.getElementById('sid').value;
			
        	var shopData = {
				sintro : $('#sintro').val(),
				sopeninghour : $('#sopeninghour').val(),
				sclosinghour : $('#sclosinghour').val(),
				sclosingdate : $('#sclosingdate').val(),
				sdeposit : $('#sdeposit').val(),
				smealfee : $('#smealfee').val(),
				lunch : $('#lunch').val(),
				dinner : $('#dinner').val(),
				sid : $('#sid').val()
			};
        	
        	/*======= shop photo =======*/
        	var files = {};
        	var filesCheck = {
        						file1 : 0,
        						file2 : 0,
        						file3 : 0,
        						file4 : 0,
        						file5 : 0,
        					 };
        	var fileInput1 = $("input[type='file'][name='images1']")[0];
        	if(fileInput1.files.length != 0) {
        		files["file1"] = fileInput1.files[0];
        		filesCheck["file1"] = 1;
        	}
        	var fileInput2 = $("input[type='file'][name='images2']")[0];
        	if(fileInput2.files.length != 0) {
        		files["file2"] = fileInput2.files[0];
        		filesCheck["file2"] = 1;
        	}
        	var fileInput3 = $("input[type='file'][name='images3']")[0];
        	if(fileInput3.files.length != 0) {
        		files["file3"] = fileInput3.files[0];
        		filesCheck["file3"] = 1;
        	}
        	var fileInput4 = $("input[type='file'][name='images4']")[0];
        	if(fileInput4.files.length != 0) {
        		files["file4"] = fileInput4.files[0];
        		filesCheck["file4"] = 1;
        	}
        	var fileInput5 = $("input[type='file'][name='images5']")[0];
        	if(fileInput5.files.length != 0) {
        		files["file5"] = fileInput5.files[0];
        		filesCheck["file5"] = 1;
        	}
        	
        	if(Object.keys(files).length== 0) {
        		alert("Register at least one Photo");
        		return;
        	}
				
			var formData = new FormData();
			for(var key in files) {
				formData.append("photos", files[key]);
			}
			for(var key in filesCheck) {
				console.log(key + ": " + filesCheck[key]);
			}
			
			formData.append("files", JSON.stringify(filesCheck));
			formData.append("sid", $('#sid').val());
			
        	$.ajax({
        		url: "shop_information_photo.do",
        		method: "POST",
        		data: formData,
        		contentType: false,
        		processData: false,
        		success: function(result) {
        			if(result == 1) {
        				alert("Photo Upload Complete");
        			}else {
        				alert("Photo Upload Fail");
        			}
        		},
        		error: function(error) {
        			alert("Photo Upload Error Occured"); 
        		}
        	});
        	/*======= shop photo =======*/
        	
			$.ajax({
	            url: "shop_information_proc.do",
	            method: "POST",
	            data: shopData,
	            dataType: "text",
	            success: function(result) {
	                if (result == 1) {
	                    alert("Success!! - Shop Registration Form Request To Admin");
	                }else {
	                    alert("Fail!! - Shop Registered Failed");
	                }
	            }
        	});

			$.ajax({
	            url: "shop_information_facility_proc.do",
	            method: "POST",
	            data: storedFacilityData,
	            dataType: "text",
	            success: function(result) {
	                if (result == 1) {
	                    $(location).attr('href', 'index.do');
	                }else {
	                    alert("Fail!! - Shop Facility Registered Failed");
	                }
	            },
	            error: function() {
	                alert("Error Happend shop_information_facility_proc.do");
           		}
        	});

		}
	});	
	/*======================= shop_information 페이지에서 shop 상세 정보 입력 버튼  =======================*/	
	
	
	
	/*======================= shop_information 페이지에서 shop facility 진입 버튼  =======================*/	
	$("#btnShopFacilityDetail").click(function() {
		const sidValue = $('#sid').val();
  		const queryString = "?sid=" + encodeURIComponent(sidValue);
		const popup = window.open("shop_information_facility.do" + queryString, 'Facility Information', 'width=700px,height=1200px, scrollbars=yes');
	});
	/*======================= shop_information 페이지에서 shop facility 진입 버튼  =======================*/	
	
	
	
	/*======================= admin_shop_information.do 페이지에서 (waiting)  =======================*/	
	function adminShopWaiting() {
		$.ajax({
			url: "admin_shop_information_List.do?sconfirm=true&aconfirmfinal=false",
			success: function(result) {
				let jdata = JSON.parse(result);
				
				$("section.s2").empty();
				
				let output = "";
				output += "<div class='shopInfoList' style='height:300px; overflow:auto'>";
				for(obj of jdata.jlist) {
					output += "<div class='restaurantList " + obj.sid + "'>"; 
					output += "<div class='restaurantInfo admin'>"; 
					output += "<span>" + obj.sname + "</span>";
					output += "<span>" + obj.slocshort + "</span>"; 
					output += "</div>";	
					output += "</div>";	
					output += "<hr style='margin:0px'>";
					
					let outputDetail = "";
					outputDetail += "<div id='shopInfoDetail'>";
					outputDetail += "<div>";
				 	outputDetail += "<div class='shopInfoDetail'>";
				 	outputDetail += "<div>"; 
					outputDetail += "<span>Shop  :  </span>"; 
					outputDetail += "<span>" + obj.sname + "</span>";
					outputDetail += "</div>";
					outputDetail += "<div>";
					outputDetail += "<span>ID  :  </span>";
					outputDetail += "<span>" + obj.sid + "</span>";  					
					outputDetail += "</div>";
					outputDetail += "<div>";
					outputDetail += "</div>";
					outputDetail += "<div>";
					outputDetail += "<span>Phone  :  </span>";   
					outputDetail += "<span>" + obj.sphone + "</span>";
					outputDetail += "</div>";
					outputDetail += "<div>";
					outputDetail += "<span>Address  :  </span>";
					outputDetail += "<span>" + obj.sloc + "</span>";  
					outputDetail += "</div>";
					outputDetail += "<div>";
					outputDetail += "<span>Intro  :  </span>";
					outputDetail += "<span>" + obj.sintro + "</span>";  
					outputDetail += "</div>";
					outputDetail += "<div>";
					outputDetail += "<span>Opening  :  </span>";
					outputDetail += "<span>" + obj.sopeninghour + "</span>"; 						
					outputDetail += "</div>";
					outputDetail += "<div>";
					outputDetail += "<span>Closing  :  </span>";
					outputDetail += "<span>" + obj.sclosinghour + "</span>"; 
					outputDetail += "</div>";
					outputDetail += "<div>";
					outputDetail += "<span>MealFee  :  </span>";
					outputDetail += "<span>" + obj.smealfee + "</span>";
					outputDetail += "</div>";
					outputDetail += "<div>";
					outputDetail += "<span>Lunch  :  </span>"; 
					outputDetail += "<span>" + obj.lunch + "</span>"; 
					outputDetail += "</div>";
					outputDetail += "<div>";
					outputDetail += "<span>Dinner  :  </span>";
					outputDetail += "<span>" + obj.dinner + "</span>";
					outputDetail += "</div>";
					outputDetail += "</div>";
					outputDetail += "<div class='confirm'>";					
					outputDetail += "<form name='confirmForm' action='#' method='get'>";
					outputDetail += "<button type='button' class='btnConfirm' id='btnConfirm_" + obj.sid + "'>confirm</button>";
					outputDetail += "<button type='button' class='btnCancel' id='btnCancel_" + obj.sid + "'>cancel</button>";
					outputDetail += "</form>";
					outputDetail += "</div>";
					outputDetail += "</div>";
					outputDetail += "</div>";	
								
					adminShopDetail(obj.sid, outputDetail);
					$(document).off("click", "#btnConfirm_" + obj.sid);
					adminShopConfirm(obj.sid);
					adminShopCancel(obj.sid);
				}
				output += "</div>";
				
				$("section.s2").append(output);
			}
		});
	}
	
	$("#adminShopWaiting").click(function() {
		adminShopWaiting();
	});
	
	function adminShopDetail(sid, outputDetail) {
		$(document).on("click", "." + sid, function() {
			$(".shopInfoList").next("div").remove();
			$(".shopInfoList").after(outputDetail);
		});		
	}
	
	function adminShopConfirm(sid) {
		$(document).on("click", "#btnConfirm_" + sid, function() {
			$.ajax({
				url: "admin_shop_information_waiting_confirm.do?sid=" + sid,
				success: function(result) {
					if(result == 1) {
						alert("Shop Register Completed.");
						adminShopWaiting();
					}
				}
			});
		});		
	}
	 
	function adminShopCancel(sid) {
		$(document).on("click", "#btnCancel_" + sid, function() {
			$.ajax({
				url: "admin_shop_information_waiting_cancel.do?sid=" + sid,
				success: function(result) {
					if(result == 1) {
						alert("Shop Register Canceled.");
						adminShopWaiting();
					}
				}
			});
		});		
	} 
	
	/*======================= admin_shop_information.do 페이지에서 (waiting) =======================*/	
	

	
	/*======================= admin_shop_information.do 페이지에서 (completed) =======================*/
	$("#adminShopCompleted").click(function() {
		$.ajax({
			url: "admin_shop_information_List.do?sconfirm=true&aconfirmfinal=true",
			success: function(result) {
				let jdata = JSON.parse(result);
				
				$("section.s2").empty();
				
				let output = "";
				output += "<div class='shopInfoList' style='height:300px; overflow:auto'>";
				for(obj of jdata.jlist) {
					output += "<div class='restaurantList " + obj.sid + "'>"; 
					output += "<div class='restaurantInfo admin'>"; 
					output += "<span>" + obj.sname + "</span>";
					output += "<span>" + obj.slocshort + "</span>"; 
					output += "</div>";	
					output += "</div>";	
					output += "<hr style='margin:0px'>";
					
					let outputDetail = "";
					outputDetail += "<div id='shopInfoDetail'>";
					outputDetail += "<div>";
				 	outputDetail += "<div class='shopInfoDetail'>";
				 	outputDetail += "<div>"; 
					outputDetail += "<span>Shop  :  </span>"; 
					outputDetail += "<span>" + obj.sname + "</span>";
					outputDetail += "</div>";
					outputDetail += "<div>";
					outputDetail += "<span>ID  :  </span>";
					outputDetail += "<span>" + obj.sid + "</span>";  					
					outputDetail += "</div>";
					outputDetail += "<div>";
					outputDetail += "</div>";
					outputDetail += "<div>";
					outputDetail += "<span>Phone  :  </span>";   
					outputDetail += "<span>" + obj.sphone + "</span>";
					outputDetail += "</div>";
					outputDetail += "<div>";
					outputDetail += "<span>Address  :  </span>";
					outputDetail += "<span>" + obj.sloc + "</span>";  
					outputDetail += "</div>";
					outputDetail += "<div>";
					outputDetail += "<span>Intro  :  </span>";
					outputDetail += "<span>" + obj.sintro + "</span>";  
					outputDetail += "</div>";
					outputDetail += "<div>";
					outputDetail += "<span>Opening  :  </span>";
					outputDetail += "<span>" + obj.sopeninghour + "</span>"; 						
					outputDetail += "</div>";
					outputDetail += "<div>";
					outputDetail += "<span>Closing  :  </span>";
					outputDetail += "<span>" + obj.sclosinghour + "</span>"; 
					outputDetail += "</div>";
					outputDetail += "<div>";
					outputDetail += "<span>MealFee  :  </span>";
					outputDetail += "<span>" + obj.smealfee + "</span>";
					outputDetail += "</div>";
					outputDetail += "<div>";
					outputDetail += "<span>Lunch  :  </span>"; 
					outputDetail += "<span>" + obj.lunch + "</span>"; 
					outputDetail += "</div>";
					outputDetail += "<div>";
					outputDetail += "<span>Dinner  :  </span>";
					outputDetail += "<span>" + obj.dinner + "</span>";
					outputDetail += "</div>";
					outputDetail += "</div>";
					outputDetail += "<div class='confirm'>";					
					//outputDetail += "<form name='confirmForm' action='#' method='get'>";
					//outputDetail += "<button type='button' class='btnConfirm'>confirm</button>";
					//outputDetail += "<button type='button' class='btnCancel'>cancel</button>";
					//outputDetail += "</form>";
					outputDetail += "</div>";
					outputDetail += "</div>";
					outputDetail += "</div>";	
								
					adminShopDetail(obj.sid, outputDetail)
				}
				output += "</div>";
				
				$("section.s2").append(output);
			}
		});
	});	
	/*======================= admin_shop_information.do 페이지에서 (completed) =======================*/



	/*======================= admin_review_detail.do 페이지에서 'selected review' 버튼 처리 =======================*/
	$("#adminReviewSelected").click(function() {
	    window.open("admin_review_selected.do", 'Review For Main', 'width=905px,height=800px, scrollbars=yes');
	});
	/*======================= admin_review_detail.do 페이지에서 'selected review' 버튼 처리 =======================*/
});

/*======================= index.jsp 페이지에서 book now =======================*/	
function mainBookNowToSearch(bookNowDate, bookNowLocation, bookNowCuisine) {
	console.log(bookNowDate);
	console.log(bookNowLocation);
	console.log(bookNowCuisine);

	$.ajax({
		url: "search_list_book_now_proc.do?date=" + bookNowDate + "&location=" + bookNowLocation + "&cuisine=" + bookNowCuisine,
		success: function(result) {
			 let jdata = JSON.parse(result);
			 if(jdata.jlist != "") {
			 	console.log("여기 들어옴~~~ search_list_book_now_proc");
		        $(".rb").empty();
		        let output = "";
		        for (const obj of jdata.jlist) {
		        	output += "<a href='restaurant.do?sid=" + obj.sid + "'>";
                    output += "<div class='saved-restaurant-list-item' style='margin-bottom: 20px; padding-bottom: 10px;' >";
                    output += "<div class='restaurant-info'>";
                    output += "<div class='tb'>";
                    output += "<div class='img' style='background-image:url(" + obj.smphoto + ");'>";
                    output += "</div>";
                    output += "</div>";
                    output += "<div class='detail'>";
                    output += "<div class='detail-header'>";
                    output += "<div class='txt'>";
                    output += "<h4 class='name'>" + obj.sname + "</h4>";
                    output += "<p class='excerpt'>" + obj.sintro + "<br>";
                    output += "</p>";
                    output += "</div>";
                    output += "</div>";
                    output += "<div class='restaurant-meta'>";
                    output += "<div class='__d-flex mb-6'>";
                    output += "<div class='rating'>";
                    output += "<span class='star'>" + "★ " +obj.reviewstar + "</span>&nbsp;";
                    output += "</div>";
                    output += "<div style='text-align: right; width: 100%;'>";
                    output += "</div>";
                    output += "</div>";
                    output += "<span class='tags'>" + obj.slocshort + "&nbsp&nbsp&nbsp&nbsp&nbsp | &nbsp&nbsp&nbsp&nbsp&nbsp" + "L "+obj.lunch + " /&nbsp" + "D "+obj.dinner + "</span>";
                    //output += "<span class='price'>" + obj.lunch + "<br>" + obj.dinner + "<br>";
                    output += "</span>";
                    output += "</div>";
                    output += "<div class='timetable-list timetable-list-sm'>";
                    output += "<a href='#' id='DEFAULT_itemElem_1830' class='timetable-list-item'style='margin-bottom: auto; margin-top: auto; min-width: 70px;'>";
                    output += "<span class='time'>" + obj.sopeninghour + "</span>";
                    output += "</a>";
                    output += "</div>";
                    output += "</div>";
                    output += "</div>";
                    output += "</div>";
                    output += "</a>"
                    output += "<hr>";
		        }
		        $(".rb").append(output);
		    }else {
		    	$(".rb").empty();
		    }
		}
	})

}	
	
	
/*======================= index.jsp 페이지에서 book now =======================*/	



/*======================= index.jsp 페이지에서 음식 종류 클릭했을때 search 페이지 이동 및 리스팅 =======================*/	
function mainToSearch(searchQuery, searchUrl) {
	 $.ajax({
	    url: "search_list_proc.do?searchQuery=" + searchQuery,
	    async:false,
	    success: function(result) {
	        let jdata = JSON.parse(result);
	        if(jdata.jlist != "") {
		        $(".rb").empty();
		        let output = "";
		        for (const obj of jdata.jlist) {
		        	output += "<a href='restaurant.do?sid=" + obj.sid + "'>";
                    output += "<div class='saved-restaurant-list-item' style='margin-bottom: 20px; padding-bottom: 10px;' >";
                    output += "<div class='restaurant-info'>";
                    output += "<div class='tb'>";
                    output += "<div class='img' style='background-image:url(" + obj.smphoto + ");'>";
                    output += "</div>";
                    output += "</div>";
                    output += "<div class='detail'>";
                    output += "<div class='detail-header'>";
                    output += "<div class='txt'>";
                    output += "<h4 class='name'>" + obj.sname + "</h4>";
                    output += "<p class='excerpt'>" + obj.sintro + "<br>";
                    output += "</p>";
                    output += "</div>";
                    output += "</div>";
                    output += "<div class='restaurant-meta'>";
                    output += "<div class='__d-flex mb-6'>";
                    output += "<div class='rating'>";
                    output += "<span class='star'>" + "★ " +obj.reviewstar + "</span>&nbsp;";
                    output += "</div>";
                    output += "<div style='text-align: right; width: 100%;'>";
                    output += "</div>";
                    output += "</div>";
                    output += "<span class='tags'>" + obj.slocshort + "&nbsp&nbsp&nbsp&nbsp&nbsp | &nbsp&nbsp&nbsp&nbsp&nbsp" + "L "+obj.lunch + " /&nbsp" + "D "+obj.dinner + "</span>";
                    //output += "<span class='price'>" + obj.lunch + "<br>" + obj.dinner + "<br>";
                    output += "</span>";
                    output += "</div>";
                    output += "<div class='timetable-list timetable-list-sm'>";
                    output += "<a href='#' id='DEFAULT_itemElem_1830' class='timetable-list-item'style='margin-bottom: auto; margin-top: auto; min-width: 70px;'>";
                    output += "<span class='time'>" + obj.sopeninghour + "</span>";
                    output += "</a>";
                    output += "</div>";
                    output += "</div>";
                    output += "</div>";
                    output += "</div>";
                    output += "</a>"
                    output += "<hr>";
		        }
		        $(".rb").append(output);
		        localStorage.setItem('searchQuery', JSON.stringify(''));
		    }else {
		    	$(".rb").empty();
		    }
	    }
	});
}

function getParameterByName(name, url) {
	name = name.replace(/[\[\]]/g, "\\$&");
	var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)");
	var results = regex.exec(url);
	if (!results) return null;
	if (!results[2]) return "";
	return decodeURIComponent(results[2].replace(/\+/g, " "));
}
/*======================= index.jsp 페이지에서 음식 종류 클릭했을때 search 페이지 이동 및 리스팅 =======================*/	



/*======================= index 페이지에서 지도 클릭 후 search 페이지 이동 =======================*/
function mapMainToSearch() {
	var lat = localStorage.getItem('lat');
	var lng = localStorage.getItem('lng');
	$.ajax({
		url:"index_mapMarker.do",
		data: {
			lat: lat,
			lng: lng
		},
		success: function(result) {
	        fdata = result;
	        let jdata = JSON.parse(result);
	        
	        let output = "";
	        for (const obj of jdata.jlist) {
	            	output += "<a href='restaurant.do?sid=" + obj.sid + "'>";
                    output += "<div class='saved-restaurant-list-item' style='margin-bottom: 20px; padding-bottom: 10px;' >";
                    output += "<div class='restaurant-info'>";
                    output += "<div class='tb'>";
                    output += "<div class='img' style='background-image:url(" + obj.smphoto + ");'>";
                    output += "</div>";
                    output += "</div>";
                    output += "<div class='detail'>";
                    output += "<div class='detail-header'>";
                    output += "<div class='txt'>";
                    output += "<h4 class='name'>" + obj.sname + "</h4>";
                    output += "<p class='excerpt'>" + obj.sintro + "<br>";
                    output += "</p>";
                    output += "</div>";
                    output += "</div>";
                    output += "<div class='restaurant-meta'>";
                    output += "<div class='__d-flex mb-6'>";
                    output += "<div class='rating'>";
                    output += "<span class='star'>" + "★ " +obj.reviewstar + "</span>&nbsp;";
                    output += "</div>";
                    output += "<div style='text-align: right; width: 100%;'>";
                    output += "</div>";
                    output += "</div>";
                    output += "<span class='tags'>" + obj.slocshort + "&nbsp&nbsp&nbsp&nbsp&nbsp | &nbsp&nbsp&nbsp&nbsp&nbsp" + "L "+obj.lunch + " /&nbsp" + "D "+obj.dinner + "</span>";
                    //output += "<span class='price'>" + obj.lunch + "<br>" + obj.dinner + "<br>";
                    output += "</span>";
                    output += "</div>";
                    output += "<div class='timetable-list timetable-list-sm'>";
                    output += "<a href='#' id='DEFAULT_itemElem_1830' class='timetable-list-item'style='margin-bottom: auto; margin-top: auto; min-width: 70px;'>";
                    output += "<span class='time'>" + obj.sopeninghour + "</span>";
                    output += "</a>";
                    output += "</div>";
                    output += "</div>";
                    output += "</div>";
                    output += "</div>";
                    output += "</a>"
                    output += "<hr>";
	        }
	        $(".rb").append(output);
		}
	})
}
/*======================= index 페이지에서 지도 클릭 후 search 페이지 이동 =======================*/



/*======================= shop_reservation.jsp 페이지에서 'datepicker'로 날짜 선택시 리스팅 =======================*/
function reservationListing() {
	$.ajax({
		url: "shop_reservation_proc.do",
		data: {
			sid : $("#shopReservationSid").val(),
			startDate :  $("#startDate").val(),
			endDate : $("#endDate").val()
		},
		success: function(result) {
			let jdata = JSON.parse(result);
			
			$("#reserveDetail").empty();
			
			let output = "";	
			for(obj of jdata.jlist) {
				output += "<div>"; 
				output += "<div class='reserveDetail'>";
				output += "<div>";
				output += "<span>Date  :  </span>";
				output += "<span>" + obj.rmodifydate + "</span>";
				output += "</div>";
				output += "<div>";
				output += "<span>Time  :  </span>";
				output += "<span>" + obj.rmodifytime + "</span>";
				output += "</div>";
				output += "<div>";
				output += "<span>Name  :  </span>";
				output += "<span>" + obj.mname + "</span>";
				output += "</div>";
				output += "<div>";
				output += "<span>ID  :  </span>";
				output += "<span>" + obj.mid + "</span>";
				output += "</div>";
				output += "<div>";
				output += "<span>Phone  :  </span>";
				output += "<span>" + obj.rphone + "</span>";
				output += "</div>";
				output += "<div>";
				output += "<span>GuestNumber  :  </span>";
				output += "<span>" + obj.guestnumber + "</span>";
				output += "</div>";
				output += "<div>";
				output += "<span>Request  :  </span>";
				output += "<span>" + obj.rrequest + "</span>";
				output += "</div>";
				output += "<div>";
				output += "<span>TableType  :  </span>";
				output += "<span>" + obj.rtabletype + "</span>";
				output += "</div>";
				output += "</div>";
				output += "</div>";
				output += "<hr>";	
			}	
			$("#reserveDetail").append(output);		
		}  		
	});
}
/*======================= shop_reservation.jsp 페이지에서 'datepicker'로 날짜 선택시 리스팅 =======================*/



/*======================= shop_reservation.jsp 페이지에서 shop photo 등록&프리뷰 =======================*/  	
function getimagePreview(e) {
	const file = e.currentTarget.files;
	const str = e.target.classList.value;
	const lastChar = str.charAt(str.length-1);
	const reader = new FileReader();

	reader.onload = (e) => {
		const previewImg = createPhotoElement(e, file[0], lastChar);
	};
	reader.readAsDataURL(file[0]);
}

function createPhotoElement(e, file, lastChar) {
	const img = document.querySelector('.upload_img'+lastChar);

	img.setAttribute('src', e.target.result);
	img.setAttribute('data-file', file.name);
	
	return img;
}	
	
function bringPhoto(sid, count, photos) {
	$.ajax({
		url:"shop_information_photoBring.do",
		data: {
			sid : sid,
			count : count,
			photos : JSON.stringify(photos) 
		},
		dataType: 'json',
//		xhrFields: {
//			responseType: 'arraybuffer'
//		},		
		success: function(arrayBuffers) {
	        // arrayBuffers는 JSON 데이터로 파싱된 객체
	        // 각각의 arraybuffer 값을 처리
	        for (var i = 0; i < arrayBuffers.length; i++) {
	           // var byteArray = new Uint8Array(arrayBuffers[i]);
	            
                var base64Data = arrayBuffers[i];
                var byteArray = base64ToByteArray(base64Data);

	            let previewImg = "";
	            if(i == 0) {
	            	previewImg = document.querySelector('.upload_img1');
	            }else if(i == 1) {
	            	previewImg = document.querySelector('.upload_img2');
	            }else if(i == 2) {
	            	previewImg = document.querySelector('.upload_img3');
	            }else if(i == 3) {
	            	previewImg = document.querySelector('.upload_img4');
	            }else if(i == 4) {
	            	previewImg = document.querySelector('.upload_img5');
	            }
				displayImage(previewImg, byteArray);
	        }
		}
	}); 
}	

function displayImage(previewImg, imageData) {
	var blob = new Blob([imageData], { type: 'image/jpg' });
	var imageUrl = URL.createObjectURL(blob);
	
	console.log("imageUrl --> " + imageUrl);
	
	previewImg.src = imageUrl;
}

function base64ToByteArray(base64Data) {
    var binaryString = atob(base64Data);
    var byteArray = new Uint8Array(binaryString.length);
    for (var i = 0; i < binaryString.length; i++) {
        byteArray[i] = binaryString.charCodeAt(i);
    }
    return byteArray;
}
/*======================= shop_reservation.jsp 페이지에서 shop photo 등록&프리뷰 =======================*/	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


        	
