package hs.kr.dgsw.board_back.controller;

import hs.kr.dgsw.board_back.domain.Post;
import hs.kr.dgsw.board_back.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/write")
    public Long writePost(@RequestBody Post post) {
        return postService.insertPost(post);
    }

    @GetMapping("/load")
    public List getPost(@RequestParam Long board, @RequestParam String order, @RequestParam int page) {
        return postService.loadPosts(board, order, page);
    }

    @GetMapping("/loadRecent")
    public List getRecentPosts() {
        return postService.loadRecentPosts();
    }

    @GetMapping("/get/{id}")
    public HashMap getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @DeleteMapping("/delete/{id}")
    public Long deletePostById(@PathVariable Long id){
        return postService.deletePost(id);
    }

    @PutMapping("/recommend/{id}")
    public int recommendPost(@PathVariable Long id){
        return postService.recommendPost(id);
    }

    @PutMapping("/update")
    public int updatePost(@RequestBody Post post){
        return postService.updatePost(post);
    }
}
