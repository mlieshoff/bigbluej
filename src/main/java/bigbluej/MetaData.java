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
public class MetaData {

    @XmlElement(name = "title")
    private String title;

    @XmlElement(name = "subject")
    private String subject;

    @XmlElement(name = "description")
    private String description;

    @XmlElement(name = "creator")
    private String creator;

    @XmlElement(name = "contributor")
    private String contributor;

    @XmlElement(name = "language")
    private String language;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getContributor() {
        return contributor;
    }

    public void setContributor(String contributor) {
        this.contributor = contributor;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaData metaData = (MetaData) o;

        if (contributor != null ? !contributor.equals(metaData.contributor) : metaData.contributor != null) return false;
        if (creator != null ? !creator.equals(metaData.creator) : metaData.creator != null) return false;
        if (description != null ? !description.equals(metaData.description) : metaData.description != null) return false;
        if (language != null ? !language.equals(metaData.language) : metaData.language != null) return false;
        if (subject != null ? !subject.equals(metaData.subject) : metaData.subject != null) return false;
        if (title != null ? !title.equals(metaData.title) : metaData.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        result = 31 * result + (contributor != null ? contributor.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MetaData{" +
                "title='" + title + '\'' +
                ", subject='" + subject + '\'' +
                ", description='" + description + '\'' +
                ", creator='" + creator + '\'' +
                ", contributor='" + contributor + '\'' +
                ", language='" + language + '\'' +
                '}';
    }

}
