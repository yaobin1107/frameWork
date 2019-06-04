package cn.yb.tieba.service;

import cn.yb.tieba.model.Topic;

import java.util.List;

public interface ITopicService {
    //保存话题
    public void save(Topic topic);
    //获取话题
    public List<Topic> getAll(String key);
}
