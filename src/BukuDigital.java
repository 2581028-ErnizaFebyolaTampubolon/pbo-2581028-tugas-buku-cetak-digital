// BukuDigital, TURUNAN dari Buku (BukuDigital ADALAH sebuah Buku).
// Tambahannya: punya ukuran file, dan harga akhirnya mendapat diskon 20%.
public class BukuDigital extends Buku {

    // Field khusus buku digital
    private double ukuranMB;    // ukuran file dalam MB, mis. 12.5

    // Constructor: data umum diserahkan ke constructor Buku lewat super(...)
    public BukuDigital(String judul, String penulis, int harga, double ukuranMB) {
        super(judul, penulis, harga);    // baris ini yang dihapus sementara untuk uji error (ketentuan no. 8)
        this.ukuranMB = ukuranMB;
    }

    // OVERRIDE hargaAkhir(): harga dari Buku dikali 80 lalu dibagi 100 (= diskon 20%).
    // Dikali dulu baru dibagi, supaya pembagian int tidak membuat hasil jadi 0.
    @Override
    public int hargaAkhir() {
        return super.hargaAkhir() * 80 / 100;
    }

    // OVERRIDE tampilkanInfo(): cetak dua baris milik Buku dulu, lalu bagian khas buku digital.
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();    // judul (penulis) + Harga
        System.out.printf("  %-11s : %s MB%n", "Ukuran", ukuranMB);
        System.out.printf("  %-11s : %s (diskon 20%%)%n", "Harga akhir", formatRupiah(hargaAkhir()));
        // %% = mencetak tanda persen (%) di dalam printf
    }
}