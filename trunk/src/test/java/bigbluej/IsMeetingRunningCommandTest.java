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

/**
 * @author Michael Lieshoff
 */
public class IsMeetingRunningCommandTest {

    private IsMeetingRunningCommand.Builder builder;

    private IsMeetingRunningCommand.Builder join;

    @Before
    public void setUp() {
        builder = IsMeetingRunningCommand.builder();
    }

    @Test
    public void shouldCreateBuilder() {
        assertNotNull(builder);
    }

    @Test(expected = IllegalArgumentException.class)
    public void failBuildWithoutMeetingID() {
        builder.build();
    }

    @Test
    public void shouldBuildWithMeetingID() {
        assertEquals("abc", builder.meetingID("abc").build().getMeetingID());
    }

}