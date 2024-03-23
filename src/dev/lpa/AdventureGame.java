package dev.lpa;

import java.util.HashMap;
import java.util.Map;

public class AdventureGame {

    private static final String GAME_LOCATIONS = """
            road,at the end of the road, W: hill, E:well house,S:valley,N:forest
            hill,on top of hill with a view in all directions,N:forest, E:road
            well house,inside a well house for a small spring,W:road,N:lake,S:stream
            valley,in a forest valley beside a tumbling stream,N:road,W:hill,E:stream
            forest,at the edge of a thick dark forest,S:road,E:lake
            lake,by an alpine lake surrounded by wildflowers,W:forest,S:well house
            stream,near a stream with a rocky bed,W:valley, N:well house
            """;

    private enum Compass {
        E, N, S, W;

        private static final String[] directions = {"East, North, South, West"};

        private String getString(){
            // returns "East" if this's value is E, frex
            return directions[this.ordinal()];
        }
    }


    private record Location(String description, Map<Compass, String> nextPlaces){}

    private String lastPlace;
    private Map<String, Location> adventureMap = new HashMap<>();


    public AdventureGame() {


    }

    // Can pass in string similar to GAME_LOCATIONS above
    public AdventureGame(String customLocations) {

    }


    private void loadLocations (String data){
        // Split text block by line
        // \\R is any unicode line break on any OS
        for(String s : data.split("\\R")){

        }
    }
}
