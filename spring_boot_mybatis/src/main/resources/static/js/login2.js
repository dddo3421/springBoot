$(document).ready(function(){
	$('#frmLogin2').on('submit',function(){
		event.preventDefault();//submit 이벤트 중지
		
		let user_id = $('#user_id').val();
		let user_pw = $('#user_pw').val();
		
		$.ajax({
			type:"post", //요청 방식 메소드
			url:"/mybatis/login", //요청 url
			data:{"id":user_id,
				  "pw":user_pw}, //요청시 전송될 파라미터, 파라미터명 id, pw
			dataType:"text", //요청후 반환되는 데이터 타입
			success:function(result){
				if(result == "success"){
				    alert("로그인 성공\n상품 조회 화면으로 이동합니다.");
					location.href="/mybatis/product/listAllProduct";}
				else
					alert("로그인 실패");

			},
			error:function(data){
				alert("요청 실패");
			},
			complete:function(){
				//alert("작업 완료");
			}
		});
	
	});//submit 종료
});//ready 종료