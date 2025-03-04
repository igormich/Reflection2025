package reflection.pro.user;

import reflection.pro.autumn.AutoWired;
import reflection.pro.autumn.Service;

@Service
public class ImageServiceImpl implements ImageService {

    @AutoWired
    DataBaseService dataBase;
    @Override
    public void createImage(String prompt) {
        System.out.println("Image for prompt " + prompt + " has been created");
        dataBase.storeData(-37);
    }
}
