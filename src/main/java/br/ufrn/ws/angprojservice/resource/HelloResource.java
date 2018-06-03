package br.ufrn.ws.angprojservice.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {
	@RequestMapping("/")
	public String saudacao() {
		return "Ola";
	}
}
