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

/**
 * @author Michael Lieshoff
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Meeting {

    @XmlElement(name = "meetingID")
    private String meetingID;

    @XmlElement(name = "meetingName")
    private String meetingName;

    @XmlElement(name = "attendeePW")
    private String attendeePW;

    @XmlElement(name = "moderatorPW")
    private String moderatorPW;

    @XmlElement(name = "createTime")
    private long createTime;

    @XmlElement(name = "hasUserJoined")
    private boolean hasUserJoined;

    @XmlElement(name = "duration")
    private int duration;

    @XmlElement(name = "hasBeenForcibleEnded")
    private boolean hasBeenForcibleEnded;

    @XmlElement(name = "running")
    private boolean running;

    public String getMeetingID() {
        return meetingID;
    }

    public void setMeetingID(String meetingID) {
        this.meetingID = meetingID;
    }

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
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

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public boolean isHasUserJoined() {
        return hasUserJoined;
    }

    public void setHasUserJoined(boolean hasUserJoined) {
        this.hasUserJoined = hasUserJoined;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isHasBeenForcibleEnded() {
        return hasBeenForcibleEnded;
    }

    public void setHasBeenForcibleEnded(boolean hasBeenForcibleEnded) {
        this.hasBeenForcibleEnded = hasBeenForcibleEnded;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Meeting meeting = (Meeting) o;

        if (createTime != meeting.createTime) return false;
        if (duration != meeting.duration) return false;
        if (hasBeenForcibleEnded != meeting.hasBeenForcibleEnded) return false;
        if (hasUserJoined != meeting.hasUserJoined) return false;
        if (running != meeting.running) return false;
        if (attendeePW != null ? !attendeePW.equals(meeting.attendeePW) : meeting.attendeePW != null) return false;
        if (meetingID != null ? !meetingID.equals(meeting.meetingID) : meeting.meetingID != null) return false;
        if (meetingName != null ? !meetingName.equals(meeting.meetingName) : meeting.meetingName != null) return false;
        if (moderatorPW != null ? !moderatorPW.equals(meeting.moderatorPW) : meeting.moderatorPW != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = meetingID != null ? meetingID.hashCode() : 0;
        result = 31 * result + (meetingName != null ? meetingName.hashCode() : 0);
        result = 31 * result + (attendeePW != null ? attendeePW.hashCode() : 0);
        result = 31 * result + (moderatorPW != null ? moderatorPW.hashCode() : 0);
        result = 31 * result + (int) (createTime ^ (createTime >>> 32));
        result = 31 * result + (hasUserJoined ? 1 : 0);
        result = 31 * result + duration;
        result = 31 * result + (hasBeenForcibleEnded ? 1 : 0);
        result = 31 * result + (running ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "meetingID='" + meetingID + '\'' +
                ", meetingName='" + meetingName + '\'' +
                ", attendeePW='" + attendeePW + '\'' +
                ", moderatorPW='" + moderatorPW + '\'' +
                ", createTime=" + createTime +
                ", hasUserJoined=" + hasUserJoined +
                ", duration=" + duration +
                ", hasBeenForcibleEnded=" + hasBeenForcibleEnded +
                ", running=" + running +
                '}';
    }

}
