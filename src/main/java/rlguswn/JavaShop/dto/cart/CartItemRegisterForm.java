package rlguswn.JavaShop.dto.cart;

public class CartItemRegisterForm {

    private Long quantity;
    private Long productId;

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
