package reflection.pro.user;

import reflection.pro.autumn.AutoWired;
import reflection.pro.autumn.Autumn;
import reflection.pro.autumn.Get;
import reflection.pro.autumn.Service;

@Service
public class BotService1 implements BotService {
    @AutoWired
    DataBaseService dataBase;

    @Get
    public int sum(int x, int y) {
        dataBase.storeData(y);
        return x + y;
    }

    @Get
    public int square(int x) {
        dataBase.storeData(x);
        return x * x;
    }

    public static void main(String[] args) throws Exception {
        Autumn.runServer();
    }
}
