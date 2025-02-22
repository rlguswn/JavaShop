document.getElementById("productRegisterForm").addEventListener("submit", function(event) {
    event.preventDefault();

    const formData = new FormData();

    formData.append("name", document.getElementById("name").value);
    formData.append("description", document.getElementById("description").value);
    formData.append("price", document.getElementById("price").value);
    formData.append("quantity", document.getElementById("quantity").value);

    const imageInput = document.getElementById("image")
    if (imageInput.files.length > 0) {
        formData.append("image", imageInput.files[0])
    } else {
        formData.append("image", new Blob())
    }

    fetch("/product/register", {
        method: "POST",
        body: formData,
        redirect: "manual"
    })
    .then(response => {
        console.log("Response:", response);
        window.location.href = "/";
    })
    .catch(error => {
        console.error("Error:", error);
        alert("상품등록 중 문제가 발생했습니다.");
    })
})