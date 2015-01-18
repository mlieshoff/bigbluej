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
public class JoinCommand {

    private final String fullName;
    private final String meetingID;
    private final String password;
    private final Long createTime;
    private final String userId;
    private final String webConfigConf;
    private final String configToken;
    private final String avatarURL;
    private final boolean redirectClient;
    private final String clientURL;

    public JoinCommand(String fullName, String meetingID, String password, Long createTime, String userId, String webConfigConf, String configToken,
            String avatarURL, boolean redirectClient, String clientURL) {
        Validate.notEmpty(fullName, "fullName");
        Validate.notEmpty(meetingID, "meetingID");
        Validate.notEmpty(password, "password");
        this.fullName = fullName;
        this.meetingID = meetingID;
        this.password = password;
        this.createTime = createTime;
        this.userId = userId;
        this.webConfigConf = webConfigConf;
        this.configToken = configToken;
        this.avatarURL = avatarURL;
        this.redirectClient = redirectClient;
        this.clientURL = clientURL;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getFullName() {
        return fullName;
    }

    public String getMeetingID() {
        return meetingID;
    }

    public long getCreateTime() {
        return createTime;
    }

    public String getPassword() {
        return password;
    }

    public String getUserId() {
        return userId;
    }

    public String getWebConfigConf() {
        return webConfigConf;
    }

    public String getConfigToken() {
        return configToken;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public boolean isRedirectClient() {
        return redirectClient;
    }

    public String getClientURL() {
        return clientURL;
    }

    public static class Builder {

        private String fullName;
        private String meetingID;
        private String password;
        private Long createTime;
        private String userId;
        private String webConfigConf;
        private String configToken;
        private String avatarURL;
        private boolean redirectClient;
        private String clientURL;

        public JoinCommand build() {
            return new JoinCommand(fullName, meetingID, password, createTime, userId, webConfigConf, configToken, avatarURL, redirectClient,
                    clientURL);
        }

        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder meetingID(String meetingID) {
            this.meetingID = meetingID;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder createTime(Long createTime) {
            this.createTime = createTime;
            return this;
        }

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder webConfigConf(String webConfigConf) {
            this.webConfigConf = webConfigConf;
            return this;
        }

        public Builder configToken(String configToken) {
            this.configToken = configToken;
            return this;
        }

        public Builder avatarURL(String avatarURL) {
            this.avatarURL = avatarURL;
            return this;
        }

        public Builder redirectClient(boolean redirectClient) {
            this.redirectClient = redirectClient;
            return this;
        }

        public Builder clientURL(String clientURL) {
            this.clientURL = clientURL;
            return this;
        }
    }

}
