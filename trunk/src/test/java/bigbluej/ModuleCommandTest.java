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

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Michael Lieshoff
 */
public class ModuleCommandTest {

    private ModuleCommand.Builder builder;

    @Before
    public void setUp() {
        builder = ModuleCommand.builder();
    }

    @Test
    public void shouldCreateBuilder() {
        assertNotNull(builder);
    }

    @Test
    public void shouldBuildWithName() {
        assertEquals("name", builder.name("name").build().getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void failBuildWithoutName() {
        builder.build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void failToAddNullDocument() {
        builder.document(null);
    }

    @Test
    public void shouldAddDocument() {
        DocumentCommand documentCommand = DocumentCommand.builder().url("theurl").build();
        assertTrue(builder.name("module").document(documentCommand).build().getDocuments().contains(documentCommand));
    }

    @Test
    public void shouldAddTwoModules() {
        DocumentCommand documentCommand1 = DocumentCommand.builder().url("url1").build();
        DocumentCommand documentCommand2 = DocumentCommand.builder().url("url2").build();
        List<DocumentCommand> documents = builder.name("module").document(documentCommand1).document(documentCommand2).build().getDocuments();
        assertTrue(documents.contains(documentCommand1));
        assertTrue(documents.contains(documentCommand2));
    }

}