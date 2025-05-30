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
![Screenshot (259)](https://github.com/user-attachments/assets/bbe4223d-703f-49e6-ae9e-116bf00a9832)
![Screenshot (260)](https://github.com/user-attachments/assets/53b2b6f7-868d-4f2c-acf8-b4842bd98b72)
![Screenshot (261)](https://github.com/user-attachments/assets/19e24341-d80f-49a6-a5f1-3241d209922c)
![Screenshot (262)](https://github.com/user-attachments/assets/a164693f-40d3-4586-9ac0-301cdf364816)
![Screenshot (263)](https://github.com/user-attachments/assets/e1dd5946-6fa7-4793-b144-0f2119259924)
![Screenshot (264)](https://github.com/user-attachments/assets/eb070aab-301a-46ca-9ab8-377ceda0ddf4)
![Screenshot (265)](https://github.com/user-attachments/assets/1137081c-dd5c-46a9-add4-336e8f255f09)
![Screenshot (266)](https://github.com/user-attachments/assets/fa83f72c-57ae-4f2e-9423-a76ad82103b7)
![Screenshot (267)](https://github.com/user-attachments/assets/bee2118d-8f44-4497-84de-d253b5db0fa7)




