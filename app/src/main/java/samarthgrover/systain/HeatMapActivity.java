package samarthgrover.systain;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.maps.android.heatmaps.HeatmapTileProvider;
import com.google.maps.android.heatmaps.WeightedLatLng;

import java.util.ArrayList;

public class HeatMapActivity extends BaseMapActivity {

    private HeatmapTileProvider Provider;

    @Override
    protected void initMapSettings() {
        ArrayList<WeightedLatLng> locations = generateLocations();
        Provider = new HeatmapTileProvider.Builder().weightedData(locations).build();
        Provider.setRadius(40);
        Provider.setOpacity(0.8);
        GoogleMap.addTileOverlay(new TileOverlayOptions().tileProvider(Provider));
    }

    private ArrayList<WeightedLatLng> generateLocations() {

        ArrayList<WeightedLatLng> locations = new ArrayList<WeightedLatLng>();

        double lat = 17.419088;
        double lng = 78.363908;
        double weight = 0.1;

        LatLng coordinates = new LatLng(lat, lng);

        locations.add(new WeightedLatLng(coordinates, weight));

       return locations;
    }
}