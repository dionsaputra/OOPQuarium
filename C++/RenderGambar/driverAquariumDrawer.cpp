#include "AquariumDrawerController.hpp"

#include <chrono>
#include <thread>
int main(){

    AquariumDrawerController drv;
    
    drv.init();
    cout<<"lol"<<endl;
    bool running = true;

    bool gameStart = false;
    while(running){
        drv.handle_input();
        if (drv.quit_pressed()) {
            running = false;
        }
        for (auto key : drv.get_tapped_keys()) {
            switch (key) {
            // x untuk keluar
            case SDLK_x:
                running = false;
                break;
            }
        }
        //Deteksi Mouse

        if(gameStart){
            for (auto key : drv.get_tapped_Mousekeys()) {
                int x = key.x;
                int y = key.y;
                if(drv.isPointInBackground(x,y)){
                    cout<<"Clicked at "<<"background"<<endl;
                } else if(drv.isPointInEggButton(x,y)){
                    cout<<"Clicked at "<<"egg"<<endl;
                } else if(drv.isPointInFoodButton(x,y)){
                    cout<<"Clicked at "<<"food"<<endl;
                } else if(drv.isPointInGuppyButton(x,y)){
                    cout<<"Clicked at "<<"guppy"<<endl;
                } else if(drv.isPointInPiranhaButton(x,y)){
                    cout<<"Clicked at "<<"piranha"<<endl;
                } else if(drv.isPointInSaveButton(x,y)){
                    cout<<"Clicked at "<<"save"<<endl;
                }
            }
            drv.clear_screen();

            drv.drawBackground();

            //Check Draw Object in Aquarium
            drv.drawGoldCoin(30+200,30);
            drv.drawSilverCoin(60+200,60);

            drv.drawGuppyLv1LeftDirection(30,30);
            drv.drawGuppyLv2LeftDirection(60,60);
            drv.drawGuppyLv3LeftDirection(90,90);
            drv.drawHungryGuppyLv1LeftDirection(120,120);
            drv.drawHungryGuppyLv2LeftDirection(150,150);
            drv.drawHungryGuppyLv3LeftDirection(180,180);

            drv.drawGuppyLv1RightDirection(30+20,30);
            drv.drawGuppyLv2RightDirection(60+20,60);
            drv.drawGuppyLv3RightDirection(90+20,90);
            drv.drawHungryGuppyLv1RightDirection(120+20,120);
            drv.drawHungryGuppyLv2RightDirection(150+20,150);
            drv.drawHungryGuppyLv3RightDirection(180+20,180);

            //Untuk mati tentukan fram nya sendiri dari 0 sampai 9
            drv.drawDeadGuppyLv1RightDirection(30+20+70,30,9);
            drv.drawDeadGuppyLv2RightDirection(60+20+70,60,9);
            drv.drawDeadGuppyLv3RightDirection(90+20+70,90,9);
            drv.drawDeadGuppyLv1LeftDirection(120+20+70,120,9);
            drv.drawDeadGuppyLv2LeftDirection(150+20+70,150,9);
            drv.drawDeadGuppyLv3LeftDirection(180+20+70,180,9);
            
            drv.drawPiranhaRightDirection(90,200);
            drv.drawPiranhaLeftDirection(90,250);
            drv.drawHungryPiranhaLeftDirection(90,300);
            drv.drawHungryPiranhaRightDirection(90,350);
            drv.drawDeadPiranhaRightDirection(90,400,9);
            drv.drawDeadPiranhaLeftDirection(90,450,9);


            drv.drawSnailLeftDirection(50,600);
            drv.drawSnailRightDirection(100,600);
            drv.drawGuppyButton();
            drv.drawPiranhaButton();
            drv.drawFoodButton();
            drv.drawFoodPriceText("$10000");
            drv.drawGuppyPriceText("$20000");
            drv.drawPiranhaPriceText("$30000");
            drv.drawEggPriceText("$40000");
            drv.drawMoneyText("$99999");
            drv.drawCursorStatusText("Select appearing guppy position buying");
            drv.drawSaveButton();
            drv.drawEggButton(2);
            drv.incrementFrameAnimate();
            drv.update_screen();
        } else{
            for (auto key : drv.get_tapped_Mousekeys()) {
                int x = key.x;
                int y = key.y;
                if(drv.isPointInStartButton(x,y)){
                    cout<<"Clicked at "<<"start button"<<endl;
                    gameStart=true;
                } else if(drv.isPointInLoadButton(x,y)){
                    cout<<"Clicked at "<<"load button"<<endl;
                }
            } 
            drv.clear_screen();
            drv.drawStartButton();
            drv.drawLoadButton();
            drv.update_screen();

        }

        std::this_thread::sleep_for(std::chrono::milliseconds(20));
    }


    drv.close();
}