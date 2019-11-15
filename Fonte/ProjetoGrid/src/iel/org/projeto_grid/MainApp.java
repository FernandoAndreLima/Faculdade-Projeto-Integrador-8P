package iel.org.projeto_grid;

import java.io.IOException;

import iel.org.projeto_grid.model.entities.Person;
import iel.org.projeto_grid.views.GradeGerarOverviewController;
import iel.org.projeto_grid.views.PersonEditDialogController;
import iel.org.projeto_grid.views.login.LoginOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {
	

	private Stage primaryStage;
	private BorderPane rootLayout;
	
	/**
	 * Os dados estarão como uma observable list de Persons
	 */
	private ObservableList<Person> personData = FXCollections.observableArrayList();
	
	/**
	 * Constructor
	 */
	public MainApp() {}
		
	@Override
	public void start(Stage primaryStage) {

		
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Projeto Grid");
		this.primaryStage.getIcons().add(new Image("file:resources/images/icone.png"));
		
		initRootLayout();
//		showPersonOverview();
//		showGradeGerarOverview();
		showLoginOverview();
	}

	private void showLoginOverview() {
		try {
			//carrega o loginOverview
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("views/login/LoginOverview.fxml"));
			AnchorPane loginOverview = (AnchorPane) loader.load();
			
			//define o loginOverview dentro do root layout
			rootLayout.setCenter(loginOverview);
			
	        // Dá ao controlador acesso à the main app.
	        LoginOverviewController controller = loader.getController();
	        controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Inicializa o root layout
	 */
	private void initRootLayout() {
		try {
			//carrega o rootlayout do arquivo fxml
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("views/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			//mostra a scene contendo o rootlayout
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	@SuppressWarnings("unused")
	private void showGradeGerarOverview() {
		/*
		 * Menu grade
		 */
		Menu gradeMenu = new Menu("Grade");
		
		gradeMenu.getItems().add(new MenuItem("Gerar Grade"));
		gradeMenu.getItems().add(new MenuItem("Visualizar grades geradas"));
		gradeMenu.getItems().add(new MenuItem("Teste"));
		
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(gradeMenu); 
		rootLayout.setTop(menuBar);
		
		
		try {
			//carrega o person overview
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("views/GradeGerarOverview.fxml"));
			AnchorPane gradeGerarOverview = (AnchorPane) loader.load();
			
			//define o personoverview dentro do root layout
			rootLayout.setCenter(gradeGerarOverview);
			
	        // Dá ao controlador acesso à the main app.
	        GradeGerarOverviewController controller = loader.getController();
	        controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	


	/**
	 * Abre uma janela para editar detalhes para a pessoa especificada. Se o usuário clicar
	 * OK, as mudanças são salvasno objeto pessoa fornecido e retorna true.
	 * 
	 * @param person O objeto pessoa a ser editado
	 * @return true Se o usuário clicou OK,  caso contrário false.
	 */
	public boolean showPersonEditDialog(Person person) {
	    try {
	        // Carrega o arquivo fxml e cria um novo stage para a janela popup.
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("views/PersonEditDialog.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();

	        // Cria o palco dialogStage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Edit Person");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        // Define a pessoa no controller.
	        PersonEditDialogController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setPerson(person);

	        // Mostra a janela e espera até o usuário fechar.
	        dialogStage.showAndWait();

	        return controller.isOkClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	/**
	 * Retorna o palco principal
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}


	public static void main(String[] args) {
		launch(args);
	}

	public ObservableList<Person> getPersonData() {
		return personData;
	}
}


///**
// * Constructor
// */
//public MainApp() {
//    // Add some sample data
//    getPersonData().add(new Person("Hans", "Muster"));
//    getPersonData().add(new Person("Ruth", "Mueller"));
//    getPersonData().add(new Person("Heinz", "Kurz"));
//    getPersonData().add(new Person("Cornelia", "Meier"));
//    getPersonData().add(new Person("Werner", "Meyer"));
//    getPersonData().add(new Person("Lydia", "Kunz"));
//    getPersonData().add(new Person("Anna", "Best"));
//    getPersonData().add(new Person("Stefan", "Meier"));
//    getPersonData().add(new Person("Martin", "Mueller"));
//}

///**
//* Mostra o person overview do root layout
//*/
//private void showPersonOverview() {
//	try {
//		//carrega o person overview
//		FXMLLoader loader = new FXMLLoader();
//		loader.setLocation(MainApp.class.getResource("views/PersonOverview.fxml"));
//		AnchorPane personOverview = (AnchorPane) loader.load();
//		
//		//define o personoverview dentro do root layout
//		rootLayout.setCenter(personOverview);
//		
//       // Dá ao controlador acesso à the main app.
//       PersonOverviewController controller = loader.getController();
//       controller.setMainApp(this);
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
//}
///**
// * Abre uma janela para editar detalhes para a pessoa especificada. Se o usuário clicar
// * OK, as mudanças são salvasno objeto pessoa fornecido e retorna true.
// * 
// * @param person O objeto pessoa a ser editado
// * @return true Se o usuário clicou OK,  caso contrário false.
// */
//public boolean showPersonEditDialog(Person person) {
//    try {
//        // Carrega o arquivo fxml e cria um novo stage para a janela popup.
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(MainApp.class.getResource("views/PersonEditDialog.fxml"));
//        AnchorPane page = (AnchorPane) loader.load();
//
//        // Cria o palco dialogStage.
//        Stage dialogStage = new Stage();
//        dialogStage.setTitle("Edit Person");
//        dialogStage.initModality(Modality.WINDOW_MODAL);
//        dialogStage.initOwner(primaryStage);
//        Scene scene = new Scene(page);
//        dialogStage.setScene(scene);
//
//        // Define a pessoa no controller.
//        PersonEditDialogController controller = loader.getController();
//        controller.setDialogStage(dialogStage);
//        controller.setPerson(person);
//
//        // Mostra a janela e espera até o usuário fechar.
//        dialogStage.showAndWait();
//
//        return controller.isOkClicked();
//    } catch (IOException e) {
//        e.printStackTrace();
//        return false;
//    }
//}
