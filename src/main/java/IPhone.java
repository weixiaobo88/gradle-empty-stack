public class IPhone extends Mobile {
    private static final int IPHONE_MESSAGE_MAX_LENGTH = 30;
    private static final String IPHONE_PREFIX = "<iPhone>";

    public IPhone(String name, String color, String brand) {
        super(name, color, brand);
    }


    @Override
    public void call(String message) {
        System.out.print(IPHONE_PREFIX);

        if (message.length() > IPHONE_MESSAGE_MAX_LENGTH) {
            System.out.println(" Message cannot be sent");
        } else {
            super.call(message);
        }
    }
}
