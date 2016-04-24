package kr.ac.kpu.termproject01;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Terminati on 2016-04-24.
 */
public class MenuUI extends GraphicObject  {
    private boolean isHidden = true;
    private Bitmap shade;

    public MenuUI() {
        super(GameManager.getInstance().getBitmap(R.drawable.menu_gui));
        shade = GameManager.getInstance().getBitmap(R.drawable.shade_paused);
        SetPosition(0, 0);
    }
    void Update(long GameTime) {

    }


    @Override
    public void Draw(Canvas canvas) {
        if(isHidden == false) {
            canvas.drawBitmap(shade, x, y, null);
            canvas.drawBitmap(bitmap, x, y, null);
        }
    }

    public void SetHidden(boolean setHidden) {
        isHidden = setHidden;
    }

    public boolean GetHidden() {
        return isHidden;
    }
}
