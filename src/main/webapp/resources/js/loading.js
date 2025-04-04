const spinner = document.getElementById("spinner-overlay");

function showLoading() {
    spinner.style.display = "flex";
}

function hideLoading() {
    spinner.style.display = "none";
}

window.showLoading = showLoading;
window.hideLoading = hideLoading;