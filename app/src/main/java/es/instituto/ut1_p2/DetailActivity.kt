package es.instituto.ut1_p2

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import es.instituto.pmdm_ut1_p2.AgendaApp
import es.instituto.pmdm_ut1_p2.model.Persona
import es.instituto.pmdm_ut1_p2.model.PersonasRepository
import javax.inject.Inject

class DetailActivity : AppCompatActivity() {
    @Inject
    lateinit var personasrepositor: PersonasRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        //injección de dependecias
        (applicationContext as AgendaApp).appComponent.inject(this)

        //configuración de botones
        (findViewById<Button>(R.id.cancelarButton)).setOnClickListener(){
            finish();
        }
        //se vuelve atras
        (findViewById<Button>(R.id.aceptarButton)).setOnClickListener(){

                var persona:Persona= Persona();
                persona.setNombre((findViewById<TextView>(R.id.editTextNombre)).text.toString())
                persona.setApellidos((findViewById<TextView>(R.id.editTextApellidos)).text.toString())
                persona.setEmail((findViewById<TextView>(R.id.editTextEmail)).text.toString())
                persona.setTelefono((findViewById<TextView>(R.id.editTextTelefono)).text.toString())
                persona.setActivo(((findViewById<CheckBox>(R.id.editActivo)).isChecked()))
                this.personasrepositor.add(persona)

            finish();
        }
    }

}