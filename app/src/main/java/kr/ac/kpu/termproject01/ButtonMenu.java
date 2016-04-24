package kr.ac.kpu.termproject01;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Terminati on 2016-04-24.
 */
public class ButtonMenu extends GraphicObject {
    private boolean isPressed = false;

    public ButtonMenu(int x, int y) {
        super(GameManager.getInstance().getBitmap(R.drawable.btn_menu_u));
        SetPosition(x, y);
    }
    void Update(long GameTime) {
        if(isPressed == false) super.bitmap = GameManager.getInstance().getBitmap(R.drawable.btn_menu_u);
        else super.bitmap = GameManager.getInstance().getBitmap(R.drawable.btn_menu_d);
    }

    public void buttonPressed() {
        isPressed = true;
    }

    public void buttonPop() {
        isPressed = false;
    }

    @Override
    public void Draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, x, y, null);
    }
}
