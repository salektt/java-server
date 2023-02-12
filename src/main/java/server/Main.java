package server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import server.servlets.MirrorServlet;

public class Main {
    public static void main(String[] args) {
        MirrorServlet servlet = new MirrorServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(servlet), "/mirror");

        Server server = new Server(8080);
        server.setHandler(context);

        try {
            server.start();
            server.join();
        } catch (Exception e) {
            System.out.println("Cannot start or stop server");
        }
    }
}