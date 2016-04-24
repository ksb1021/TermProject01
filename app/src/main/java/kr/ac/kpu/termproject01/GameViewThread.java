package kr.ac.kpu.termproject01;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * Created by Terminati on 2016-04-04.
 */
public class GameViewThread extends Thread {
    private SurfaceHolder surfaceHolder;
    private GameView gameView;
    private boolean run = false;

    public GameViewThread(SurfaceHolder surfaceHolder, GameView gameView){
        this.surfaceHolder = surfaceHolder;
        this.gameView = gameView;
    }

    public void setRunning(boolean run) {
        this.run = run;
    }

    @Override
    public void run() {
        Canvas canvas;
        while(run) {
            canvas = null;
            try{
                gameView.Update();
                canvas = surfaceHolder.lockCanvas(null);
                synchronized (surfaceHolder) {
                    gameView.OnDraw(canvas);
                }
            }finally {
                if(canvas != null) {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }
}
