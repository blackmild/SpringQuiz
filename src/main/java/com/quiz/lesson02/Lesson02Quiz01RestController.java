package com.quiz.lesson02;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson02.domain.Store;

@RestController
public class Lesson02Quiz01RestController {

	// http://localhost:8080/lesson02/quiz01
	@RequestMapping("/lesson02/quiz01")
	public List<Store> quiz01 () {
		List<Store> storeList = ;
		
		return storeList;
	}
}
