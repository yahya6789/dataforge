# DataForge 🚀

DataForge adalah pustaka Java untuk menghasilkan data secara otomatis dengan kinerja tinggi. Proyek ini dirancang untuk menangani pembuatan data dalam jumlah besar, termasuk pembuatan nama acak dalam bahasa Indonesia dan generator CSV yang efisien.

## ✨ Fitur
- **📝 Generator Nama Acak**: Menghasilkan nama acak dari dataset yang dimuat ke dalam memori.
- **📄 Generator CSV**: Membuat file CSV dengan jutaan baris secara efisien tanpa menyimpan seluruh data dalam memori.
- **⚡ Dukungan Multi-Threading**: Mengoptimalkan performa dalam lingkungan multi-threaded.
- **📊 Logging dengan SLF4J**: Menyediakan logging yang fleksibel dan dapat dikonfigurasi.

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

### 2. 📑 Menulis CSV secara Efisien
```java
BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()));
CsvTemplate salesCsv = new SalesCsvTemplate(1_000_000);  // Menghasilkan 1 juta baris data
salesCsv.generate(writer);
```

## 📜 Lisensi
Proyek ini dirilis di bawah lisensi MIT. Lihat file `LICENSE` untuk detail lebih lanjut.

---
Dikembangkan dengan ❤️ oleh [yahya6789](https://github.com/yahya6789).
