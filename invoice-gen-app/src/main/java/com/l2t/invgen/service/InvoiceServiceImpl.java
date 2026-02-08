package com.l2t.invgen.service;

import com.l2t.invgen.dao.InvoiceDao;
import com.l2t.invgen.domain.InvoiceLineItem;
import com.l2t.invgen.dto.InvoiceDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceDao invoiceDao;

    @Override
    public List<InvoiceDto> getAllInvoices() {
        log.info("User requested for all invoices");
        List<InvoiceDto> invoiceDtos = invoiceDao.selectAllInvoices();
        log.info("Total {} invoices are sent", invoiceDtos.size());
        return invoiceDtos;
    }

    @Override
    public InvoiceDto getInvoiceById(Integer id) {
        log.info("Looking for invoice with id {}", id);
        InvoiceDto invoiceDto = invoiceDao.selectInvoiceById(id);
        log.info("Found invoice: {}", invoiceDto.getInvoiceNumber());
        return invoiceDto;
    }

    @Override
    public List<InvoiceLineItem> getInvoiceLineItems(String invoiceNum) {
        log.info("Looking for invoice item of {}", invoiceNum);
        List<InvoiceLineItem> invoiceLineItems = invoiceDao.selectInvoiceLineItems(invoiceNum);
        log.info("Invoice {} has {} line items", invoiceNum, invoiceLineItems.size());
        return invoiceLineItems;
    }
}
