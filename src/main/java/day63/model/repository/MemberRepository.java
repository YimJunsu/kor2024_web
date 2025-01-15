package day63.model.repository;

import day63.model.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository                                       // <조작할 엔티티 클래스명, 기본키 타입>
public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {
}
