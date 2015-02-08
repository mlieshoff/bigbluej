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
import static org.junit.Assert.assertTrue;

/**
 * @author Michael Lieshoff
 */
public class GetMeetingsResponseTest {

    private static final String XML =
            "<response>" +
            "    <returncode>SUCCESS</returncode>" +
            "    <meetings>" +
            "        <meeting>" +
            "            <meetingID>test01</meetingID>" +
            "            <meetingName>Test</meetingName>" +
            "            <createTime>1315254777880</createTime>" +
            "            <attendeePW>ap</attendeePW>" +
            "            <moderatorPW>mp</moderatorPW>" +
            "            <hasBeenForciblyEnded>false</hasBeenForciblyEnded>" +
            "            <running>true</running>" +
            "        </meeting>" +
            "        <meeting>" +
            "            <meetingID>test02</meetingID>" +
            "            <meetingName>Test2</meetingName>" +
            "            <createTime>1315254777885</createTime>" +
            "            <attendeePW>ap</attendeePW>" +
            "            <moderatorPW>mp</moderatorPW>" +
            "            <hasBeenForciblyEnded>false</hasBeenForciblyEnded>" +
            "            <running>true</running>" +
            "        </meeting>" +
            "    </meetings>" +
            "</response>";

    private GetMeetingsResponse getMeetingsResponse;

    @Before
    public void setUp() {
        getMeetingsResponse = JAXB.unmarshal(new StringReader(XML), GetMeetingsResponse.class);
    }

    @Test
    public void shouldHasReturnCode() {
        assertEquals(ReturnCode.SUCCESS, getMeetingsResponse.getReturnCode());
    }

    @Test
    public void shouldHasTwoMeetings() {
        assertEquals(2, getMeetingsResponse.getMeetings().size());
    }

    @Test
    public void shouldHasFirstMeetingMeetingID() {
        assertEquals("test01", getMeetingsResponse.getMeetings().get(0).getMeetingID());
    }

    @Test
    public void shouldHasFirstMeetingMeetingName() {
        assertEquals("Test", getMeetingsResponse.getMeetings().get(0).getMeetingName());
    }

    @Test
    public void shouldHasFirstMeetingCreateTime() {
        assertEquals(1315254777880L, getMeetingsResponse.getMeetings().get(0).getCreateTime());
    }

    @Test
    public void shouldHasFirstMeetingAttendeePW() {
        assertEquals("ap", getMeetingsResponse.getMeetings().get(0).getAttendeePW());
    }

    @Test
    public void shouldHasFirstMeetingModeratorPW() {
        assertEquals("mp", getMeetingsResponse.getMeetings().get(0).getModeratorPW());
    }

    @Test
    public void shouldFirstMeetingHasBeenForciblyEnded() {
        assertFalse(getMeetingsResponse.getMeetings().get(0).isHasBeenForcibleEnded());
    }

    @Test
    public void shouldFirstMeetingHasRunning() {
        assertTrue(getMeetingsResponse.getMeetings().get(0).isRunning());
    }

    @Test
    public void shouldHasSecondMeetingMeetingID() {
        assertEquals("test02", getMeetingsResponse.getMeetings().get(1).getMeetingID());
    }

    @Test
    public void shouldHasSecondMeetingMeetingName() {
        assertEquals("Test2", getMeetingsResponse.getMeetings().get(1).getMeetingName());
    }

    @Test
    public void shouldHasSecondMeetingCreateTime() {
        assertEquals(1315254777885L, getMeetingsResponse.getMeetings().get(1).getCreateTime());
    }

    @Test
    public void shouldHasSecondMeetingAttendeePW() {
        assertEquals("ap", getMeetingsResponse.getMeetings().get(1).getAttendeePW());
    }

    @Test
    public void shouldHasSecondMeetingModeratorPW() {
        assertEquals("mp", getMeetingsResponse.getMeetings().get(1).getModeratorPW());
    }

    @Test
    public void shouldSecondMeetingHasBeenForciblyEnded() {
        assertFalse(getMeetingsResponse.getMeetings().get(1).isHasBeenForcibleEnded());
    }

    @Test
    public void shouldSecondMeetingHasRunning() {
        assertTrue(getMeetingsResponse.getMeetings().get(1).isRunning());
    }

}