package com.cr.house.repository;


import com.cr.house.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * 角色数据DAO
 * @author chengrui
 *
 */
public interface RoleRepository extends CrudRepository<Role, Long> {
	List<Role> findRolesByUserId(Long userId);
}
