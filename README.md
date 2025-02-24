# DataForge 🚀

DataForge adalah pustaka Java untuk menghasilkan data secara otomatis dengan kinerja tinggi. Proyek ini dirancang untuk menangani pembuatan data dalam jumlah besar, termasuk pembuatan nama acak dalam bahasa Indonesia dan generator CSV yang efisien.

## ✨ Fitur
- **📝 Generator Teks dan Angka**: Menghasilkan teks atau angka acak.
- **📝 Generator Nama Acak**: Menghasilkan nama lengkap acak dalam bahasa Indonesia.
- **📝 Generator Alamat Acak**: Menghasilkan alamat acak dalam bahasa Indonesia.
- **📄 Generator CSV**: Membuat file CSV dengan ratusan juta baris secara efisien.
- **⚡ Dukungan Multi-Threading**: Mengoptimalkan performa dalam lingkungan multi-threaded.

## 📥 Instalasi
Tambahkan dependensi berikut ke proyek Anda jika menggunakan Maven:

```xml
<dependency>
    <groupId>io.github.yahya6789</groupId>
    <artifactId>dataforge</artifactId>
    <version>1.0.0</version>
</dependency>
```

## 🚀 Penggunaan
### 1. 🏷️ Menggunakan Generator Nama Acak
```java
RandomNameGenerator randomName = new RandomNameGenerator();
String name = randomName.generate();
System.out.println(name);
```

### 2. 🏷️ Menggunakan System.out sebagai Output
```java
CsvTemplate salesCsv = new SalesCsvTemplate(10);
salesCsv.generate(new OutputStreamWriter(System.out));
```
#### Contoh Output
```bash
627.25|150|Ramdhan Danendra|Jl .Gading Jaya No.31
290.29|761|Rifzan Bram|Jl .Damai Mandiri No.92
925.10|113|Omar Arselan|Jl .Karunia Lestari No.40
484.60|572|Fikran Aryad|Jl .Gading Makmur No.62
240.44|406|Radika Amier|Jl .Manggis Manis No.75
661.91|249|Tirta Bilqis|Jl .Alam Raya No.15
912.27|434|Perdana Hilmi|Jl .Anyelir Permai No.88
541.53|837|Reyhan Haykal|Jl .Gambir Makmur No.153
166.06|556|Ashrul Alghifari|Jl .Kencana Jaya No.167
712.11|717|Arthesa Darupono|Jl .Baruna Perkasa No.3
5561.56|4795||
```

### 3. 📑 Menulis CSV secara Efisien
```java
BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()));
CsvTemplate salesCsv = new SalesCsvTemplate(1_000_000);  // Menghasilkan 1 juta baris data
salesCsv.generate(writer);
```

## 📜 Lisensi
Proyek ini dirilis di bawah lisensi MIT. Lihat file `LICENSE` untuk detail lebih lanjut.

---
Dikembangkan dengan ❤️ oleh [yahya6789](https://github.com/yahya6789).
