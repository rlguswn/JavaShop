package rlguswn.JavaShop.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import rlguswn.JavaShop.domain.Cart;
import rlguswn.JavaShop.domain.CartItem;
import rlguswn.JavaShop.domain.Product;
import rlguswn.JavaShop.dto.cart.CartItemRegisterForm;
import rlguswn.JavaShop.repository.CartItemRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CartItemService {

    private final CartItemRepository cartItemRepository;

    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public Optional<CartItem> getCartItemById(Long id) {
        return cartItemRepository.findById(id);
    }

    public CartItem addCartItem(CartItemRegisterForm form, Product product, Cart cart) {
        CartItem cartItem = new CartItem(
                form.getQuantity(),
                product,
                cart
        );
        return cartItemRepository.save(cartItem);
    }

    public void updateCartItem(Long id, int quantity) {
        cartItemRepository.findById(id).ifPresent(cartItem ->
                cartItem.setQuantity(quantity));
    }

    public List<CartItem> getCartItemByCartId(Long id) {
        return cartItemRepository.findByCartId(id);
    }

    public boolean deleteById(Long id) {
        return cartItemRepository.deleteById(id);
    }

    public void deleteByCartId(Long id) {
        List<CartItem> cartItems = cartItemRepository.findByCartId(id);
        for (CartItem cartItem : cartItems) {
            cartItemRepository.deleteById(cartItem.getId());
        }
    }
}
