package com.example.hanghaememo1.entity;

import com.example.hanghaememo1.dto.MemoRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Memo extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;
    //@Column(nullable = false)
    private String titlename;
    //@Column(nullable = false)
    private String password;

    public Memo(String username, String contents, String titlename, String password) {
        this.username = username;
        this.contents = contents;
        this.titlename = titlename;
        this.password = password;
    }

    public Memo(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.titlename = requestDto.getTitlename();
        this.password = requestDto.getPassword();
    }

    public void update(MemoRequestDto memoRequestDto) {
        this.username = memoRequestDto.getUsername();
        this.contents = memoRequestDto.getContents();
        this.titlename = memoRequestDto.getTitlename();
        this.password = memoRequestDto.getPassword();
    }


}