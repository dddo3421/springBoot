$(document).ready(function(){
	$('#searchZipBtn').on('click',function(){
		new daum.Postcode({
			oncomplete:function(data){
				//전달받은 우편번호와 주소를 회원가입 입력폼에 값으로 전달
				address1="";
				
				//도로명 주소인 경우
				if(data.userSelectedType=='R'){
					address1=data.roadAddress + "(" + data.buildingName+")";
				}else{//지번 주소인 경우
					address1=data.jibunAddress;
				}
				
				//입력란에 우편번호, 주소1 출력
				document.getElementById('memZipcode').value=data.zonecode;
				document.getElementById('memAddress1').value=address1;
				
				address2 = document.getElementById('memAddress2');
				address2.value="";
				address2.focus();
			}

		}).open();//우편번호 검색 창 열림	
	});//click 끝	
}); //ready 끝