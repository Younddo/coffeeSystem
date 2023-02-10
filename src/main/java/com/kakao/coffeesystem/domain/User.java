package com.kakao.coffeesystem.domain;

import com.kakao.coffeesystem.dto.requestDto.UserRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User extends TimeStamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userNum;

    @Column
    private Long point;


    public User(UserRequestDto userRequestDto) {
        this.userNum = userRequestDto.getUserNum();
        this.point = userRequestDto.getChargeAmount();
    }

    public void update(UserRequestDto userRequestDto) {
        this.point += userRequestDto.getChargeAmount();
    }
}
