package Lab_01;

import java.util.ArrayList;

public class MultiLevelGarage {
	
   ArrayList<Garage<ITransport>> garageStages;
   
    private final int countPlaces = 15;
    
    public MultiLevelGarage(int countStages, int pictureWidth, int pictureHeight) {
       garageStages = new ArrayList<Garage<ITransport>>();
       for (int i = 0; i < countStages; ++i)
       {
           garageStages.add(new Garage<ITransport>(countPlaces, pictureWidth, pictureHeight));
       }
   }
    public Garage<ITransport> getGarage(int index) {
       if (index > -1 && index < garageStages.size()) {
           return garageStages.get(index);
       }
        return null;
   }
}
