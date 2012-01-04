package jp.ambrosoli.http.server.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.seasar.struts.annotation.Execute;

public class CharsetAction {

    @Resource
    protected HttpServletRequest request;

    @Resource
    protected HttpServletResponse response;

    @Execute(validator = false)
    public String utf8() {
        String charset = this.request.getCharacterEncoding();
        if ("UTF-8".equals(charset)) {
            this.response.setStatus(HttpServletResponse.SC_OK);
        } else {
            this.response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        return null;
    }

    @Execute(validator = false)
    public String sjis() {
        String charset = this.request.getCharacterEncoding();
        if ("Shift_JIS".equals(charset)) {
            this.response.setStatus(HttpServletResponse.SC_OK);
        } else {
            this.response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        return null;
    }
}
