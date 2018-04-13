public class Koin extends ObjekMati{
    private final int kecepatanKoin = 1;
    private int nilaiKoin;

    public Koin(int _nilaiKoin, Point _posisi){
        super(kecepatanKoin);
        nilaiKoin = _nilaiKoin;
        jenis = "Koin";
        posisi = _posisi;
    }

    public int getNilaiKoin(){
        return nilaiKoin;
    }

    public void setNilaiKoin(int _nilaiKoin){
        nilaiKoin = _nilaiKoin;
    }
}
