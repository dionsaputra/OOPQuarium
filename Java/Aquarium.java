import java.lang.*;
import java.util.*;
public class Aquarium{
    private LinkedList<ObjekMati> List_Objek_Mati;
    private LinkedList<Fish> List_Ikan;
    private LinkedList<Pet> List_Pet;
    private int time;
    private final int LENGTH;
    private final int WIDTH;
    public Aquarium(){
        LENGTH = 100;
        WIDTH = 100;
    }
    public Aquarium(int length, int width){
        LENGTH = length;
        WIDTH = width;
    }
    public Aquarium(int length, int width, LinkedList<ObjekMati> ListObjekMati, LinkedList<Fish> ListIkan, LinkedList<Pet> ListPet){
        LENGTH = length;
        WIDTH = width;
        List_Objek_Mati = ListObjekMati;
        List_Ikan = ListIkan;
        List_Pet = ListPet;
    }
    public void AddObject(Fish fish){
        List_Ikan.add(fish);
    }
    public void AddObject(ObjekMati objekMati){
        List_Objek_Mati.add(objekMati);
    }
    public void AddObject(Pet pet){
        List_Pet.add(pet);
    }
    public void RemoveObject(Fish fish){
        List_Ikan.remove(fish);
    }
    public void RemoveObject(ObjekMati objekMati){
        List_Objek_Mati.remove(objekMati);
    }
    public void RemoveObject(Pet pet){
        List_Objek_Mati.remove(pet);
    }
    public void Action(){
        Random rand = new Random();
        for(int i=0;i<List_Ikan.totalElmt();i++){
            Fish temp = List_Ikan.get(i);
            if(temp.getStarving()<=0){
                RemoveObject(List_Ikan.get(i));
            }
            else{
                int count=0,countguppy=0;
                for(int j=0;j<List_Objek_Mati.totalElmt();j++){
                    if(List_Objek_Mati.get(j).getJenis()=="Makanan Ikan"){
                        count++;
                    }
                }
                for(int j=0;j<List_Ikan.totalElmt();j++){
                    if(List_Ikan.get(j).getJenis()=="Guppy"){
                        countguppy++;
                    }
                }
                if(temp.getJenis()=="Guppy"){
                    if(temp.getStarvationPeriod() > 0 || count==0){
                        temp.setStarvationPeriod(temp.getStarvationPeriod()-1);
                        if(temp.getMoveTime()<=0){
                            //srand(time(NULL));
                            int randoms = (rand.nextInt(40) % 40);
                            int directions = (rand.nextInt(4)%2);
                            if(directions >=1){
                                randoms*=-1;
                            }
                            temp.setDegree((temp.getDegree()+randoms)%360);
                            temp.setMoveTime(temp.getMAXMOVE());
                        }
                        temp.swim(temp.setDegree(),temp.getSpeed());
                        temp.setStarving(temp.getStarving()-1);
                    }
                    else{
                        temp.eat(this);
                    }
                }
                else{
                    if(temp.getStarvationPeriod() > 0 || countguppy==0){
                        temp.setStarvationPeriod(temp.getStarvationPeriod()-1);
                        if(temp.getMoveTime()<=0){
                            //srand(time(NULL));
                            int randoms = (rand.nextInt(360) % 360);

                            int directions = (rand.nextInt(4)%2);
                            if(directions != 0){
                                randoms*=-1;
                            }
                            temp.setDegree((temp.getDegree()+randoms)%360);
                            temp.setMoveTime(temp.getMAXMOVE());
                        }
                        temp.swim(temp.getDegree(),temp.getSpeed());
                        temp.setStarving(temp.getStarving()-1);
                    }
                    else{
                        temp.eat(this);
                    }
                }
                temp.setMoveTime(temp.getMoveTime()-1);

                //produce
                if(temp.getJenis() == "Guppy"){
                    if(temp.getProduceTime() < 0){
                        temp.produce(this);
                        temp.setProduceTime(temp.getMaxProduceTime());
                    }
                    //cout<<temp->getProduceTime()<<" ampun\n";
                    temp.setProduceTime(temp.getProduceTime()-1);
                }
            }
        }
        for(int i=0;i<List_Pet.totalElmt();i++){
            List_Pet.get(i).eat(this);
            //cout<<"EAT TELAH DIJALANKAN\n";
        }
        for(int i=0;i<List_Objek_Mati.totalElmt();i++){
            List_Objek_Mati.get(i).turun(this);
        }
    }

    public int IsEdge(Point P, double radius){
        if(Math.abs(P.getOrdinat() - WIDTH) < radius){
            return 2;
        }
        else if(P.getOrdinat() < radius){
            return 4;
        }
        else if(Math.abs(P.getAbsis() - LENGTH) < radius){
            return 1;
        }
        else if(P.getAbsis() < radius){
            return 3;
        }
        else{
            return 0;
        }
    }
    public LinkedList<ObjekMati> getListObjekMati(){return List_Objek_Mati;}
    public LinkedList<Fish> getListIkan(){return List_Ikan;}
    public LinkedList<Pet> getListPet(){return List_Pet;}
    public int getLength(){return LENGTH;}
    public int getWidth(){return WIDTH;}
    public int getTime(){return time;}

}
