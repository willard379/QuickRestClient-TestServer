package jp.ambrosoli.http.server.action;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import jp.ambrosoli.http.server.test.util.TestUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.framework.mock.servlet.MockHttpServletRequest;
import org.seasar.framework.mock.servlet.MockHttpServletResponse;
import org.seasar.framework.unit.Seasar2;

@RunWith(Seasar2.class)
public class IndexActionTest {

    private IndexAction action;

    private MockHttpServletRequest request;

    private MockHttpServletResponse response;

    @Test
    public void testHelloWorld() {
        this.request.setParameter("name", "willard379");
        this.action.helloWorld();
        assertThat(TestUtil.getAsString(this.response), is(equalTo("Hello, willard379!")));
    }

    @Test
    public void testIndex_timeout() {
        this.action.to = "700";
        long start = System.currentTimeMillis();
        this.action.timeout();
        long end = System.currentTimeMillis();
        long diff = (end - start);
        assertThat(diff >= 700, is(true));
        assertThat(this.response.getStatus(), is(200));
    }
}
