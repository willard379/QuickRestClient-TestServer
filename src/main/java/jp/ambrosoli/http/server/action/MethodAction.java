package jp.ambrosoli.http.server.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.seasar.struts.annotation.Execute;

public class MethodAction {

    @Resource
    protected HttpServletRequest request;

    @Resource
    protected HttpServletResponse response;

    @Execute(validator = false)
    public String get() {
        if (isMethod("GET")) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }
        return null;
    }

    @Execute(validator = false)
    public String post() {
        if (isMethod("POST")) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }
        return null;
    }

    @Execute(validator = false)
    public String put() {
        if (isMethod("PUT")) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }
        return null;
    }

    @Execute(validator = false)
    public String delete() {
        if (isMethod("DELETE")) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }
        return null;
    }

    @Execute(validator = false)
    public String head() {
        if (isMethod("HEAD")) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }
        return null;
    }

    @Execute(validator = false)
    public String options() {
        if (isMethod("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }
        return null;
    }

    @Execute(validator = false)
    public String trace() {
        if (isMethod("TRACE")) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }
        return null;
    }

    protected boolean isMethod(String expected) {
        String method = request.getMethod();
        if (StringUtils.isEmpty(method)) {
            return false;
        }
        return method.equalsIgnoreCase(expected);
    }
}
