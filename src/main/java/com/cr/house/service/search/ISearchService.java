package com.cr.house.service.search;


import com.cr.house.service.ServiceMultiResult;
import com.cr.house.service.ServiceResult;
import com.cr.house.web.from.RentSearch;

import java.util.List;

/**
 * @auther chengrui
 */
public interface ISearchService {
    /**
     * 索引目标房源
     * @param houseId
     */
    void index(Long houseId);

    /**
     * 移除房源索引
     * @param houseId
     */
    void remove(Long houseId);
    /**
     * 查询房源接口
     * @param rentSearch
     * @return
     */
    ServiceMultiResult<Long> query(RentSearch rentSearch);
    /**
     * 聚合特定小区的房间数
     */
    ServiceResult<Long> aggregateDistrictHouse(String cityEnName, String regionEnName, String district);
}
