package com.ssg.webmvc_member.dao;

import com.ssg.webmvc_member.domain.MemberVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    public MemberVO login(String id, String pw) throws Exception{
        MemberVO vo;
        String sql = "select * from mvc_member where id =? and pw =?";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,id);
        ps.setString(2,pw);
        @Cleanup ResultSet rs = ps.executeQuery();

        rs.next();
        vo = MemberVO.builder()
                .id(rs.getString(1))
                .pw(rs.getString(2))
                .name(rs.getString(3))
                .email(rs.getString(4))
                .date(rs.getDate(5).toLocalDate())
                .build();

        return vo;
    }

    public List<MemberVO> selectAll() throws Exception {
        String sql = "select * from mvc_member";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(sql);
        @Cleanup ResultSet rs = ps.executeQuery();

        List<MemberVO> list = new ArrayList<>();

        while (rs.next()) {
            MemberVO vo = MemberVO.builder()
                    .id(rs.getString("id"))
                    .pw(rs.getString("pw"))
                    .name(rs.getString("name"))
                    .email(rs.getString("email"))
                    .date(rs.getDate("date").toLocalDate())
                    .build();
            list.add(vo);
        }
        return list;
    }
    public void insert(MemberVO vo) throws Exception{
        String sql = "insert into mvc_member(id,pw,name,email,date) values(?,?,?,?,?)";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1,vo.getId());
        ps.setString(2,vo.getPw());
        ps.setString(3,vo.getName());
        ps.setString(4,vo.getEmail());
        ps.setDate(5, Date.valueOf(vo.getDate()));
        ps.executeUpdate();
    }

    public MemberVO selectOne(String id) throws Exception{
        String sql = "select * from mvc_member where id = ?";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1,id);

        @Cleanup ResultSet rs = ps.executeQuery();

        if(rs.next()){
            MemberVO vo = MemberVO.builder().id(rs.getString("id"))
                    .pw(rs.getString("pw"))
                    .name(rs.getString("name"))
                    .pw(rs.getString("pw"))
                    .email(rs.getString("email"))
                    .date(rs.getDate("date").toLocalDate())
                    .build();
            return vo;
        }
        return null;
    }

    public void updateOne(MemberVO vo) throws Exception{
        String sql = "update mvc_member set pw= ?, name =?, email =?, `date` = ? where id =?";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1,vo.getPw());
        ps.setString(2,vo.getName());
        ps.setString(3,vo.getEmail());
        ps.setDate(4, Date.valueOf(vo.getDate()));
        ps.setString(5,vo.getId());
        ps.executeUpdate();
    }
    public void deleteOne(String id) throws Exception{
        String sql = "delete from mvc_member where id =?";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1,id);
        ps.executeUpdate();
    }
}
