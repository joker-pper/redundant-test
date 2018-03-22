package com.devloper.joker.redundant.test.domain;

import com.devloper.joker.redundant.annotation.field.RdtField;
import com.devloper.joker.redundant.annotation.field.RdtFieldCondition;

public class Reply {

    private String id;

    @RdtFieldCondition(target = User.class, eqProperty = "id")
    private String userId;

    @RdtField(target = User.class, property = "username")
    private String userName;

    @RdtFieldCondition(target = User.class, eqProperty = "id", index = 1)
    private String answerUserId;  //当前回复的用户id

    @RdtField(target = User.class, property = "username", index = 1)
    private String answerUserName;  //当前回复的用户名称


    private String detail;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAnswerUserId() {
        return answerUserId;
    }

    public void setAnswerUserId(String answerUserId) {
        this.answerUserId = answerUserId;
    }

    public String getAnswerUserName() {
        return answerUserName;
    }

    public void setAnswerUserName(String answerUserName) {
        this.answerUserName = answerUserName;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
