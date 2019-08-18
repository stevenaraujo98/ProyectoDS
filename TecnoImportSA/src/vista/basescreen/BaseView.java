/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.basescreen;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author 
 */
public class BaseView extends BorderPane {
    private MenuDrawing menu;
    private StackPane home;
    private Text titleHome;
    private Text subtitleHome;
    private StackPane logOut;
    private Stage stage;
    
    public BaseView(){
        menu = new MenuDrawing();
        VBox menuContent = new VBox(new Rectangle(10, 5, Color.TRANSPARENT), menu); 
        this.setRight(menuContent);
        home = new StackPane();
        logOut = new StackPane();
        stage = new Stage();
        stage.setScene(new Scene(this)); 
        topPane();
    }
    
    private void topPane() {
        StackPane topContent = new StackPane();
        backgorundTopPane(topContent);
        this.setTop(topContent); 
        homeButton();
        double size = Const.MAX_HEIGHT * 0.175 * 0.55;
        ImageView iv = new ImageView(
                new Image(BaseView.class.getResourceAsStream("/recursos/icons/user.png"), size, size, true, true));
        HBox box = new HBox(10, iv, home);
        box.setAlignment(Pos.CENTER);
        box.setTranslateX(20); 
        topContent.setAlignment(Pos.CENTER_LEFT); 
        buttonLogOut();
        HBox hbox = new HBox(Const.MAX_WIDTH * 0.65, box, logOut); 
        topContent.getChildren().add(hbox);           
    }
    
    private void backgorundTopPane(StackPane topContent){
        Rectangle rectangle = new Rectangle(Const.MAX_WIDTH, Const.MAX_HEIGHT * 0.175);
        rectangle.setFill(Color.rgb(224, 224, 224));
        rectangle.setArcHeight(10);
        rectangle.setArcWidth(10); 
        DropShadow shadow = new DropShadow();
        shadow.setOffsetX(-5);
        shadow.setOffsetY(-5);
        shadow.setRadius(20); 
        rectangle.setEffect(shadow); 
        topContent.getChildren().add(rectangle);
    }
    
     private void homeButton() {
        int[] shadow = {-5, 5, 5};
        Rectangle background = backformat(0.18, 0.09625, shadow, Color.rgb(182, 182, 182));
        background.setFill(Color.rgb(245, 245, 245));
        titleHome = new Text("TITLE");
        titleHome.setStyle(Const.FONT_BOLD); 
        subtitleHome = new Text("subtitulo");
        VBox vb = new VBox(5, titleHome, subtitleHome);
        vb.setAlignment(Pos.CENTER_LEFT); 
        vb.setTranslateX(20); 
        home.setAlignment(Pos.CENTER_LEFT);
        home.getChildren().addAll(background, vb);
        evtHome(background);
    }
    
    private void evtHome(Rectangle r) {
        home.setOnMouseEntered(e-> home.setCursor(Cursor.HAND));
        home.setOnMouseExited(e-> home.setCursor(Cursor.DEFAULT)); 
        home.setOnMousePressed(e-> r.setFill(Color.rgb(230, 230, 230)));
        home.setOnMouseReleased(e-> r.setFill(Color.rgb(245, 245, 245)));
    }
    
    private void buttonLogOut() {
        int [] shadow = {-3, 3, 5};
        Rectangle backgroung = backformat(0.072, 0.05775, shadow, Color.rgb(169, 182, 183));
        backgroung.setFill(Color.rgb(34, 184, 204));
        Text logautText = new Text("LogOut");
        logautText.setFont(Font.font(logautText.getFont().getFamily(), FontWeight.SEMI_BOLD, 14));
        ImageView icon = new ImageView(
                new Image(BaseView.class.getResourceAsStream("/recursos/icons/logout.png"), 15, 15, true, true));
        HBox contentBtn = new HBox(2, icon, logautText);
        contentBtn.setAlignment(Pos.CENTER); 
        logOut.getChildren().addAll(backgroung, contentBtn);
        logOut.setAlignment(Pos.CENTER); 
        evtLogOut(backgroung);
    }
    
    private Rectangle backformat(double width, double height, int[] shadowPos, Color shadow){
        Rectangle backgroung = new Rectangle(Const.MAX_WIDTH * width, Const.MAX_HEIGHT * height);
        DropShadow effect = new DropShadow();
        effect.setOffsetX(shadowPos[0]); 
        effect.setOffsetY(shadowPos[1]);
        effect.setRadius(shadowPos[2]);
        effect.setColor(shadow); 
        backgroung.setEffect(effect);
        return backgroung;
    }
    
    private void evtLogOut(Rectangle r) {
        logOut.setOnMouseEntered(e-> logOut.setCursor(Cursor.HAND));
        logOut.setOnMouseExited(e-> logOut.setCursor(Cursor.DEFAULT)); 
        logOut.setOnMousePressed(e-> r.setFill(Color.rgb(22, 172, 192)));
        logOut.setOnMouseReleased(e-> r.setFill(Color.rgb(34, 184, 204)));
    }
    
    /**
     * Cambia el titulo de la pantalla
     * @param title - nuevo titulo
     */
    public void setTitle(String title){
        stage.setTitle(title); 
    }
    
    /**
     * Cambia el titulo del boton de home
     * @param titleHome - nuevo titulo
     */
    public void setTitleHome(String titleHome){
        this.titleHome.setText(titleHome);
    }
    
    
    /**
     * Cambia el subtitulo del boton de home 
     * @param subtitleHome - nuebo subtitulo
     */
    public void setSubtitleHome(String subtitleHome){
        this.subtitleHome.setText(subtitleHome); 
    }
    
    /**
     * Evento al hacer click en el boton de logOut
     * @param event - accion a realizar
     */
    public void setOnLogOutAction(EventHandler<MouseEvent> event){
        logOut.setOnMouseClicked(event);
    }
    
    /**
     * Evento al hacer click en el boton de home
     * @param event - accion a realizar
     */
    public void setOnHomeAction(EventHandler<MouseEvent> event){
        home.setOnMouseClicked(event);
    }
    
    /**
     * Cambia el menu latearal izquierdo
     * @param menu - nuevo menu
     */
    public void setMenu(MenuDrawing menu){
        this.menu = menu;
    }
    
    /**
     * Dvuelve le menu lateral izquierdo
     * @return MenuDrawing
     */
    public MenuDrawing getMenu(){
        return this.menu;
    }
    
    public void show() {
        this.stage.show();
    }
    
    public void close(){
        this.stage.close();
    }
}
