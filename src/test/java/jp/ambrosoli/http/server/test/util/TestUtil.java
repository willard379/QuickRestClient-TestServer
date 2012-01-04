package jp.ambrosoli.http.server.test.util;

import java.io.UnsupportedEncodingException;

import org.junit.Ignore;
import org.seasar.framework.mock.servlet.MockHttpServletResponse;

@Ignore
public class TestUtil {

    public static String getAsString(MockHttpServletResponse response) {
        byte[] data = response.getResponseBytes();
        try {
            return new String(data, System.getProperty("file.encoding"));
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
