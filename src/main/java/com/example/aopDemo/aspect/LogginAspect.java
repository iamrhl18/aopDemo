package com.example.aopDemo.aspect;

import com.example.aopDemo.annotation.MeasureExecutionTime;
import com.example.aopDemo.dto.Student;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;



@Component
@Aspect
public class LogginAspect {

    @Around("@annotation(measureExecutionTime)")
    public Object logBeforeMethod(ProceedingJoinPoint joinPoint , MeasureExecutionTime measureExecutionTime) throws Throwable{
        long startTime = System.currentTimeMillis();

        try {
            return joinPoint.proceed();
        }
        finally {
            long endtime = System.currentTimeMillis();
            long duration = endtime - startTime;
            String operation = measureExecutionTime.operation();
            if(operation.isBlank()){
                operation = joinPoint.getSignature().getName();
            }

            long TimeOutTime = measureExecutionTime.warnAfter();

            if(duration>=TimeOutTime){
                System.out.println("SLOW OPERATION FOUND " + "Total time taken by :" +
                        " " + operation + " : " + duration);
            }
            else System.out.println("Total time taken by :" +
                    " " + operation + " : " + duration);
        }
    }

    @Before("com.example.aopDemo.aspect.serviceMethod()")
    public void demoMethods(){
        System.out.println("Dummy intercepor intercepted");
    }

}
