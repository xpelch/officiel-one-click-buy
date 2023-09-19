package ca.ulaval.glo4002.mockexercise;

import ca.ulaval.glo4002.mockexercise.do_not_edit.InvoiceLine;
import ca.ulaval.glo4002.mockexercise.do_not_edit.Invoice;

import java.util.List;
import java.util.stream.Collectors;

public class InvoiceFactory {

    public InvoiceFactory() {
    }

    public Invoice createInvoice(Cart cart) {
        List<InvoiceLine> invoiceLines = cart.getProducts()
                .stream()
                .map(this::createInvoiceLine)
                .collect(Collectors.toList());

        return new Invoice(cart.getEmail(), invoiceLines);
    }

    private InvoiceLine createInvoiceLine(Product product) {
        String lineText = product.getName() + " - " + product.getSku();
        return new InvoiceLine(lineText, product.getPrice());
    }
}
