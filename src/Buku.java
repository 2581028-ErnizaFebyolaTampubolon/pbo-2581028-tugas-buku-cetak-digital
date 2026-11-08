public class Buku {

    // Semua field private: hanya class Buku yang boleh membaca/mengubah langsung.
    // Subclass TIDAK bisa menyentuh "harga" secara langsung, harus lewat hargaAkhir().
    private String judul;
    private String penulis;
    private int harga;

    // Constructor tiga parameter: mengisi data awal buku.
    public Buku(String judul, String penulis, int harga) {
        this.judul = judul;        // this.judul = field, judul = parameter
        this.penulis = penulis;
        this.harga = harga;
    }

    // Mengembalikan harga akhir. Untuk Buku biasa, harga akhir = harga dasar.
    // Subclass akan meng-override method ini dengan aturan masing-masing.
    public int hargaAkhir() {
        return harga;
    }

    // Mencetak DUA baris pertama setiap buku:
    // Pemrograman Java (John Doe)
    //   Harga       : Rp120.000
    // Baris sisanya (berat/ukuran, ongkir, harga akhir) dicetak oleh subclass.
    public void tampilkanInfo() {
        System.out.println(judul + " (" + penulis + ")");
        // %-11s = teks rata kiri selebar 11 karakter, supaya tanda ":" sejajar
        System.out.printf("  %-11s : %s%n", "Harga", formatRupiah(harga));
    }

    // Mengubah angka jadi format rupiah, mis. 120000 -> "Rp120.000".
    // protected = bisa dipakai subclass; static = dipanggil lewat nama class (Buku.formatRupiah).
    protected static String formatRupiah(int angka) {
        // %,d memberi pemisah ribuan (koma), lalu koma diganti titik
        return "Rp" + String.format("%,d", angka).replace(',', '.');
    }
}