package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.Seller;

@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01Controller {
	
	@Autowired
	private SellerBO sellerBO;

	// 회원가입 화면
	// http://localhost:8080/lesson04/quiz01/add-seller-view
	@RequestMapping("/add-seller-view")
	public String addSellerView() {
		return "lesson04/addSeller";  // view 경로
	}
	
	//DB 저장 -> 입력 성공 페이지 이동
	// /lesson04/quiz01/add-seller
	@PostMapping("/add-seller")
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam(value = "profileImageUrl", required = false) String profileImageUrl,
			@RequestParam(value = "temperature", defaultValue = "36.5") double temperature) {
		
		// DB insert
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		// 결과 화면 이동
		return "lesson04/afterAddSeller";
	}
	
	
	// 최신 판매자 정보 화면
	// http://localhost:8080/lesson04/quiz01/seller-info-view
	// http://localhost:8080/lesson04/quiz01/seller-info-view?id=3
	@GetMapping("/seller-info-view")
	public String sellerInfoView (
			@RequestParam(value = "id", required = false) Integer id,
			Model model) {
		// DB select 
		// id가 null이면 최신, id 있으면 id로
		Seller seller = null;
		if(id ==null) {
			seller = sellerBO.getLatestSeller();
		}else {
			seller = sellerBO.getSellerById(id);
		}
		
		// Controller가 Model에 데이터를 집어 넣는다.
		// HTML(view)가 Model에서 꺼내서 쓴다.
		model.addAttribute("seller",seller);
		model.addAttribute("title", "판매자 정보");
		
		return "lesson04/sellerInfo";
	}
	
}
