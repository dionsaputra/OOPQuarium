#include "AquariumDrawerController.hpp"


AquariumDrawerController::AquariumDrawerController(){
    backgroundImageFile = "assets/aq4.jpeg";
    this->addFileImageToSurfaces(backgroundImageFile);
    saveImageFile = "assets/save.png";
    this->addFileImageToSurfaces(saveImageFile);
    loadImageFile = "assets/load.png";
    this->addFileImageToSurfaces(loadImageFile);
    startImageFile = "assets/start.png";
    this->addFileImageToSurfaces(startImageFile);
    
    winImageFile = "assets/win.png";
    this->addFileImageToSurfaces(winImageFile);
    loseImageFile = "assets/lose.png";
    this->addFileImageToSurfaces(loseImageFile);
    
    this->indexFrameAnimate = 0;
}


void AquariumDrawerController::initMedia(){
    //Add Egg to surfaces;
    string eggasset = "assets/egg/";
    for(int i=0;i<3;i++){
        string filename = eggasset+to_string(i)+".png";
        eggFilenameFrame.push_back(filename);
        this->addFileImageToSurfaces(filename);
    }

    string folderAsset[16] ;
    folderAsset[0]= "assets/foodfish/";
    folderAsset[1]= "assets/goldCoin/";
    folderAsset[2]= "assets/guppyLv1/";
    folderAsset[3]= "assets/guppyLv2/";
    folderAsset[4]= "assets/guppyLv3/";
    folderAsset[5]= "assets/hungryGuppyLv1/";
    folderAsset[6]= "assets/hungryGuppyLv2/";
    folderAsset[7]= "assets/hungryGuppyLv3/";
    folderAsset[8]= "assets/piranha/";
    folderAsset[9]= "assets/piranhaHungry/";
    folderAsset[10]= "assets/silverCoin/";
    folderAsset[11]= "assets/snail/";
    folderAsset[12]= "assets/deadGuppyLv1/";
    folderAsset[13]= "assets/deadGuppyLv2/";
    folderAsset[14]= "assets/deadGuppyLv3/";
    folderAsset[15]= "assets/deadPiranha/";
    int numberFrame=9;
    for(int i=0;i<=15;i++){
        for(int j=0;j<=numberFrame;j++){
            this->addFileImageToSurfaces(folderAsset[i]+to_string(j)+".png");
            switch(i){
                case 0:
                    foodFilenameFrame.push_back(folderAsset[i]+to_string(j)+".png");
                    break;
                case 1:
                    goldCoinFilenameFrame.push_back(folderAsset[i]+to_string(j)+".png");
                    break;
                case 2:
                    guppy1FilenameFrame.push_back(folderAsset[i]+to_string(j)+".png");
                    break;
                case 3:
                    guppy2FilenameFrame.push_back(folderAsset[i]+to_string(j)+".png");
                    break;
                case 4:
                    guppy3FilenameFrame.push_back(folderAsset[i]+to_string(j)+".png");
                    break;
                case 5:
                    hungryGuppy1FilenameFrame.push_back(folderAsset[i]+to_string(j)+".png");
                    break;
                case 6:
                    hungryGuppy2FilenameFrame.push_back(folderAsset[i]+to_string(j)+".png");
                    break;
                case 7:
                    hungryGuppy3FilenameFrame.push_back(folderAsset[i]+to_string(j)+".png");
                    break;
                case 8:
                    piranhaFilenameFrame.push_back(folderAsset[i]+to_string(j)+".png");
                    break;
                case 9:
                    hungryPiranhaFilenameFrame.push_back(folderAsset[i]+to_string(j)+".png");
                    break;
                case 10:
                    silverCoinFilenameFrame.push_back(folderAsset[i]+to_string(j)+".png");
                    break;
                case 11:
                    snailFilenameFrame.push_back(folderAsset[i]+to_string(j)+".png");
                    break;
                case 12:
                    deadGuppy1FilenameFrame.push_back(folderAsset[i]+to_string(j)+".png");
                    break; 
                case 13:
                    deadGuppy2FilenameFrame.push_back(folderAsset[i]+to_string(j)+".png");
                    break; 
                case 14:
                    deadGuppy3FilenameFrame.push_back(folderAsset[i]+to_string(j)+".png");
                    break; 
                case 15:
                    deadPiranhaFilenameFrame.push_back(folderAsset[i]+to_string(j)+".png");
                    break;                                               
            }
        }
    }
}

