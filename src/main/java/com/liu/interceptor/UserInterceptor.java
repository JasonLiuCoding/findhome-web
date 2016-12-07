package com.liu.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//声明该类为切面  
@Aspect  
@Component  
public class UserInterceptor {  

  //注意，第一个拦截所有方法，方法要获取参数，可以加上参数"&& args(param)"  
  //@Pointcut(value="execution (* com.liu.service.UserServiceImpl.*(..))")  
  @Pointcut(value="execution (* com.liu.service.UserServiceImpl.addUser(..))")  
  private void anyMethod(){} // 声明一个切入点，切入点名称是一个方法  
    
  //前置通知，没参数  
  @Before(value="anyMethod()")  
  public void before(){  
      System.out.println("before");  
  }  
    
  @AfterReturning("anyMethod()")  
  public void afterReturning(){  
      System.out.println("afterReturning");  
  }  
    
  @AfterThrowing(value="anyMethod()",throwing="ex")  
  public void afterThrowing(){  
      System.out.println("afterThrowing");  
  }  
    
  @After("anyMethod()")  
  public void after(){  
      System.out.println("after");  
  }  
    
  @Around("anyMethod()")  
  public Object around(ProceedingJoinPoint pjp) throws Throwable{  
      System.out.println("进入around中");  
      Object proceed = pjp.proceed();  
      Object[] args = pjp.getArgs();//可以在这里获取到所有参数
      System.out.println("退出around");  
      return proceed;  
  }  
} 
