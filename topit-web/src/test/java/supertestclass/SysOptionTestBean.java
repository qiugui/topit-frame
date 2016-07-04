package supertestclass;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.topit.frame.busniess.base.ISysOptionService;
import com.topit.frame.core.entity.data.SysOption;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/config/spring/spring-hibernate-config.xml" })
public class SysOptionTestBean extends AbstractTransactionalJUnit4SpringContextTests {

	@Resource(name="sysOptionServiceImp")
	private ISysOptionService sysOptionServiceImp;

	@Test
	@Rollback(false)
	public void test() throws Exception {
		
		Date date=new Date();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-mm-dd mm:hh:ss");
		simpleDateFormat.format(date);
		
		SysOption sysOption1=new SysOption(1,"1",1,"读取事件通知间隔","5","int",0,
				"间隔几分钟检查一次是否有系统事件通知收到",1,date,1,date,15);
		
		SysOption sysOption2=new SysOption(1,"2",2,"启用列表界面分页","5","int",1,
				"启用列表界面分页",1,date,1,date,8);
		
		SysOption sysOption3=new SysOption(1,"3",3,"列表界面分页方式","多分页","varchar",0,
				"列表界面分页方式",1,	date,1,date,8);
		
		
		List<SysOption> list=new ArrayList<SysOption>();
		
		list.add(sysOption1);
		list.add(sysOption2);
		list.add(sysOption3);
		
		Assert.assertTrue(sysOptionServiceImp.batchUpdate(list));
		
		System.out.println(sysOptionServiceImp.batchUpdate(list));
		

	}
	
	@Test
	public void loadAllTest() throws Exception{
		
		List<SysOption> list1=sysOptionServiceImp.loadAllByCategoryId("2");
		
		for(SysOption s:list1){
			System.out.println("选项分类的ID"+s.getCategoryId()+"选项分类名"+s.getOptionName()+"版本号"+s.getVersion());
		}
	}

}
