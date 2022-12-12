import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {


    private final String name;
    private final float price;

    public IngredientTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    Ingredient ingredient;

    @Mock
    IngredientType ingredientType;

    @Before
    public void setUp() {
        ingredient = new Ingredient(ingredientType, name, price);
    }

    @Parameterized.Parameters
    public static Object[][] getBurgerInside() {
        return new Object[][]{
                {"Котлета", 100},
                {"Cоус", 35.99f},
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
        assertEquals("Некорректное название", ingredientType, ingredient.getType());
    }
}
