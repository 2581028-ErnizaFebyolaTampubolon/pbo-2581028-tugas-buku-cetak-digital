// Class penjalan program (berisi main). Data sudah ditentukan langsung di kode, tanpa Scanner.
public class TokoBuku {

    // main = titik awal program dijalankan
    public static void main(String[] args) {

        // Membuat ketiga buku
        BukuCetak buku1 = new BukuCetak("Pemrograman Java", "John Doe", 120_000, 750);   // cetak, 750 gram
        BukuCetak buku2 = new BukuCetak("Algoritma Dasar", "Jane Smith", 95_000, 400);   // cetak, 400 gram
        BukuDigital buku3 = new BukuDigital("Belajar OOP", "Ani Wijaya", 80_000, 12.5);  // digital, 12.5 MB

        System.out.println("=============== KERANJANG ===============");

        // Menampilkan semua buku. Masing-masing memanggil tampilkanInfo() versi class-nya sendiri (override).
        buku1.tampilkanInfo();
        buku2.tampilkanInfo();
        buku3.tampilkanInfo();

        System.out.println("-----------------------------------------");

        // Total bayar = jumlah hargaAkhir() ketiga buku
        // 130.000 + 100.000 + 64.000 = 294.000
        int total = buku1.hargaAkhir() + buku2.hargaAkhir() + buku3.hargaAkhir();
        System.out.println("Total bayar   : " + Buku.formatRupiah(total));

        // Uji error (ketentuan no. 8): baris super(...) di constructor BukuDigital dihapus sementara.
        // Pesan error:
        // java: constructor Buku in class Buku cannot be applied to given types;
        //   required: String,String,int
        //   found:    no arguments
        //   reason: actual and formal argument lists differ in length
        // Artinya: kalau super(...) tidak ditulis, Java otomatis memanggil super() tanpa parameter,
        // padahal Buku hanya punya constructor tiga parameter. Jadi super(...) WAJIB ditulis.
    }
}