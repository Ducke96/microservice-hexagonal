package com.usuario.usuario.infrastructure.input.rest;

import org.springframework.web.bind.annotation.*;

import com.usuario.usuario.application.handler.impl.SmsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/sms")
@RequiredArgsConstructor
public class SmsController {

    private SmsService smsService;

    @PostMapping("/send")
    public String sendSms(@RequestParam String to, @RequestParam String body) {
        smsService.sendSms(to, body);
        return "SMS sent successfully!";
    }
}