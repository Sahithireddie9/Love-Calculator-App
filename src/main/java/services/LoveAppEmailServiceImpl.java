package services;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoveAppEmailServiceImpl implements LoveAppEmailService {

    @Autowired
    private JavaMailSender mailSender;
    
    @Override
    public void sendRegistrationSuccess(String username, String email) {
        SimpleMailMessage mailRegisterMessage = new SimpleMailMessage();

        mailRegisterMessage.setTo(email);
        mailRegisterMessage.setSubject("🎉 Welcome to Love Calculator, " + username + "!");

        mailRegisterMessage.setText(
            "Hi " + username + ",\n\n" +
            "🎊 Congratulations! You’ve successfully registered on Love Calculator.\n" +
            "We're thrilled to have you on board. Start exploring your love compatibility now!\n\n" +
            "💖 Features you can try:\n" +
            " - Calculate love matches\n" +
            " - View your crush history\n" +
            " - Share results\n\n" +
            "Thank you for joining us!\n\n" +
            "With love,\n" +
            "❤️ Love Calculator Team"
        );

        mailRegisterMessage.setFrom("sahithireddysabbu123@gmail.com"); // ✅ Replace with your verified sender email

        try {
            mailSender.send(mailRegisterMessage);
            System.out.println("✅ Registration email sent to: " + email);
        } catch (Exception e) {
            System.err.println("❌ Failed to send registration email: " + e.getMessage());
        }
    }

    
    
    

    @Override
    public void sendEmail(String username, String userEmail, String result) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(userEmail);
        mailMessage.setSubject("💖 Your Love Calculator Result is Here!");

        String body = "Hi " + username + ",\n\n" +
                "Thank you for using the Love Calculator App!\n\n" +
                "💘 Based on the names you entered, your love result is:\n\n" +
                "👉 *" + result + "*\n\n" +
                "Want to try again? Visit us anytime at: http://your-love-app-url.com\n\n" +
                "With love,\n" +
                "❤️ The Love Calculator Team";

        mailMessage.setText(body);
        mailMessage.setFrom("sahithireddysabbu123@gmail.com");
        mailSender.send(mailMessage);
    }

	@Override
	public void sendFeedback(String username, String email, String message) {
		// Send to Support Team
	    SimpleMailMessage toTeam = new SimpleMailMessage();
	    toTeam.setTo("sahithireddysabbu123@gmail.com"); // ✅ your team email address
	    toTeam.setSubject("📝 New Feedback from " + username);
	    toTeam.setText(
	        "You have received a new feedback message:\n\n" +
	        "Name: " + username + "\n" +
	        "Email: " +email + "\n\n" +
	        "Message:\n" + message + "\n\n" +
	        "Sent from Love Calculator"
	    );
	    toTeam.setFrom("email");

	    //Send Acknowledgment to User
	    SimpleMailMessage toUser = new SimpleMailMessage();
	    toUser.setTo(email);
	    toUser.setSubject("💖 Thanks for Your Feedback, " + username + "!");
	    toUser.setText(
	        "Hi " + username + ",\n\n" +
	        "Thanks a lot for sending us your feedback!\n" +
	        "We've received your message and our team will review it shortly.\n\n" +
	        "Here’s what you sent:\n" +
	        "-----------------------------------\n" +
	        message + "\n" +
	        "-----------------------------------\n\n" +
	        "💌 With appreciation,\nLove Calculator Team"
	    );
	    toUser.setFrom("sahithireddysabbu123@gmail.com");

	    try {
	        mailSender.send(toTeam);
	        mailSender.send(toUser);
	        System.out.println("✅ Feedback sent to team and reply sent to user: " + email);
	    } catch (Exception e) {
	        System.err.println("❌ Failed to send feedback emails: " + e.getMessage());
	    }
		
	}

	
    
}
