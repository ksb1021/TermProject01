package kr.ac.kpu.termproject01;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by Terminati on 2016-04-04.
 */
public class GameManager {
    private GameView gameView;
    private Resources resources;

    void setGameView(GameView _gameView) { gameView = _gameView; }
    void setResources(Resources _resources) { resources = _resources; }
    public GameView getGameView() { return gameView; }
    public Resources getResources() { return resources; }
    public Bitmap getBitmap(int r) { return BitmapFactory.decodeResource(resources, r); }


    private static GameManager instance;
    public static GameManager getInstance() {
        if(instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

}
