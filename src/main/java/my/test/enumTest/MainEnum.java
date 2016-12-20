package my.test.enumTest;

/**
 * Тест из книги. (Эффективное програмирование Java.)
 * Вложенный Enum для ассоциации.
 */
public class MainEnum {
    public static void main(String[] args) {
        Ingredients.Dish from1 = Ingredients.Dish.from(Ingredients.CHEESE, Ingredients.KETCHUP);
        Ingredients.Dish from2 = Ingredients.Dish.from(Ingredients.SAUSAGE, Ingredients.BREAD);

        System.out.println(from1);
        System.out.println(from2);

    }
}
