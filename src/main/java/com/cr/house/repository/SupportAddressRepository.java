package com.cr.house.repository;

import com.cr.house.entity.SupportAddress;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @auther chengrui
 */
public interface SupportAddressRepository extends CrudRepository<SupportAddress,Long> {
    /**
     * 获取所有对应的行政级别的信息
     * @param level
     * @return
     */
    List<SupportAddress> findAllByLevel(String level);
    SupportAddress findByEnNameAndLevel(String enName, String level);

    SupportAddress findByEnNameAndBelongTo(String enName, String belongTo);

    List<SupportAddress> findAllByLevelAndBelongTo(String level, String belongTo);
}
