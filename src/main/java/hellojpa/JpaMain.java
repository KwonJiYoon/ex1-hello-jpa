package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        // 애플리케이션 로딩 시 한번만 생성하여 애플리케이션 전체에서 공유
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // 스레드간 공유 X :: 사용하고 버려야 함
        EntityManager em = emf.createEntityManager();

        // JPA의 모든 데이터 변경은 트랜잭션 안에서 실행
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            // 비영속
            Member member = new Member();
            member.setId(101L);
            member.setName("HelloJPA");

            // 영속
            System.out.println("=== BEFORE ===");
            em.persist(member);
            System.out.println("=== AFTER ===");

            Member findMember = em.find(Member.class, 101L);

            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
