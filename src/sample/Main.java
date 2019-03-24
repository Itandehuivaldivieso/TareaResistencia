package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application{
    Pane posss= new Pane();

    @Override
    public void start(Stage primaryStage) throws Exception{

        posss.getStyleClass().add("centro");
        BorderPane root = new BorderPane();
        primaryStage.setTitle("Resistencias");
        Scene scenaP = new Scene(root, 540, 300);
        scenaP.getStylesheets().add("/sample/pru.css");
        primaryStage.setScene(scenaP);
        primaryStage.show();
        root.setTop(rectangulos());
        GridPane centro =bandaColor(0);
        centro.getStyleClass().add("centro");
        root.setCenter(centro);
        //Vbox para los radioButtons
        VBox izq = new VBox();

        //izq.setStyle("-fx-background-color: #9a9d89");
        izq.setPadding(new Insets(10, 10, 10, 10));
        izq.getStyleClass().add("centro");
        //Boton distancia
        ToggleGroup opciones = new ToggleGroup();
        RadioButton cuBa = new RadioButton("4 Bandas");
        cuBa.setToggleGroup(opciones);
        cuBa.setPadding(new Insets(2,0,2,0));
        cuBa.setFont(Font.font("Century Gothic", FontWeight.BLACK, 12));
        cuBa.setTextFill(Color.WHITE);
        //Boton velocidad
        RadioButton cinBand = new RadioButton("5 Bandas");
        cinBand.setPadding(new Insets(2,0,2,0));
        cinBand.setFont(Font.font("Century Gothic", FontWeight.BLACK, 12));
        cinBand.setStyle("-fx-font-size: 12");
        cinBand.setToggleGroup(opciones);
        cinBand.setTextFill(Color.WHITE);
        //Boton tiempo
        RadioButton seBa    = new RadioButton("6 Bandas");
        seBa.setPadding(new Insets(10,0,10,0));
        seBa.setFont(Font.font("Century Gothic", FontWeight.BLACK, 12));
        seBa.setTextFill(Color.WHITE);
        seBa.setToggleGroup(opciones);


        //Evento listener para saber que radioButton se seleccionó
        opciones.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
        {
            public void changed(ObservableValue<? extends Toggle> ob,
                                Toggle o, Toggle n)
            {
                GridPane centro = null;

                RadioButton rb = (RadioButton)opciones.getSelectedToggle();
                if (rb != null) {
                    String s = rb.getText();
                    if (s == "4 Bandas") {
                        centro = bandaColor(2);
                        centro.getStyleClass().add("centro");
                        root.setCenter(centro);
                    }
                    else if (s== "5 Bandas") {
                        centro = bandaColor(3);
                        centro.getStyleClass().add("centro");
                        root.setCenter(centro);
                    }
                    else if (s == "6 Bandas") {
                        centro = bandaColor(4);
                        centro.getStyleClass().add("centro");
                        root.setCenter(centro);
                    }
                    // change the label
                    System.out.println("SELECT" +   s);
                    //l2.setText(s + " selected");
                }
            }
        });

        //Agregación
        izq.getChildren().addAll(cuBa,cinBand,seBa);
        root.setLeft(izq);
    }

    public ArrayList<BandCo> colores(){
        ArrayList<BandCo> bandasBasicas= new ArrayList<BandCo>();
        bandasBasicas.add(new BandCo("Negro",0 ,1,0,0, Color.BLACK));
        bandasBasicas.add(new BandCo("Cafe",1,10,1,100,Color.BROWN));
        bandasBasicas.add(new BandCo("Rojo",2 ,100,2,50, Color.RED));
        bandasBasicas.add(new BandCo("Naranja",3,1000,0,15, Color.ORANGE));
        bandasBasicas.add(new BandCo("Amariilo",4 ,10000,0,25, Color.YELLOW));
        bandasBasicas.add(new BandCo("Verde",5,100000,0.5,0, Color.GREEN));
        bandasBasicas.add(new BandCo("Azul",6 ,1000000,0.25,0, Color.BLUE));
        bandasBasicas.add(new BandCo("Morado",7,10000000,0.1,0, Color.PURPLE));
        bandasBasicas.add(new BandCo("Gris",8,0,0,0, Color.GREY));
        bandasBasicas.add(new BandCo("Blanco",9,0,0,0, Color.WHITE));
        bandasBasicas.add(new BandCo("Ninguno",10 ,0,20,0, Color.BEIGE));
        bandasBasicas.add(new BandCo("Plata",11,0.01,10,0, Color.SILVER));
        bandasBasicas.add(new BandCo("Oro",12 ,.10,5,0, Color.GOLD));
        return bandasBasicas;
    }
    public Rectangle refs(int cont){
        Rectangle pos = new Rectangle();
        pos.setWidth(10);
        pos.setHeight(46);
        pos.setY(12);
        pos.setX(cont);
        return pos;
    }
    public GridPane bandaColor(int n){

        GridPane comboxColores = new GridPane();

        ArrayList<BandCo> colores1 = colores();
        String banda;
        comboxColores.setHgap(10);
        comboxColores.setVgap(10);
        comboxColores.setPadding(new Insets(0, 10, 0, 10));
        String nombres[] ={"Negro", "Cafe", "Rojo", "Naranja", "Amarillo", "Verde", "Azul", "Morado", "Gris","Blanco", "Oro", "Plata", "Ninguno"};
        String multiplicVec[] ={"Negro", "Cafe", "Rojo", "Naranja", "Amarillo", "Verde", "Azul", "Morado", "Gris", "Oro", "Plata"};
        String toleVec[] = {"Plata", "Oro", "Cafe", "Rojo", "Verde", "Azul", "Morado"};
        String tempVec[] = {"Cafe", "Rojo", "Naranja", "Amarrillo"};
        System.out.println();
        colores1= colores();
        Text banda1 = new Text("Banda 1");
        banda1.setId("text");
        comboxColores.add(banda1,1,2);
        ComboBox combo = new ComboBox();
        combo.getItems().addAll(nombres);
        combo.getSelectionModel().select(0);
        comboxColores.add(combo,2,2);


        Text banda2 = new Text("Banda 2");
        banda2.setId("text");
        comboxColores.add(banda2,1,3);
        ComboBox combo2 = new ComboBox();
        combo2.getItems().addAll(nombres);
        combo2.getSelectionModel().select(1);
        comboxColores.add(combo2,2,3);

        Text banda3 = new Text("Banda 3");
        banda3.setId("text");
        comboxColores.add(banda3,1,4);
        ComboBox combo3 = new ComboBox();
        combo3.getItems().addAll(nombres);
        combo3.getSelectionModel().select(1);
        comboxColores.add(combo3,2,4);

        Text Multiplicador = new Text("Multiplicador");
        Multiplicador.setId("text");
        comboxColores.add(Multiplicador,4,2);
        ComboBox mul = new ComboBox();
        mul.getItems().addAll(multiplicVec);
        mul.getSelectionModel().select(0);
        comboxColores.add(mul,5,2);

        Text tolerancia = new Text("Tolerancia");
        tolerancia.setId("text");
        comboxColores.add(tolerancia,4,3);
        ComboBox tol = new ComboBox();
        tol.getItems().addAll(toleVec);
        tol.getSelectionModel().select(0);
        comboxColores.add(tol,5,3);

        Text temperatura = new Text("Temperatura");
        temperatura.setId("text");
        comboxColores.add(temperatura,4,4);
        ComboBox temp = new ComboBox();
        temp.getItems().addAll(tempVec);
        temp.getSelectionModel().select(0);
        comboxColores.add(temp,5,4);

        class bandasMolochas implements EventHandler<ActionEvent>{
            public int cont,l1;
            public String val;
            public bandasMolochas(int cont, int l1){
                this.cont = cont;
                this.l1   = l1;
            }
            public String comp(int l1){
                String val1="";
                if (l1 ==1)
                    val1 =(String)combo.getValue();
                if (l1 == 2)
                    val1 = (String)combo2.getValue();
                if (l1 == 3)
                    val1 = (String)combo3.getValue();
                if (l1 ==4)
                    val1 =(String)mul.getValue();
                if (l1 == 5)
                    val1 = (String)tol.getValue();
                if (l1 == 6)
                    val1 = (String)temp.getValue();
                return val1;
            }
            @Override
            public void handle(ActionEvent actionEvent) {

                ArrayList<BandCo> colores1 = colores();
                val = comp(l1);
                int l2= combo.getItems().indexOf(val);
                Rectangle rrr2 = refs(cont);
                BandCo nnnnn = (BandCo)colores1.get(l2);
                rrr2.setFill(nnnnn.getCol());
                posss.getChildren().add(rrr2);
            }
        }
        Button enviar = new Button("Calcular");
        comboxColores.add(enviar, 5, 7);

        Text resT = new Text("Resultado");
        resT.setId("text");
        TextField resultado1 = new TextField();
        resultado1.setEditable(false);
        comboxColores.add(resT,1,7);
        comboxColores.add(resultado1, 2,7);


        combo.setOnAction(new bandasMolochas(214, 1));
        combo2.setOnAction(new bandasMolochas(230, 2));
        combo3.setOnAction(new bandasMolochas(246, 3));
        mul.setOnAction(new bandasMolochas(262, 4));
        tol.setOnAction(new bandasMolochas(278, 5));
        temp.setOnAction(new bandasMolochas(294, 6));
        enviar.setOnMouseClicked(new EventHandler<MouseEvent>() {
            ArrayList<BandCo> colores1 = colores();

            double resultado;
            String resss;
            public double ress (int n){
                String val1="";
                if (n ==1)
                    val1 =(String)combo.getValue();
                if (n == 2)
                    val1 = (String)combo2.getValue();
                if (n == 3)
                    val1 = (String)combo3.getValue();
                if (n ==4)
                    val1 =(String)mul.getValue();
                if (n == 5)
                    val1 = (String)tol.getValue();
                if (n == 6)
                    val1 = (String)temp.getValue();
                for (BandCo y: colores1) {
                    if (y.getNombre()== val1) {
                        if (n==1 || n==2 || n==3)
                            resultado = y.getBanda();
                        else if (n==4)
                            resultado = y.getMult();
                        else if (n==5)
                            resultado = y.getTol();
                        else if (n==6)
                            resultado = y.getTemp();
                    }
                }
                return resultado;
            }
            @Override
            public void handle(MouseEvent mouseEvent) {
                String conc = "";
                try {

                    if (n == 2) {
                        conc = String.valueOf((int)ress(1)) + String.valueOf((int)ress(2));
                        System.out.println("conc = " + conc);
                        resss = String.valueOf(Double.parseDouble(conc) * ress(4));
                        System.out.println("conc = " + conc);
                        resultado1.setText(resss + " +- " + String.valueOf(ress(5)));

                    }
                    if (n == 3) {
                        conc = String.valueOf((int)ress(1)) + String.valueOf((int)ress(2) + String.valueOf((int)ress(3)));
                        resss = String.valueOf(Double.parseDouble(conc) * ress(4));
                        resultado1.setText(resss + " +- " + String.valueOf(ress(5)));
                    }

                    if (n == 4){
                        conc = String.valueOf((int)ress(1)) + String.valueOf((int)ress(2) + String.valueOf((int)ress(3)));
                        resss = String.valueOf(Double.parseDouble(conc) * ress(4));
                        resultado1.setText(resss + " +- " + String.valueOf(ress(5)) + " " + String.valueOf(ress(6) + " ppm"));
                    }

                }catch (Exception e){
                    System.out.println("e = " + e);
            }

            }
        });

            if(n==0) {
                combo.setVisible(false);
                combo2.setVisible(false);
                combo3.setVisible(false);
                mul.setVisible(false);
                tol.setVisible(false);
                temp.setVisible(false);
                enviar.setDisable(true);
            }
            if(n==2) {
                banda3.setVisible(false);
                combo3.setVisible(false);
                temperatura.setVisible(false);
                temp.setVisible(false);
            }
            if (n==3)
                temperatura.setVisible(false);
                temp.setVisible(false);
            if (n==4)
                temp.setVisible(true);

        return comboxColores;
    }
    public Pane rectangulos(){
        posss.setStyle("-fx-background-color: white");
        ImageView imagenResistencia = new ImageView(
                new Image(getClass().getClassLoader().getResourceAsStream("r1.jpg")));
        imagenResistencia.setPreserveRatio(true);
        imagenResistencia.setFitHeight(100);
        imagenResistencia.setFitWidth(250);
        imagenResistencia.setX(140);
        imagenResistencia.setY(5);
        posss.getChildren().add(imagenResistencia);
        return posss;
    }
    public static void main(String[] args) {
        launch(args);
    }

    public class BandCo{
        public String nombre;
        public int banda, temp;
        public double mult, tol;
        public Color col;

        public BandCo(String nombre, int banda, double mult, double tol, int temp, Color col){
            this.nombre = nombre;
            this.banda  = banda;
            this.mult   = mult;
            this.tol    = tol;
            this.temp   = temp;
            this.col    = col;
        }
        public BandCo(String nombre){
            this.nombre = nombre;
        }
        public BandCo(){
            
        }
        public Color getCol() {
            return col;
        }

        public String getNombre() {
            return nombre;
        }

        public int getBanda() {
            return banda;
        }

        public double getMult() {
            return mult;
        }

        public double getTol() {
            return tol;
        }

        public int getTemp() {
            return temp;
        }
    }
}
