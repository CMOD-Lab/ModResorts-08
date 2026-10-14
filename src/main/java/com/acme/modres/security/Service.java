package com.acme.modres.security;

public class Service {
  public static final String OPERATION = "my-operation";

  public void operation() {
    // SecurityManager has been deprecated for removal since Java 17 and is
    // effectively a no-op in Java 21. System.getSecurityManager() always returns
    // null in Java 21. The SecurityManager-based access check has been removed
    // for Java 21 compatibility.
    System.out.println("Operation is executed");
  }
}
