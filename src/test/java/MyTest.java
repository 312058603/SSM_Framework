import com.alibaba.fastjson.JSON;
import com.gmcx.wpx.dao.UserDao;
import com.gmcx.wpx.model.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wpx on 2017/7/5.
 */
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class MyTest {

    @Autowired
    private UserDao UserDao;

    @Test
    public void TestSpringIoc() {
        //创建容器
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Person person0 = (Person) context.getBean("person0");
        System.out.println("name=" + person0.getName());
        System.out.println("age=" + person0.getAge());

        Person person1 = (Person) context.getBean("person1");
        System.out.println("name=" + person1.getName());
        System.out.println("age=" + person1.getAge());

        Person person4 = (Person) context.getBean("person4");
        System.out.println("name=" + person4.getName());
        System.out.println("age=" + person4.getAge());

        Person person5 = (Person) context.getBean("person5");
        System.out.println("name=" + person5.getName());
        System.out.println("age=" + person5.getAge());

        Person person6 = (Person) context.getBean("person6");
        System.out.println("name=" + person6.getName());
        System.out.println("age=" + person6.getAge());

        Person person7 = (Person) context.getBean("person7");
        System.out.println("name=" + person7.getName());
        System.out.println("age=" + person7.getAge());

        Student student0 = (Student) context.getBean("student2");
        System.out.println("name=" + student0.getPerson().getName());
        System.out.println("age=" + student0.getPerson().getAge());

        JavaCollections javaCollections = (JavaCollections) context.getBean("javaCollections");
        System.out.println("javaCollections:" + javaCollections.toString());

        MergeProperties mergeProperties = (MergeProperties) context.getBean("mergeProperties_child");
        System.out.println("mergeProperties:" + mergeProperties.toString());

        Person person9 = (Person) context.getBean("person9");
        System.out.println("name=" + person9.getName());
        System.out.println("age=" + person9.getAge());

        Person person10 = (Person) context.getBean("person10");
        System.out.println("name=" + person10.getName());
        System.out.println("age=" + person10.getAge());

        //关闭销毁容易
        ((ClassPathXmlApplicationContext) context).close();
    }

    private SqlSessionFactory sessionFactory;

    @Before
    public void before() throws IOException {
//        //mybatis的配置文件
//        String resource = "mybatis-config.xml";
//        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
//        InputStream is = Resources.getResourceAsStream(resource);
//        //构建sqlSession的工厂
//        sessionFactory = new SqlSessionFactoryBuilder().build(is);
    }

    @Test
    public void findAllUsers() {
//        SqlSession session = sessionFactory.openSession();
//        String statement = "UserDao.findAllUsers";
//        List<User> users = session.selectList(statement);
//        List<User> users= UserDao.findAllUsers();
//        System.out.println(users.toString());
    }

    @Test
    public void findUserById() {
        SqlSession session = sessionFactory.openSession();
        String statement = "UserDao.findUserById";
        User user = session.selectOne(statement, 1);
        System.out.println(user.toString());
    }

    @Test
    public void addOneUser() {

    }

    @Test
    public void updateUserById() {

    }

    private static Logger logger = Logger.getLogger(Test.class);

    @Test
    public void testLog4j() {
        logger.info("info ");
        logger.error("error");
        logger.warn("warn");
    }

    @Test
    public void testJson() {
        UserToBooks userToBooks = new UserToBooks();
        userToBooks.setUser_Name("王培学");
        userToBooks.setUser_Age(20);

        Book book = new Book();
        book.setBook_Name("鲁宾逊漂流记");
        book.setBook_Price(30.5);

        Book book1 = new Book();
        book1.setBook_Name("朝花夕拾");
        book1.setBook_Price(20.5);

        List<Book> bookList = new ArrayList<Book>();
        bookList.add(book);
        bookList.add(book1);

        userToBooks.setBookList(bookList);

        System.out.println(JSON.toJSONString(userToBooks));
    }

    @Test
    public void raoraoTest() {
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(i+"*"+ j+"=" + i * j+" ");
            }
            System.out.print("\n");
        }
    }


    @Test
    public void TestThread(){

    }

}
