window.onload = function(){
	let qty = 1;
	
	let plusBtn = document.getElementById('plusBtn');
	let minusBtn = document.getElementById('minusBtn');
	
	plusBtn.addEventListener('click', ()=>{
		qtyChange(1)
	});
	
	minusBtn.addEventListener('click', ()=>{
		qtyChange(-1)
	});
	
	//주문수량 변경하는 함수
	function qtyChange(num){
		qty = qty + num;
		if(qty < 1) qty = 1;
		//구매 예정 금액 계산 함수 호출
		calAmount();
	}
	
	function calAmount(){
		//현재 주문 수량과 주문 예정 금액 객체 추출
		let cartQty = document.getElementById('cartQty');
		let amount = document.getElementById('amount');
		//상품 가격 정보 추출
		let price = document.getElementById('price').dataset.price;
		price = parseInt(price); //문자열을 숫자로 변환
		
		//구매 예정 금액 계산
		let total = price * qty;
		
		cartQty.value = qty;
		amount.innerHTML = total.toLocaleString(); //천단위 구분
	}
	
	
} //window.onload 끝
