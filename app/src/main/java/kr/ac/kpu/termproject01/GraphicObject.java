package kr.ac.kpu.termproject01;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Terminati on 2016-04-07.
 */
public class GraphicObject {
    protected Bitmap   bitmap;
    protected int      x;
    protected int      y;

    public GraphicObject(Bitmap bitmap) {
        this.bitmap = bitmap;
        x = 0;
        y = 0;
    }

    public void Draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, x, y, null);
    }

    public void SetPosition(int x, int y) {
        this.x = x;    this.y = y;
    }

    public int GetX() { return x; }
    public int GetY() { return y; }
}
