// baseUrl is loaded from config.js
let allItems = [];
let filteredItems = [];
let currentItemPage = 1;
const itemsPerPage = 10;
let currentInvoiceNumber = '';

function getInvoiceIdFromURL() {
    const params = new URLSearchParams(window.location.search);
    return params.get('invoiceId');
}

function fetchInvoiceDetails() {
    const invoiceId = getInvoiceIdFromURL();
    
    if (!invoiceId) {
        console.error('No invoice ID provided');
        return;
    }

    console.log(`Fetching details for invoice ID: ${invoiceId}`);
    
    // Fetch invoice details
    fetch(`${baseUrl}/${invoiceId}`)
        .then(response => response.json())
        .then(data => {
            console.log('Invoice Data:', data);
            currentInvoiceNumber = data.invoiceNumber;
            renderInvoiceInfo(data);
            // Fetch invoice items using invoice number
            fetchInvoiceItems(data.invoiceNumber);
        })
        .catch(error => console.error('Error fetching invoice details:', error));
}

function fetchInvoiceItems(invoiceNumber) {
    console.log(`Fetching items for invoice number: ${invoiceNumber}`);
    fetch(`${baseUrl}/items/${invoiceNumber}`)
        .then(response => response.json())
        .then(data => {
            console.log('Invoice Items:', data);
            allItems = data;
            filteredItems = data;
            currentItemPage = 1;
            renderPaginatedItems();
            renderItemPagination();
        })
        .catch(error => console.error('Error fetching invoice items:', error));
}

function handleItemSearch() {
    const searchValue = document.getElementById('searchItemInput').value.toLowerCase();
    
    filteredItems = allItems.filter(item => {
        const serviceId = item.serviceId.toLowerCase();
        return serviceId.includes(searchValue);
    });
    
    currentItemPage = 1;
    renderPaginatedItems();
    renderItemPagination();
}

function renderPaginatedItems() {
    const startIndex = (currentItemPage - 1) * itemsPerPage;
    const endIndex = startIndex + itemsPerPage;
    const paginatedItems = filteredItems.slice(startIndex, endIndex);
    
    renderInvoiceItems(paginatedItems);
}

function renderItemPagination() {
    const paginationContainer = document.querySelector('#itemPaginationControls ul');
    paginationContainer.innerHTML = '';
    
    const totalPages = Math.ceil(filteredItems.length / itemsPerPage);
    
    if (totalPages <= 1) {
        return;
    }
    
    // Previous button
    const prevLi = document.createElement('li');
    prevLi.className = `page-item ${currentItemPage === 1 ? 'disabled' : ''}`;
    prevLi.innerHTML = `<a class="page-link" href="#" onclick="changeItemPage(${currentItemPage - 1}); return false;">Previous</a>`;
    paginationContainer.appendChild(prevLi);
    
    // Page numbers
    for (let i = 1; i <= totalPages; i++) {
        const li = document.createElement('li');
        li.className = `page-item ${currentItemPage === i ? 'active' : ''}`;
        li.innerHTML = `<a class="page-link" href="#" onclick="changeItemPage(${i}); return false;">${i}</a>`;
        paginationContainer.appendChild(li);
    }
    
    // Next button
    const nextLi = document.createElement('li');
    nextLi.className = `page-item ${currentItemPage === totalPages ? 'disabled' : ''}`;
    nextLi.innerHTML = `<a class="page-link" href="#" onclick="changeItemPage(${currentItemPage + 1}); return false;">Next</a>`;
    paginationContainer.appendChild(nextLi);
}

function changeItemPage(pageNumber) {
    const totalPages = Math.ceil(filteredItems.length / itemsPerPage);
    if (pageNumber >= 1 && pageNumber <= totalPages) {
        currentItemPage = pageNumber;
        renderPaginatedItems();
        renderItemPagination();
        window.scrollTo(0, document.querySelector('.card').offsetTop);
    }
}

function renderInvoiceInfo(invoice) {
    const invoiceInfoContainer = document.getElementById('invoiceInfo');
    
    const invoiceHtml = `
        <div class="card-body">
            <div class="row">
                <div class="col-md-6">
                    <p><strong>Invoice Number:</strong> ${invoice.invoiceNumber}</p>
                    <p><strong>Customer Name:</strong> ${invoice.userName}</p>
                    <p><strong>Invoice Date:</strong> ${new Date(invoice.invoiceDate).toLocaleDateString()}</p>
                </div>
                <div class="col-md-6">
                    <p><strong>Due Date:</strong> ${new Date(invoice.dueDate).toLocaleDateString()}</p>
                    <p><strong>Total Amount:</strong> $${invoice.totalAmount.toFixed(2)}</p>
                </div>
            </div>
        </div>
    `;
    
    invoiceInfoContainer.innerHTML = invoiceHtml;
}

function renderInvoiceItems(items) {
    const itemsContainer = document.getElementById('invoiceItemsTable');
    
    if (!items || items.length === 0) {
        itemsContainer.innerHTML = '<p class="text-muted">No items found for this invoice.</p>';
        return;
    }

    let tableHtml = `
        <table class="table table-striped table-hover">
            <thead class="table-dark">
                <tr>
                    <th>Service ID</th>
                    <th>Units</th>
                    <th>Unit Price</th>
                    <th>Line Total</th>
                    <th>Item Date</th>
                </tr>
            </thead>
            <tbody>
    `;

    items.forEach(item => {
        tableHtml += `
            <tr>
                <td>${item.serviceId}</td>
                <td>${item.units}</td>
                <td>$${item.unitPrice.toFixed(2)}</td>
                <td>$${item.lineTotal.toFixed(2)}</td>
                <td>${new Date(item.itemDate).toLocaleDateString()}</td>
            </tr>
        `;
    });

    tableHtml += `
            </tbody>
        </table>
    `;

    itemsContainer.innerHTML = tableHtml;
}

// Fetch invoice details when the page loads
document.addEventListener('DOMContentLoaded', fetchInvoiceDetails);
