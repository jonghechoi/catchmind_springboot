$(document).ready(function() {
	/*======================= MyDining 페이지에서 mydining_visited 페이징 처리 =======================*/
	initAjax(1);
	
	function initAjax(page) {
		$.ajax({
			url: "/mydining_cancel_noshow/"+page,
			success: function(result){
				console.log(result);
				console.log(result.page);
				console.log(result.page.dbCount);
				console.log(result.page.pageCount);
				console.log(result.page.pageSize);
				console.log(result.page.reqPage);
				let output = "<div class='row mb_30'>";
				for(obj of result.list) {
					output += "<div class='col-lg-3 col-sm-6'>";
					output += "<div class='accomodation_item text-center'>";
					output += "<div class='hotel_img'>";
					output += "<img src='" + obj.smphoto + "' width='262px' height='272px' alt=''>";
					output += "</div>";
					if (obj.rstatus == 'CANCEL') {
						output += "<span class = 'cancel_noshow_M'>Canceled</span>";
					}else if(obj.rstatus == 'NOSHOW'){
						output += "<span class = 'cancel_noshow_M'>No-Show</span>";
					}
					output += "<a href='#'><h4 class='sec_h4'>"+ obj.sname +"</h4></a>";
					output += "<h5 id='cancel_re' style='color:lightgrey;'>" + obj.rdate + "<br>" + obj.rtime + "-" + obj.guestNumber + " People <br></h5>";
					output += "<h5 style='color:lightgrey;'><small style='color:lightgrey;'>" + obj.slocShort + "</small></h5>"
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