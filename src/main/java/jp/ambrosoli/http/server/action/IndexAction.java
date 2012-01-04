/*
 * Copyright 2004-2008 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package jp.ambrosoli.http.server.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.ResponseUtil;

public class IndexAction {

    @Resource
    protected HttpServletRequest request;

    @Resource
    protected HttpServletResponse response;

    @Resource
    protected Map<String, String> requestScope;

    public String to;

    @Execute(validator = false)
    public String index() {
        return "index.jsp";
    }

    @Execute(validator = false)
    public String helloWorld() {
        String name = this.request.getParameter("name");
        String queryString = this.requestScope.get("javax.servlet.forward.query_string");
        String[] query = StringUtils.split(queryString, "=");
        if (ArrayUtils.isNotEmpty(query)) {
            try {
                name = URLDecoder.decode(query[1], this.request.getCharacterEncoding());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        if (StringUtils.isEmpty(name)) {
            this.response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        ResponseUtil.write("Hello, " + name + "!", "UTF-8");
        return null;
    }

    @Execute(validator = false, urlPattern = "timeout/{to}")
    public String timeout() {
        try {
            Thread.sleep(Long.valueOf(this.to));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ResponseUtil.getResponse().setStatus(200);
        return null;
    }
}
