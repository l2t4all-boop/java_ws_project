package com.l2t.invgen.service;

import com.l2t.invgen.domain.InvoiceLineItem;
import com.l2t.invgen.dto.InvoiceDto;

import java.util.List;

public interface InvoiceService {
    List<InvoiceDto> getAllInvoices();
    List<InvoiceLineItem> getInvoiceLineItems(String invoiceNum);
    InvoiceDto getInvoiceById(Integer id);
}
