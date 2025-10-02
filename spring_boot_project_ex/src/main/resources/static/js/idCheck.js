$(document).ready(function() {
	$('#idCheck').on('click', function() {
		event.preventDefault();

		let memId = $('#memId').val();

		if (memId == "") {
			alert("ID를 입력하세요");
		} else {
			$.ajax({
				type: "post",
				url: "/member/idCheck",
				data: {
					"id": $('#memId').val()
				},
				dataType: "text",
				success: function(result) {
					if(result>0){
						alert("사용할 수 없는 ID 입니다");
					}else{
						alert("사용가능한 ID 입니다");
					}
				},
				error: function() {
					alert("요청 실패");
				}

			}); //ajax 끝
		} //if 끝
	});//click 끝	
}); //ready 끝