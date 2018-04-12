#include "MachineDriverAquarium.hpp"
#include <bits/stdc++.h>
using namespace std;

#define DEBUG_START cout<<"DEBUG_START\n";
#define DEBUG_END   cout<<"DEBUG_END\n";

MachineDriverAquarium::MachineDriverAquarium():Aquarium(933,700){
    egg=1;
    money =1000;
    foodPrice=10;
    eggPrice = 500;
    piranhaPrice = 150;
    guppyPrice = 50;
    winEgg=3;
    coinPrice=10;
    piranhaJenis = "Piranha";

    guppyJenis= "Guppy";
    makananIkanJenis = "Makanan Ikan";
    koinJenis = "Koin";
    srand((unsigned) std::time ( NULL ) );
}


void MachineDriverAquarium::initAll(){

    Fish *ikan1 = new Guppy();
    Point ikan1Position(getWidthBackground()/2,getHeightBackground()/2);
    ikan1->setPosisi(ikan1Position);
    this->AddObject(ikan1);

    Fish *ikan2 = new Guppy();
    Point ikan2Position(200,400);
    ikan2->setPosisi(ikan2Position);
    this->AddObject(ikan2);

    Point siput1Position(800,600);
    Pet *siput1 = new Pet(20,5,siput1Position);
    this->AddObject(siput1);

    ObjekMati* objekMati1 = new MakananIkan(400);
    cout<<objekMati1->getPosisi().getAbsis()<<endl;
    this->AddObject(objekMati1);

    ObjekMati* objekMati2 = new Koin(10,ikan1Position);
    ObjekMati* objekMati3 = new Koin(11,ikan2Position);
    this->AddObject(objekMati2);
    this->AddObject(objekMati3);
}

void MachineDriverAquarium::execute(){

    init();
    bool running = true;
    bool gameStart = false;
    bool win;
    //Fase Gameplay
    while(running){
        handle_input();
        if (quit_pressed()) {
            running = false;
        }
        for (auto key : get_tapped_keys()) {
            switch (key) {
            // x untuk keluar
            case SDLK_x:
                running = false;
                break;
            }
        }
        //Deteksi Mouse

        if(gameStart){
            for (auto key : get_tapped_Mousekeys()) {
                int x = key.x;
                int y = key.y;
                if(isPointInBackground(x,y)){
                    bool isKoinFound=false;
                    for(int i=0;i<List_Objek_Mati.totalElmt();i++){
                        ObjekMati *temp = List_Objek_Mati.get(i);
                        int xpos = temp->getPosisi().getAbsis();
                        int ypos = temp->getPosisi().getOrdinat();
                        if(temp->getJenis()==koinJenis){
                            if(isPointInObject(x,y,xpos,ypos,getWidthCoin(),getHeightCoin())){
                                isKoinFound = true;
                                this->RemoveObject(temp);
                                money+=coinPrice;
                            }
                        }
                    }
                    cout<<"Clicked at "<<"background"<<endl;
                    if(!isKoinFound){
                        ObjekMati *temp =  new MakananIkan();
                        Point pos;
                        pos.setAbsis(x);
                        pos.setOrdinat(y);
                        temp->setPosisi(pos);
                        AddObject(temp);
                    }
                } else if(isPointInEggButton(x,y)){
                    if(money>=eggPrice){
                        egg++;
                        money-=eggPrice;
                        if(egg==winEgg){
                            running=false;
                            win=true;
                        }
                    } else{
                        cout<<"Uang tidak cukup"<<endl;
                    }
                } else if(isPointInFoodButton(x,y)){
                    cout<<"Clicked at "<<"food"<<endl;
                } else if(isPointInGuppyButton(x,y)){
                    if(money>=guppyPrice){
                        Fish *ikan2 = new Guppy();
                        Point ikan2Position(100 + (rand()%(this->getWidthBackground()-200)),100);
                        ikan2->setPosisi(ikan2Position);
                        this->AddObject(ikan2);
                        money-=guppyPrice;
                    } else{
                        cout<<"Uang tidak cukup\n";
                    }

                    cout<<"Clicked at "<<"guppy"<<endl;
                } else if(isPointInPiranhaButton(x,y)){
                    if(money>=piranhaPrice){
                        Fish *ikan2 = new Piranha();
                        Point ikan2Position(100 + (rand()%(this->getWidthBackground()-200)),100);
                        ikan2->setPosisi(ikan2Position);
                        this->AddObject(ikan2);
                        money-=piranhaPrice;
                    } else{
                        cout<<"Uang tidak cukup\n";
                    }
                    cout<<"Clicked at "<<"piranha"<<endl;
                } else if(isPointInSaveButton(x,y)){
                    cout<<"Clicked at "<<"save"<<endl;
                }
            }
            clear_screen();
            drawBackground();

            //Drawing
            for(int i=0;i<this->List_Ikan.totalElmt();i++){
                Fish *temp = List_Ikan.get(i);
                drawIkanAndCheck(temp);
            }

            for(int i=0;i<this->List_Objek_Mati.totalElmt();i++){
                ObjekMati *temp = List_Objek_Mati.get(i);
                if (temp->getJenis() == "Koin"){
                    Koin * temps = (Koin*) temp;
                    if(temps->getNilaiKoin()>50){
                        drawGoldCoin(temp->getPosisi().getAbsis(),temp->getPosisi().getOrdinat());
                    }
                    else{
                        drawSilverCoin(temp->getPosisi().getAbsis(),temp->getPosisi().getOrdinat());
                    }
                    cout<<temps->getNilaiKoin()<<" hehe\n";

                } else {
                    drawFishFood(temp->getPosisi().getAbsis(),temp->getPosisi().getOrdinat());
                }
            }
            for(int i=0;i<this->List_Pet.totalElmt();i++){
                Pet *temp = List_Pet.get(i);
                money += temp->getTotalMoney();
                List_Pet.get(i)->setTotalMoney(0);
                if (temp->getFace()){
                    drawSnailRightDirection(temp->getPosisi().getAbsis(),temp->getPosisi().getOrdinat());
                } else {
                    drawSnailLeftDirection(temp->getPosisi().getAbsis(),temp->getPosisi().getOrdinat());
                }
            }
            this->Action();
            drawGuppyButton();
            drawPiranhaButton();
            drawFoodButton();
            drawFoodPriceText(to_string(foodPrice));
            drawGuppyPriceText(to_string(guppyPrice));
            drawPiranhaPriceText(to_string(piranhaPrice));
            drawEggPriceText(to_string(eggPrice));
            drawMoneyText(to_string(money));
            //drawCursorStatusText("Select appearing guppy position buying");
            drawSaveButton();
            drawEggButton(egg);
            incrementFrameAnimate();
            update_screen();

            if(List_Ikan.totalElmt()==0 && money<guppyPrice){
                running = false;
                win =false;
            }
        } else{
            for (auto key : get_tapped_Mousekeys()) {
                int x = key.x;
                int y = key.y;
                if(isPointInStartButton(x,y)){
                    cout<<"Clicked at "<<"start button"<<endl;
                    gameStart=true;

                    initAll();
                } else if(isPointInLoadButton(x,y)){
                    cout<<"Clicked at "<<"load button"<<endl;
                }
            }
            clear_screen();
            drawStartButton();
            drawLoadButton();
            update_screen();

        }

        std::this_thread::sleep_for(std::chrono::milliseconds(20));
    }



    running=true;
    //Fase Menang atau Kalah
    while(running){
        handle_input();
        if (quit_pressed()) {
            running = false;
        }
        for (auto key : get_tapped_keys()) {
            switch (key) {
            // x untuk keluar
            case SDLK_x:
                running = false;
                break;
            }
        }
        clear_screen();
        drawBackground();
        if(win){
            drawWinAnnouncement();
        } else{
            drawLoseAnnouncement();
        }
        update_screen();
    }


    close();

}



