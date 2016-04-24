package kr.ac.kpu.termproject01;

import android.graphics.Canvas;

/**
 * Created by Terminati on 2016-04-24.
 */
public class BaseUI extends GraphicObject  {

    public BaseUI() {
        super(GameManager.getInstance().getBitmap(R.drawable.base_gui));
        SetPosition(0, 0);
    }
    void Update(long GameTime) {

    }
    @Override
    public void Draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, x, y, null);
    }
}
