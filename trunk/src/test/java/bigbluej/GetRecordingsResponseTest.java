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

import static org.junit.Assert.*;

/**
 * @author Michael Lieshoff
 */
public class GetRecordingsResponseTest {

    private static final String XML =
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
            "      </recording>" +
            "   </recordings>" +
            "   <messageKey/>" +
            "   <message/>" +
            "</response>";

    private GetRecordingsResponse getRecordingsResponse;

    @Before
    public void setUp() {
        getRecordingsResponse = JAXB.unmarshal(new StringReader(XML), GetRecordingsResponse.class);
    }

    @Test
    public void shouldHasReturnCode() {
        assertEquals(ReturnCode.SUCCESS, getRecordingsResponse.getReturnCode());
    }

    @Test
    public void shouldHasTwoRecordings() {
        assertEquals(2, getRecordingsResponse.getRecordings().size());
    }

    @Test
    public void shouldHasRecordID() {
        assertEquals("183f0bf3a0982a127bdb8161-1308597520", getRecordingsResponse.getRecordings().get(0).getRecordID());
    }

    @Test
    public void shouldHasFirstRecordingMeetingID() {
        assertEquals("CS101", getRecordingsResponse.getRecordings().get(0).getMeetingID());
    }

    @Test
    public void shouldHasName() {
        assertEquals("On-line session for CS 101", getRecordingsResponse.getRecordings().get(0).getName());
    }

    @Test
    public void shouldHasPublished() {
        assertFalse(getRecordingsResponse.getRecordings().get(0).isPublished());
    }

    @Test
    public void shouldHasStartTime() {
        assertEquals(34545465656L, getRecordingsResponse.getRecordings().get(0).getStartTime());
    }

    @Test
    public void shouldHasEndTime() {
        assertEquals(34575565465L, getRecordingsResponse.getRecordings().get(0).getEndTime());
    }

    @Test
    public void shouldHasMetaDataTitle() {
        assertEquals("Test Recording", getRecordingsResponse.getRecordings().get(0).getMetaData().getTitle());
    }

    @Test
    public void shouldHasMetaDataSubject() {
        assertEquals("English 232 session", getRecordingsResponse.getRecordings().get(0).getMetaData().getSubject());
    }

    @Test
    public void shouldHasMetaDataDescription() {
        assertEquals("First Class", getRecordingsResponse.getRecordings().get(0).getMetaData().getDescription());
    }

    @Test
    public void shouldHasMetaDataCreator() {
        assertEquals("Fred Dixon", getRecordingsResponse.getRecordings().get(0).getMetaData().getCreator());
    }

    @Test
    public void shouldHasMetaDataContributor() {
        assertEquals("Richard Alam", getRecordingsResponse.getRecordings().get(0).getMetaData().getContributor());
    }

    @Test
    public void shouldHasMetaDataLanguage() {
        assertEquals("en_US", getRecordingsResponse.getRecordings().get(0).getMetaData().getLanguage());
    }

    @Test
    public void shouldHasPlaybackFormatType() {
        assertEquals("simple", getRecordingsResponse.getRecordings().get(0).getPlayback().getFormat().getType());
    }

    @Test
    public void shouldHasPlaybackFormatUrl() {
        assertEquals("http://server.com/simple/playback?recordID=183f0bf3a0982a127bdb8161-1...", getRecordingsResponse.getRecordings().get(0).getPlayback().getFormat().getUrl());
    }

    @Test
    public void shouldHasPlaybackFormatLength() {
        assertEquals(62, getRecordingsResponse.getRecordings().get(0).getPlayback().getFormat().getLength());
    }

}