package com.lab4.exchangerate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@Controller
public class ExchangeController {

    @GetMapping("/exchange")
    public String getExchangeRate(Model model) throws ParserConfigurationException, SAXException, IOException
    {
        model.addAttribute("exchange", ExchangeData.requestExchange());
        return "index.html";
    }
}
