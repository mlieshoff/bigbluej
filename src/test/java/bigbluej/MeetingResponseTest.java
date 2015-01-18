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
import static org.junit.Assert.assertFalse;

/**
 * @author Michael Lieshoff
 */
public class MeetingResponseTest {

    private static final String XML =
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

    private MeetingResponse meetingResponse;

    @Before
    public void setUp() {
        meetingResponse = JAXB.unmarshal(new StringReader(XML), MeetingResponse.class);
    }

    @Test
    public void shouldHasReturnCode() {
        assertEquals(ReturnCode.SUCCESS, meetingResponse.getReturnCode());
    }

    @Test
    public void shouldHasMeetingID() {
        assertEquals("4711", meetingResponse.getMeetingID());
    }

    @Test
    public void shouldHasAttendeePW() {
        assertEquals("123", meetingResponse.getAttendeePW());
    }

    @Test
    public void shouldHasModeratorPW() {
        assertEquals("mp", meetingResponse.getModeratorPW());
    }

    @Test
    public void shouldHasCreateTime() {
        assertEquals(1421447393750L, meetingResponse.getCreateTime());
    }

    @Test
    public void shouldHasCreateDate() {
        assertEquals("Fri Jan 16 17:29:53 EST 2015", meetingResponse.getCreateDate());
    }

    @Test
    public void shouldHasUserJoined() {
        assertFalse(meetingResponse.isHasUserJoined());
    }

    @Test
    public void shouldHasDuration() {
        assertEquals(0, meetingResponse.getDuration());
    }

    @Test
    public void shouldHasBeenForcibleEnded() {
        assertFalse(meetingResponse.isHasBeenForcibleEnded());
    }

    @Test
    public void shouldNotHasMessageKey() {
        assertEquals("", meetingResponse.getMessageKey());
    }

    @Test
    public void shouldNotHasMessage() {
        assertEquals("", meetingResponse.getMessage());
    }

}