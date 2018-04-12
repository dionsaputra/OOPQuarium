#include "SDLRenderImage.hpp"
#include "AquariumDrawerController.hpp"
#include <iostream>
#include <math.h>
#include <sstream>
#include <chrono>
#include <thread>
const double speed = 50; // pixels per second

int main( int argc, char* args[] )
{
    SDLRenderImage renderEngine;
    renderEngine.init();

    // Menghitung FPS
    int frames_passed = 0;
    double fpc_start = renderEngine.time_since_start();
    std::string fps_text = "FPS: 0";

    // Posisi ikan
    // double cy = renderEngine.SCREEN_HEIGHT / 2;
    // double cx = renderEngine.SCREEN_WIDTH / 2;
    double cy = 0;
    double cx = 0;

    bool running = true;
    int gambar=0;
    double prevtime = renderEngine.time_since_start();
    bool kiri=true;
    while (running) {
        double now = renderEngine.time_since_start();
        double sec_since_last = now - prevtime;
        prevtime = now;

        renderEngine.handle_input();
        if (renderEngine.quit_pressed()) {
            running = false;
        }

        // Gerakkan ikan selama tombol panah ditekan
        // Kecepatan dikalikan dengan perbedaan waktu supaya kecepatan ikan
        // konstan pada komputer yang berbeda.
        for (auto key : renderEngine.get_pressed_keys()) {
            switch (key) {
            case SDLK_UP:
                cy -= speed * sec_since_last;
                break;
            case SDLK_DOWN:
                cy += speed * sec_since_last;
                break;
            case SDLK_LEFT:
                kiri=true;
                cx -= speed * sec_since_last;
                break;
            case SDLK_RIGHT:
                kiri=false;
                cx += speed * sec_since_last;
                break;
            }
        }

        // Proses masukan yang bersifat "tombol"
        for (auto key : renderEngine.get_tapped_keys()) {
            switch (key) {
            // r untuk reset
            case SDLK_r:
                cy = renderEngine.getScreenHeight() / 2;
                cx = renderEngine.getScreenWidth() / 2;
                break;
            // x untuk keluar
            case SDLK_x:
                running = false;
                break;
            }
        }

        for (auto key : renderEngine.get_tapped_Mousekeys()) {
            cout<<"Clicked at "<<key.x<<","<<key.y<<endl;
        }
        // Update FPS setiap detik
        frames_passed++;
        if (now - fpc_start > 1) {
            std::ostringstream strs;
            strs << "FPS: " ;
            strs << frames_passed/(now - fpc_start);
            fps_text = strs.str();;
            fpc_start = now;
            frames_passed = 0;
        }

        // Gambar ikan di posisi yang tepat.
        renderEngine.clear_screen();
        
        renderEngine.draw_image("assets/aq4.jpeg", renderEngine.getScreenWidth() / 2, renderEngine.getScreenHeight() / 2);

        renderEngine.draw_text("Panah untuk bergerak, r untuk reset, x untuk keluar", 18, 10, 10, 0, 0, 0);
        renderEngine.draw_text(fps_text, 18, 10, 30, 0, 0, 0);
        int x, y;
        renderEngine.getMouseXY(x,y);
        cout<<x<<","<<y<<endl;
        if(!kiri){
            renderEngine.draw_imageMirrorY("assets/"+ to_string(gambar)+".png", cx, cy);
        } else{
            renderEngine.draw_image("assets/"+to_string(gambar) +".png", cx, cy);
        }
        gambar++;
        gambar=gambar%15;
        renderEngine.update_screen();

        std::this_thread::sleep_for(std::chrono::milliseconds(20));
    }

    renderEngine.close();
    
    return 0;
}
