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
public class EndResponseTest {

    private static final String XML =
            "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
            "<response>" +
            "   <returncode>SUCCESS</returncode>" +
            "   <messageKey>sentEndMeetingRequest</messageKey>" +
            "   <message>A request to end the meeting was sent. Please wait a few seconds, and then use the getMeetingInfo or isMeetingRunning API calls to verify that   it was ended.</message>" +
            "</response>";

    private EndResponse endResponse;

    @Before
    public void setUp() {
        endResponse = JAXB.unmarshal(new StringReader(XML), EndResponse.class);
    }

    @Test
    public void shouldHasReturnCode() {
        assertEquals(ReturnCode.SUCCESS, endResponse.getReturnCode());
    }

    @Test
    public void shouldHasMessageKey() {
        assertEquals("sentEndMeetingRequest", endResponse.getMessageKey());
    }

    @Test
    public void shouldHasMessage() {
        assertEquals("A request to end the meeting was sent. Please wait a few seconds, and then use the getMeetingInfo or isMeetingRunning API calls to verify that   it was ended.", endResponse.getMessage());
    }

}