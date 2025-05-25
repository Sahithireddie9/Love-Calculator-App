package customValidators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age,Integer> {
	private int min;
	private int max;
	@Override
	public void initialize(Age age) {
		this.max=age.max();
		this.min=age.min();
	}
	
	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		
		if(value==null) return false;
		if(value<min ||  value>max) {
			return false;
		}
		return true;
	}

}
