package sg.edu.nus.iss.vttp5a_ssf_day02L.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sg.edu.nus.iss.vttp5a_ssf_day02L.model.Country;
import sg.edu.nus.iss.vttp5a_ssf_day02L.repo.CountryRepo;

@Service
public class CountryService {

    private final CountryRepo countryRepo;

    public CountryService(CountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }
    
    public List<Country> getCountries() {
        return countryRepo.getCountries();
    }
    
    public Boolean createCountry(Country c) {
        Boolean result = countryRepo.createCountry(c);
        return result;
    }
}
