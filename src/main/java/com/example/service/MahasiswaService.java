package com.example.service;

import com.example.model.MahasiswaModel;

public interface MahasiswaService {
	
	MahasiswaModel selectMahasiswaById(int id_mahasiswa);
	
	MahasiswaModel selectMahasiswaByNpm(String npm);
	
}
