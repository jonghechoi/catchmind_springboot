/*****************************************
	카카오 공유하기
******************************************/
	Kakao.init('adacb7319ef90251f888ca7acb9c479d');
	
	function shareKakao() {
		      Kakao.Link.sendDefault({
		        objectType: 'feed',	
		        content: {
		          title: '카카오 공유하기',
		          description: '캐치마인드!.',
		          imageUrl: '이미지 URL',
		          link: {
		            webUrl: '웹사이트 URL',
		            mobileWebUrl: '모바일 웹사이트 URL'
		          }
		        }
		      });
		    }


