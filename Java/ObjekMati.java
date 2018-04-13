public class ObjekMati{
    private static int counter = 0;
    private final int id;
    private int kecepatan;
    private Point posisi;
    private String jenis;

    public ObjekMati(int _kecepatan){
        id = counter++;
        kecepatan = _kecepatan;
        posisi = new Point();
        jenis = null;
    }

    public int getId(){
        return id;
    }

    public int getKecepatan(){
        return kecepatan;
    }

    public void setKecepatan(int _kecepatan){
        kecepatan = _kecepatan;
    }

    public String getJenis(){
        return jenis;
    }

    public void setJenis(String _jenis){
        jenis = _jenis;
    }

    public Point getPosisi(){
        return posisi;
    }

    public void setPosisi(Point _posisi){
        posisi = _posisi;
    }

    public boolean isDasar(Aquarium _aquarium){
        return this.getPosisi().getOrdinat() >= _aquarium.getLength();
    }

    public void(Aquarium _aquarium){
        if (!isDasar(_aquarium)) {
            Point point = this.getPosisi();
            point.setOrdinat(this.getPosisi().getOrdinat() + this.getKecepatan());
            this.setPosisi(point);
        } else {
            if (this.getJenis() == "Makanan Ikan") {
                _aquarium.RemoveObject(this);
            }
        }
    }
}
