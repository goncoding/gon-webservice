package com.gon.demo.domain.Memo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Table(name="tbl_memo")
@ToString
@Getter
@Entity
@NoArgsConstructor
public class Memo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;

    @Column(length = 200, nullable = false)
    private String memoText;

    @Builder
    public Memo(Long mno, String memoText) {
        this.mno = mno;
        this.memoText = memoText;
    }
}
