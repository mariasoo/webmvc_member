package com.ssg.webmvc_member.service;

import com.ssg.webmvc_member.dao.MemberDAO;
import com.ssg.webmvc_member.domain.MemberVO;
import com.ssg.webmvc_member.dto.MemberDTO;
import com.ssg.webmvc_member.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum MemberService {
    INSTANCE;
    // 상수 이름이고 여기 안에 멤버 서비스와 관련한 생성자 메소드 다 포함되어 있음 싱글톤 패턴과 같음
    //enum으로 직접 접근 중간객체라서 컨트롤러와 다오 사이에 있어서 로그 처리 해줘야 함

    private ModelMapper modelMapper; //서비스에서 vo를 dto로 바꿔줌
    private MemberDAO memberDAO;

    MemberService() {
        memberDAO = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public MemberDTO login(String id,String pw) throws Exception{
        MemberVO vo = memberDAO.login(id,pw);
        MemberDTO dto = modelMapper.map(vo,MemberDTO.class);
        return dto;
    }

    public List<MemberDTO> listMembers() throws Exception{
        List<MemberVO> voList = memberDAO.selectAll();

        List<MemberDTO> dtoList = voList.stream().
                map(vo->modelMapper.map(vo,MemberDTO.class))
                .collect(Collectors.toList());

        return dtoList;
    }

    public void registerMembers(MemberDTO dto) throws Exception{
        MemberVO vo = modelMapper.map(dto,MemberVO.class);
        memberDAO.insert(vo);
    }

    public MemberDTO selectMember(String id) throws Exception{
        MemberVO vo = memberDAO.selectOne(id);
        MemberDTO dto = modelMapper.map(vo,MemberDTO.class);

        return dto;
    }

    public void modifyMember(MemberDTO dto) throws Exception{
        MemberVO vo = modelMapper.map(dto,MemberVO.class);
        memberDAO.updateOne(vo);
    }

    public void deleteMember(String id) throws Exception{
        memberDAO.deleteOne(id);
    }
}
