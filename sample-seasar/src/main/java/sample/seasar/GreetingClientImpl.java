package sample.seasar;

public class GreetingClientImpl implements GreetingClient {

    private Greeting greeting;

    public void setGreeting(Greeting greeting) {
        this.greeting = greeting;
    }

    public void execute() {
        System.out.println(greeting.greet());
    }

}
