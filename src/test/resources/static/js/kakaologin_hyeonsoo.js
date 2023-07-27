/******************************************
		카카오 로그인 
******************************************/
	Kakao.init('a07bd04ced35130db583b416ed4c8f94'); //발급받은 키 중 javascript키를 사용해준다.
	console.log(Kakao.isInitialized()); // sdk초기화여부판단
	
	//카카오로그인
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

// 유저 데이터를 폼으로 전송
function sendUserData(userInfo) {
  var form = document.createElement('form');
  form.method = 'POST';
  form.action = 'kakao_login';

  // 폼 데이터 추가
  for (var key in userInfo) {
    if (userInfo.hasOwnProperty(key)) {
      var input = document.createElement('input');
      input.type = 'hidden';
      input.name = key;
      input.value = userInfo[key];
      form.appendChild(input);
    }
  }

  // 폼 전송
 document.body.appendChild(form);
 form.submit();
}
/******************************************
		카카오 로그인 체크
******************************************/
	function loginCheck(userInfo) {
		if(userInfo.id !== undefined || userInfo.length !== 0 || userInfo !== null) {
			/* location.replace("http://localhost:9000/catchmind/index.do"); */ 
		}
	}

/******************************************
		카카오 로그아웃
******************************************/
	//카카오로그아웃  
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