package es.instituto.ut1_p2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import es.instituto.pmdm_ut1_p2.AgendaApp
import es.instituto.pmdm_ut1_p2.model.Persona
import es.instituto.pmdm_ut1_p2.model.PersonasRepository
import es.instituto.pmdm_ut1_p2.ui.CustomArrayAdapter
import javax.inject.Inject


class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var personasrepositor: PersonasRepository
    lateinit var adaptador: CustomArrayAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        var listado: ListView
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    //injección de dependencias
        (applicationContext as AgendaApp).appComponent.inject(this)
        this.personasrepositor.add(Persona("Pekkkkdro","Picapiedra","pedro@picapiedra.es", "2",true))
        this.personasrepositor.add(Persona("Pablo","Marmol","pablo@marmol.com", "5",true))

    //adapatador de la lista
        this.adaptador= CustomArrayAdapter(applicationContext,this.personasrepositor)
        listado=findViewById<ListView>(R.id.listado)
        listado.adapter=adaptador
        //se configuran los eventos de los botones
        var addButton:FloatingActionButton= findViewById(R.id.addButton)
        addButton.setOnClickListener(){

            val intent = Intent(applicationContext, DetailActivity::class.java)
            startActivity(intent)
        }
        var searchbutton:Button=findViewById<Button>(R.id.searchbutton)
        searchbutton.setOnClickListener(){
        }
    }

    override fun onResume() {
        super.onResume()
        //se avisa de los cambios
        this.adaptador.notifyDataSetChanged()
    }
}