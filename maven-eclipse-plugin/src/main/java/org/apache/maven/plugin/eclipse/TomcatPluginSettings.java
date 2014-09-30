/*
 * @(#)TomcatPluginSettings.java
 */
package org.apache.maven.plugin.eclipse;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;

/**
 * Date: 2006/05/13
 * Time: 1:34:57
 *
 * @author yamada
 */
public class TomcatPluginSettings {

    private boolean enabled = false;

    private String reloadable;

    private String updateXml;

    private String redirectLogger;

    private String warLocation;

    private String rootDir;

    private String exportSource;

    private String extraInfo;

    private String webPath;

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getReloadable() {
        return reloadable;
    }

    public void setReloadable(String reloadable) {
        this.reloadable = reloadable;
    }

    public String getUpdateXml() {
        return updateXml;
    }

    public void setUpdateXml(String updateXml) {
        this.updateXml = updateXml;
    }

    public String getRedirectLogger() {
        return redirectLogger;
    }

    public void setRedirectLogger(String redirectLogger) {
        this.redirectLogger = redirectLogger;
    }

    public String getWarLocation() {
        return warLocation;
    }

    public void setWarLocation(String warLocation) {
        this.warLocation = warLocation;
    }

    public String getRootDir() {
        return rootDir;
    }

    public void setRootDir(String rootDir) {
        this.rootDir = rootDir;
    }

    public String getExportSource() {
        return exportSource;
    }

    public void setExportSource(String exportSource) {
        this.exportSource = exportSource;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public String getWebPath() {
        return webPath;
    }

    public void setWebPath(String webPath) {
        this.webPath = webPath;
    }

}
