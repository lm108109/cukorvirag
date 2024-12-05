package org.example.twenty_points.service;

import org.example.twenty_points.model.dto.SutiDto;

import java.util.List;

public interface SutiService {

    List<SutiDto> getSuti();

    SutiDto addSuti(String name, String description);
}
