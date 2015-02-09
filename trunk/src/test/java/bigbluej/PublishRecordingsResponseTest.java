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
import static org.junit.Assert.assertTrue;

/**
 * @author Michael Lieshoff
 */
public class PublishRecordingsResponseTest {

    private static final String XML =
            "<response>" +
            "   <returncode>SUCCESS</returncode>" +
            "   <published>true</published>" +
            "</response>";

    private PublishRecordingsResponse publishRecordingsResponse;

    @Before
    public void setUp() {
        publishRecordingsResponse = JAXB.unmarshal(new StringReader(XML), PublishRecordingsResponse.class);
    }

    @Test
    public void shouldHasReturnCode() {
        assertEquals(ReturnCode.SUCCESS, publishRecordingsResponse.getReturnCode());
    }

    @Test
    public void shouldHasPublished() {
        assertTrue(publishRecordingsResponse.isPublished());
    }

}