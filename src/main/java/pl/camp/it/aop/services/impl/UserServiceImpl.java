package pl.camp.it.aop.services.impl;

import org.springframework.stereotype.Service;
import pl.camp.it.aop.model.User;
import pl.camp.it.aop.services.IUserService;

@Service
public class UserServiceImpl implements IUserService {
    @Override
    public User getUser1() {
        System.out.println("Wykonywanie metody getUser1 z serwisu !!");
        return new User(1, "mateusz", "mateusz123");
    }

    @Override
    public User getUser2() {
        System.out.println("Wykonywanie metody getUser2 z serwisu !!");
        return new User(2, "janusz", "janusz123");
    }

    @Override
    public User getUser3() {
        System.out.println("Wykonywanie metody getUser3 z serwisu !!");
        return new User(3, "wiesiek", "wiesiek123");
    }
}
