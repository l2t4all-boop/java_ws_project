package com.l2t.invgen.controller;

import com.l2t.invgen.domain.InvoiceLineItem;
import com.l2t.invgen.dto.InvoiceDto;
import com.l2t.invgen.dto.InvoiceItemDto;
import com.l2t.invgen.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/invoice")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;

    @GetMapping("/all")
    public ResponseEntity<List<InvoiceDto>> getInvoices(){
        List<InvoiceDto> invoiceDtos = invoiceService.getAllInvoices();
        return ResponseEntity.ok(invoiceDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceDto> getInvoiceById(@PathVariable("id") Integer id) {
        InvoiceDto invoiceDto = invoiceService.getInvoiceById(id);
        return ResponseEntity.ok(invoiceDto);
    }

    @GetMapping("/items/{invoiceNum}")
    public ResponseEntity<List<InvoiceLineItem>> getInvoiceLineItems(@PathVariable("invoiceNum")String invoiceNum){
        List<InvoiceLineItem> invoiceLineItems = invoiceService.getInvoiceLineItems(invoiceNum);
        return ResponseEntity.ok(invoiceLineItems);
    }
}
