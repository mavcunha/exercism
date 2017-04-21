public class HelloWorld {

    public static String hello(String name) {
        return new SayHello(name).toString();
    }

}

class SayHello {
    private final String name;

    SayHello(String name) {
        this.name = isNameDefined(name) ? name : "World";
    }

    @Override
    public String toString() {
        return "Hello, " + this.name + "!";
    }

    private boolean isNameDefined(String name) {
        return name != null && !name.isEmpty();
    }
}
