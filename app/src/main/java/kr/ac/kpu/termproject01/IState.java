package kr.ac.kpu.termproject01;

import android.graphics.Canvas;
import android.view.KeyEvent;
import android.view.MotionEvent;
/**
 * Created by Terminati on 2016-04-07.
 */
public interface IState {
    public void Init();
    public void Destroy();
    public void Update();
    public void Render(Canvas canvas);
    public boolean onTouchEvent(MotionEvent event);
}
