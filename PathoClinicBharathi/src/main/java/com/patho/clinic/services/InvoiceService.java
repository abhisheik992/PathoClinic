package com.patho.clinic.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patho.clinic.interfaces.IInvoice;
import com.patho.clinic.models.Invoice;
import com.patho.clinic.models.InvoiceDetails;
import com.patho.clinic.models.PackagePrice;
import com.patho.clinic.models.Price;
import com.patho.clinic.payloads.RequestPayload;
import com.patho.clinic.repositories.InvoiceRepository;
import com.patho.clinic.repositories.PackagePriceRepository;
import com.patho.clinic.repositories.PriceRepository;

@Service
public class InvoiceService implements IInvoice {
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	@Autowired
	private PriceRepository priceRepository;
	
	@Autowired
	private PackagePriceRepository packagePriceRepository;

	@Override
	public Invoice addInvoice(Invoice invoice) {
		double total = 0;
		try {
			
			if(invoice.getInvoiceDetailsList().size()>0) {
				for (InvoiceDetails details : invoice.getInvoiceDetailsList()) {
					if(details.getProduct()!= null) {
						Optional<Price> productDetail = priceRepository.findById(details.getProduct().getId());
						if(productDetail.isPresent()) {
							details.setPrice(productDetail.get().getCost());
							total = total+ productDetail.get().getCost();
						}
					}
					
					if(details.getProductPackage()!= null) {
						Optional<PackagePrice> packageDetail = packagePriceRepository.findById(details.getProductPackage().getId());
						if(packageDetail.isPresent()) {
							details.setPrice(packageDetail.get().getCost());
							total = total+ packageDetail.get().getCost();
						}
					}
					
				}
				invoice.setTotal(total);
				return this.invoiceRepository.save(invoice);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Invoice findInvoiceById(RequestPayload request) {
		return this.invoiceRepository.findById(request.getId()).get();
	}

}
