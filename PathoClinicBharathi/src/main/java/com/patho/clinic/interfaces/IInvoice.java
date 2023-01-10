package com.patho.clinic.interfaces;

import com.patho.clinic.models.Invoice;
import com.patho.clinic.payloads.RequestPayload;

public interface IInvoice {

	public Invoice addInvoice(Invoice invoice);

	public Invoice findInvoiceById(RequestPayload request);
}
