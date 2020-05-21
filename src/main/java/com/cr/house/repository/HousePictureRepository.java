package com.cr.house.repository;



import com.cr.house.entity.HousePicture;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HousePictureRepository  extends CrudRepository<HousePicture, Long> {
    List<HousePicture> findAllByHouseId(Long id);
}
