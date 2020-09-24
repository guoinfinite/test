package guojing.pro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guojing
 * @version 1.0
 * @date 2020/9/24 上午10:12
 */
@RestController
public class TestController {

	@GetMapping("/hello")
	public String hello() {
		return "hello world";
	}
}
