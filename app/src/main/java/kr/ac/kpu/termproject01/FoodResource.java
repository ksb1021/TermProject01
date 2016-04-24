package kr.ac.kpu.termproject01;

import android.graphics.Canvas;

/**
 * Created by Terminati on 2016-04-24.
 */
public class FoodResource extends GraphicObject {

    public FoodResource(int x, int y, int numRes) {
        super(GameManager.getInstance().getBitmap(R.drawable.background));
        SetPosition(x, y);
        setBitmap(numRes);
    }

    void Update(long GameTime) {

    }

    @Override
    public void Draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, x, y, null);
    }

    public void setBitmap(int numRes) {
        switch(numRes) {
            case 0:
                super.bitmap = GameManager.getInstance().getBitmap(R.drawable.res00resized);
                break;
            case 1:
                super.bitmap = GameManager.getInstance().getBitmap(R.drawable.res01resized);
                break;
            case 2:
                super.bitmap = GameManager.getInstance().getBitmap(R.drawable.res02resized);
                break;
            case 3:
                super.bitmap = GameManager.getInstance().getBitmap(R.drawable.res03resized);
                break;
            case 4:
                super.bitmap = GameManager.getInstance().getBitmap(R.drawable.res04resized);
                break;
            case 5:
                super.bitmap = GameManager.getInstance().getBitmap(R.drawable.res05resized);
                break;
            case 10:
                super.bitmap = GameManager.getInstance().getBitmap(R.drawable.res10resized);
                break;
            case 11:
                super.bitmap = GameManager.getInstance().getBitmap(R.drawable.res11resized);
                break;
            case 12:
                super.bitmap = GameManager.getInstance().getBitmap(R.drawable.res12resized);
                break;
            case 13:
                super.bitmap = GameManager.getInstance().getBitmap(R.drawable.res13resized);
                break;
            case 14:
                super.bitmap = GameManager.getInstance().getBitmap(R.drawable.res14resized);
                break;
            case 15:
                super.bitmap = GameManager.getInstance().getBitmap(R.drawable.res15resized);
                break;
            default:
                super.bitmap = GameManager.getInstance().getBitmap(R.drawable.res_empty);
        }
    }
}
