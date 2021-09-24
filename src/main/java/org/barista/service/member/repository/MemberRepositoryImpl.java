package org.barista.service.member.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.barista.service.member.entity.MemberEntity;
import org.barista.service.member.entity.QMemberEntity;

import javax.persistence.EntityManager;
import java.util.Optional;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{
    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

//    EntityManager em = entityManagerFactory.createEntityManager();
//    JPAQueryFactory queryFactory = new JPAQueryFactory(em);

    QMemberEntity dbName = new QMemberEntity("member");

//    public long save(MemberEntity member) {
//        em.persist(member);
//        return 1;
//    }

//    public long create(MemberEntity member) {
//        queryFactory.insert(dbName)
////                .columns(dbName.mberNo,
////                        dbName.mberId,
////                        dbName.password,
////                        dbName.mberName,
////                        dbName.email,
////                        dbName.mberSe,
////                        dbName.registDe,
////                        dbName.modifyDe)
////                .values(member.getMberNo(),
////                        member.getMberId(),
////                        member.getPassword(),
////                        member.getMberName(),
////                        member.getEmail(),
////                        member.getMberSe(),
////                        LocalDateTime.now(),
////                        LocalDateTime.now() )
////                .execute();
//
//                .set(dbName.mberNo,   member.getMberNo()  )
//                .set(dbName.mberId,   member.getMberId()  )
//                .set(dbName.password, member.getPassword())
//                .set(dbName.mberName, member.getMberName())
//                .set(dbName.email,    member.getEmail()   )
//                .set(dbName.mberSe,   member.getMberSe()  )
//                .set(dbName.registDe, LocalDateTime.now() )
//                .set(dbName.modifyDe, LocalDateTime.now() )
//                .execute();
//        return 1;
//    }

    public Optional<MemberEntity> get(String mberid) {
        return Optional.ofNullable(
                queryFactory
                    .selectFrom(dbName)
                    .where(dbName.mberId.eq(mberid))
                    .fetchOne()
        );
    }
}
