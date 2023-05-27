package com.juniza82.resume.books.repository;

import com.juniza82.resume.ResumeApplication;
import com.juniza82.resume.domain.books.Posts;
import com.juniza82.resume.repository.books.PostsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ResumeApplication.class)
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        // given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        Posts posts = Posts.builder()
                .title(title)
                .content(content)
                .author("juniza82@gmail.com")
                .build();

        postsRepository.save(posts);

        // when
        List<Posts> postsList = postsRepository.findAll();

        System.out.println(postsList);
        System.out.println(postsList);

        // then
        Posts postsTest = postsList.get(0);
        assertThat(postsTest.getTitle()).isEqualTo(title);
        assertThat(postsTest.getContent()).isEqualTo(content);

    }

    @Test
    public void BaseTimeEntity_등록() {

        //given
        LocalDateTime now = LocalDateTime.of(2023,5,27,0,0,0);
        postsRepository.save(Posts.builder()
                            .title("title")
                            .content("content")
                            .author("juniza82@gmail.com")
                            .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>> createDate= " + posts.getCreatedDate() + ", modifiedDate= "+ posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
