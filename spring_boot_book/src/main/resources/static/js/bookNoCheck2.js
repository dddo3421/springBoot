//fetch 사용요청 get 방식

$(document).ready(function(){
	$('#bookNoCheckBtn').on('click',function(){
		event.preventDefault();
		
		let bookNo = $('#bookNo').val();
		
		if(bookNo == ""){
			alert("도서번호를 입력하세요.");
			return false;
		}else{ //서버측에 상품번호 중복 확인 요청
			//자바스크립트 내장함수 : fetch()
			fetch("/mybatis2/book/bookNoCheck2/"+bookNo)
			.then(response=>response.text()) //응답객체를 text로 변환
			.then(result=>{
				if(result=="available"){
						alert("사용 가능한 번호입니다 fetch get")
					}else{
						alert("사용 불가능한 번호입니다")
					}
				})
			.catch(err=>console.log(err));
		} //else 끝
	
	});//on 메소드 종료
});//ready 종료

//fetch(url) : url로 요청
//서버 : 객체 반환 -> Promise 객체를 반환
//첫번째 .then() : 반환된 객체의 Promise가 성공적으로 완료되면 두번째 then 콜백이 실행됨
//두번째 .then(Http Response 객체를 전달받음) : 전달받은 res 객체를 json(), text() 변환해서 사용
