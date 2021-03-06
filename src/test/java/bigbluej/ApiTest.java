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

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author Michael Lieshoff
 */
public class ApiTest {

    private Api api;

    private Client client = Mockito.mock(Client.class);

    private ServletResponse servletResponse = Mockito.mock(ServletResponse.class);

    @Before
    public void setUp() throws Exception {
        api = Api.builder()
                .url("junit-test-server")
                .sharedSecret("my secret")
                .build();
        TestUtils.setField("client", api, client);
    }

    @Test(expected = IllegalArgumentException.class)
    public void faildBuildWithoutUrl() throws Exception {
        Api.builder().sharedSecret("abc").build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void faildBuildWithEmptyUrl() throws Exception {
        Api.builder().url("").sharedSecret("abc").build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void faildBuildWithoutSharedSecret() throws Exception {
        Api.builder().url("abc").build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void faildBuildWithEmptySharedSecret() throws Exception {
        Api.builder().url("abc").sharedSecret("").build();
    }

    @Test
    public void shouldCreateMeetingWithId() throws Exception {
        MeetingResponse meetingResponse = new MeetingResponse();
        CreateCommand createCommand = CreateCommand.builder()
                .meetingID("4711")
                .attendeePW("123")
                .moderatorPW("mp")
                .build();
        when(client.createMeeting(createCommand)).thenReturn(meetingResponse);
        assertEquals(meetingResponse, api.createMeeting(createCommand));
    }

    @Test
    public void shouldCreateMeetingWithSlides() throws Exception {
        MeetingResponse meetingResponse = new MeetingResponse();
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
                        .build())
                .build();
        when(client.createMeeting(createCommand, modulesCommand)).thenReturn(meetingResponse);
        assertEquals(meetingResponse, api.createMeeting(createCommand, modulesCommand));
    }

    @Test
    public void shouldJoin() throws Exception {
        JoinCommand joinCommand = JoinCommand.builder()
                .meetingID("4711")
                .password("abc")
                .fullName("Al Bundy")
                .build();
        Mockito.doNothing().when(client).joinMeeting(servletResponse, joinCommand);
        api.joinMeeting(servletResponse, joinCommand);
    }

    @Test
    public void shouldIsMeetingRunning() throws Exception {
        IsMeetingRunningResponse isMeetingRunningResponse = new IsMeetingRunningResponse();
        IsMeetingRunningCommand isMeetingRunningCommand = IsMeetingRunningCommand.builder()
                .meetingID("4711")
                .build();
        when(client.isMeetingRunning(isMeetingRunningCommand)).thenReturn(isMeetingRunningResponse);
        assertEquals(isMeetingRunningResponse, api.isMeetingRunning(isMeetingRunningCommand));
    }

    @Test
    public void shouldEnd() throws Exception {
        EndResponse endResponse = new EndResponse();
        EndCommand endCommand = EndCommand.builder()
                .meetingID("4711")
                .password("pass")
                .build();
        when(client.end(endCommand)).thenReturn(endResponse);
        assertEquals(endResponse, api.end(endCommand));
    }

    @Test
    public void shouldGetMeetings() throws Exception {
        GetMeetingsResponse getMeetingsResponse = new GetMeetingsResponse();
        when(client.getMeetings()).thenReturn(getMeetingsResponse);
        assertEquals(getMeetingsResponse, api.getMeetings());
    }

    @Test
    public void shouldGetRecordings() throws Exception {
        GetRecordingsResponse getRecordingsResponse = new GetRecordingsResponse();
        GetRecordingsCommand getRecordingsCommand = GetRecordingsCommand.builder()
                .meetingID("4711")
                .build();
        when(client.getRecordings(getRecordingsCommand)).thenReturn(getRecordingsResponse);
        assertEquals(getRecordingsResponse, api.getRecordings(getRecordingsCommand));
    }

    @Test
    public void shouldPublishRecordings() throws Exception {
        PublishRecordingsResponse publishRecordingsResponse = new PublishRecordingsResponse();
        PublishRecordingsCommand publishRecordingsCommand = PublishRecordingsCommand.builder()
                .recordID("4711")
                .publish(true)
                .build();
        when(client.publishRecordings(publishRecordingsCommand)).thenReturn(publishRecordingsResponse);
        assertEquals(publishRecordingsResponse, api.publishRecordings(publishRecordingsCommand));
    }

    @Test
    public void shouldDeleteRecordings() throws Exception {
        DeleteRecordingsResponse deleteRecordingsResponse = new DeleteRecordingsResponse();
        DeleteRecordingsCommand deleteRecordingsCommand = DeleteRecordingsCommand.builder()
                .recordID("4711")
                .build();
        when(client.deleteRecordings(deleteRecordingsCommand)).thenReturn(deleteRecordingsResponse);
        assertEquals(deleteRecordingsResponse, api.deleteRecordings(deleteRecordingsCommand));
    }

    @Test
    public void shouldGetDefaultConfigXML() throws Exception {
        Config config = new Config();
        when(client.getDefaultConfigXML()).thenReturn(config);
        assertEquals(config, api.getDefaultConfigXML());
    }

    @Test
    public void shouldSetConfigXML() throws Exception {
        Config config = new Config();
        SetConfigXMLResponse setConfigXMLResponse = new SetConfigXMLResponse();
        SetConfigXMLCommand setConfigXMLCommand = SetConfigXMLCommand.builder()
                .config(config)
                .meetingID("abc")
                .build();
        when(client.setConfigXML(setConfigXMLCommand)).thenReturn(setConfigXMLResponse);
        assertEquals(setConfigXMLResponse, api.setConfigXML(setConfigXMLCommand));
    }

    @Test
    public void shouldGetJoinMeetingUrl() throws Exception {
        String url = "url";
        JoinCommand joinCommand = JoinCommand.builder()
                .meetingID("4711")
                .password("abc")
                .fullName("Al Bundy")
                .build();
        when(client.getJoinMeetingUrl(joinCommand)).thenReturn(url);
        assertEquals(url, api.getJoinMeetingUrl(joinCommand));
    }

}