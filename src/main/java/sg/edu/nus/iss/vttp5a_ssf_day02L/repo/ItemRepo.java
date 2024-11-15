package sg.edu.nus.iss.vttp5a_ssf_day02L.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5a_ssf_day02L.model.Item;

@Repository
public class ItemRepo {

    private List<Item> itemList;
    
    public List<Item> getItems() {
        itemList = new ArrayList<>();

        Item itm = new Item("Apple", 5);
        itemList.add(itm);
        itm = new Item("Banana", 15);
        itemList.add(itm);
        itm = new Item("Cantaloupe" , 25);
        itemList.add(itm);
        itm = new Item("Durian" , 35);
        itemList.add(itm);

        return itemList;
    }
    
}
