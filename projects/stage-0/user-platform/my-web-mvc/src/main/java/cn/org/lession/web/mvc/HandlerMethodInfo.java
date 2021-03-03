package cn.org.lession.web.mvc;
import java.lang.reflect.Method;
import java.util.Set;

public class HandlerMethodInfo {

    private final String requestPath;

    private final Method handlerMethod;

    private final Set<String> supportHttpMethods;

    public HandlerMethodInfo(String requestPath, Method handlerMethod, Set<String> supportHttpMethods) {
        this.requestPath = requestPath;
        this.handlerMethod = handlerMethod;
        this.supportHttpMethods = supportHttpMethods;
    }

    public String getRequestPath() {
        return requestPath;
    }

    public Method getHandlerMethod() {
        return handlerMethod;
    }

    public Set<String> getSupportHttpMethods() {
        return supportHttpMethods;
    }
}
