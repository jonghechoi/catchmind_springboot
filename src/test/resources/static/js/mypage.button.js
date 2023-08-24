
// Edit Profile 버튼 클릭 시 동작
document.querySelector('.btn-edit-profile').addEventListener('click', function() {
// 페이지 이동을 위한 URL 설정
var editProfileURL = 'mypage_editprofile';
// 페이지 이동
window.location.href = editProfileURL;
});

// Favorites 버튼 클릭 시 동작
document.querySelector('.btn-favorites').addEventListener('click', function() {
// 페이지 이동을 위한 URL 설정
var favoritesURL = 'favorites.html';
// 페이지 이동
window.location.href = favoritesURL;
});

// My Review 버튼 클릭 시 동작
document.querySelector('.btn-my-review').addEventListener('click', function() {
// 페이지 이동을 위한 URL 설정
var myReviewURL = 'my_review.html';
// 페이지 이동
window.location.href = myReviewURL;
});