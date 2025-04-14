const spinner = document.getElementById("spinner-overlay");

function showLoading() {
    spinner.style.display = "flex";
}

function hideLoading() {
    spinner.style.display = "none";
}

function handleFormSubmit(event) {
    showLoading();

//    setTimeout(() => {
//        event.target.submit();
//    }, 500);
//    return false;
    return true;
}