package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {
	int iv = 10;
	static int cv = 20;
	
	@RequestMapping("/hello")
	public void main() {//인스턴스 메서드
		System.out.println("Hello");
		System.out.println(cv);
	//	System.out.println(iv);
	}
	
	public static void main2() {// static 메서드
		System.out.println(cv);
	//	System.out.println(iv);
	}
}
