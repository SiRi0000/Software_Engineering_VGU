import org.junit.Before;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class TestMealOrderMgmt {
    MealOrderMgmt mgmt;
    MealOrder mo1;
    MealOrder mo2;
    MealOrder mo3;
    @BeforeEach
    void setUp(){
        mgmt = new MealOrderMgmt();
        mo1 = new MealOrder(1001);
        mo2 = new MealOrder(1002);
        mo3 = new MealOrder(1003);
    }

    @AfterEach
    void teardown(){
        mgmt = null;
        mo1 = null;
        mo2 = null;
    }

    @Test
    void testPositiveAddMealOrder(){
        assertEquals(0, mgmt.getOrderCount());
        mgmt.addMealOrder(mo1);
        assertEquals(1, mgmt.getOrderCount());
        mgmt.addMealOrder(mo2);
        assertEquals(2, mgmt.getOrderCount());
    }

    @Test
    void testNegativeAddMealOrder(){
        assertEquals(0, mgmt.getOrderCount());
        mgmt.addMealOrder(null);
        assertEquals(0, mgmt.getOrderCount());
    }

    @Test
    void testPositiveUpdateMealOrder(){
        mgmt.addMealOrder(mo1);

        mgmt.updateMealOrder(mo1.getOrderID(),OrderStatus.ORDERED);
        assertEquals(OrderStatus.ORDERED, mo1.getStatus());

        mgmt.updateMealOrder(mo1.getOrderID(),OrderStatus.IN_KITCHEN);
        assertEquals(OrderStatus.IN_KITCHEN, mo1.getStatus());

        mgmt.updateMealOrder(mo1.getOrderID(),OrderStatus.DELIVERING);
        assertEquals(OrderStatus.DELIVERING, mo1.getStatus());

        mgmt.updateMealOrder(mo1.getOrderID(),OrderStatus.ARCHIVED);
        assertEquals(OrderStatus.ARCHIVED, mo1.getStatus());

        mgmt.updateMealOrder(mo1.getOrderID(),OrderStatus.INACTIVE);
        assertEquals(OrderStatus.INACTIVE, mo1.getStatus());
    }

    @Test
    void testPositiveCountOrderStatus(){
        assertEquals(0, mgmt.countNumberOf(OrderStatus.ORDERED));
        assertEquals(0, mgmt.countNumberOf(OrderStatus.IN_KITCHEN));

        mgmt.addMealOrder(mo1);
        mgmt.updateMealOrder(mo1.getOrderID(),OrderStatus.IN_KITCHEN);

        mgmt.addMealOrder(mo2);
        mgmt.updateMealOrder(mo2.getOrderID(), OrderStatus.ORDERED);

        mgmt.addMealOrder(mo3);
        mgmt.updateMealOrder(mo3.getOrderID(), OrderStatus.ORDERED);

        assertEquals(1, mgmt.countNumberOf(OrderStatus.IN_KITCHEN));
        assertEquals(2, mgmt.countNumberOf(OrderStatus.ORDERED));
    }
}
