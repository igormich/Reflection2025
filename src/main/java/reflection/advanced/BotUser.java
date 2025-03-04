package reflection.advanced;

public class BotUser implements BotPart{

    public BotUser() {
        System.out.println("new BotUser");
    }
    @Override
    public void init() {
        System.out.println("BotUser.init");
    }
}
