package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.PeminjamanRuanganModel;

@Mapper
public interface PeminjamanRuanganMapper {
	
	@Select("select * from peminjaman_ruangan where id = #{id_peminjaman}")
    PeminjamanRuanganModel selectPeminjamanRuangan (@Param("id_peminjaman") int id_peminjaman);

    @Select("SELECT id, id_ruang, id_mahasiswa, waktu_mulai, waktu_selesai, tanggal_mulai, tanggal_selesai, tujuan, keterangan, jumlah_peserta, fasilitas, is_disetujui, disetujui_oleh from peminjaman_ruangan ")
    List<PeminjamanRuanganModel> selectAllPeminjamanRuangan ();
    
    @Select("SELECT * FROM peminjaman_ruangan WHERE (tanggal_mulai BETWEEN #{tanggal_mulai} AND #{tanggal_selesai} OR tanggal_selesai BETWEEN #{tanggal_mulai} AND #{tanggal_selesai} "
    		+ "OR (tanggal_mulai < #{tanggal_mulai} AND tanggal_selesai > #{tanggal_selesai}))AND (id NOT IN (SELECT id FROM peminjaman_ruangan WHERE (tanggal_selesai = #{tanggal_mulai} "
    		+ "AND waktu_selesai < #{waktu_selesai}) OR (tanggal_mulai = #{tanggal_selesai} AND waktu_mulai > #{waktu_mulai}))) AND (is_disetujui = 1) ORDER BY id_ruang ASC") 
    List<PeminjamanRuanganModel> selectAllPeminjamanRuanganByDateTime(@Param("tanggal_mulai") String tanggal_mulai, @Param("tanggal_selesai") String tanggal_selesai,@Param("waktu_mulai") String waktu_mulai, @Param("waktu_selesai") String waktu_selesai);
    
    //@Select("SELECT id, id_ruang, id_mahasiswa, waktu_mulai, waktu_selesai, tanggal_mulai, tanggal_selesai, tujuan, keterangan, jumlah_peserta, fasilitas, is_disetujui, disetujui_oleh from peminjaman_ruangan")
    ArrayList<PeminjamanRuanganModel> selectArrayAllPeminjamanRuangan (); 
    
    @Select ("select * from peminjaman_ruangan where id= #{id_mahasiswa}")
    List<PeminjamanRuanganModel> selectAllPeminjamanRuanganByIdMahasiswa (@Param("id_mahasiswa")int id_mahasiswa);
	
    @Insert("insert into peminjaman_ruangan (id_ruang, id_mahasiswa, waktu_mulai, waktu_selesai, tanggal_mulai, tanggal_selesai, tujuan, keterangan, jumlah_peserta, fasilitas, is_disetujui)"
    		+ "values (#{id_ruang}, #{id_mahasiswa}, #{waktu_mulai}, #{waktu_selesai}, #{tanggal_mulai}, #{tanggal_selesai}, #{tujuan}, #{keterangan}, #{jumlah_peserta}, #{fasilitas}, #{is_disetujui})")
    void addPeminjamanRuangan(PeminjamanRuanganModel peminjamanRuangan);
    
    @Select ("select * from peminjaman_ruangan where npm= #{npm}")
    List<PeminjamanRuanganModel> selectAllPeminjamanRuanganByNpm (@Param("npm")int npm);
    
    @Select ("select count(1) from peminjaman_ruangan where id_ruang = #{id_ruang} "
    		+ "AND (tanggal_mulai between #{tanggal_mulai} and #{tanggal_selesai} OR tanggal_selesai between #{tanggal_mulai} and #{tanggal_selesai} OR (tanggal_mulai < #{tanggal_mulai} AND tanggal_selesai > #{tanggal_selesai}))"
    		+ "AND (id NOT IN (SELECT id FROM peminjaman_ruangan WHERE (tanggal_selesai = #{tanggal_mulai} AND waktu_selesai < #{waktu_mulai}) OR (tanggal_mulai = #{tanggal_selesai} AND waktu_mulai > #{waktu_selesai})))"
    		+ "AND (is_disetujui = 1)")
    int checkAvailabilityRuangan(PeminjamanRuanganModel peminjamanRuangan);
    
    @Update("update peminjaman_ruangan set is_disetujui = #{status}, disetujui_oleh = #{id_pegawai} where id = #{id_peminjaman}")
    void updateStatusPeminjamanRuangan(@Param("id_peminjaman")int id_peminjaman, @Param("status")String status, @Param("id_pegawai")int id_pegawai);
    
    @Select("select count(1) from peminjaman_ruangan where is_disetujui = 2 and tanggal_mulai >= #{today_date}")
    int quantityTotalStatusPeminjamanPending(@Param("today_date")String today_date);
    
    @Select("select count(distinct id_ruang) from peminjaman_ruangan where is_disetujui = 1  and tanggal_selesai >= #{today_date}")
    int quantityToatalRuanganDigunakan(@Param("today_date")String today_date);
    
    @Select("select id_ruang, count(id_ruang) as total from peminjaman_ruangan group by id_ruang order by total desc limit 0,5")
    List<int[]> selectTop5ruangan();
    
}
