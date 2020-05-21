package com.cr.house.service.house;
/**
 * 房屋管理接口
 * @auther chengrui
 *
 */

import com.cr.house.base.HouseSubscribeStatus;
import com.cr.house.service.ServiceMultiResult;
import com.cr.house.service.ServiceResult;
import com.cr.house.web.dto.HouseDTO;
import com.cr.house.web.dto.HouseSubscribeDTO;
import com.cr.house.web.from.DatatableSearch;
import com.cr.house.web.from.HouseForm;
import com.cr.house.web.from.RentSearch;
import org.springframework.data.util.Pair;

import java.util.Date;


public interface IHouseService {
	/**
	 * 保存房源信息
	 * @param houseForm
	 * @return
	 */
	public ServiceResult<HouseDTO> save(HouseForm houseForm);
	/**
	 * 查询房源信息
	 * @param searchBody
	 * @return
	 */
	public ServiceMultiResult<HouseDTO> adminQuery(DatatableSearch searchBody);
	/**
	 * 查询完整房源信息
	 * @param id
	 * @return
	 */
	ServiceResult<HouseDTO> findCompleteOne(Long id);
	/**
	 * 更新房源信息
	 * @param houseForm
	 * @return
	 */
	public ServiceResult update(HouseForm houseForm);
	/**
	 * 移除图片
	 * @param id
	 * @return
	 */
	public ServiceResult removePhoto(Long id);
	/**
	 * 修改封面接口
	 * @param coverId
	 * @param targetId
	 * @return
	 */
	public ServiceResult updateCover(Long coverId, Long targetId);
	/**
	 * 增加标签接口
	 * @param houseId
	 * @param tag
	 * @return
	 */
	public ServiceResult addTag(Long houseId, String tag);
	/**
	 * 移除标签接口
	 * @param houseId
	 * @param tag
	 * @return
	 */
	public ServiceResult removeTag(Long houseId, String tag);
	/**
	 * 更新房源状态
	 * @param id
	 * @param value
	 * @return
	 */
	public ServiceResult updateStatus(Long id, int value);
	/**
	 * 前台查询房源信息集
	 * @param rentSearch
	 * @return
	 */
	public ServiceMultiResult<HouseDTO> query(RentSearch rentSearch);
	/**
	 * 加入预约清单
	 * @param houseId
	 * @return
	 */
	ServiceResult addSubscribeOrder(Long houseId);
	/**
	 * 获取对应状态的预约列表
	 * @param of
	 * @param start
	 * @param size
	 * @return
	 */
	public ServiceMultiResult<Pair<HouseDTO, HouseSubscribeDTO>> querySubscribeList(HouseSubscribeStatus of, int start,
																					int size);
	/**
	 * 预约看房时间
	 * @param houseId
	 * @param orderTime
	 * @param telephone
	 * @param desc
	 * @return
	 */
	ServiceResult subscribe(Long houseId, Date orderTime, String telephone, String desc);
	/**
	 * 取消预约
	 * @param houseId
	 * @return
	 */
	ServiceResult cancelSubscribe(Long houseId);
	/**
	 * 管理员查询预约信息接口
	 * @param start
	 * @param size
	 */
	ServiceMultiResult<Pair<HouseDTO, HouseSubscribeDTO>> findSubscribeList(int start, int size);
	/**
	 * 完成预约
	 */
	ServiceResult finishSubscribe(Long houseId);

}
