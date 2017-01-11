package test;

import org.springframework.stereotype.Service;

/**
 * TODO: Add doc
 * Created by Nikita on 11.01.2017.
 */
public class Calc {
    private String name;

    public Calc(String name) {
        this.name = name;
    }

    public int amount(int a, int b){
        return a+b;
    }

    public int difference(int a, int b){
        return a-b;
    }

    public String getName() {
        return name;
    }
}
