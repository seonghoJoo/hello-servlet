package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name="responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");
        ArrayList<HelloData> list = new ArrayList<>();

        for(int i=0;i<20;i++){
            HelloData helloData = new HelloData();
            helloData.setAge(20);
            char c = (char)('a'+ i);
            helloData.setUsername(c+"주성호");
            list.add(helloData);
        }
        for(HelloData c : list){
            System.out.println(c.getUsername());
        }

        String result = objectMapper.writeValueAsString(list);
        //{"username":"joo", "age":20}
        resp.getWriter().println(result);
    }
}
