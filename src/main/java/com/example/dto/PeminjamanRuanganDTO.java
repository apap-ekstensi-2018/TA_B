package com.example.dto;

import com.example.model.MahasiswaModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeminjamanRuanganDTO {
	
	private int id;
	private String ruangan;
	private String npm_mahasiswa;
	private String nama_mahasiswa;
	private String waktu_mulai;
	private String waktu_selesai;
	private String tanggal_mulai;
	private String tanggal_selesai;
	private String tujuan;
	private String keterangan;
	private int jumlah_peserta;
	private String fasilitas;
	private String is_disetujui;
	private String disetujui_oleh;
}
