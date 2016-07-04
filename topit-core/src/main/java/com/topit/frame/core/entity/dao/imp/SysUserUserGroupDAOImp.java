 package com.topit.frame.core.entity.dao.imp;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.topit.frame.core.dao.BaseDAO;
import com.topit.frame.core.entity.dao.base.ISysUserUserGroupDAO;
import com.topit.frame.core.entity.data.SysUserUserGroup;
 /** 
* @ClassName: SysUserUserGroupDAOImp 
* @Description: 系统用户  与 系统用户组 关联表DAO接口的实现 
* @author qiugui 
* @date 2014年12月3日 下午1:37:34 
*  
*/
@Repository("sysUserUserGroupDAOImp")
public class SysUserUserGroupDAOImp extends BaseDAO<SysUserUserGroup> implements
		ISysUserUserGroupDAO {

	/**   
	 * <p>Title: findByUserId</p>   
	 * <p>Description:  根据用户id查询所属用户组</p>   
	 * @param userid
	 * @return
	 * @throws Exception   
	 * @see com.topit.frame.core.entity.dao.base.ISysUserUserGroupDAO#findByUserId(java.io.Serializable)   
	 */
	 
	@SuppressWarnings("unchecked")
	public List<SysUserUserGroup> findByUserId(Serializable userid)
			throws Exception {
		
		String hql="from SysUserUserGroup where UserId = "+userid;
		
		Query query=this.getSessionFactory().getCurrentSession().createQuery(hql);
		
		List<SysUserUserGroup> list=query.list();
		
		 return list;
		 
	}

	/**   
	 * <p>Title: deleteSysUserUserGroupByGroupid</p>   
	 * <p>Description: 按照用户组id删除系统用户用户组</p>   
	 * @param id
	 * @return
	 * @throws Exception   
	 * @see com.topit.frame.core.entity.dao.base.ISysUserUserGroupDAO#deleteSysUserUserGroupByGroupid(java.io.Serializable)   
	 */
	 
	public Boolean deleteSysUserUserGroupByGroupid(Serializable id)
			throws Exception {
		boolean flag= false;
		
		String hql = "DELETE SysUserUserGroup WHERE groupId = "+id;
		
		Query query = this.getSessionFactory().getCurrentSession().createQuery(hql);
		
		try {
			query.executeUpdate();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
		return flag;
		 
	}
}

 