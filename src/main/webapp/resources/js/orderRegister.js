document.getElementById("orderRegister").addEventListener("submit", function(event) {
    event.preventDefault();

    const formData = new URLSearchParams();
    let index = 0;

    while (document.getElementById(`productId${index}`)) {
        let productId = document.getElementById(`productId${index}`).innerText;
        let quantity = document.getElementById(`quantity${index}`).innerText;

        formData.append(`forms[${index}].productId`, productId);
        formData.append(`forms[${index}].quantity`, quantity);

        index++;
    }

    fetch("/order/register", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: formData,
        redirect: "manual"
    })
    .then(response => {
        console.log("Response:", response);
        window.location.href = "/order";
    })
    .catch(error => {
        console.error("Error:", error);
        alert("상품주문 중 문제가 발생했습니다.");
    })
})