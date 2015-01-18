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
import org.mockito.Mockito;

import java.util.SortedMap;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * @author Michael Lieshoff
 */
public class ClientTest {

    private Client client;

    private String expectedResult;

    private CrawlerFactory crawlerFactory = Mockito.mock(CrawlerFactory.class);

    private Crawler crawler = Mockito.mock(Crawler.class);

    @Before
    public void setUp() throws Exception {
        client = new Client("junit-test-server", "my secret");
        TestUtils.setField("crawlerFactory", client, crawlerFactory);
    }

    @Test(expected = IllegalArgumentException.class)
    public void failCreateWithEmptyUrl() throws Exception {
        new Client("", "abc");
    }

    @Test(expected = IllegalArgumentException.class)
    public void failCreateWithNullUrl() throws Exception {
        new Client(null, "abc");
    }

    @Test(expected = IllegalArgumentException.class)
    public void failCreateWithEmptySharedSecret() throws Exception {
        new Client("abc", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void failCreateWithNullSharedSecret() throws Exception {
        new Client("abc", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void failCreateMeetingWithoutCommand() throws Exception {
        client.createMeeting(null);
    }

    @Test
    public void shouldCreateMeeting() throws Exception {
        expectedResult = "<response><returncode>SUCCESS</returncode><meetingID>4711</meetingID><attendeePW>ap</attendeePW><moderatorPW>mp</moderatorPW><createTime>1421447393750</createTime><createDate>Fri Jan 16 17:29:53 EST 2015</createDate><hasUserJoined>false</hasUserJoined><duration>0</duration><hasBeenForciblyEnded>false</hasBeenForciblyEnded><messageKey/><message/></response>";

        when(crawlerFactory.createCrawler()).thenReturn(crawler);
        when(crawler.post(anyString())).thenReturn(expectedResult);

        assertEquals(expectedResult, client.createMeeting(CreateCommand.builder()
                .meetingID("4711")
                .attendeePW("ap")
                .moderatorPW("mp").build()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void failCreateQueryBecauseNull() throws Exception {
        Client.toQuery(null);
    }

    @Test
    public void shouldCreateEmptyQuery() throws Exception {
        assertEquals("", Client.toQuery(new TreeMap<String, Object>()));
    }

    @Test
    public void shouldCreateQuery() throws Exception {
        SortedMap<String, Object> sortedMap = new TreeMap<>();
        sortedMap.put("param1", "value1");
        sortedMap.put("param2", "value2");
        String expected = "param1=value1&param2=value2";
        String actual = Client.toQuery(sortedMap);
        assertEquals(expected, actual);
    }

}