package org.barista.service.attach.repository;

import com.querydsl.core.support.QueryBase;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.barista.framework.base.BaseMap;
import org.barista.framework.constants.CommonConstants;
import org.barista.framework.utils.RepositoryUtil;
import org.barista.framework.utils.Utils;
import org.barista.service.attach.dto.AttachDto;
import org.barista.service.attach.dto.AttachSearchDto;
import org.barista.service.attach.entity.AttachEntity;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class AttachRepositoryImpl implements AttachRepositoryCustorm {

    private final JPAQueryFactory queryFactory;

    BaseMap<AttachEntity> baseMap = new BaseMap<AttachEntity>(AttachEntity.class, "attachEntity");

    @Override
    public AttachDto get(String id, Expression<?>... expressions) {
        return queryFactory.select(Projections.fields(AttachDto.class, setSearchColumns(expressions)))
                .from(Q_ATTACH_ENTITY)
                .where(Utils.isExpression(id, Q_ATTACH_ENTITY.id.eq(id)))
                .fetchOne();
    }

    @Override
    public List<AttachDto> getJustList(Object obj, Expression<?>... expressions) {
        AttachSearchDto searchDto = (AttachSearchDto) obj;
        searchDto.setSort(searchDto.getOrder(), searchDto.getOrderProperty());

        return getListSQL(getBaseSQL(searchDto, expressions), searchDto).fetch();
    }

    @Override
    public Map<String, Object> getList(Object obj, Expression<?>... expressions) {
        AttachSearchDto searchDto = (AttachSearchDto) obj;
        searchDto.setSort(searchDto.getOrder(), searchDto.getOrderProperty());

        QueryBase<JPAQuery<AttachDto>> query = getBaseSQL(searchDto, expressions);

        return Map.of(
                CommonConstants.CONST_LIST, getListSQL(query, searchDto).fetch(),
                CommonConstants.CONST_LIST_COUNT, query.distinct().fetchCount()
        );
    }

    private JPAQuery getListSQL (QueryBase<JPAQuery<AttachDto>> queryBase, AttachSearchDto searchDto) {
        return queryBase
                .orderBy(RepositoryUtil.getOrderSpecifier(searchDto.getSort()
                        , new PathBuilder(AttachEntity.class, "attachEntity")).stream().toArray(OrderSpecifier[]::new))
                .offset(RepositoryUtil.setPage(searchDto.getPage()))
                .limit(RepositoryUtil.setPageSize(searchDto.getPageSize()))
                .distinct();
    }

    private QueryBase<JPAQuery<AttachDto>> getBaseSQL(AttachSearchDto searchDto, Expression<?>... expressions) {
        return queryFactory.select(Projections.fields(AttachDto.class, setSearchColumns(expressions)))
                .from(Q_ATTACH_ENTITY)
                .where(
                          RepositoryUtil.equals(searchDto.getId(), Q_ATTACH_ENTITY.id)
                        , RepositoryUtil.equals(searchDto.getSavedFileName(), Q_ATTACH_ENTITY.savedFileName)
                        , RepositoryUtil.equals(searchDto.getOrgFileName(), Q_ATTACH_ENTITY.orgFileName)
                        , RepositoryUtil.equals(searchDto.getDirPath(), Q_ATTACH_ENTITY.dirPath)
                        , RepositoryUtil.equals(searchDto.getDivision(), Q_ATTACH_ENTITY.division)
                        , RepositoryUtil.equals(searchDto.getDivisionId(), Q_ATTACH_ENTITY.divisionId)
                );
    }

    private Expression<?>[] setSearchColumns(Expression<?>... expressions) {
        return expressions.length == 0 ? new Expression[] {
                  Q_ATTACH_ENTITY.id
                , Q_ATTACH_ENTITY.savedFileName
                , Q_ATTACH_ENTITY.orgFileName
                , Q_ATTACH_ENTITY.dirPath
                , Q_ATTACH_ENTITY.division
                , Q_ATTACH_ENTITY.divisionId
                , Q_ATTACH_ENTITY.sortOrder
        } : expressions;
    }

}
