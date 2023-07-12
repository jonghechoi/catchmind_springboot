<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>CatchMind</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="icon" href="/image/catchcon.png" type="image/png">
        <script src="/js/jquery-3.6.4.min.js"></script>
        <script src="/js/catchmind_hyeonsoo.js"></script>
		<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
        <!-- main css -->
        <link rel="stylesheet" href="/css/style.css">
		<link rel="stylesheet" href="/css/jhsStyle.css">
		<link rel="stylesheet" href="/css/hyeonsoo_join_consent.css">
</head>
<body>
	<form name="cancelReservationForm" action="cancle_reservation" method="post" id="joinConsentForm">
    	<input type="hidden" name="rid" value="${rid}">
	    <ul class="join_box">
	    	<li class="cancle_check">
	    		<h5 class="cancle_h5">Please select a reason for cancellation (required)</h5>
	    		<div>
		    		<span class="cancle_check1">Unable to visit during reservation time</span><input type="radio" name="cancle" value="time">
	    		</div>
	    		<div>
		    		<span class="cancle_check1">I don't think it'll taste good</span><input type="radio" name="cancle" value="taste">
	    		</div>
	    		<div>
		    		<span class="cancle_check1">I don't think the atmosphere will be good</span><input type="radio" name="cancle" value="mood">
	    		</div>
	    		<div>
		    		<span class="cancle_check1">Because of the price</span><input type="radio" name="cancle" value="price">
	    		</div>
	    		<div class="other_check">
		    		<span class="cancle_check1">Other reasons</span><input type="radio" name="cancle" value="other">
	    		</div>
	    		
	    	</li>
	              <li class="checkBox check01">
	                  <ul class="clearfix">
	                      <li>Please agree to the terms and conditions for cancellation of the reservation (required)</li>
	                      <li class="checkBtn">
	                          <input type="checkbox" name="chk" class="chk" id="chk1">
	                      </li>
	                  </ul>

             <textarea name="" id="">
If you cancel the reservation within 3 days of the reservation date, there may be a disadvantage in the reservation fee. After cancellation of the reservation, the refund of the reservation fee will proceed immediately, and if there are many cancellations/no shows, the service may be restricted.
		     </textarea>
              </li>
          </ul>
          <ul class="footBtwrap clearfix">
              <li><button type="button" class="fpmgBt1" id="btn_cancleReservation">Cancle</button></li>
              <li><button type="button" class="fpmgBt2" id="conset_disagree">Close</button></li>
          </ul>
      </form>
</body>
</html>