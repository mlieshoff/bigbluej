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
    public void shouldGetMeetings() throws Exception {
        MeetingsResponse meetingsResponse = new MeetingsResponse();
        when(client.getMeetings()).thenReturn(meetingsResponse);
        assertEquals(meetingsResponse, api.getMeetings());
    }

}