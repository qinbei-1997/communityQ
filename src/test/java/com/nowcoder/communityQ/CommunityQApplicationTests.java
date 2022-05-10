package com.nowcoder.communityQ;

import com.nowcoder.communityQ.dao.AlphaDao;
import com.nowcoder.communityQ.service.Aservice;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.namespace.QName;
import java.text.SimpleDateFormat;
import java.util.Date;
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityQApplication.class)
class CommunityQApplicationTests implements ApplicationContextAware {
	private ApplicationContext applicationContext;
		@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
			this.applicationContext = applicationContext;
	}
	@Test
	public void testApplicationContext(){
			System.out.println(applicationContext);
		AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class);
		System.out.println(alphaDao.select());
		alphaDao = (AlphaDao) applicationContext.getBean("alphah");
		System.out.println(alphaDao.select());
	}
	@Test
	public void testBeanManage(){
		Aservice aservice = applicationContext.getBean(Aservice.class);
		System.out.println(aservice);

	}
	@Test
	public void testBeamConfig(){
		SimpleDateFormat simpleDateFormat =
				applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));
	}

	@Autowired//依赖注入
	private AlphaDao alphaDao;
		@Autowired
		@Qualifier("alphah")//改变bean
		private AlphaDao alphaDao1;
		@Test
	public void testDI(){
			System.out.println(alphaDao);
			System.out.println(alphaDao1);
		}
}
