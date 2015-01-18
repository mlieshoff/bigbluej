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

import static org.junit.Assert.assertEquals;

/**
 * @author Michael Lieshoff
 */
public class BigBlueJIntegrationTest {

    private Api api;

    @Before
    public void setUp() {
        api = Api.builder()
                .url("http://test-install.blindsidenetworks.com/bigbluebutton/api")
                .sharedSecret("8cd8ef52e8e101574e400365b55e11a6")
                .build();
    }

    @Test
    public void shouldCreateMeeting() throws Exception {
        long meetingID = System.currentTimeMillis();
        CreateCommand createCommand = CreateCommand.builder()
                .meetingID("myMeeting" + meetingID)
                .attendeePW("passpass")
                .moderatorPW("superpass")
                .name("myMeeting")
                .welcome("<br>Welcome to <b>%%CONFNAME%%</b>!")
                .build();
        checkMeetingResponse(createCommand, api.createMeeting(createCommand));
    }

    private void checkMeetingResponse(CreateCommand createCommand, MeetingResponse meetingResponse) {
        assertEquals(ReturnCode.SUCCESS, meetingResponse.getReturnCode());
        assertEquals(createCommand.getMeetingID(), meetingResponse.getMeetingID());
        assertEquals(createCommand.getAttendeePW(), meetingResponse.getAttendeePW());
        assertEquals(createCommand.getModeratorPW(), meetingResponse.getModeratorPW());
    }

    @Test
    public void shouldGetMeetings() throws Exception {
        MeetingsResponse meetingsResponse = api.getMeetings();
        assertEquals(ReturnCode.SUCCESS, meetingsResponse.getReturnCode());
    }

}
