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

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Michael Lieshoff
 */
public class GetMeetingInfoCommandTest {

    private GetMeetingInfoCommand.Builder builder = GetMeetingInfoCommand.builder();

    @Test
    public void shouldCreateBuilder() {
        assertNotNull(builder);
    }

    @Test(expected = IllegalArgumentException.class)
    public void failBuildWithoutMeetingID() {
        builder.password("pass").build();
    }

    @Test
    public void shouldBuildWithMeetingID() {
        assertEquals("123", builder.meetingID("123").password("pass").build().getMeetingID());
    }

    @Test(expected = IllegalArgumentException.class)
    public void failBuildWithoutPassword() {
        builder.meetingID("123").build();
    }

    @Test
    public void shouldBuildWithPassword() {
        assertEquals("pass", builder.meetingID("123").password("pass").build().getPassword());
    }

}