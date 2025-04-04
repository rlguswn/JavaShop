document.getElementById("orderRegister").addEventListener("submit", function(event) {
    event.preventDefault();

    window.showLoading();

    const forms = [];

    document.querySelectorAll("[data-product-id]").forEach(row => {
        let productId = row.getAttribute("data-product-id");
        let quantity = row.querySelector(".quantity").innerText;

        forms.push({
            productId: productId,
            quantity: quantity
        });
    });

    fetch("/order/register", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(forms),
        redirect: "manual"
    })
    .then(response => {
        console.log("Response:", response);
        window.hideLoading();
        window.location.href = "/order";
    })
    .catch(error => {
        console.error("Error:", error);
        alert("상품주문 중 문제가 발생했습니다.");
        window.hideLoading();
    })
})