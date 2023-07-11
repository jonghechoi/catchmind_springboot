package com.springboot.catchmind.service;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailSendService {
	@Autowired(required = false)
	private JavaMailSenderImpl mailSender;
	private int authNumber; 
	
		public void makeRandomNumber() {
			Random r = new Random();
			int checkNum = r.nextInt(888888) + 111111;
			System.out.println("������ȣ : " + checkNum);
			authNumber = checkNum;
		}
		
		public String findEmail(String memail) {
			makeRandomNumber();
			String setFrom = "uo1992@naver.com"; // email-config�� ������ �ڽ��� �̸��� �ּҸ� �Է� 
			String toMail = memail;
			String title = "Catch Mind password search authentication."; // �̸��� ���� 
			String content = 
					"Thank you for visiting Catch Mind." + 	//html �������� �ۼ� ! 
	                "<br><br>" + 
				    "Verification number is " + authNumber + " no see." + 
				    "<br>" + 
				    "Please enter the verification number in the verification code box."; //�̸��� ���� ����
			mailSend(setFrom, toMail, title, content);
			return Integer.toString(authNumber);
		}
		
		//�̸��� ���� �޼ҵ�
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
