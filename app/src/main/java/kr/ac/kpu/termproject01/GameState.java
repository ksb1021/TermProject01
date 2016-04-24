package kr.ac.kpu.termproject01;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
/**
 * Created by Terminati on 2016-04-11.
 */
public class GameState implements IState {
    //Basic UI
    private BackGround background;
    private BaseUI baseUI;

    //Resources
    private int currentStack = 0;
    private FoodResource foodRes[];

    //Buttons
    private ButtonMenu btnMenu;
    private ButtonResource btnRes[][];

    //Hidden GUI
    private MenuUI menuUI;


    @Override
    public void Init() {
        //Basic UI
        background = new BackGround();
        baseUI = new BaseUI();

        //Resources
        foodRes = new FoodResource[5];
        for(int i = 0; i < 5; i++) {
            foodRes[i] = new FoodResource(48, 288 - (6 * i), -1);
        }

        //Buttons
        btnMenu = new ButtonMenu(288, 0);
        btnRes = new ButtonResource[2][6];
        for(int x = 0; x < 2; x++) {
            for(int y = 0; y < 6; y++){
                btnRes[x][y] = new ButtonResource(0 + (x * 272), 288 + (y*32), (x * 10) + y);
            }
        }

        //Hidden GUI
        menuUI = new MenuUI();
    }

    @Override
    public void Destroy() {

    }

    @Override
    public void Update() {
        long GameTime = System.currentTimeMillis();
        //Basic UI
        background.Update(GameTime);
        baseUI.Update(GameTime);

        //Resources
        for(int i = 0; i < 5; i++) {
            foodRes[i].Update(GameTime);
        }

        //Buttons
        btnMenu.Update(GameTime);
        for(int x = 0; x < 2; x++) {
            for(int y = 0; y < 6; y++){
                btnRes[x][y].Update(GameTime);
            }
        }

        //Hidden GUI
        menuUI.Update(GameTime);
    }

    @Override
    public void Render(Canvas canvas) {
        //Basic UI
        background.Draw(canvas);
        baseUI.Draw(canvas);

        //Resources
        for(int i = 0; i < 5; i++) {
            foodRes[i].Draw(canvas);
        }

        //Buttons
        btnMenu.Draw(canvas);
        for(int x = 0; x < 2; x++) {
            for(int y = 0; y < 6; y++){
                btnRes[x][y].Draw(canvas);
            }
        }

        //Hidden GUI
        menuUI.Draw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int px = (int)event.getX();
        int py = (int)event.getY();

        checkMenu(px, py, event);
        checkRes(px, py, event);

        return true;
    }


    private void checkMenu(int px, int py, MotionEvent event) {
        int action = event.getAction();

        Rect rectMenu = new Rect(288, 0, 288 + 32, 0 + 32);

        if(rectMenu.contains(px, py)) {
            if(action==MotionEvent.ACTION_DOWN) {
                btnMenu.buttonPressed();
            }
            else if(action==MotionEvent.ACTION_UP){
                btnMenu.buttonPop();
                if(menuUI.GetHidden() == true)menuUI.SetHidden(false);
                else menuUI.SetHidden(true);
            }
        }
    }

    private void checkRes(int px, int py, MotionEvent event) {
        int action = event.getAction();
        Rect rectRes[][];
        rectRes = new Rect[2][6];

        for(int x = 0; x < 2; x++) {
            for(int y = 0; y < 6; y++){
                rectRes[x][y] = new Rect(0 + (x * 272), 288 + (y*32), 0 + (x * 272) + 48, 288 + (y*32) + 32);
            }
        }

        for(int x = 0; x < 2; x++) {
            for(int y = 0; y < 6; y++){
                if(rectRes[x][y].contains(px, py)) {
                    if(action==MotionEvent.ACTION_DOWN) {
                        btnRes[x][y].buttonPressed();
                    }
                    else if(action==MotionEvent.ACTION_UP){
                        btnRes[x][y].buttonPop();
                        if(currentStack < 5) {
                            foodRes[currentStack].setBitmap((x * 10) + y);
                            currentStack++;
                        }
                    }
                }
            }
        }
    }
}
