package ca.ulaval.glo4002.mockexercise;

import ca.ulaval.glo4002.mockexercise.do_not_edit.CartFactory;
import ca.ulaval.glo4002.mockexercise.do_not_edit.Invoice;
import ca.ulaval.glo4002.mockexercise.do_not_edit.InvoiceLine;
import ca.ulaval.glo4002.mockexercise.do_not_edit.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class StartByTestingThisTest {

    private StartByTestingThis service;
    private final CartFactory cartFactory = Mockito.mock(CartFactory.class);
    private final ProductRepository productRepository = Mockito.mock(ProductRepository.class);
    private final InvoiceFactory invoiceFactory = Mockito.mock(InvoiceFactory.class);
    private final Product product = Mockito.mock(Product.class);
    private final Cart shoppingCart = Mockito.mock(Cart.class);
    private static final String PRODUCT_SKU = "PRODUCT_SKU";
    private static final String CLIENT_EMAIL = "EMAIL@BENCOOL.COM";
    private static final String PRODUCT_NAME = "BIG DINDON";
    private static final double PRODUCT_PRICE = 69.696;


    // Phase Rouge, Phase Verte, Phase Bleue

    @BeforeEach
    public void setUp() {
        service = new StartByTestingThis(cartFactory, productRepository, invoiceFactory);
    }
    @AfterEach
    public void cleanUp(){
        Mockito.reset(cartFactory);
        Mockito.reset(productRepository);
        Mockito.reset(product);
        Mockito.reset(shoppingCart);
        Mockito.reset(invoiceFactory);
    }

    // Étape 1 : Créer le cart avec le CartFactory
    @Test
    public void whenOneClickBuy_thenCreateCartIsCalled() {
        Mockito.when(cartFactory.create(CLIENT_EMAIL)).thenReturn(shoppingCart);

        service.oneClickBuy(CLIENT_EMAIL, PRODUCT_SKU);

        Mockito.verify(cartFactory).create(CLIENT_EMAIL);
    }

    // Étape 2 : Trouver le produit avec le ProductRepository
    @Test
    public void whenOneClickBuy_thenFindProductIsCalled() {
        Mockito.when(cartFactory.create(CLIENT_EMAIL)).thenReturn(shoppingCart);
        Mockito.when(productRepository.findBySku(PRODUCT_SKU)).thenReturn(product);

        service.oneClickBuy(CLIENT_EMAIL, PRODUCT_SKU);

        Mockito.verify(productRepository).findBySku(PRODUCT_SKU);
    }

    // Étape 3 : Ajouter le produit au cart
    @Test
    public void whenOneClickBuy_thenAddProductToCart() {
        Mockito.when(cartFactory.create(CLIENT_EMAIL)).thenReturn(shoppingCart);
        Mockito.when(productRepository.findBySku(PRODUCT_SKU)).thenReturn(product);

        service.oneClickBuy(CLIENT_EMAIL, PRODUCT_SKU);

        Mockito.verify(shoppingCart).addProduct(product);
    }

    // Étape 4 : Pour chaque item du cart, ajouter une ligne sur l'invoice
    @Test
    public void whenOneClickBuy_thenInvoiceIsCreated() {
        Mockito.when(cartFactory.create(CLIENT_EMAIL)).thenReturn(shoppingCart);
        Mockito.when(productRepository.findBySku(PRODUCT_SKU)).thenReturn(product);

        service.oneClickBuy(CLIENT_EMAIL, PRODUCT_SKU);

        Mockito.verify(invoiceFactory).createInvoice(shoppingCart);
    }

    // Étape 5 : Retourner l'invoice
    @Test
    public void whenOneClickBuy_thenReturnInvoice() {
        Mockito.when(cartFactory.create(CLIENT_EMAIL)).thenReturn(shoppingCart);
        Mockito.when(productRepository.findBySku(PRODUCT_SKU)).thenReturn(product);

        Invoice invoice = service.oneClickBuy(CLIENT_EMAIL, PRODUCT_SKU);

        Assertions.
    }

}
