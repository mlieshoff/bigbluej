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

/**
 * @author Michael Lieshoff
 */
public class ApiTest {

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

    private Api api;

    private ServletResponse servletResponse = Mockito.mock(ServletResponse.class);

    @Before
    public void setUp() throws Exception {
        api = Api.builder()
                .url("junit-test-server")
                .sharedSecret("my secret")
                .build();
        TestUtils.setField("client", api, new Client("junit-test-server", "my secret") {
            @Override
            public String createMeeting(CreateCommand createCommand) {
                return CREATE_MEETING_XML;
            }

            @Override
            public String getMeetings() throws Exception {
                return GET_MEETINGS_XML;
            }

            @Override
            public void joinMeeting(ServletResponse servletResponse, JoinCommand joinCommand) throws Exception {
                super.joinMeeting(servletResponse, joinCommand);
            }
        });
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
        meetingResponse.setReturnCode(ReturnCode.SUCCESS);
        meetingResponse.setAttendeePW("123");
        meetingResponse.setMeetingID("4711");
        meetingResponse.setModeratorPW("mp");
        meetingResponse.setCreateDate("Fri Jan 16 17:29:53 EST 2015");
        meetingResponse.setCreateTime(1421447393750L);
        meetingResponse.setMessage("");
        meetingResponse.setMessageKey("");
        assertEquals(meetingResponse, api.createMeeting(CreateCommand.builder()
                .meetingID("4711")
                .attendeePW("123")
                .moderatorPW("mp")
                .build()));
    }

    @Test
    public void shouldJoin() throws Exception {
        api.joinMeeting(servletResponse, JoinCommand.builder()
                .meetingID("4711")
                .password("abc")
                .fullName("Al Bundy")
                .build());
    }

    @Test
    public void shouldGetMeetings() throws Exception {
        assertEquals(2, api.getMeetings().getMeetings().size());
    }

}