package bigbluej;

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.commons.lang.Validate;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;

/**
 * @author Michael Lieshoff
 */
public class Client {

    private CrawlerFactory crawlerFactory = new CrawlerFactory();

    private String url;
    private String sharedSecret;

    Client(String url, String sharedSecret) {
        Validate.notEmpty(url);
        Validate.notEmpty(sharedSecret);
        this.url = url;
        this.sharedSecret = sharedSecret;
    }

    public String createMeeting(CreateCommand createCommand) throws Exception {
        Validate.notNull(createCommand);
        String query = toQuery(ReflectionUtils.getFieldsAndValuesInSortedMap(createCommand));
        String checksum = Checksum.create("create", query, sharedSecret);
        return crawlerFactory.createCrawler().post(url + "/create?" + query + "&checksum=" + checksum);
    }

    public static String toQuery(SortedMap<String, Object> sortedParameterMap) throws UnsupportedEncodingException {
        Validate.notNull(sortedParameterMap);
        StringBuilder s = new StringBuilder();
        for (Iterator<Map.Entry<String, Object>> iterator = sortedParameterMap.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<String, Object> entry = iterator.next();
            s.append(String.format("%s=%s", entry.getKey(), URLEncoder.encode(String.valueOf(entry.getValue()), "UTF-8")));
            if (iterator.hasNext()) {
                s.append("&");
            }
        }
        return s.toString();
    }

    public void joinMeeting(ServletResponse servletResponse, JoinCommand joinCommand) throws Exception {
        Validate.notNull(joinCommand);
        String query = toQuery(ReflectionUtils.getFieldsAndValuesInSortedMap(joinCommand));
        String checksum = Checksum.create("join", query, sharedSecret);
        if (servletResponse instanceof HttpServletResponse) {
            String redirectUrl = url + "/join?" + query + "&checksum=" + checksum;
            System.out.println("redirect> " + redirectUrl);
            HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
            httpServletResponse.sendRedirect(redirectUrl);
            httpServletResponse.setStatus(200);
        }
    }

    public String getMeetingInfo(GetMeetingInfoCommand getMeetingInfoCommand) throws Exception {
        Validate.notNull(getMeetingInfoCommand);
        String query = toQuery(ReflectionUtils.getFieldsAndValuesInSortedMap(getMeetingInfoCommand));
        String checksum = Checksum.create("getMeetingInfo", query, sharedSecret);
        return crawlerFactory.createCrawler().post(url + "/getMeetingInfo?" + query + "&checksum=" + checksum);
    }

    public String getMeetings() throws Exception {
        String checksum = Checksum.create("getMeetings", "", sharedSecret);
        return crawlerFactory.createCrawler().get(url + "/getMeetings?checksum=" + checksum);
    }

}
