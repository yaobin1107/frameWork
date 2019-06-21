package cn.yb;

import cn.yb.dao.RoleDao;
import cn.yb.dao.UserDao;
import cn.yb.domain.Role;
import cn.yb.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class testManyToMany {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    /**
     * 保存一个用户，保存一个角色
     *  多对多放弃外键维护权：被动的一方放弃（角色被选择，角色放弃）
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void testAdd() {
        User user = new User();
        user.setUserName("zhangsan");

        Role role = new Role();
        role.setRoleName("Java后台开发工程师");

        //配置用户到角色的关系，可以对中间表数据进行维护
        user.getRoles().add(role);
        //配置角色到用户的关系，也可以对中间表进行维护
        role.getUsers().add(user);//同时配置关系会出现主键冲突 Duplicate entry '1-1' for key 'PRIMARY'

        userDao.save(user);
        roleDao.save(role);
    }

    /**
     * 级联操作：在主体上配置cascade（User）
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void testCascade() {
        User user = new User();
        user.setUserName("zhangsan");

        Role role = new Role();
        role.setRoleName("Java后台开发工程师");

        //配置用户到角色的关系，可以对中间表数据进行维护
        user.getRoles().add(role);
        //配置角色到用户的关系，也可以对中间表进行维护
        role.getUsers().add(user);//同时配置关系会出现主键冲突 Duplicate entry '1-1' for key 'PRIMARY'

        userDao.save(user);
    }


    @Test
    @Transactional
    @Rollback(value = false)
    public void testCascadeDelete() {
        User one = userDao.findOne(1L);
        userDao.delete(one);
    }
}
