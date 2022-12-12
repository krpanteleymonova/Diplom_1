import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredientFillingMeat;
    @Mock
    Ingredient ingredientFillingCheese;
    @Mock
    Ingredient ingredientFillingSalad;
    @Mock
    Ingredient ingredientSauce;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void burgerGetPriceTest() {
        bunGetMockito();
        burger.setBuns(bun);
        ingredientFillingMeatGetMockito();
        burger.addIngredient(ingredientFillingMeat);
        assertEquals(170, burger.getPrice(), 0);
    }

    @Test
    public void burgerGetReceiptTest() {
        bunGetMockito();
        burger.setBuns(bun);
        ingredientFillingMeatGetMockito();
        burger.addIngredient(ingredientFillingMeat);
        System.out.println(burger.getReceipt());
        assertTrue(burger.getReceipt().contains("==== Булочка с кунжутом ===="));
        assertTrue(burger.getReceipt().contains("Котлета"));
        assertTrue(burger.getReceipt().contains("Price: 170,000000"));
    }

    @Test
    public void burgerAddIngredientTest() {
        burgerAddIngredient();
        assertEquals("Некорректное кол-во ингридиентов", 4, burger.ingredients.size());
        assertTrue("Бургер не содержит котлету", burger.ingredients.get(0).equals(ingredientFillingMeat));
        assertTrue("Бургер не содержит сыр", burger.ingredients.get(1).equals(ingredientFillingCheese));
        assertTrue("Бургер не содержит соус", burger.ingredients.get(2).equals(ingredientSauce));
        assertTrue("Бургер не содержит салат", burger.ingredients.get(3).equals(ingredientFillingSalad));
    }

    @Test
    public void burgerMoveIngredientTest() {
        burgerAddIngredient();
        burger.moveIngredient(3, 1);
        assertEquals("Некорректное кол-во ингридиентов", 4, burger.ingredients.size());
        assertTrue("Бургер не содержит котлету", burger.ingredients.get(0).equals(ingredientFillingMeat));
        assertTrue("Бургер не содержит салат", burger.ingredients.get(1).equals(ingredientFillingSalad));
        assertTrue("Бургер не содержит сыр", burger.ingredients.get(2).equals(ingredientFillingCheese));
        assertTrue("Бургер не содержит соус", burger.ingredients.get(3).equals(ingredientSauce));
    }

    @Test
    public void burgerRemoveIngredientTest() {
        burgerAddIngredient();
        burger.removeIngredient(1);
        System.out.println(burger.ingredients.size());
        assertEquals("Некорректное кол-во ингридиентов", 3, burger.ingredients.size());
        assertFalse("Бургер не содержит данный ингридиент", burger.ingredients.contains(ingredientFillingCheese));
        assertTrue("Бургер не содержит котлету", burger.ingredients.get(0).equals(ingredientFillingMeat));
        assertTrue("Бургер не содержит соус", burger.ingredients.get(1).equals(ingredientSauce));
        assertTrue("Бургер не содержит салат", burger.ingredients.get(2).equals(ingredientFillingSalad));
    }

    private void burgerAddIngredient() {
        assertEquals("Некорректное кол-во ингридиентов", 0, burger.ingredients.size());
        burger.addIngredient(ingredientFillingMeat);
        burger.addIngredient(ingredientFillingCheese);
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFillingSalad);
        System.out.println(burger.ingredients.size());
    }

    public void bunGetMockito() {
        Mockito.when(bun.getName()).thenReturn("Булочка с кунжутом");
        Mockito.when(bun.getPrice()).thenReturn(69.9f);
    }

    public void ingredientFillingMeatGetMockito() {
        Mockito.when(ingredientFillingMeat.getPrice()).thenReturn(30.2f);
        Mockito.when(ingredientFillingMeat.getType()).thenReturn(IngredientType.valueOf("FILLING"));
        Mockito.when(ingredientFillingMeat.getName()).thenReturn("Котлета");
    }
}