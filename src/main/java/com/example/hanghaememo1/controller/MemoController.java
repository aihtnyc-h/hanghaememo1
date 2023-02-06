package com.example.hanghaememo1.controller;

import com.example.hanghaememo1.dto.MemoRequestDto;
import com.example.hanghaememo1.entity.Memo;
import com.example.hanghaememo1.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class MemoController {

    private final MemoService memoService;

    @GetMapping("/api/posts")
    public List<Memo> getPosts() {
        return memoService.getMemos();
    }

    @PostMapping("/api/post")
    public Memo createPost(@RequestBody MemoRequestDto requestDto) {
        return memoService.createMemo(requestDto);
    }

    @GetMapping("/api/post/{id}")
    public List<Memo> getPost(@PathVariable Long id) {
        return memoService.getMemos();
    }

    @PutMapping("/api/post/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        return memoService.update(id, requestDto);
    }

    @DeleteMapping("/api/post/{id}")
    public Long deletePost(@PathVariable Long id) {
        return memoService.deleteMemo(id);
    }
}

