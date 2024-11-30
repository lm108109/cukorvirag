package org.example.twenty_points.service.impl;

import org.example.twenty_points.model.dto.StorageDto;
import org.example.twenty_points.model.entity.Storage;
import org.example.twenty_points.repository.StorageRepository;
import org.example.twenty_points.service.StorageService;
import org.example.twenty_points.util.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StorageServiceImpl implements StorageService {

    private final StorageRepository storageRepository;

    public StorageServiceImpl(StorageRepository storageRepository) {
        this.storageRepository = storageRepository;
    }


    @Override
    public StorageDto addStorage(String name, Long quantity) {
        Storage newItem = new Storage();
        newItem.setId(storageRepository.findMaxId() + 1);
        newItem.setIngredientName(name);
        newItem.setQuantity(quantity);
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
            storageDtos.add(dto);
        });
        return storageDtos;
    }


    @Override
    public StorageDto updateStorage(String name, Long quantity) {
        Storage storage = storageRepository.findByIngredientName(name);
        storage.setQuantity(quantity);
        storageRepository.save(storage);
        return new StorageDto(storage);
    }
}
