Love Calculator Application

A simple web application built with Spring MVC that calculates love compatibility between two people.

Features:

User Registration and Login with form validation using Hibernate

Home page to enter user name and crush name

Calculates and displays the love compatibility result

View history of previous calculations

Send result via email

Provide feedback through the feedback form

Session management to track logged-in users

Email notifications for registration success, feedback, and result sharing

Technologies Used:

Java

Spring MVC

Hibernate

JSP

MySQL

Email API (JavaMail)

Session management

CSS

Configuration:

Database:
Set your MySQL database configuration in application.properties:

db.driver=com.mysql.cj.jdbc.Driver
db.url=jdbc:mysql://localhost:3306/lovecalculatordb
db.username=your_db_username
db.password=your_db_password

Email:
Set up email configuration in application.properties:

mail.host=smtp.gmail.com
mail.port=587
mail.username=your_email@gmail.com
mail.password=your_email_password
mail.protocol=smtp
mail.smtp.auth=true
mail.smtp.starttls.enable=true

Note: For security, keep sensitive info like passwords outside of your code (e.g., using environment variables or config servers).

How to Run:

Clone the repository:
git clone https://github.com/Sahithireddie9/Love-Calculator-App.git

Set up MySQL database:
Create a database named lovecalculatordb and update credentials in application.properties.

Import the project into your IDE:
Use IntelliJ IDEA, Eclipse, or any other Java IDE.

Build and run the project:
Run the Spring MVC application using your IDE or build tool.

Open in browser:
Go to http://localhost:8080/ to use the app.

Contact:
Feel free to reach out for feedback or questions!

Enjoy using the Love Calculator! 💖


