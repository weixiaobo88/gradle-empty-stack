class Person {
    private String name;

    Person(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    void call(Mobile mobile, String message) {
        mobile.call(message);
    }

    void call(IPhone iPhone, String message) {
        iPhone.call(message);
    }
}
