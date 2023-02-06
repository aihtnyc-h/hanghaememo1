package com.example.hanghaememo1.service;

import com.example.hanghaememo1.dto.MemoRequestDto;
import com.example.hanghaememo1.dto.MemoResponseDto;
import com.example.hanghaememo1.entity.Memo;
import com.example.hanghaememo1.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoRepository memoRepository;

    @Transactional
    public Memo createMemo(MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        memoRepository.save(memo);
        return memo;
    }

    @Transactional(readOnly = true)
    public List<Memo> getMemo() {
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

//    @Transactional(readOnly = true)
//    public Optional<Memo> getPost(Long id) {
//        return memoRepository.findById(id);
//    }

//    @Transactional(readOnly = true)
//    public MemoRepository getMemo(Long id) {
//        Memo post = memoRepository.findById(id).orElseThrow(
//                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
//        );
//
//        return new MemoResponseDto(memo);
//    }
//
//        return memo.getId();
//        memo = memoRepository.findById(id).orElseThrow(
//                () -> new IllegalArgumentException("비밀번호가 일치하지 않습니다.")
//        );
//
//        if (!memo.getPassword().equals(id)) {
//            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
//
//        };
//        return Long.valueOf(memo.getPassword());
    //return Long.valueOf(memo.getPassword());


//    @Transactional
//    public Long deleteMemo(Long password) {
//        Memo memo = memoRepository.findById(password).orElseThrow(
//                () -> new IllegalArgumentException("비밀번호가 일치하지 않습니다.")
//        );
//        if (!memo.Password().equals(password)) {
//            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
//
//        }
//
//        return password;
//    }


    @Transactional(readOnly = true)
    public MemoRequestDto getPost(Long id) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                ()  -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );

        return new MemoRequestDto();//memo
    }

    @Transactional
    public Long updateMemo(Long id, MemoRequestDto requestDto) {
        if (!validatePassword(id, requestDto.getPassword())) {
            return -99L;
        }

        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );

        memo.update(requestDto);
        return memo.getId();
    }

    @Transactional
    public Long deleteMemo(Long id, String password) {
        if (!validatePassword(id, password)) {
            return -99L;
        }

        memoRepository.deleteById(id);
        return id;
    }

    private Boolean validatePassword(Long id, String password) {
        return password.equals(memoRepository.getReferenceById(id).getPassword());
    }


}