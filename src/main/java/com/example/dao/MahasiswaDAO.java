package com.example.dao;

import com.example.model.MahasiswaModel;

public interface MahasiswaDAO {
	
	MahasiswaModel selectMahasiswaById(int id_mahasiswa);
	
	MahasiswaModel selectMahasiswaByNpm(int npm);

}
