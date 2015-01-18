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

    @XmlElement(name = "attendeePW")
    private String attendeePW;

    @XmlElement(name = "moderatorPW")
    private String moderatorPW;

    @XmlElement(name = "createTime")
    private long createTime;

    @XmlElement(name = "createDate")
    private String createDate;

    @XmlElement(name = "hasUserJoined")
    private boolean hasUserJoined;

    @XmlElement(name = "duration")
    private int duration;

    @XmlElement(name = "hasBeenForcibleEnded")
    private boolean hasBeenForcibleEnded;

    public String getMeetingID() {
        return meetingID;
    }

    public void setMeetingID(String meetingID) {
        this.meetingID = meetingID;
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Meeting that = (Meeting) o;

        if (createTime != that.createTime) return false;
        if (duration != that.duration) return false;
        if (hasBeenForcibleEnded != that.hasBeenForcibleEnded) return false;
        if (hasUserJoined != that.hasUserJoined) return false;
        if (attendeePW != null ? !attendeePW.equals(that.attendeePW) : that.attendeePW != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (meetingID != null ? !meetingID.equals(that.meetingID) : that.meetingID != null) return false;
        if (moderatorPW != null ? !moderatorPW.equals(that.moderatorPW) : that.moderatorPW != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (meetingID != null ? meetingID.hashCode() : 0);
        result = 31 * result + (attendeePW != null ? attendeePW.hashCode() : 0);
        result = 31 * result + (moderatorPW != null ? moderatorPW.hashCode() : 0);
        result = 31 * result + (int) (createTime ^ (createTime >>> 32));
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (hasUserJoined ? 1 : 0);
        result = 31 * result + duration;
        result = 31 * result + (hasBeenForcibleEnded ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MeetingResponse{" +
                "meetingID='" + meetingID + '\'' +
                ", attendeePW='" + attendeePW + '\'' +
                ", moderatorPW='" + moderatorPW + '\'' +
                ", createTime=" + createTime +
                ", createDate='" + createDate + '\'' +
                ", hasUserJoined=" + hasUserJoined +
                ", duration=" + duration +
                ", hasBeenForcibleEnded=" + hasBeenForcibleEnded +
                '}';
    }

}
