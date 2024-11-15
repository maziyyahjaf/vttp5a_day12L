package sg.edu.nus.iss.vttp5a_ssf_day02L.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sg.edu.nus.iss.vttp5a_ssf_day02L.service.CountryService;

@Controller
@RequestMapping("/weather")
public class WeatherController {

    private final CountryService countryService;

    @Autowired
    public WeatherController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("")
    public String weather(
            @RequestParam(required = true, name = "country", defaultValue = "Singapore") String city,
            @RequestParam(name = "metrics", defaultValue = "centimetres") String units,
            Model model) {

        model.addAttribute("city", city);
        model.addAttribute("units", units);
        return "weather";
    }

    @GetMapping("/city/{country}/metrics/{metrics}")
    public String weather2(
            @PathVariable(required = true, name = "country") String city,
            @PathVariable(name = "metrics") String units,
            Model model) {

        model.addAttribute("city", city);
        model.addAttribute("units", units);
        return "weather";
    }

    @GetMapping("/pagea")
    public String pageA(Model model) {
        String[] units = {"millimeter","centimeters", "meter", "kilometer"};
        var countries = countryService.getCountries();

        model.addAttribute("countries", countries);
        model.addAttribute("units", units);

        return "pagea";
    }

    @GetMapping("/forma")
    public String showForm() {
        return "forma";
    }

    @PostMapping("/forma")
    public String handlePageA(
        @RequestBody MultiValueMap<String, String> form) {

            Map<String, String> formData = new HashMap<>();

            for (String str: form.keySet()) {
                formData.put(str, form.getFirst(str));
                System.out.println(str + ">>>>>" + form.getFirst(str));
            }

            return "forma";
        }

}
