package com.example.cascadiafx.Tile;

import java.util.ArrayList;
import java.util.List;

/*
- Parent of MapTile and PlayerTile
 */
public class Tile {
    // Every Tile has a List of AnimalTokenTypes that are allowed to inhabit the Tile. For a PlayerTile this list is set whereas for a MapTile this list is empty.
    private List<AnimalTokenType> animalTokenTypeList = new ArrayList<>();
    // Every Tile has a TerrainType that represents the type of terrain that the Tile has on each side of the Tile represented as an ArrayList with the capacity of 6 since a Tile has 6 sides.
    // For a PlayerTile this list is set whereas for a MapTile this list is empty.
    private List<TerrainType> terrainTypeList = new ArrayList<>(6);
    // Every Tile has an ImagePath that represents the path to the image that represents the Tile.
    // For a PlayerTile this path is set whereas for a MapTile this path is empty.
    private String imagePath;

    // Constructor for Tile that takes in a List of AnimalTokenTypes and a List of TerrainTypes and a String as parameters
    public Tile(List<AnimalTokenType> animalTokenTypeList, List<TerrainType> terrainTypeList, String imagePath) {
        this.animalTokenTypeList = animalTokenTypeList;
        this.terrainTypeList = terrainTypeList;
        this.imagePath = imagePath;
    }

    // Getter and Setters for the List of AnimalTokenTypes
    public List<AnimalTokenType> getAnimalTokenTypeList() {
        return animalTokenTypeList;
    }

    public void setAnimalTokenTypeList(List<AnimalTokenType> animalTokenTypeList) {
        this.animalTokenTypeList = animalTokenTypeList;
    }

    // Getter and Setters for the List of TerrainTypes
    public List<TerrainType> getTerrainTypeList() {
        return terrainTypeList;
    }

    public void setTerrainTypeList(List<TerrainType> terrainTypeList) {
        this.terrainTypeList = terrainTypeList;
    }

    // Getter and Setters for the ImagePath
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }


    // toString method for the Tile
    @Override
    public String toString() {
        return "Tile{" +
                "animalTokenTypeList=" + animalTokenTypeList +
                ", terrainTypeList=" + terrainTypeList +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
