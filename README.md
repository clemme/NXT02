NXT02
=====
Project for DTU Course 02343F13

The purpose of the system is to control one or several robots around a track consisting of gates. The goal is to pass as many tracks in 10 mins. 1 point is given for each passed port and each colision with a port or robot is -1 point.

This project consists of image analysis, to track the positions of ports and robots, mapping of datapoints from image analysis and robot control logic using information from the mapping.

Libraries used:
* JavaCV - a Java wrapper of C++ OpenCV
* lejOS API - open source operating system for LEGO Mindstorm NXT 
