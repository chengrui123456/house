package com.cr.house.repository;


import com.cr.house.entity.SubwayStation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @auther chengrui
 */
public interface SubwayStationRepository extends CrudRepository<SubwayStation, Long> {
    List<SubwayStation> findAllBySubwayId(Long subwayId);
}
