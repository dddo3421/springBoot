$(document).ready(function(){
	$('#prdSearchFrm2').on('submit',function(){
		event.preventDefault();//submit 이벤트 중지
		
		//폼에 입력된 여러개의 값을 쿼리스트링 방식의 데이터로 변환 : serialize() 사용
		let formData = $(this).serialize();		
		
		let keyword=$('#keyword').val();
		let type=$('#type').val();
		
		if(keyword==""||type==""){
			alert("검색 조건과 검색어를 입력하세요");
			//return false;
		}else{		
			$.ajax({
				type:"post", //요청 방식 메소드
				url:"/mybatis/product/productSearch2", //요청 url
				data: formData , //요청시 전송될 파라미터
				success:function(result){
					console.log(result);
					//반환된 결과 페이지를 searchResultBox에 페이지로 삽입 : .html()
					$('#searchResultBox').html(result);											 
					
				},
				error:function(data){
					alert("요청 실패");
				}
			});
		}
	});//submit 종료
});//ready 종료