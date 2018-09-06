package sample;

import java.io.File;
import java.io.InputStream;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {
    private static final int COLUMNS =8;
    private static final int COUNT =61;
    private static final int OFFSET_X =0;
    private static final int OFFSET_Y=0;
    private static final int WIDTH =50;
    private static final int HEIGHT =50;




    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello World");
        AnchorPane root = new AnchorPane();
        File fl = new File("D:/Java/AnimationTest/src/sample/13_vortex_spritesheet.png");
        Image IMAGE = new Image(fl.toURI().toString());
        ImageView imv =new ImageView(IMAGE);
        imv.setViewport(new Rectangle2D(OFFSET_X,OFFSET_Y,WIDTH,HEIGHT));
        final Animation animation = new anim.SpriteAnimation(imv,Duration.millis(3000),
                COUNT, COLUMNS,OFFSET_X,OFFSET_Y,WIDTH,HEIGHT);
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
        Scene scene =  new Scene(root,800,500);
        Circle circle = new Circle(125,126,40,new Color(0,0,1,0.4));
        circle.setRadius(18);
        imv.setX( 100);
        imv.setY(100);
        root.getChildren().add(circle);
        root.getChildren().add(imv);
        primaryStage.setScene(scene);
        primaryStage.show();
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                imv.setX(imv.getX() +1);
                imv.setY(imv.getY() +1);
                circle.setCenterX(circle.getCenterX()+1);
                circle.setCenterY(circle.getCenterY()+1);
            }
        };
        animationTimer.start();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
