# hello-servlet

## HttpRequest 역할

HTTP 요청 메세지를 개발자가 직접 파싱해서 사용해도 되지만 매우 불편함. 
서블릿은 개발자가 HTTP 요청 메시지를 편리하게 사용할 수 있도록 개발자 대신에 HTTP 요청메세지를 파싱함. 그결과를 HTTPServlet 객체에 담아서 제공한다.

### HTTP 요청메시지
***
```
POST  /save HTTP/1.1
Host : localhost:8080
content-Type: application/x-www-form-urlencoded
username=kim&age=20
```
***

### 임시 저장소 기능
해당 HTTP 요청이 시작부터 끝날때 까지 유지되는 임시저장소 기능

1. 저장 : request.setAttribute(name,value)
2. 조회 : requset.getAttribute(name)
