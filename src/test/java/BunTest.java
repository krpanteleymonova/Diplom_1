
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("Флюресцентная булка", 100.5f);
    }

    @Test
    public void bunGetNameTest() {

        System.out.println(bun.getName());
        assertEquals("Некорректное название булочки", "Флюресцентная булка", bun.getName());
    }

    @Test
    public void bunGetPriceTest() {

        System.out.println(bun.getPrice());
        assertEquals(100.5f, bun.getPrice(), 0);

    }


}
