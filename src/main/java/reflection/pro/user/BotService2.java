package reflection.pro.user;

import reflection.pro.autumn.Arg;
import reflection.pro.autumn.AutoWired;
import reflection.pro.autumn.Get;
import reflection.pro.autumn.Service;

@Service
public class BotService2 implements BotService{
    @AutoWired
    DataBaseService dataBase;
    @AutoWired
    ImageService imageService;

    @Get
    public int draw(@Arg("prompt") String s) {
        dataBase.storeData(s);
        imageService.createImage(s);
        return dataBase.loadData();
    }
}
