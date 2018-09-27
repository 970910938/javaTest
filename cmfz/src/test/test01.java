import com.baizhi.dao.PersonDao;
import com.baizhi.entity.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

//import com.baizhi.dao.PersonDao;
//import com.baizhi.entity.Person;
//import com.baizhi.entity.Province;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.util.List;
//
public class test01 {
  @Test
   public void test02(){
       ApplicationContext cc = new ClassPathXmlApplicationContext("spring.xml");
       PersonDao personDao = (PersonDao) cc.getBean("personDao");
      List<Person> list = personDao.queryAll();
      System.out.println("111");
      System.out.println("111");
      System.out.println("111");
      System.out.println("111");
      System.out.println("111");
      System.out.println("111");
   }
}
