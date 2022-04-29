package servlet.courses;

import javax.servlet.ServletContext;
import javax.servlet.http.*;

public class Context implements AutoCloseable {

    private static ThreadLocal<Context> instance = new ThreadLocal<>();

    private HttpServletRequest request;
    private HttpServletResponse response;

    private Context(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public static Context create(HttpServletRequest request, HttpServletResponse response) {
        Context context = new Context(request, response);
        instance.set(context);
        return context;
    }

    public static Context getCurrentInstance() {
        return instance.get();
    }

    @Override
    public void close() {
        instance.remove();
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public HttpSession getSession() {
        return request.getSession();
    }

    public ServletContext getServletContext() {
        return request.getServletContext();
    }

    // ... (add if necessary more methods here which return/delegate the request/response).
}