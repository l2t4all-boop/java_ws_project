
const domain = "https://java-ws-project-1.onrender.com";
const baseUrl = `${domain}/api/v1/invoice`;
let allInvoices = [];
let filteredInvoices = [];
let currentPage = 1;
const itemsPerPage = 10;

function fetchInvoices() {
    console.log('Fetching invoices from API...');
    fetch(`${baseUrl}/all`)
        .then(response => response.json())
        .then(data => {
            console.log(data);
            allInvoices = data;
            filteredInvoices = data;
            currentPage = 1;
            renderPaginatedTable();
            renderPagination();
        })
        .catch(error => console.error('Error fetching invoices:', error));
}

function handleSearch() {
    const searchValue = document.getElementById('searchInput').value.toLowerCase();
    
    filteredInvoices = allInvoices.filter(invoice => {
        const invoiceNumber = invoice.invoiceNumber.toLowerCase();
        const userName = invoice.userName.toLowerCase();
        return invoiceNumber.includes(searchValue) || userName.includes(searchValue);
    });
    
    currentPage = 1;
    renderPaginatedTable();
    renderPagination();
}

function renderPaginatedTable() {
    const startIndex = (currentPage - 1) * itemsPerPage;
    const endIndex = startIndex + itemsPerPage;
    const paginatedInvoices = filteredInvoices.slice(startIndex, endIndex);
    
    renderInvoiceTable(paginatedInvoices);
}

function renderPagination() {
    const paginationContainer = document.querySelector('#paginationControls ul');
    paginationContainer.innerHTML = '';
    
    const totalPages = Math.ceil(filteredInvoices.length / itemsPerPage);
    
    if (totalPages <= 1) {
        return;
    }
    
    // Previous button
    const prevLi = document.createElement('li');
    prevLi.className = `page-item ${currentPage === 1 ? 'disabled' : ''}`;
    prevLi.innerHTML = `<a class="page-link" href="#" onclick="changePage(${currentPage - 1}); return false;">Previous</a>`;
    paginationContainer.appendChild(prevLi);
    
    // Page numbers
    for (let i = 1; i <= totalPages; i++) {
        const li = document.createElement('li');
        li.className = `page-item ${currentPage === i ? 'active' : ''}`;
        li.innerHTML = `<a class="page-link" href="#" onclick="changePage(${i}); return false;">${i}</a>`;
        paginationContainer.appendChild(li);
    }
    
    // Next button
    const nextLi = document.createElement('li');
    nextLi.className = `page-item ${currentPage === totalPages ? 'disabled' : ''}`;
    nextLi.innerHTML = `<a class="page-link" href="#" onclick="changePage(${currentPage + 1}); return false;">Next</a>`;
    paginationContainer.appendChild(nextLi);
}

function changePage(pageNumber) {
    const totalPages = Math.ceil(filteredInvoices.length / itemsPerPage);
    if (pageNumber >= 1 && pageNumber <= totalPages) {
        currentPage = pageNumber;
        renderPaginatedTable();
        renderPagination();
        window.scrollTo(0, 0);
    }
}

function renderInvoiceTable(invoices) {
    const tableContainer = document.getElementById('idInvoiceTable');
    let tableHtml = `
        <table class="table table-striped table-hover">
            <thead class="table-dark">
                <tr>
                    <th>Invoice Number</th>
                    <th>Customer Name</th>
                    <th>Invoice Date</th>
                    <th>Due Date</th>
                    <th>Total Amount</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
    `;

    invoices.forEach(invoice => {
        tableHtml += `
            <tr>
                <td><a href="invoice-details.html?invoiceId=${invoice.id}" class="text-decoration-none" style="cursor: pointer;">${invoice.invoiceNumber}</a></td>
                <td>${invoice.userName}</td>
                <td>${new Date(invoice.invoiceDate).toLocaleDateString()}</td>
                <td>${new Date(invoice.dueDate).toLocaleDateString()}</td>
                <td>$${invoice.totalAmount.toFixed(2)}</td>
                <td>
                    <button class="btn btn-sm btn-primary" onclick="downloadInvoice(${invoice.id})" title="Download Invoice">Download</button>
                    <button class="btn btn-sm btn-info" onclick="emailInvoice(${invoice.id})" title="Email Invoice">Email</button>
                    <button class="btn btn-sm btn-danger" onclick="deleteInvoice(${invoice.id})" title="Delete Invoice">Delete</button>
                </td>
            </tr>
        `;
    });

    tableHtml += `
            </tbody>
        </table>
    `;

    tableContainer.innerHTML = tableHtml;
}

function downloadInvoice(invoiceId) {
    console.log(`Downloading invoice ID: ${invoiceId}`);
    // Create a link to download the invoice as PDF or document
    window.location.href = `${baseUrl}/${invoiceId}/download`;
}

function emailInvoice(invoiceId) {
    console.log(`Sending invoice ID: ${invoiceId} via email`);
    fetch(`${baseUrl}/${invoiceId}/email`, {
        method: 'POST'
    })
    .then(response => {
        if (response.ok) {
            console.log('Invoice sent via email successfully');
            alert('Invoice has been sent successfully!');
        } else {
            alert('Failed to send invoice via email');
        }
    })
    .catch(error => {
        console.error('Error sending invoice via email:', error);
        alert('Error sending invoice via email');
    });
}

function deleteInvoice(invoiceId) {
    if (confirm('Are you sure you want to delete this invoice?')) {
        console.log(`Deleting invoice ID: ${invoiceId}`);
        fetch(`${baseUrl}/${invoiceId}`, {
            method: 'DELETE'
        })
        .then(response => {
            if (response.ok) {
                console.log('Invoice deleted successfully');
                // Refresh the invoice list
                fetchInvoices();
            } else {
                alert('Failed to delete invoice');
            }
        })
        .catch(error => {
            console.error('Error deleting invoice:', error);
            alert('Error deleting invoice');
        });
    }
}

// Fetch invoices when the page loads
document.addEventListener('DOMContentLoaded', fetchInvoices);  