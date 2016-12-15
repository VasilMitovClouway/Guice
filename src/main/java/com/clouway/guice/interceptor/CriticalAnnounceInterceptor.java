package com.clouway.guice.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
public class CriticalAnnounceInterceptor implements MethodInterceptor {
  public Object invoke(MethodInvocation methodInvocation) throws Throwable {
    System.out.println("Critical damage!!!");
    return methodInvocation.proceed();
  }
}
