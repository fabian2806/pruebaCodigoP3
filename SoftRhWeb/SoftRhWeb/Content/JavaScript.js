document.addEventListener("DOMContentLoaded", function () {
    const cartButtons = document.querySelectorAll('.product button');

    cartButtons.forEach(button => {
        button.addEventListener('click', () => {
            alert('Producto añadido al carrito');
        });
    });
});
