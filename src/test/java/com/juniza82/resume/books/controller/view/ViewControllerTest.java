package com.juniza82.resume.books.controller.view;

import com.juniza82.resume.domain.books.Posts;
import com.juniza82.resume.dto.books.PostsSaveRequestDto;
import com.juniza82.resume.dto.books.PostsUpdateRequestDto;
import com.juniza82.resume.repository.books.PostsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ViewControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostsRepository postsRepository;

    @Test
    public void 메인페이지_index_로딩() {
        // when
        String body = this.restTemplate.getForObject("/", String.class);

        // then
        assertThat(body).contains("개인 공간 테스트");
    }



}
