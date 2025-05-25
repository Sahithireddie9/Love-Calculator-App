package services;

public interface LoveAppEmailService {
	
	void sendRegistrationSuccess(String username,String email);
	
	void sendEmail(String username,String userEmail,String result);
	
	void sendFeedback(String username,String email,String message);

}
