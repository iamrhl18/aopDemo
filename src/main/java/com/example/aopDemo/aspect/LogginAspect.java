package com.example.aopDemo.aspect;

import com.example.aopDemo.dto.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@Aspect
public class LogginAspect {

    @Before("execution(String com.example.aopDemo.service.StudentService.saveStudent())")
    public void logBeforeMethode(JoinPoint joinPoint){
        // JoinPoint is very important class which hold the target method
        Object[] arr = joinPoint.getArgs();
        System.out.println("Student is going to be saved ");

        // Can we stop the execution of targetMethod from the aspect class
        // Directly : there is no method to stop this but we can do this with alternate
        // We can throw any exception that stop execution of targetmethod and execute catch block

//        boolean allowed = false;
//        if(allowed == false){
//            throw new RuntimeException("This method is not allowed for perticular condition");
//        }
    }

//    @AfterReturning(
//            value = "execution(com.example.aopDemo.dto.Student " +
//                    " com.example.aopDemo.service.StudentService" +
//                    ".saveStudent(com.example.aopDemo.dto.Student ))",
//            returning = "result")
//    public void logAfterReturning(Student result){
//        result.setName("Ajay");
//        System.out.println("Interceptor avoked");
//    }

//    @AfterThrowing(
//            value = "execution(*  com.example.aopDemo.service.StudentService.saveStudent(..)),",
//        throwing = "exception")
//    public void logAfterThrowingMethod(Throwable exception){
//        System.out.println("Exception Type : " + exception.getClass().getName());
//        System.out.println("Exception message : "+exception.getMessage());
//
//
//    }

//    @After(
//            value = "execution(*  com.example.aopDemo.service.StudentService.saveStudent(..)),")
//    public void logAfterMethod(){
//        System.out.println("logAfterMethod executed");
//    }

//    @Around(
//            value = "execution(*  com.example.aopDemo.service.StudentService.saveStudent(..)),")
//    public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("Starting : " + joinPoint.getSignature().getName());
//
//        try {
//            Object result = joinPoint.proceed();
//            System.out.println("Execution successfull");
//            return result;
//        }
//        catch (Exception e){
//            System.out.println("Execution failed");
//            System.out.println("Exception type : " + e.getClass().getName());
//            System.out.println("Exception message :"+  e.getMessage());
//            throw e;
//        }
//        finally {
//            System.out.println("Ending : " + joinPoint.getSignature().getName());
//        }
//    }


    @Around(
            value = "execution(*  com.example.aopDemo.service.StudentService.dummy(..)),")
    public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//        Object[] arr = joinPoint.getArgs();
//        String originalString = (String) arr[0];
//        String modifiedString = originalString.toUpperCase();
//        Object[] modifiedarr = {modifiedString};
//
//        String returnType = (String) joinPoint.proceed(modifiedarr);
//
//        returnType = returnType + "String intercepted";
//
//        return  returnType;

        Object res1 = joinPoint.proceed();

        System.out.println("Intercepted request calling again ");

        Object res2 = joinPoint.proceed();

        return res2;


    }
}
