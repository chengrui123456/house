package com.cr.house.repository;


import com.cr.house.entity.Subway;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @auther chengrui
 */
public interface SubwayRepository extends CrudRepository<Subway, Long> {
    List<Subway> findAllByCityEnName(String cityEnName);
}
