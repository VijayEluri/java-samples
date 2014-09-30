/*
 * @(#)EclipseMetadataWriter.java
 * Product: Caty
 * Version: 4
 * Copyright 2006 by i-TEC hanshin, Inc., All rights reserved.
 */
package org.apache.maven.plugin.eclipse.writers;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.eclipse.TomcatPluginProjectSettings;
import org.apache.maven.plugin.eclipse.TeamCoreSettings;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.project.MavenProject;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Iterator;

import com.sun.org.apache.xalan.internal.xsltc.cmdline.getopt.*;

/**
 * .metadata以下の設定ファイルの出力
 * Date: 2006/05/12
 * Time: 23:04:21
 *
 * @author yamada
 */
public class EclipseMetadataWriter extends AbstractEclipseResourceWriter {

    private MavenProject project;

    private Log log;

    private File eclipseProjectDir;

    private final String COMPILANCE_DEF = "org.eclipse.jdt.core.compiler.compliance=";
    private final String TARGET_PLATFORM_DEF = "org.eclipse.jdt.core.compiler.codegen.targetPlatform=";
    private final String SOURCE_DEF = "org.eclipse.jdt.core.compiler.source=";
    private final String ENUM_IDENTIFIER_DEF = "org.eclipse.jdt.core.compiler.problem.enumIdentifier=";
    private final String ASSERT_IDENTIFIER_DEF = "org.eclipse.jdt.core.compiler.problem.assertIdentifier=";

    private final String MAVEN_LOCAL_REPO_DEF = "org.eclipse.jdt.core.classpathVariable.M2_REPO=";

    private final String METADATA_DIRECTORY_NAME  = ".metadata";

    private final String ECLIPSE_CORE_RUNTIME_SETTINGS_DIRECTORY_NAME = ".plugins/org.eclipse.core.runtime/.settings";

    private final String JDT_CORE_PREFS_FILE_NAME = "org.eclipse.jdt.core.prefs";
	
    private final String UI_EDITORS_PREFS_FILE_NAME = "org.eclipse.ui.editors.prefs";

    private final String TOMCAT_PLUGIN_PREFS_FILE_NAME = "com.sysdeo.eclipse.tomcat.prefs";

    private final String TEAM_CORE_PREFS_FILE_NAME = "org.eclipse.team.core.prefs";

    /**
     * 初期化
     * @param log
     * @param eclipseProjectDir
     * @param project
     */
    public EclipseMetadataWriter(Log log, File eclipseProjectDir, MavenProject project) {
        super(log, eclipseProjectDir, project);
        this.log = log;
        this.eclipseProjectDir = eclipseProjectDir;
        this.project = project;
    }

    /**
     * 出力
     * @throws MojoExecutionException
     */
    public void write(Map paramMap) throws MojoExecutionException {

        String fileSeparator = System.getProperty("file.separator");

        File jdtCorePrefsDirecotryName = new File(METADATA_DIRECTORY_NAME + "/" + ECLIPSE_CORE_RUNTIME_SETTINGS_DIRECTORY_NAME);

        jdtCorePrefsDirecotryName.mkdirs();

        writeCorePrefs();
    	writeUiEditorsPrefs();
        writeTomcatPluginPrefs((TomcatPluginProjectSettings) paramMap.get("TomcatPluginProjectPrefs"));
        writeTeamCorePrefs((TeamCoreSettings) paramMap.get("TeamCorePrefs"));

    }

