package toros;

public class Lonca {
    private final String ad;
    private final int kurulusYili;
    private String duyuru;

    public Lonca(String ad, int kurulusYili, String duyuru) {
        if (ad == null || ad.length() < 3 || ad.length() > 25) {
            throw new IllegalArgumentException("Lonca adı 3 ile 25 karakter arasında olmalıdır.");
        }
        if (kurulusYili <= 0) {
            throw new IllegalArgumentException("Kuruluş yılı pozitif olmalıdır.");
        }

        this.ad = ad;
        this.kurulusYili = kurulusYili;
        this.duyuru = duyuruyuDogrula(duyuru);
    }
    private String duyuruyuDogrula(String duyuru) {
        if (duyuru == null || duyuru.trim().isEmpty() || duyuru.length() > 100) {
            throw new IllegalArgumentException("Duyuru boş olamaz ve en fazla 100 karakter olmalıdır.");
        }
        return duyuru;
    }
    public String getAd() {
        return ad;
    }
    public int getKurulusYili() {
        return kurulusYili;
    }
    public String getDuyuru() {
        return duyuru;
    }
    public void setDuyuru(String duyuru) {
        this.duyuru = duyuruyuDogrula(duyuru);
    }
    public String bilgiMetni() {
        return ad + " (kuruluş " + kurulusYili + ") - Duyuru: " + duyuru;
    }
}
