package jp.ambrosoli.http.server.action;

import java.util.Enumeration;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.ResponseUtil;

@SuppressWarnings("unchecked")
public class HeaderAction {

    @Resource
    protected HttpServletRequest request;

    @Resource
    protected HttpServletResponse response;

    @Execute(validator = false)
    public String userAgent() {
        String userAgent = this.request.getHeader("User-Agent");
        if (StringUtils.isEmpty(userAgent)) {
            this.response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return null;
        }
        ResponseUtil.write(userAgent);
        return null;
    }

    @Execute(validator = false)
    public String sameAsParams() {
        Enumeration<String> paramNames = this.request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            if ("SAStruts.method".equals(paramName)) {
                continue;
            }
            String paramValue = this.request.getParameter(paramName);
            String headerValue = this.request.getHeader(paramName);
            if (headerValue == null || !headerValue.equalsIgnoreCase(paramValue)) {
                this.response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return null;
            }
        }
        this.response.setStatus(HttpServletResponse.SC_OK);
        return null;
    }

    @Execute(validator = false)
    public String accept() {

        StringBuilder response = new StringBuilder();

        Enumeration<String> headers = this.request.getHeaders("Accept");
        while (headers.hasMoreElements()) {
            String headerValue = headers.nextElement();
            response.append(headerValue).append(",");
        }

        if (response.length() > 0) {
            response.deleteCharAt(response.length() - 1);
        }

        ResponseUtil.write(response.toString());
        return null;
    }

    @Execute(validator = false)
    public String setHeaders() {
        Enumeration<String> paramNames = this.request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            if ("SAStruts.method".equals(paramName)) {
                continue;
            }
            String paramValue = this.request.getParameter(paramName);
            this.response.addHeader(paramName, paramValue);
        }
        return null;
    }

}
