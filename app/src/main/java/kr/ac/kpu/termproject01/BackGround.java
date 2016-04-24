package kr.ac.kpu.termproject01;

import android.graphics.Canvas;
/**
 * Created by Terminati on 2016-04-14.
 */

public class BackGround extends GraphicObject {
    public BackGround() {
        super(GameManager.getInstance().getBitmap(R.drawable.background));
        SetPosition(0, 0);
    }
    void Update(long GameTime) {

    }
    @Override
    public void Draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, x, y, null);
    }
}
