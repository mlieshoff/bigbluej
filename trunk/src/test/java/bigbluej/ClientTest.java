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
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.ServletResponse;
import java.util.SortedMap;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * @author Michael Lieshoff
 */
public class ClientTest {

    private static final String CREATE_MEETING_XML =
            "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
            "<response>" +
            "    <returncode>SUCCESS</returncode>" +
            "    <meetingID>4711</meetingID>" +
            "    <attendeePW>123</attendeePW>" +
            "    <moderatorPW>mp</moderatorPW>" +
            "    <createTime>1421447393750</createTime>" +
            "    <createDate>Fri Jan 16 17:29:53 EST 2015</createDate>" +
            "    <hasUserJoined>false</hasUserJoined>" +
            "    <duration>0</duration>" +
            "    <hasBeenForciblyEnded>false</hasBeenForciblyEnded>" +
            "    <messageKey/>" +
            "    <message/>" +
            "</response>";

    private static final String GET_MEETING_INFO_XML =
            "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
            "<response>" +
            "     <returncode>SUCCESS</returncode>" +
            "     <meetingName>Test</meetingName>" +
            "     <meetingID>test01</meetingID>" +
            "     <createTime>1315254777880</createTime>" +
            "     <voiceBridge>70775</voiceBridge>" +
            "     <attendeePW>ap</attendeePW>" +
            "     <moderatorPW>mp</moderatorPW>" +
            "     <running>true</running>" +
            "     <recording>false</recording>" +
            "     <hasBeenForciblyEnded>false</hasBeenForciblyEnded>" +
            "     <startTime>1315254785069</startTime>" +
            "     <endTime>0</endTime>" +
            "     <participantCount>1</participantCount>" +
            "     <maxUsers>20</maxUsers>" +
            "     <moderatorCount>1</moderatorCount>" +
            "     <attendees>" +
            "         <attendee>" +
            "             <userID>1</userID>" +
            "             <fullName>John Doe</fullName>" +
            "             <role>MODERATOR</role>" +
            "         </attendee>" +
            "     </attendees>" +
            "     <metadata/>" +
            "     <messageKey/>" +
            "     <message/>" +
            "</response>";

    private static final String GET_MEETINGS_XML =
            "<response>" +
            "    <returncode>SUCCESS</returncode>" +
            "    <meetings>" +
            "        <meeting>" +
            "            <meetingID>66f8c04072edbf0b23aeb2e1e4db92d1-2-1</meetingID>" +
            "            <meetingName>Visioconférence avec Agnila</meetingName>" +
            "            <createTime>1421537049295</createTime>" +
            "            <createDate>Sat Jan 17 18:24:09 EST 2015</createDate>" +
            "            <attendeePW>a88c97163ab9d31e536e557c817fc3ef</attendeePW>" +
            "            <moderatorPW>310b2f5877c6d1d83d36de6a7c8f0ba4</moderatorPW>" +
            "            <hasBeenForciblyEnded>false</hasBeenForciblyEnded>" +
            "            <running>true</running>" +
            "            <duration>240</duration>" +
            "            <hasUserJoined>true</hasUserJoined>" +
            "        </meeting>" +
            "        <meeting>" +
            "            <meetingID>myMeeting1421540508138</meetingID>" +
            "            <meetingName>myMeeting</meetingName>" +
            "            <createTime>1421540509193</createTime>" +
            "            <createDate>Sat Jan 17 19:21:49 EST 2015</createDate>" +
            "            <attendeePW>passpass</attendeePW>" +
            "            <moderatorPW>superpass</moderatorPW>" +
            "            <hasBeenForciblyEnded>false</hasBeenForciblyEnded>" +
            "            <running>false</running>" +
            "            <duration>0</duration>" +
            "            <hasUserJoined>false</hasUserJoined>" +
            "        </meeting>" +
            "    </meetings>" +
            "</response>";

    private static final String IS_MEETING_RUNNING_XML =
            "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
            "<response>" +
            "   <returncode>SUCCESS</returncode>" +
            "   <running>true</running>" +
            "</response>";

