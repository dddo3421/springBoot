package com.spring_boot.book.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring_boot.book.model.BookVO;
import com.spring_boot.book.service.BookService;



@Controller
public class BookController {

	@Autowired
	BookService service;
	
	@RequestMapping("/")
	public String viewIndex() {
		return "index"; // 메인 페이지 뷰
	}
	
	// 전체 도서 조회
	@RequestMapping("/book/listAllBook")
	public String listAllBook(Model model) {
		ArrayList<BookVO> bookList = service.listAllBook(); // 서비스에서 전체 도서 목록 가져오기
		model.addAttribute("bookList", bookList);           // 모델에 도서 목록 저장
		return "book/bookListView";                        // 전체 도서 목록 뷰 반환
	}
		
	// 도서 등록 폼 요청
	@RequestMapping("/book/newBookForm")
	public String newBookForm() {
		return "book/newBookForm"; // 도서 등록 폼 뷰
	}
		
	// 도서 등록 요청 - 처리 로직
	@RequestMapping("/book/insertBook")
	public String insertBook(BookVO vo) {
		service.insertBook(vo);                // 서비스에 도서 등록 요청
		return "redirect:/book/listAllBook";   // 등록 후 전체 도서 목록 페이지로 리다이렉트
	}
	
	// 도서 상세 정보 조회
	@RequestMapping("/book/detailViewBook/{bookNo}") // {}안의 값은 가변값 
	public String detailViewBook(@PathVariable String bookNo, Model model) {//{bookNo}에 해당하는 값을 bookNo 변수에 넣음
		BookVO book = service.detailViewBook(bookNo); // 해당 도서 상세 정보 가져오기
		model.addAttribute("book", book);             // 모델에 도서 정보 저장
		return "book/bookDetailView";                 // 상세 뷰 반환
	}
	
	// 도서 정보 수정 폼 요청
	@RequestMapping("/book/updateBookForm/{bookNo}")
	public String updateBookForm(@PathVariable String bookNo, Model model) {
	    BookVO book = service.detailViewBook(bookNo); // 수정할 도서 정보 조회
	    model.addAttribute("book", book);            // 모델에 저장
	    return "book/updateBookForm";                // 수정 폼 뷰 반환
	}

	// 도서 정보 수정 처리
	@RequestMapping("/book/updateBook")
	public String updateBook(BookVO book) {
	    service.updateBook(book);                    // 서비스에서 도서 정보 수정
	    return "redirect:/book/listAllBook";         // 수정 후 전체 도서 목록 페이지로 리다이렉트
	}
	
	// 도서 정보 삭제 처리
	@RequestMapping("/book/deleteBook/{bookNo}")
	public String deleteBook(@PathVariable String bookNo) {
	    service.deleteBook(bookNo);                  // 서비스에서 도서 삭제
	    return "redirect:/book/listAllBook";         // 삭제 후 전체 도서 목록 페이지로 리다이렉트
	}
	
	////////////////////////
	
	// ajax - 도서번호 중복확인 처리 post
		@ResponseBody
		@RequestMapping("/book/bookNoCheck") 
		public String bookNoCheck(@RequestParam("bookNo") String bookNo) {
			String bookNo_result = service.bookNoCheck(bookNo);
			
			String result = "available";
			if(bookNo_result !=null) {
				result = "no_available";
			}
	 		return result;
		}

		// ajax - 도서번호 중복확인 처리 get
		@ResponseBody
		@RequestMapping("/book/bookNoCheck1/{bookNo}") 
		public String bookNoCheck1(@PathVariable String bookNo) {
			String bookNo_result = service.bookNoCheck(bookNo);
			System.out.println(bookNo);
			String result = "available";
			if(bookNo_result !=null) {
				result = "no_available";
			}
	 		return result;
		}

	
	// fetch() get방식 요청 처리 - 요청url에 도서번호가 포함됨
	// 도서정보 중복 확인 처리 
	@ResponseBody
	@RequestMapping("/book/bookNoCheck2/{bookNo}")
	public String bookNoCheck2(@PathVariable String bookNo) {
		String bookNo_result = service.bookNoCheck(bookNo);
		System.out.println(bookNo);
		String result = "available";
		if(bookNo_result != null) {
			result = "no_available";
		}
		return result;
	}

	// fetch() post방식 요청 처리 - 네트워크 data body key에 도서번호가 포함됨
	// 도서정보 중복 확인 처리 
	@ResponseBody
	@RequestMapping("/book/bookNoCheck3")
	public String bookNoCheck3(@RequestBody String bookNo) {
		String bookNo_result = service.bookNoCheck(bookNo);
		System.out.println(bookNo);
		String result = "available";
		if(bookNo_result != null) {
			result = "no_available";
		}
		return result;
	}

	// axios() get 방식 - 요청url에 도서번호가 포함됨
	// 도서정보 중복 확인 처리 
	@ResponseBody
	@RequestMapping("/book/bookNoCheck4/{bookNo}")
	public String bookNoCheck4(@PathVariable String bookNo) {
		String bookNo_result = service.bookNoCheck(bookNo);
		System.out.println(bookNo);
		String result = "available";
		if(bookNo_result != null) {
			result = "no_available";
		}
		return result;
	}

	// axios() post 방식 
	// 도서정보 중복 확인 처리 
	@ResponseBody
	@RequestMapping("/book/bookNoCheck5")
	public String bookNoCheck5(@RequestBody HashMap<String, String> map) {
		String bookNo = map.get("bookNo");
		String bookNo_result = service.bookNoCheck(bookNo);
		System.out.println(bookNo);
		String result = "available";
		if(bookNo_result != null) {
			result = "no_available";
		}
		return result;
	}

	
	///////////////////////////////////////////////////////////
	//도서검색 폼 요청 처리
	@RequestMapping("/book/bookSearchForm1")	
	public String bookSearchForm1() {
	    return "book/bookSearchForm1";
	}
	
	//도서 검색 처리
	@ResponseBody
	@RequestMapping("/book/bookSearch1")
	public ArrayList<BookVO> bookSearch1(@RequestParam HashMap<String, Object> param, Model model) {
		ArrayList<BookVO> bookList = service.bookSearch(param);
		model.addAttribute("bookList",bookList);
		
		return bookList;
	}
	
}
