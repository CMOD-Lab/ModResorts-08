package com.acme.modres;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({ "/logout" })
public class LogoutServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response) throws IOException {

    // WSSecurityHelper.revokeSSOCookies is a WebSphere-specific API not available
    // in standard Jakarta EE / Java 21 environments. Replaced with standard
    // session invalidation for Java 21 compatibility.
    try {
      if (request.getSession(false) != null) {
        request.getSession(false).invalidate();
      }
    } catch (Exception e) {
      System.err.println("[ERROR] Error logging out");
      e.printStackTrace();
    }

    response.sendRedirect("login.jsp");
  }
}
