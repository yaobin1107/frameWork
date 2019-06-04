package cn.yb.tieba.service.impl;

import cn.yb.tieba.dao.ITopicDao;
import cn.yb.tieba.dao.impl.TopicDaoImpl;
import cn.yb.tieba.model.Topic;
import cn.yb.tieba.service.ITopicService;

import java.util.List;

public class TopivServiceImpl implements ITopicService {

    ITopicDao topicDao = new TopicDaoImpl();

    @Override
    public void save(Topic topic) {
        topicDao.save(topic);
    }

    @Override
    public List<Topic> getAll(String key) {
        return topicDao.getAll(key);
    }
}
