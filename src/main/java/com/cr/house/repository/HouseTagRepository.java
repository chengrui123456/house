package com.cr.house.repository;


import com.cr.house.entity.HouseTag;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface HouseTagRepository extends CrudRepository<HouseTag, Long> {
	 List<HouseTag> findAllByHouseId(Long id);

	 List<HouseTag> findAllByHouseIdIn(List<Long> houseIds);

	HouseTag findByNameAndHouseId(String tag, Long houseId);


}
