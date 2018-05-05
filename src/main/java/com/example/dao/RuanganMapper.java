package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.RuanganModel;

@Mapper
public interface RuanganMapper {
	
	@Select("select * from ruang where id = #{id_ruang}")
    RuanganModel selectRuangan (@Param("id_ruang") int id_ruang);

    @Select("select * from ruang")
    List<RuanganModel> selectAllRuangans ();
    
}
