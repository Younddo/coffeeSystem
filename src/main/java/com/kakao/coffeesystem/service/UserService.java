package com.kakao.coffeesystem.service;

import com.kakao.coffeesystem.domain.Member;
import com.kakao.coffeesystem.dto.requestDto.MemberRequestDto;
import com.kakao.coffeesystem.dto.responseDto.MemberResponseDto;
import com.kakao.coffeesystem.global.GlobalResponseDto;
import com.kakao.coffeesystem.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final MemberRepository memberRepository;
    @Transactional
    public GlobalResponseDto<MemberResponseDto> chargePoint(MemberRequestDto memberRequestDto) {

        if(!memberRepository.existsMemberByUserNum(memberRequestDto.getUserNum())) {
            Member member = new Member(memberRequestDto);
            memberRepository.save(member);
            return GlobalResponseDto.ok("포인트 충전 성공!", new MemberResponseDto(member));
        } else{
            Member member = memberRepository.findUserByUserNum(memberRequestDto.getUserNum());
            member.update(memberRequestDto);
            return GlobalResponseDto.ok("포인트 충전 성공!", new MemberResponseDto(member));
        }
    }

}
