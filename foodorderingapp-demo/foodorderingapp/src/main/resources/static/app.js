const output = document.getElementById('output');
const canteenGrid = document.getElementById('canteenGrid');
const menuGrid = document.getElementById('menuGrid');
const orderOutput = document.getElementById('orderOutput');

function toText(message) {
    output.textContent = message;
}

function scrollToSection(id) {
    const el = document.getElementById(id);
    if (el) el.scrollIntoView({ behavior: 'smooth', block: 'start' });
}

async function loadCanteens() {
    const res = await fetch('/canteens');
    const items = await res.json();
    canteenGrid.innerHTML = items.map(canteen => `
        <article class="card">
            <div class="card-image" style="background-image:url('${canteen.imageUrl}')"></div>
            <div class="card-body">
                <h4>${canteen.name}</h4>
                <p>${canteen.description}</p>
                <small>${canteen.location}</small>
            </div>
        </article>
    `).join('');
}

async function loadMenu() {
    const res = await fetch('/menu');
    const items = await res.json();
    menuGrid.innerHTML = items.map(item => `
        <article class="card">
            <div class="card-image" style="background-image:url('https://images.unsplash.com/photo-1504674900247-0877df9cc836?auto=format&fit=crop&w=800&q=80')"></div>
            <div class="card-body">
                <h4>${item.name}</h4>
                <p>₹${item.price.toFixed(2)} • ${item.available ? 'Available' : 'Unavailable'}</p>
                <small>ID: ${item.itemId}</small>
            </div>
        </article>
    `).join('');
}

async function loadOrders() {
    const res = await fetch('/student/orders');
    const orders = await res.json();
    if (!orders.length) {
        orderOutput.textContent = 'No active orders yet.';
        return;
    }
    orderOutput.textContent = orders.map(order => {
        return `Order ${order.orderId} | Status: ${order.status} | Collected: ${order.collected} | QR: ${order.qrToken}`;
    }).join('\n');
}

async function studentLogin() {
    const res = await fetch('/student/login');
    const text = await res.text();
    toText(text);
}

async function adminLogin() {
    toText('Admin portal is ready. Use the admin panel to manage items.');
}

async function placeOrder() {
    const orderId = document.getElementById('orderId').value || '101';
    const res = await fetch(`/student/order?orderId=${encodeURIComponent(orderId)}`, { method: 'POST' });
    const text = await res.text();
    toText(text);
    await loadOrders();
}

async function payOrder() {
    const orderId = document.getElementById('payOrderId').value || '101';
    const res = await fetch(`/student/pay?orderId=${encodeURIComponent(orderId)}`, { method: 'POST' });
    const text = await res.text();
    toText(text);
    await loadOrders();
}

async function addMenuItem() {
    const itemId = document.getElementById('itemId').value || '101';
    const itemName = document.getElementById('itemName').value || 'Samosa';
    const itemPrice = document.getElementById('itemPrice').value || '35';
    const available = document.getElementById('itemAvailable').value;
    const url = `/admin/add-item?itemId=${encodeURIComponent(itemId)}&name=${encodeURIComponent(itemName)}&price=${encodeURIComponent(itemPrice)}&available=${encodeURIComponent(available)}`;
    const res = await fetch(url, { method: 'POST' });
    const text = await res.text();
    toText(text);
    await loadMenu();
}

async function collectOrder() {
    const qrToken = document.getElementById('qrToken').value;
    const res = await fetch(`/canteen/collect?qr=${encodeURIComponent(qrToken)}`, { method: 'POST' });
    const text = await res.text();
    toText(text);
    await loadOrders();
}

window.addEventListener('load', async () => {
    await loadCanteens();
    await loadMenu();
    await loadOrders();
    toText('Campus Bites is live. Use the controls to manage orders.');
});
