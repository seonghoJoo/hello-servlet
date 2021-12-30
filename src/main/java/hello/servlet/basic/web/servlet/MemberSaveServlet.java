package hello.servlet.basic.web.servlet;


import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@Slf4j
@WebServlet(name="memberSaveServlet", urlPatterns = "/servlet/members/save")
public class MemberSaveServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // axios에서 쏜 username / age를 받아와라 req = request => 요청 resp = response : 응답
        ServletInputStream inputStream = req.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        System.out.println("messageBody = " + messageBody);

        Member member = objectMapper.readValue(messageBody, Member.class);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");

        // DB에 값 넣기
        memberRepository.save(member);

        String result = objectMapper.writeValueAsString(member);
        //{"username":"joo", "age":20}
        resp.getWriter().println(result);

    }
}
