import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface Dao {
    @Query("SELECT * FROM solicitudes ORDER BY fechaCreacion DESC")
    suspend fun getAllSolicitudes(): List<Solicitud>

    @Query("SELECT * FROM solicitudes WHERE id = :id")
    suspend fun getSolicitudById(id: Long): Solicitud?

    @Insert
    suspend fun insertSolicitud(solicitud: Solicitud): Long

    @Query("DELETE FROM solicitudes WHERE id = :id")
    suspend fun deleteSolicitud(id: Long)

    @Update
    suspend fun updateSolicitud(solicitud: Solicitud)
}