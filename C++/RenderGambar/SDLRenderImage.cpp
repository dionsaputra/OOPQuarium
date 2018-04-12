// Anda tidak perlu melakukan perubahan pada file ini untuk memenuhi spek
// wajib. Namun, hal tersebut diperbolehkan.
#include "SDLRenderImage.hpp"









SDLRenderImage::SDLRenderImage():SCREEN_WIDTH(933),SCREEN_HEIGHT(700){
    start =high_resolution_clock::now();

}
SDLRenderImage::SDLRenderImage(int w,int h):SCREEN_WIDTH(w),SCREEN_HEIGHT(h){
    start =high_resolution_clock::now();
}



double SDLRenderImage::time_since_start()
{
    high_resolution_clock::time_point now = high_resolution_clock::now();
    return duration_cast<duration<double>>(now - this->start).count();
}



//

void SDLRenderImage::setpixel(SDL_Surface *screen, int x, int y, Uint32 newcolor )
{

  Uint8 *ubuff8;
  Uint16 *ubuff16;
  Uint32 *ubuff32;
  Uint32 color = newcolor;
  char c1, c2, c3;
  
  /* Lock the screen, if needed */
  if(SDL_MUSTLOCK(screen)) 
  {
    if(SDL_LockSurface(screen) < 0) 
      return;
  }
  
  /* How we draw the pixel depends on the bitdepth */
  switch(screen->format->BytesPerPixel) 
    {
    case 1: 
      ubuff8 = (Uint8*) screen->pixels;
      ubuff8 += (y * screen->pitch) + x; 
      *ubuff8 = (Uint8) color;
      break;

    case 2:
      ubuff8 = (Uint8*) screen->pixels;
      ubuff8 += (y * screen->pitch) + (x*2);
      ubuff16 = (Uint16*) ubuff8;
      *ubuff16 = (Uint16) color; 
      break;  

    case 3:
      ubuff8 = (Uint8*) screen->pixels;
      ubuff8 += (y * screen->pitch) + (x*3);

      if(SDL_BYTEORDER == SDL_LIL_ENDIAN) {
	c1 = (color & 0xFF0000) >> 16;
	c2 = (color & 0x00FF00) >> 8;
	c3 = (color & 0x0000FF);
      } else {
	c3 = (color & 0xFF0000) >> 16;
	c2 = (color & 0x00FF00) >> 8;
	c1 = (color & 0x0000FF);	
      }

      ubuff8[0] = c3;
      ubuff8[1] = c2;
      ubuff8[2] = c1;
      break;
      
    case 4:
      ubuff8 = (Uint8*) screen->pixels;
      ubuff8 += (y*screen->pitch) + (x*4);
      ubuff32 = (Uint32*)ubuff8;
      *ubuff32 = color;
      break;
      
    default:
      fprintf(stderr, "Error: Unknown bitdepth!\n");
    }
  
  /* Unlock the screen if needed */
  if(SDL_MUSTLOCK(screen)) {
    SDL_UnlockSurface(screen);
  }
}


Uint32 SDLRenderImage::getpixel(SDL_Surface *surface, int x, int y)
{
    int bpp = surface->format->BytesPerPixel;
    /* Here p is the address to the pixel we want to retrieve */
    Uint8 *p = (Uint8 *)surface->pixels + y * surface->pitch + x * bpp;

    switch(bpp) {
    case 1:
        return *p;

    case 2:
        return *(Uint16 *)p;

    case 3:
        if(SDL_BYTEORDER == SDL_BIG_ENDIAN)
            return p[0] << 16 | p[1] << 8 | p[2];
        else
            return p[0] | p[1] << 8 | p[2] << 16;

    case 4:
        return *(Uint32 *)p;

    default:
        return 0;       /* shouldn't happen, but avoids warnings */
    }
}



