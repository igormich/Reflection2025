package reflection.pro.user;

import reflection.pro.autumn.Service;

@Service
public class DataBaseServiceImpl implements DataBaseService {
    @Override
    public int loadData() {
        System.out.println("Load 42 from DB");
        return 42;
    }

    @Override
    public void storeData(int value) {
        System.out.println("Store " + value + " to DB");
    }

    @Override
    public void storeData(String value) {
        System.out.println("Store " + value + " to DB");
    }
}
