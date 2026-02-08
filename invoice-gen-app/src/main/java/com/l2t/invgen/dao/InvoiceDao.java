package com.l2t.invgen.dao;

import com.l2t.invgen.domain.Invoice;
import com.l2t.invgen.domain.InvoiceLineItem;
import com.l2t.invgen.dto.InvoiceDto;

import java.util.List;

public interface InvoiceDao {

    List<InvoiceDto> selectAllInvoices();
    List<InvoiceLineItem> selectInvoiceLineItems(String invoiceNum);
    InvoiceDto selectInvoiceById(Integer id);
}
