package com.example.hanghaememo1.entity;

import com.example.hanghaememo1.dto.MemoRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.util.ArrayList;
import java.util.Collection;
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
    @Column(nullable = false)
    private String titlename;
    @Column(nullable = false)
    private String password;

    public Memo(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.titlename = requestDto.getTitlename();
        this.password = requestDto.getPassword();
    }

//    public static User Username() { //
//        return null;
//    }

    public void update(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.titlename = requestDto.getTitlename();
    }

}