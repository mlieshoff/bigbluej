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

/**
 * @author Michael Lieshoff
 */
public class DocumentTest {

    private static final String XML1 = "<document url=\"http://www.samplepdf.com/sample.pdf\" />";
    private static final String XML2 =
            "<document name=\"sample-presentation.pdf\">JVBERi0xLjQKJ...." +
            "  [clipped here]" +
            "  ....0CiUlRU9GCg==" +
            "</document>";

    private Document document1;
    private Document document2;

    @Before
    public void setUp() {
        document1 = JAXB.unmarshal(new StringReader(XML1), Document.class);
        document2 = JAXB.unmarshal(new StringReader(XML2), Document.class);
    }

    @Test
    public void shouldHasUrl() {
        assertEquals("http://www.samplepdf.com/sample.pdf", document1.getUrl());
    }

    @Test
    public void shouldHasName() {
        assertEquals("sample-presentation.pdf", document2.getName());
    }

    @Test
    public void shouldHasContent() {
        assertEquals("JVBERi0xLjQKJ....  [clipped here]  ....0CiUlRU9GCg==", document2.getValue());
    }

}