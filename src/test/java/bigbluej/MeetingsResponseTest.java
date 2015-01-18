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
public class MeetingsResponseTest {

    private static final String XML =
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

    private MeetingsResponse meetingsResponse;

    @Before
    public void setUp() {
        meetingsResponse = JAXB.unmarshal(new StringReader(XML), MeetingsResponse.class);
    }

    @Test
    public void shouldHasReturnCode() {
        assertEquals(ReturnCode.SUCCESS, meetingsResponse.getReturnCode());
    }

    @Test
    public void shouldHasTwoMeeting() {
        System.out.println(meetingsResponse.getMeetings().get(0));
        assertEquals(2, meetingsResponse.getMeetings().size());
    }

}