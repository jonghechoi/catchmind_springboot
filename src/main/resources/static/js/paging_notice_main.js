$(document).ready(function() {
	/*======================= admin 페이지에서 notice_list 페이징 처리 =======================*/
	initAjax(1);
	
	function initAjax(page) {
		$.ajax({
			url: "/notice_list_paging/"+page,
			success: function(result){
				//let jdata = JSON.parse(result);
				
				let output = "<table class='board_list'>";
				output += "<tr>";
				output += "<td colspan='3'>";
				output += "</td>";
				output += "</tr>";
				output += "<tr>";
				output += "<th>No</th>";
				output += "<th>Title</th>";
				output += "<th>Reporting Date</th>";
				output += "</tr>";

				for(obj of result.jlist) {
					output += "<tr>";
					output += "<td>" + obj.rno + "</td>";
					output += "<td><a href='/notice_content/" + obj.nid + "'>" + obj.ntitle + "</a></td>";
					output += "<td>" + obj.ncreatedate + "</td>";
					output += "</tr>";
				}				
				
				output += "<tr>";
				output += "<td colspan='3'><div id='ampaginationsm'></div></td>";
				output += "</tr>";
				output += "</table>";
				
				$("table.board_list").remove();
				$("h1.title").after(output);
				

				//pager(jdata.totals, jdata.maxSize, jdata.pageSize, jdata.page);

				pager(result.page.dbCount, result.page.maxSize, result.page.pageSize, result.page.page);
	
				//페이지 번호 클릭 이벤트 처리
				jQuery('#ampaginationsm').on('am.pagination.change',function(e){
			   		jQuery('.showlabelsm').text('The selected page no: '+e.page);
	           		//$(location).attr('href', "notice_list_paging.do?page="+e.page);
	           		
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
	/*======================= admin 페이지에서 notice_list 페이징 처리 =======================*/
});