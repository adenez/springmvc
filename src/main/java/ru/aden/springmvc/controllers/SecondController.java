package ru.aden.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/second")
public class SecondController {

    @GetMapping("/calculator")
    public String helloPage(@RequestParam(value = "a", required = false) int a,
                            @RequestParam(value = "b", required = false) int b,
                            @RequestParam(value = "sym", required = false) String sym,
                            Model model) {
        if (sym == null){
            sym = "+";
        }

        if (a == 0 || b == 0) {
            a = 0;
            b = 0;
        }

        double result = 0;

        switch (sym) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "/":
                result = a / (double)b;
                break;
            case "*":
                result = a * b;
                break;
            default:
                result = a + b;
        }

        model.addAttribute("result", "Result:" + result);
        return "second/calculator";
    }

    @GetMapping("/exit")
    public String exit() {
        return "second/exit";
    }
}
