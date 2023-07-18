$(document).ready(function() {
	/*======================= admin 페이지에서 member_list 페이징 처리 =======================*/
	initAjax(1);
	
	function initAjax(page) {
		$.ajax({
			url: "member_list_paging.do?page="+page,
			success: function(result){
				let jdata = JSON.parse(result);
			
				let output = "<table id='memberAdmin'>";
				output += "<tr>";
				output += "<th>No</th>";
				output += "<th>M_ID</th>";
				output += "<th>Name</th>";
				output += "<th>ID</th>";
				output += "<th>E-mail</th>";
				output += "<th>Phone</th>";
				output += "<th></th>";
				output += "</tr>";

				for(obj of jdata.jlist) {
					output += "<tr style='background-color:white'>";
					output += "<td>" + obj.rno + "</td>";
					output += "<td>" + obj.mid + "</td>";
					output += "<td>" + obj.mname + "</td>";
					output += "<td>" + obj.memberid + "</td>";
					output += "<td>" + obj.memail + "</td>";
					output += "<td>" + obj.mphone + "</td>";
					output += "<td><button type='button' name='name' id='btnMemberDetail" + obj.rno + "'><a href='member_info.do?mid=" + obj.mid + "'>Detail</a></button></td>";
					output += "</tr>";
				}			
			
				output += "<tr>";
				output += "<td colspan='7'><div id='ampaginationsm'></div></td>";
				output += "</tr>";
				output += "</table>";			

				$("table#memberAdmin").remove();
				$("h1").after(output);
				
				pager(jdata.totals, jdata.maxSize, jdata.pageSize, jdata.page);
	
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
	/*======================= admin 페이지에서 member_list 페이징 처리 =======================*/
});