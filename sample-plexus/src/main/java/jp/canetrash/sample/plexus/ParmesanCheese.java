package jp.canetrash.sample.plexus;

public class ParmesanCheese
    implements Cheese
{
    public void slice( int slices )
    {
        throw new UnsupportedOperationException( "No can do" );
    }

    public String getAroma()
    {
        return Long.toString(System.currentTimeMillis());
    }
}

