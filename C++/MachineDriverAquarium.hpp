#ifndef MACHINEDRIVERAQUA_HPP
#define MACHINEDRIVERAQUA_HPP

#include <bits/stdc++.h>
#include "Aquarium.hpp"
#include "RenderGambar/AquariumDrawerController.hpp"
#include "RenderGambar/SDLRenderImage.hpp"

#include <ctime>
#include <cstdlib>
class MachineDriverAquarium:public AquariumDrawerController,public Aquarium {
    private:
        int money,egg,guppyPrice,foodPrice,piranhaPrice,eggPrice,winEgg,coinPrice;
        string piranhaJenis,guppyJenis,makananIkanJenis,koinJenis;
    public:
        MachineDriverAquarium();

        void execute();

        void initAll();

        void drawIkanAndCheck(Fish * temp);

        void drawGuppyLeftLv(int level,int x,int y,bool isStarving);
        void drawGuppyRightLv(int level,int x,int y,bool isStarving);

};


#endif
