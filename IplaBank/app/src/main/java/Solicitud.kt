import androidx.room.Entity
import androidx.room.PrimaryKey
import com.MaximilianoQuirozprueba3.iplabank.IplaBankApp

@Entity(tableName = "solicitudes")
data class Solicitud(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val nombreCompleto: String,
    val rut: String,
    val fechaNacimiento: String,
    val email: String,
    val telefono: String,
    val latitud: Double,
    val longitud: Double,
    val imagenCedulaFrontal: String,
    val imagenCedulaTrasera: String,
    val fechaCreacion: Long
)
suspend fun guardarSolicitudEnBaseDeDatos(solicitud: Solicitud) {
    val solicitudConValoresPredeterminados = solicitud.copy(
        imagenCedulaFrontal = "",
        imagenCedulaTrasera = "",
        latitud = 0.0,
        longitud = 0.0
    )

val solicitudId = IplaBank().database.Dao().insertSolicitud(solicitudConValoresPredeterminados)

}