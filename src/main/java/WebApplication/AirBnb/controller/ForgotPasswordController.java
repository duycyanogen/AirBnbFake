package WebApplication.AirBnb.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import WebApplication.AirBnb.domain.Accounts;
import WebApplication.AirBnb.domain.Services;
import WebApplication.AirBnb.model.AccountDto;
import WebApplication.AirBnb.repository.AccountRepository;
import WebApplication.AirBnb.service.impl.AccountServiceImpl;
import net.bytebuddy.utility.RandomString;

@Controller
//@RequestMapping("")
public class ForgotPasswordController {

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	AccountServiceImpl accountService;

	@Autowired
	SessionFactory factory;

//	@Autowired
//	JavaMailSender mailer;

	@RequestMapping(value = "forgot-pass", method = RequestMethod.GET)
	public String forgotPassword(ModelMap model) {
		return "account/forgot-pass";
	}

	@RequestMapping(value = "forgot-pass", method = RequestMethod.POST)
	public String processForgotPassword(ModelMap model, HttpServletRequest re) {
		
		JavaMailSenderImpl mailer = new JavaMailSenderImpl();
		
		//Set c???u h??nh g???i mail
		mailer.setHost("smtp.gmail.com");
		mailer.setPort(587);
		mailer.setUsername("airb8080@gmail.com");
		mailer.setPassword("@mdd456789");
		 
		Properties properties = new Properties();
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		
		//C???u h??nh g???i mail
		mailer.setJavaMailProperties(properties);
		
		Session s = factory.openSession();
		Transaction t = s.beginTransaction();
		boolean check = true;
		
		String email = re.getParameter("email");
		
		try {
		//T??m Account theo Email
		Accounts ac = new Accounts();
		ac = accountService.getAccountByMail(email);
		
		// Random password
		int random = (int) Math.floor(((Math.random() * 8999999) + 1000000));
		String newPassword = String.valueOf(random);
		String mailgui;
		mailgui = ac.getMail();
		ac.setPassword(newPassword);
		
		check = false;
		// T???o Date v???i th???i gian hi???n t???i
		Date date = new Date();
		String from = "AirBnbFake";
		String to = mailgui;
		SimpleMailMessage message = new SimpleMailMessage();
		String subject = "Qu??n m???t kh???u";
		String body = "B???n ???? b??o qu??n m???t kh???u v??o " + date + "  m???t kh???u m???i c???a b???n l?? " + newPassword
				+ "\n N???u b???n kh??ng th???c hi???n y??u c???u tr??n , vui l??ng li??n h??? qu???n tr??? vi??n ngay";
		
		message.setFrom(from);
		message.setTo(to);
		message.setReplyTo(from);
		message.setSubject(subject);
		message.setText(body);
		mailer.send(message);
		
		model.addAttribute("tinnhan", "M???t kh???u m???i ???? g???i ?????n email c???a b???n");
		
		ac.setPassword(bCryptPasswordEncoder.encode(newPassword));
		s.update(ac);
		t.commit();
		} catch (Exception ex) {
			model.addAttribute("tinnhan", "T??i kho???n kh??ng t???n t???i");
			t.rollback();
		} finally {
			s.close();
		}

//		if (check == true) {
//			model.addAttribute("tinnhan", "T??i kho???n kh??ng t???n t???i");
//		}

		return "account/forgot-pass";
	}
}
