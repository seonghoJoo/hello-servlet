package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;


/*
*       1. 파라미터 전송기능
*       http:://localhost:8080/request-param?username=hello&age=20
*
* */

@WebServlet(name="requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회] - start");

        //http:://localhost:8080/request-param?username=hello&age=20&username=bye
        String[] usernames = req.getParameterValues("username");
        for(String name : usernames){
            System.out.println("username = " + name);
        }

        System.out.println("[전체 파라미터 조회] - end");
    }
}
