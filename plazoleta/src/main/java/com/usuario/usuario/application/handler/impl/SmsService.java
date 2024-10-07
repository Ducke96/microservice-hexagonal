package com.usuario.usuario.application.handler.impl;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SmsService {

    private String accountSid = "";

    private String authToken = "";

    private String fromNumber = "";

    public SmsService() {
        Twilio.init(accountSid, authToken);
    }

    public void sendSms(String to, String body) {
        Message message = Message.creator(
                new PhoneNumber(to),
                new PhoneNumber(fromNumber),
                body).create();
        System.out.println("SMS sent: " + message.getSid());
    }
}