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
public class JoinCommandTest {

    private JoinCommand.Builder builder;

    private JoinCommand.Builder join;

    @Before
    public void setUp() {
        builder = JoinCommand.builder();
        join = JoinCommand.builder().fullName("Al Bundy").meetingID("123").password("xyz");
    }

    @Test
    public void shouldCreateBuilder() {
        assertNotNull(builder);
    }

    @Test(expected = IllegalArgumentException.class)
    public void failBuildWithoutFullName() {
        builder.meetingID("123").password("xyz").build();
    }

    @Test
    public void shouldBuildWithFullName() {
        assertEquals("Al Bundy", join.build().getFullName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void failBuildWithoutMeetingID() {
        builder.fullName("Al Bundy").password("xyz").build();
    }

    @Test
    public void shouldBuildWithMeetingID() {
        assertEquals("123", join.build().getMeetingID());
    }

    @Test(expected = IllegalArgumentException.class)
    public void failBuildWithoutPassword() {
        builder.fullName("Al Bundy").meetingID("123").build();
    }

    @Test
    public void shouldBuildWithPassword() {
        assertEquals("xyz", join.build().getPassword());
    }

    @Test
    public void shouldBuildWithCreateTime() {
        assertEquals(1234, join.createTime(1234L).build().getCreateTime());
    }

    @Test
    public void shouldBuildWithUserId() {
        assertEquals("mia", join.userId("mia").build().getUserId());
    }

    @Test
    public void shouldBuildWithWebConfigConf() {
        assertEquals("lala", join.webConfigConf("lala").build().getWebConfigConf());
    }

    @Test
    public void shouldBuildWithConfigToken() {
        assertEquals("token", join.configToken("token").build().getConfigToken());
    }

    @Test
    public void shouldBuildWithAvatarURL() {
        assertEquals("url", join.avatarURL("url").build().getAvatarURL());
    }

    @Test
    public void shouldBuildWithRedirectClient() {
        assertEquals(true, join.redirectClient(true).build().isRedirectClient());
    }

    @Test
    public void shouldBuildWithClientURL() {
        assertEquals("clienturl", join.clientURL("clienturl").build().getClientURL());
    }

}