$(document).ready(function() {
	/*======================= MyDining 페이지에서 mydining_visited 페이징 처리 =======================*/
	initAjax(1);
	
	function initAjax(page) {
		$.ajax({
			url: "mydining_visited_paging/"+page,
			success: function(result){
				console.log(result);
				//let jdata = JSON.parse(result);
				let output = "<div class='row mb_30'>";
				for(obj of result.list) {
					output += "<div class='col-lg-3 col-sm-6'>";
					output += "<div class='accomodation_item text-center'>";
					output += "<div class='hotel_img'>";
					output += "<img src='" + obj.smphoto + "' width='262px' height='272px' alt=''>";
					if (obj.reviewYN == 'N') {
					    output += "<a href='http://localhost:82/write_review/"+ obj.rid + "' class='btn theme_btn button_hover'>Write Review</a>";
					} else if (obj.reviewYN == 'Y') {
					    output += "<a href='/mypage_review' class='btn theme_btn button_hover' style='padding: 5px 1px;'>My Review Check</a>";
					}
					output += "</div>";			
					output += "<img src='/image/jhs_img/1000_F_412408259_m13MpFAxpttIh3jxxsRl3rbsbS5SjnVL.jpg' width='20px' height='20px' >";
					output += "<a href='#'><h4 class='sec_h4'>"+ obj.sname +"</h4></a>";			
					output += "<h5>"+ obj.rdate +"<br>"+ obj.rtime +"-"+ obj.guestNumber +" People <br><small>"+ obj.slocShort +"</small></h5>";
					output += "</div>";			
					output += "</div>";			
				}			
				output += "<div>";
				output += "<td colspan='4'><div id='ampaginationsm'></div></td>";
				output += "</div>";
				output += "</div>";			
				
				$("div.mb_30").remove();
				$("p#pooo").after(output);
				pager(result.page.dbCount, result.page.pageCount, result.page.pageSize, result.page.reqPage);
				//페이지 번호 클릭 이벤트 처리
				jQuery('#ampaginationsm').on('am.pagination.change',function(e){
			   		jQuery('.showlabelsm').text('The selected page no: '+e.page);
	           		
	           		initAjax(e.page); 
	           	});
           	}//success
		});//$.ajax
	};//initAjax	
	
	/* 페이징 처리 함수 */
	function pager(totals, maxSize, pageSize, page){
		var pager = jQuery('#ampaginationsm').pagination({
		    maxSize: maxSize,	    		// max page size
		    totals: totals,	// total pages	
		    page: page,		// initial page		
		    pageSize: pageSize,			// max number items per page
		
		    // custom labels		
		    lastText: '&raquo;&raquo;', 		
		    firstText: '&laquo;&laquo;',		
		    prevText: '&laquo;',		
		    nextText: '&raquo;',
				     
		    btnSize:'sm'	// 'sm'  or 'lg'		
		});
	};
	/*======================= MyDining 페이지에서 mydining_visited 페이징 처리 =======================*/
});