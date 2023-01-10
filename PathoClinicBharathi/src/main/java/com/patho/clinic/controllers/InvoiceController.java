package com.patho.clinic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patho.clinic.interfaces.IInvoice;
import com.patho.clinic.models.Invoice;
import com.patho.clinic.payloads.RequestPayload;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class InvoiceController {

	@Autowired
	private IInvoice invoiceService;
	
	@PostMapping("/invoice")
	public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
		Invoice _invoice = invoiceService.addInvoice(invoice);
		return new ResponseEntity<>(_invoice, HttpStatus.CREATED);
	}
	
	@PostMapping("/getinvoice")
	public ResponseEntity<Invoice> getInvoiceById(@RequestBody RequestPayload request) {
		Invoice _invoice = invoiceService.findInvoiceById(request);
		return new ResponseEntity<>(_invoice, HttpStatus.CREATED);
	}
}
