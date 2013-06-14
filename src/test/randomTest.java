package test;

import java.util.ArrayList;

import com.googlecode.javacv.cpp.ARToolKitPlus.Tracker;

import picture.GUI;

import robot.Position;
import robot.Robot;

public class randomTest {
	public static void main(String[] args) {
		Position robotFront = new Position(5, 5);
		Position robotBack = new Position(3, 7);
		ArrayList<Position> route = new ArrayList<Position>();
		Position pos = new Position(3, 5);
		route.add(pos);
		Robot robot = new Robot();
		robot.robotInit(robotFront, robotBack);
		System.out.println("Angle " + findangle(robotFront,pos,robotBack));
	}

	public static double findangle(Position p0, Position p1, Position c) {
		double p0c = Math.sqrt(Math.pow(c.getX()-p0.getX(),2)+
				Math.pow(c.getY()-p0.getY(),2)); // p0->c (b)   
		double p1c = Math.sqrt(Math.pow(c.getX()-p1.getX(),2)+
				Math.pow(c.getY()-p1.getY(),2)); // p1->c (a)
		double p0p1 = Math.sqrt(Math.pow(p1.getX()-p0.getX(),2)+
				Math.pow(p1.getY()-p0.getY(),2)); // p0->p1 (c)
		return (p1c*p1c+p0c*p0c-p0p1*p0p1)/(2*p1c*p0c);
	}
}