    private static final String GET_RECORDINGS_XML =
            "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
            "<response>" +
            "   <returncode>SUCCESS</returncode>" +
            "   <recordings>" +
            "      <recording>" +
            "         <recordID>183f0bf3a0982a127bdb8161-1308597520</recordID>" +
            "         <meetingID>CS101</meetingID>" +
            "         <name><![CDATA[On-line session for CS 101]]></name>" +
            "         <published>false</published>" +
            "         <startTime>34545465656</startTime>" +
            "         <endTime>34575565465</endTime>" +
            "         <metadata>" +
            "            <title><![CDATA[Test Recording]]></title>" +
            "            <subject><![CDATA[English 232 session]]></subject>" +
            "            <description><![CDATA[First Class]]></description>" +
            "            <creator><![CDATA[Fred Dixon]]></creator>" +
            "            <contributor><![CDATA[Richard Alam]]></contributor>" +
            "            <language><![CDATA[en_US]]></language>" +
            "         </metadata>" +
            "         <playback>" +
            "            <format>" +
            "               <type>simple</type>" +
            "               <url>http://server.com/simple/playback?recordID=183f0bf3a0982a127bdb8161-1...</url>" +
            "               <length>62</length>" +
            "            </format>" +
            "         </playback>" +
            "      </recording>" +
            "      <recording>" +
            "         <recordID>183f0bf3a0982a127bdb8161-13085974450</recordID>" +
            "         <meetingID>CS102</meetingID>" +
            "         ... " +
            "      </recording>" +
            "   </recordings>" +
            "   <messageKey/>" +
            "   <message/>" +
            "</response>";

    private static final String PUBLISH_RECORDINGS_XML =
            "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
            "<response>" +
            "   <returncode>SUCCESS</returncode>" +
            "   <published>true</published>" +
            "</response>";

    private static final String DELETE_RECORDINGS_XML =
            "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
            "<response>" +
            "   <returncode>SUCCESS</returncode>" +
            "   <deleted>true</deleted>" +
            "</response>";

    private static final String GET_DEFAULT_CONFIG_XML =
            "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
            "<config>" +
            "    <localeversion suppressWarning=\"false\">0.9.0</localeversion>" +
            "    <version>211</version>" +
            "    <help url=\"http://test-install.blindsidenetworks.com/help.html\" />" +
            "    <javaTest url=\"http://test-install.blindsidenetworks.com/testjava.html\" />" +
            "    <porttest host=\"test-install.blindsidenetworks.com\" application=\"video/portTest\" timeout=\"10000\" />" +
            "    <bwMon server=\"test-install.blindsidenetworks.com\" application=\"video/bwTest\" />" +
            "    <application uri=\"rtmp://test-install.blindsidenetworks.com/bigbluebutton\" host=\"http://test-install.blindsidenetworks.com/bigbluebutton/api/enter\" />" +
            "    <language userSelectionEnabled=\"true\" />" +
            "    <skinning enabled=\"true\" url=\"http://test-install.blindsidenetworks.com/client/branding/css/BBBDefault.css.swf\" />" +
            "    <shortcutKeys showButton=\"true\" />" +
            "    <browserVersions chrome=\"39\" firefox=\"35\" flash=\"16\" java=\"1.7.0_51\" />" +
            "    <layout showLogButton=\"false\" showVideoLayout=\"false\" showResetLayout=\"true\" defaultLayout=\"bbb.layout.name.defaultlayout\" showToolbar=\"true\" showFooter=\"true\" showMeetingName=\"true\" showHelpButton=\"true\" showLogoutWindow=\"true\" showLayoutTools=\"true\" showNetworkMonitor=\"false\" confirmLogout=\"true\" showRecordingNotification=\"true\" />" +
            "    <lock allowModeratorLocking=\"false\" disableCamForLockedUsers=\"false\" disableMicForLockedUsers=\"false\" disablePrivateChatForLockedUsers=\"false\" disablePublicChatForLockedUsers=\"false\" lockLayoutForLockedUsers=\"false\" />" +
            "    <modules>" +
            "        <module name=\"ChatModule\" url=\"http://test-install.blindsidenetworks.com/client/ChatModule.swf?v=211\" uri=\"rtmp://test-install.blindsidenetworks.com/bigbluebutton\" dependsOn=\"UsersModule\" privateEnabled=\"true\" fontSize=\"12\" position=\"top-right\" baseTabIndex=\"701\" colorPickerIsVisible=\"false\" />" +
            "        <module name=\"UsersModule\" url=\"http://test-install.blindsidenetworks.com/client/UsersModule.swf?v=211\" uri=\"rtmp://test-install.blindsidenetworks.com/bigbluebutton\" allowKickUser=\"true\" enableRaiseHand=\"true\" enableSettingsButton=\"true\" baseTabIndex=\"301\" />" +
            "    </modules>" +
            "</config>";

    private static final String SET_CONFIG_XML =
            "<response>" +
            "   <returncode>SUCCESS</returncode>" +
            "   <token>asdfl234kjasdfsadfy</token>" +
            "</response>";

    private Client client;

    private CrawlerFactory crawlerFactory;

    private Crawler crawler;

    private ServletResponse servletResponse;

