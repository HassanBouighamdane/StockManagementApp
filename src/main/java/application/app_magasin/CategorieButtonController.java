package application.app_magasin;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CategorieButtonController {
    @FXML
    private Button categoryButton;

    @FXML
    private ImageView categoryImage;

    public void setCategoryImage(Image image) {
        categoryImage.setImage(image);
    }
}
