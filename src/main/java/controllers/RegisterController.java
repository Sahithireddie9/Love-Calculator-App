package controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import dao.UserDAO;
import dtos.RegisterDTO;
import jakarta.validation.Valid;
import services.LoveAppEmailServiceImpl;

@Controller
public class RegisterController {
	
	@Autowired
	private LoveAppEmailServiceImpl emailService;
	
	@Autowired
	private UserDAO userDAO;
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("registerInfo",new RegisterDTO());
		return "register";
	}
	
	@PostMapping("/processResult")
	public String handleRegistration(@Valid @ModelAttribute("registerInfo") RegisterDTO registerInfo,BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "register";
		}
		
		// Email already exists
		if(userDAO.emailExist(registerInfo.getEmail())) {
			model.addAttribute("emailError", "Email already exists");
			return "register";
			
		}
		
		// Register user
		boolean isRegistered=userDAO.registerUser(registerInfo);
		if (isRegistered) {
			emailService.sendRegistrationSuccess(registerInfo.getName(), registerInfo.getEmail());
		    return "redirect:/processResult";
		}

		// Fallback (should not occur under normal circumstances)
	    model.addAttribute("emailError", "An unexpected error occurred");
		return "register";
	}
	
	@GetMapping("/processResult")
	public String showResultPage() {
	    return "processResult";
	}

	

}
