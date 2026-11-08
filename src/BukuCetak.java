// BukuCetak, TURUNAN dari Buku
// Tambahannya: punya berat, dan harga akhirnya ditambah ongkir.
public class BukuCetak extends Buku {

    // Field khusus buku cetak
    private int beratGram;    // berat buku dalam gram

    // Constructor: data umum diserahkan ke constructor Buku lewat super(...)
    public BukuCetak(String judul, String penulis, int harga, int beratGram) {
        super(judul, penulis, harga);    // wajib baris pertama: isi judul, penulis, harga milik Buku
        this.beratGram = beratGram;      // isi data khusus BukuCetak
    }

    // Menghitung ongkir: Rp5.000 per 500 gram, sisa gram dibulatkan ke atas.
    // Contoh: 750 gram -> 2 x 5.000 = 10.000 ; 400 gram -> 1 x 5.000 = 5.000
    public int hitungOngkir() {
        int jumlahKelipatan = (beratGram + 499) / 500;   // trik pembulatan ke atas untuk pembagian int
        return jumlahKelipatan * 5000;
    }

    // OVERRIDE hargaAkhir(): harga dari Buku DITAMBAH ongkir.
    // Tidak menyentuh field harga langsung (private), tapi lewat super.hargaAkhir().
    @Override
    public int hargaAkhir() {
        return super.hargaAkhir() + hitungOngkir();
    }

    // OVERRIDE tampilkanInfo(): cetak dua baris milik Buku dulu, lalu bagian khas buku cetak.
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();    // judul (penulis) + Harga
        System.out.printf("  %-11s : %d gram%n", "Berat", beratGram);
        System.out.printf("  %-11s : %s%n", "Ongkir", formatRupiah(hitungOngkir()));
        System.out.printf("  %-11s : %s%n", "Harga akhir", formatRupiah(hargaAkhir()));
    }
}