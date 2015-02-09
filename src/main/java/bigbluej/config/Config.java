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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author Michael Lieshoff
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "config")
public class Config {

    @XmlElement(name = "localeversion")
    private LocaleVersion localeVersion;

    @XmlElement(name = "version")
    private Version version;

    @XmlElement(name = "help")
    private Help help;

    @XmlElement(name = "javaTest")
    private JavaTest javaTest;

    @XmlElement(name = "porttest")
    private PortTest portTest;

    @XmlElement(name = "bwMon")
    private BwMon bwMon;

    @XmlElement(name = "application")
    private Application application;

    @XmlElement(name = "language")
    private Language language;

    @XmlElement(name = "skinning")
    private Skinning skinning;

    @XmlElement(name = "shortcutKeys")
    private ShortcutKeys shortcutKeys;

    @XmlElement(name = "browserVersions")
    private BrowserVersions browserVersions;

    @XmlElement(name = "layout")
    private Layout layout;

    @XmlElement(name = "lock")
    private Lock lock;

    @XmlElementWrapper(name = "modules")
    @XmlElement(name = "module")
    private List<Module> modules;

    public LocaleVersion getLocaleVersion() {
        return localeVersion;
    }

    public void setLocaleVersion(LocaleVersion localeVersion) {
        this.localeVersion = localeVersion;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public Help getHelp() {
        return help;
    }

    public void setHelp(Help help) {
        this.help = help;
    }

    public JavaTest getJavaTest() {
        return javaTest;
    }

    public void setJavaTest(JavaTest javaTest) {
        this.javaTest = javaTest;
    }

    public PortTest getPortTest() {
        return portTest;
    }

    public void setPortTest(PortTest portTest) {
        this.portTest = portTest;
    }

    public BwMon getBwMon() {
        return bwMon;
    }

    public void setBwMon(BwMon bwMon) {
        this.bwMon = bwMon;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Skinning getSkinning() {
        return skinning;
    }

    public void setSkinning(Skinning skinning) {
        this.skinning = skinning;
    }

    public ShortcutKeys getShortcutKeys() {
        return shortcutKeys;
    }

    public void setShortcutKeys(ShortcutKeys shortcutKeys) {
        this.shortcutKeys = shortcutKeys;
    }

    public BrowserVersions getBrowserVersions() {
        return browserVersions;
    }

    public void setBrowserVersions(BrowserVersions browserVersions) {
        this.browserVersions = browserVersions;
    }

    public Layout getLayout() {
        return layout;
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Config)) return false;

        Config config = (Config) o;

        if (application != null ? !application.equals(config.application) : config.application != null) return false;
        if (browserVersions != null ? !browserVersions.equals(config.browserVersions) : config.browserVersions != null)
            return false;
        if (bwMon != null ? !bwMon.equals(config.bwMon) : config.bwMon != null) return false;
        if (help != null ? !help.equals(config.help) : config.help != null) return false;
        if (javaTest != null ? !javaTest.equals(config.javaTest) : config.javaTest != null) return false;
        if (language != null ? !language.equals(config.language) : config.language != null) return false;
        if (layout != null ? !layout.equals(config.layout) : config.layout != null) return false;
        if (localeVersion != null ? !localeVersion.equals(config.localeVersion) : config.localeVersion != null)
            return false;
        if (lock != null ? !lock.equals(config.lock) : config.lock != null) return false;
        if (modules != null ? !modules.equals(config.modules) : config.modules != null) return false;
        if (portTest != null ? !portTest.equals(config.portTest) : config.portTest != null) return false;
        if (shortcutKeys != null ? !shortcutKeys.equals(config.shortcutKeys) : config.shortcutKeys != null)
            return false;
        if (skinning != null ? !skinning.equals(config.skinning) : config.skinning != null) return false;
        if (version != null ? !version.equals(config.version) : config.version != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = localeVersion != null ? localeVersion.hashCode() : 0;
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (help != null ? help.hashCode() : 0);
        result = 31 * result + (javaTest != null ? javaTest.hashCode() : 0);
        result = 31 * result + (portTest != null ? portTest.hashCode() : 0);
        result = 31 * result + (bwMon != null ? bwMon.hashCode() : 0);
        result = 31 * result + (application != null ? application.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (skinning != null ? skinning.hashCode() : 0);
        result = 31 * result + (shortcutKeys != null ? shortcutKeys.hashCode() : 0);
        result = 31 * result + (browserVersions != null ? browserVersions.hashCode() : 0);
        result = 31 * result + (layout != null ? layout.hashCode() : 0);
        result = 31 * result + (lock != null ? lock.hashCode() : 0);
        result = 31 * result + (modules != null ? modules.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Config{" +
                "localeVersion=" + localeVersion +
                ", version=" + version +
                ", help=" + help +
                ", javaTest=" + javaTest +
                ", portTest=" + portTest +
                ", bwMon=" + bwMon +
                ", application=" + application +
                ", language=" + language +
                ", skinning=" + skinning +
                ", shortcutKeys=" + shortcutKeys +
                ", browserVersions=" + browserVersions +
                ", layout=" + layout +
                ", lock=" + lock +
                ", modules=" + modules +
                '}';
    }

}
