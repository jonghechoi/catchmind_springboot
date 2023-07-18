/******************************************
		Ïπ¥Ïπ¥?ò§ Î°úÍ∑∏?ù∏ 
******************************************/
	Kakao.init('a07bd04ced35130db583b416ed4c8f94'); //Î∞úÍ∏âÎ∞õÏ?? ?Ç§ Ï§? javascript?Ç§Î•? ?Ç¨?ö©?ï¥Ï§??ã§.
	console.log(Kakao.isInitialized()); // sdkÏ¥àÍ∏∞?ôî?ó¨Î∂??åê?ã®
	
	//Ïπ¥Ïπ¥?ò§Î°úÍ∑∏?ù∏
	 function kakaoLogin() {
	    Kakao.Auth.login({
	      success: function (response) {
	        Kakao.API.request({
	          url: '/v2/user/me',
	          success: function (response) {
				  var userInfo = {
		        	  memberId : response.id,
		        	  mcreatedate : response.connected_at,
		        	  mname : response.properties.nickname,
		        	  kemail : response.kakao_account.email
		          };
		        	  sendUserData(userInfo);
		        	  console.log(userInfo);
	          },
	          fail: function (error) {
	            console.log(error)
	          },
	        })
	      },
	      fail: function (error) {
	        console.log(error)
	      },
	    })
	  }

// ?ú†??? ?ç∞?ù¥?Ñ∞Î•? ?èº?úºÎ°? ?†Ñ?Ü°
function sendUserData(userInfo) {
  var form = document.createElement('form');
  form.method = 'POST';
  form.action = 'kakao_login_proc.do';

  // ?èº ?ç∞?ù¥?Ñ∞ Ï∂îÍ??
  for (var key in userInfo) {
    if (userInfo.hasOwnProperty(key)) {
      var input = document.createElement('input');
      input.type = 'hidden';
      input.name = key;
      input.value = userInfo[key];
      form.appendChild(input);
    }
  }

  // ?èº ?†Ñ?Ü°
 document.body.appendChild(form);
 form.submit();
}
/******************************************
		Ïπ¥Ïπ¥?ò§ Î°úÍ∑∏?ù∏ Ï≤¥ÌÅ¨
******************************************/
	function loginCheck(userInfo) {
		if(userInfo.id !== undefined || userInfo.length !== 0 || userInfo !== null) {
			/* location.replace("http://localhost:9000/catchmind/index.do"); */ 
		}
	}

/******************************************
		Ïπ¥Ïπ¥?ò§ Î°úÍ∑∏?ïÑ?õÉ
******************************************/
	//Ïπ¥Ïπ¥?ò§Î°úÍ∑∏?ïÑ?õÉ  
	function kakaoLogout() {
	    if (Kakao.Auth.getAccessToken()) {
	      Kakao.API.request({
	        url: '/v1/user/unlink',
	        success: function (response) {
	        	console.log(response)
	        },
	        fail: function (error) {
	          console.log(error)
	        },
	      })
	      Kakao.Auth.setAccessToken(undefined)
	    }
	  }