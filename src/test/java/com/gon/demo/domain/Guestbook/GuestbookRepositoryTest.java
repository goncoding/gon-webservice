package com.gon.demo.domain.Guestbook;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GuestbookRepositoryTest {

    @Autowired
    EntityManager em;

    JPAQueryFactory queryFactory;

    @Autowired
    private GuestbookRepository guestbookRepository;

    @Test
    @Commit
    void test01() throws Exception{
        //given
        IntStream.rangeClosed(1,300).forEach(i -> {
            Guestbook build = Guestbook.builder()
                    .title("title..." + i)
                    .content("content..." + i)
                    .writer("user" + (i % 10))
                    .build();

            guestbookRepository.save(build);

        });

//        Pageable pageable = PageRequest.of(0, 10);
//        Page<Guestbook> all = guestbookRepository.findAll(pageable);
//
//        for (Guestbook guestbook : all) {
//            System.out.println("guestbook = " + guestbook);
//        }


        //when


        //then
    }


    @Test
    @Transactional
    @Commit
    void test04() throws Exception{
        //given

        Optional<Guestbook> byId = guestbookRepository.findById(100L);
        if(byId.isPresent()){
            Guestbook guestbook = byId.get();
            guestbook.updateGuestbook("aaa1","bbb1");

        }

        Optional<Guestbook> byId1 = guestbookRepository.findById(100L);
        System.out.println("byId1 = " + byId1);


        //when


        //then
    }

    @Test
    void test05() throws Exception{
        //given
        Pageable pageable = PageRequest.of(0, 10, Sort.by("gno"));

        QGuestbook guestbook = QGuestbook.guestbook;
        String keyword = "1";




        BooleanBuilder builder = new BooleanBuilder();

        BooleanExpression exTitle = guestbook.title.contains(keyword);

        BooleanExpression exContent = guestbook.content.contains(keyword);

        BooleanExpression exAll = exTitle.or(exContent);

        builder.and(exAll).and(guestbook.gno.gt(0L));

        Page<Guestbook> all = guestbookRepository.findAll(builder, pageable);

        all.get().forEach(System.out::println);

        //when


        //then
    }


}
