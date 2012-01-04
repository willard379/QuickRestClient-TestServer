package jp.ambrosoli.http.server.action;

import javax.servlet.http.HttpServletResponse;

import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.ResponseUtil;

public class StatusCodeAction {

    @Execute(validator = false)
    public String ok() {
        ResponseUtil.getResponse().setStatus(HttpServletResponse.SC_OK);
        return null;
    }

    @Execute(validator = false)
    public String notFound() {
        ResponseUtil.getResponse().setStatus(HttpServletResponse.SC_NOT_FOUND);
        return null;
    }

    @Execute(validator = false)
    public String internalServerError() {
        ResponseUtil.getResponse().setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return null;
    }

}
