package com.ssg.webmvc_member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class MemberDTO {
    private String id;
    private String pw;
    private String name;
    private String email;
    private LocalDate date;
}
