/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.maven.plugin.eclipse;

import java.util.Properties;

/**
 * @author <a href="mailto:trygvis@inamo.no">Trygve Laugst&oslash;l</a>
 * @author <a href="mailto:fgiust@apache.org">Fabrizio Giustina</a>
 * @version $Id: EclipsePluginTest.java 487861 2006-12-16 19:29:12Z fgiust $
 */
public class EclipsePluginTest
    extends AbstractEclipsePluginTestCase
{
    public void testProject01()
        throws Exception
    {
        testProject( "project-01" );
    }

    public void testProject02()
        throws Exception
    {
        testProject( "project-02" );
    }

    public void testProject03()
        throws Exception
    {
        testProject( "project-03" );
    }

    public void testProject04()
        throws Exception
    {
        testProject( "project-04" );
    }

    public void testProject05()
        throws Exception
    {
        testProject( "project-05" );
    }

    public void testProject06()
        throws Exception
    {
        testProject( "project-06" );
    }

    // @todo temporary disabled, since it randomically fails due to a different order for dependencies in classpath and
    // wtpmodules. This is not a problem, since order could be ignored in this test, but we should rewrite the file-comparing
    // step which at the moment just does line by line comparison
    //    public void testProject07()
    //        throws Exception
    //    {
    //        testProject( "project-07" );
    //    }

    public void testProject08()
        throws Exception
    {
        testProject( "project-08" );
    }

    /**
     * Tests with <code>outputDirectory</code> and <code>outputDir</code>
     * @throws Exception
     */
    public void testProject09()
        throws Exception
    {
        testProject( "project-09" );
    }

    public void testProject10()
        throws Exception
    {
        testProject( "project-10" );
    }

    public void testProject11()
        throws Exception
    {
        testProject( "project-11" );
    }

    /**
     * Ear packaging
     * @throws Exception any exception thrown during test
     */
    public void testProject12()
        throws Exception
    {
        testProject( "project-12" );
    }

    /**
     * Dependency range - MECLIPSE-96
     * @throws Exception any exception thrown during test
     */
    public void testProject13()
        throws Exception
    {
        testProject( "project-13" );
    }

    /**
     * Additional natures and builders - MECLIPSE-64
     * @throws Exception any exception thrown during test
     */
    public void testProject14()
        throws Exception
    {
        testProject( "project-14" );
    }

    /**
     * <code>outputDirectory</code> parameter - MECLIPSE-11
     * @throws Exception any exception thrown during test
     */
    public void testProject15()
        throws Exception
    {
        Properties props = new Properties();
        props.put( "outputDirectory", "bin" );
        testProject( "project-15", props, "clean", "eclipse" );
    }

    //Commented out: failing due to MNG-2025
    //    /**
    //     * UTF8 encoding - MECLIPSE-56
    //     * @throws Exception any exception thrown during test
    //     */
    //    public void testProject16()
    //        throws Exception
    //    {
    //        testProject( "project-16" );
    //    }

    //Commented out: failing on Continuum, due to MNG-2025 too?
    //    /**
    //     * ISO-8859-15 encoding - MECLIPSE-56
    //     * @throws Exception any exception thrown during test
    //     */
    //    public void testProject17()
    //        throws Exception
    //    {
    //        testProject( "project-17" );
    //    }

    /**
     * relative location of system dependencies - MECLIPSE-89
     * @throws Exception any exception thrown during test
     */
    public void testProject18()
        throws Exception
    {
        testProject( "project-18" );
    }

    /**
     * Resource targetPath is relative to the project's output directory - MECLIPSE-77
     * @throws Exception any exception thrown during test
     */
    public void testProject19()
        throws Exception
    {
        testProject( "project-19" );
    }

    /**
     * WTP 1.5 changes in wtpmodules.
     * @throws Exception any exception thrown during test
     */
    public void testProject20()
        throws Exception
    {
        testProject( "project-20" );
    }

    /**
     * PDE support.
     * @throws Exception any exception thrown during test
     */
    public void testProject21()
        throws Exception
    {
        testProject( "project-21" );
    }

    /**
     * PDE support using eclipse-plugin packaging.
     * @throws Exception any exception thrown during test
     */
    public void testProject22()
        throws Exception
    {
        testProject( "project-22" );
    }

    /**
     * Additional config files using "additionalConfig" property.
     * @throws Exception any exception thrown during test
     */
    public void testProject23()
        throws Exception
    {
        testProject( "project-23" );
    }

    /**
     * Test rewriting of OSGI manifest files.
     * @throws Exception any exception thrown during test
     */
    public void testProject24()
        throws Exception
    {
        testProject( "project-24" );
    }

    /**
     * Test source exclude/include.
     * @throws Exception any exception thrown during test
     */
    public void testProject25()
        throws Exception
    {
        testProject( "project-25" );
    }

    /**
     * Test different compiler settings for test sources.
     * @throws Exception any exception thrown during test
     */
    public void testProject26()
        throws Exception
    {
        testProject( "project-26" );
    }

}