int AquariumDrawerController::getWidthStartButton(){
    return loadedSurfaces[startImageFile]->w;
}
int AquariumDrawerController::getHeightStartButton(){
    return loadedSurfaces[startImageFile]->h;
}

int AquariumDrawerController::getWidthLoadButton(){
    return loadedSurfaces[loadImageFile]->w;
}
int AquariumDrawerController::getHeightLoadButton(){
    return loadedSurfaces[loadImageFile]->h;
}

int AquariumDrawerController::getWidthSaveButton(){
    return loadedSurfaces[saveImageFile]->w;
}
int AquariumDrawerController::getHeightSaveButton(){
    return loadedSurfaces[saveImageFile]->h;
}


int AquariumDrawerController::getWidthBackground(){
    return loadedSurfaces[backgroundImageFile]->w;
}
int AquariumDrawerController::getHeightBackground(){
    return loadedSurfaces[backgroundImageFile]->h;
}

int AquariumDrawerController::getWidthGuppy(){
    return loadedSurfaces[guppy1FilenameFrame[0]]->w;
}
int AquariumDrawerController::getHeightGuppy(){
    return loadedSurfaces[guppy1FilenameFrame[0]]->h;
}

int AquariumDrawerController::getWidthPiranha(){
    return loadedSurfaces[piranhaFilenameFrame[0]]->w;
}
int AquariumDrawerController::getHeightPiranha(){
    return loadedSurfaces[piranhaFilenameFrame[0]]->h;
}

int AquariumDrawerController::getWidthSnail(){
    return loadedSurfaces[snailFilenameFrame[0]]->w;
}
int AquariumDrawerController::getHeightSnail(){
    return loadedSurfaces[snailFilenameFrame[0]]->h;
}  

int AquariumDrawerController::getWidthCoin(){
    return loadedSurfaces[goldCoinFilenameFrame[0]]->w;
}
int AquariumDrawerController::getHeightCoin(){
    return loadedSurfaces[goldCoinFilenameFrame[0]]->h;
}

int AquariumDrawerController::getWidthFishFood(){
    return loadedSurfaces[foodFilenameFrame[0]]->w;
}
int AquariumDrawerController::getHeightFishFood(){
    return loadedSurfaces[foodFilenameFrame[0]]->h;
}
int AquariumDrawerController::getWidthEgg(){
    return loadedSurfaces[eggFilenameFrame[0]]->w;
}
int AquariumDrawerController::getHeightEgg(){
    return loadedSurfaces[eggFilenameFrame[0]]->h;
}


void AquariumDrawerController::drawBackground(){
    this->draw_image(backgroundImageFile,getWidthBackground()/2,getHeightBackground()/2);
}

void AquariumDrawerController::init(){
    initMedia();
    this->init_Custom_Width_Height(getWidthBackground()+300,getHeightBackground());
}

void AquariumDrawerController::incrementFrameAnimate(){
    indexFrameAnimate++;
    indexFrameAnimate%=10;
}


void AquariumDrawerController::drawGuppyButton(){
    int x = getWidthBackground()+(getWidthGuppy()/2);
    int y = (getHeightGuppy()/2);
    this->draw_image(guppy3FilenameFrame[indexFrameAnimate],x,y);   
}

void AquariumDrawerController::drawPiranhaButton(){
    int x = getWidthBackground()+(getWidthPiranha()/2);
    int y = getHeightGuppy()+(getHeightPiranha()/2);
    this->draw_image(piranhaFilenameFrame[indexFrameAnimate],x,y);       
}
void AquariumDrawerController::drawFoodButton(){
    int x = getWidthBackground()+(getWidthFishFood()/2);
    int y = getHeightPiranha()+getHeightGuppy()+(getHeightFishFood()/2);
    this->draw_image(foodFilenameFrame[indexFrameAnimate],x,y);       
}
void AquariumDrawerController::drawEggButton(int lv){
    int x = getWidthBackground()+(getWidthEgg()/2);
    int y = getHeightPiranha()+getHeightGuppy()+getHeightFishFood()+getHeightEgg()/2;
    this->draw_image(eggFilenameFrame[lv-1],x,y);
}


void AquariumDrawerController::drawSaveButton(){
    int x = getWidthBackground()+getWidthSaveButton()/2;
    int y = getHeightBackground()-getHeightSaveButton()/2;
    this->draw_image(saveImageFile,x,y);

}

