package tw.com.ei.myviewtest2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2017/8/2.
 */

public class MyView extends View {
    private Resources res;
    private Bitmap ball;
    private int height,width;
    private boolean isInit;
    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        res=context.getResources();
        setBackgroundResource(R.drawable.mybg);//會縮放
        //放在onDraw會每分每秒，每一次都會載入一次
        ball=BitmapFactory.decodeResource(res,R.drawable.ball);
        height=getHeight();
        width=getWidth();//建構子內還沒有寬高
        Log.i("simon",height+","+width);

    }
    private void init(){
        //第一次載入的時候設定初始化參數等等
        isInit=true;
        height=getHeight();
        width=getWidth();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInit) init();

        //onDraw盡量只做繪圖的動作，呈現圖的動作就拿掉...拿到上面...
        //在onDraw內 drawBitmap-->原圖大小呈現
        //Bitmap bg=BitmapFactory.decodeResource(res,R.drawable.mybg);
        canvas.drawBitmap(ball, 0, 0, null);//原圖
        /* 因為每次都會重拿VIEW的寬高，所以直接判斷如果第一次載入，再拿就好...
        height=getHeight();
        width=getWidth();
        Log.i("simon",height+","+width);
        */


    }
}
