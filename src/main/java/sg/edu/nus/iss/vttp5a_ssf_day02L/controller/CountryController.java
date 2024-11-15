package sg.edu.nus.iss.vttp5a_ssf_day02L.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sg.edu.nus.iss.vttp5a_ssf_day02L.model.Country;
import sg.edu.nus.iss.vttp5a_ssf_day02L.service.CountryService;

@Controller
@RequestMapping("/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @ResponseBody
    @GetMapping("")
    public List<Country> getCountries() {

        return countryService.getCountries();
    }

    @GetMapping("/list")
    public String displayCountryList(Model model)  {
        var countries = countryService.getCountries();
        model.addAttribute("countries", countries);
        return "countryList";

    }

    @GetMapping("/list/filter")
    public String displayFilterCountryList(
        @RequestParam String quantity,
        Model model)  {
        var countries = countryService.getCountries();
        countries.stream().filter( c -> c.getPopulation() >= Integer.parseInt(quantity)).collect(Collectors.toList());
        model.addAttribute("countries", countries);
        return "countryList";

    }


    
}
