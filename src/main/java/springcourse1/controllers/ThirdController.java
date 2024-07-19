package springcourse1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
public class ThirdController {

    @GetMapping("/calculator")
    public String Calculator(@RequestParam("number") Integer number,
                             @RequestParam("number2") Integer number2,
                             @RequestParam("action") String action,
                             Model model) {

            if(Objects.equals(action, "addition")){
                model.addAttribute("addition", (number+number2));
            }
            else if(Objects.equals("subtraction", action)){
                model.addAttribute("subtraction", (number-number2));
            }
            else if(Objects.equals(action, "multiplication")){
                model.addAttribute("multiplication", (number*number2));
            }
            else if(Objects.equals(action, "division") && number2==0){
                model.addAttribute("mistake", "Mistake");
            }
            else if(Objects.equals(action, "division")){
                model.addAttribute("division", (number/number2));
            }
            else{
                model.addAttribute("mistake2", "Use correct action");
            }

        return "first/calculator";

    }
}

