package org.example.security;


import org.example.security.register.UserAppDTO;
import org.example.security.register.UserAppService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    private UserAppService userAppService;

    public AuthController(UserAppService userAppService) {
        this.userAppService = userAppService;
    }

    @GetMapping("/login")
    public String getLoginPage(@RequestParam(required = false) String error, Model model) {
        model.addAttribute("errorInfo", error);
        return "login";
    }

    @GetMapping("/register")
    public String getRegisterPage() {
        return "register";
    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute UserAppDTO userAppDTO) {
        userAppService.registerUser(userAppDTO);
        return "redirect:/home?name=" + userAppDTO.getName();
    }

}
