package th.ac.kku.cis.mobileapp.animeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class AnimeUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anime_user)

        val fullname:TextView=findViewById(R.id.nameUser)
        val imageUser:ImageView=findViewById(R.id.profile_image)
        val fullstory:TextView=findViewById(R.id.fullsoty)
        val animeweb:TextView=findViewById(R.id.animeWeb)

        val bundle:Bundle?=intent.extras

        val heading = bundle!!.getString("heading")
        val imageID = bundle.getInt("imageID")
        val storyID = bundle!!.getString("storyID")
        val animeWeb = bundle!!.getString("animeweb")



        fullname.text=heading
        fullstory.text=storyID
        animeweb.text=animeWeb
        imageUser.setImageResource(imageID)
    }
}