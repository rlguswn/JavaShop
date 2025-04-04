document.getElementById("cartItemRegister").addEventListener("submit", function(event) {
    event.preventDefault();

    window.showLoading();

    const formData = new URLSearchParams();
    const productId = document.getElementById("productId").value;

    formData.append("productId", productId);
    formData.append("quantity", document.getElementById("quantity").value);

    fetch("/cart/add", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: formData,
        redirect: "manual"
    })
    .then(response => {
        console.log("Response:", response);
        window.hideLoading();
        window.location.href = `/product/${productId}`;
    })
    .catch(error => {
        console.error("Error:", error);
        alert("상품등록 중 문제가 발생했습니다.");
        window.hideLoading();
    })
})