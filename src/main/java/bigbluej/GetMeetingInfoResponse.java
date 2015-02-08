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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        GetMeetingInfoResponse that = (GetMeetingInfoResponse) o;

        if (createTime != that.createTime) return false;
        if (endTime != that.endTime) return false;
        if (hasBeenForciblyEnded != that.hasBeenForciblyEnded) return false;
        if (maxUsers != that.maxUsers) return false;
        if (moderatorCount != that.moderatorCount) return false;
        if (participantCount != that.participantCount) return false;
        if (recording != that.recording) return false;
        if (running != that.running) return false;
        if (startTime != that.startTime) return false;
        if (attendeePW != null ? !attendeePW.equals(that.attendeePW) : that.attendeePW != null) return false;
        if (attendees != null ? !attendees.equals(that.attendees) : that.attendees != null) return false;
        if (meetingID != null ? !meetingID.equals(that.meetingID) : that.meetingID != null) return false;
        if (meetingName != null ? !meetingName.equals(that.meetingName) : that.meetingName != null) return false;
        if (moderatorPW != null ? !moderatorPW.equals(that.moderatorPW) : that.moderatorPW != null) return false;
        if (voiceBridge != null ? !voiceBridge.equals(that.voiceBridge) : that.voiceBridge != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (meetingName != null ? meetingName.hashCode() : 0);
        result = 31 * result + (meetingID != null ? meetingID.hashCode() : 0);
        result = 31 * result + (int) (createTime ^ (createTime >>> 32));
        result = 31 * result + (voiceBridge != null ? voiceBridge.hashCode() : 0);
        result = 31 * result + (attendeePW != null ? attendeePW.hashCode() : 0);
        result = 31 * result + (moderatorPW != null ? moderatorPW.hashCode() : 0);
        result = 31 * result + (running ? 1 : 0);
        result = 31 * result + (recording ? 1 : 0);
        result = 31 * result + (hasBeenForciblyEnded ? 1 : 0);
        result = 31 * result + (int) (startTime ^ (startTime >>> 32));
        result = 31 * result + (int) (endTime ^ (endTime >>> 32));
        result = 31 * result + participantCount;
        result = 31 * result + maxUsers;
        result = 31 * result + moderatorCount;
        result = 31 * result + (attendees != null ? attendees.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GetMeetingInfoResponse{" +
                "meetingName='" + meetingName + '\'' +
                ", meetingID='" + meetingID + '\'' +
                ", createTime=" + createTime +
                ", voiceBridge='" + voiceBridge + '\'' +
                ", attendeePW='" + attendeePW + '\'' +
                ", moderatorPW='" + moderatorPW + '\'' +
                ", running=" + running +
                ", recording=" + recording +
                ", hasBeenForciblyEnded=" + hasBeenForciblyEnded +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", participantCount=" + participantCount +
                ", maxUsers=" + maxUsers +
                ", moderatorCount=" + moderatorCount +
                ", attendees=" + attendees +
                '}';
    }

}
