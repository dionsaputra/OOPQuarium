# Masukkan semua file cpp Anda
OBJS = mainprog.cpp MakananIkan.cpp MachineDriverAquarium.cpp RenderGambar/AquariumDrawerController.cpp RenderGambar/SDLRenderImage.cpp Piranha.hpp Piranha.cpp Guppy.hpp Guppy.cpp Fish.hpp Aquarium.hpp Point.hpp Aquarium.cpp Point.cpp ObjekMati.hpp ObjekMati.cpp Pet.hpp Pet.cpp Fish.cpp Koin.cpp
CC = g++
COMPILER_FLAGS = -std=c++11 -Wall -O2 
LINKER_FLAGS = -lSDL2 -lSDL2_image -lSDL2_ttf
OBJ_NAME = oopquarium
all : $(OBJS)
	$(CC) $(OBJS) $(COMPILER_FLAGS) $(LINKER_FLAGS) -o $(OBJ_NAME)
