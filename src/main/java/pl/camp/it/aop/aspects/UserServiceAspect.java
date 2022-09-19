package pl.camp.it.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import pl.camp.it.aop.model.User;

@Component
@Aspect
public class UserServiceAspect {

    @Pointcut("execution(pl.camp.it.aop.model.User pl.camp.it.aop.services.impl.UserServiceImpl.getUser1())")
    public void getUser1Pointcut() {}

    @Pointcut("execution(* pl.camp.it.aop.services.impl.UserServiceImpl.*(..))")
    public void getAllUsersPointCut() {}

    @Pointcut("within(pl.camp.it.aop.services.impl.UserServiceImpl)")
    public void getAllUsers2PointCut() {}

    @Pointcut("within(pl.camp.it.aop.services.impl.*)")
    public void getAllUsersPackagePointCut() {}

    @Pointcut("target(pl.camp.it.aop.services.IUserService)")
    public void getAllUsersInterfacePointCut() {}

    @AfterReturning(value = "getUser1Pointcut()", returning = "value")
    public void printAdditionalData(User value) {
        System.out.println(value.getLogin());
        System.out.println(value.getPassword());
        System.out.println("Dodatkowe informacje !!!");
    }

    @Around("getUser1Pointcut()")
    public User duringMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Wykryto wywolanie metody z UserServiceImpl !!!");
        System.out.println("Wykonuje jakies operacje przed !!!");
        Object proceedResult = joinPoint.proceed();
        if(proceedResult instanceof User) {
            User user = (User) proceedResult;
            user.setId(200);
            System.out.println("jakies rzeczy po wykonaniu docelowej metody !!!");
            return user;
        }

        return null;
    }
}
