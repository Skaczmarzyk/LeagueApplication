package pl.lolapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomepageController {

    public String getHomepage(Model model)
    {
        return "redirect:/championComp";
    }

}
