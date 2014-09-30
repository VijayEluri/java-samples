package org.apache.maven.plugin.eclipse.writers;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.factory.ArtifactFactory;
import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.artifact.resolver.ArtifactResolver;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.eclipse.EclipseSourceDir;
import org.apache.maven.plugin.eclipse.EclipseUtils;
import org.apache.maven.plugin.eclipse.Messages;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.IOUtil;
import org.codehaus.plexus.util.StringUtils;
import org.codehaus.plexus.util.xml.PrettyPrintXMLWriter;
import org.codehaus.plexus.util.xml.XMLWriter;

/**
 * Writes eclipse .classpath file.
 *
 * @author <a href="mailto:trygvis@inamo.no">Trygve Laugst&oslash;l</a>
 * @author <a href="mailto:kenney@neonics.com">Kenney Westerhof</a>
 * @author <a href="mailto:fgiust@apache.org">Fabrizio Giustina</a>
 * @version $Id: EclipseClasspathWriter.java 360273 2005-12-31 11:59:16Z fgiust $
 */
public class EclipseClasspathWriter2
    extends AbstractEclipseResourceWriter
{

    /**
     * Eclipse build path variable M2_REPO
     */
    private static final String M2_REPO = "M2_REPO"; //$NON-NLS-1$

    private File eclipseProjectDir;

    /**
     * Attribute for sourcepath.
     */
    private static final String ATTR_SOURCEPATH = "sourcepath"; //$NON-NLS-1$

    private MavenProject project;

    /**
     * Attribute for output.
     */
    private static final String ATTR_OUTPUT = "output"; //$NON-NLS-1$

    /**
     * Attribute for path.
     */
    private static final String ATTR_PATH = "path"; //$NON-NLS-1$

    /**
     * Attribute for kind - Container (con), Variable (var)..etc.
     */
    private static final String ATTR_KIND = "kind"; //$NON-NLS-1$

    /**
     * Element for classpathentry.
     */
    private static final String ELT_CLASSPATHENTRY = "classpathentry"; //$NON-NLS-1$

    /**
     * Element for classpath.
     */
    private static final String ELT_CLASSPATH = "classpath"; //$NON-NLS-1$

    /**
     * File name that stores project classpath settings.
     */
    private static final String FILE_DOT_CLASSPATH = ".classpath"; //$NON-NLS-1$

    /**
     * Dependencies for our project.
     */
    private Collection artifacts;

    public EclipseClasspathWriter2( Log log, File eclipseProjectDir, MavenProject project, Collection artifacts )
    {
        super( log, eclipseProjectDir, project );
        this.artifacts = artifacts;
    	this.project = project;
    	this.eclipseProjectDir = eclipseProjectDir;
    }

    public void write( File projectBaseDir, List referencedReactorArtifacts, EclipseSourceDir[] sourceDirs,
                      List classpathContainers, ArtifactRepository localRepository, ArtifactResolver artifactResolver,
                      ArtifactFactory artifactFactory, File buildOutputDirectory )
        throws MojoExecutionException
    {

        FileWriter w;

        try
        {
            w = new FileWriter( new File( getEclipseProjectDirectory(), FILE_DOT_CLASSPATH ) );
        }
        catch ( IOException ex )
        {
            throw new MojoExecutionException( Messages.getString( "EclipsePlugin.erroropeningfile" ), ex ); //$NON-NLS-1$
        }

        XMLWriter writer = new PrettyPrintXMLWriter( w );

        writer.startElement( ELT_CLASSPATH );


        // ----------------------------------------------------------------------
        // Source roots and resources
        // ----------------------------------------------------------------------

        for ( int j = 0; j < sourceDirs.length; j++ )
        {
            EclipseSourceDir dir = sourceDirs[j];

            writer.startElement( ELT_CLASSPATHENTRY );

            writer.addAttribute( ATTR_KIND, "src" ); //$NON-NLS-1$ 
            writer.addAttribute( ATTR_PATH, dir.getPath() );
            if ( dir.getOutput() != null )
            {
                writer.addAttribute( ATTR_OUTPUT, dir.getOutput() );
            }

            writer.endElement();

        }
    	
        for ( int j = 0; j < referencedReactorArtifacts.size(); j++ )
        {
        	Artifact artifact = (Artifact) referencedReactorArtifacts.get(j);
            String path = "/" + artifact.getArtifactId() + "/target/classes"; //$NON-NLS-1$
            String srcpath = "/" + artifact.getArtifactId() + "/src/main/java"; //$NON-NLS-1$

            writer.startElement( ELT_CLASSPATHENTRY );

            writer.addAttribute( ATTR_KIND, "lib"); //$NON-NLS-1$ 
            writer.addAttribute( ATTR_PATH, path );
            //writer.addAttribute( ATTR_SOURCEPATH, srcpath); //$NON-NLS-1$ 

            writer.endElement();
        	
        }
    	
        // ----------------------------------------------------------------------
        // Libraries
        // ----------------------------------------------------------------------
        File localRepositoryFile = new File(localRepository.getBasedir());
        List classpathElements = new ArrayList(project.getArtifacts());
        for (Iterator iterator = classpathElements.iterator(); iterator.hasNext();) {
            Artifact artifact = (Artifact) iterator.next();

	        if ( referencedReactorArtifacts.contains( artifact ) )
	        {
	            continue;
	        }
            String path = "M2_REPO/"
                    + EclipseUtils.toRelativeAndFixSeparator(localRepositoryFile, new File(artifact.getFile().getAbsolutePath()), false);

            writer.startElement( ELT_CLASSPATHENTRY );

            writer.addAttribute( ATTR_KIND, "var" ); //$NON-NLS-1$ 
            writer.addAttribute( ATTR_PATH, path );

            writer.endElement();
        }
    	
        // ----------------------------------------------------------------------
        // The default output
        // ----------------------------------------------------------------------

        writer.startElement( ELT_CLASSPATHENTRY );
        writer.addAttribute( ATTR_KIND, ATTR_OUTPUT );
        writer.addAttribute( ATTR_PATH, EclipseUtils.toRelativeAndFixSeparator( projectBaseDir, buildOutputDirectory,
                                                                                false ) );
        writer.endElement();

        // ----------------------------------------------------------------------
        // Container classpath entries
        // ----------------------------------------------------------------------

        for ( Iterator it = classpathContainers.iterator(); it.hasNext(); )
        {
            writer.startElement( ELT_CLASSPATHENTRY );
            writer.addAttribute( ATTR_KIND, "con" ); //$NON-NLS-1$ 
            writer.addAttribute( ATTR_PATH, (String) it.next() );
            writer.endElement(); // name
        }

        writer.endElement();

        IOUtil.close( w );

    }


}
