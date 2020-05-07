cmake_minimum_required(VERSION 3.15)
project(dryer)

set(CMAKE_CXX_STANDARD 98)

add_executable(dryer generated/main.cpp generated/proc.cpp reflex_lib/r_io.cpp reflex_lib/r_lib.cpp usr/usr.cpp generated/io.cpp)