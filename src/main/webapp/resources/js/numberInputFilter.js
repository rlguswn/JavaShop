document.addEventListener("DOMContentLoaded", function() {
    function applyNumberInputFilter(element) {
        document.getElementById(element).forEach(input => {
            input.addEventListener("input", function (event) {
                event.target.value = event.target.value.replace(/[^0-9]/g, '');
            })
        })
    }

    applyNumberInputFilter("price");
    applyNumberInputFilter("quantity");
});
