public class Android extends Mobile {
    private static final int ANDROID_MESSAGE_MAX_LENGTH = 40;
    private static final String ANDROID_PREFIX = "<Android>";

    public Android(String name, String color, String brand) {
        super(name, color, brand);
    }

    @Override
    public void call(String message) {
        System.out.print(ANDROID_PREFIX);

        if (message.length() > ANDROID_MESSAGE_MAX_LENGTH) {
            System.out.println(" Message cannot be sent");
        } else {
            super.call(message);
        }
    }
}
