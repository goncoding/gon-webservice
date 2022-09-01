package com.gon.demo.domain.Memo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MemoRepositoryTest {
    
    @Autowired
    private MemoRepository memoRepository;

    @Commit
    @Test
    void test01() throws Exception{
        //given
        IntStream.rangeClosed(1,100).forEach(i -> {
            Memo build = Memo.builder().memoText("Sample..." + i).build();
            memoRepository.save(build);
        });
        
        //when
        
        
        //then
    }

    @Test
    void test02() throws Exception{
        //given
        Long mno = 100L;
        Optional<Memo> memo = memoRepository.findById(mno);
        if(memo.isPresent()){
            Memo memo1 = memo.get();
            System.out.println("memo1 = " + memo1);
        }

        System.out.println("memo = " + memo);

        //when


        //then
    }

    @Test
    void memo_페이징처리() throws Exception{
        //given
        
        Pageable pageable = PageRequest.of(10, 5);

        Page<Memo> result = memoRepository.findAll(pageable);
        System.out.println("result.isFirst() = " + result.isFirst());
        System.out.println("result.hasNext() = " + result.hasNext());
        System.out.println("result.getSize() = " + result.getSize());
        System.out.println("result.getNumber() = " + result.getNumber());
        System.out.println("result.getTotalElements() = " + result.getTotalElements());
        
        System.out.println("result.getTotalPages() = " + result.getTotalPages());
        
        for (Memo memo : result) {
            System.out.println("memo = " + memo);
        }


        //when


        //then
    }

    @Test
    @Transactional
    void test03() throws Exception{



        //given
//        Pageable pageable = PageRequest.of(0, 10, Sort.by("mno").descending().and(Sort.by("memoText").ascending()));
//        Page<Memo> result = memoRepository.findAll(pageable);
//        result.get().forEach(System.out::println);

//        List<Memo> list = memoRepository.findByMnoBetweenOrderByMnoDesc(70L, 80L);
//
//        for (Memo memo : list) {
//            System.out.println("memo = " + memo);
//        }

//        Pageable pageable = PageRequest.of(0, 10, Sort.by("mno").descending());
//
//        Page<Memo> byMnoBetween = memoRepository.findByMnoBetween(10L, 50L, pageable);
//
//        for (Memo memo : byMnoBetween) {
//            System.out.println("memo = " + memo);
//        }

        //transaction이 꼭 필요
        //5보다 작은 memo select 해와서
        //삭제가 진행
        memoRepository.deleteMemoByMnoLessThan(5L);


        Pageable pa = PageRequest.of(0, 10);

        Page<Memo> all = memoRepository.findAll(pa);
        for (Memo memo : all) {
            System.out.println("memo = " + memo);
        }

        //when


        //then
    }




}