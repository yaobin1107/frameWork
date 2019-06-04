package cn.yb.tieba.dao.impl;

import cn.yb.tieba.dao.ITopicDao;
import cn.yb.tieba.model.Topic;
import cn.yb.tieba.utils.HibernateUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class TopicDaoImpl implements ITopicDao {
    @Override
    public void save(Topic topic) {
        Session session = HibernateUtils.getCurrentSession();
        session.save(topic);
    }

    @Override
    public List<Topic> getAll(String key) {

        Session session = HibernateUtils.getCurrentSession();
        System.out.println("TopicDao：" + session.hashCode());
        Query query = null;

        if (StringUtils.isEmpty(key)) {
            query = session.createQuery("from Topic");
        } else {
            query = session.createQuery("from Topic where title like:like");
            query.setParameter("like", "%" + key + "%");
        }

        List<Topic> list = query.list();

        return list;
    }
}
