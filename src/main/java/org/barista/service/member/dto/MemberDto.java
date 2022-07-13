package org.barista.service.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.barista.framework.base.BaseDto;
import org.barista.service.member.entity.MemberEntity;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class MemberDto extends BaseDto {

    private String mberNo;
    private String mberName;
    private String mberId;
    private String mberPhone;
    private String address1;
    private String address2;
    private String mberSe;
    private String email;
    private String tokenKey;

    public static MemberDto getMemberDto(MemberEntity entity, String tokenKey) {
        return MemberDto.builder()
                .mberNo(entity.getMberNo())
                .mberName(entity.getMberName())
                .mberId(entity.getMberId())
                .mberPhone(entity.getMberPhone())
                .address1(entity.getAddress1())
                .address2(entity.getAddress2())
                .mberSe(entity.getMberSe())
                .email(entity.getEmail())
                .tokenKey(tokenKey)
                .build();
    }

    public MemberEntity toMemberEntity() {
        return MemberEntity.builder()
                .mberNo(mberNo)
                .mberName(mberName)
                .mberId(mberId)
                .mberPhone(mberPhone)
                .address1(address1)
                .address2(address2)
                .mberSe(mberSe)
                .email(email)
                .tokenKey(tokenKey)
                .build();
    }
}
