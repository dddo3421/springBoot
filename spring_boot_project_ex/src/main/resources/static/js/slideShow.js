/**
 * slideShow.js
 */
 $(function() {
	// 이동한 이미지의 index 값 저장 (현재 위치)
	let movedIndex = 0;
	
	// 슬라이드 패널을 이동시키는 함수 
	function moveSlide(index){
		// 전달받은 index 값을 movedIndex에 저장
		movedIndex = index;
		
		// 슬라이드 이동
		let moveLeft = -(index * 1280); // index(위치) 값에 따라 그림 길이 만큼 왼쪽으로 이동
		$('#slidePanel').animate({'left': moveLeft}, 'slow');
	}
	
	// prev 버튼 클릭 시 왼쪽으로 이동
	$('#prevButton').on('click', function() {
		if(movedIndex != 0) { // 첫 번째가 아니면 이동
			movedIndex = movedIndex -1; // 인덱스값 - 1
			
			moveSlide(movedIndex);
		}
	});
	
		// prev 버튼 클릭 시 왼쪽으로 이동
	$('#nextButton').on('click', function() {
		if(movedIndex != 4) { //마지막이 아니면 이동
			movedIndex = movedIndex +1; // 인덱스값 + 1
			
			moveSlide(movedIndex);
		}
	});
	
	// 초기 슬라이더 위치 랜덤하게 지정
	let randomNum = Math.floor(Math.random() * 5);
	moveSlide(randomNum);
	
	// 각 컨트롤 버튼에 대해
	$('.controlButton').each(function(index) {
		$(this).hover(
			function() { // 마우스 올렸을 때 이미지 변경
				$(this).attr('src', 'image/controlButton2.png');
			},
			function() { // 마우스 뗐을 때 이미지 변경
				$(this).attr('src', 'image/controlButton1.png');
			}
		);
		
		// 클릭했을 때 이동 : 인덱스 값을 moveSlide() 함수에게 전달
		$(this).on("click", function() {
			moveSlide(index);
		});
	});
	
	
}); //  $(function() 끝