void AquariumDrawerController::drawStartButton(){
    int xcenter = this->getScreenWidth()/2;
    int ycenter = this->getScreenHeight()/2-getHeightStartButton()/2;
    this->draw_image(startImageFile,xcenter,ycenter);
}
void AquariumDrawerController::drawLoadButton(){
    int xcenter = this->getScreenWidth()/2;
    int ycenter = this->getScreenHeight()/2+getHeightLoadButton()/2;
    this->draw_image(loadImageFile,xcenter,ycenter);
}

void AquariumDrawerController::drawWinAnnouncement(){
    int xcenter = this->getScreenWidth()/2;
    int ycenter = this->getScreenHeight()/2;
    this->draw_image(winImageFile,xcenter,ycenter);
}
void AquariumDrawerController::drawLoseAnnouncement(){
    int xcenter = this->getScreenWidth()/2;
    int ycenter = this->getScreenHeight()/2;
    this->draw_image(loseImageFile,xcenter,ycenter);
}



void AquariumDrawerController::drawGuppyPriceText(string money){
    int x = getWidthBackground()+(getWidthGuppy());
    int y = 0;    
    this->draw_text(money, 18, x, y, 0, 0, 0);
}
void AquariumDrawerController::drawPiranhaPriceText(string money){
    int x = getWidthBackground()+(getWidthPiranha());
    int y = getHeightGuppy();
    this->draw_text(money, 18, x, y, 0, 0, 0);
}
void AquariumDrawerController::drawFoodPriceText(string money){
    int x = getWidthBackground()+(getWidthFishFood());
    int y = getHeightPiranha()+getHeightGuppy();
    this->draw_text(money, 18, x, y, 0, 0, 0);
}

void AquariumDrawerController::drawEggPriceText(string money){
    int x = getWidthBackground()+(getWidthEgg());
    int y = getHeightPiranha()+getHeightGuppy()+getHeightFishFood();
    this->draw_text(money, 18, x, y, 0, 0, 0);
}



void AquariumDrawerController::drawMoneyText(string money){
    int x = getWidthBackground();
    int y = getHeightPiranha()+getHeightGuppy()+getHeightFishFood()+getHeightEgg();
    this->draw_text("Your money : "+ money, 18, x, y, 0, 0, 0);    
}

void AquariumDrawerController::drawCursorStatusText(string status){
    int x = getWidthBackground();
    int y = getHeightPiranha()+getHeightGuppy()+getHeightFishFood()+getHeightEgg()+20;
    this->draw_text( status, 12, x, y, 0, 0, 0);     
}


bool AquariumDrawerController::isPointInFoodButton(int xpixel, int ypixel){
    //int xcenter = getWidthBackground()+(getWidthFishFood()/2);
    //int ycenter = getHeightPiranha()+getHeightGuppy()+(getHeightFishFood()/2);
    int xKiriAtas = getWidthBackground();
    int yKiriAtas = getHeightPiranha()+getHeightGuppy();
    bool validasiX = xpixel>xKiriAtas && xpixel<xKiriAtas+getWidthFishFood();
    bool validasiY = ypixel>yKiriAtas && ypixel<yKiriAtas+getHeightFishFood();
    return  validasiX&&validasiY ;

}
bool AquariumDrawerController::isPointInPiranhaButton(int xpixel, int ypixel){
    int xKiriAtas = getWidthBackground();
    int yKiriAtas = getHeightGuppy();
    bool validasiX = xpixel>xKiriAtas && xpixel<xKiriAtas+getWidthPiranha();
    bool validasiY = ypixel>yKiriAtas && ypixel<yKiriAtas+getHeightPiranha();
    return validasiX && validasiY;
}
bool AquariumDrawerController::isPointInGuppyButton(int xpixel, int ypixel){
    int xKiriAtas = getWidthBackground();
    int yKiriAtas = 0;
    bool validasiX = xpixel>xKiriAtas && xpixel<xKiriAtas+getWidthGuppy();
    bool validasiY = ypixel>yKiriAtas && ypixel<yKiriAtas+getHeightGuppy();
    return validasiX && validasiY;    
}
bool AquariumDrawerController::isPointInEggButton(int xpixel, int ypixel){
    int xKiriAtas = getWidthBackground();
    int yKiriAtas = getHeightPiranha()+getHeightGuppy()+getHeightFishFood();    
    bool validasiX = xpixel>xKiriAtas && xpixel<xKiriAtas+getWidthEgg();
    bool validasiY = ypixel>yKiriAtas && ypixel<yKiriAtas+getHeightEgg();
    return validasiX && validasiY;     
}
bool AquariumDrawerController::isPointInSaveButton(int xpixel, int ypixel){
    int xKiriAtas = getWidthBackground();
    int yKiriAtas = getHeightBackground()-getHeightSaveButton();
    bool validasiX = xpixel>xKiriAtas && xpixel<xKiriAtas+getWidthSaveButton();
    bool validasiY = ypixel>yKiriAtas && ypixel<yKiriAtas+getHeightSaveButton();
    return validasiX && validasiY;     

}
bool AquariumDrawerController::isPointInBackground(int xpixel, int ypixel){
    bool validasiX = xpixel>0 && xpixel<getWidthBackground();
    bool validasiY = ypixel>0 && ypixel<getHeightBackground();
    return validasiX && validasiY;     

}

