package kr.ac.kpu.termproject01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Terminati on 2016-04-04.
 */
public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private GameViewThread thread;
    private IState state;


    public GameView(Context context){
        super(context);

        setFocusable(true);

        GameManager.getInstance().setGameView(this);
        GameManager.getInstance().setResources(getResources());

        ChangeGameState(new GameState());

        getHolder().addCallback(this);
        thread = new GameViewThread(getHolder(), this);
    }

    public void OnDraw(Canvas canvas){
        canvas.drawColor(Color.BLACK);
        state.Render(canvas);
    }

    public void Update() {
        state.Update();
    }
    public void ChangeGameState(IState state) {
        if(this.state != null) state.Destroy();
        state.Init();
        this.state = state;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread.setRunning(true);
        thread.start();
    }
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        thread.setRunning(false);
        while (retry) {
            try {
                thread.join();
                retry = false;
            } catch (InterruptedException e) {

            }
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        state.onTouchEvent(event);
        return true;
    }
}
