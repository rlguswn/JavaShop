document.getElementById("loginForm").addEventListener("submit", function(event) {
    event.preventDefault();

    window.showLoading();

    const formData = new URLSearchParams();

    formData.append("email", document.getElementById("email").value);
    formData.append("password", document.getElementById("password").value);

    fetch("/login", {
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
        window.location.href = "/";
    })
    .catch(error => {
        console.error("Error:", error);
        alert("로그인 중 문제가 발생했습니다.");
        window.hideLoading();
    })
})