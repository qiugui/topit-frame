/**   
 * @Title: SysUser.java 
 * @Package supertestclass 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author ivan.zhang
 * @date 2014年11月21日 上午11:29:31 
 * @version V1.0   
 */

package supertestclass;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.topit.frame.busniess.base.ISysUserService;
import com.topit.frame.core.entity.dao.base.ISysUserDAO;
import com.topit.frame.core.entity.data.SysUser;

/**
 * @ClassName: SysUser
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ivan.zhang
 * @date 2014年11月21日 上午11:29:31
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/config/spring/spring-hibernate-config.xml" })
public class SysUsers {
	@Resource(name = "sysUserServiceImp")
	private ISysUserService sysUserService;
	BigInteger element = new BigInteger("10");

	// @Resource
	// private SysUser user=new SysUser(element, null, null, null, null, null,
	// remark, needChangePassword, lastPasswordChangedTime, loginTimes,
	// activitySessionGUID, isOnline, lastActivityTime, lastLoginTime,
	// lastLogoutTime, lastRightEditTime, allowLoginWeekDay, allowLoginTime1,
	// allowLoginTime2, failedPasswordAttemptCount, failedPasswordAttemptTime,
	// failedPasswordAnswerAttemptCount, failedPasswordAnswerAttemptTime,
	// isSystemDefine, inactive, isDeleted, creator, createTime, null, null, 1)

	@Rollback(false)
	//@Test
	public void test() {

		BigInteger element = new BigInteger("119");
		SysUser user = new SysUser();
		user.setId(element);
		user.setRealName("张三");
		user.setLoginName("lisi");
		user.setCreator(150);
		user.setVersion(1);
		System.out.println(sysUserService);
		System.out.println(user);
		try {
			sysUserService.add(user);
			System.out.println(sysUserService);
			System.out.println(user);
		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	@Rollback(false)
    @Test
    public void TestGetCount(){
    	BigInteger element=new BigInteger("120");
    	SysUser user = new SysUser();
    	 user.setId(element);
	     user.setRealName("张三");
	    // user.setLoginName("lisi");
	     try {
			List<SysUser> list=sysUserService.find(user);
		    System.out.println(list.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
			 
		}
    }
	@Rollback(false)
	    //@Test
	public void TestFind(){
		//BigInteger element=new BigInteger("120");
    	//SysUser user = new SysUser();
    	 //user.setId(element);
	     //user.setRealName("张三");
	     //user.setLoginName("lisi");
	     try {
               SysUser user=sysUserService.findSysUserByLoginName("lisi");
		       System.out.println(user.getLoginName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
			 
		}
	}
	@Rollback(false)
	// @Test
	public void TestUpdate(){
		BigInteger element=new BigInteger("120");
 	SysUser user = new SysUser();
 	 user.setId(element);
	     user.setRealName("lisi");
	     user.setVersion(1);
	     //user.setLoginName("lisi");
	     try {
			boolean isupdate=sysUserService.updateSysUser(user);
		    assertTrue(isupdate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
			 
		}
	}
	@Rollback(false)
	// @Test
	public void TestDelete(){
		BigInteger element=new BigInteger("120");
	    SysUser user = new SysUser();
	    user.setId(element);
	     //user.setRealName("lisi");
	     //user.setVersion(1);
	     //user.setLoginName("lisi");
	     try {
			boolean isupdate=sysUserService.deleteSysUser(user);
		    assertTrue(isupdate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
			 
		}
	}

}
