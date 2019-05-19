import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void doSomething(){
        System.out.println("DO OSksdfljkljf");
    }


    static {
        System.out.println("First Static Initializer");
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static String something = returnSomething();

    public static String returnSomething() {
        System.out.println("Static Variable Initializing");
        return "IJSE";
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/dashboard.fxml"));
        Scene mainScene = new Scene(root);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Template POS System");
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    static{
        System.out.println("Last Static Initializer");
    }
}
