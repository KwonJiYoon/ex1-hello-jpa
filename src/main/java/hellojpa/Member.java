package hellojpa;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Member {

    @Id
    private Long id;

    // updatable = false : 업데이트 되지 않음
    // nullable = false : not null
    // unique = true : 유니크 제약 조건을 만들어주긴하나 이름을 랜덤으로 생성하여 잘 사용하지 않음
    // columnDefinition = "varchar(100) default 'EMPTY' : 데이터베이스 컬럼 정보 직접 줄 수 있음
    @Column(name = "name", updatable = false)
    private String userName;

    private Integer age;

    // EnumType.ORNiDAL : enum의 순서 저장
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

    @Transient  // DB 반영 X
    private int temp;

    public Member() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return userName;
    }

    public Integer getAge() {
        return age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.userName = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
