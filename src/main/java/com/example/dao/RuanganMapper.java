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

    @Select("select * from ruang where nama like #{nama}")
    RuanganModel selectRuanganByNama(@Param("nama")String nama);
    
    @Insert("insert into ruang (nama, kapasitas) VALUES (#{nama}, #{kapasitas})")
    void addRuangan (RuanganModel ruanganModel);
    
    @Update("update ruang set nama=#{nama}, kapasitas=#{kapasitas} where id = #{id}")
    void updateRuangan(RuanganModel ruanganModel);
    

	}
