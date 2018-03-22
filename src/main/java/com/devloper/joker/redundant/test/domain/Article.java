package com.devloper.joker.redundant.test.domain;

import com.devloper.joker.redundant.annotation.RdtComplex;
import com.devloper.joker.redundant.annotation.RdtMany;
import com.devloper.joker.redundant.annotation.RdtOne;
import com.devloper.joker.redundant.annotation.field.RdtField;
import com.devloper.joker.redundant.annotation.field.RdtFieldCondition;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Article {

    @Id
    private String id;

    @RdtField(target = User.class, property = "username")
    private String author;

    @RdtFieldCondition(target = User.class, eqProperty = "id")
    private String userId;

    private String content;  //内容

    //子文档更新----依赖于子文档的注解

    @RdtMany
    private List<Reply> replyList;

    @RdtOne
    private Reply reply;

    @RdtOne
    private ComplexVo complex;//复杂对象

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Reply> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<Reply> replyList) {
        this.replyList = replyList;
    }

    public Reply getReply() {
        return reply;
    }

    public void setReply(Reply reply) {
        this.reply = reply;
    }

    public ComplexVo getComplex() {
        return complex;
    }

    public void setComplex(ComplexVo complex) {
        this.complex = complex;
    }
}
