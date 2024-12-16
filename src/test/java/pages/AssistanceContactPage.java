package pages;

public class AssistanceContactPage {
    private String tema;
    private String prenumeNume;
    private String email;
    private long phone;
    private int numarComanda;
    private String mesaj;

    public AssistanceContactPage(String tema, String prenumeNume, String email, long phone, int numarComanda, String mesaj) {
        this.tema = tema;
        this.prenumeNume = prenumeNume;
        this.email = email;
        this.phone = phone;
        this.numarComanda = Integer.parseInt(String.valueOf(numarComanda));
        this.mesaj = mesaj;
    }

    public String getTema() { return tema; }
    public String getPrenumeNume() { return prenumeNume; }
    public String getEmail() { return email; }
    public long getPhone() { return phone; }
    public int getnumarComanda() { return numarComanda; }
    public String getMesaj() { return mesaj; }

    @Override
    public String toString() {
        return "AssistanceContactPage{" +
                "tema='" + tema + '\'' +
                ", prenumeNume='" + prenumeNume + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", numarComanda=" + numarComanda +
                ", mesaj='" + mesaj + '\'' +
                '}';
    }


}