bool AquariumDrawerController::isPointInStartButton(int xpixel, int ypixel){
    int xKiriAtas = this->getScreenWidth()/2-getWidthStartButton()/2;
    int yKiriAtas = this->getScreenHeight()/2-getHeightStartButton();
    bool validasiX = xpixel>xKiriAtas && xpixel<xKiriAtas+getWidthStartButton();
    bool validasiY = ypixel>yKiriAtas && ypixel<yKiriAtas+getHeightStartButton();
    return validasiX && validasiY;
}
bool AquariumDrawerController::isPointInLoadButton(int xpixel, int ypixel){
    int xKiriAtas = this->getScreenWidth()/2-getWidthLoadButton()/2;
    int yKiriAtas = this->getScreenHeight()/2;
    bool validasiX = xpixel>xKiriAtas && xpixel<xKiriAtas+getWidthSaveButton();
    bool validasiY = ypixel>yKiriAtas && ypixel<yKiriAtas+getHeightSaveButton();
    return validasiX && validasiY;
}

bool AquariumDrawerController::isPointInObject(int xpixel, int ypixel,int xcenter,int ycenter,int objectWidth, int objectHeight){
    int xKiriAtas = xcenter-objectWidth/2;
    int yKiriAtas = ycenter-objectHeight/2;
    bool validasiX = xpixel>xKiriAtas && xpixel<xKiriAtas+objectWidth;
    bool validasiY = ypixel>yKiriAtas && ypixel<yKiriAtas+objectHeight;
    return validasiX && validasiY;    
}


void AquariumDrawerController::drawGuppyLv1LeftDirection(int xpixel, int ypixel){
    this->draw_image(guppy1FilenameFrame[indexFrameAnimate],xpixel,ypixel);   
}
void AquariumDrawerController::drawGuppyLv2LeftDirection(int xpixel, int ypixel){
    this->draw_image(guppy2FilenameFrame[indexFrameAnimate],xpixel,ypixel);       
}
void AquariumDrawerController::drawGuppyLv3LeftDirection(int xpixel, int ypixel){
    this->draw_image(guppy3FilenameFrame[indexFrameAnimate],xpixel,ypixel);
}
void AquariumDrawerController::drawPiranhaLeftDirection(int xpixel, int ypixel){
    this->draw_image(piranhaFilenameFrame[indexFrameAnimate],xpixel,ypixel);

}
void AquariumDrawerController::drawHungryGuppyLv1LeftDirection(int xpixel, int ypixel){
    this->draw_image(hungryGuppy1FilenameFrame[indexFrameAnimate],xpixel,ypixel);

}
void AquariumDrawerController::drawHungryGuppyLv2LeftDirection(int xpixel, int ypixel){
    this->draw_image(hungryGuppy2FilenameFrame[indexFrameAnimate],xpixel,ypixel);
}
void AquariumDrawerController::drawHungryGuppyLv3LeftDirection(int xpixel, int ypixel){
    this->draw_image(hungryGuppy3FilenameFrame[indexFrameAnimate],xpixel,ypixel);

}
void AquariumDrawerController::drawHungryPiranhaLeftDirection(int xpixel, int ypixel){
    this->draw_image(hungryPiranhaFilenameFrame[indexFrameAnimate],xpixel,ypixel);

}
void AquariumDrawerController::drawDeadGuppyLv1LeftDirection(int xpixel, int ypixel,int animateConditionFrame){
    this->draw_image(deadGuppy1FilenameFrame[animateConditionFrame],xpixel,ypixel);

}
void AquariumDrawerController::drawDeadGuppyLv2LeftDirection(int xpixel, int ypixel,int animateConditionFrame){
    this->draw_image(deadGuppy2FilenameFrame[animateConditionFrame],xpixel,ypixel);

}
void AquariumDrawerController::drawDeadGuppyLv3LeftDirection(int xpixel, int ypixel,int animateConditionFrame){
    this->draw_image(deadGuppy3FilenameFrame[animateConditionFrame],xpixel,ypixel);

}
void AquariumDrawerController::drawDeadPiranhaLeftDirection(int xpixel, int ypixel,int animateConditionFrame){
    this->draw_image(deadPiranhaFilenameFrame[animateConditionFrame],xpixel,ypixel);

}
void AquariumDrawerController::drawSnailLeftDirection(int xpixel, int ypixel){
    this->draw_image(snailFilenameFrame[indexFrameAnimate],xpixel,ypixel);

}







