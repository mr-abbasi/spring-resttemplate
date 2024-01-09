package com.abbasi.springresttemplate.service;

import com.abbasi.springresttemplate.model.Post;
import com.abbasi.springresttemplate.utils.Converter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class PostService {
    private final RestTemplate restTemplate;

    @Value("${api.base-url}")
    private String baseUrl;

    public PostService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Post> getAllPosts() {
        var url = baseUrl + "posts";
        var postsResponseEntity = restTemplate.getForEntity(url, Post[].class);

        return Converter.arrayToList(postsResponseEntity.getBody());
    }

    public Post getPost(int id) {
        var url = (baseUrl + "posts/{id}").replace("{id}",Integer.toString(id));
        ResponseEntity<Post> postResponseEntity = restTemplate.getForEntity(url,Post.class);

        return postResponseEntity.getBody();


    }
}
