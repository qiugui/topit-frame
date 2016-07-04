package com.topit.frame.busniess.imp;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.topit.frame.busniess.base.ISysUserGroupModuleRightService;
import com.topit.frame.core.entity.dao.base.ISysUserGroupModuleRightDAO;
import com.topit.frame.core.entity.data.SysUserGroupModuleRight;


@Service(value="sysUserGroupModuleRightServiceImp")
@Transactional
public class SysUserGroupModuleRightServiceImp implements
		ISysUserGroupModuleRightService {

	@Resource(name="sysUserGroupModuleRightDAOImpl")
	ISysUserGroupModuleRightDAO sysUserGroupModuleRightDAOImpl;
	
	public boolean add(SysUserGroupModuleRight sysUserGroupModuleRight) throws Exception {
		
		return sysUserGroupModuleRightDAOImpl.add(sysUserGroupModuleRight);
		
	}

	public boolean delete(SysUserGroupModuleRight sysUserGroupModuleRight) throws Exception {
		
		return sysUserGroupModuleRightDAOImpl.delete(sysUserGroupModuleRight);
	}

	/**   
	 * <p>Title: deleteByGroupId</p>   
	 * <p>Description: 根据用户组id删除相应记录</p>   
	 * @param id
	 * @return
	 * @throws Exception   
	 * @see com.topit.frame.busniess.base.ISysUserGroupModuleRightService#deleteByGroupId(java.io.Serializable)   
	 */
	 
	public boolean deleteByGroupId(Serializable id) throws Exception {
		
		 return sysUserGroupModuleRightDAOImpl.deleteByGroupId(id);
		 
	}

}
