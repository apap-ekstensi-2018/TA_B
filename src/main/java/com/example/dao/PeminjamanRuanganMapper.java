package com.example.dao;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
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

    @Select("SELECT id, id_ruang, id_mahasiswa, waktu_mulai, waktu_selesai, tanggal_mulai, tanggal_selesai, tujuan, keterangan, jumlah_peserta, fasilitas, is_disetujui, disetujui_oleh from peminjaman_ruangan ")
    List<PeminjamanRuanganModel> selectAllPeminjamanRuangan ();
    
    @Select("SELECT * FROM peminjaman_ruangan WHERE (tanggal_mulai BETWEEN #{tanggal_mulai} AND #{tanggal_selesai} OR tanggal_selesai BETWEEN #{tanggal_mulai} AND #{tanggal_selesai} "
    		+ "OR (tanggal_mulai < #{tanggal_mulai} AND tanggal_selesai > #{tanggal_selesai}))AND (id NOT IN (SELECT id FROM peminjaman_ruangan WHERE (tanggal_selesai = #{tanggal_mulai} "
    		+ "AND waktu_selesai < #{waktu_selesai}) OR (tanggal_mulai = #{tanggal_selesai} AND waktu_mulai > #{waktu_mulai})))ORDER BY id_ruang ASC") 
    List<PeminjamanRuanganModel> selectAllPeminjamanRuanganByDateTime(@Param("tanggal_mulai") String tanggal_mulai, @Param("tanggal_selesai") String tanggal_selesai,@Param("waktu_mulai") String waktu_mulai, @Param("waktu_selesai") String waktu_selesai);
    
    //@Select("SELECT id, id_ruang, id_mahasiswa, waktu_mulai, waktu_selesai, tanggal_mulai, tanggal_selesai, tujuan, keterangan, jumlah_peserta, fasilitas, is_disetujui, disetujui_oleh from peminjaman_ruangan")
    ArrayList<PeminjamanRuanganModel> selectArrayAllPeminjamanRuangan (); 
    
    @Select ("select * from peminjaman_ruangan where id= #{id_mahasiswa}")
    List<PeminjamanRuanganModel> selectAllPeminjamanRuanganByIdMahasiswa (@Param("id_mahasiswa")int id_mahasiswa);
	
    @Insert("insert into peminjaman_ruangan (id_ruang, id_mahasiswa, waktu_mulai, waktu_selesai, tanggal_mulai, tanggal_selesai, tujuan, keterangan, jumlah_peserta, fasilitas, is_disetujui)"
    		+ "values (#{idRuang}, #{idMahasiswa}, #{waktuMulai}, #{waktuSelesai}, #{tanggalMulai}, #{tanggalSelesai}, #{tujuan}, #{keterangan}, #{jumlahPeserta}, #{fasilitas}, #{isDisetujui})")
    void addPeminjamanRuangan(PeminjamanRuanganModel peminjamanRuangan);
    
    @Select ("select * from peminjaman_ruangan where npm= #{npm}")
    List<PeminjamanRuanganModel> selectAllPeminjamanRuanganByNpm (@Param("npm")int npm);
}
