package com.springboot.catchmind.controller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

@Controller
public class PaymentController {
	//field
	private IamportClient api;
	
	//constructor
	public PaymentController() {
    	// REST API 키와 REST API secret 를 아래처럼 순서대로 입력한다.
		this.api = new IamportClient("2738563041520456","Gexouqp3iADrIXIOfUE58wB3KkudJuoe5Et6XiRi62bY2NZI69sgFuiaTVPTsp13aLTS389obnYPDsci");
	}
		
	@ResponseBody
	@RequestMapping(value="/verifyIamport/{imp_uid}")
	public IamportResponse<Payment> paymentByImpUid(Model model, Locale locale, HttpSession session, 
													@PathVariable(value= "imp_uid") String imp_uid) 
															throws IamportResponseException, IOException {
		System.out.println("결제가격 비교 성공");
		return api.paymentByImpUid(imp_uid);
	}
}
