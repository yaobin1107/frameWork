package cn.yb.tieba.dao.impl;

import cn.yb.tieba.dao.ITopicDao;
import cn.yb.tieba.model.Topic;
import cn.yb.tieba.utils.HibernateUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class TopicDaoImpl_备份 implements ITopicDao {
    @Override
    public void save(Topic topic) {

        Session session = HibernateUtils.openSession();

        session.getTransaction().begin();

        session.save(topic);

        session.getTransaction().commit();

        session.close();
    }

    @Override
    public List<Topic> getAll(String key) {
        Session session = HibernateUtils.openSession();
        Query query = null;
        if (StringUtils.isEmpty(key)) {
            query = session.createQuery("from Topic");
        } else {
            query = session.createQuery("from Topic where title like:like");
            query.setParameter("like", "%" + key + "%");
        }
        List<Topic> list = query.list();
        session.close();
        return list;
    }
}
