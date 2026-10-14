package toros;

public class Karekter {
    private final String ad;
    private int seviye;
    private int can;
    private final Lonca lonca;
    private Silah silah;

    public Karekter(String ad, int seviye, Lonca lonca) {
        if (ad == null || ad.trim().isEmpty() || ad.length() < 3 || ad.length() > 15) {
            throw new IllegalArgumentException("Karakter adı 3 ile 15 karakter arasında olmalıdır.");
        }
        if (seviye < 1 || seviye > 50) {
            throw new IllegalArgumentException("Seviye 1 ile 50 arasında olmalıdır.");
        }
        if (lonca == null) {
            throw new IllegalArgumentException("Lonca null olamaz.");
        }

        this.ad = ad;
        this.seviye = seviye;
        this.lonca = lonca;
        this.can = azamiCan();
    }
    public final int azamiCan() {
        return 100 + seviye * 10;
    }
    public final boolean hayattaMi() {
        return can > 0;
    }
    protected final void hayattaOldugunuDogrula() {
        if (!hayattaMi()) {
            throw new IllegalStateException("Karakter hayatta değil.");
        }
    }
    protected void kayitYaz(String olay) {
        System.out.println("[" + ad + "] " + olay);
    }
    public void hasarAl(int miktar) {
        if (miktar <= 0) {
            throw new IllegalArgumentException("Miktar pozitif olmalıdır.");
        }
        can = Math.max(0, can - miktar);
    }
    public void iyiles(int miktar) {
        if (miktar <= 0) {
            throw new IllegalArgumentException("Miktar pozitif olmalıdır.");
        }
        hayattaOldugunuDogrula();
        can = Math.min(azamiCan(), can + miktar);
    }
    public void seviyeAtla() {
        if (seviye >= 50) {
            throw new IllegalStateException("Seviye 50'ye ulaşmış karakter daha fazla seviye atlayamaz.");
        }
        seviye++;
        can = azamiCan();
    }
    public void silahKusan(Silah yeniSilah) {
        if (yeniSilah == null) {
            throw new IllegalArgumentException("Silah null olamaz.");
        }
        silah = yeniSilah;
    }
    public int saldir() {
        hayattaOldugunuDogrula();
        if (silah == null) {
            return 5 + seviye;
        }
        return silah.kullan() * seviye;
    }
    public String bilgiGoster() {
        String loncaAdi = lonca.getAd();
        String silahAdi = silah == null ? "yok" : silah.getAd();
        return ad + " | Seviye " + seviye + " | Can " + can + "/" + azamiCan()
                + " | Lonca: " + loncaAdi + " | Silah: " + silahAdi;
    }

    @Override
    public String toString() {
        return "Karakter[" + ad + ", seviye " + seviye + "]";
    }
}
