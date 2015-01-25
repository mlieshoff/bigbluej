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

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

/**
 * @author Michael Lieshoff
 */
public class DocumentCommand {

    private final String url;
    private final String name;
    private final byte[] content;

    private DocumentCommand(String url, String name, byte[] content) {
        if (StringUtils.isNotBlank(url)) {
            Validate.isTrue(ArrayUtils.isEmpty(content), "when set url, don't set content too!");
            Validate.isTrue(StringUtils.isBlank(name), "when set url, don't set name too!");
        } else if (StringUtils.isNotBlank(name)) {
            Validate.isTrue(ArrayUtils.isNotEmpty(content), "when set name, set content too!");
            Validate.isTrue(StringUtils.isBlank(url), "when set name, don't set url too!");
        } else {
            throw new IllegalArgumentException("set either name or url!");
        }
        this.url = url;
        this.name = name;
        this.content = content;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public byte[] getContent() {
        return content;
    }

    public static class Builder {

        private String url;
        private String name;
        private byte[] content;

        private Builder() {
        }

        public DocumentCommand build() {
            return new DocumentCommand(url, name, content);
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder content(byte[] content) {
            this.content = content;
            return this;
        }
    }

}
