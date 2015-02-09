package bigbluej.config;

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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author Michael Lieshoff
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Lock {

    @XmlAttribute(name = "allowModeratorLocking")
    private boolean allowModeratorLocking;

    @XmlAttribute(name = "disableCamForLockedUsers")
    private boolean disableCamForLockedUsers;

    @XmlAttribute(name = "disableMicForLockedUsers")
    private boolean disableMicForLockedUsers;

    @XmlAttribute(name = "disablePrivateChatForLockedUsers")
    private String disablePrivateChatForLockedUsers;

    @XmlAttribute(name = "disablePublicChatForLockedUsers")
    private boolean disablePublicChatForLockedUsers;

    @XmlAttribute(name = "lockLayoutForLockedUsers")
    private boolean lockLayoutForLockedUsers;

    public boolean isAllowModeratorLocking() {
        return allowModeratorLocking;
    }

    public void setAllowModeratorLocking(boolean allowModeratorLocking) {
        this.allowModeratorLocking = allowModeratorLocking;
    }

    public boolean isDisableCamForLockedUsers() {
        return disableCamForLockedUsers;
    }

    public void setDisableCamForLockedUsers(boolean disableCamForLockedUsers) {
        this.disableCamForLockedUsers = disableCamForLockedUsers;
    }

    public boolean isDisableMicForLockedUsers() {
        return disableMicForLockedUsers;
    }

    public void setDisableMicForLockedUsers(boolean disableMicForLockedUsers) {
        this.disableMicForLockedUsers = disableMicForLockedUsers;
    }

    public String getDisablePrivateChatForLockedUsers() {
        return disablePrivateChatForLockedUsers;
    }

    public void setDisablePrivateChatForLockedUsers(String disablePrivateChatForLockedUsers) {
        this.disablePrivateChatForLockedUsers = disablePrivateChatForLockedUsers;
    }

    public boolean isDisablePublicChatForLockedUsers() {
        return disablePublicChatForLockedUsers;
    }

    public void setDisablePublicChatForLockedUsers(boolean disablePublicChatForLockedUsers) {
        this.disablePublicChatForLockedUsers = disablePublicChatForLockedUsers;
    }

    public boolean isLockLayoutForLockedUsers() {
        return lockLayoutForLockedUsers;
    }

    public void setLockLayoutForLockedUsers(boolean lockLayoutForLockedUsers) {
        this.lockLayoutForLockedUsers = lockLayoutForLockedUsers;
    }

}
