import android.app.Application
import androidx.room.Room

class IplaBank : Application() {
    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "iplaBank-db"
        ).build()
    }
}