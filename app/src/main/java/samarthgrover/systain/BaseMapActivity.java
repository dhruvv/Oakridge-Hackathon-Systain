package samarthgrover.systain;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by admin on 20/01/18.
 */

public abstract class BaseMapActivity extends AppCompatActivity {

    protected LatLng CenterLocation = new LatLng( 17.419088, 78.363908 );

    protected GoogleMap GoogleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( getMapLayoutId() );
        initMapIfNecessary();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initMapIfNecessary();
    }

    protected void initMapIfNecessary() {
        if( GoogleMap != null ) {
            return;
        }

        GoogleMap = ((MapFragment) getFragmentManager().findFragmentById( R.id.map )).getMap();

        initMapSettings();
        initCamera();
    }

    protected void initCamera() {
        CameraPosition position = CameraPosition.builder()
                .target(CenterLocation)
                .zoom(getInitialMapZoomLevel())
                .build();

        GoogleMap.animateCamera(CameraUpdateFactory.newCameraPosition(position), null);
    }

    protected int getMapLayoutId() {
        return R.layout.activity_map;
    }

    protected float getInitialMapZoomLevel() {
        return 18;
    }

    protected abstract void initMapSettings();
}
