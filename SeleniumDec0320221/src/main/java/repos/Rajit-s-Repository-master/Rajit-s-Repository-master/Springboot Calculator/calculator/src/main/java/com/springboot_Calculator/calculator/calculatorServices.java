package com.springboot_Calculator.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class calculatorServices {
	
	@GetMapping("/add/{x}/{y}")
	public Response addition(@PathVariable int x , @PathVariable int y) {
		
		return new Response(x, y, x+y);
	}
	
	@GetMapping("/sub/{x}/{y}")
	public Response subtraction(@PathVariable int x , @PathVariable int y) {
		
		return new Response(x, y, x-y) ; 
	}
	
	@GetMapping("/div/{x}/{y}")
	public Response division(@PathVariable int x , @PathVariable int y) {
		
		return new Response(x,y, x/y);
	}
	
	@GetMapping("mul/{x}/{y}")
	public Response multiplication(@PathVariable int x, @PathVariable int y) {
		
		return new Response(x,y,x*y);
		
	}

}
