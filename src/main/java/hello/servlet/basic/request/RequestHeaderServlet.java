package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        System.out.println("쿠키 시작");
        // 쿠기정보
        if(req.getCookies() !=null){
            int index=1;
            for(Cookie cookie : req.getCookies()){
                System.out.println(index++ +")"+cookie.getName() + " : " + cookie.getValue());
            }
        }else{
            System.out.println("no cookies");
        }
    }
}
