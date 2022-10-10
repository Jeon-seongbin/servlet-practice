package org.example;

import org.example.calculator.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(CalculatorServlet.class);

//    private ServletConfig servletConfig;
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        logger.info("CalculatorServlet init");
//        this.servletConfig = config;
//    }
//
//    @Override
//    public ServletConfig getServletConfig() {
//        logger.info("CalculatorServlet getServletConfig");
//        return this.servletConfig;
//    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);

        logger.info("CalculatorServlet service");

        int operand1 = Integer.parseInt(req.getParameter("operand1"));
        String operator = req.getParameter("operator");
        int operand2 = Integer.parseInt(req.getParameter("operand2"));

        int result = Calculator.calculator(operand1, operator, operand2);
        PrintWriter pw = resp.getWriter();
        pw.write(result);
    }

//    public void doGet(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//
//    }

//    @Override
//    public String getServletInfo() {
//        logger.info("CalculatorServlet getServletInfo");
//        return null;
//    }
//
//    @Override
//    public void destroy() {
//        logger.info("CalculatorServlet destroy");
//    }
}
