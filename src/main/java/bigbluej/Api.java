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

import bigbluej.config.Config;
import bigbluej.exception.ApiException;
import org.apache.commons.lang.Validate;

import javax.servlet.ServletResponse;

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

    public MeetingResponse createMeeting(CreateCommand createCommand) {
        try {
            return client.createMeeting(createCommand);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public MeetingResponse createMeeting(CreateCommand createCommand, ModulesCommand modulesCommand) {
        try {
            return client.createMeeting(createCommand, modulesCommand);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public void joinMeeting(ServletResponse servletResponse, JoinCommand joinCommand) {
        try {
            client.joinMeeting(servletResponse, joinCommand);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public IsMeetingRunningResponse isMeetingRunning(IsMeetingRunningCommand isMeetingRunningCommand) {
        try {
            return client.isMeetingRunning(isMeetingRunningCommand);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public EndResponse end(EndCommand endCommand) {
        try {
            return client.end(endCommand);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public GetMeetingInfoResponse getMeetingInfo(GetMeetingInfoCommand getMeetingInfoCommand) {
        try {
            return client.getMeetingInfo(getMeetingInfoCommand);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public GetMeetingsResponse getMeetings() {
        try {
            return client.getMeetings();
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public GetRecordingsResponse getRecordings(GetRecordingsCommand getRecordingsCommand) {
        try {
            return client.getRecordings(getRecordingsCommand);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public PublishRecordingsResponse publishRecordings(PublishRecordingsCommand publishRecordingsCommand) {
        try {
            return client.publishRecordings(publishRecordingsCommand);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public DeleteRecordingsResponse deleteRecordings(DeleteRecordingsCommand deleteRecordingsCommand) {
        try {
            return client.deleteRecordings(deleteRecordingsCommand);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public Config getDefaultConfigXML() {
        try {
            return client.getDefaultConfigXML();
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public SetConfigXMLResponse setConfigXML(SetConfigXMLCommand setConfigXMLCommand) {
        try {
            return client.setConfigXML(setConfigXMLCommand);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public String getJoinMeetingUrl(JoinCommand joinCommand) {
        try {
            return client.getJoinMeetingUrl(joinCommand);
        } catch (Exception e) {
            throw new ApiException(e);
        }
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

}