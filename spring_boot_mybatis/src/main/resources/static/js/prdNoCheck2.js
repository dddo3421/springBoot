//prdNoCheck2.js 
//fetch 사용요청 get 방식
$(document).ready(function(){
	$('#prdNoCheckBtn').on('click',function(){
		event.preventDefault();
		
		let prdNo = $('#prdNo').val();
		
		if(prdNo == ""){
			alert("상품번호를 입력하세요. 2");
			return false;
		}else{ //서버측에 상품번호 중복 확인 요청
			   //자바스크립트 내장함수 : fetch()
			   fetch("/mybatis/product/prdNoCheck2/"+prdNo)
			   .then(response=>response.text()) //response=>response.text())//응답객체를 text로 변환
			   .then(result=>{
					if(result=="available"){
						alert("사용가능한 번호 입니다");
					}else{
						alert("사용 불가능한 번호 입니다.");
					}			   		
			   		})
		   	   .catch(err=>console.log(err));		
		} //else 끝	
	
	});//on 종료
});//ready 종료

//fetch(url) : url로 요청
//서버 : 객체 반환 -> Promise 객체를 반환
//첫번째.then() : 반환된 객체의 Promise가 성공적으로 완료되면 두번째 then 콜백이 실행됨
//두번째.then(Http Response 객체를 전달받음) : 전달받은 res 객체를 json(), text() 변환해서 사용