//Mirroring image
SDL_Surface * SDLRenderImage::MirrorSurfaceX( SDL_Surface *screen )
{
	SDL_Surface* newimg = SDL_CreateRGBSurface( SDL_SWSURFACE, screen->w, screen->h, screen->format->BitsPerPixel, screen->format->Rmask, screen->format->Gmask, screen->format->Bmask, screen->format->Amask);

	for( int y = 0; y < screen->h; y++ )
	{
		for( int x = 0; x < screen->w; x++ )
		{
			setpixel( newimg, x, y, getpixel( screen, x, screen->h - y - 1 ) );
		}
	}

	return newimg;
}

SDL_Surface * SDLRenderImage::MirrorSurfaceY( SDL_Surface *screen )
{
	SDL_Surface* newimg = SDL_CreateRGBSurface( SDL_SWSURFACE, screen->w, screen->h, screen->format->BitsPerPixel, screen->format->Rmask, screen->format->Gmask, screen->format->Bmask, screen->format->Amask);

	for( int y = 0; y < screen->h; y++ )
	{
		for( int x = 0; x < screen->w; x++ )
		{
			setpixel( newimg, x, y, getpixel( screen, screen->w - x - 1, y ) );
		}
	}

	return newimg;
}


int SDLRenderImage::getHeightImage(string filename){
    if(loadedSurfaces.count(filename)<1){
        loadedSurfaces[filename] = loadSurface(filename);
    }

    return loadedSurfaces[filename]->h;
}

int SDLRenderImage::getWidthImage(string filename){
    if(loadedSurfaces.count(filename)<1){
        loadedSurfaces[filename] = loadSurface(filename);
    }

    return loadedSurfaces[filename]->w;
}

bool SDLRenderImage::init()
{
    bool success = true;

    if( SDL_Init( SDL_INIT_VIDEO ) < 0 )
    {
        printf( "SDL could not initialize! SDL Error: %s\n", SDL_GetError() );
        success = false;
    }
    else
    {

        if(TTF_Init() == -1) {
            printf("TTF_Init: %s\n", TTF_GetError());
            success = false;
        }
        sdlWindow = SDL_CreateWindow( "ArkavQuarium", SDL_WINDOWPOS_UNDEFINED, SDL_WINDOWPOS_UNDEFINED, SCREEN_WIDTH, SCREEN_HEIGHT, SDL_WINDOW_SHOWN );
        if( sdlWindow == NULL )
        {
            printf( "Window could not be created! SDL Error: %s\n", SDL_GetError() );
            success = false;
        }
        else
        {
            gScreenSurface = SDL_GetWindowSurface( sdlWindow );
        }
    }

    return success;
}

void SDLRenderImage::close()
{
    for (auto const& x : loadedSurfaces)
    {
        SDL_FreeSurface( x.second );
    }

    for (auto const& x : loadedFontSizes)
    {
        TTF_CloseFont( x.second );
    }

    SDL_DestroyWindow( sdlWindow );
    sdlWindow = NULL;

    SDL_Quit();
}

SDL_Surface* SDLRenderImage::loadSurface( std::string path )
{
    SDL_Surface* loadedSurface = IMG_Load( path.c_str() );
    if( loadedSurface == NULL )
    {
        printf( "Unable to load image %s! SDL Error: %s\n", path.c_str(), SDL_GetError() );
    }

    return loadedSurface;
}
void SDLRenderImage::addFileImageToSurfaces(string filename){
    loadedSurfaces[filename] = loadSurface(filename);
}
void SDLRenderImage::draw_image(std::string filename, int x, int y) {
    if (loadedSurfaces.count(filename) < 1) {
        loadedSurfaces[filename] = loadSurface(filename);
    }

    SDL_Surface* s = loadedSurfaces[filename];
    SDL_BlitSurface(loadedSurfaces[filename], NULL, s, NULL);
    SDL_Rect dest;
    dest.x = x - s->w/2;
    dest.y = y - s->h/2;
    dest.w = s->w;
    dest.h = s->h;
    SDL_BlitSurface(s, NULL, gScreenSurface, &dest);
}





