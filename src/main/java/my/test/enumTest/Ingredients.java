package my.test.enumTest;

import java.util.EnumMap;
import java.util.Map;

/**
 * Ассоциации колекций товаров.
 */
public enum Ingredients {
    SAUSAGE, CHEESE, KETCHUP, BREAD;

    public enum Dish{
        SANDWICH(SAUSAGE,BREAD),PIZZA(CHEESE,KETCHUP),;

        private Ingredients ingred1;
        private Ingredients ingred2;

        Dish(Ingredients ingred1, Ingredients ingred2) {
            this.ingred1 = ingred1;
            this.ingred2 = ingred2;
        }

        private static final Map<Ingredients,Map<Ingredients,Dish>> m =
                new EnumMap<>(Ingredients.class);

        static {
            for(Ingredients ingred:Ingredients.values()){
                m.put(ingred,new EnumMap<Ingredients, Dish>(Ingredients.class));
                for (Dish dish:Dish.values()){
                    m.get(dish.ingred1).put(dish.ingred2,dish);
                }
            }
        }

        public static Dish from(Ingredients ingred1, Ingredients ingred2){
            return m.get(ingred1).get(ingred2);
        }

    }

}
