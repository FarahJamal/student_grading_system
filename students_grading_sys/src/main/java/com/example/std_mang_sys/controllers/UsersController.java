package com.example.std_mang_sys.controllers;

import com.example.std_mang_sys.data.UsersDAO;
import com.example.std_mang_sys.model.Courses;
import com.example.std_mang_sys.model.Users;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    private UsersDAO usersDAO;

    public UsersController(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Users create(@RequestBody Users users) {
        return usersDAO.add(users);
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object userLogin(@RequestParam("username") String username, @RequestParam("password") String password) {

        ModelAndView mv = new ModelAndView();

        Users user = new Users();
        user.setUsername(username);
        user.setPassword(password);

        Users userData = usersDAO.loginUser(user);

        if (userData != null) {

            mv.addObject("msg", "Welcome " + userData.getUsername() + ", You have successfully logged in.");
            mv.setViewName("welcome");

        } else {

            mv.addObject("msg", "Invalid user id or password.");
            mv.setViewName("login");
        }
        System.out.println("holaaaaaaaaaa "+mv);
        return mv.getModel().get("msg");

    }



}
