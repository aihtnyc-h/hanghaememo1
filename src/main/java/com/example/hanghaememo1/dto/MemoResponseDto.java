package com.example.hanghaememo1.dto;


import com.example.hanghaememo1.entity.Memo;
import lombok.Getter;

@Getter
public class MemoResponseDto {
    private String title;
    private String contents;
    private String username;

    public MemoResponseDto(Memo memo) {
        this.title = memo.getTitlename();
        this.contents = memo.getContents();
        this.username = memo.getUsername();
    }
}