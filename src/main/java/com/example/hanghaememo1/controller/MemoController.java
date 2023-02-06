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
    public List<Memo> getMemo() {
        return memoService.getMemo();
    }

    @PostMapping("/api/post")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        return memoService.createMemo(requestDto);
    }

    @GetMapping("/api/post/{id}")
    public List<Memo> getMemo(@PathVariable Long id) {
        return memoService.getMemo();
    }

    @PutMapping("/api/post/{id}")
    public Long updateMemos(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        return memoService.updateMemo(id, requestDto);
    }

    @DeleteMapping("/api/post/{id}")
    public Long deleteMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        return memoService.deleteMemo(id, requestDto.getPassword());
    }
}

