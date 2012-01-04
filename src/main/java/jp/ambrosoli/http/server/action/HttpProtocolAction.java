package jp.ambrosoli.http.server.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.seasar.struts.annotation.Execute;

public class HttpProtocolAction {

    @Resource
    protected HttpServletRequest request;

    @Resource
    protected HttpServletResponse response;

    @Execute(validator = false)
    public String version0_9() {
        if (isVersion("HTTP/0.9")) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_HTTP_VERSION_NOT_SUPPORTED);
        }
        return null;
    }

    @Execute(validator = false)
    public String version1_0() {
        if (isVersion("HTTP/1.0")) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_HTTP_VERSION_NOT_SUPPORTED);
        }
        return null;
    }

    @Execute(validator = false)
    public String version1_1() {
        if (isVersion("HTTP/1.1")) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_HTTP_VERSION_NOT_SUPPORTED);
        }
        return null;
    }

    protected boolean isVersion(String expected) {
        String protocol = request.getProtocol();
        if (StringUtils.isEmpty(protocol)) {
            return false;
        }
        return protocol.equals(expected);
    }

}