void AquariumDrawerController::drawGoldCoin(int xpixel, int ypixel){
    this->draw_image(goldCoinFilenameFrame[indexFrameAnimate],xpixel,ypixel);
}

void AquariumDrawerController::drawSilverCoin(int xpixel, int ypixel){
    this->draw_image(silverCoinFilenameFrame[indexFrameAnimate],xpixel,ypixel);
}
void AquariumDrawerController::drawFishFood(int xpixel, int ypixel){
    this->draw_image(foodFilenameFrame[indexFrameAnimate],xpixel,ypixel);

}




void AquariumDrawerController::drawGuppyLv1RightDirection(int xpixel, int ypixel){
    this->draw_imageMirrorY(guppy1FilenameFrame[indexFrameAnimate],xpixel,ypixel);   
}
void AquariumDrawerController::drawGuppyLv2RightDirection(int xpixel, int ypixel){
    this->draw_imageMirrorY(guppy2FilenameFrame[indexFrameAnimate],xpixel,ypixel);       
}
void AquariumDrawerController::drawGuppyLv3RightDirection(int xpixel, int ypixel){
    this->draw_imageMirrorY(guppy3FilenameFrame[indexFrameAnimate],xpixel,ypixel);
}
void AquariumDrawerController::drawPiranhaRightDirection(int xpixel, int ypixel){
    this->draw_imageMirrorY(piranhaFilenameFrame[indexFrameAnimate],xpixel,ypixel);

}
void AquariumDrawerController::drawHungryGuppyLv1RightDirection(int xpixel, int ypixel){
    this->draw_imageMirrorY(hungryGuppy1FilenameFrame[indexFrameAnimate],xpixel,ypixel);

}
void AquariumDrawerController::drawHungryGuppyLv2RightDirection(int xpixel, int ypixel){
    this->draw_imageMirrorY(hungryGuppy2FilenameFrame[indexFrameAnimate],xpixel,ypixel);
}
void AquariumDrawerController::drawHungryGuppyLv3RightDirection(int xpixel, int ypixel){
    this->draw_imageMirrorY(hungryGuppy3FilenameFrame[indexFrameAnimate],xpixel,ypixel);

}
void AquariumDrawerController::drawHungryPiranhaRightDirection(int xpixel, int ypixel){
    this->draw_imageMirrorY(hungryPiranhaFilenameFrame[indexFrameAnimate],xpixel,ypixel);

}
void AquariumDrawerController::drawDeadGuppyLv1RightDirection(int xpixel, int ypixel,int animateConditionFrame){
    this->draw_imageMirrorY(deadGuppy1FilenameFrame[animateConditionFrame],xpixel,ypixel);

}
void AquariumDrawerController::drawDeadGuppyLv2RightDirection(int xpixel, int ypixel,int animateConditionFrame){
    this->draw_imageMirrorY(deadGuppy2FilenameFrame[animateConditionFrame],xpixel,ypixel);

}
void AquariumDrawerController::drawDeadGuppyLv3RightDirection(int xpixel, int ypixel,int animateConditionFrame){
    this->draw_imageMirrorY(deadGuppy3FilenameFrame[animateConditionFrame],xpixel,ypixel);

}
void AquariumDrawerController::drawDeadPiranhaRightDirection(int xpixel, int ypixel,int animateConditionFrame){
    this->draw_imageMirrorY(deadPiranhaFilenameFrame[animateConditionFrame],xpixel,ypixel);

}
void AquariumDrawerController::drawSnailRightDirection(int xpixel, int ypixel){
    this->draw_imageMirrorY(snailFilenameFrame[indexFrameAnimate],xpixel,ypixel);

}
