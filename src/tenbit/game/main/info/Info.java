package tenbit.game.main.info;

import java.lang.Object.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;
import java.awt.Component;
import java.awt.Font;

public class Info {
	private int choice;
	private boolean toRun;
	MousePos mp =  new MousePos();
	
	public Info() {
		choice = 0;
		toRun = false;
	}
	public Info(boolean on, int in) {
		toRun = on;
		choice = in;
		start();
	}
	private void start() {
		switch(choice) {
			case 1: mp = new MousePos(toRun);
				break;
			default: System.out.println("Invalid Info Request");
				break;
		}
	}
	public void paint(Graphics window) {
		mp.paint(window);
	}

}
