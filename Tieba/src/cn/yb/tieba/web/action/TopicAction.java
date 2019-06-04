package cn.yb.tieba.web.action;

import cn.yb.tieba.model.Topic;
import cn.yb.tieba.service.ITopicService;
import cn.yb.tieba.service.impl.TopivServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import java.util.Date;
import java.util.List;

public class TopicAction extends ActionSupport implements ModelDriven<Topic> {

    private Topic topic = new Topic();
    private ITopicService topicService = new TopivServiceImpl();
    private List<Topic> topicList;

    /**
     * 返回话题列表界面
     */
    public String list() {
        //获取数据
        List<Topic> topicList = topicService.getAll(null);
        //存在ContextMap
        ActionContext.getContext().put("topicList", topicList);

        return "list";
    }

    public String save() {
        /**
         * 保存话题
         * dao
         * service
         * action
         * jsp
         */
        //表达数据封装
        //帖子的创建时间
        topic.setCreateDate(new Date());
        //帖子IP地址
        String remoteAddr = ServletActionContext.getRequest().getRemoteAddr();
        topic.setIpAddr(remoteAddr);
        System.out.println(topic);

        //调用service
        topicService.save(topic);

        //获取数据
        topicList = topicService.getAll(null);
        //存在ContextMap
        ActionContext.getContext().put("topicList", topicList);

        return "list";
    }

    private String key;

    public void setKey(String key) {
        this.key = key;
    }

    public String search() {
        /**
         * 通过关键字搜索
         */
        System.out.println("搜索的关键字:" + key);
        //获取数据
        topicList = topicService.getAll(key);
        //存在ContextMap
        ActionContext.getContext().put("topicList", topicList);
        return "list";
    }

    @Override
    public Topic getModel() {
        return topic;
    }
}