    @Before
    public void setUp() throws Exception {
        crawlerFactory = Mockito.mock(CrawlerFactory.class);
        crawler = Mockito.mock(Crawler.class);
        servletResponse = Mockito.mock(ServletResponse.class);
        client = new Client("junit-test-server", "my secret");
        TestUtils.setField("crawlerFactory", client, crawlerFactory);
        when(crawlerFactory.createCrawler()).thenReturn(crawler);
    }

    @Test(expected = IllegalArgumentException.class)
    public void failCreateWithEmptyUrl() throws Exception {
        new Client("", "abc");
    }

    @Test(expected = IllegalArgumentException.class)
    public void failCreateWithNullUrl() throws Exception {
        new Client(null, "abc");
    }

    @Test(expected = IllegalArgumentException.class)
    public void failCreateWithEmptySharedSecret() throws Exception {
        new Client("abc", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void failCreateWithNullSharedSecret() throws Exception {
        new Client("abc", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void failCreateMeetingWithoutCommand() throws Exception {
        client.createMeeting(null);
    }

    @Test
    public void shouldCreateMeetingWithId() throws Exception {
        MeetingResponse meetingResponse = new MeetingResponse();
        meetingResponse.setReturnCode(ReturnCode.SUCCESS);
        meetingResponse.setAttendeePW("123");
        meetingResponse.setMeetingID("4711");
        meetingResponse.setModeratorPW("mp");
        meetingResponse.setCreateDate("Fri Jan 16 17:29:53 EST 2015");
        meetingResponse.setCreateTime(1421447393750L);
        meetingResponse.setMessage("");
        meetingResponse.setMessageKey("");
        CreateCommand createCommand = CreateCommand.builder()
                .meetingID("4711")
                .attendeePW("123")
                .moderatorPW("mp")
                .build();
        when(crawler.post("junit-test-server/create?attendeePW=123&duration=0&meetingID=4711&moderatorPW=mp&record=false&checksum=f10e533b82bcf83987b3467efdd1817e49d72807")).thenReturn(CREATE_MEETING_XML);
        assertEquals(meetingResponse, client.createMeeting(createCommand));
    }

    @Test
    public void shouldCreateMeetingWithSlides() throws Exception {
        MeetingResponse meetingResponse = new MeetingResponse();
        meetingResponse.setReturnCode(ReturnCode.SUCCESS);
        meetingResponse.setAttendeePW("123");
        meetingResponse.setMeetingID("4711");
        meetingResponse.setModeratorPW("mp");
        meetingResponse.setCreateDate("Fri Jan 16 17:29:53 EST 2015");
        meetingResponse.setCreateTime(1421447393750L);
        meetingResponse.setMessage("");
        meetingResponse.setMessageKey("");
        CreateCommand createCommand = CreateCommand.builder()
                .meetingID("4711")
                .attendeePW("123")
                .moderatorPW("mp")
                .build();
        ModulesCommand modulesCommand = ModulesCommand.builder()
                .module(ModuleCommand.builder()
                        .name("presentation")
                        .document(DocumentCommand.builder()
                                .url("theurl")
                                .build())
                        .document(DocumentCommand.builder()
                                .name("theotherurl")
                                .content(new byte[]{0, 1})
                                .build())
                        .build()
                )
                .build();
        String body =
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<modules>\n" +
                "    <module name=\"presentation\">\n" +
                "        <document url=\"theurl\"/>\n" +
                "        <document name=\"theotherurl\">AAE=</document>\n" +
                "    </module>\n" +
                "</modules>\n";
        System.out.println("exp body: " + body);
        System.out.println("exp url : junit-test-server/create?attendeePW=123&duration=0&meetingID=4711&moderatorPW=mp&record=false&checksum=f10e533b82bcf83987b3467efdd1817e49d72807" );
        when(crawler.post("junit-test-server/create?attendeePW=123&duration=0&meetingID=4711&moderatorPW=mp&record=false&checksum=f10e533b82bcf83987b3467efdd1817e49d72807", body)).thenReturn(CREATE_MEETING_XML);
        assertEquals(meetingResponse, client.createMeeting(createCommand, modulesCommand));
    }

    @Test(expected = IllegalArgumentException.class)
    public void failCreateQueryBecauseNull() throws Exception {
        Client.toQuery(null);
    }

    @Test
    public void shouldCreateEmptyQuery() throws Exception {
        assertEquals("", Client.toQuery(new TreeMap<String, Object>()));
    }

    @Test
    public void shouldCreateQuery() throws Exception {
        SortedMap<String, Object> sortedMap = new TreeMap<>();
        sortedMap.put("param1", "value1");
        sortedMap.put("param2", "value2");
        String expected = "param1=value1&param2=value2";
        String actual = Client.toQuery(sortedMap);
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void failJoinMeetingWithoutCommand() throws Exception {
        client.joinMeeting(servletResponse, null);
    }

    @Test
    public void shouldJoin() throws Exception {
        JoinCommand joinCommand = JoinCommand.builder()
                .meetingID("4711")
                .password("abc")
                .fullName("Al Bundy")
                .build();
        client.joinMeeting(servletResponse, joinCommand);
    }

    @Test(expected = IllegalArgumentException.class)
    public void failIsMeetingRunningWithNullCommand() throws Exception {
        client.isMeetingRunning(null);
    }

    @Test
    public void shouldIsMeetingRunning() throws Exception {
        when(crawler.post(anyString())).thenReturn(IS_MEETING_RUNNING_XML);
        IsMeetingRunningResponse isMeetingRunningResponse = client.isMeetingRunning(IsMeetingRunningCommand.builder()
                .meetingID("abc")
                .build());
        assertEquals(ReturnCode.SUCCESS, isMeetingRunningResponse.getReturnCode());
        assertTrue(isMeetingRunningResponse.isRunning());
    }

    @Test
    public void shouldGetMeetingInfo() throws Exception {
        when(crawler.post(anyString())).thenReturn(GET_MEETING_INFO_XML);
        GetMeetingInfoResponse getMeetingInfoResponse = client.getMeetingInfo(GetMeetingInfoCommand.builder()
                .meetingID("abc")
                .password("passpass")
                .build());
        assertEquals(ReturnCode.SUCCESS, getMeetingInfoResponse.getReturnCode());
        assertTrue(getMeetingInfoResponse.isRunning());
    }

    @Test(expected = IllegalArgumentException.class)
    public void failGetMeetingInfoWithoutCommand() throws Exception {
        client.getMeetingInfo(null);
    }

    @Test
    public void shouldGetMeetings() throws Exception {
        when(crawler.post(anyString())).thenReturn(GET_MEETINGS_XML);
        assertEquals(2, client.getMeetings().getMeetings().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void failGetRecordingsWithoutCommand() throws Exception {
        client.getRecordings(null);
    }

    @Test
    public void shouldGetRecordings() throws Exception {
        when(crawler.post(anyString())).thenReturn(GET_RECORDINGS_XML);
        GetRecordingsResponse getRecordingsResponse = client.getRecordings(GetRecordingsCommand.builder()
                .meetingID("abc")
                .build());
        assertEquals(ReturnCode.SUCCESS, getRecordingsResponse.getReturnCode());
        // CHECK
    }

    @Test(expected = IllegalArgumentException.class)
    public void failPublishRecordingsWithoutCommand() throws Exception {
        client.publishRecordings(null);
    }

    @Test
    public void shouldPublishRecordings() throws Exception {
        when(crawler.post(anyString())).thenReturn(PUBLISH_RECORDINGS_XML);
        PublishRecordingsResponse publishRecordingsResponse = client.publishRecordings(PublishRecordingsCommand.builder()
                .recordID("abc")
                .publish(true)
                .build());
        assertEquals(ReturnCode.SUCCESS, publishRecordingsResponse.getReturnCode());
        // CHECK
    }

    @Test(expected = IllegalArgumentException.class)
    public void failDeleteRecordingsWithoutCommand() throws Exception {
        client.getRecordings(null);
    }

    @Test
    public void shouldDeleteRecordings() throws Exception {
        when(crawler.post(anyString())).thenReturn(DELETE_RECORDINGS_XML);
        DeleteRecordingsResponse deleteRecordingsResponse = client.deleteRecordings(DeleteRecordingsCommand.builder()
                .recordID("abc")
                .build());
        assertEquals(ReturnCode.SUCCESS, deleteRecordingsResponse.getReturnCode());
        // CHECK
    }

    @Test
    public void shouldGetDefaultConfigXML() throws Exception {
        when(crawler.post(anyString())).thenReturn(GET_DEFAULT_CONFIG_XML);
        Config config = client.getDefaultConfigXML();
        assertNotNull(config);
        assertEquals("0.9.0", config.getLocaleVersion().getValue());
    }

    @Test
    public void shouldSetConfigXML() throws Exception {
        when(crawler.post(anyString(), anyString())).thenReturn(SET_CONFIG_XML);
        SetConfigXMLCommand setConfigXMLCommand = SetConfigXMLCommand.builder()
                .config(new Config())
                .meetingID("abc")
                .build();
        SetConfigXMLResponse setConfigXMLResponse = client.setConfigXML(setConfigXMLCommand);
        assertNotNull(setConfigXMLResponse);
        // CHECK
    }

}