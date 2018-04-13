public class Pet{
    private static int counter = 0;
    private boolean face;
    private int id;
    private int kecepatan;
    private int radius;
    private int totalMoney;
    private Point posisi;

    public Pet(int _kecepatan, int _radius, Point _posisi){
        face = true;
        id = counter++;
        kecepatan = _kecepatan;
        radius = _radius;
        totalMoney = 0;
        posisi = _posisi;
    }

    public getId(){
        return id;
    }

    public boolean getFace(){
        return face;
    }

    public void setFace(boolean _face){
        face = _face;
    }

    public int getRadius(){
        return radius;
    }

    public void setRadius(_radius){
        radius = _radius;
    }

    public int getTotalMoney(){
        return totalMoney;
    }

    public void setTotalMoney(int _totalMoney){
        totalMoney = _totalMoney;
    }

    public Point getPosisi(){
        return posisi;
    }

    public void setPosisi(_posisi){
        posisi = _posisi;
    }

    public void WalkTo(Point goal){
        int dx = kecepatan;
        if (goal.getAbsis() < posisi.getAbsis()) {
            face = false;
            dx = -1 * dx;
        } else if (goal.getAbsis() == posisi.getAbsis()) {
            dx = 0;
        } else {
            face = true;
        }
        Point point = this.getPosisi();
        point.setAbsis(point.getAbsis() + dx);
        this.setPosisi(point);
    }

    public void eat(Aquarium aquarium){
        boolean existCoin = false;
        int i = 0;
        while (i < aquarium.getListObjekMati().totalElmt() && !existCoin){
            if (aquarium.getListObjekMati().get(i).getJenis() == "Koin"){
                existCoin = true;
            } else {
                i++;
            }
        }

        if (existCoin) {
            int i = 0;
            boolean existCoinOnGround = false;
            while (i < aquarium.getListObjekMati().totalElmt() && !existCoinOnGround) {
                boolean isKoin = aquarium.getListObjekMati().get(i).getJenis() == "Koin";
                boolean isDasar = aquarium.getListObjekMati().get(i).isDasar(aquarium);
                if (isKoin && isDasar) {
                    existCoinOnGround = true;
                } else {
                    i++;
                }
            }

            if (existCoinOnGround) {
                double nearestHorizontally = aquarium.getWidth() + 1000000;
                int idx;
                for (idx = 0; idx < aquarium.getListObjekMati().totalElmt(); idx++) {
                    boolean isKoin = aquarium.getListObjekMati().get(idx).getJenis() == "Koin";
                    boolean isDasar = aquarium.getListObjekMati().get(idx).isDasar(aquarium);
                    boolean isLower = getPosisi().hitungJarak(aquarium.getListObjekMati.get(idx).getPosisi()) < nearestHorizontally;
                    if (isKoin && isDasar && isLower) {
                        nearestHorizontally = getPosisi().hitungJarak(aquarium.getListObjekMati().get(idx).getPosisi());
                        break;
                    }
                }

                if (radius >= nearestHorizontally) {
                    Koin koin = (Koin) aquarium.getListObjekMati().get(idx);
                    setTotalMoney(getTotalMoney() + koin.getNilaiKoin());
                    aquarium.RemoveObject(aquarium.getListObjekMati().get(idx));
                } else {
                    Point goal = new Point(aquarium.getListObjekMati().get(idx).getPosisi().getAbsis(),aquarium.getLength());
                    WalkTo(goal);
                }
            } else {
                double nearestVertically = aquarium.getLength() + 1000000;
                int idx;
                for (idx = 0; i<aquarium.getListObjekMati().totalElmt(); i++) {
                    boolean isKoin = aquarium.getListObjekMati().get(idx).getJenis() == "Koin";
                    boolean isLower = aquarium.getLength() - aquarium.getListObjekMati.get(idx).getPosisi().getOrdinat() < nearestVertically;
                    if (isKoin && isLower) {
                        nearestVertically = aquarium.getLength() - aquarium.getListObjekMati.get(idx).getPosisi().getOrdinat();
                        break;
                    }
                }

                if (radius >= nearestVertically) {
                    Koin koin = (Koin) aquarium.getListObjekMati().get(idx);
                    setTotalMoney(getTotalMoney() + koin.getNilaiKoin());
                    aquarium.RemoveObject(aquarium.getListObjekMati().get(idx));
                } else {
                    Point goal = new Point(aquarium.getListObjekMati().get(idx).getPosisi().getAbsis(), aquarium.getLength());
                    WalkTo(goal);
                }
            }
        }
    }
}
