$(document).ready(function(){
	$('#prdSearchFrm3').on('submit',function(){
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
				url:"/mybatis/product/productSearch3", //요청 url
				data: formData , //요청시 전송될 파라미터
				success:function(result){
					console.log(result);
					//반환된 결과를 searchResultBox에 테이블 형태로 출력
					$('#searchResultBox').empty();//기존 검색결과 지우기
					$('#searchResultBox').append('<table id="resultTable" border="1" width="500">' +
					                             '<tr><th>상품번호</th><th>상품명</th><th>상품가격</th>' +
	 											 '<th>제조사</th><th>재고</th><th>제조일</th><th>사진</th></tr>');
				    if(result==""){ //검색 결과가 없는 경우
				    $('#searchResultBox').append('<tr align="center"><td colspan="7">찾는 상품이 없습니다</td></tr>');
				    } else {
				    	for(let i=0; i<result.length; i++){
				    		let prd_date = new Date(result[i].prdDate);
				    		let year = prd_date.getFullYear();
				    		let month = (prd_date.getMonth()+1).toString().padStart(2,'0');
				    		let date = (prd_date.getDate()).toString().padStart(2,'0');
				    		let prdDate = `${year}-${month}-${date}`;
				    		$('#resultTable').append('<tr><td>' + result[i].prdNo+'</td><td>' +
				    											  result[i].prdName+'</td><td>' +
				    											  result[i].prdPrice+'</td><td>' +
				    											  result[i].prdCompany+'</td><td>' +
				    											  result[i].prdStock+'</td><td>' +
				    											  prdDate+'</td><td>' +
				    											  '<img src="/mybatis/prd_images/'+
				    											  result[i].prdNo +
				    											  +'.jpg" width="30" height="20"></td></tr>');
				    											  
				    	}
				    }
				    $('#searchResultBox').append('</table>');	 											 
					
				},
				error:function(data){
					alert("요청 실패");
				}
			});
		}
	});//submit 종료
});//ready 종료