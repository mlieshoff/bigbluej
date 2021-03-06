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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Michael Lieshoff
 */
public class ModulesCommandTest {

    private ModulesCommand.Builder builder;

    @Before
    public void setUp() {
        builder = ModulesCommand.builder();
    }

    @Test
    public void shouldCreateBuilder() {
        assertNotNull(builder);
    }

    @Test(expected = IllegalArgumentException.class)
    public void failToAddNullModule() {
        builder.module(null);
    }

    @Test
    public void shouldAddModule() {
        ModuleCommand moduleCommand = ModuleCommand.builder().name("name").build();
        assertTrue(builder.module(moduleCommand).build().getModules().contains(moduleCommand));
    }

    @Test
    public void shouldAddTwoModules() {
        ModuleCommand moduleCommand1 = ModuleCommand.builder().name("name1").build();
        ModuleCommand moduleCommand2 = ModuleCommand.builder().name("name2").build();
        List<ModuleCommand> modules = builder.module(moduleCommand1).module(moduleCommand2).build().getModules();
        assertTrue(modules.contains(moduleCommand1));
        assertTrue(modules.contains(moduleCommand2));
    }

}