package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor  // 기본 생성자 자동 추가
@Entity     // 테이블과 링크될 클래스임을 나타낸다. 기본값으로 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭한다.
            // ex)SalesManager.java -> sales_manager table
public class Posts {
    @Id     // 해당 테이블의 PK 필드를 나타낸다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙을 나타낸다. 부트 2.0에서는 GenerationType.IDENTITY
                                                        // 옵션을 추가해야만 auto_increment가 된다.
    private Long id;

    @Column(length = 500, nullable = false)     // 테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이된다.
                                                // 기본값 외에 추가로 변경이  필요한 옵션이 있으면 사용한다.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder    // 해당 클래스의 빌더 패턴 클래스를 생성
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
