import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Parameterized.Parameters
    public static Object[][] getBurgerInside() {
        return new Object[][]{
                {FILLING, "Котлета", 100},
                {SAUCE, "Cоус", 35.99f},
        };
    }

    @Test
    public void ingredientGetNameTest() {
        System.out.println(ingredient.getName());
        assertEquals("Некорректное название", name, ingredient.getName());
    }

    @Test
    public void ingredientGetPriceTest() {
        System.out.println(ingredient.getPrice());
        assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void ingredientGetTypeTest() {
        System.out.println(ingredient.getType());
        assertEquals("Некорректное название", type, ingredient.getType());
    }


}
