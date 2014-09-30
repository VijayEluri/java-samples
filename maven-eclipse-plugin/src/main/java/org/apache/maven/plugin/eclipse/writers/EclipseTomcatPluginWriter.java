/*
 * @(#)EclipseTomcatPluginWriter.java
 * Product: Caty
 * Version: 4
 * Copyright 2006 by i-TEC hanshin, Inc., All rights reserved.
 */
package org.apache.maven.plugin.eclipse.writers;

import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.eclipse.Messages;
import org.apache.maven.plugin.eclipse.TomcatPluginSettings;
import org.apache.maven.plugin.eclipse.EclipseUtils;
import org.apache.maven.project.MavenProject;
import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.repository.ArtifactRepository;
import org.codehaus.plexus.util.xml.XMLWriter;
import org.codehaus.plexus.util.xml.PrettyPrintXMLWriter;
import org.codehaus.plexus.util.IOUtil;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Date: 2006/05/13
 * Time: 1:45:58
 *
 * @author yamada
 */
public class EclipseTomcatPluginWriter extends AbstractEclipseResourceWriter{

    private MavenProject project;

    private Log log;

    private File eclipseProjectDir;

    private final String TOMCAT_PLUGIN_SETTING_FILE_NAME = ".tomcatplugin";

    public EclipseTomcatPluginWriter(Log log, File eclipseProjectDir, MavenProject project) {
        super(log, eclipseProjectDir, project);
        this.log = log;
        this.eclipseProjectDir = eclipseProjectDir;
        this.project = project;
    }

    public void write(TomcatPluginSettings tomcatPluginSettings, File projectBaseDir, List referencedReactorArtifacts, ArtifactRepository localRepository, File buildOutputDirectory)

            throws MojoExecutionException {

        FileWriter w;

        try {
            w = new FileWriter(new File(getEclipseProjectDirectory(), TOMCAT_PLUGIN_SETTING_FILE_NAME));
        }
        catch (IOException ex) {
            throw new MojoExecutionException(TOMCAT_PLUGIN_SETTING_FILE_NAME + " create failed", ex);
        }

        XMLWriter writer = new PrettyPrintXMLWriter(w);

        writer.writeMarkup("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        writer.writeMarkup(System.getProperty("line.separator"));
        writer.startElement("tomcatProjectProperties");

        writer.startElement("reloadable");
        if (tomcatPluginSettings.getReloadable() != null) {
            writer.writeText(tomcatPluginSettings.getReloadable());
        }
        writer.endElement();

        writer.startElement("updateXml");
        if (tomcatPluginSettings.getUpdateXml() != null) {
            writer.writeText(tomcatPluginSettings.getUpdateXml());
        }
        writer.endElement();

        writer.startElement("redirectLogger");
        if (tomcatPluginSettings.getReloadable() != null) {
            writer.writeText(tomcatPluginSettings.getReloadable());
        }
        writer.endElement();

        writer.startElement("warLocation");
        if (tomcatPluginSettings.getWarLocation() != null) {
            writer.writeText(tomcatPluginSettings.getWarLocation());
        }
        writer.endElement();

        writer.startElement("rootDir");
        if (tomcatPluginSettings.getRootDir() != null) {
            writer.writeText(tomcatPluginSettings.getRootDir());
        }
        writer.endElement();

        writer.startElement("exportSource");
        if (tomcatPluginSettings.getExportSource() != null) {
            writer.writeText(tomcatPluginSettings.getExportSource());
        }
        writer.endElement();

        writer.startElement("extraInfo");
        if (tomcatPluginSettings.getExtraInfo() != null) {
            writer.writeText(tomcatPluginSettings.getExtraInfo());
        }
        writer.endElement();

        writer.startElement("webPath");
        if (tomcatPluginSettings.getWebPath() != null) {
            writer.writeText(tomcatPluginSettings.getWebPath());
        }
        writer.endElement();

        writer.startElement("webClassPathEntries");
        writer.startElement("webClassPathEntry");
        writer.writeText("/" + project.getArtifactId() + "/" +
                EclipseUtils.toRelativeAndFixSeparator(projectBaseDir, buildOutputDirectory, false));
        writer.endElement();

        File localRepositoryFile = new File(localRepository.getBasedir());
        List classpathElements = new ArrayList(project.getArtifacts());
        for (Iterator iterator = classpathElements.iterator(); iterator.hasNext();) {
            Artifact artifact = (Artifact) iterator.next();

	        if ( referencedReactorArtifacts.contains( artifact ) )
	        {
	            continue;
	        }
            if (artifact.getScope().compareToIgnoreCase("provided") == 0 || artifact.getScope().compareToIgnoreCase("test") == 0)
            {
                continue;
            }
            String path = "M2_REPO/"
                    + EclipseUtils.toRelativeAndFixSeparator(localRepositoryFile, new File(artifact.getFile().getAbsolutePath()), false);

            writer.startElement("webClassPathEntry");
            writer.writeText(path);
            writer.endElement();
        }
         
        for ( int j = 0; j < referencedReactorArtifacts.size(); j++ )
        {
        	Artifact artifact = (Artifact) referencedReactorArtifacts.get(j);
            String path = "/" + artifact.getArtifactId() + "/target/classes"; //$NON-NLS-1$

            writer.startElement("webClassPathEntry");
            writer.writeText(path);
            writer.endElement();
        	
        }
        writer.endElement();

        writer.endElement();

        IOUtil.close(w);
    }

}
