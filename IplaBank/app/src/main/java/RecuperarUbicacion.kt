import android.content.Context
import android.location.Location
import com.google.android.gms.location.*

private val Any.await: Unit
    get() {
        TODO("Not yet implemented")
    }

@Suppress("DEPRECATION")
class RecuperarUbicacion(private val context: Context) {

    private var fusedLocationClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)

    suspend fun obtenerUbicacion(): Location? {
        return try {
            val locationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(10000)
                .setFastestInterval(5000)

            val location = fusedLocationClient.awaitLastLocation()
            if (location != null) {
                return location
            } else {
                val callback = obtenerUbicacionCallback()
                fusedLocationClient.requestLocationUpdates(locationRequest, callback, null)
                    .await
                fusedLocationClient.awaitLastLocation()
            }
        } catch (e: Exception) {
            null
        }
    }

    private fun obtenerUbicacionCallback(): LocationCallback {
        return object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                super.onLocationResult(locationResult)
            }
        }
    }
}

private fun FusedLocationProviderClient.awaitLastLocation(): Location? {
    TODO("Not yet implemented")
}
