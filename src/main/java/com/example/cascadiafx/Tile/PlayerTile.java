package com.example.cascadiafx.Tile;

import java.util.List;

/*
- PlayerTile holds the information of the Tile that the player holds in his hand.
- PlayerTile is used to separate the information from the visual representation of a PlayerTile.
- PlayerTiles are already set with the TerrainType and AnimalTokenTypes that are allowed to inhabit the Tile and stored inside a JSON file.
*/
public class PlayerTile extends Tile{
    // Constructor for PlayerTile that takes in a List of AnimalTokenTypes and a List of TerrainTypes and a String as parameters
    public PlayerTile(List<AnimalTokenType> animalTokenTypeList, List<TerrainType> terrainTypeList, String imagePath) {
        super(animalTokenTypeList, terrainTypeList, imagePath);
    }
}
