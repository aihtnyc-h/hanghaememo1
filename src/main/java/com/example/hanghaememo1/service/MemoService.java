package com.example.hanghaememo1.service;

import com.example.hanghaememo1.dto.MemoRequestDto;
import com.example.hanghaememo1.entity.Memo;
import com.example.hanghaememo1.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public List<Memo> getMemos() {
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    @Transactional
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        memo.update(requestDto);

        //return memo.getId();

        memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("비밀번호가 일치하지 않습니다.")
        );
        if (!memo.getPassword().equals(id)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");

        }
        return Long.valueOf(memo.getPassword());
    }

    @Transactional
    public Long deleteMemo(Long password) {
        Memo memo = memoRepository.findById(password).orElseThrow(
                () -> new IllegalArgumentException("비밀번호가 일치하지 않습니다.")
        );
        if (!memo.getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");

        }

        return password;
    }
}

