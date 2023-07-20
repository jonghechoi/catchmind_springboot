$(document).ready(function() {
	/*======================= admin 페이지에서 review_list 페이징 처리 =======================*/
	initAjax(1);
	
	function initAjax(page) {
		$.ajax({
			url: "/admin_review_list/" + page,
			success: function(result){
				let output = "<table id='reviewAdmin'>";
				output += "<tr>";
				output += "<th>No</th>";
				output += "<th>Name</th>";
				output += "<th>Restaurant</th>";
				output += "<th>Riview</th>";
				output += "<th>Star</th>";
				output += "<th>Date</th>";
				output += "<th></th>";
				output += "</tr>";
				
				for(obj of result.list) {
					output += "<tr>";
					output += "<td>" + obj.rno + "</td>";
					output += "<td>" + obj.mname + "</td>";
					output += "<td>" + obj.sid + "</td>";
					output += "<td>" + obj.reviewcontent + "</td>";
					output += "<td>" + obj.reviewstar + "</td>";
					output += "<td>" + obj.reviewcreatedate + "</td>";
					output += "<td><button type='button' name='name' id='btnReviewDetail_" + obj.rid + "'>Detail</button></td>";
					output += "</tr>";
					
					adminReviewDatail(obj.rid);
				}
							
				output += "<tr>";
				output += "<td colspan='8'><div id='ampaginationsm'></div></td>";
				output += "</tr>";
				output += "</table>";		
				
				$("table#reviewAdmin").remove();
				$("section.review.s2").append(output);
				
				pager(result.page.dbCount, result.page.maxSize, result.page.pageSize, result.page.page);
	
				//페이지 번호 클릭 이벤트 처리
				jQuery('#ampaginationsm').on('am.pagination.change',function(e){
			   		jQuery('.showlabelsm').text('The selected page no: '+e.page);
	           		//$(location).attr('href', "notice_list_paging?page="+e.page);
	           		
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
	/*======================= admin 페이지에서 review_list 페이징 처리 =======================*/
	
	
	
	/*======================= admin 페이지에서 review_detail =======================*/
	function adminReviewDatail(rid) {
		$(document).on("click", "#btnReviewDetail_" + rid, function() {
			const popup = window.open("/admin_review_detail/true/" + rid, 'Review Detail', 'width=700px,height=1200px, scrollbars=yes');
		});		
	}	
  	/*======================= admin 페이지에서 review_detail =======================*/
});