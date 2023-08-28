package pl.maja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.maja.model.MountainPeak;
import pl.maja.model.User;
import pl.maja.service.MountainPeakService;
import pl.maja.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/addPeak")
public class AddMountainPeakController {

    private UserService userService;
    private MountainPeakService mountainPeakService;

    public AddMountainPeakController(UserService userService, MountainPeakService mountainPeakService) {
        this.userService = userService;
        this.mountainPeakService = mountainPeakService;
    }

    @GetMapping
    public String showAddMountainPeakForm(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "add-mountain-peak-form";
    }

    @PostMapping
    public String handleAddMountainPeakForm(@RequestParam String nickName, MountainPeak mountainPeak) {
        User user = userService.getUser(nickName);
        if (user != null) {
            mountainPeak.setUser(user);
            mountainPeakService.addMountainPeak(mountainPeak);
        }
        return "redirect:/addPeak";
    }



}
