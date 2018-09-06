package anim;

import javafx.animation.Transition;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class SpriteAnimation extends Transition {
    private final ImageView imageView;
    private final int count;
    private final int columns;
    private final int offsetX;
    private final int offsetY;
    private final int widht;
    private final int height;
    double index1;

    public SpriteAnimation(
            ImageView imageView,
            Duration duration,
            int count,int columns,
            int offsetX, int offsetY,
            int widht, int height) {
        this.imageView  = imageView;
        this.count =count;
        this.columns =columns;
        this.offsetX =offsetX;
        this.offsetY = offsetY;
        this.widht =widht;
        this.height = height;
        setCycleDuration(duration);
        index1=0;

    }
    protected void interpolate(double k){
        int index =Math.min((int)Math.round(Math.floor(k*count)),count-1);
        index1 = index1+0.5;
        if(index1>=count)
            index1=0;
        index = (int)(index1);
        final  int x = (index%columns)*widht+offsetX;
        final int y =(index/columns)*height + offsetY;
        imageView.setViewport(new Rectangle2D(x,y,widht,height));
    }
}
