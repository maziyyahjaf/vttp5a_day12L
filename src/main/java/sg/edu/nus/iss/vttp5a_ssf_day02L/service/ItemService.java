package sg.edu.nus.iss.vttp5a_ssf_day02L.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.vttp5a_ssf_day02L.model.Item;
import sg.edu.nus.iss.vttp5a_ssf_day02L.repo.ItemRepo;

@Service
public class ItemService {
    
    private final ItemRepo itemRepo;

    @Autowired
    public ItemService(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    public List<Item> getItems() {
        System.out.println(itemRepo.getItems());
        return itemRepo.getItems();
        
    }

    
}
