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

import bigbluej.config.Config;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Michael Lieshoff
 */
public class SetConfigXMLCommandTest {

    private SetConfigXMLCommand.Builder builder = SetConfigXMLCommand.builder();

    @Test
    public void shouldCreateBuilder() {
        assertNotNull(builder);
    }

    @Test(expected = IllegalArgumentException.class)
    public void failBuildWithoutMeetingID() {
        builder.config(new Config()).build();
    }

    @Test
    public void shouldBuildWithMeetingID() {
        assertEquals("123", builder.meetingID("123").config(new Config()).build().getMeetingID());
    }

    @Test(expected = IllegalArgumentException.class)
    public void failBuildWithoutConfig() {
        builder.meetingID("123").build();
    }

    @Test
    public void shouldBuildWithConfig() {
        Config config = new Config();
        assertEquals(config, builder.meetingID("123").config(new Config()).build().getConfig());
    }

}