/*
    Licensed to the Apache Software Foundation (ASF) under one
    or more contributor license agreements.  See the NOTICE file
    distributed with this work for additional information
    regarding copyright ownership.  The ASF licenses this file
    to you under the Apache License, Version 2.0 (the
    "License"); you may not use this file except in compliance
    with the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing,
    software distributed under the License is distributed on an
    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    KIND, either express or implied.  See the License for the
    specific language governing permissions and limitations
    under the License.
 */
package org.apache.wiki.plugin;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.wiki.WikiContext;
import org.apache.wiki.api.exceptions.PluginException;
import org.apache.wiki.api.plugin.WikiPlugin;

/**
 * @author David VIttor
 * @date 20/01/2015
 * @since 2.10.2-svn10
 */
public class SampleAjaxPlugin extends HttpServlet implements WikiPlugin {
	private static final long serialVersionUID = 1L;

	@Override
    public String execute(WikiContext context, Map<String, String> params) throws PluginException {
    	String id = Integer.toString(this.hashCode());
        String baseUrl = context.getEngine().getBaseURL();
        String url = baseUrl+"ajax/SampleAjaxPlugin";
        String html= "<div onclick='makeRequest(\"GET\",\""+url+"\",\"result"+id+"\",\"Loading...\")' style='color: blue; cursor: pointer'>Press Me</div>\n"+
                        "<div id='result"+id+"'></div>";
        return html;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Thread.sleep(5000); // Wait 5 seconds
        } catch (Exception e) {}
        resp.getWriter().print("You called by get!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Thread.sleep(5000); // Wait 5 seconds
        } catch (Exception e) {}
        resp.getWriter().print("You called by post!");
    }
}