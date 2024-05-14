package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
    private final UserService userService;

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
    public String newUser(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "add";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String userID(@PathVariable("id") int id, ModelMap modelMap) {
        modelMap.addAttribute("userID", userService.userID(id));
        return "userID";
    }

    @GetMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id) {
        userService.removeUserById(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, ModelMap modelMap) {
        modelMap.addAttribute("user", userService.userID(id));
        return "usersEdit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("user") User user) {
        userService.update(user, id);
        return "redirect:/";
    }

}
