package com.cr.house.service.house;


import com.cr.house.entity.SupportAddress;
import com.cr.house.service.ServiceMultiResult;
import com.cr.house.service.ServiceResult;
import com.cr.house.web.dto.SubwayDTO;
import com.cr.house.web.dto.SubwayStationDTO;
import com.cr.house.web.dto.SupportAddressDTO;

import java.util.List;
import java.util.Map;


/**
 * @auther chengrui
 */
public interface IAddressService {
    /**
     * 获取所有支持的城市列表
     * @return
     */
    public ServiceMultiResult<SupportAddressDTO> findAllCities();
    /**
     * 根据英文简写获取具体区域的信息
     * @param cityEnName
     * @param regionEnName
     * @return
     */
    public Map<SupportAddress.Level, SupportAddressDTO> findCityAndRegion(String cityEnName, String regionEnName);

    /**
     * 根据城市英文简写获取该城市所有支持的区域信息
     * @param cityName
     * @return
     */
    public ServiceMultiResult findAllRegionsByCityName(String cityName);

    /**
     * 获取该城市所有的地铁线路
     * @param cityEnName
     * @return
     */
    public List<SubwayDTO> findAllSubwayByCity(String cityEnName);

    /**
     * 获取地铁线路所有的站点
     * @param subwayId
     * @return
     */
    public List<SubwayStationDTO> findAllStationBySubway(Long subwayId);

    /**
     * 获取地铁线信息
     * @param subwayId
     * @return
     */
    public ServiceResult<SubwayDTO> findSubway(Long subwayId);

    /**
     * 获取地铁站点信息
     * @param stationId
     * @return
     */
    public ServiceResult<SubwayStationDTO> findSubwayStation(Long stationId);

    /**
     * 根据城市英文简写获取城市详细信息
     * @param cityEnName
     * @return
     */
    public ServiceResult<SupportAddressDTO> findCity(String cityEnName);


}