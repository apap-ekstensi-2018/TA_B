package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeminjamanRuanganModel {
	
	private int id;
	private int idRuang;
	private int idMahasiswa;
	private String waktuMulai;
	private String waktuSelesai;
	private String tanggalMulai;
	private String tanggalSelesai;
	private String tujuan;
	private String keterangan;
	private int jumlahPeserta;
	private String fasilitas;
	private String isDisetujui;
	private int disetujuiOleh;

}
