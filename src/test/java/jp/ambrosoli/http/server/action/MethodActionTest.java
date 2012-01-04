package jp.ambrosoli.http.server.action;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.framework.mock.servlet.MockHttpServletRequest;
import org.seasar.framework.mock.servlet.MockHttpServletResponse;
import org.seasar.framework.unit.Seasar2;

@RunWith(Seasar2.class)
public class MethodActionTest {

    private MethodAction action;

    private MockHttpServletRequest request;

    private MockHttpServletResponse response;

    @Test
    public void testGet() {
        request.setMethod("GET");
        action.get();
        assertThat(response.getStatus(), is(200));

        request.setMethod("POST");
        action.get();
        assertThat(response.getStatus(), is(405));

        request.setMethod("PUT");
        action.get();
        assertThat(response.getStatus(), is(405));

        request.setMethod("DELETE");
        action.get();
        assertThat(response.getStatus(), is(405));

        request.setMethod("HEAD");
        action.get();
        assertThat(response.getStatus(), is(405));

        request.setMethod("OPTIONS");
        action.get();
        assertThat(response.getStatus(), is(405));

        request.setMethod("TRACE");
        action.get();
        assertThat(response.getStatus(), is(405));

    }

    @Test
    public void testPost() {
        request.setMethod("GET");
        action.post();
        assertThat(response.getStatus(), is(405));

        request.setMethod("POST");
        action.post();
        assertThat(response.getStatus(), is(200));

        request.setMethod("PUT");
        action.post();
        assertThat(response.getStatus(), is(405));

        request.setMethod("DELETE");
        action.post();
        assertThat(response.getStatus(), is(405));

        request.setMethod("HEAD");
        action.post();
        assertThat(response.getStatus(), is(405));

        request.setMethod("OPTIONS");
        action.post();
        assertThat(response.getStatus(), is(405));

        request.setMethod("TRACE");
        action.post();
        assertThat(response.getStatus(), is(405));

    }

    @Test
    public void testPut() {
        request.setMethod("GET");
        action.put();
        assertThat(response.getStatus(), is(405));

        request.setMethod("POST");
        action.put();
        assertThat(response.getStatus(), is(405));

        request.setMethod("PUT");
        action.put();
        assertThat(response.getStatus(), is(200));

        request.setMethod("DELETE");
        action.put();
        assertThat(response.getStatus(), is(405));

        request.setMethod("HEAD");
        action.put();
        assertThat(response.getStatus(), is(405));

        request.setMethod("OPTIONS");
        action.put();
        assertThat(response.getStatus(), is(405));

        request.setMethod("TRACE");
        action.put();
        assertThat(response.getStatus(), is(405));

    }

    @Test
    public void testDelete() {
        request.setMethod("GET");
        action.delete();
        assertThat(response.getStatus(), is(405));

        request.setMethod("POST");
        action.delete();
        assertThat(response.getStatus(), is(405));

        request.setMethod("PUT");
        action.delete();
        assertThat(response.getStatus(), is(405));

        request.setMethod("DELETE");
        action.delete();
        assertThat(response.getStatus(), is(200));

        request.setMethod("HEAD");
        action.delete();
        assertThat(response.getStatus(), is(405));

        request.setMethod("OPTIONS");
        action.delete();
        assertThat(response.getStatus(), is(405));

        request.setMethod("TRACE");
        action.delete();
        assertThat(response.getStatus(), is(405));

    }

    @Test
    public void testHead() {
        request.setMethod("GET");
        action.head();
        assertThat(response.getStatus(), is(405));

        request.setMethod("POST");
        action.head();
        assertThat(response.getStatus(), is(405));

        request.setMethod("PUT");
        action.head();
        assertThat(response.getStatus(), is(405));

        request.setMethod("DELETE");
        action.head();
        assertThat(response.getStatus(), is(405));

        request.setMethod("HEAD");
        action.head();
        assertThat(response.getStatus(), is(200));

        request.setMethod("OPTIONS");
        action.head();
        assertThat(response.getStatus(), is(405));

        request.setMethod("TRACE");
        action.head();
        assertThat(response.getStatus(), is(405));

    }

    @Test
    public void testOptions() {
        request.setMethod("GET");
        action.options();
        assertThat(response.getStatus(), is(405));

        request.setMethod("POST");
        action.options();
        assertThat(response.getStatus(), is(405));

        request.setMethod("PUT");
        action.options();
        assertThat(response.getStatus(), is(405));

        request.setMethod("DELETE");
        action.options();
        assertThat(response.getStatus(), is(405));

        request.setMethod("HEAD");
        action.options();
        assertThat(response.getStatus(), is(405));

        request.setMethod("OPTIONS");
        action.options();
        assertThat(response.getStatus(), is(200));

        request.setMethod("TRACE");
        action.options();
        assertThat(response.getStatus(), is(405));
    }

    @Test
    public void testTrace() {
        request.setMethod("GET");
        action.trace();
        assertThat(response.getStatus(), is(405));

        request.setMethod("POST");
        action.trace();
        assertThat(response.getStatus(), is(405));

        request.setMethod("PUT");
        action.trace();
        assertThat(response.getStatus(), is(405));

        request.setMethod("DELETE");
        action.trace();
        assertThat(response.getStatus(), is(405));

        request.setMethod("HEAD");
        action.trace();
        assertThat(response.getStatus(), is(405));

        request.setMethod("OPTIONS");
        action.trace();
        assertThat(response.getStatus(), is(405));

        request.setMethod("TRACE");
        action.trace();
        assertThat(response.getStatus(), is(200));
    }
}
