package rlguswn.JavaShop.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import rlguswn.JavaShop.domain.CartItem;
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

    public CartItem addCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    public void updateCartItem(Long id, int quantity) {
        cartItemRepository.findById(id).ifPresent(cartItem ->
                cartItem.setQuantity(quantity));
    }

    public List<CartItem> getCartItemByCartId(Long id) {
        return cartItemRepository.findByCartId(id);
    }
}
