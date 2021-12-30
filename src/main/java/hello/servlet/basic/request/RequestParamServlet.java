package hello.servlet.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;


/*
*       1. 파라미터 전송기능
*       http:://localhost:8080/request-param?username=hello&age=20
*
* */

@WebServlet(name="requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회] - start");

        //http:://localhost:8080/request-param?username=hello&age=20&username=bye
        String username = req.getParameter("username");
        String ageStr = req.getParameter("age");
        int age = Integer.parseInt(ageStr);

        HelloData helloData = new HelloData();
        helloData.setAge(age);
        helloData.setUsername(username);

        String result = objectMapper.writeValueAsString(helloData);
        //{"username":"joo", "age":20}
        resp.getWriter().println(result);

        System.out.println("[전체 파라미터 조회] - end");
    }
}
