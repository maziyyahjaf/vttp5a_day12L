package sg.edu.nus.iss.vttp5a_ssf_day02L.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5a_ssf_day02L.model.Country;

@Repository
public class CountryRepo {

    private List<Country> countryList;

    public List<Country> getCountries() {

        countryList = new ArrayList<>();

        Country cty = new Country("SG", "Singapore", 6000000);
        countryList.add(cty);
        cty = new Country("MY", "Malaysia", 8000000);
        countryList.add(cty);
        cty = new Country("IL", "Israel", 10000000);
        countryList.add(cty);
        cty = new Country("CN", "China", 100000000);
        countryList.add(cty);
        cty = new Country("EU", "Europe", 800000000);
        countryList.add(cty);
        cty = new Country("HK", "HOng Kong", 7000000);
        countryList.add(cty);

        return countryList;
    }

    public Boolean createCountry(Country cty) {
        if (countryList == null) { // if the countryList is empty
            countryList = new ArrayList<>();
        }

        countryList.add(cty);
        return true;
    }

}
