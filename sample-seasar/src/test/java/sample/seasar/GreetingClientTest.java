package sample.seasar;

import junit.framework.TestCase;

import org.seasar.framework.container.factory.SingletonS2ContainerFactory;

public class GreetingClientTest extends TestCase {

    protected void setUp() throws Exception {
        super.setUp();
        SingletonS2ContainerFactory.init();
    }

    /*
     * 'sample.seasar.GreetingClient.execute()' のためのテスト・メソッド
     */
    public void testExecute() {
        GreetingClient client = 
            (GreetingClient)SingletonS2ContainerFactory.getContainer().getComponent("greet.greetingClient");
        client.execute();
    }
}
