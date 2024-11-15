package sg.edu.nus.iss.vttp5a_ssf_day02L.controller;

import java.util.Calendar; 
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping(path = {"", "/landing"})
    public String home(Model model) {
        model.addAttribute("currentTime", (new Date()).toString());
        Calendar cal = Calendar.getInstance();
        model.addAttribute("currentHour", cal.get(Calendar.HOUR_OF_DAY));
        return "home";
    }

  
    
}
