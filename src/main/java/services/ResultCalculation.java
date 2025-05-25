package services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class ResultCalculation {
	public String result(String yourname,String crushname) {
		List<String> relation = new ArrayList<>(Arrays.asList("Friends", "Lovers", "Arranged", "Marriage", "Enimes", "Sisters"));
		int length=yourname.length()+crushname.length();
		int letterIndex=length%6;
		return relation.get(letterIndex);
		
	}
	
	


}
