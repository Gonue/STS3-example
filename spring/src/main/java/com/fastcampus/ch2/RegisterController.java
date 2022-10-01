package com.fastcampus.ch2;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
	//@RequestMapping("/register/add")
//	@GetMapping("/register/add")
//	public String register() {
//		return "registerForm"; // WEB-INF/views/registerForm.jsp
//	}

	//@RequestMapping(value="/register/save")
	@PostMapping("/register/save") //4.3 버전 부터
	public String save(User user, Model m)throws Exception {
		//1. 유효성 검사
		if(!isvalid(user)) {
			String msg = URLEncoder.encode("id잘못 입력","utf-8");
			return "redirect:/register/add?msg="+msg; //url 재작성
		}
		
		//2. DB 신규회원 정보 저장
		return "registerInfo";
	}

	private boolean isvalid(User user) {
		return true;
	}

}


