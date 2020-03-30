package com.example.blog.po;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="t_blog")
public class Blog {
    @Id
    @GeneratedValue
    private Long id;                //序号
    private String title;           //标题
    private String content;         //博客内容
    private String firstPicture;    //首图
    private String flag;            //标记
    private Integer views;          //浏览次数
    private boolean appreciatin;    //赞赏开关
    private boolean shareStatement; //评论开关
    private boolean copyright;      //版权开启
    private boolean issue;          //发布开关
    private boolean recommend;      //推荐开关

    @Temporal(TemporalType.TIMESTAMP)
    private Date    createTime;     //创建时间

    @Temporal(TemporalType.TIMESTAMP)
    private Date    updateTime;     //更新时间

    @ManyToOne
    private Type type;              //博客类型

    @ManyToMany(cascade = {CascadeType.PERSIST})  //级联新增  （新增加一个tag会把tag保存到数据库中）
    private List<Tag> tags = new ArrayList<>();

    @ManyToOne
    private User user;              //用户

    @OneToMany(mappedBy = "blog")
    private List<Comment> comments; //内容集合

    public Blog() {
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", firstPicture='" + firstPicture + '\'' +
                ", flag='" + flag + '\'' +
                ", views=" + views +
                ", appreciatin=" + appreciatin +
                ", shareStatement=" + shareStatement +
                ", copyright=" + copyright +
                ", issue=" + issue +
                ", recommend=" + recommend +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public boolean isAppreciatin() {
        return appreciatin;
    }

    public void setAppreciatin(boolean appreciatin) {
        this.appreciatin = appreciatin;
    }

    public boolean isShareStatement() {
        return shareStatement;
    }

    public void setShareStatement(boolean shareStatement) {
        this.shareStatement = shareStatement;
    }

    public boolean isCopyright() {
        return copyright;
    }

    public void setCopyright(boolean copyright) {
        this.copyright = copyright;
    }

    public boolean isIssue() {
        return issue;
    }

    public void setIssue(boolean issue) {
        this.issue = issue;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
