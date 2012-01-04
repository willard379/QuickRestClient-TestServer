package jp.ambrosoli.http.server.action;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.framework.mock.servlet.MockHttpServletRequest;
import org.seasar.framework.mock.servlet.MockHttpServletResponse;
import org.seasar.framework.unit.Seasar2;

@RunWith(Seasar2.class)
public class HttpProtocolActionTest {

    private HttpProtocolAction action;

    private MockHttpServletRequest request;

    private MockHttpServletResponse response;

    @Test
    public void testVersion0_9() {
        request.setProtocol("HTTP/0.9");
        action.version0_9();
        assertThat(response.getStatus(), is(200));

        request.setProtocol("HTTP/1.0");
        action.version0_9();
        assertThat(response.getStatus(), is(505));

        request.setProtocol("HTTP/1.1");
        action.version0_9();
        assertThat(response.getStatus(), is(505));
    }

    @Test
    public void testVersion1_0() {
        request.setProtocol("HTTP/0.9");
        action.version1_0();
        assertThat(response.getStatus(), is(505));

        request.setProtocol("HTTP/1.0");
        action.version1_0();
        assertThat(response.getStatus(), is(200));

        request.setProtocol("HTTP/1.1");
        action.version1_0();
        assertThat(response.getStatus(), is(505));
    }

    @Test
    public void testVersion1_1() {
        request.setProtocol("HTTP/0.9");
        action.version1_1();
        assertThat(response.getStatus(), is(505));

        request.setProtocol("HTTP/1.0");
        action.version1_1();
        assertThat(response.getStatus(), is(505));

        request.setProtocol("HTTP/1.1");
        action.version1_1();
        assertThat(response.getStatus(), is(200));
    }

}
