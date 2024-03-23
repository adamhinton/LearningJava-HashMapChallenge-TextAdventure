package dev.lpa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
        // \n is good too but this is more robust
        for(String s : data.split("\\R")){

            // Split each line into three parts
            // The third part will contain all data after second comma. Will contain commas if any.
            String[] parts = s.split(",", 3);
            // remove whitespace
            Arrays.asList(parts).replaceAll(String::trim);

            // TODO: Make this method
            Map<Compass, String> nextPlaces = loadDirections(parts[2]);

            Location location = new Location(parts[1], nextPlaces);
            adventureMap.put(parts[0], location);
        }

        adventureMap.forEach((k, v) -> System.out.printf("%s:%s%n", k, v));
    }

    private Map<Compass, String> loadDirections (String nextPlaces){
        Map<Compass, String> directions = new HashMap<>();
        List<String> nextSteps = Arrays.asList(nextPlaces.split(","));

    }


}
