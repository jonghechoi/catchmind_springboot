<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CatchMind</title>
<link rel="icon" href="/image/catchcon.png" type="image/png">
<link rel="stylesheet" href="/css/hyeonsoo_join_consent.css">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src="/js/catchmind_hyeonsoo.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>


</head>
<body>
	<form action="" id="joinConsentForm">
	    <ul class="join_box">
	        <li class="checkBox check01">
	            <ul class="clearfix">
	                <li>
	                I agree with the terms of use, personal information collection and use, 
	                and location information terms and conditions (required).
	                </li>
	                <li class="checkAllBtn">
	                    <input type="checkbox" name="chkAll" id="chkAll" class="chkAll">
	                </li>
	            </ul>
	        </li>
	        <li class="checkBox check02">
	            <ul class="clearfix">
	                <li>Agree to terms of use (required)</li>
	                <li class="checkBtn">
	                    <input type="checkbox" name="chk" class="chk" id="chk1"> 
	                </li>
	            </ul>
	        <textarea name="" id="">
Welcome everyone. Enjoy various Catch Mind services. If you sign up as a member, you can use the Catch Mind service more conveniently.We'll cherish the content you've. We protect your personal information. Please respect the rights of others.
	   		</textarea>
	             </li>
	             <li class="checkBox check03">
	                 <ul class="clearfix">
	                     <li>Guidance on the collection and use of personal information (required)</li>
	                     <li class="checkBtn">
	                         <input type="checkbox" name="chk" class="chk" id="chk2">
	                     </li>
	                 </ul>
	
	        <textarea name="" id="">
We promise to receive only the information of the minimum number of users who need our Catchmind service, and to treat your precious information carefully without leaking it.

Purpose of collection: It is used for smooth restaurant reservations for users.

Collection item: Collect the information you enter when you sign up.

Retention and use period: It will be automatically deleted when a member is withdrawn.
	   		</textarea>
	              </li>
	              <li class="checkBox check03">
	                  <ul class="clearfix">
	                      <li>Agree to the terms and conditions of use of location information (required)</li>
	                      <li class="checkBtn">
	                          <input type="checkbox" name="chk" class="chk" id="chk3">
	                      </li>
	                  </ul>

             <textarea name="" id="">
This location service consent is obtained for the convenience of users in providing Catchmind service. We promise that it will not cause information leakage or disadvantage to users due to the location service and will be used only for Catch Mind services.
		     </textarea>
              </li>
          </ul>
          <ul class="footBtwrap clearfix">
              <li><button type="button" class="fpmgBt1" id="btn_conset">Consent</button></li>
              <li><button type="button" class="fpmgBt2" id="conset_disagree">Disagree</button></li>
          </ul>
      </form>
<script>

/* 회원가입 약관동의 페이지 유효성 체크 */

window.onload = function () {
const checkAll = document.getElementById('chkAll');
const chks = document.querySelectorAll('.chk');
const chkBoxLength = chks.length;

checkAll.addEventListener('click', function(event) {
    if (event.target.checked) {
        chks.forEach(function(value) {
            value.checked = true;
        });
    } else {
        chks.forEach(function(value) {
            value.checked = false;
        });
    }
});

for (chk of chks) {
    chk.addEventListener('click', function() {
        let count = 0;
        chks.forEach(function(value) {
            if (value.checked == true) {
                count++;
            }
        });
        if (count !== chkBoxLength) {
            checkAll.checked = false;
        } else {
            checkAll.checked = true;
        }
    });
}
};

</script>
</body>
</html>