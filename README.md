# ⚡ **DataForge** ⚡
DataForge adalah pustaka Java untuk menghasilkan data dalam format CSV dengan performa tinggi.

### ✨ Fitur
* Pembangkitan CSV Super Cepat.
* Support CSV custom template.
* Generator Nama dan Alamat acak dalam bahasa Indonesia.

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

* Contoh Data CSV
```csv
104.17|982|Asraf Jovan|Jl. Tanjung Harapan No.106
213.13|451|Taka Gibran|Jl. Banyu Biru No.36
753.10|538|Tarmizi Pradipta|Jl. Kenanga Indah No.97
782.20|662|Fadhil Jauhar|Jl. Angkasa Permai No.58
836.99|617|Pradipta Gantari|Jl. Harmoni Asri No.134
850.08|363|Dion Eko|Jl. Tidar Permai No.198
150.50|797|Wasesa Dhafin|Jl. Gerbang Surya No.135
383.66|223|Samuel Dicky|Jl. Istana Jaya No.112
612.08|762|Zayyan Ezra|Jl. Citra Harmoni No.48
319.65|347|Jauhari Khulaifi|Jl. Rajawali Sejahtera No.5
5005.56|5742||
```

### ⏱️ Benchmark
Hasil pengujian terbaru:
- **50 juta baris (2,4 GB) CSV** dihasilkan dalam **~2 menit**

Pengujian menggunakan StopWatch dari Apache Commons Lang untuk mengukur durasi proses.

### 📜 Lisensi
Proyek ini dirilis di bawah lisensi MIT. Lihat file `LICENSE` untuk detail lebih lanjut.

---

Dikembangkan dengan ❤️ oleh [yahya6789](https://github.com/yahya6789).
