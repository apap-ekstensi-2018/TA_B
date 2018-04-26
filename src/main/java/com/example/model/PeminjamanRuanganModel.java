package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeminjamanRuanganModel {
	
	private int id;
	private int id_ruang;
	private int id_mahasiswa;
	private String waktu_mulai;
	private String waktu_selesai;
	private String tanggal_mulai;
	private String tanggal_selesai;
	private String tujuan;
	private String keterangan;
	private int jumlah_peserta;
	private String fasilitas;
	private String is_disetujui;
	private int disetujui_oleh;

}
