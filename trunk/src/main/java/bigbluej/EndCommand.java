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

/**
 * @author Michael Lieshoff
 */
public class EndCommand {

    private final String meetingID;
    private final String password;

    public EndCommand(String meetingID, String password) {
        Validate.notEmpty(meetingID, "meetingID");
        Validate.notEmpty(password, "password");
        this.meetingID = meetingID;
        this.password = password;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getMeetingID() {
        return meetingID;
    }

    public String getPassword() {
        return password;
    }

    public static class Builder {

        private String meetingID;
        private String password;

        public EndCommand build() {
            return new EndCommand(meetingID, password);
        }

        public Builder meetingID(String meetingID) {
            this.meetingID = meetingID;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

    }

}
