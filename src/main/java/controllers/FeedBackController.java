package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import dtos.FeedBackDTO;
import services.LoveAppEmailServiceImpl;

@Controller
public class FeedBackController {
	
	
	@Autowired
	private LoveAppEmailServiceImpl emailService;
	
	@RequestMapping("feedback")
	public String feedbackPage(@ModelAttribute("feedbackDTO")   FeedBackDTO feedbackDTO, Model model) {
		model.addAttribute("feedbackDTO", feedbackDTO);
		return "feedback";
	}
	
	@RequestMapping("/submitFeedback")
	public String sentFeedback(@ModelAttribute("feedbackDTO")  FeedBackDTO feedbackDTO) {
		emailService.sendFeedback(feedbackDTO.getName(), feedbackDTO.getEmail(), feedbackDTO.getMessage());
		return "feedbackSuccess";
	}

}
