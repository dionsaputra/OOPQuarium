#ifndef AQDRAWER_HPP
#define AQDRAWER_HPP
#include "SDLRenderImage.hpp"
#include <bits/stdc++.h>
class AquariumDrawerController: public SDLRenderImage{
    private:
        string backgroundImageFile;
        string saveImageFile;
        string loadImageFile;
        string startImageFile;
        string winImageFile;
        string loseImageFile;
        vector<string> piranhaFilenameFrame; 
        vector<string> hungryPiranhaFilenameFrame;
        vector<string> deadPiranhaFilenameFrame;

        vector<string> guppy1FilenameFrame;
        vector<string> guppy2FilenameFrame;    
        vector<string> guppy3FilenameFrame;
        vector<string> hungryGuppy1FilenameFrame;
        vector<string> hungryGuppy2FilenameFrame;    
        vector<string> hungryGuppy3FilenameFrame;
        vector<string> deadGuppy1FilenameFrame;
        vector<string> deadGuppy2FilenameFrame;    
        vector<string> deadGuppy3FilenameFrame;
        
        vector<string> snailFilenameFrame;
        vector<string> silverCoinFilenameFrame;
        vector<string> goldCoinFilenameFrame;
        vector<string> foodFilenameFrame;
        vector<string> eggFilenameFrame;
        int indexFrameAnimate;     
    public:
        AquariumDrawerController();
        void initMedia();

        void init();
        
        int getWidthBackground();
        int getHeightBackground();

        int getWidthGuppy();
        int getHeightGuppy();


        int getWidthPiranha();
        int getHeightPiranha();

        int getWidthSnail();
        int getHeightSnail();    

        int getWidthCoin();
        int getHeightCoin(); 

        int getWidthFishFood();
        int getHeightFishFood();   

        int getWidthEgg();
        int getHeightEgg();  

        int getWidthStartButton();
        int getHeightStartButton();

        int getWidthLoadButton();
        int getHeightLoadButton();

        int getWidthSaveButton();
        int getHeightSaveButton();
        //Drawing  Aquarium Object    
        void drawBackground();
        void drawGoldCoin(int xpixel, int ypixel);
        void drawSilverCoin(int xpixel, int ypixel);
        void drawFishFood(int xpixel, int ypixel);
        
        //Left
        void drawGuppyLv1LeftDirection(int xpixel, int ypixel);
        void drawGuppyLv2LeftDirection(int xpixel, int ypixel);
        void drawGuppyLv3LeftDirection(int xpixel, int ypixel);
        void drawPiranhaLeftDirection(int xpixel, int ypixel);
        void drawHungryGuppyLv1LeftDirection(int xpixel, int ypixel);
        void drawHungryGuppyLv2LeftDirection(int xpixel, int ypixel);
        void drawHungryGuppyLv3LeftDirection(int xpixel, int ypixel);
        void drawHungryPiranhaLeftDirection(int xpixel, int ypixel);
        void drawDeadGuppyLv1LeftDirection(int xpixel, int ypixel,int animateConditionFrame);
        void drawDeadGuppyLv2LeftDirection(int xpixel, int ypixel,int animateConditionFrame);
        void drawDeadGuppyLv3LeftDirection(int xpixel, int ypixel,int animateConditionFrame);
        void drawDeadPiranhaLeftDirection(int xpixel, int ypixel,int animateConditionFrame);
        void drawSnailLeftDirection(int xpixel, int ypixel);



        //Right
        void drawGuppyLv1RightDirection(int xpixel, int ypixel);
        void drawGuppyLv2RightDirection(int xpixel, int ypixel);
        void drawGuppyLv3RightDirection(int xpixel, int ypixel);
        void drawPiranhaRightDirection(int xpixel, int ypixel);
        void drawHungryGuppyLv1RightDirection(int xpixel, int ypixel);
        void drawHungryGuppyLv2RightDirection(int xpixel, int ypixel);
        void drawHungryGuppyLv3RightDirection(int xpixel, int ypixel);
        void drawHungryPiranhaRightDirection(int xpixel, int ypixel);
        void drawDeadGuppyLv1RightDirection(int xpixel, int ypixel,int animateConditionFrame);
        void drawDeadGuppyLv2RightDirection(int xpixel, int ypixel,int animateConditionFrame);
        void drawDeadGuppyLv3RightDirection(int xpixel, int ypixel,int animateConditionFrame);
        void drawDeadPiranhaRightDirection(int xpixel, int ypixel,int animateConditionFrame);
        void drawSnailRightDirection(int xpixel, int ypixel);


        void drawMoneyText(string money);
        void drawGuppyPriceText(string money);
        void drawPiranhaPriceText(string money);
        void drawFoodPriceText(string money);
        void drawEggPriceText(string money);
        void drawCursorStatusText(string status);
        
        void drawWinAnnouncement();
        void drawLoseAnnouncement();
        

        void drawStartButton();
        void drawLoadButton();
        void drawSaveButton();
        void drawGuppyButton();
        void drawPiranhaButton();
        void drawFoodButton();
        void drawEggButton(int lv);
        //Validasi
        bool isPointInFoodButton(int xpixel, int ypixel);
        bool isPointInPiranhaButton(int xpixel, int ypixel);
        bool isPointInGuppyButton(int xpixel, int ypixel);
        bool isPointInEggButton(int xpixel, int ypixel);
        bool isPointInSaveButton(int xpixel, int ypixel);
        bool isPointInLoadButton(int xpixel, int ypixel);
        bool isPointInStartButton(int xpixel, int ypixel);
        bool isPointInBackground(int xpixel, int ypixel);
        bool isPointInObject(int xpixel, int ypixel,int xcenter,int ycenter,int objectWidth, int objectHeight);
        void incrementFrameAnimate();


};



#endif
