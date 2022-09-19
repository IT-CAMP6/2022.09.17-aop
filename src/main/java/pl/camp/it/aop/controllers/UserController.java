package pl.camp.it.aop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.camp.it.aop.model.User;
import pl.camp.it.aop.services.IUserService;

@RestController
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping(value = "/getuser1", method = RequestMethod.GET)
    public User getUser1() {
        return this.userService.getUser1();
    }

    @RequestMapping(value = "/getuser2", method = RequestMethod.GET)
    public User getUser2() {
        return this.userService.getUser2();
    }

    @RequestMapping(value = "/getuser3", method = RequestMethod.GET)
    public User getUser3() {
        return this.userService.getUser3();
    }
}
