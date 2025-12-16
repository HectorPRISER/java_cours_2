package fr.wijin.aspecttuto.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // Avant l'exécution de toutes les méthodes du service
    @Before("execution(* fr.wijin.aspecttuto.service.TransferService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("[BEFORE] Method: " + joinPoint.getSignature().getName());
    }

    // Après l’exécution normale (retour sans exception)
    @AfterReturning(pointcut = "execution(* fr.wijin.aspecttuto.service.TransferService.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("[AFTER RETURNING] Method: " + joinPoint.getSignature().getName() + ", Result: " + result);
    }

    // Après qu’une exception est levée
    @AfterThrowing(pointcut = "execution(* fr.wijin.aspecttuto.service.TransferService.*(..))", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Exception ex) {
        System.out.println("[AFTER THROWING] Method: " + joinPoint.getSignature().getName() + ", Exception: " + ex.getMessage());
    }

    // Autour de l’exécution (permets de modifier ou mesurer le temps)
    @Around("execution(* fr.wijin.aspecttuto.service.TransferService.*(..))")
    public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("[AROUND] Before method: " + pjp.getSignature().getName());
        Object result = null;
        try {
            result = pjp.proceed();
        } catch (Throwable ex) {
            System.out.println("[AROUND] Exception in method: " + pjp.getSignature().getName() + " -> " + ex.getMessage());
            throw ex;
        }
        System.out.println("[AROUND] After method: " + pjp.getSignature().getName());
        return result;
    }
}
