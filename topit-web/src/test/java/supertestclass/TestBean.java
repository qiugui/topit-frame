package supertestclass;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.sound.midi.Sequence;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.topit.frame.core.entity.dao.imp.IdGenerator;
import com.topit.frame.core.entity.data.SysSequence;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/config/spring/spring-hibernate-config.xml" })
public class TestBean extends AbstractTransactionalJUnit4SpringContextTests {

	@Resource
	private IdGenerator idGenerator;

	@Test
	@Rollback(false)
	public void test() throws Exception {

		long j = System.currentTimeMillis();

		System.out.println("开始时间"
				+ new SimpleDateFormat("yyyy-MM-dd mm:hh:ss").format(new Date(
						System.currentTimeMillis())));
		/*List<BigInteger> list=idGenerator.getNextIds("gg", 1000);
		for(BigInteger i:list)
		{
			System.out.println(i);
		}
		*/
		System.out.println(idGenerator.getNextId("mm"));
		/*SysSequence sequence=new SysSequence("ff");*/
		
		long m = System.currentTimeMillis();
		/*System.out.println("结束时间" + new SimpleDateFormat("yyyy-mm-dd mm:hh:ss").format(new Date(
				System.currentTimeMillis())));*/
		System.out.println("结束时间"+(m-j));

	}
    
	
}
