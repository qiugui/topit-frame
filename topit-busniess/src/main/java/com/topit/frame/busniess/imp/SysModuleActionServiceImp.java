package com.topit.frame.busniess.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.topit.frame.busniess.base.ISysModuleActionService;
import com.topit.frame.core.entity.dao.base.ISysModuleActionDAO;
import com.topit.frame.core.entity.data.SysModuleAction;
import com.topit.frame.core.util.ActionRightUtil;

/**
 * @ClassName: SysModuleActionServiceImp
 * @Description: 系统模块操作的 服务类实现
 * @author qiugui
 * @date 2014年12月25日 下午3:36:33
 * 
 */
@Service(value = "sysModuleActionServiceImp")
@Transactional
public class SysModuleActionServiceImp implements ISysModuleActionService {

	@Resource(name = "sysModuleActionDAOImp")
	ISysModuleActionDAO sysModuleActionDAOImp;

	/**
	 * <p>
	 * Title: getList
	 * </p>
	 * <p>
	 * Description: 根据用户组id和模块id获得对应的模块操作权限
	 * </p>
	 * 
	 * @param groupId
	 * @param moduleId
	 * @return
	 * @throws Exception
	 * @see com.topit.frame.busniess.base.ISysModuleActionService#getList(java.lang.String,
	 *      java.lang.String)
	 */

	public List<Map<String, Object>> getList(String groupId, String moduleId)
			throws Exception {

		return sysModuleActionDAOImp.getList(groupId, moduleId);

	}

	/**
	 * <p>
	 * Title: getListAction
	 * </p>
	 * <p>
	 * Description: 根据模块路径modulePath和用户UserID查询模块权限
	 * </p>
	 * 
	 * @param modulePath
	 * @param userId
	 * @return
	 * @throws Exception
	 * @see com.topit.frame.busniess.base.ISysModuleActionService#getListAction(java.lang.String,
	 *      int)
	 */

	public List<SysModuleAction> getListAction(String modulePath, int userId)
			throws Exception {

		return sysModuleActionDAOImp.getListAction(modulePath, userId);

	}

	public int getCount() throws Exception {

		return sysModuleActionDAOImp.getCount();

	}


	/**
	 * 
	 * <p>
	 * Title: initActions
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * @return 
	 * 
	 * @see com.topit.frame.busniess.base.ISysModuleActionService#initActions()
	 */
	public boolean initActions() {
        boolean flag=false;
		Set<SysModuleAction> actions = ActionRightUtil
				.readAllActions(new String[]{"com.topit.frame.web.controller"});
		List<SysModuleAction> temp = new ArrayList<SysModuleAction>();
		temp.addAll(actions);
		try {
			sysModuleActionDAOImp.excuteSQL("DELETE FROM sys_module_action");
			sysModuleActionDAOImp.save(temp);
			flag=true;
		} catch (Exception e) {

			e.printStackTrace();

		}
		return flag;
	}

	public List<SysModuleAction> getAllSysActions(int currentPage,int pageSize) throws Exception {
		 DetachedCriteria criteria=DetachedCriteria.forClass(SysModuleAction.class);
		 return sysModuleActionDAOImp.getListForPage(criteria, (currentPage-1)*pageSize, pageSize);
		 
	}

}
