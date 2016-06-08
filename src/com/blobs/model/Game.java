package com.blobs.model;
import java.util.Timer;

import com.blobs.view.IView;
import com.blobs.view.View;

public class Game implements IModel{
	
	private Timer spawnTimer;
	private Timer gameTimer;
	private Gamefield field;
	private int score;
	private IView view;
	
	public static void main(String[] args) {
		View v = new View();
		Game g = new Game(v);
		g.startGame();
	}
	
	public Game(IView view) {
		this.view = view;
		reset();
	}
	
	private void reset() {
		this.field = new Gamefield(3,3);
		this.gameTimer = new Timer();
		this.spawnTimer = new Timer();
		this.score = 0;
	}
	
	public void killBlob(int id) {
		this.score += this.field.getBlobScore(id);
		this.field.removeBlob(id);
		//call to view
	}
	
	public void gameOver() {
		System.out.println("Game Over");
		this.gameTimer.cancel();
		this.spawnTimer.cancel();
		// gameOver
	}
	
	public void addBlob() {
		int location = this.field.addBlob();
		// call to view
	}

	@Override
	public void startGame() {
		this.gameTimer.scheduleAtFixedRate(new CheckGameTask(this, this.field), 50, 50);
		this.spawnTimer.schedule(new NewBlobTask(this, this.spawnTimer, 2000), 2000);
		
	}

	@Override
	public void restartGame() {
		this.reset();
		this.startGame();
	}

	@Override
	public void submitHighscore(String name, int score) {
		// TODO Auto-generated method stub
		
	}
}
