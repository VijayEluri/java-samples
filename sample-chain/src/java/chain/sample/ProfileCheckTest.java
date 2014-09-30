/*
 * Copyright (c) 2005 ATL Systems incorporated.
 * All rights reserved.
 */
package chain.sample;


import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;

import junit.framework.TestCase;


/**
 *
 * @author funato
 * @createted 2005/07/22
 */
public class ProfileCheckTest extends TestCase {
    public void testProfileCheckNeed() {
        Context context = new ContextBase();
        Command command = new ProfileCheck();

        try {
            command.execute(context);
        } catch (Exception e) {
            fail(e.getMessage());
        }

        Profile profile = (Profile) context.get(Profile.PROFILE_KEY);
        assertNotNull("Missing Profile", profile);
    }
}
