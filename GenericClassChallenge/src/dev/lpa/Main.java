package dev.lpa;

public class Main {
    public static void main(String[] args) {

        var nationalUSParks = new Park[]{
                new Park("Yellowstone", "44.4882, -110.5916"),
                new Park("Grand Canyon", "36.1085, -112.0965"),
                new Park("Yosemite", "37.8855, -119.5360"),
        };

        Layer<Park> parkLayer = new Layer<>(nationalUSParks);
        parkLayer.renderLayer();
        //Render Yellowstone National Park as POINT ([44.4882, -110.5916])
        //Render Grand Canyon National Park as POINT ([36.1085, -112.0965])
        //Render Yosemite National Park as POINT ([37.8855, -119.536])

        var majorUSRivers = new River[]{
                new River("Mississippi", "47.2160, -95.2348", "29.1566, -89.2495",
                        "35.1556, -90.0695"),
                new River("Missouri", "45.9239, -111.4983", "38.8146, -90.1218")
        };

        Layer<River> riverLayer = new Layer<>(majorUSRivers);

        riverLayer.addElements(
                new River("Colorado", "40.4708, -105.8286", "36.1015,-12.0892",
                        "34.2964, -114.1148", "31.7811, -114.7724"),
                new River("Delaware", "42.2026, -75.00836", "39.4955, -75.5592")
        );

        riverLayer.renderLayer();
        //Render Mississippi River as LINE ([[47.216, -95.2348], [29.1566, -89.2495], [35.1556, -90.0695]])
        //Render Missouri River as LINE ([[45.9239, -111.4983], [38.8146, -90.1218]])
        //Render Colorado River as LINE ([[40.4708, -105.8286], [36.1015, -12.0892], [34.2964, -114.1148], [31.7811, -114.7724]])
        //Render Delaware River as LINE ([[42.2026, -75.00836], [39.4955, -75.5592]])
    }
}
