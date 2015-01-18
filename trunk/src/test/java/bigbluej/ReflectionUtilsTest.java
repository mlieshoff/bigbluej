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

import java.util.SortedMap;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

/**
 * @author Michael Lieshoff
 */
public class ReflectionUtilsTest {

    @Test(expected = IllegalArgumentException.class)
    public void failGetFieldsAndValuesAsSortedMapBecauseNull() throws Exception {
        ReflectionUtils.getFieldsAndValuesInSortedMap(null);
    }

    @Test
    public void shouldGetFieldsAndValuesAsSortedMap() throws Exception {
        Foo foo = new Foo();
        SortedMap<String, Object> expected = new TreeMap<>();
        expected.put("i", foo.i);
        expected.put("s", foo.s);
        assertEquals(expected, ReflectionUtils.getFieldsAndValuesInSortedMap(foo));
    }

    private class Foo {
        private int i = 4711;
        private String s = "bla";
        private String s1 = null;
    }

}