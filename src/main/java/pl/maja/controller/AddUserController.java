package pl.maja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.maja.model.User;
import pl.maja.service.UserService;

@Controller
@RequestMapping("/addUser")
public class AddUserController {

    private UserService userService;

    public AddUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String handleGetRequest() {
        return "add-user";
    }

    @PostMapping
    public String handlePostRequest(User user, Model model) {
        userService.addUser(user);
        System.out.println(user);

        return "user-added";
    }




}
