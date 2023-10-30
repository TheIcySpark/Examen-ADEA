package com.adea.evaluation.controller;

import com.adea.evaluation.model.UserFilterModel;
import com.adea.evaluation.model.UserModel;
import com.adea.evaluation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/tablero-usuarios")
    public String TableroUsuarios(@ModelAttribute UserFilterModel userFilter, Model model){
        model.addAttribute("userFilter", new UserFilterModel());
        List<UserModel> users = userService.searchUsers(userFilter.getNombre(),
                userFilter.getFechaAlta(), userFilter.getFechaBaja());
        model.addAttribute("users", users);
        return "tablero-usuarios";
    }

    @GetMapping("/gestion-usuarios")
    public String GestionUsuarios(Model model){
        List<UserModel> users = userService.list();
        model.addAttribute("users", users);
        model.addAttribute("user", new UserModel());
        return "gestion-usuarios";
    }

    @GetMapping("/delete-user/{login}")
    public String deleteUser(Model model, @PathVariable String login){
        userService.delete(login);
        return "redirect:/gestion-usuarios";
    }

    @GetMapping("change-user-status/{login}/{status}")
    public String changeUserStatus(Model model, @PathVariable String login, @PathVariable Character status){
        userService.changeUserStatus(login, status);
        return "redirect:/tablero-usuarios";
    }

    @PostMapping("/edit-user/{login}")
    public String editUser(@PathVariable String login, @ModelAttribute("user") UserModel user, Model model){
        userService.update(user, login);
        return "redirect:/gestion-usuarios";
    }

    @PostMapping("/save-user")
    public String saveUser(@ModelAttribute("user") UserModel user, Model model){
        userService.save(user);
        return "redirect:/gestion-usuarios";
    }
}
