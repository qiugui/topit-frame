 package supertestclass;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.topit.frame.busniess.base.ISysUserErrorLoginLogService;
import com.topit.frame.core.entity.data.SysUserErrorLoginLog;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/config/spring/spring-hibernate-config.xml"})
public class SysUserErrorLoginLogTest extends AbstractTransactionalJUnit4SpringContextTests{

	@Resource(name="sysUserErrorLoginLogServiceImp")
	ISysUserErrorLoginLogService  sysUserErrorLoginLogServiceImp;
	
	@Test
	@Rollback(false)
	public void saveTest() throws Exception{
		
		Date date=new Date();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-mm-dd hh:MM:ss");
		simpleDateFormat.format(date);
		
		SysUserErrorLoginLog sysUserErrorLoginLog=new SysUserErrorLoginLog
				(1, "qiugui", "123456", 1, "192.168.6.123", "qiugui", date);
		
		sysUserErrorLoginLogServiceImp.save(sysUserErrorLoginLog);
		
	}
	
}

 