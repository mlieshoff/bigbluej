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

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * @author Michael Lieshoff
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class GetMeetingInfoResponse extends Response {

    @XmlElement(name = "meetingName")
    private String meetingName;

    @XmlElement(name = "meetingID")
    private String meetingID;

    @XmlElement(name = "createTime")
    private long createTime;

    @XmlElement(name = "voiceBridge")
    private String voiceBridge;

    @XmlElement(name = "attendeePW")
    private String attendeePW;

    @XmlElement(name = "moderatorPW")
    private String moderatorPW;

    @XmlElement(name = "running")
    private boolean running;

    @XmlElement(name = "recording")
    private boolean recording;

    @XmlElement(name = "hasBeenForciblyEnded")
    private boolean hasBeenForciblyEnded;

    @XmlElement(name = "startTime")
    private long startTime;

    @XmlElement(name = "endTime")
    private long endTime;

    @XmlElement(name = "participantCount")
    private int participantCount;

    @XmlElement(name = "maxUsers")
    private int maxUsers;

    @XmlElement(name = "moderatorCount")
    private int moderatorCount;

    @XmlElementWrapper(name = "attendees")
    @XmlElement(name = "attendee")
    private List<Attendee> attendees;

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }

    public String getMeetingID() {
        return meetingID;
    }

    public void setMeetingID(String meetingID) {
        this.meetingID = meetingID;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getVoiceBridge() {
        return voiceBridge;
    }

    public void setVoiceBridge(String voiceBridge) {
        this.voiceBridge = voiceBridge;
    }

    public String getAttendeePW() {
        return attendeePW;
    }

    public void setAttendeePW(String attendeePW) {
        this.attendeePW = attendeePW;
    }

    public String getModeratorPW() {
        return moderatorPW;
    }

    public void setModeratorPW(String moderatorPW) {
        this.moderatorPW = moderatorPW;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isRecording() {
        return recording;
    }

    public void setRecording(boolean recording) {
        this.recording = recording;
    }

    public boolean isHasBeenForciblyEnded() {
        return hasBeenForciblyEnded;
    }

    public void setHasBeenForciblyEnded(boolean hasBeenForciblyEnded) {
        this.hasBeenForciblyEnded = hasBeenForciblyEnded;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public int getParticipantCount() {
        return participantCount;
    }

    public void setParticipantCount(int participantCount) {
        this.participantCount = participantCount;
    }

    public int getMaxUsers() {
        return maxUsers;
    }

    public void setMaxUsers(int maxUsers) {
        this.maxUsers = maxUsers;
    }

    public int getModeratorCount() {
        return moderatorCount;
    }

    public void setModeratorCount(int moderatorCount) {
        this.moderatorCount = moderatorCount;
    }

    public List<Attendee> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<Attendee> attendees) {
        this.attendees = attendees;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(17, 31, this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
