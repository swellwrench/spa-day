package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class UserController {


    @GetMapping("user/add")
    public String displayAddUserForm() {
        return "/user/add";
    }

    @PostMapping("user/add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        model.addAttribute("username",user.getUsername());
        model.addAttribute("email",user.getEmail());
        if(verify.equals(user.getPassword())) {
            UserData.add(user);
            model.addAttribute("databaseOfUsers",UserData.getAll());
            return "/user/index";
        } else {
            model.addAttribute("error","error");
            return "/user/add";
        }
    }

    @GetMapping("user")
    public String displayWelcomeMessage() {
        return "/user/index";
    }

    @GetMapping("user/id/{id}")
    public String displayUserInfoPage(Model model,@PathVariable int id) {
        model.addAttribute("userdata",UserData.getById(id));
        return "/user/userInfoPage";
    }

}