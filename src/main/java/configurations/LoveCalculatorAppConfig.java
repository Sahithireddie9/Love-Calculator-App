package configurations;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = {
    "controllers",
    "dao",
    "services"
})
@EnableWebMvc
@PropertySource("classpath:application.properties")
public class LoveCalculatorAppConfig {

    @Value("${db.driver}")
    private String dbDriver;
    
    @Value("${db.url}")
    private String dbUrl;
    
    @Value("${db.username}")
    private String dbUsername;
    
    @Value("${db.password}")
    private String dbPassword;
    
    @Value("${mail.host}")
    private String mailHost;
    
    @Value("${mail.port}")
    private int mailPort;
    
    @Value("${mail.username}")
    private String mailUsername;
    
    @Value("${mail.password}")
    private String mailPassword;
    
    @Value("${mail.protocol}")
    private String mailProtocol;
    
    @Value("${mail.smtp.auth}")
    private String mailSmtpAuth;
    
    @Value("${mail.smtp.starttls.enable}")
    private String mailStartTls;

    @Bean
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/VIEWS/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean 
    public DataSource getDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(dbDriver);
        ds.setUrl(dbUrl);
        ds.setUsername(dbUsername);
        ds.setPassword(dbPassword);
        return ds;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        try (Connection conn = dataSource.getConnection()) {
            System.out.println("✅ Database connection established successfully.");
        } catch (SQLException e) {
            System.out.println("❌ Failed to connect to the database");
            e.printStackTrace();
        }
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public JavaMailSender configureMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(mailHost);
        mailSender.setPort(mailPort);
        mailSender.setUsername(mailUsername);
        mailSender.setPassword(mailPassword);
        mailSender.setJavaMailProperties(mailProperties());
        return mailSender;
    }

    private Properties mailProperties() {
        Properties props = new Properties();
        props.put("mail.transport.protocol", mailProtocol);
        props.put("mail.smtp.auth", mailSmtpAuth);
        props.put("mail.smtp.starttls.enable", mailStartTls);
        return props;
    }
    
   
}