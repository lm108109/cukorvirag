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
import org.example.twenty_points.service.StorageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StorageServiceImpl implements StorageService {

    private final StorageRepository storageRepository;
    private final CookieRepository cookieRepository;
    private final RecipeRepository recipeRepository;
    private final OrderRepository orderRepository;

    public StorageServiceImpl(StorageRepository storageRepository, CookieRepository cookieRepository, RecipeRepository recipeRepository, OrderRepository orderRepository) {
        this.storageRepository = storageRepository;
        this.cookieRepository = cookieRepository;
        this.recipeRepository = recipeRepository;
        this.orderRepository = orderRepository;
    }


    @Override
    public StorageDto addStorage(String name, Long quantity) {
        Storage newItem = new Storage();
        newItem.setId(storageRepository.findMaxId() + 1);
        newItem.setIngredientName(name);
        newItem.setQuantity(Double.valueOf(quantity));
        storageRepository.save(newItem);
        return new StorageDto(newItem);
    }

    @Override
    public List<StorageDto> getStorage() {
        List<StorageDto> storageDtos = new ArrayList<>();
        storageRepository.findAll().forEach(storage -> {
            StorageDto dto = new StorageDto();
            dto.setIngredientName(storage.getIngredientName());
            dto.setQuantity(storage.getQuantity());
            dto.setUnit(storage.getUnit());
            storageDtos.add(dto);
        });
        return storageDtos;
    }


    @Override
    public StorageDto updateStorage(String name, Long quantity) {
        Storage storage = storageRepository.findByIngredientName(name);
        storage.setQuantity(storage.getQuantity() + quantity);
        storageRepository.save(storage);
        return new StorageDto(storage);
    }

    @Override
    public StorageDto updateStorage(StorageDto storageDto) {
        return null;
    }

    @Override
    public Boolean checkStorage(String name, Long orderId) {
        List<Long> ids = new ArrayList<>();
        ids.add(2L);
        ids.add(29L);
        ids.add(42L);
        Order order = orderRepository.findById(orderId);
        if (order == null) {
            throw new IllegalArgumentException("Order with ID " + orderId + " does not exist.");
        }

        Cookie cookie = cookieRepository.findCookieByName(name);
        if (cookie == null) {
            throw new IllegalArgumentException("Cookie with name " + name + " does not exist.");
        }

        List<Recipe> recipes = recipeRepository.findByCookieId(cookie.getId());
        if (recipes == null || recipes.isEmpty()) {
            throw new IllegalArgumentException("No recipes found for cookie with name " + name);
        }

        for (Recipe recipe : recipes) {
            Optional<Storage> optionalStorage = storageRepository.findById(recipe.getStorageId());

            if (optionalStorage.isEmpty()) {
                throw new IllegalArgumentException("Storage with ID " + recipe.getStorageId() + " does not exist.");
            }

            Storage storage = optionalStorage.get();

            double requiredQuantity;

            if (ids.contains(storage.getId())) {
                requiredQuantity = storage.getQuantity();
            }
            else {
                requiredQuantity = ((double) order.getQuantity() / 4) * recipe.getRequiredQuantity();
            }

            if (storage.getQuantity() < requiredQuantity) {
                return false;
            }
        }

        for (Recipe recipe : recipes) {
            Optional<Storage> optionalStorage = storageRepository.findById(recipe.getStorageId());

            if (optionalStorage.isEmpty()) {
                throw new IllegalArgumentException("Storage with ID " + recipe.getStorageId() + " does not exist.");
            }

            Storage storage = optionalStorage.get();

            if (ids.contains(storage.getId())) {
                storage.setQuantity(storage.getQuantity() - recipe.getRequiredQuantity());
            }
            else {
                double requiredQuantity = ((double) order.getQuantity() / 4) * recipe.getRequiredQuantity();

                storage.setQuantity( storage.getQuantity() - requiredQuantity);
            }

            storageRepository.save(storage);
        }
        return true;
    }

}
