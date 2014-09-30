/*
 * @(#)TeamCoreSettings.java
 * Product: Caty
 * Version: 4
 * Copyright 2006 by i-TEC hanshin, Inc., All rights reserved.
 */
package org.apache.maven.plugin.eclipse;

import java.util.List;
import java.util.ArrayList;

/**
 * Date: 2006/08/25
 * Time: 10:03:48
 *
 * @author yamada
 */
public class TeamCoreSettings {

    private boolean enabled = false;

    private List ignoreFiles = new ArrayList();

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List getIgnoreFiles() {
        return ignoreFiles;
    }

    public void setIgnoreFiles(List ignoreFiles) {
        this.ignoreFiles = ignoreFiles;
    }
}
