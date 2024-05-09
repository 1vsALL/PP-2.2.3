package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
    final
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String users(ModelMap modelMap) {
        modelMap.addAttribute("userList", userService.listUsers());
        return "users";
    }
    @GetMapping("/add")
    public String add(ModelMap modelMap){

        return "add";
    }

}
