/*
 * @(#)TomcatPluginProjectSettings.java
 * Product: Caty
 * Version: 4
 * Copyright 2006 by i-TEC hanshin, Inc., All rights reserved.
 */
package org.apache.maven.plugin.eclipse;

/**
 * Date: 2006/08/24
 * Time: 21:47:58
 *
 * @author yamada
 */
public class TomcatPluginProjectSettings {

    private boolean enabled = false;

    private String fixTomcatHomeBug = "fixed";

    private String contextsDir;

    private String tomcatDir;

    private String configMode;

    private String jvmParameters;

    private String tomcatJRE;

    private String tomcatConfigFile;

    private String eclipsePreferenceVersion;

    private String tomcatVersion;

    private String managerUrl;

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getFixTomcatHomeBug() {
        return fixTomcatHomeBug;
    }

    public void setFixTomcatHomeBug(String fixTomcatHomeBug) {
        this.fixTomcatHomeBug = fixTomcatHomeBug;
    }

    public String getContextsDir() {
        return contextsDir;
    }

    public void setContextsDir(String contextsDir) {
        this.contextsDir = contextsDir;
    }

    public String getTomcatDir() {
        return tomcatDir;
    }

    public void setTomcatDir(String tomcatDir) {
        this.tomcatDir = tomcatDir;
    }

    public String getConfigMode() {
        return configMode;
    }

    public void setConfigMode(String configMode) {
        this.configMode = configMode;
    }

    public String getJvmParameters() {
        return jvmParameters;
    }

    public void setJvmParameters(String jvmParameters) {
        this.jvmParameters = jvmParameters;
    }

    public String getTomcatJRE() {
        return tomcatJRE;
    }

    public void setTomcatJRE(String tomcatJRE) {
        this.tomcatJRE = tomcatJRE;
    }

    public String getTomcatConfigFile() {
        return tomcatConfigFile;
    }

    public void setTomcatConfigFile(String tomcatConfigFile) {
        this.tomcatConfigFile = tomcatConfigFile;
    }

    public String getEclipsePreferenceVersion() {
        return eclipsePreferenceVersion;
    }

    public void setEclipsePreferenceVersion(String eclipsePreferenceVersion) {
        this.eclipsePreferenceVersion = eclipsePreferenceVersion;
    }

    public String getTomcatVersion() {
        return tomcatVersion;
    }

    public void setTomcatVersion(String tomcatVersion) {
        this.tomcatVersion = tomcatVersion;
    }

    public String getManagerUrl() {
        return managerUrl;
    }

    public void setManagerUrl(String managerUrl) {
        this.managerUrl = managerUrl;
    }
}
