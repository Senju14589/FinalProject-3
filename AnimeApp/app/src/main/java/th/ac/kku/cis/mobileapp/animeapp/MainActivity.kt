package th.ac.kku.cis.mobileapp.animeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import java.time.Instant

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<News>
    lateinit var imageId:Array<Int>
    lateinit var heading:Array<String>
    lateinit var story:Array<String>
    lateinit var animeweb:Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId= arrayOf(
            R.drawable.aharen,
            R.drawable.chikimori,
            R.drawable.gojokung,
            R.drawable.komi,
            R.drawable.loveanime,
            R.drawable.slam
        )
        heading= arrayOf(
            "Aharen-san wa Hakarenai",
            "คุณชิกิโมริไม่ได้แค่น่ารักอย่างเดียวหรอกนะ",
            "หนุ่มเย็บผ้ากับสาวนักคอสเพลย์",
            "โฉมงามพูดไม่เก่งกับผองเพื่อนไม่เต็มเต็ง",
            "รักไร้เสียง",
            "Tensei shitara Slime Datta Ken",

        )
        story= arrayOf(
            "อาฮะเร็น เรนะ สาวร่างเล็กเหมือนเด็กประถมที่นั่งข้างโต๊ะของหนุ่ม ดันไซ โจชิ เธอไม่ค่อยคุยกับใครแล้วยังทำตัวเกินความเข้าใจให้คนคิดมากแบบเขาได้เห็นเสมอ",
            "คุณ \"ชิกิโมริ\" ดูเหมือนจะเป็นแฟนสาวที่สมบูรณ์แบบ น่ารัก น่าสนุก เวลาอยู่ใกล้ๆ กันรู้สึกสวีทมากเลยเมื่อเธออยากจะเป็น... แต่บางทีเธอก็มีด้านเท่ห์ที่เก็บซ่อนไว้ภายใต้เงามืดของเธอเอง และแฟนหนุ่มของเธอ Izumi ก็ชอบอยู่ใกล้ๆ เมื่อสิ่งนั้นเกิดขึ้น !",
            "ความสัมพันธ์ลับๆกับ คิตะกาวะ มาริน และ โกะโจ วากานะ ซึ่งคิดว่าเธอเป็น “คนที่อยู่กันคนละโลก” กับเขาขณะที่วากานะซึ่งตั้งเป้าหมายจะเป็นช่างปั้นหน้าตุ๊กตาฮินะกำลังใช้ห้องปฏิบัติการหัตถกรรมในการทำงานนั้นเองผู้ที่โผล่เข้ามาในห้อง… คือคนที่คาดไม่ถึง…!?",
            "โคมิ โชโกะเป็นหญิงสาวผู้งดงามที่ได้รับความนิยมอย่างล้นหลามในทันทีจากเพื่อนร่วมชั้นในวันแรกของการเข้าเรียน แต่มีเพียงทาดาโนะ ฮิโตฮิโตะ นักเรียนชายธรรมดาที่มีโอกาสได้รู้ว่าโคมิมีปัญหาในการสื่อสารกับคนอื่น ทาดาโนะจึงช่วยโคมิในการหาเพื่อนให้ได้ 100 คน",
            "เรื่องราวของ อิชิดะ โชยะ เด็กหนุ่มที่เป็นเหมือนหัวโจกของเพื่อน ๆ ผู้ชาย ซึ่งบังเอิญให้ได้ต้องมารู้จักกับ นิชิมิยะ โชโกะ เด็กสาวที่เพิ่งย้ายมาใหม่ ที่สำคัญเธอพิการทางการได้ยินต้องใช้เครื่องช่วยฟังและภาษามือ",
            "มิคามิ มนุษย์เงินเดือนธรรมดาแต่กลับตายด้วยเหตุการณ์ที่ไม่ธรรมดา เมื่ออยู่ดี ๆ ก็มีคนร้ายที่ไหนก็ไม่รู้วิ่งถือมีดมาแทงเค้าตายคาที่ จนทำให้เค้ากลับไปเกิดใหม่ในโลกที่แม้แต่ตัวเค้าเองก็เคยเห็นแค่ในเกมการ์ตูน แถมสิ่งมีชีวิตเท่ ๆ มีตั้งเยอะแยะแต่เค้ากลับได้เกิดมาเป็นแค่ สไลม์ ซะอย่างงั้น",
        )
        animeweb= arrayOf(
            "ดูได้ทาง:Bilibili",
            "ดูได้ทาง:Bilibili,Muse Thailand",
            "ดูได้ทาง:Bilibili",
            "ดูได้ทาง:Netflix",
            "ดูได้ทาง:Bilibili",
            "ดูได้ทาง:Bilibili",
        )

        newRecyclerView=findViewById(R.id.recyclerview)
        newRecyclerView.layoutManager=LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList= arrayListOf<News>()

        getUserData()
    }

    private fun getUserData(){
        for (i in imageId.indices){
            val news=News(imageId[i],heading[i],story[i],animeweb[i])
            newArrayList.add(news)
        }
        var adapter=MyAdapter(newArrayList)
        newRecyclerView.adapter=adapter
        adapter.setOnItemClickListener(object:MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                //Toast.makeText(this@MainActivity,"คุณคลิ๊กเลือกอนิเมะลำดับที่. $position",Toast.LENGTH_SHORT)

                val intent = Intent (this@MainActivity,AnimeUserActivity :: class.java)

                intent.putExtra("heading",newArrayList[position].heading)
                intent.putExtra("imageID",newArrayList[position].titleImage)
                intent.putExtra("storyID",newArrayList[position].story)
                intent.putExtra("animeweb",newArrayList[position].animeWeb)

                startActivity(intent)

            }

        })

        FirebaseAuth.getInstance().signOut();
    }

}