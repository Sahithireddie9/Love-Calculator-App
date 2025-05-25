package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import dao.LoveResultDAO;


import dtos.NamesDTO;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import services.ResultCalculation;

@Controller
public class HomeController {
	
	@Autowired
	private ResultCalculation resultCalculation;

	
	@Autowired
	private LoveResultDAO loveResultDAO;

	
	
	
	@GetMapping("/home")
	public String homePage(Model model,HttpSession session) {
		if(session.getAttribute("userEmail")!=null) {
			model.addAttribute("namesInfo",new NamesDTO());
			return "home";
		}
		
		return "redirect:/login";
	}
	
	
	@PostMapping("/calculateResult")
	public String resultPage(@Valid @ModelAttribute("namesInfo") NamesDTO namesInfo, BindingResult bindingResult, Model model ,HttpSession session ) {
		String email = (String) session.getAttribute("userEmail");
	    if (email == null) {
	        model.addAttribute("error", "Session expired. Please log in again.");
	        return "login";
	    }
	    if(bindingResult.hasErrors()) {
	    	return "redirect:/home";
	    }
		int userId=(int) session.getAttribute("userId");
		String result=resultCalculation.result(namesInfo.getYourname(), namesInfo.getCrushname());
		boolean saved=loveResultDAO.saveResult(namesInfo, userId, result);
		if(saved) {
	        session.setAttribute("loveResult", result); 
			model.addAttribute("namesInfo",namesInfo);
			model.addAttribute("result",result);
			return "calculate";    
		}
		return "home";
	}
	
	
	@RequestMapping("/seeHistory")
	public String history(HttpSession session,Model model) {
		Integer userId=(Integer) session.getAttribute("userId");
		 if (userId == null) {
            model.addAttribute("error", "Session expired. Please log in again.");
            return "login";
	        }
		
		SqlRowSet rowSet=loveResultDAO.getHistory(userId);
		List<Map<String,Object>> history=new ArrayList<>();
		while(rowSet.next()) {
			Map<String, Object> row = new HashMap<>();
	        row.put("yourName", rowSet.getString("your_name"));
	        row.put("crushName", rowSet.getString("crush_name"));
	        row.put("result", rowSet.getString("result"));
	        row.put("time", rowSet.getTimestamp("calculated_at"));
	        history.add(row);
		}
		
		 model.addAttribute("history", history);
		return "history";
	}
	
	
	

}
