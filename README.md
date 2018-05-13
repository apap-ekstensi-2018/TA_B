# SIRUANG - Sistem Informasi Ruangan

	Dalam melaksanakan aktivitasnya sebagai institusi pendidikan, Fakultas Ilmu
Komputer memiliki berbagai macam ruangan yang dapat digunakan. Mulai dari ruang kelas, ruang pertemuan, lab, hingga aula. Ruangan-ruangan ini digunakan sebagai tempat agar kegiatan pembelajaran oleh dosen berlangsung. Maka dari itu, Fakultas Ilmu Komputer membutuhkan sebuah Sistem Informasi Ruangan atau dapat disingkat SIRUANG. SIRUANG diharapkan dapat membantu mahasiswa dalam proses peminjaman ruangan. Mulai dari mengajukan peminjaman hingga penyetujuan ruangan. Selain itu, SIRUANG diharapkan dapat membantu pegawai fakultas dalam mengelola peminjaman ruangan secara lebih efektif dan efisien.

## Base URL

```
https://kelompok-b.herokuapp.com/
```

## API List


- [/ruang/view/[id_ruang]](#ruang-view-id_ruang)


### api/ruang/view/[id_ruang]

Mengembalikan object ruangan berdasarkan id ruang. Object dalam bentuk JSON.

**URL** : `http://kelompok-b.herokuapp.com/api/ruang/view/{id_ruang}`
**Method** : `GET`


### Response

**Contoh Request** : [/ruang/view/1](http://kelompok-b.herokuapp.com/api/ruang/view/1)

```
{
"id":1,
"nama":"Eagle, pallas's fish",
"kapasitas":6
}
```

#Team

* Budi Indrawan (1606954754)
* Poppy Rosaline (1606954956)
* Riandani Gita L (1606954981)
* Selina Octavia (1606955025)
* Shafa Maharani P (1606955031)
* Shinta Kusuma W (1606955044)

