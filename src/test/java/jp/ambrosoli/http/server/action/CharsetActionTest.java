package jp.ambrosoli.http.server.action;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.runner.RunWith;
import org.seasar.framework.mock.servlet.MockHttpServletRequest;
import org.seasar.framework.mock.servlet.MockHttpServletResponse;
import org.seasar.framework.unit.Seasar2;

@RunWith(Seasar2.class)
public class CharsetActionTest {

    private CharsetAction action;

    private MockHttpServletRequest request;

    private MockHttpServletResponse response;

    public void testUtf8() throws UnsupportedEncodingException {
        this.request.setCharacterEncoding("UTF-8");
        this.action.utf8();
        assertThat(this.response.getStatus(), is(200));
    }

    public void testSjis() throws UnsupportedEncodingException {
        this.request.setCharacterEncoding("Shift_JIS");
        this.action.sjis();
        assertThat(this.response.getStatus(), is(200));
    }

}
