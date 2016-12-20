package my.test;

import my.test.annotations.Init;
import my.test.annotations.Service;

/**
 * TODO: Add doc
 * Created by Nikita on 21.12.2016.
 */
@Service(name = "Service lazy 1")
public class LazyService {

    @Init
    public void lazyinit() throws Exception {

    }
}
