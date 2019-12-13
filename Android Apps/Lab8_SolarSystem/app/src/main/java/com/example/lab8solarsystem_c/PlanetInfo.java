package com.example.lab8solarsystem_c;

public class PlanetInfo {
    private String planetInfo;
    private String planetUrl;

    private void setPlanetInfo(Integer planetOptions){
        switch (planetOptions){
            case 0: //Mercury
                planetInfo="The orbit of Mercury was important in proving Albert Einstein’s theory of General Relativity.";
                planetUrl="https://solarsystem.nasa.gov/planets/mercury/overview/";
                break;
            case 1: //Venus
                planetInfo="Venus rotates in the opposite direction to other planets.";
                planetUrl="https://solarsystem.nasa.gov/planets/venus/overview/";
                break;
            case 2: //Mars
                planetInfo="The tallest mountain known in the solar system is on Mars: Olympus Mons is a 21 km high";
                planetUrl="https://solarsystem.nasa.gov/planets/mars/overview/";
                break;
            case 3: //Jupiter
                planetInfo ="Jupiter has at least 67 moons in satellite around the planet. ";
                planetUrl="https://solarsystem.nasa.gov/planets/jupiter/overview/";
                break;
            case 4: //Saturn
                planetInfo="Saturn has the fastest winds of any other planet in our solar system. These winds have been measured at approximately 1,800 km per hour";
                planetUrl="https://solarsystem.nasa.gov/planets/saturn/overview/";
                break;
            case 5: //Uranus
                planetInfo="Uranus is the coldest planet in the solar system. The minimum surface temperature on Uranus is -224°C. ";
                planetUrl="https://solarsystem.nasa.gov/planets/uranus/overview/";
                break;
            case 6: //Neptune
                planetInfo="The climate on Neptune is extremely active. In its upper atmosphere, large storms sweep across it and high-speed solar winds track around the planet at up to 1,340 km per second. ";
                planetUrl="https://solarsystem.nasa.gov/planets/neptune/overview/";
                break;
            default:
                planetInfo="none";
                planetUrl="https://solarsystem.nasa.gov/";
        }
    }

    public String getplanetInfo(){
        return planetInfo;
    }

    public String getPlanetUrl(){
        return planetUrl;
    }

    public void setplanetInfo(Integer planetOptions){
        setPlanetInfo(planetOptions);
    }

    public void setPlanetUrl(Integer planetOptions){
        setPlanetInfo(planetOptions);
    }

}
