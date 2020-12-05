package com.aop.aop02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;


import java.util.Date;

/*
 * @Aspect: 是aspectj框架中的注解
 *     作用：表示当前类是切面类
 *     切面类：是用来给业务方法增加功能的类，在这个类中有切面的功能的代码
 *     位置：在类定义的上面
 **/

@Aspect
public class MyAspect {
    /*
     定义方法，方法是实现切面功能的
     方法的定义要求：
      1.公共方法public
      2.方法没有返回值
      3.方法名称自定义
      4.方法有参数,推荐是Object，参数名自定义
     **/


    /*
     @AfterReturning: 后置通知
        属性：1.value 切入点表达式
             2.returning 自定义的变量，表示目标方法返回值
        位置： 在发那个发定义的上面
        特点：
         1.在目标方法之后执行
         2.能够获取到目标方法的返回值，可以根据这个返回值做不同的处理功能
            Object res = doOther()
         3.可以修改这个返回值

         后置通知的执行
         object res = doOther()
         myAfterReturning(res)
     **/

    @AfterReturning(value = "execution(* *..SomeServiceImpl.doOther(..))", returning = "res")
    public void myAfterReturning(Object res) {
        // Object res: 是目标非那个发执行后的返回值，根据返回值做你的切面的功能处理
        System.out.println("后置通知：在目标方法执行之后执行的，获取的返回值是：" + res);
        if(res.equals("doOther()")) {
            System.out.println("返回值是：doOther()");
        }

        if(res != null) {
            res = "hello world!";
        }
    }


}