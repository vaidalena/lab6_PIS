package com.lab4.exchangerate.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    @Before("execution(public * com.lab4.exchangerate.ExchangeController.getExchangeRate(org.springframework.ui.Model))")
    public void beforeController()
    {
        System.out.println("[NOTICE] Запуск процесу, відкриття сторінки");
    }

    @After("execution(public * com.lab4.exchangerate.ExchangeController.getExchangeRate(org.springframework.ui.Model))")
    public void afterController()
    {
        System.out.println("[NOTICE] Закриття процесу");
    }
}
