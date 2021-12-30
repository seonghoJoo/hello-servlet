package hello.servlet.basic.web.servletmvc;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Slf4j
@WebServlet(name="mvcMemberFormServlet" , urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {



    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String viewPath = "/WEB-INF/view/new-form.jsp";
        // 콘트롤러에서 view로 이동할때 사용
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
        // 다른 서블릿이나 JSP로 이동할수 있는 기능 서버 내부에서 다시 호출 발생
        // redirect와는 다름
        dispatcher.forward(req,resp);


    }
}
