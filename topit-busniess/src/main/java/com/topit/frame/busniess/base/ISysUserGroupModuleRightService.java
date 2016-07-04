package com.topit.frame.busniess.base;

import java.io.Serializable;

import com.topit.frame.core.entity.data.SysUserGroupModuleRight;

public interface ISysUserGroupModuleRightService {

	public boolean add(SysUserGroupModuleRight sysUserGroupModuleRight) throws Exception;
	
	public boolean delete(SysUserGroupModuleRight sysUserGroupModuleRight) throws Exception;
	
	/**   
	 * @Title: deleteByGroupId   
	 * @Description: 根据用户组id删除表中记录   
	 * @param id
	 * @return
	 * @throws Exception        
	 */
	 
	public boolean deleteByGroupId(Serializable id) throws Exception;
	
}
