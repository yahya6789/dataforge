# **DataForge** 🚀

**DataForge** adalah pustaka Java untuk menghasilkan data dalam format **CSV** dengan performa tinggi.

## **✨ Fitur**

✅ **Generasi CSV Cepat** – Mampu menghasilkan **50 juta baris dalam ~1.5 menit** 

✅ **CLI Support** – Gunakan parameter baris perintah untuk mengontrol output

## **🚀 Instalasi**

### **1️⃣ Clone Repository**

```sh
git clone https://github.com/yahya6789/dataforge.git
cd dataforge
mvn clean package
```

## **📌 Cara Penggunaan**

### **1️⃣ Jalankan dengan CLI**

Gunakan `java -jar` untuk menjalankan **DataForge** dari terminal:

```sh
java -jar target/dataforge.jar -f output.csv -n 100
```

**Opsi yang tersedia:**

| Parameter       | Deskripsi                    | Default      |
| --------------- | ---------------------------- | ------------ |
| `-f, --file`    | Nama file output CSV         | `output.csv` |
| `-n, --numRows` | Jumlah baris yang dihasilkan | `10`         |
| `-h, --help`    | Menampilkan bantuan          |              |

### **2️⃣ Contoh Kode Penggunaan dalam Java**

```java
CsvTemplate csvTemplate = new CsvTemplate();
csvTemplate.generateCsv("data.csv", 5000000);
```

## **⏱️ Benchmark**

**Hasil pengujian terbaru:**

- **50 juta baris dalam 00:01:50.988**

Metode pengujian menggunakan StopWatch dari Apache Commons Lang untuk mengukur durasi proses.

#### 📜 Lisensi

Proyek ini dirilis di bawah lisensi MIT. Lihat file `LICENSE` untuk detail lebih lanjut.

---

Dikembangkan dengan ❤️ oleh [yahya6789](https://github.com/yahya6789).
