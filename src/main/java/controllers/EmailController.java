package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import services.LoveAppEmailServiceImpl;

@Controller
public class EmailController {
	
	
	@Autowired
	private LoveAppEmailServiceImpl emailService; 
	
	@GetMapping("/tryWithEmail")
	public String tryWithEmail( HttpSession session) {
		return "tryWithEmail";
	}
	
	
	@RequestMapping("/sendEmailResult")
	public String sendEmailResult(@RequestParam("email") String senderEmail,HttpSession session) {
		System.out.println(senderEmail);
		String username=(String) session.getAttribute("userName");
		String result=(String) session.getAttribute("loveResult");
		
		emailService.sendEmail(username, senderEmail, result);
		return "emailSent";
		
	}

}
