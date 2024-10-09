package com.quiz.lesson04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01Controller {

	// http://localhost:8080/lesson04/quiz01/add-seller-view
	@RequestMapping(path = "/add-seller-view", method= RequestMethod.GET)
	public String addSellerView() {
		return "lesson04/addSeller";
	}
}
