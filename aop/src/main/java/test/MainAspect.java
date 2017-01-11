package test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TODO: Add doc
 * Created by Nikita on 11.01.2017.
 */
public class MainAspect {
    private static final Logger LOGGER = LogManager.getLogger(MainAspect.class);
    private static ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans/main.xml");

    public static void main(String[] args) {
        Calc calc = context.getBean("calc",Calc.class);
        int result1 = calc.amount(1, 5);
        int result2 = calc.difference(1, 5);
        System.out.println(result1);
        System.out.println(result2);
    }


}
