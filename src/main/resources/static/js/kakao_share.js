/*****************************************
	카카오 공유하기
******************************************/
	Kakao.init('adacb7319ef90251f888ca7acb9c479d');
	
	function shareKakao() {
		      Kakao.Link.sendDefault({
		        objectType: 'feed',	
		        content: {
		          title: '카카오 공유하기',
		          description: '캐치 마인드로 당신을 초대합니다!',
		          imageUrl: 'https://image.toast.com/aaaaaqx/catchtable/shopinfo/sz7PepEw6dYzPacOpI-IvAQ/z7pepew6dyzpacopi-ivaq_2382322351679730.jpeg',
		          link: {
		            webUrl: 'http://localhost:9000/restaurant/S_0001',
		            mobileWebUrl: '모바일 웹사이트 URL'
		          }
		        }
		      });
		    }


