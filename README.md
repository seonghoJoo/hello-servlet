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

1. 저장 : ```request.setAttribute(name,value)```
2. 조회 : ```requset.getAttribute(name)```

### 세션 관리 기능
```requset.getSession(create:true) ```

## 중요
```HttpServletRequest``` , ```HttpServletResponse``` HTTP 스펙이 제공하는 요청을 편리하게 사용하려는 목적이 더 큼, 응답메시지 자체를 이해해야함

### GET 쿼리 파라미터
메세지 바디 없이 URL에 쿼리파라미터에 데이터를 포함해서 전달
/url?username=kim&age=20
### POST - HTML Form
content-type : application/x-www-form-urlencoded
메세지 바디에 쿼리 파라미터 형식으로 전달 
username=hello&age=2
### HTTP message body에 데이터를 직접 담아서 
***
## HttpServletResponse 역할
### HTTP 응답메세지 생성
1. HTTP 응답코드 지정
2. 헤더 생성
3. 바디 생성
4. 편의기능 제공 Content-type, 쿠키, Redirect


### Redirect vs Forward
Redirect 응답이 실제로 클라이언트로 나감 요청 2번 응답 2번 
대표번호 전화 -> 안내원 -> ```여기로 전화하세요~``` -> 전화 끊고 -> 목적지와 통화
Forward 요청 1번 응답 1번
대표번호 전화 -> 안내원 -> ```연결해드리겠습니다.``` -> 목적지와 통화

### DispatcherServlet.doDispatch()
1. 핸들러 조회
2. 핸들러 어댑터 조회 - 핸들러를 처리할 수 있는 어댑터
3. 핸들러 어댑터 실행 
4. 핸들러 어댑터를 통해 핸들러 실행
5. ModelAndView 반환
6. viewResolver 호출
7. View 반환
8. View 
