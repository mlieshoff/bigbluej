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
public class Recording {

    @XmlElement(name = "recordID")
    private String recordID;

    @XmlElement(name = "meetingID")
    private String meetingID;

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "published")
    private boolean published;

    @XmlElement(name = "startTime")
    private long startTime;

    @XmlElement(name = "endTime")
    private long endTime;

    @XmlElement(name = "metadata")
    private MetaData metaData;

    @XmlElement(name = "playback")
    private Playback playback;

    public String getRecordID() {
        return recordID;
    }

    public void setRecordID(String recordID) {
        this.recordID = recordID;
    }

    public String getMeetingID() {
        return meetingID;
    }

    public void setMeetingID(String meetingID) {
        this.meetingID = meetingID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
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

    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    public Playback getPlayback() {
        return playback;
    }

    public void setPlayback(Playback playback) {
        this.playback = playback;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recording recording = (Recording) o;

        if (endTime != recording.endTime) return false;
        if (published != recording.published) return false;
        if (startTime != recording.startTime) return false;
        if (meetingID != null ? !meetingID.equals(recording.meetingID) : recording.meetingID != null) return false;
        if (metaData != null ? !metaData.equals(recording.metaData) : recording.metaData != null) return false;
        if (name != null ? !name.equals(recording.name) : recording.name != null) return false;
        if (playback != null ? !playback.equals(recording.playback) : recording.playback != null) return false;
        if (recordID != null ? !recordID.equals(recording.recordID) : recording.recordID != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recordID != null ? recordID.hashCode() : 0;
        result = 31 * result + (meetingID != null ? meetingID.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (published ? 1 : 0);
        result = 31 * result + (int) (startTime ^ (startTime >>> 32));
        result = 31 * result + (int) (endTime ^ (endTime >>> 32));
        result = 31 * result + (metaData != null ? metaData.hashCode() : 0);
        result = 31 * result + (playback != null ? playback.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Recording{" +
                "recordID='" + recordID + '\'' +
                ", meetingID='" + meetingID + '\'' +
                ", name='" + name + '\'' +
                ", published=" + published +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", metaData=" + metaData +
                ", playback=" + playback +
                '}';
    }

}
