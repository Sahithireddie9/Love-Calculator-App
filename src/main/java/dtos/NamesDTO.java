package dtos;

import jakarta.validation.constraints.NotBlank;

public class NamesDTO {
	@NotBlank(message = "Your name is required")
	private String yourname;
	
	@NotBlank(message = "Crush name is required")
	private String crushname;
	
	
	public String getYourname() {
		return yourname;
	}
	public String getCrushname() {
		return crushname;
	}
	public void setYourname(String yourname) {
		this.yourname = yourname;
	}
	public void setCrushname(String crushname) {
		this.crushname = crushname;
	}
	
}
