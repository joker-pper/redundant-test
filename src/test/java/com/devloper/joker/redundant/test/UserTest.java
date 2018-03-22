package com.devloper.joker.redundant.test;


import com.devloper.joker.redundant.mongo.MongoRdtOperation;
import com.devloper.joker.redundant.test.domain.Article;
import com.devloper.joker.redundant.test.domain.ComplexVo;
import com.devloper.joker.redundant.test.domain.Reply;
import com.devloper.joker.redundant.test.domain.User;
import com.devloper.joker.redundant.test.repository.domain.ArticleRepository;
import com.devloper.joker.redundant.test.repository.domain.UserRepository;
import com.devloper.joker.redundant.utils.JackSonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private UserRepository userRepository;


    @Resource
    private ArticleRepository articleRepository;


    @Resource
    private MongoRdtOperation rdtOperation;

    @Resource
    private MongoTemplate mongoTemplate;

    @Test
    public void saveUsers() {
        String[] userNames = new String[] {"张三", "李四", "王五"};
        String[] ids = new String[] {"1", "2", "3"};
        int[] ages = new int[] {22, 25, 23};

        for (int i = 0; i < userNames.length; i ++) {
            User user = new User();
            user.setUserName(userNames[i]);
            user.setId(ids[i]);
            user.setAge(ages[i]);

            userRepository.save(user);
        }
    }


    @Test
    public void updateUsers() {
        String[] userNames = new String[] {"张三-Aa", "李四-Bb", "王五-Cc"};
        String[] ids = new String[] {"1", "2", "3"};
        int[] ages = new int[] {22, 25, 23};

        for (int i = 0; i < userNames.length; i ++) {
            User user = new User();
            user.setUserName(userNames[i]);
            user.setId(ids[i]);
            user.setAge(ages[i]);
            userRepository.save(user);
        }


        try {
            Thread.sleep(8888);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void saveArticles() {
        String[] userNames = new String[] {"张三", "李四", "王五"};
        String[] ids = new String[] {"1", "2", "3"};
        String[] userIds = new String[] {"1", "2", "3"};

        for (int i = 0; i < userNames.length; i ++) {
            Article article = new Article();
            article.setId(ids[i]);
            //设置用户id和作者
            article.setUserId(userIds[i]);
            article.setAuthor(userNames[i]);

            article.setReplyList(getReplyList(6, true));

            article.setReply(getReply());

            article.setComplex(getComplexVo());


            articleRepository.save(article);
        }

    }


    @Test
    public void saveUserInfo() {
        User user = new User();
        user.setId("1");
        user.setUserName("joker");
        userRepository.save(user);

        //rdtOperation.updateMulti(user);  //修改相关数据
    }

    @Test
    public void findArticleList() {
        List<Article> articleList = articleRepository.findAll();
        List<Article> articleList2 = mongoTemplate.findAll(Article.class);
        log.info("{}", JackSonUtils.toJson(articleList));

    }

    public ComplexVo getComplexVo() {
        ComplexVo vo = new ComplexVo();
        String[] userIds = new String[] {"1", "2", "3"};
        String[] userNames = new String[] {"张三", "李四", "王五"};
        int index = new Random().nextInt(3);
        vo.setUserId(userIds[index]);
        vo.setUserName(userNames[index]);
        vo.setReply(getReply());
        vo.setReplyList(getReplyList(6, true));

        return vo;
    }
    public List<Reply> getReplyList(int size, boolean random) {
        List<Reply> replies = new ArrayList<>();
        if (random) size = new Random().nextInt(size);
        for (int j = 0; j < size; j ++) {
            replies.add(getReply());
        }
        return replies;
    }





    public Reply getReply() {

        String[] userIds = new String[] {"1", "2", "3"};
        String[] userNames = new String[] {"张三", "李四", "王五"};

        int first = new Random().nextInt(3);
        int second = new Random().nextInt(3);

        Reply reply = new Reply();
        reply.setId(UUID.randomUUID().toString());
        reply.setUserId(userIds[first]);
        reply.setUserName(userNames[first]);
        if (first != second) {
            reply.setAnswerUserId(userIds[second]);
            reply.setAnswerUserName(userNames[second]);
        }
        return reply;
    }




}
