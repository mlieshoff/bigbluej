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
public class CreateCommand {

    private final String name;
    private final String meetingID;
    private final String attendeePW;
    private final String moderatorPW;
    private final String welcome;
    private final String dialNumber;
    private final String voiceBridge;
    private final String webVoice;
    private final String logoutURL;
    private final boolean record;
    private final int duration;
    private final String meta;

    private CreateCommand(String name, String meetingID, String attendeePW, String moderatorPW, String welcome, String dialNumber, String voiceBridge,
            String webVoice, String logoutURL, boolean record, int duration, String meta) {
        Validate.notEmpty(meetingID);
        this.name = name;
        this.meetingID = meetingID;
        this.attendeePW = attendeePW;
        this.moderatorPW = moderatorPW;
        this.welcome = welcome;
        this.dialNumber = dialNumber;
        this.voiceBridge = voiceBridge;
        this.webVoice = webVoice;
        this.logoutURL = logoutURL;
        this.record = record;
        this.duration = duration;
        this.meta = meta;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public String getMeetingID() {
        return meetingID;
    }

    public String getAttendeePW() {
        return attendeePW;
    }

    public String getModeratorPW() {
        return moderatorPW;
    }

    public String getWelcome() {
        return welcome;
    }

    public String getDialNumber() {
        return dialNumber;
    }

    public String getVoiceBridge() {
        return voiceBridge;
    }

    public String getWebVoice() {
        return webVoice;
    }

    public String getLogoutURL() {
        return logoutURL;
    }

    public boolean isRecord() {
        return record;
    }

    public int getDuration() {
        return duration;
    }

    public String getMeta() {
        return meta;
    }

    public static class Builder {

        private String name;
        private String meetingID;
        private String attendeePW;
        private String moderatorPW;
        private String welcome;
        private String dialNumber;
        private String voiceBridge;
        private String webVoice;
        private String logoutURL;
        private boolean record;
        private int duration;
        private String meta;

        private Builder() {
        }

        public CreateCommand build() {
            return new CreateCommand(name, meetingID, attendeePW, moderatorPW, welcome, dialNumber, voiceBridge, webVoice, logoutURL, record,
                    duration, meta);
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder meetingID(String meetingID) {
            this.meetingID = meetingID;
            return this;
        }

        public Builder attendeePW(String attendeePW) {
            this.attendeePW = attendeePW;
            return this;
        }

        public Builder moderatorPW(String moderatorPW) {
            this.moderatorPW = moderatorPW;
            return this;
        }

        public Builder welcome(String welcome) {
            this.welcome = welcome;
            return this;
        }

        public Builder dialNumber(String dialNumber) {
            this.dialNumber = dialNumber;
            return this;
        }

        public Builder voiceBridge(String voiceBridge) {
            this.voiceBridge = voiceBridge;
            return this;
        }

        public Builder webVoice(String webVoice) {
            this.webVoice = webVoice;
            return this;
        }

        public Builder logoutURL(String logoutURL) {
            this.logoutURL = logoutURL;
            return this;
        }

        public Builder record(boolean record) {
            this.record = record;
            return this;
        }

        public Builder duration(int duration) {
            this.duration = duration;
            return this;
        }

        public Builder meta(String meta) {
            this.meta = meta;
            return this;
        }

    }
}
