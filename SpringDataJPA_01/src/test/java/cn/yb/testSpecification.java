package cn.yb;

import cn.yb.dao.CustomerDao;
import cn.yb.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.*;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class testSpecification {

    @Autowired
    private CustomerDao customerDao;

    /**
     * 根据条件查询，查询单个对象
     */
    @Test
    public void testSpecification() {
        /**
         * 自定义查询条件
         *      1.实现Specification接口（提供泛型-->查询对象的类型）
         *      2.实现toPredicate方法（构造查询条件）
         *      3.需要借助方法参数中的两个参数
         *          （root：获取需要的对象属性，CriteriaBuilder：构造查询条件，内部封装了很多条件（模糊匹配，精准匹配））
         * 案例：根据客户名查询，查询的客户名为张三
         *      查询条件：
         *          1.查询方式：CriteriaBuilder
         *          2.比较的属性名称：root
         */
        Specification<Customer> specification = new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //1.获取比较的属性
                Path<Object> custName = root.get("custName");
                //2.构造查询条件：select * from cst_customer where cust_name = '张三'
                /**
                 * 第一个参数：要比较的属性
                 * 第二个参数：需要比较的取值
                 */
                Predicate predicate = criteriaBuilder.equal(custName, "姚斌");//进行精准的匹配（比较的属性，比较的属性值）
                return predicate;
            }
        };
        Customer one = customerDao.findOne(specification);
        System.out.println(one);
    }

    /**
     * 多条件查询：根据客户名和客户行业查询
     * root：获取属性
     *      客户名
     *      客户行业
     * CriteriaBuilder：构造查询
     *      1.构造客户名的精准查询
     *      2.构造客户行业的精准查询
     *      3.将上面两个查询联系起来
     */
    @Test
    public void testSpecification2() {
        Customer one = customerDao.findOne(new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //获取属性
                Path<Object> custName = root.get("custName");
                Path<Object> custIndustry = root.get("custIndustry");
                //构造查询条件
                Predicate p1 = criteriaBuilder.equal(custName, "张三");
                Predicate p2 = criteriaBuilder.equal(custIndustry, "IT");
                //将多个查询条件组合到一起，组合（and / or）
                Predicate and = criteriaBuilder.and(p1, p2);//criteriaBuilder.or();
                return and;
            }
        });
        System.out.println(one);
    }

    /**
     * 根据客户名称模糊查询返回客户列表
     * equal：
     *      直接得到path对象（属性），然后比较
     * gt，lt，ge，le，like：
     *      得到path对象，根据path指定比较的参数类型，再去比较
     * 指定参数类型：
     *      path.as(类型的字节码对象)
     */
    @Test
    public void testSpec(){
        List<Customer> custName = customerDao.findAll(new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> custName = root.get("custName");
                Predicate like = criteriaBuilder.like(custName.as(String.class), "%三");
                return like;
            }
        });
        for (Customer customer : custName) {
            System.out.println(customer);
        }
    }

    @Test
    public void testSpecSort(){
        Specification<Customer> specification = new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> custName = root.get("custName");
                Predicate like = criteriaBuilder.like(custName.as(String.class), "%三");
                return like;
            }
        };
        /**
         * 添加排序：
         *  创建排序对象，需要调用构造方法实例化sort对象
         *      第一个参数：排序的顺序（降序，升序）
         *          Sort.Direction.DESC：降序
         *          Sort.Direction.ASC：升序
         *      第二个参数：根据哪个属性排序？
         */
        Sort sort = new Sort(Sort.Direction.DESC,"custId");
        List<Customer> custName = customerDao.findAll(specification,sort);
        for (Customer customer : custName) {
            System.out.println(customer);
        }
    }

    /**
     * 分页查询:
     *  Specification：查询条件
     *  Pageable：分页参数（查询页码，每页查询条数）
     *      findAll(Specification,Pageable)：带有条件的分页查询
     *      findAll(Pageable)：无条件分页查询
     *  返回 Page 对象（SpringDataJPA为我们封装好的PageBean对象，可以获取数据列表，总条数）
     */
    @Test
    public void testLimit(){
        /**
         * PageRequest是 Pageable 的实现类
         * 创建 PageRequest 的过程中，需要调用器构造方法传入两个参数
         *      第一个参数：当前页（从0开始）
         *      第二个参数：每页查询条数
         */
        Pageable pageable = new PageRequest(0,2);
        Page<Customer> page = customerDao.findAll(pageable);
        /**
         * getTotalElements()：总记录条数
         * getContent()：得到单页所有数据，返回 List
         * getTotalPages()：得到总页数
         */
        System.out.println(page.getTotalPages());
    }
}
