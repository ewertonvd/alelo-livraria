package br.com.alelo.livraria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@RequestMapping("/")
	@ResponseBody
	public String hello() {
		return "Essa é um API 'simples', com os métodos GET/POST/Delete e PUT.\nUtilizando Spring Boot, Java8 e BD em memória H2";
	}
}