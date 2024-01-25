import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Solicitud::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun Dao(): Dao
}