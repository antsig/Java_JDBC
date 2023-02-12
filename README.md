# CRUD Menggunakan Java dan MySQL JDBC (Text-based)
# Apache Netbeans IDE 13 dan MySQL Connector-J 8


Membuat Database mahasiswa dengan PhpMyAdmin 
1.	Aktifkan  modul Apache dan MySQL dari XAMPP Control Panel
2.	Buka http://localhost/phpmyadmin/ 
3.	Buat database baru dengan nama java_jdbc
4.	Import database yang saya sertakan sebagai contoh (sudah ada 1 data)

Project ini menggunakan package java dengan nama jdbc_uas. Sebelum menuliskan kode selanjutnya, import class dan interface yang akan kita gunakan. Kita menggunakan java.sql.* (turunan java.sql)

JDBC_DRIVER digunakan untuk memanggil driver JDBC. Masing-masing database memiliki driver yang berbeda. (kita pakai MySQL JDBC)
DB_URL digunakan untuk memanggil URL server database yang akan dipakai, diikuti USER dan PASS yang harus disesuaikan dengan username dan password yang digunakan di database server. Username default untuk PhpMyAdmin adalah “root”. Apabila password di server tidak di setting, maka cukup kosongkan saja nilai pada string PASS. 

Selanjutnya perlu persiapkan beberapa parameter yaitu Connection, Statement dan ResultSet untuk menampung object yang akan kita buat.
Tentukan driver terlebih dahulu sebelum membuat koneksi ke server. Untuk driver MySQL terbaru kita gunakan “com.mysql.cj.jdbc.Driver”. Kemudian lakukan koneksi ke database dengan parameter yang sudah dibuat. Jika koneksi gagal, akan terjadi SQLException.

Kita buat object statement (stmt) untuk mengeksekusi Query MySQL. Kemudian buat sebuah query. 
Hasil eksekusi query akan tersimpan dalam object rs. Method executeQuery() akan mengambil data dari database dan mengembalikan nilai berupa ResultSet.

Buat perulangan while untuk menampilkan data dari MySQL dengan mengambil nilai dari object rs. 
close() digunakan untuk menutup statement dan koneksi supaya aman.

Class BuffereReader dan InputstreamReader kita panggil untuk bisa mengambil inputan dari keyboard.

Method main() merupakan pusat dari sebuah program yang di dalamnya akan kita lakukan perulangan selama terkoneksi dengan database. Perulangan akan berhenti setelah user memilih 0 (keluar) dari menu interface text. 

Di dalam method showMenu() terdapat perulangan menggunakan logika percabangan switch/case untuk pemilihan menu.

Method showData() hanya berfungsi untuk menampilkan data hasil pemanggilan dari database. Untuk memudahkan penggabungan string, bisa kita gunakan fungsi String.format(). 

Dalam method inserMhs() kita memakai execute() untuk melakukan query simpan data ke database yang mengembalikan nilai boolean: true bila query berhasil dan false bila gagal.

Dalam method updateMhs() dan deleteMhs() kita juga memakai execute() untuk melakukan query simpan data dan hapus data di database yang akan mengembalikan nilai boolean: true bila query berhasil dan false bila gagal.


