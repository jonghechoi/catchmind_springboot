<%-- <%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="icon" href="image/favicon.png" type="image/png">
        <title>CatchMind</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="resources/css/bootstrap.css">
        <link rel="stylesheet" href="resources/vendors/linericon/style.css">
        <link rel="stylesheet" href="resources/css/font-awe	some.min.css">
        <link rel="stylesheet" href="resources/vendors/bootstrap-datepicker/bootstrap-datetimepicker.min.css">
        <link rel="stylesheet" href="resources/vendors/nice-select/css/nice-select.css">
        <link rel="stylesheet" href="resources/vendors/owl-carousel/owl.carousel.min.css">
        <link rel="stylesheet" href="resources/vendors/lightbox/simpleLightbox.css">
        <!-- main css -->
        <link rel="stylesheet" href="resources/css/style.css">
        <link rel="stylesheet" href="resources/css/lsm.css">
        <link rel="stylesheet" href="resources/css/responsive.css">
    </head>
    <body>
        <!--================Header Area =================-->
        <header class="header_area">
            <div class="container">
                <nav class="navbar navbar-expand-lg navbar-light">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <a class="navbar-brand logo_h" href="index"><img src="resources/image/jhs_img/KakaoTalk_20230507_132927423.png" alt=""></a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse offset" id="navbarSupportedContent">
                        <ul class="nav navbar-nav menu_nav ml-auto">
                            <li class="nav-item"><a class="nav-link" href="index">HOME</a></li>
                            <li class="nav-item"><a class="nav-link" href="search">SEARCH</a></li>
                             <li class="nav-item submenu dropdown">
                                <a href="mydining_scheduled" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">MYDINING</a>
                                <ul class="dropdown-menu">
                                    <li class="nav-item active"><a class="nav-link" href="mydining_scheduled">Scheduled</a></li>
                                    <li class="nav-item"><a class="nav-link" href="mydining_visited">Visited</a></li>
                                </ul>
                            </li> 
                            <li class="nav-item active"><a class="nav-link" href="mypage">MYPAGE</a></li>
                             <li class="nav-item"><a class="nav-link" href="notice">NOTICE</a></li>
                            <li class="nav-item"><a class="nav-link" href="admin">ADMIN</a></li>
                        </ul>
                    </div> 
                </nav>
            </div>
        </header>
        <!--================Header Area =================-->
        
        <!--================Breadcrumb Area =================-->
        <section class="breadcrumb_area blog_banner_two">
            <div class="overlay bg-parallax" data-stellar-ratio="0.8" data-stellar-vertical-offset="0" data-background=""></div>
            <div class="container">
                <div class="page-cover text-center">
                    <h2 class="page-cover-tittle f_48">Edit Profile</h2>
                    <ol class="breadcrumb">
                        <li><a href="index.html">MY PAGE</a></li>
                        <li class="active">Edit Profile</li>
                    </ol>
                </div>
            </div>
        </section>
        <!--================Breadcrumb Area =================-->
        <div class="section_title text-center">
		<div class="w3-content w3-container w3-margin-top">
	<div class="wrapper">
    <header id="header" class="opaque">
        <div class="container">
            <div class="header-left"><button class="btn-back">back</button>
            </div>
            <script>
            const backButton = document.querySelector('.btn-back');
				backButton.addEventListener('click', function() {
				window.history.back();
		});
            </script>
        </div>
    </header>
    <main id="main">
        <div class="my-account">
            <div class="pt-30 mb-30">
                <div class="profile-pic-editor" style="cursor: pointer;">
                    <div class="pic">
                        <div class="img" style="background-image: url(&quot;https://catchtable.co.kr/web-static/static_webapp_v2/img/noimg/profile_default_v2.png&quot;);"></div>
                    </div>
                </div>
            </div>
            <div class="mb-10">
                <div class="container gutter-sm">
                    <div class="form-block mb-24">
                        <div class="mb-6"><label class="color-gray font-12">Nickname</label></div><input type="text" class="form-input" placeholder="Make your nickname within 15 characters" name="displayName" value="THE JOEUN">
                    </div>
                    <div class="form-block mb-24">
                        <div class="mb-6"><label class="color-gray font-12">Self Introduction</label></div><textarea class="form-input" placeholder="Please write a self-introduction" name="introduce" rows="3">lee sang myeng</textarea>
                    </div>
                </div>
            </div>
        </div>
    </main>	
    <div><p style="text-align:center"><button id="saveButton" class="btn btn-lg btn-red">Save</button></p></div>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    
    <!-- <form id="updateForm" action="save_changes.php" method="POST">
  변경된 정보 입력 필드 등
  <input type="text" name="displayName" value="THE JOEUN">
  <textarea name="introduce">lee sang myeng</textarea>
  
  저장 버튼
  <button type="submit">Save</button>
	</form> -->
    
 <script>
 $(document).ready(function() {
	  $('#saveButton').on('click', function() {
	    // 세이브 버튼이 클릭되었을 때 실행되는 코드
	  });
	});

      // AJAX 요청을 통해 서버에 데이터 전송
      $.ajax({
        url: 'mypage_editprofile', // 서버의 저장 기능을 처리하는 URL로 변경해야 합니다.
        type: 'POST',
        data: formData, // 저장할 데이터를 전달합니다.
        contentType: false,
        processData: false,
        success: function(response) {
          console.log('저장이 완료되었습니다.');
          // 저장 완료 후 필요한 작업을 수행할 수 있습니다.
          // 예를 들어, 다른 페이지로 이동하거나 알림 메시지를 표시할 수 있습니다.
        },
        error: function(xhr, status, error) {
          console.error('저장 중 오류가 발생하였습니다.');
          // 오류 발생 시 사용자에게 알림 메시지를 표시할 수 있습니다.
        }
      });
  });
});
</script>
</div>
	</div>
		                
        <!--================ start footer Area  =================-->   
        <footer class="footer-area section_gap" style="padding:50px 0 0 0; background:rgb(255, 61, 0)">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3  col-md-6 col-sm-6 footer-widget1" style="padding-right:50px width:370px">
                        <div class="single-footer-widget single-footer-widget-left">
                            <h6 class="footer_title">About Agency</h6>
                            <p style="color:white">WAD Corp.
                            <br>
                     Address: A-605, 660, Daewangpangyo-ro, Bundang-gu, Seongnam-si, Gyeonggi-do, Republic of Korea
                     <br>
                     Business registration number: 614-88-00597
                     <br>
                     Online marketing business report number: 2017-Seongnam Bundang-0933
                     <br>
                     Personal information responsible: service@catchtable.co.kr
                     <br>
                     Terms of Service | Privacy policy | Terms of Location Service </p>
                        </div>
                    </div>                  
                    <div class="col-lg-3 col-md-6 col-sm-6 footer-widget2" style="width:300px">
                        <div class="single-footer-widget">
                            <h6 class="footer_title">Newsletter</h6>
                            <p style="color:white">For business professionals caught between high OEM price and mediocre print and graphic output, </p>      
                            <div id="mc_embed_signup">
                                <form target="_blank" action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01" method="get" class="subscribe_form relative">
                                    <div class="input-group d-flex flex-row">
                                        <input name="EMAIL" placeholder="Email Address" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Email Address '" required="" type="email">
                                        <button class="btn sub-btn"><span class="lnr lnr-location"></span></button>      
                                    </div>                           
                                    <div class="mt-10 info"></div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 col-sm-6 footer-widget3"  style="width:300px">
                        <div class="single-footer-widget instafeed">
                            <h6 class="footer_title">InstaFeed</h6>
                            <ul class="list_style instafeed d-flex flex-wrap">
                                <li><img src="resources/image/instagram/Image-01.jpg" alt=""></li>
                                <li><img src="resources/image/instagram/Image-02.jpg" alt=""></li>
                                <li><img src="resources/image/instagram/Image-03.jpg" alt=""></li>
                                <li><img src="resources/image/instagram/Image-04.jpg" alt=""></li>
                                <li><img src="resources/image/instagram/Image-05.jpg" alt=""></li>
                                <li><img src="resources/image/instagram/Image-06.jpg" alt=""></li>
                                <li><img src="resources/image/instagram/Image-07.jpg" alt=""></li>
                                <li><img src="resources/image/instagram/Image-08.jpg" alt=""></li>
                            </ul>
                        </div>
                    </div>                  
                </div>
                <div class="border_line"></div>
                <div class="row footer-bottom d-flex justify-content-between align-items-center">
                    <p class="col-lg-8 col-sm-12 footer-text m-0">
                </div>
            </div>
        </footer>
      <!--================ End footer Area  =================-->
        
        
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="resources/js/jquery-3.2.1.min.js"></script>
        <script src="resources/js/popper.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>
        <script src="resources/vendors/owl-carousel/owl.carousel.min.js"></script>
        <script src="resources/js/jquery.ajaxchimp.min.js"></script>
        <script src="resources/vendors/bootstrap-datepicker/bootstrap-datetimepicker.min.js"></script>
        <script src="resources/vendors/nice-select/js/jquery.nice-select.js"></script>
        <script src="resources/js/mail-script.js"></script>
        <script src="resources/js/stellar.js"></script>
        <script src="resources/vendors/lightbox/simpleLightbox.min.js"></script>
        <script src="resources/js/custom.js"></script>
    </body>
</html> --%>