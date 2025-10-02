/**
 * product.js
 */

  $(function() {
	// 상품 이미지에 마우스 올렸을 때 이미지 확대 
	$('.product img')
		.on('mouseover', function() {
			$(this).css('transform', 'scale(1.1)'); // 1.1배 확대
			$('.product div').css('overflow', 'hidden'); // 확대되어서 영역에서 벗어나는 부분 안 보이게
		})
		.on('mouseout', function() {
			$(this).css('transform', 'scale(1)'); // 1배 확대 : 원래 크기
		});

	
 }); //  $(function() 끝