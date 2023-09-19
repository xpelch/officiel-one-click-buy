package ca.ulaval.glo4002.mockexercise;

import ca.ulaval.glo4002.mockexercise.do_not_edit.CartFactory;
import ca.ulaval.glo4002.mockexercise.do_not_edit.Invoice;
import ca.ulaval.glo4002.mockexercise.do_not_edit.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StartByTestingThisTest {

    @InjectMocks
    private StartByTestingThis service;
    @Mock
    private CartFactory cartFactory;
    @Mock
    private ProductRepository productRepository;
    @Mock
    private InvoiceFactory invoiceFactory;
    @Mock
    private Invoice invoice;
    @Mock
    private Product product;
    @Mock
    private Cart shoppingCart;
    private static final String PRODUCT_SKU = "PRODUCT_SKU";
    private static final String CLIENT_EMAIL = "EMAIL@BENCOOL.COM";

    @Test
    public void whenOneClickBuy_thenCreateCartIsCalled() {
        when(cartFactory.create(CLIENT_EMAIL)).thenReturn(shoppingCart);

        service.oneClickBuy(CLIENT_EMAIL, PRODUCT_SKU);

        verify(cartFactory).create(CLIENT_EMAIL);
    }

    @Test
    public void whenOneClickBuy_thenFindProductIsCalled() {
        when(cartFactory.create(anyString())).thenReturn(shoppingCart);
        when(productRepository.findBySku(anyString())).thenReturn(product);

        service.oneClickBuy(CLIENT_EMAIL, PRODUCT_SKU);

        verify(productRepository).findBySku(PRODUCT_SKU);
    }

    @Test
    public void whenOneClickBuy_thenAddProductToCart() {
        when(cartFactory.create(anyString())).thenReturn(shoppingCart);
        when(productRepository.findBySku(anyString())).thenReturn(product);

        service.oneClickBuy(CLIENT_EMAIL, PRODUCT_SKU);

        verify(shoppingCart).addProduct(product);
    }

    @Test
    public void whenOneClickBuy_thenInvoiceIsCreated() {
        when(cartFactory.create(anyString())).thenReturn(shoppingCart);
        when(productRepository.findBySku(anyString())).thenReturn(product);

        service.oneClickBuy(CLIENT_EMAIL, PRODUCT_SKU);

        verify(invoiceFactory).createInvoice(shoppingCart);
    }

    @Test
    public void whenOneClickBuy_thenReturnInvoice() {
        when(cartFactory.create(anyString())).thenReturn(shoppingCart);
        when(productRepository.findBySku(anyString())).thenReturn(product);
        when(invoiceFactory.createInvoice(shoppingCart)).thenReturn(invoice);

        Invoice returnedInvoice = service.oneClickBuy(CLIENT_EMAIL, PRODUCT_SKU);

        assertEquals(invoice, returnedInvoice);
    }
}