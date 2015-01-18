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

import org.apache.commons.lang.Validate;

import javax.xml.bind.JAXB;
import java.io.StringReader;

/**
 * @author Michael Lieshoff
 */
public class Api {

    private Client client;

    private Api(String url, String sharedSecret) {
        Validate.notEmpty(url);
        Validate.notEmpty(sharedSecret);
        client = new Client(url, sharedSecret);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String url;
        private String sharedSecret;

        private Builder() {
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder sharedSecret(String sharedSecret) {
            this.sharedSecret = sharedSecret;
            return this;
        }

        public Api build() {
            return new Api(url, sharedSecret);
        }

    }

    public MeetingResponse createMeeting(CreateCommand createCommand) throws Exception {
        return fromXml(MeetingResponse.class, client.createMeeting(createCommand));
    }

    private <T> T fromXml(Class<T> clazz, String input) {
        System.out.println("xml> " + input);
        return JAXB.unmarshal(new StringReader(input), clazz);
    }

    public MeetingsResponse getMeetings() throws Exception {
        return fromXml(MeetingsResponse.class, client.getMeetings());
    }

}