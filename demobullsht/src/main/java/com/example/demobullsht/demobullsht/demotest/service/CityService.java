package com.example.demobullsht.demobullsht.demotest.service;

import com.example.demobullsht.demobullsht.demotest.entity.CityEntity;
import com.example.demobullsht.demobullsht.demotest.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;


    public List<CityEntity> getCity() {
        return cityRepository.findAll();
    }

    public CityEntity getCityById(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException("Город не найден!"));
    }

    public CityEntity getCityByCityName(String CityName) {
        CityEntity cityEntityByCityName = cityRepository.findByCityName(CityName);
        if (cityEntityByCityName == null) {
            throw new RuntimeException("Города с данным названием не найден");
        } else {
            return cityEntityByCityName;
        }
    }

    public void addNewCityEntity(CityEntity cityEntity) {
        cityRepository.save(cityEntity);
    }


    @Transactional
    public void updateCityEntity(Long id, String CityName) {
        CityEntity cityEntity = cityRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "city with id " + id + "doesn't exist"));
        if (CityName != null &&
                CityName.length() > 0 &&
                !Objects.equals(cityEntity.getCityName(), CityName)) {
            cityEntity.setCityName(CityName);
        }
    }

    public void deleteCityEntity(Long id) {
        boolean exists = cityRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException(
                    "city with id " + id + "doesn't exist");
        }
        cityRepository.deleteById(id);
    }
}