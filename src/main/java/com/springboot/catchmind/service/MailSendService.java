package com.springboot.catchmind.service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Random;

@Component
public class MailSendService {
	JavaMailSender mailSender;
	private int authNumber; 
	
		public void makeRandomNumber() {
			Random r = new Random();
			int checkNum = r.nextInt(888888) + 111111;
			System.out.println("Random Number : " + checkNum);
			authNumber = checkNum;
		}
		
		public String findEmail(String memail) {
			System.out.println(memail);
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
			System.out.println(mailSender);
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
