$(document).ready(function() {

	var fdata;
    const toCatchForm = document.querySelector('#catch-form');
    const toCatchList = document.querySelector('#catch-list');
    const allDelete = document.querySelector('.allDelete');
    const txt = document.querySelector('.txt');
    const TODOS_KEY = "todos";
    let toCatch = [];
	
	
    function saveToCatch() { 
        if (typeof(Storage) !== 'undefined') {
            localStorage.setItem(TODOS_KEY, JSON.stringify(toCatch));
            
        }
    }
    
    function allDeleteToCatch() {
        localStorage.removeItem(TODOS_KEY); 
        toCatchList.innerText = 'No Recently Word';
        $(".rb").empty();
    }
    
    function deleteToCatch(e) {
        const li = e.target.parentElement;
        li.remove();
        toCatch = toCatch.filter((toCatch) => toCatch.id !== parseInt(li.id));
        if (toCatch.length === 0) {
            txt.innerText = 'No Recently Word';
        }
        saveToCatch();
    }
    
    function paintCatch(newCatch) {
        const { id, text } = newCatch;
        const item = document.createElement("li");
        const span = document.createElement("span");
        const button = document.createElement("button");
        item.id = id;
        span.innerText = text;
        button.innerText = '❌';
        button.addEventListener("click", deleteToCatch);
        allDelete.addEventListener("click", allDeleteToCatch);
        item.appendChild(span);
        item.appendChild(button);
        toCatchList.appendChild(item);
        if (newCatch !== null) {
            allDelete.classList.remove('off');
        }
    }
    
    let newCatchItem = '';
    function handleToCatchSubmit(event) {
        event.preventDefault();
        const toCatchInput = toCatchForm.querySelector('input');
        //console.log(event);
        newCatchItem = toCatchInput.value;
        //console.log(newCatchItem);
        toCatchInput.value = '';
        const newCatchObj = {
            id: Date.now(),
            text: newCatchItem
        };
        toCatch.push(newCatchObj);
        paintCatch(newCatchObj);
        searchPost(newCatchItem);
    }
    
    toCatchForm.addEventListener('submit', handleToCatchSubmit);
    
    const savedCatch = JSON.parse(localStorage.getItem(TODOS_KEY));
    if (savedCatch !== null) {
        toCatch = savedCatch;
        savedCatch.forEach(paintCatch);
    }
   
    
    
    
    
    
    function enterkeySearch(event) {
        if (event.keyCode === 13) { 
            //console.log(1111);
        }
    }
    window.enterkeySearch = enterkeySearch;
   
    let searchPost = (searchQuery) => {
        $('.rb').empty();
        //console.log('1234'+searchQuery);
        if (searchQuery === '') { 
            $('#searchBar').focus();
            return;
        }
        
        
        
        $.ajax({
            url: "/search_list_proc/" + searchQuery,
            async:false,
            success: function(result) {
            fdata = result;
                let jdata = JSON.parse(result);
                
                let output = "";

                for (const obj of jdata.jlist) {
                	//console.log(obj.sid);
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
        });
        
    }
    
    $(".d_p1").click(function(){
    	//alert($(this).attr("id"));
    	let locname = $(this).attr("id");
		const jdata = JSON.parse(fdata);
        const searchData =jdata.jlist.filter(object => {
	        if(object.sloc.indexOf(locname) > -1){
	        return object;
	        }
	        return null;
        }); //searchData
        
                
                
                let output = "";

                for (const obj of searchData) {
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
                } //for
				$(".saved-restaurant-list-item").remove();
				$("hr").remove();
                $(".rb").append(output);
            
	
	}); //location filter
    
    $(".d_p2").click(function(){
    	//alert($(this).attr("id"));
    	let cuisinename = $(this).attr("id");
    	//alert(fdata);
		const jdata = JSON.parse(fdata);
        const searchData =jdata.jlist.filter(object => {
	        if(object.sfoodstyle.indexOf(cuisinename) > -1){
	        return object;
	        }
	        return null;
        }); //searchData
        
                
                
                let output = "";

                for (const obj of searchData) {
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
                } //for
				$(".saved-restaurant-list-item").remove();
				$("hr").remove();
                $(".rb").append(output);
            
	
	}); //Cuisine filter
    
    ///////////Price Filtering //////////
    const contractAmountRange = [{
		    id: "1",
		    min: 0,
		    max: 50000		   
		  },
		  {
		    id: "2",
		    min: 50001,
		    max: 100000		   
		  },
		  {
		    id: "3",
		    min: 100001,
		    max: 150000		   
		  },
		  {
		    id: "4",
		    min: 150001,
		    max: 200000		   
		  },
		  {
		    id: "5",
		    min: 200001,
		    max: 300000		   
		  }
		  
		];
    $(".d_p3").click(function(){
    	
    	//alert($(this).attr("id"));
    	let pricescope = $(this).attr("id");
    	
		const jdata = JSON.parse(fdata);
		const pricedata = jdata.jlist; //Price filtering Data
       
       	const filterData = (pricedata, contractAmountRange, rangeSelected) => {
			  const foundRange = contractAmountRange.find((x) => x.id === rangeSelected);
			  const {
			    min,
			    max
			  } = foundRange;
			 
			  return pricedata.filter(
			    ({
			    	dinner
			    }) => dinner >= min && dinner <= max
			  );
			};

			const searchData = filterData(pricedata, contractAmountRange, pricescope);
			//alert(searchData);
			for(obj of searchData){
				//alert(obj.sid+",,,"+ obj.dinner);
			}
                let output = "";
				
                for (const obj of searchData) {
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
                } //for
				$(".saved-restaurant-list-item").remove();
				$("hr").remove();
                $(".rb").append(output);
            
	
	}); //Price filter
	
    
}); //ready
