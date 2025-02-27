# ⚡ **DataForge** ⚡
DataForge adalah pustaka Java untuk menghasilkan data dalam format CSV dengan performa tinggi.

### ✨ Fitur
* Pembangkitan CSV Super Cepat.
* Support CSV custom template.
* Generator Nama dan Alamat acak aalam bahasa Indonesia.

### 🚀 Instalasi
* Clone dan Build Repository
```sh
git clone https://github.com/yahya6789/dataforge.git
cd dataforge
mvn clean package
```

### 📚 Penggunaan
* Jalankan dengan CLI
Gunakan `java -jar` untuk menjalankan **DataForge** dari terminal:
```sh
java -jar target/dataforge.jar
```

* Opsi yang tersedia:

| Parameter       | Deskripsi                    | Default      |
| --------------- | ---------------------------- | ------------ |
| `-f, --file`    | Nama file output CSV         | `output.csv` |
| `-n, --numRows` | Jumlah baris yang dihasilkan | `10`         |
| `-h, --help`    | Menampilkan bantuan          |              |

* Contoh Kode Penggunaan dalam Java:
```java
CsvTemplate csvTemplate = new SalesCsvTemplate();
csvTemplate.generate(10, System.out); // Menulis 10 baris ke console
```

### ⏱️ Benchmark
Hasil pengujian terbaru:
- 50 juta baris dalam 00:01:50.988

Pengujian menggunakan StopWatch dari Apache Commons Lang untuk mengukur durasi proses.

### 📜 Lisensi
Proyek ini dirilis di bawah lisensi MIT. Lihat file `LICENSE` untuk detail lebih lanjut.

---

Dikembangkan dengan ❤️ oleh [yahya6789](https://github.com/yahya6789).
