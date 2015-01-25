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
public class DocumentCommandTest {

    private DocumentCommand.Builder builder;

    private static final byte[] CONTENT = new byte[]{1};

    @Before
    public void setUp() {
        builder = DocumentCommand.builder();
    }

    @Test
    public void shouldCreateBuilder() {
        assertNotNull(builder);
    }

    @Test
    public void shouldBuildWithUrl() {
        assertEquals("theurl", builder.url("theurl").build().getUrl());
    }

    @Test
    public void shouldBuildWithNameAndContent() {
        assertEquals("donald", builder.name("donald").content(CONTENT).build().getName());
    }

    @Test
    public void shouldBuildWithContentAndName() {
        assertEquals(CONTENT, builder.name("donald").content(CONTENT).build().getContent());
    }

    @Test(expected = IllegalArgumentException.class)
    public void failBuildWithNameAndUrl() {
        builder.name("donald").url("theurl").build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void failBuildWithoutNameAndUrl() {
        builder.build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void failBuildWithNameAndWithoutContent() {
        builder.name("donald").build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void failBuildWithUrlAndContent() {
        builder.url("theurl").content(CONTENT).build();
    }

}