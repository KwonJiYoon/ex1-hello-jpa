package hellojpa;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Member {

    // @Id : 직접 할당
    // @GeneratedValue : 자동 생성
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // updatable = false : 업데이트 되지 않음
    // nullable = false : not null
    // unique = true : 유니크 제약 조건을 만들어주긴하나 이름을 랜덤으로 생성하여 잘 사용하지 않음
    // columnDefinition = "varchar(100) default 'EMPTY' : 데이터베이스 컬럼 정보 직접 줄 수 있음
    @Column(name = "name", updatable = false)
    private String userName;

    public Member() {
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
