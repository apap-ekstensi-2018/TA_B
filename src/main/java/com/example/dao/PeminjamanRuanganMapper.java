package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.model.PeminjamanRuanganModel;

@Mapper
public interface PeminjamanRuanganMapper {
	
	@Select("select * from peminjaman_ruangan where id = #{id_peminjaman}")
    PeminjamanRuanganModel selectPeminjamanRuangan (@Param("id_peminjaman") int id_peminjaman);

    @Select("select * from peminjaman_ruangan")
    List<PeminjamanRuanganModel> selectAllPeminjamanRuangans ();
	
    @Insert("insert into peminjaman_ruangan (id_ruang, id_mahasiswa, waktu_mulai, waktu_selesai, tanggal_mulai, tanggal_selesai, tujuan, keterangan, jumlah_peserta, fasilitas, is_disetujui)"
    		+ "values (#{idRuang}, #{idMahasiswa}, #{waktuMulai}, #{waktuSelesai}, #{tanggalMulai}, #{tanggalSelesai}, #{tujuan}, #{keterangan}, #{jumlahPeserta}, #{fasilitas}, #{isDisetujui})")
    void addPeminjamanRuangan(PeminjamanRuanganModel peminjamanRuangan);
}
