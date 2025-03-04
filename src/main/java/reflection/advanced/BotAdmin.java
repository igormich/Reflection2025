package reflection.advanced;

public class BotAdmin implements BotPart{
    public BotAdmin() {
        System.out.println("new BotUser");
    }
    @Override
    public void init() {
        System.out.println("BotAdmin.init");
    }
}
