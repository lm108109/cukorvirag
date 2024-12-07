package org.example.twenty_points.service;

import org.example.twenty_points.model.dto.StorageDto;

import java.util.List;

public interface StorageService {

    StorageDto addStorage(String name, Long quantity);

    List<StorageDto> getStorage();
    StorageDto updateStorage(String name, Long quantity);
}
