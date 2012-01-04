package jp.ambrosoli.http.server.action;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.framework.mock.servlet.MockHttpServletResponse;
import org.seasar.framework.unit.Seasar2;

@RunWith(Seasar2.class)
public class StatusCodeActionTest {

    private StatusCodeAction action;

    private MockHttpServletResponse response;

    @Test
    public void testOk() {
        assertThat(action, is(notNullValue()));
        action.ok();
        assertThat(response.getStatus(), is(200));
    }

    @Test
    public void testNotFounc() {
        assertThat(action, is(notNullValue()));
        action.notFound();
        assertThat(response.getStatus(), is(404));
    }

    @Test
    public void testInternalServerError() {
        assertThat(action, is(notNullValue()));
        action.internalServerError();
        assertThat(response.getStatus(), is(500));
    }

}
