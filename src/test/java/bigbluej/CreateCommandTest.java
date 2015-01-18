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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Michael Lieshoff
 */
public class CreateCommandTest {

    private CreateCommand.Builder builder;

    @Before
    public void setUp() {
        builder = CreateCommand.builder();
    }

    @Test
    public void shouldCreateBuilder() {
        assertNotNull(builder);
    }

    @Test
    public void shouldBuildWithName() {
        assertEquals("lala", meetingWithId().name("lala").build().getName());
    }

    @Test
    public void shouldBuildWithMeetingID() {
        assertEquals("4711", meetingWithId().build().getMeetingID());
    }

    private CreateCommand.Builder meetingWithId() {
        return builder.meetingID("4711");
    }

    @Test(expected = IllegalArgumentException.class)
    public void failBuildWithoutMeetingID() {
        builder.build();
    }

    @Test
    public void shouldBuildWithAttendeePW() {
        assertEquals("pw", meetingWithId().attendeePW("pw").build().getAttendeePW());
    }

    @Test
    public void shouldBuildWithModeratorPW() {
        assertEquals("mpw", meetingWithId().moderatorPW("mpw").build().getModeratorPW());
    }

    @Test
    public void shouldBuildWithWelcome() {
        assertEquals("hello world!", meetingWithId().welcome("hello world!").build().getWelcome());
    }

    @Test
    public void shouldBuildWithDialNumber() {
        assertEquals("555-555", meetingWithId().dialNumber("555-555").build().getDialNumber());
    }

    @Test
    public void shouldBuildWithVoiceBridge() {
        assertEquals("78119", meetingWithId().voiceBridge("78119").build().getVoiceBridge());
    }

    @Test
    public void shouldBuildWithWebVoice() {
        assertEquals("abc", meetingWithId().webVoice("abc").build().getWebVoice());
    }

    @Test
    public void shouldBuildWithLogoutURL() {
        assertEquals("www.google.de", meetingWithId().logoutURL("www.google.de").build().getLogoutURL());
    }

    @Test
    public void shouldBuildWithRecord() {
        assertTrue(meetingWithId().record(true).build().isRecord());
    }

    @Test
    public void shouldBuildWithDuration() {
        assertEquals(42, meetingWithId().duration(42).build().getDuration());
    }

    @Test
    public void shouldBuildWithMeta() {
        assertEquals("my-meta", meetingWithId().meta("my-meta").build().getMeta());
    }

}