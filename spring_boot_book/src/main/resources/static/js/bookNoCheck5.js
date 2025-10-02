// bookNoCheck5.js
// axios 사용요청 post 방식

$(document).ready(function(){
	$('#bookNoCheckBtn').on('click', function(){
		event.preventDefault();
		
		let bookNo = $('#bookNo').val();
		
		if(bookNo == ""){
			alert("도서번호를 입력하세요.");
			return false;
		}else{ // 서버측에 도서번호 중복 확인 요청
			// 라이브러리 axios.post(url, data(key:value)).then(function(response){처리코드})
			let data = {"bookNo": bookNo};
			axios.post("/mybatis2/book/bookNoCheck5", data)
			.then(function(response){
				if(response.data == "available"){
					alert("사용 가능한 도서번호입니다 axios post");
				}else{
					alert("사용 불가능한 도서번호입니다");
				}
			})
			.catch(err => console.log(err));
		} // else 끝
	});// on 메소드 종료
});// ready 종료
