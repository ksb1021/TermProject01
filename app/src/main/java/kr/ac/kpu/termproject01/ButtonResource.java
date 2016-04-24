package kr.ac.kpu.termproject01;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Terminati on 2016-04-24.
 */
public class ButtonResource extends GraphicObject {
    private Bitmap icon;
    private boolean isPressed = false;

    public ButtonResource(int x, int y, int numRes) {
        super(GameManager.getInstance().getBitmap(R.drawable.btn_res_u));
        SetPosition(x, y);
        setIcon(numRes);
    }

    void Update(long GameTime) {
        if(isPressed == false) super.bitmap = GameManager.getInstance().getBitmap(R.drawable.btn_res_u);
        else super.bitmap = GameManager.getInstance().getBitmap(R.drawable.btn_res_d);
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
        canvas.drawBitmap(icon, x, y, null);
    }

    private void setIcon(int numRes) {
        switch(numRes) {
            case 0:
                icon = GameManager.getInstance().getBitmap(R.drawable.res00);
                break;
            case 1:
                icon = GameManager.getInstance().getBitmap(R.drawable.res01);
                break;
            case 2:
                icon = GameManager.getInstance().getBitmap(R.drawable.res02);
                break;
            case 3:
                icon = GameManager.getInstance().getBitmap(R.drawable.res03);
                break;
            case 4:
                icon = GameManager.getInstance().getBitmap(R.drawable.res04);
                break;
            case 5:
                icon = GameManager.getInstance().getBitmap(R.drawable.res05);
                break;
            case 10:
                icon = GameManager.getInstance().getBitmap(R.drawable.res10);
                break;
            case 11:
                icon = GameManager.getInstance().getBitmap(R.drawable.res11);
                break;
            case 12:
                icon = GameManager.getInstance().getBitmap(R.drawable.res12);
                break;
            case 13:
                icon = GameManager.getInstance().getBitmap(R.drawable.res13);
                break;
            case 14:
                icon = GameManager.getInstance().getBitmap(R.drawable.res14);
                break;
            case 15:
                icon = GameManager.getInstance().getBitmap(R.drawable.res15);
                break;
        }
    }
}
