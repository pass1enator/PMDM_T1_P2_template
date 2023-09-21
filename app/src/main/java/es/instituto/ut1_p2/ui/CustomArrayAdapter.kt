package es.instituto.pmdm_ut1_p2.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import es.instituto.pmdm_ut1_p2.model.PersonasRepository
import es.instituto.ut1_p2.DetailActivity
import es.instituto.ut1_p2.R

class CustomArrayAdapter(private val context: Context, private val repository: PersonasRepository) :
    BaseAdapter() {
    private lateinit var nombre: TextView
    private lateinit var button: Button
    private lateinit var borrar: ImageButton


    override fun getCount(): Int {
        return this.repository.getAll().size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    fun find(field:String=""){

        notifyDataSetChanged()
    }
    init {


    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var convertView = convertView
        convertView = LayoutInflater.from(context).inflate(R.layout.row_item, parent, false)
        nombre = convertView.findViewById(R.id.textView)
        button = convertView.findViewById(R.id.button2)
        button.setOnClickListener {
            val intent = Intent(parent.context, DetailActivity::class.java)

            parent.context.startActivity(intent)
        }


         borrar= convertView.findViewById(R.id.borrar)
         borrar.setOnClickListener {
            //se borra del original

             this.repository.getAll().removeAt(position)


             //se avisa de lso cambios
             this.notifyDataSetChanged();


         }
         nombre.text =  this.repository.getAll()[position].getNombre()
        return convertView
    }
}