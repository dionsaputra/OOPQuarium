#ifndef OOP_HPP
#define OOP_HPP

#include <SDL2/SDL.h>
#include <SDL2/SDL_image.h>
#include <SDL2/SDL_ttf.h>
#include <set>
#include <vector>
#include <string>
#include <map>
#include <iostream>
#include <chrono>
using namespace std::chrono;
using namespace std;

class SDLRenderImage{

protected:
        const char* const FONT_NAME = "OpenSans-Regular.ttf";
        SDL_Window* sdlWindow;
        std::map<std::string, SDL_Surface*> loadedSurfaces;
        std::map<std::string, SDL_Surface*> loadedSurfacesMirror;
        std::map<int, TTF_Font*> loadedFontSizes;
        SDL_Surface* gScreenSurface = NULL;
        bool quit = false;
        std::set<SDL_Keycode> pressedKeys;
        std::set<SDL_Keycode> tappedKeys;
        std::vector<SDL_MouseButtonEvent> tappedMouseKeys;
        high_resolution_clock::time_point start;    
        int SCREEN_WIDTH;
        int SCREEN_HEIGHT;
public:


    int getScreenWidth(){
        return  SCREEN_WIDTH;
    }
    int getScreenHeight(){
        return  SCREEN_HEIGHT;
    }
    // Pengaturan ukuran layar yang dihasilkan.
    int getHeightImage(string filename);
    int getWidthImage(string filename);
    SDLRenderImage();
    SDLRenderImage(int,int);
    //Mirroring Image
    void setpixel(SDL_Surface *screen, int x, int y, Uint32 newcolor );
    Uint32 getpixel(SDL_Surface *surface, int x, int y);
    SDL_Surface *MirrorSurfaceY( SDL_Surface *screen );
    SDL_Surface *MirrorSurfaceX( SDL_Surface *screen );
    SDL_Surface*loadSurface( std::string path );





    


    // Nama font yang digunakan untuk menggambar tulisan.
    

    // ---------------------------------- SETUP ----------------------------------

    // Melakukan inisialisasi terhadap program.
    bool init();
    bool init_Custom_Width_Height(int w,int h);
    // Menghentikan program.
    void close();

    // ------------------------------ PENGGAMBARAN -------------------------------

    // Menggambar suatu gambar png, jpg, bmp sehingga tengah gambar berada di
    // titik (x, y).
    // Perubahan di layar baru muncul ketika update_screen() dipanggil.
    void draw_image(std::string filename, int x, int y);
    void draw_imageMirrorY(std::string filename, int x, int y);
    // Menuliskan teks berukuran font_size berwarna (r, g, b) ke layar sehingga
    // kiri atas teks berada di titik (x, y).
    // Perubahan di layar baru muncul ketika update_screen() dipanggil.
    void draw_text(std::string text, int font_size,
                int x, int y,
                unsigned char r, unsigned char g, unsigned char b);

    // Mengisi layar dengan warna putih.
    // Perubahan di layar baru muncul ketika update_screen() dipanggil.
    void clear_screen();

    // Melakukan proses update terhadap layar.
    void update_screen();

    // --------------------------------- MASUKAN ---------------------------------

    // Memproses masukan dari sistem operasi.
    void handle_input();

    // Mengembalikan apakah pengguna telah meminta keluar dengan menekan tombol
    // keluar di jendela program ketika handle_input() terakhir dipanggil.
    bool quit_pressed();

    // Untuk dua fungsi berikut, nama konstan kode yang tepat dapat dilihat di
    // https://wiki.libsdl.org/SDL_Keycode pada kolom "SDL_Keycode Value".

    // Mengembalikan himpunan kode tombol yang sedang ditekan pada saat
    // handle_input() terakhir dipanggil.
    const std::set<SDL_Keycode>& get_pressed_keys();

    // Mengembalikan himpunan kode tombol yang baru mulai ditekan pada saat
    // handle_input() terakhir dipanggil.
    const std::set<SDL_Keycode>& get_tapped_keys();


    const std::vector<SDL_MouseButtonEvent>& get_tapped_Mousekeys();
    // ---------------------------------- WAKTU ----------------------------------

    // Mengembalikan waktu dari permulaan program dalam nilai detik (bisa pecahan).
    double time_since_start();


    void getMouseXY(int &x, int &y);


    void addFileImageToSurfaces(string filename);
};


#endif