void SDLRenderImage::draw_imageMirrorY(std::string filename, int x, int y) {
    if (loadedSurfacesMirror.count(filename) < 1) {
        loadedSurfacesMirror[filename] = MirrorSurfaceY (loadSurface(filename));
    }  
    SDL_Surface* s =loadedSurfacesMirror[filename];

    SDL_Rect dest;
    dest.x = x - s->w/2;
    dest.y = y - s->h/2;
    dest.w = s->w;
    dest.h = s->h;
    SDL_BlitSurface(s, NULL, gScreenSurface, &dest);

}

void SDLRenderImage::draw_text(std::string text, int font_size, int x, int y, unsigned char r, unsigned char g, unsigned char b) {
    if (loadedFontSizes.count(font_size) < 1) {
        loadedFontSizes[font_size] = TTF_OpenFont(FONT_NAME, font_size);
    }

    TTF_Font* font = loadedFontSizes[font_size];
    SDL_Surface* result = TTF_RenderText_Blended(font, text.c_str(), {r, g, b});
    SDL_Rect dest;
    dest.x = x;
    dest.y = y;
    dest.w = result->w;
    dest.h = result->h;
    SDL_BlitSurface(result, NULL, gScreenSurface, &dest);
    SDL_FreeSurface(result);
}

void SDLRenderImage::clear_screen() {
    SDL_FillRect(gScreenSurface, NULL, SDL_MapRGB(gScreenSurface->format, 255, 255, 255));
}

void SDLRenderImage::update_screen() {
    SDL_UpdateWindowSurface(sdlWindow);
}



void SDLRenderImage::handle_input() {
    SDL_Event e;
    if (!tappedKeys.empty()) tappedKeys.clear();
    if (!tappedMouseKeys.empty()) tappedMouseKeys.clear();
    while( SDL_PollEvent( &e ) != 0 )
        {
            if ( e.type == SDL_QUIT ) {
                quit = true;
            } else if (e.type == SDL_KEYDOWN && !e.key.repeat) {
                pressedKeys.insert(e.key.keysym.sym);
                tappedKeys.insert(e.key.keysym.sym);
            } else if (e.type == SDL_KEYUP) {
                pressedKeys.erase(e.key.keysym.sym);
                
            } else if(e.type == SDL_MOUSEBUTTONDOWN){                
                tappedMouseKeys.push_back(e.button);
                
            }
        }
}

bool SDLRenderImage::quit_pressed() {
    return quit;
}

const std::set<SDL_Keycode>& SDLRenderImage::get_pressed_keys() {
    return pressedKeys;
}

const std::set<SDL_Keycode>& SDLRenderImage::get_tapped_keys() {
    return tappedKeys;
}
const std::vector<SDL_MouseButtonEvent>& SDLRenderImage::get_tapped_Mousekeys(){
    return tappedMouseKeys;
}


void SDLRenderImage::getMouseXY(int &x, int &y){
    
    SDL_GetMouseState(&x,&y);

}

bool SDLRenderImage::init_Custom_Width_Height(int w,int h){
    bool success = true;
    SCREEN_HEIGHT = h;
    SCREEN_WIDTH = w;
    if( SDL_Init( SDL_INIT_VIDEO ) < 0 )
    {
        printf( "SDL could not initialize! SDL Error: %s\n", SDL_GetError() );
        success = false;
    }
    else
    {

        if(TTF_Init() == -1) {
            printf("TTF_Init: %s\n", TTF_GetError());
            success = false;
        }
        sdlWindow = SDL_CreateWindow( "ArkavQuarium", SDL_WINDOWPOS_UNDEFINED, SDL_WINDOWPOS_UNDEFINED,w, h, SDL_WINDOW_SHOWN );
        if( sdlWindow == NULL )
        {
            printf( "Window could not be created! SDL Error: %s\n", SDL_GetError() );
            success = false;
        }
        else
        {
            gScreenSurface = SDL_GetWindowSurface( sdlWindow );
        }
    }

    return success;
}
