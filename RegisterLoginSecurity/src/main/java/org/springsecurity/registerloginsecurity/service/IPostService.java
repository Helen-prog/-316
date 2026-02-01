package org.springsecurity.registerloginsecurity.service;

import org.springframework.web.multipart.MultipartFile;
import org.springsecurity.registerloginsecurity.entity.Post;

import java.util.List;

public interface IPostService {
    public Post savePost(Post post);
    public List<Post> getAllPosts();
    public Boolean deletePost(int id);
    public Post getPostById(int id);
    public Post updatePost(Post post, MultipartFile image);
    public List<Post> getAllSelectPosts(String category);
}
