package server.servlets;

import server.PageGenerator;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MirrorServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        Map<String, Object> model = new HashMap<>();
        model.put("message", request.getParameter("key"));

        response.getWriter().println(PageGenerator.getInstance().generate("template.html", model));

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) {

    }
}
