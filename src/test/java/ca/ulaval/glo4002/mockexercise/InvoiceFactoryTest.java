package ca.ulaval.glo4002.mockexercise;

import ca.ulaval.glo4002.mockexercise.do_not_edit.CartFactory;
import ca.ulaval.glo4002.mockexercise.do_not_edit.Invoice;
import ca.ulaval.glo4002.mockexercise.do_not_edit.InvoiceLine;
import ca.ulaval.glo4002.mockexercise.do_not_edit.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class InvoiceFactoryTest {
    private static final String EMAIL = "EMAIL";

    private InvoiceFactory factory;

    private final Cart shoppingCart = Mockito.mock(Cart.class);
    private final Product product1 = Mockito.mock(Product.class);

    private static final String PRODUCT_NAME = "IM A MAGIC PRODUCT";
    private static final String PRODUCT_SKU = "IM A MAGIC PRODUCT SKU";
    private static final double PRODUCT_PRICE = 69.69d;


    private static final String FIRST_INVOICE_LINE = "IM A MAGIC PRODUCT - IM A MAGIC PRODUCT SKU";

    @BeforeEach
    public void setup() {
        factory = new InvoiceFactory();
    }

//    @Test
//    public void givenEmptyCart_whenCreateInvoice_thenReturnEmptyInvoiceList() {
//
//        Mockito.when(shoppingCart.getProducts()).thenReturn(new ArrayList<>());
//        Mockito.when(shoppingCart.getEmail()).thenReturn(EMAIL);
//
//        Invoice newInvoice = factory.createInvoice(shoppingCart);
//
//
//        assertEquals(expectedInvoice, newInvoice);
//    }


}
