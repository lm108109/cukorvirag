package org.example.twenty_points.service.impl;

import org.example.twenty_points.model.dto.SutiDto;
import org.example.twenty_points.model.entity.Suti;
import org.example.twenty_points.repository.SutiRepository;
import org.example.twenty_points.service.SutiService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SutiServiceImpl implements SutiService {

    private final SutiRepository repository;
    public SutiServiceImpl(SutiRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<SutiDto> getSuti() {
        List<SutiDto> sutiDtos = new ArrayList<>();
        repository.findAll().forEach(sutis ->{
                SutiDto sutiDto = new SutiDto();
                sutiDto.setName(sutis.getName());
                sutiDto.setDescription(sutis.getDescription());
                sutiDtos.add(new SutiDto(sutis));
        });
        return sutiDtos;
    }

    @Override
    public SutiDto addSuti(String name, String description) {
        Suti suti = new Suti();
        suti.setId(repository.findMaxId() + 1);
        suti.setName(name);
        suti.setDescription(description);
        repository.save(suti);
        return new SutiDto(suti);
    }


}
