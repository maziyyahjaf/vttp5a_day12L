package sg.edu.nus.iss.vttp5a_ssf_day02L.controller;

import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.nus.iss.vttp5a_ssf_day02L.service.ItemService;

@Controller
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("")
    public String cartItems(Model model) {
        var items = itemService.getItems();
        System.out.println(items);
        model.addAttribute("items", items);
        return "cartList";

    }

    @GetMapping("/filter")
    public String filterCartItems(
        @RequestParam(name = "itemQuantity") String quantity,
        Model model) {
        var items = itemService.getItems();
        items.stream().filter(a -> a.getQuantity() >= Integer.parseInt(quantity))
        .collect(Collectors.toList());
        model.addAttribute("items", items);
        return "cartList.html";

    }

    
}
