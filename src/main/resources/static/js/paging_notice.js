$(document).ready(function() {
	/*======================= admin 페이지에서 notice_list 페이징 처리 =======================*/
	initAjax(1);
	
	function initAjax(page) {
		$.ajax({
			url: "notice_list_paging/"+page+"/",
			success: function(result){
				let jdata = JSON.parse(result);
				
				let output = "<table class='notice_list'>";
				output += "<tr class='adminList'>";
				output += "<td colspan='3'>";
				output += "<a href='notice_write'>";
				output += "<button type='button'>register</button>";
				output += "</a>";
				output += "</td>";
				output += "</tr>";
				output += "<tr>";
				output += "<th>No</th>";
				output += "<th>Title</th>";
				//output += "<th>Hits</th>";
				output += "<th>Reporting Date</th>";
				output += "</tr>";
		
				for(obj of jdata.jlist) {
					output += "<tr>";
					output += "<td>" + obj.rno + "</td>";
					output += "<td><a href='admin_notice_content?nid=" + obj.nid + "'>" +  obj.ntitle + "</a></td>";
					//output += "<td>" + obj.nhits + "</td>";
					output += "<td>" + obj.ncreatedate + "</td>";
					output += "</tr>";
				}
		
				output += "<tr>";
				output += "<td colspan='3'><div id='ampaginationsm'></div></td>";
				output += "</tr>";
				output += "</table>";
				
				$("table.notice_list").remove();
				$("h1").after(output);
				
				pager(jdata.totals, jdata.maxSize, jdata.pageSize, jdata.page);
	
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
	/*======================= admin 페이지에서 notice_list 페이징 처리 =======================*/
});