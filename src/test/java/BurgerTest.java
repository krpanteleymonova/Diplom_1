import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Ingredient ingredientFillingMeat;
    Ingredient ingredientFillingCheese;
    Ingredient ingredientSauce;
    Ingredient ingredientFillingSalad;
    Burger burger;

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Before
    public void setUp() {

        ingredientFillingMeat = new Ingredient(FILLING, "Котлета", 100);
        ingredientFillingCheese = new Ingredient(FILLING, "Сыр", 80);
        ingredientFillingSalad = new Ingredient(FILLING, "Салат", 60);
        ingredientSauce = new Ingredient(SAUCE, "Кетчуп", 30);
        burger = new Burger();
    }

    @Test
    public void burgerGetPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(69.9f);
        Mockito.when(ingredient.getPrice()).thenReturn(30.2f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals(170, burger.getPrice(), 0);
    }

    @Test
    public void burgerGetReceiptTest() {
        Mockito.when(bun.getPrice()).thenReturn(69.9f);
        Mockito.when(bun.getName()).thenReturn("Булочка с кунжутом");
        Mockito.when(ingredient.getPrice()).thenReturn(30.2f);
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        Mockito.when(ingredient.getName()).thenReturn("Котлета");
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        System.out.println(burger.getReceipt());
        assertTrue(burger.getReceipt().contains("==== Булочка с кунжутом ===="));
        assertTrue(burger.getReceipt().contains("Котлета"));
        assertTrue(burger.getReceipt().contains("Price: 170,000000"));

    }


    @Test
    public void burgerAddIngredientTest() {
        burgerAddIngredient();
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
        assertEquals("Некорректное кол-во ингридиентов", 4, burger.ingredients.size());
        assertTrue("Бургер не содержит котлету", burger.ingredients.get(0).equals(ingredientFillingMeat));
        assertTrue("Бургер не содержит сыр", burger.ingredients.get(1).equals(ingredientFillingCheese));
        assertTrue("Бургер не содержит соус", burger.ingredients.get(2).equals(ingredientSauce));
        assertTrue("Бургер не содержит салат", burger.ingredients.get(3).equals(ingredientFillingSalad));
    }
}