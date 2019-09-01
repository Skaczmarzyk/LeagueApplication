package pl.lolapp.User;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {



    @GetMapping(path= "/userForm")
    public String getUserForm()
    {
        return "UserForm";
    }

    @PostMapping(path= "/userForm")
    public String submitUserForm()
    {

        return "UserForm";
    }

    @GetMapping(path= "/registerForm")
    public String getRegisterForm(Model model)
    {
        model.addAttribute("user",new User());
        return "registerForm";
    }
    @PostMapping(path= "/registerForm/add")
    public String submitRegisterForm(@ModelAttribute("user")User user)
    {
        System.out.println(user.email);
        return "registerForm";
    }


}
