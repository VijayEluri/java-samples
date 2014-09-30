package jp.canetrash.sample.plexus;

import org.codehaus.plexus.DefaultPlexusContainer;
import org.codehaus.plexus.PlexusContainer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception 
    {
        PlexusContainer container = new DefaultPlexusContainer();
        
        Cheese cheese = (Cheese) container.lookup( Cheese.ROLE, "other" );
        System.out.println( "Parmesan is " + cheese.getAroma() );
        System.out.println(cheese);
        cheese = (Cheese) container.lookup( Cheese.ROLE, "parmesan" );
        System.out.println( "Parmesan is " + cheese.getAroma() );
        System.out.println(cheese);
        
        container.dispose();
    }
}
