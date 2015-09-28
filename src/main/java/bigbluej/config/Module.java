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

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author Michael Lieshoff
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Module {

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "url")
    private String url;

    @XmlAttribute(name = "uri")
    private String uri;

    @XmlAttribute(name = "dependsOn")
    private String dependsOn;

    @XmlAttribute(name = "privateEnabled")
    private boolean privateEnabled;

    @XmlAttribute(name = "fontSize")
    private String fontSize;

    @XmlAttribute(name = "position")
    private String position;

    @XmlAttribute(name = "baseTabIndex")
    private int baseTabIndex;

    @XmlAttribute(name = "colorPickerIsVisible")
    private boolean colorPickerIsVisible;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getDependsOn() {
        return dependsOn;
    }

    public void setDependsOn(String dependsOn) {
        this.dependsOn = dependsOn;
    }

    public boolean isPrivateEnabled() {
        return privateEnabled;
    }

    public void setPrivateEnabled(boolean privateEnabled) {
        this.privateEnabled = privateEnabled;
    }

    public String getFontSize() {
        return fontSize;
    }

    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getBaseTabIndex() {
        return baseTabIndex;
    }

    public void setBaseTabIndex(int baseTabIndex) {
        this.baseTabIndex = baseTabIndex;
    }

    public boolean isColorPickerIsVisible() {
        return colorPickerIsVisible;
    }

    public void setColorPickerIsVisible(boolean colorPickerIsVisible) {
        this.colorPickerIsVisible = colorPickerIsVisible;
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
