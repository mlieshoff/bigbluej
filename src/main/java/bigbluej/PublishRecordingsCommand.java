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
public class PublishRecordingsCommand {

    private final String recordID;
    private final boolean publish;

    public PublishRecordingsCommand(String recordID, boolean publish) {
        Validate.notEmpty(recordID, "recordID");
        this.recordID = recordID;
        this.publish = publish;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getRecordID() {
        return recordID;
    }

    public boolean isPublish() {
        return publish;
    }

    public static class Builder {

        private String recordID;
        private boolean publish;

        public PublishRecordingsCommand.Builder recordID(String recordID) {
            this.recordID = recordID;
            return this;
        }

        public PublishRecordingsCommand.Builder publish(boolean publish) {
            this.publish = publish;
            return this;
        }

        public PublishRecordingsCommand build() {
            return new PublishRecordingsCommand(recordID, publish);
        }

    }

}
