package com.example.cascadiafx.Tile;

import com.example.cascadiafx.Map.CubeCoordinate;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
The MapTile Class holds the information for a single tile on the map.
Later the map will be made up of these tiles. MapTile is used to separate
the information from the visual representation of a MapTile.

A MapTile is an empty representation of a tile signaling that a tile exists
at a certain position on the map and can be occupied by a player using a PlayerTile.
Once a PlayerTile is placed on a MapTile the MapTile will inherit the
AnimalTokenTypes, TerrainTypes, and imagePath from the PlayerTile.

MapTiles have an empty list of AnimalTokenTypes, an empty list of TerrainTypes,
and an empty imagePath at the start.
*/
public class MapTile extends Tile {
    // The CubeCoordinate of the MapTile that represents the position of the tile
    // on the map each tile has a unique CubeCoordinate
    private final CubeCoordinate cubeCoordinate;
    // List of MapTiles that are neighbors to the MapTile with a maximum of 6 neighbors
    // since a tile has 6 sides
    private final List<MapTile> neighbors = new ArrayList<>(6);
    // BooleanProperty that represents if the MapTile has copied the AnimalTokenTypes,
    // TerrainTypes, and imagePath from a PlayerTile. A MapTile is occupied if it has
    // copied the information from a PlayerTile. so if allowedTokens, terrainTypeList,
    // and imagePath are not empty then the MapTile is occupied.
    private final BooleanProperty isOccupied = new SimpleBooleanProperty(false);
    // BooleanProperty that represents if the MapTile is currently selected by the player
    private final BooleanProperty isSelected = new SimpleBooleanProperty(false);
    // BooleanProperty that represents if the MapTile is currently highlighted by the player
    private final BooleanProperty isHighlighted = new SimpleBooleanProperty(false);
    // BooleanProperty that represents if the MapTile is currently a valid placement
    // for a PlayerTile. A MapTile is a valid placement if a neighboring MapTile is occupied.
    private final BooleanProperty isValidPlacement = new SimpleBooleanProperty(false);

    // Constructor for MapTile that takes in a CubeCoordinate as a parameter
    public MapTile(CubeCoordinate cubeCoordinate) {
        super(null, null, null);
        this.cubeCoordinate = cubeCoordinate;

        // Listener for the isOccupied BooleanProperty that updates the isValidPlacement
        // BooleanProperty based on the neighbors of the MapTile. A MapTile is a valid
        // placement if a neighboring MapTile is occupied.
        // If the MapTile is occupied then the isValidPlacement BooleanProperty is set
        // to false and the updateNeighbors method is called.
        // isOccupied changes when a PlayerTile is placed on the MapTile.
        // i.e. when the copyTile method is called.
        isOccupied.addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                setValidPlacement(false);
                updateNeighbors();
            }
        });
    }

    // Getters for the CubeCoordinate
    public CubeCoordinate getCubeCoordinate() {
        return cubeCoordinate;
    }

    // Getter for the neighbors list
    public List<MapTile> getNeighbors() {
        return neighbors;
    }

    // Setter for the neighbors list, which takes in a Map<CubeCoordinate, MapTile> as a parameter
    // and sets the neighbors based on the CubeCoordinate of the MapTile. If MapTiles are on the
    // edge of the map they will have less than 6 neighbors. The neighbors get added to the neighbors
    // list starting from the top right and going clockwise. Using the CubeCoordinate class Consturctor which takes in the q and r values as parameters that calculates the s value that satisfies the equation q + r + s = 0 with an Exception if the equation is not satisfied.
    public void setNeighbors(Map<CubeCoordinate, MapTile> mapTiles) {

        CubeCoordinate[] directions = {
                new CubeCoordinate(0, -1), new CubeCoordinate(1, -1), new CubeCoordinate(1, 0),
                new CubeCoordinate(0, 1), new CubeCoordinate(-1, 1), new CubeCoordinate(-1, 0)
        };

        for (CubeCoordinate direction : directions) {
            CubeCoordinate neighborCoordinate = cubeCoordinate.add(direction);
            MapTile neighbor = mapTiles.get(neighborCoordinate);
            if (neighbor != null) {
                neighbors.add(neighbor);
            }
        }
    }

    // Getters and Setters for the isOccupied BooleanProperty
    public BooleanProperty isOccupiedProperty() {
        return isOccupied;
    }

    public boolean isOccupied() {
        return isOccupied.get();
    }

    public void setOccupied(boolean occupied) {
        isOccupied.set(occupied);
    }

    // Getters and Setters for the isSelected BooleanProperty
    public BooleanProperty isSelectedProperty() {
        return isSelected;
    }

    public boolean isSelected() {
        return isSelected.get();
    }

    public void setSelected(boolean selected) {
        isSelected.set(selected);
    }

    // Getters and Setters for the isHighlighted BooleanProperty
    public BooleanProperty isHighlightedProperty() {
        return isHighlighted;
    }

    public boolean isHighlighted() {
        return isHighlighted.get();
    }

    public void setHighlighted(boolean highlighted) {
        isHighlighted.set(highlighted);
    }

    // Getters and Setters for the isValidPlacement BooleanProperty
    public BooleanProperty isValidPlacementProperty() {
        return isValidPlacement;
    }

    public boolean isValidPlacement() {
        return isValidPlacement.get();
    }

    public void setValidPlacement(boolean validPlacement) {
        isValidPlacement.set(validPlacement);
    }

    // Method that copies the information from a PlayerTile to the MapTile. The MapTile will inherit
    // the AnimalTokenTypes, TerrainTypes, and imagePath from the PlayerTile. The MapTile will also
    // be set as occupied.
    public void copyTile(Tile playerTile) {
        setAnimalTokenTypeList(playerTile.getAnimalTokenTypeList());
        setTerrainTypeList(playerTile.getTerrainTypeList());
        setImagePath(playerTile.getImagePath());
        setOccupied(true);
    }

    // Method that updates the neighbors of the MapTile after a PlayerTile has been placed on the MapTile
    // i.e. when the copyTile method is called. The neighbors of the MapTile will have their
    // isValidPlacement BooleanProperty updated to true.
    public void updateNeighbors() {
        for (MapTile neighbor : neighbors) {
            neighbor.setValidPlacement(isOccupied());
        }
    }

    // Method that resets the MapTile to its initial state. The MapTile will have an empty list of
    // AnimalTokenTypes, an empty list of TerrainTypes, and an empty imagePath.
    public void resetTile() {
        setAnimalTokenTypeList(new ArrayList<>());
        setTerrainTypeList(new ArrayList<>());
        setImagePath(null);
        setOccupied(false);
    }

    // Method that returns the distance between the MapTile and another MapTile
    public int distance(MapTile b) {
        return cubeCoordinate.distance(b.getCubeCoordinate());
    }

    // Method that returns the distance between the MapTile and a CubeCoordinate
    public int distance(CubeCoordinate b) {
        return cubeCoordinate.distance(b);
    }

    // Method that returns the distance between the MapTile and a List of CubeCoordinates
    public int distance(List<CubeCoordinate> cubeCoordinates) {
        int minDistance = Integer.MAX_VALUE;
        for (CubeCoordinate cubeCoordinate : cubeCoordinates) {
            int distance = distance(cubeCoordinate);
            if (distance < minDistance) {
                minDistance = distance;
            }
        }
        return minDistance;
    }
}
