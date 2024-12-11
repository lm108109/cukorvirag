package org.example.twenty_points.service.impl;

import org.example.twenty_points.model.dto.StorageDto;
import org.example.twenty_points.model.entity.Cookie;
import org.example.twenty_points.model.entity.Order;
import org.example.twenty_points.model.entity.Recipe;
import org.example.twenty_points.model.entity.Storage;
import org.example.twenty_points.repository.CookieRepository;
import org.example.twenty_points.repository.OrderRepository;
import org.example.twenty_points.repository.RecipeRepository;
import org.example.twenty_points.repository.StorageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

class StorageServiceImplTest {

    @Mock
    private StorageRepository storageRepository;

    @Mock
    private CookieRepository cookieRepository;

    @Mock
    private RecipeRepository recipeRepository;

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private StorageServiceImpl storageService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addStorageAddsNewItem() {
        Storage storage = new Storage();
        storage.setId(1L);
        storage.setIngredientName("Flour");
        storage.setQuantity(10.0);

        when(storageRepository.findMaxId()).thenReturn(0L);
        when(storageRepository.save(any(Storage.class))).thenReturn(storage);

        StorageDto result = storageService.addStorage("Flour", 10L);

        assertEquals("Flour", result.getName());
        assertEquals(10.0, result.getQuantity());
    }

    @Test
    void getStorageReturnsListOfStorageDtos() {
        Storage storage = new Storage();
        storage.setIngredientName("Flour");
        storage.setQuantity(10.0);

        when(storageRepository.findAll()).thenReturn(List.of(storage));

        List<StorageDto> result = storageService.getStorage();

        assertEquals(1, result.size());
        assertEquals("Flour", result.get(0).getName());
        assertEquals(10.0, result.get(0).getQuantity());
    }

    @Test
    void updateStorageUpdatesExistingItem() {
        Storage storage = new Storage();
        storage.setIngredientName("Flour");
        storage.setQuantity(10.0);

        when(storageRepository.findByIngredientName("Flour")).thenReturn(storage);
        when(storageRepository.save(any(Storage.class))).thenReturn(storage);

        StorageDto result = storageService.updateStorage("Flour", 5L);

        assertEquals("Flour", result.getName());
        assertEquals(15.0, result.getQuantity());
    }

    @Test
    void checkStorageReturnsTrueWhenSufficientQuantity() {
        Order order = new Order();
        order.setQuantity(4);
        Cookie cookie = new Cookie();
        cookie.setId(1L);
        Recipe recipe = new Recipe();
        recipe.setStorageId(1L);
        recipe.setRequiredQuantity(1.0);
        Storage storage = new Storage();
        storage.setQuantity(2.0);

        when(orderRepository.findById(1L)).thenReturn(order);
        when(cookieRepository.findCookieByName("Chocolate Chip")).thenReturn(cookie);
        when(recipeRepository.findByCookieId(1L)).thenReturn(List.of(recipe));
        when(storageRepository.findById(1L)).thenReturn(Optional.of(storage));

        Boolean result = storageService.checkStorage("Chocolate Chip", 1L);

        assertTrue(result);
    }

    @Test
    void checkStorageReturnsFalseWhenInsufficientQuantity() {
        Order order = new Order();
        order.setQuantity(4);
        Cookie cookie = new Cookie();
        cookie.setId(1L);
        Recipe recipe = new Recipe();
        recipe.setStorageId(1L);
        recipe.setRequiredQuantity(1.0);
        Storage storage = new Storage();
        storage.setQuantity(0.5);

        when(orderRepository.findById(1L)).thenReturn(order);
        when(cookieRepository.findCookieByName("Chocolate Chip")).thenReturn(cookie);
        when(recipeRepository.findByCookieId(1L)).thenReturn(List.of(recipe));
        when(storageRepository.findById(1L)).thenReturn(Optional.of(storage));

        Boolean result = storageService.checkStorage("Chocolate Chip", 1L);

        assertFalse(result);
    }

    @Test
    void checkStorageThrowsExceptionForNonExistentOrder() {
        when(orderRepository.findById(1L)).thenReturn(null);

        assertThrows(IllegalArgumentException.class, () -> storageService.checkStorage("Chocolate Chip", 1L));
    }

    @Test
    void checkStorageThrowsExceptionForNonExistentCookie() {
        Order order = new Order();
        when(orderRepository.findById(1L)).thenReturn(order);
        when(cookieRepository.findCookieByName("Chocolate Chip")).thenReturn(null);

        assertThrows(IllegalArgumentException.class, () -> storageService.checkStorage("Chocolate Chip", 1L));
    }

    @Test
    void checkStorageThrowsExceptionForNonExistentRecipe() {
        Order order = new Order();
        Cookie cookie = new Cookie();
        cookie.setId(1L);

        when(orderRepository.findById(1L)).thenReturn(order);
        when(cookieRepository.findCookieByName("Chocolate Chip")).thenReturn(cookie);
        when(recipeRepository.findByCookieId(1L)).thenReturn(Collections.emptyList());

        assertThrows(IllegalArgumentException.class, () -> storageService.checkStorage("Chocolate Chip", 1L));
    }

    @Test
    void checkStorageThrowsExceptionForNonExistentStorage() {
        Order order = new Order();
        Cookie cookie = new Cookie();
        cookie.setId(1L);
        Recipe recipe = new Recipe();
        recipe.setStorageId(1L);

        when(orderRepository.findById(1L)).thenReturn(order);
        when(cookieRepository.findCookieByName("Chocolate Chip")).thenReturn(cookie);
        when(recipeRepository.findByCookieId(1L)).thenReturn(List.of(recipe));
        when(storageRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> storageService.checkStorage("Chocolate Chip", 1L));
    }
}