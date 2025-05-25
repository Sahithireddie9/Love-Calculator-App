package dtos;

import java.util.List;

import customValidators.Age;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegisterDTO {
	
	@NotBlank(message = "Name is required")
	@Size(min = 5, message = "Name must be at least 5 characters long"	)
	@Pattern(regexp = "^[A-Za-z ]+$", message = "Name must contain only letters and spaces")
	private String name;
	
	@Age(min=15,max=30,message="Age should be between 15 and 30")
	private Integer age;
	
	
	@Email(message = "Enter a valid email")
    @NotBlank(message = "Email is required")
	private String email;
	
	@Pattern(
			  regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$",
			  message = "Password must be 8-20 characters long, include uppercase, lowercase, number, and special character"
			)
	@NotBlank(message = "Password is required")
	private String password;
	
	@NotEmpty(message = "Please select your gender")
	private String gender;
	
	@NotEmpty(message = "Please select at least one hobby")
	@Size(max = 3, message = "You can select up to 3 hobbies only")
	private List<String> hobbies;
	
	@AssertTrue(message="You must accept terms and conditions")
	private boolean agree;
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getGender() {
		return gender;
	}
	public List<String> getHobbies() {
		return hobbies;
	}
	public boolean isAgree() {
		return agree;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	public void setAgree(boolean agree) {
		this.agree = agree;
	}
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
}
