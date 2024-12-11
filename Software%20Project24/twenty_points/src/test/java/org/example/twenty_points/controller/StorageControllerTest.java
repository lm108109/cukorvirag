package org.example.twenty_points.controller;

import org.example.twenty_points.model.dto.StorageDto;
import org.example.twenty_points.model.entity.Storage;
import org.example.twenty_points.repository.StorageRepository;
import org.example.twenty_points.service.StorageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class StorageControllerTest {
	
	private StorageService storageService;
	private StorageRepository storageRepository;
	private StorageController storageController;
	
	@BeforeEach
	void setUp() {
		storageService = mock(StorageService.class);
		storageRepository = mock(StorageRepository.class);
		storageController = new StorageController(storageService, storageRepository);
	}
	
	@Test
	void addItemShouldReturnUnprocessableEntityWhenItemExists() {
		when(storageRepository.findByIngredientName(anyString())).thenReturn(new Storage());
		
		ResponseEntity<StorageDto> response = storageController.addItem("itemName", 10L);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@Test
	void addItemShouldReturnStorageDtoWhenItemDoesNotExist() {
		when(storageRepository.findByIngredientName(anyString())).thenReturn(null);
		StorageDto storageDto = new StorageDto();
		when(storageService.addStorage(anyString(), anyLong())).thenReturn(storageDto);
		
		ResponseEntity<StorageDto> response = storageController.addItem("itemName", 10L);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isEqualTo(storageDto);
	}
	
	@Test
	void changeQuantityShouldReturnUnprocessableEntityWhenItemDoesNotExist() {
		when(storageRepository.findByIngredientName(anyString())).thenReturn(null);
		
		ResponseEntity<StorageDto> response = storageController.changeQuantity("itemName", 10L);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@Test
	void changeQuantityShouldReturnStorageDtoWhenItemExists() {
		Storage storage = new Storage();
		when(storageRepository.findByIngredientName(anyString())).thenReturn(storage);
		StorageDto storageDto = new StorageDto();
		when(storageService.updateStorage(anyString(), anyLong())).thenReturn(storageDto);
		
		ResponseEntity<StorageDto> response = storageController.changeQuantity("itemName", 10L);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isEqualTo(storageDto);
	}
	
	@Test
	void getStorageShouldReturnListOfStorageDtos() {
		List<StorageDto> storageDtos = Collections.singletonList(new StorageDto());
		when(storageService.getStorage()).thenReturn(storageDtos);
		
		ResponseEntity<List<StorageDto>> response = storageController.getStorage();
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isEqualTo(storageDtos);
	}
	
	@Test
	void getStorageShouldReturnEmptyListWhenNoStorageItems() {
		when(storageService.getStorage()).thenReturn(Collections.emptyList());
		
		ResponseEntity<List<StorageDto>> response = storageController.getStorage();
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isEmpty();
	}
}
