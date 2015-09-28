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

import bigbluej.config.Config;
import bigbluej.exception.ClientException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXB;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
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

    public MeetingResponse createMeeting(CreateCommand createCommand) {
        try {
            Validate.notNull(createCommand);
            String query = toQuery(ReflectionUtils.getFieldsAndValuesInSortedMap(createCommand));
            String checksum = Checksum.create("create", query, sharedSecret);
            String completeUrl = url + "/create?" + query + "&checksum=" + checksum;
            Crawler crawler = crawlerFactory.createCrawler();
            return fromXml(MeetingResponse.class, crawler.post(completeUrl));
        } catch (Exception e) {
            throw new ClientException(e);
        }
    }

    private <T> T fromXml(Class<T> clazz, String input) {
        System.out.println("xml> " + input);
        return JAXB.unmarshal(new StringReader(input), clazz);
    }

    static String toQuery(SortedMap<String, Object> sortedParameterMap) throws UnsupportedEncodingException {
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

    public MeetingResponse createMeeting(CreateCommand createCommand, ModulesCommand modulesCommand) {
        try {
            Validate.notNull(createCommand);
            String query = toQuery(ReflectionUtils.getFieldsAndValuesInSortedMap(createCommand));
            String checksum = Checksum.create("create", query, sharedSecret);
            String completeUrl = url + "/create?" + query + "&checksum=" + checksum;
            System.out.println("url> " + completeUrl);
            String body = toXml(modulesCommand);
            System.out.println("body> " + body);
            Crawler crawler = crawlerFactory.createCrawler();
            return fromXml(MeetingResponse.class, crawler.post(completeUrl, body));
        } catch (Exception e) {
            throw new ClientException(e);
        }
    }

    private String toXml(ModulesCommand modulesCommand) {
        Modules modules = new Modules();
        modules.setModules(new ArrayList<Module>());
        for (ModuleCommand moduleCommand : modulesCommand.getModules()) {
            Module module = new Module();
            module.setName(moduleCommand.getName());
            module.setDocuments(new ArrayList<Document>());
            for (DocumentCommand documentCommand : moduleCommand.getDocuments()) {
                Document document = new Document();
                document.setUrl(documentCommand.getUrl());
                if (StringUtils.isNotBlank(documentCommand.getName())) {
                    document.setName(documentCommand.getName());
                    document.setValue(Base64.encodeBase64String(documentCommand.getContent()));
                    System.out.println("base64 value> " + document.getValue());
                }
                module.getDocuments().add(document);
            }
            modules.getModules().add(module);
        }
        StringWriter stringWriter = new StringWriter();
        JAXB.marshal(modules, stringWriter);
        return stringWriter.getBuffer().toString();
    }

    public void joinMeeting(ServletResponse servletResponse, JoinCommand joinCommand) {
        try {
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
        } catch (Exception e) {
            throw new ClientException(e);
        }
    }

    public IsMeetingRunningResponse isMeetingRunning(IsMeetingRunningCommand isMeetingRunningCommand) {
        try {
            Validate.notNull(isMeetingRunningCommand, "isMeetingRunningCommand");
            String query = toQuery(ReflectionUtils.getFieldsAndValuesInSortedMap(isMeetingRunningCommand));
            String checksum = Checksum.create("isMeetingRunning", query, sharedSecret);
            String completeUrl = url + "/isMeetingRunning?" + query + "&checksum=" + checksum;
            Crawler crawler = crawlerFactory.createCrawler();
            return fromXml(IsMeetingRunningResponse.class, crawler.post(completeUrl));
        } catch (Exception e) {
            throw new ClientException(e);
        }
    }

    public EndResponse end(EndCommand endCommand) {
        try {
            Validate.notNull(endCommand);
            String query = toQuery(ReflectionUtils.getFieldsAndValuesInSortedMap(endCommand));
            String checksum = Checksum.create("end", query, sharedSecret);
            return fromXml(EndResponse.class, crawlerFactory.createCrawler().post(url + "/end?" + query + "&checksum=" + checksum));
        } catch (Exception e) {
            throw new ClientException(e);
        }
    }

    public GetMeetingInfoResponse getMeetingInfo(GetMeetingInfoCommand getMeetingInfoCommand) {
        try {
            Validate.notNull(getMeetingInfoCommand);
            String query = toQuery(ReflectionUtils.getFieldsAndValuesInSortedMap(getMeetingInfoCommand));
            String checksum = Checksum.create("getMeetingInfo", query, sharedSecret);
            return fromXml(GetMeetingInfoResponse.class, crawlerFactory.createCrawler().post(url + "/getMeetingInfo?" + query + "&checksum=" + checksum));
        } catch (Exception e) {
            throw new ClientException(e);
        }
    }

    public GetMeetingsResponse getMeetings() {
        try {
            String checksum = Checksum.create("getMeetings", "", sharedSecret);
            return fromXml(GetMeetingsResponse.class, crawlerFactory.createCrawler().post(url + "/getMeetings?checksum=" + checksum));
        } catch (Exception e) {
            throw new ClientException(e);
        }
    }

    public GetRecordingsResponse getRecordings(GetRecordingsCommand getRecordingsCommand) {
        try {
            Validate.notNull(getRecordingsCommand);
            String query = toQuery(ReflectionUtils.getFieldsAndValuesInSortedMap(getRecordingsCommand));
            String checksum = Checksum.create("getRecordings", query, sharedSecret);
            return fromXml(GetRecordingsResponse.class, crawlerFactory.createCrawler().get(url + "/getRecordings?" + query + "&checksum=" + checksum));
        } catch (Exception e) {
            throw new ClientException(e);
        }
    }

    public PublishRecordingsResponse publishRecordings(PublishRecordingsCommand publishRecordingsCommand) {
        try {
            Validate.notNull(publishRecordingsCommand);
            String query = toQuery(ReflectionUtils.getFieldsAndValuesInSortedMap(publishRecordingsCommand));
            String checksum = Checksum.create("publishRecordings", query, sharedSecret);
            return fromXml(PublishRecordingsResponse.class, crawlerFactory.createCrawler().post(url + "/publishRecordings?" + query + "&checksum=" + checksum));
        } catch (Exception e) {
            throw new ClientException(e);
        }
    }

    public DeleteRecordingsResponse deleteRecordings(DeleteRecordingsCommand deleteRecordingsCommand) {
        try {
            Validate.notNull(deleteRecordingsCommand);
            String query = toQuery(ReflectionUtils.getFieldsAndValuesInSortedMap(deleteRecordingsCommand));
            String checksum = Checksum.create("deleteRecordings", query, sharedSecret);
            return fromXml(DeleteRecordingsResponse.class, crawlerFactory.createCrawler().post(url + "/deleteRecordings?" + query + "&checksum=" + checksum));
        } catch (Exception e) {
            throw new ClientException(e);
        }
    }

    public Config getDefaultConfigXML() {
        try {
            String checksum = Checksum.create("getDefaultConfigXML", "", sharedSecret);
            return fromXml(Config.class, crawlerFactory.createCrawler().post(url + "/getDefaultConfigXML?checksum=" + checksum));
        } catch (Exception e) {
            throw new ClientException(e);
        }
    }

    public SetConfigXMLResponse setConfigXML(SetConfigXMLCommand setConfigXMLCommand) {
        try {
            Validate.notNull(setConfigXMLCommand);
            StringBuilder body = new StringBuilder();
            body.append("configXML=");
            body.append(toXml(setConfigXMLCommand.getConfig()));
            body.append("&");
            body.append("meetingID=");
            body.append(setConfigXMLCommand.getMeetingID());
            System.out.println("body> " + body);

            String checksum = Checksum.create("setConfigXML", body.toString(), sharedSecret);
            String completeUrl = url + "/setConfigXML?checksum=" + checksum;
            System.out.println("url> " + completeUrl);

            Crawler crawler = crawlerFactory.createCrawler();
            return fromXml(SetConfigXMLResponse.class, crawler.post(completeUrl, body.toString()));
        } catch (Exception e) {
            throw new ClientException(e);
        }
    }

    private String toXml(Config config) {
        StringWriter stringWriter = new StringWriter();
        JAXB.marshal(config, stringWriter);
        return stringWriter.getBuffer().toString();
    }

    public String getJoinMeetingUrl(JoinCommand joinCommand) {
        try {
            Validate.notNull(joinCommand);
            String query = toQuery(ReflectionUtils.getFieldsAndValuesInSortedMap(joinCommand));
            String checksum = Checksum.create("join", query, sharedSecret);
            return url + "/join?" + query + "&checksum=" + checksum;
        } catch (Exception e) {
            throw new ClientException(e);
        }
    }

}
