package com.kapil.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccountAspectDemo {

    @Before("execution (* com.kapil.aopdemo.dao.AccountDAO.addAccount())")
    public void addAccountBeforeAdvice(JoinPoint joinPoint) {
        System.out.println("  addAccountBeforeAdvice RAN ");
    }

    @Before("execution (* com.kapil.aopdemo.dao.*.addAccount(..))")
    public void anyTypePatternMatchingBeforeAdvice(JoinPoint joinPoint) {
        System.out.println("  anyTypePatternMatchingBeforeAdvice RAN ");
    }

    @Before("execution (* display*())")
    public void displayPatternBeforeAdvice(JoinPoint joinPoint) {
        System.out.println("  displayPatternBeforeAdvice RAN ");
    }

    @Pointcut("execution (* com.kapil.aopdemo.dao.MembershipDAO.displayInsideMembershipDAO(..))")
    public void doForPackage() {
        System.out.println("  Point Cut Declaration Example      ");
    }

    @Pointcut("execution (* com.kapil.aopdemo.dao.AccountDAO.set*(..))")
    public void doForSetter() {
        System.out.println("  Point Cut Declaration Example for Setter      ");
    }
    @Pointcut("execution (* com.kapil.aopdemo.dao.AccountDAO.get*(..))")
    public void doForGetter() {
        System.out.println("  Point Cut Declaration Example for Getter          ");
    }

    @Pointcut("execution (* com.kapil.aopdemo.dao.AccountDAO.*(..))")
    public void doForAccDAO() {
        System.out.println("  Point Cut Declaration Example      ");
    }
    @Before("doForAccDAO() && !(doForSetter() || doForGetter())")
    public void pointCutDeclarationExample() {
        System.out.println("  Point Cut With Logical Operation Example      ");
    }
}
