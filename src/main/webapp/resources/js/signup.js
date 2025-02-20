document.getElementById("signupForm").addEventListener("submit", function(event) {
    event.preventDefault();

    const formData = {
        email: document.getElementById("email").value,
        password: document.getElementById("password").value,
        username: document.getElementById("username").value,
        address: document.getElementById("address").value
    };

    fetch("/signup", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(formData),
        redirect: "manual"
    })
    .then(response => {
        console.log("Response:", response);
        window.location.href = "/login";
    })
    .catch(error => {
        console.error("Error:", error);
        alert("회원가입 중 문제가 발생했습니다.");
    })
})