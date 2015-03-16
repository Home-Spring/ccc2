package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
* Created by alexandr on 13.03.15.
*/
// аннотация регистрирует сервлет в контексте приложения, это тоже самое что мы делали в web.xml
// Аннотация принимает как параметр строку, именно эта строка соответствует тегу url-pattern, тоесть это URL по которому будет доступен сервлет
@WebServlet("/")
public class MyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

//        // <URL> http:localhost:8080/hello
//        PrintWriter html_out = response.getWriter();
//        html_out.println("Hello");


        // <URL> http:localhost:8080/index || mypage.jsp
        // чтобы передать какие либо дынные на JSP нам нужно в сервлете в request добавить атрибут
        request.setAttribute("text", "Index");
        // с запроса получаем Request Dispatcher (Диспетчер Запросов) и указываем ему jsp страницу которая будет отображаться при обращении к данному методуGET.
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        // Метод forward перенаправляет наш запрос на jsp-страницу.
        dispatcher.forward(request, response);
    }
}
