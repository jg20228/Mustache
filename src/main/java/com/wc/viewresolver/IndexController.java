package com.wc.viewresolver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //IoC
public class IndexController {
	
	//한개만 걸어두면 위험해서 두개를 함
	@GetMapping({"","/"})
	//함수의 파라미터에 바로 DI해준다.
	public String index(Model model) {
		String name = "cos";
		int num = 10;
		String password="1234";
		model.addAttribute("name",name);
		model.addAttribute("num",num);
		model.addAttribute("password",password);
		return "Index";
	}
	
	@GetMapping("/model/data")
	public String modelData(Model model) {//규칙이니까 DI하기
		Member member = Member.builder()
				.id(1)
				.username("ssar")
				.phone("01022229999")
				.build();
		
		model.addAttribute("member",member);
		
		return "modelData";
	}
	
	//컬렉션
	@GetMapping("/model/array")
	public String modelArray(Model model) {//규칙이니까 DI하기
		Member member = Member.builder()
				.id(1)
				.username("ssar")
				.phone("01022221111")
				.build();
		
		Member member2 = Member.builder()
				.id(2)
				.username("cos")
				.phone("01022223333")
				.build();
		
		List<Member> members = new ArrayList<>();
		members.add(member);
		members.add(member2);
		
		model.addAttribute("members",members);
		//반전 user에 true를 담았으니까
		model.addAttribute("user",true);
		return "modelArray";
	}
	
	//include
	@GetMapping("/layout")
	public String layout() {
		return "layout";
	}
}