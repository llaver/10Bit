package tenbit.game.main.campaign;

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
import java.awt.Component;
import java.awt.Font;

public class NewGame {
	private String charName;
	private int charType;

	public NewGame() {
		charName = "";
		charType = -1;
		
	}
	public NewGame(String name, int type) {
		charName = name;
		charType = type;
		createChar();
	}
	public void createChar() {
		
	}

}
