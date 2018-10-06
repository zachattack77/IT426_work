package controller;

import javafx.scene.paint.Color;
import model.ColorPair;
import model.FileData;
import model.IColorsData;
import model.InMemoryData;

import java.util.List;

public class Controller
{

    private IColorsData model;

    public Controller(){
        model = new FileData("files/colors.dat");//new InMemoryData();
    }

    //this function wll accept date from the view and pass it to the model
    public boolean handleNewColor(String name, Color color){

        //preform a little validation
        if (name == null || name.equals("") || color == null)
        {
            return false;
        }

        //store the new color (name and rgb values) in our model
        model.addColor(name, color);
        return true;

    }

    public List<ColorPair> handleGetColors()
    {
        return model.getColors();
    }
}
