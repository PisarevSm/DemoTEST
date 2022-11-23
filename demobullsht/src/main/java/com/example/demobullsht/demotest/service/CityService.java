package com.example.demobullsht.demotest.service;


import java.util.*;

import com.example.demobullsht.demotest.entity.*;
import com.example.demobullsht.demotest.exception.*;
import com.example.demobullsht.demotest.repository.*;
import lombok.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;


import static org.springframework.data.domain.Sort.Direction.*;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public void addCity(String name) {
        boolean exists = cityRepository.existsByName(name);

        if (exists) {
            throw new AlreadyExistsException(String.format(
                "Город с таким названием уже существует: %s",
                name));
        }

        cityRepository.save(new CityEntity(null, name));
    }

    public List<CityEntity> getAll() {
        var sort = Sort.by(ASC, "name");
        return cityRepository.findAll(sort);

    }

    public CityEntity getById(Long id) {
        return cityRepository
            .findById(id)
            .orElseThrow(() -> new NotFoundException(String.format(
                "Города с таким id не существует: %s",
                id)));

    }

    public CityEntity getByName(String name) {
        return cityRepository.findByName(name);
    }

    public void updateCity(CityEntity cityEntity) {
        cityRepository.save(cityEntity);
    }

    public void deleteCity(Long id) {

        if (getById(id) == null) {
            throw new NotFoundException(String.format("Города с таким id не существует: %s", id));
        }

        cityRepository.deleteById(id);
    }

}
