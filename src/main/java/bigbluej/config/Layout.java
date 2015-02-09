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
public class Layout {

    @XmlAttribute(name = "showLogButton")
    private boolean showLogButton;

    @XmlAttribute(name = "showVideoLayout")
    private boolean showVideoLayout;

    @XmlAttribute(name = "showResetLayout")
    private boolean showResetLayout;

    @XmlAttribute(name = "defaultLayout")
    private String defaultLayout;

    @XmlAttribute(name = "showToolbar")
    private boolean showToolbar;

    @XmlAttribute(name = "showFooter")
    private boolean showFooter;

    @XmlAttribute(name = "showMeetingName")
    private boolean showMeetingName;

    @XmlAttribute(name = "showHelpButton")
    private boolean showHelpButton;

    @XmlAttribute(name = "showLogoutWindow")
    private boolean showLogoutWindow;

    @XmlAttribute(name = "showLayoutTools")
    private boolean showLayoutTools;

    @XmlAttribute(name = "showNetworkMonitor")
    private boolean showNetworkMonitor;

    @XmlAttribute(name = "confirmLogout")
    private boolean confirmLogout;

    @XmlAttribute(name = "showRecordingNotification")
    private boolean showRecordingNotification;

    public boolean isShowLogButton() {
        return showLogButton;
    }

    public void setShowLogButton(boolean showLogButton) {
        this.showLogButton = showLogButton;
    }

    public boolean isShowVideoLayout() {
        return showVideoLayout;
    }

    public void setShowVideoLayout(boolean showVideoLayout) {
        this.showVideoLayout = showVideoLayout;
    }

    public boolean isShowResetLayout() {
        return showResetLayout;
    }

    public void setShowResetLayout(boolean showResetLayout) {
        this.showResetLayout = showResetLayout;
    }

    public String getDefaultLayout() {
        return defaultLayout;
    }

    public void setDefaultLayout(String defaultLayout) {
        this.defaultLayout = defaultLayout;
    }

    public boolean isShowToolbar() {
        return showToolbar;
    }

    public void setShowToolbar(boolean showToolbar) {
        this.showToolbar = showToolbar;
    }

    public boolean isShowFooter() {
        return showFooter;
    }

    public void setShowFooter(boolean showFooter) {
        this.showFooter = showFooter;
    }

    public boolean isShowMeetingName() {
        return showMeetingName;
    }

    public void setShowMeetingName(boolean showMeetingName) {
        this.showMeetingName = showMeetingName;
    }

    public boolean isShowHelpButton() {
        return showHelpButton;
    }

    public void setShowHelpButton(boolean showHelpButton) {
        this.showHelpButton = showHelpButton;
    }

    public boolean isShowLogoutWindow() {
        return showLogoutWindow;
    }

    public void setShowLogoutWindow(boolean showLogoutWindow) {
        this.showLogoutWindow = showLogoutWindow;
    }

    public boolean isShowLayoutTools() {
        return showLayoutTools;
    }

    public void setShowLayoutTools(boolean showLayoutTools) {
        this.showLayoutTools = showLayoutTools;
    }

    public boolean isShowNetworkMonitor() {
        return showNetworkMonitor;
    }

    public void setShowNetworkMonitor(boolean showNetworkMonitor) {
        this.showNetworkMonitor = showNetworkMonitor;
    }

    public boolean isConfirmLogout() {
        return confirmLogout;
    }

    public void setConfirmLogout(boolean confirmLogout) {
        this.confirmLogout = confirmLogout;
    }

    public boolean isShowRecordingNotification() {
        return showRecordingNotification;
    }

    public void setShowRecordingNotification(boolean showRecordingNotification) {
        this.showRecordingNotification = showRecordingNotification;
    }

}
