package kr.ac.kpu.termproject01;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by Terminati on 2016-04-07.
 */
public class SpriteAnimation extends GraphicObject {
    private Rect sRectangle;
    private int FPS;
    private int numOfFrames;
    private int currentFrame;

    private long frameTimer;

    private int spriteHeight;
    private int spriteWidth;

    protected boolean reply = true;
    protected boolean end = false;

    public SpriteAnimation(Bitmap bitmap) {
        super(bitmap);
        sRectangle = new Rect(0, 0, 0, 0);
        frameTimer = 0;
        currentFrame = 0;
    }

    public void InitSpriteData(int height, int width, int theFPS, int theFrameCnt) {
        spriteHeight = height;
        spriteWidth = width;
        sRectangle.top = 0;
        sRectangle.bottom = spriteHeight;
        sRectangle.left = 0;
        sRectangle.right = spriteWidth;
        FPS = theFPS;
        numOfFrames = theFrameCnt;
    }

    @Override
    public void Draw(Canvas canvas) {
        Rect dest = new Rect(x, y, x + spriteWidth, y + spriteHeight);
        canvas.drawBitmap(bitmap, sRectangle, dest, null);
    }

    public void Update(long GameTime) {
        if(!end) {
            if(GameTime > frameTimer + FPS) {
                frameTimer = GameTime;
                currentFrame += 1;

                if(currentFrame >= numOfFrames) {
                    if(reply) currentFrame = 0;
                    else end = true;
                }
            }
        }
        sRectangle.left = currentFrame * spriteWidth;
        sRectangle.right = sRectangle.left + spriteWidth;
    }

    public boolean getAnimationEnd() { return end; }
}
