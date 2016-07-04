 package com.topit.frame.core.entity.dao.base;

import java.io.Serializable;
import java.util.List;

import com.topit.frame.core.entity.data.SysUserGroupModuleRight;
 public interface ISysUserGroupModuleRightDAO {
	 /**
	     * 
	     * @Title: findByGroupIds   
	     * @Description: 根据用户组id集合获取模块权限（去重复）  
	     * @param groupids
	     * @return
	     * @throws Exception
	     */
		public List<SysUserGroupModuleRight> findByGroupIds(List<Integer> groupids) throws Exception;
		
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

 