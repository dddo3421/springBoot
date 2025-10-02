$(document).ready(function(){
    $('#bookSearchForm').on('submit', function(event){
        event.preventDefault(); // submit 이벤트 중지

        let formData = $(this).serialize();
        let keyword = $('#keyword').val();
        let type = $('#type').val();

        if(keyword === "" || type === ""){
            alert("검색 조건과 검색어를 입력하세요");
            return;
        }

        $.ajax({
            type: "post",
            url: "/book/bookSearch1", // 서버에서 book 검색 처리 URL
            data: formData,
            dataType: "json", // JSON 자동 파싱
            success: function(result){
                console.log(result);

                // 기존 검색 결과 초기화
                $('#searchResultBox').empty();

                // 테이블 생성
                let $table = $('<table id="resultTable" border="1" width="800"></table>');
                $table.append(
                    '<tr>' +
                    '<th>책번호</th>' +
                    '<th>제목</th>' +
                    '<th>저자</th>' +
                    '<th>가격</th>' +
                    '<th>출판사</th>' +
                    '<th>재고</th>' +
                    '<th>출판일</th>' +
                    '</tr>'
                );

                if(result.length === 0){
                    $table.append('<tr align="center"><td colspan="7">찾는 책이 없습니다</td></tr>');
                } else {
                    result.forEach(function(book){
                        // 날짜 포맷팅
                        let date = new Date(book.bookDate);
                        let year = date.getFullYear();
                        let month = (date.getMonth() + 1).toString().padStart(2,'0');
                        let day = date.getDate().toString().padStart(2,'0');
                        let formattedDate = `${year}-${month}-${day}`;

                        $table.append(
                            '<tr>' +
                            '<td>' + book.bookNo + '</td>' +
                            '<td>' + book.bookName + '</td>' +
                            '<td>' + book.bookAuthor + '</td>' +
                            '<td>' + book.bookPrice + '</td>' +
                            '<td>' + book.pubNo + '</td>' +
                            '<td>' + book.bookStock + '</td>' +
                            '<td>' + formattedDate + '</td>' +
                            '</tr>'
                        );
                    });
                }

                // 테이블 추가
                $('#searchResultBox').append($table);
            },
            error: function(){
                alert("요청 실패");
            }
        });
    });
});
