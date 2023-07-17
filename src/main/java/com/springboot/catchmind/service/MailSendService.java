package com.springboot.catchmind.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Random;
@Service
public class MailSendService {

	@Autowired
	private JavaMailSender mailSender;
	private int authNumber;

		public void makeRandomNumber() {
			Random r = new Random();
			int checkNum = r.nextInt(888888) + 111111;
			authNumber = checkNum;
		}
				public String findEmail(String memail) {
			makeRandomNumber();
			String setFrom = "uo1992@naver.com";
			String toMail = memail;
			String title = "Catch Mind password search authentication.";
			String content = 
					"Thank you for visiting Catch Mind." +
	                "<br><br>" + 
				    "Verification number is " + authNumber + " no see." + 
				    "<br>" + 
				    "Please enter the verification number in the verification code box.";
			mailSend(setFrom, toMail, title, content);
			return Integer.toString(authNumber);
		}


		public void mailSend(String setFrom, String toMail, String title, String content) {
			MimeMessage message = mailSender.createMimeMessage();
			try {
				MimeMessageHelper helper = new MimeMessageHelper(message,true,"utf-8");
				helper.setFrom(setFrom);
				helper.setTo(toMail);
				helper.setSubject(title);
				helper.setText(content,true);
				mailSender.send(message);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
}
