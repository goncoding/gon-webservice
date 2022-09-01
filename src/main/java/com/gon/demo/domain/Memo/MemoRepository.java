package com.gon.demo.domain.Memo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {

    List<Memo> findByMnoBetweenOrderByMnoDesc(Long from, Long to);

    Page<Memo> findByMnoBetween(Long from, Long to, Pageable pageable);

    void deleteMemoByMnoLessThan(Long num);

    @Query("select m from Memo m order by m.mno desc")
    List<Memo> getListDesc();

//    @Query("update Memo m set m.memoText = :memoText where m.mno = :mno")
//    int updateMemoText(@Param("mno") Long mno, @Param("memoText") String memoText);

    @Transactional
    @Modifying
    @Query(value = "update Memo m set m.memoText = :#{#memo.memoText} where m.mno = #{#memo.mno}"
            , nativeQuery = true)
    int updateMemoText(@Param("memo") Memo memo);



}