void MachineDriverAquarium::drawIkanAndCheck(Fish * tempIkan){
    Guppy *temp = (Guppy*) tempIkan;
    Point pos = tempIkan->getPosisi();

    int x = pos.getAbsis();
    int y = pos.getOrdinat();
    if(temp->getJenis()==guppyJenis){
        Guppy *temp = (Guppy*) tempIkan;
        if(temp->isFaceRight()){
            //Madep kanan
            drawGuppyRightLv(temp->getGrowthStep(),x,y,temp->isStarving());
        } else{
            //madep kiri
            drawGuppyLeftLv(temp->getGrowthStep(),x,y,temp->isStarving());
        }
    } else{
        Piranha *temp = (Piranha*) tempIkan;
        if(temp->isFaceRight()){
            if(temp->isStarving()){
                drawHungryPiranhaRightDirection(x,y);
            } else{
                drawPiranhaRightDirection(x,y);
            }
        } else{
            if(temp->isStarving()){
                drawHungryPiranhaLeftDirection(x,y);
            } else{
                drawPiranhaLeftDirection(x,y);
            }
        }
    }
}


void MachineDriverAquarium::drawGuppyLeftLv(int level,int x,int y,bool isStarving){
    switch(level){
        case 1:
            if(isStarving){
                drawHungryGuppyLv1LeftDirection(x,y);
            } else{
                drawGuppyLv1LeftDirection(x,y);
            }
            break;
        case 2:
            if(isStarving){
                drawHungryGuppyLv2LeftDirection(x,y);
            } else{
                drawGuppyLv2LeftDirection(x,y);
            }
            break;
        case 3:
            if(isStarving){
                drawHungryGuppyLv3LeftDirection(x,y);
            } else{
                drawGuppyLv3LeftDirection(x,y);
            }
            break;
    }
}
void MachineDriverAquarium::drawGuppyRightLv(int level,int x,int y,bool isStarving){
    switch(level){
        case 1:
            if(isStarving){
                drawHungryGuppyLv1RightDirection(x,y);
            } else{
                drawGuppyLv1RightDirection(x,y);
            }
            break;
        case 2:
            if(isStarving){
                drawHungryGuppyLv2RightDirection(x,y);
            } else{
                drawGuppyLv2RightDirection(x,y);
            }
            break;
        case 3:
            if(isStarving){
                drawHungryGuppyLv3RightDirection(x,y);
            } else{
                drawGuppyLv3RightDirection(x,y);
            }
            break;
    }
}
