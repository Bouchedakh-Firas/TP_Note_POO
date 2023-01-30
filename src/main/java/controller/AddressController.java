package controller;

import model.AdresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddressController {
    @Autowired
    AdresseRepository addressRepository;
    @GetMapping("/addresses")
    public String showAddresses(@RequestParam(name="name", required=false , defaultValue="User") String name,Model model) {
        model.addAttribute("allAddresses", addressRepository.findAll());
        model.addAttribute("user", name);
        return "addresses";
    }

    @GetMapping("/adresse")
    public String AjouterAddresse( Model model) {

        return "AjouterAddresse";
    }
}

