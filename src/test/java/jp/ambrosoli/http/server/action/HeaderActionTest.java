package jp.ambrosoli.http.server.action;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;

import java.util.Arrays;
import java.util.List;

import jp.ambrosoli.http.server.test.util.TestUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.framework.mock.servlet.MockHttpServletRequest;
import org.seasar.framework.mock.servlet.MockHttpServletResponse;
import org.seasar.framework.unit.Seasar2;

@RunWith(Seasar2.class)
public class HeaderActionTest {

    private HeaderAction action;

    private MockHttpServletRequest request;

    private MockHttpServletResponse response;

    @Test
    public void testUserAgent() {
        this.request.addHeader("User-Agent", "hoge/1.0");
        this.action.userAgent();
        assertThat(TestUtil.getAsString(this.response), is(equalTo("hoge/1.0")));
    }

    @Test
    public void testSameAsParams() {
        // リクエストヘッダの設定
        this.request.addHeader("Header-A", "Value-A");
        this.request.addHeader("Header-B", "Value-B");
        this.request.addHeader("Header-C", "Value-C");
        this.request.addHeader("Header-D", "Value-D");
        this.request.addHeader("Header-E", "Value-E");
        this.request.addHeader("Header-F", "Value-F");

        // リクエストパラメータの設定
        this.request.setParameter("Header-A", "Value-A");
        this.request.setParameter("Header-B", "Value-B");
        this.request.setParameter("Header-D", "Value-D");
        this.request.setParameter("Header-E", "Value-E");

        this.action.sameAsParams();

        // リクエストパラメータの内容がすべてリクエストヘッダにもあればSC_OK
        assertThat(this.response.getStatus(), is(200));
    }

    @Test
    public void testSameAsParams_Failure() {
        // リクエストヘッダの設定
        this.request.addHeader("Header-A", "Value-A");
        this.request.addHeader("Header-B", "Value-B");
        this.request.addHeader("Header-C", "Value-C");
        this.request.addHeader("Header-D", "Value-D");
        this.request.addHeader("Header-E", "Value-E");
        this.request.addHeader("Header-F", "Value-F");

        // リクエストパラメータの設定
        this.request.setParameter("Header-A", "Value-A");
        this.request.setParameter("Header-B", "Value-B");
        this.request.setParameter("Header-C", "Value-C");
        this.request.setParameter("Header-G", "Value-G");

        this.action.sameAsParams();

        // リクエストパラメータの内容がすべてリクエストヘッダにもあればSC_BAD_REQUEST
        assertThat(this.response.getStatus(), is(400));
    }

    @Test
    public void testSetHeaders() {
        // リクエストヘッダの設定
        this.request.setParameter("Header-A", "Value-A");
        this.request.setParameter("Header-B", "Value-B");
        this.request.setParameter("Header-C", "Value-C");
        this.request.setParameter("Header-D", "Value-D");
        this.request.setParameter("Header-E", "Value-E");
        this.request.setParameter("Header-F", "Value-F");

        this.action.setHeaders();

        // リクエストパラメータの内容がすべてレスポンスヘッダに設定されること。
        assertThat(this.response.getHeader("Header-A"), is(equalTo("Value-A")));
        assertThat(this.response.getHeader("Header-B"), is(equalTo("Value-B")));
        assertThat(this.response.getHeader("Header-C"), is(equalTo("Value-C")));
        assertThat(this.response.getHeader("Header-D"), is(equalTo("Value-D")));
        assertThat(this.response.getHeader("Header-E"), is(equalTo("Value-E")));
        assertThat(this.response.getHeader("Header-F"), is(equalTo("Value-F")));

    }

    @Test
    public void testAccept() throws Exception {

        // リクエストヘッダの設定
        this.request.addHeader("Accept", "text/html");
        this.request.addHeader("Accept", "application/xhtml+xml");
        this.request.addHeader("Accept", "application/json");
        this.request.addHeader("Accept", "application/xml");
        this.request.addHeader("Accept", "text/plain");

        this.action.accept();

        // Acceptヘッダの値がレスポンスボディに設定されること
        String responseBody = TestUtil.getAsString(this.response);
        List<String> accepts = Arrays.asList(responseBody.split(","));

        assertThat(
                accepts,
                hasItems("text/html", "application/xhtml+xml", "application/json",
                        "application/xml", "text/plain"));
    }

}
