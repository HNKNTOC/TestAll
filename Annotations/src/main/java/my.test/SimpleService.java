package my.test;

import my.test.annotations.Init;
import my.test.annotations.Service;

/**
 * TODO: Add doc
 * Created by Nikita on 21.12.2016.
 */
@Service(name = "Service simple 2")
public class SimpleService {

    private static int numberServiceCreated = 0;

    public SimpleService() {

    }

    {
        numberServiceCreated++;
    }

    public String getInfo(){
        return "This service info:" +
                "\nNumber of service created: "+ numberServiceCreated;
    }

    @Init
    public void initService(){

    }
}
