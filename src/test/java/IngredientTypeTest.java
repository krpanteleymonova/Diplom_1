import org.junit.Test;
import praktikum.IngredientType;

import static java.lang.String.valueOf;
import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    IngredientType type;

    @Test
    public void ingredientTypeTest() {
        assertEquals("SAUCE", valueOf(type.SAUCE));
        assertEquals("FILLING", valueOf(type.FILLING));
    }
}