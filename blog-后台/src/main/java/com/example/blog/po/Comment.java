package com.example.blog.po;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_comment")
public class Comment {
    @Id
    @GeneratedValue
    private Long id;            //评论序号
    private String nickname;    //昵称
    private String email;       //邮箱
    private String avatar;      //头像
    @Temporal(TemporalType.TIMESTAMP)
    private Date   createTime;  //创建时间

    @ManyToOne
    private Blog blog;          //博客

    @OneToMany(mappedBy = "parentComment")
    private List<Comment> replayComments;
    @ManyToOne
    private Comment parentComment;

    public Comment() {
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public List<Comment> getReplayComments() {
        return replayComments;
    }

    public void setReplayComments(List<Comment> replayComments) {
        this.replayComments = replayComments;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }
}
