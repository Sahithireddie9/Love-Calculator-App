package controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.UserDAO;
import dtos.LoginDTO;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class LoginController {
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping("/login")
	public String loginPage(Model model) {
		model.addAttribute("loginInfo",new LoginDTO());
		return "login";
	}
	
	@RequestMapping("/processresult")
	public String homePage(
			@Valid @ModelAttribute("loginInfo")  LoginDTO loginInfo,
			Model model,
			HttpSession session,
			BindingResult result) {
		if(result.hasErrors()) {
			List<ObjectError> errors=result.getAllErrors();
			System.out.println(errors);
			return "login";
		}
		
		String email=loginInfo.getEmail();
		String inputPassword = loginInfo.getPassword();
	    String storedPassword = userDAO.checkPassword(email);
	    System.out.println("This method is called");
	    if (storedPassword == null) {
            model.addAttribute("emailError", "Invalid email address");
            return "login";
        }
	    
	    if (!storedPassword.equals(inputPassword)) {
            model.addAttribute("passwordError", "Incorrect password");
            return "login";
        }
		
		Map<String, Object> userDetails = userDAO.getUserDetailsByEmail(email);
		
		if (userDetails != null) {
            session.setAttribute("userId", userDetails.get("user_id"));
            session.setAttribute("userName", userDetails.get("full_name"));
            session.setAttribute("userEmail", email);
            session.setMaxInactiveInterval(15 * 60);
        }
		return "redirect:/home";	
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

}
