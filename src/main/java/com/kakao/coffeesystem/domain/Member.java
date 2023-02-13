package com.kakao.coffeesystem.domain;

import com.kakao.coffeesystem.dto.requestDto.MemberRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="member")
@Getter
@Setter
@NoArgsConstructor
public class Member extends TimeStamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userNum;

    @Column
    private Long point;


    public Member(MemberRequestDto userRequestDto) {
        this.userNum = userRequestDto.getUserNum();
        this.point = userRequestDto.getChargeAmount();
    }

    public void update(MemberRequestDto userRequestDto) {
        this.point += userRequestDto.getChargeAmount();
    }
}