    /**
     * org.eclipse.jdt.core.prefsの設定を出力
     * @throws MojoExecutionException
     */
    private void writeCorePrefs() throws MojoExecutionException{

        File jdtCorePrefsFileName = new File(METADATA_DIRECTORY_NAME + "/" + ECLIPSE_CORE_RUNTIME_SETTINGS_DIRECTORY_NAME + "/" + JDT_CORE_PREFS_FILE_NAME);

        if (!jdtCorePrefsFileName.exists()) {
            try {
                jdtCorePrefsFileName.createNewFile();
            } catch (IOException e) {
                throw new MojoExecutionException(JDT_CORE_PREFS_FILE_NAME + " failed", e);
            }
        }

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream(jdtCorePrefsFileName)));

            //javaバージョン
            writer.println(COMPILANCE_DEF + System.getProperty("java.specification.version"));
            writer.println(TARGET_PLATFORM_DEF + System.getProperty("java.specification.version"));
            writer.println(SOURCE_DEF + System.getProperty("java.specification.version"));
            writer.println(ENUM_IDENTIFIER_DEF + "error");
            writer.println(ASSERT_IDENTIFIER_DEF + "error");

            //M2_REPO環境変数(Windows用)
            writer.println(MAVEN_LOCAL_REPO_DEF + "C\\:/Documents and Settings/" + System.getProperty("user.name") + "/.m2/repository");

        } catch (FileNotFoundException e) {
            throw new MojoExecutionException(JDT_CORE_PREFS_FILE_NAME + " write failed", e);
        } finally {
            writer.close();
        }
    }

    /**
     * org.eclipse.ui.editors.prefsの設定を出力
     * @throws MojoExecutionException
     */
    private void writeUiEditorsPrefs() throws MojoExecutionException{

        File uiEditorsPrefsFileName = new File(METADATA_DIRECTORY_NAME + "/" + ECLIPSE_CORE_RUNTIME_SETTINGS_DIRECTORY_NAME + "/" + UI_EDITORS_PREFS_FILE_NAME);

        if (!uiEditorsPrefsFileName.exists()) {
            try {
                uiEditorsPrefsFileName.createNewFile();
            } catch (IOException e) {
                throw new MojoExecutionException(UI_EDITORS_PREFS_FILE_NAME + " failed", e);
            }
        }

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream(uiEditorsPrefsFileName)));
            writer.println("eclipse.preferences.version=1");
            writer.println("lineNumberRuler=true");

        } catch (FileNotFoundException e) {
            throw new MojoExecutionException(UI_EDITORS_PREFS_FILE_NAME + "write failed", e);
        } finally {
            writer.close();
        }
    }

    /**
     * TomcatPluginのcom.sysdeo.eclipse.tomcat.prefsの設定を出力
     * @throws MojoExecutionException
     */
    private void writeTomcatPluginPrefs(TomcatPluginProjectSettings tomcatPluginProjectSettings) throws MojoExecutionException{

        if(tomcatPluginProjectSettings == null){
            throw new IllegalArgumentException("tomcatPluginProjectSettings is null");
        }
        if(!tomcatPluginProjectSettings.getEnabled()){
            return;
        }

        File TomcatPluginPrefsFileName = new File(METADATA_DIRECTORY_NAME + "/" + ECLIPSE_CORE_RUNTIME_SETTINGS_DIRECTORY_NAME + "/" + TOMCAT_PLUGIN_PREFS_FILE_NAME);

        if (!TomcatPluginPrefsFileName.exists()) {
            try {
                TomcatPluginPrefsFileName.createNewFile();
            } catch (IOException e) {
                throw new MojoExecutionException(TOMCAT_PLUGIN_PREFS_FILE_NAME + " failed", e);
            }
        }

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream(TomcatPluginPrefsFileName)));

            if(tomcatPluginProjectSettings.getFixTomcatHomeBug() != null)
                writer.println("fixTomcatHomeBug=" + tomcatPluginProjectSettings.getFixTomcatHomeBug());
            if(tomcatPluginProjectSettings.getContextsDir() != null)
                writer.println("contextsDir=" + tomcatPluginProjectSettings.getContextsDir());
            if(tomcatPluginProjectSettings.getTomcatDir() != null)
                writer.println("tomcatDir=" + tomcatPluginProjectSettings.getTomcatDir());
            if(tomcatPluginProjectSettings.getConfigMode() != null)
                writer.println("configMode=" + tomcatPluginProjectSettings.getConfigMode());
            if(tomcatPluginProjectSettings.getJvmParameters() != null)
                writer.println("jvmParameters=" + tomcatPluginProjectSettings.getJvmParameters());
            if(tomcatPluginProjectSettings.getTomcatJRE() != null)
                writer.println("tomcatJRE=" + tomcatPluginProjectSettings.getTomcatJRE());
            if(tomcatPluginProjectSettings.getTomcatConfigFile() != null)
                writer.println("tomcatConfigFile=" + tomcatPluginProjectSettings.getTomcatConfigFile());
            if(tomcatPluginProjectSettings.getEclipsePreferenceVersion() != null)
                writer.println("eclipse.preferences.version=" + tomcatPluginProjectSettings.getEclipsePreferenceVersion());
            if(tomcatPluginProjectSettings.getTomcatVersion() != null)
                writer.println("tomcatVersion=" + tomcatPluginProjectSettings.getTomcatVersion());
            if(tomcatPluginProjectSettings.getManagerUrl() != null)
                writer.println("managerUrl=" + tomcatPluginProjectSettings.getManagerUrl());


        } catch (FileNotFoundException e) {
            throw new MojoExecutionException("org.eclipse.jdt.core write failed", e);
        } finally {
            writer.close();
        }
    }

    /**
     * TomcatPluginのcom.sysdeo.eclipse.tomcat.prefsの設定を出力
     * @throws MojoExecutionException
     */
    private void writeTeamCorePrefs(TeamCoreSettings teamCoreSettings) throws MojoExecutionException{

        log.info("trace");
        if(teamCoreSettings == null){
            throw new IllegalArgumentException("teamCoreSettings is null");
        }
        if(!teamCoreSettings.getEnabled()){
            return;
        }

        File TomcatPluginPrefsFileName = new File(METADATA_DIRECTORY_NAME + "/" + ECLIPSE_CORE_RUNTIME_SETTINGS_DIRECTORY_NAME + "/" + TEAM_CORE_PREFS_FILE_NAME);

        if (!TomcatPluginPrefsFileName.exists()) {
            try {
                TomcatPluginPrefsFileName.createNewFile();
            } catch (IOException e) {
                throw new MojoExecutionException(TEAM_CORE_PREFS_FILE_NAME + " failed", e);
            }
        }
        for (Iterator it = teamCoreSettings.getIgnoreFiles().iterator(); it.hasNext();) {
            log.info((String) it.next());
        }

//        PrintWriter writer = null;
//        try {
//            writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream(TomcatPluginPrefsFileName)));
//
//            if(tomcatPluginProjectSettings.getFixTomcatHomeBug() != null)
//                writer.println("fixTomcatHomeBug=" + tomcatPluginProjectSettings.getFixTomcatHomeBug());
//
//
//        } catch (FileNotFoundException e) {
//            throw new MojoExecutionException("org.eclipse.jdt.core write failed", e);
//        } finally {
//            writer.close();
//        }
    }
}
