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

import javax.xml.bind.JAXB;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;

/**
 * @author Michael Lieshoff
 */
public class GetMeetingInfoResponseTest {

    private static final String XML =
            "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
            "<response>" +
            "   <returncode>SUCCESS</returncode>" +
            "   <meetingName>Test</meetingName>" +
            "   <meetingID>test01</meetingID>" +
            "   <createTime>1315254777880</createTime>" +
            "   <voiceBridge>70775</voiceBridge>" +
            "   <attendeePW>ap</attendeePW>" +
            "   <moderatorPW>mp</moderatorPW>" +
            "   <running>true</running>" +
            "   <recording>false</recording>" +
            "   <hasBeenForciblyEnded>false</hasBeenForciblyEnded>" +
            "   <startTime>1315254785069</startTime>" +
            "   <endTime>0</endTime>" +
            "   <participantCount>1</participantCount>" +
            "   <maxUsers>20</maxUsers>" +
            "   <moderatorCount>1</moderatorCount>" +
            "   <attendees>" +
            "      <attendee>" +
            "         <userID>1</userID>" +
            "         <fullName>John Doe</fullName>" +
            "         <role>MODERATOR</role>" +
            "      </attendee>" +
            "   </attendees>" +
            "   <metadata/>" +
            "   <messageKey/>" +
            "   <message/>" +
            "</response>";

    private GetMeetingInfoResponse getMeetingInfoResponse;

    @Before
    public void setUp() {
        getMeetingInfoResponse = JAXB.unmarshal(new StringReader(XML), GetMeetingInfoResponse.class);
    }

    @Test
    public void shouldHasReturnCode() {
        assertEquals(ReturnCode.SUCCESS, getMeetingInfoResponse.getReturnCode());
    }

    @Test
    public void shouldNotHasMessageKey() {
        assertEquals("", getMeetingInfoResponse.getMessageKey());
    }

    @Test
    public void shouldNotHasMessage() {
        assertEquals("", getMeetingInfoResponse.getMessage());
    }

    @Test
    public void shouldHasMeetingName() {
        assertEquals("Test", getMeetingInfoResponse.getMeetingName());
    }

    @Test
    public void shouldHasParticipantCount() {
        assertEquals(1, getMeetingInfoResponse.getParticipantCount());
    }

}