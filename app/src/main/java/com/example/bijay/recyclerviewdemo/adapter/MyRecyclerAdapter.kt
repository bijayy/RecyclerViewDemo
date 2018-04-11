package com.example.bijay.recyclerviewdemo.adapter
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.bijay.recyclerviewdemo.R
import com.example.bijay.recyclerviewdemo.model.Employ

/**
 * Custom recycler view adapter i.e. MyRecyclerAdapter
 */
class MyRecyclerAdapter: RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {

    //Variable to inflate the view out of the "recycler_view_item.xml"
    //And demo data of employee
    private var layoutInflater: LayoutInflater? = null
    private var employee: MutableList<Employ>? = ArrayList<Employ>()

    constructor(context: Context) {
        layoutInflater = LayoutInflater.from(context)
        getEmployee()
    }

    //Getting view and passing that view to MyViewHolder class and returning the MyViewHolder object for recycler view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = layoutInflater?.inflate(R.layout.recycler_view_item, parent, false)
        val myViewHolder = MyViewHolder(view)
        return myViewHolder
    }

    //Return size of emploee data
    override fun getItemCount(): Int {
        var size: Int = employee!!.size
        return size
    }

    //Binding the view with the data present in the recycler view
    //Setting the listener on each item of the recycler view
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val employ = employee?.get(position)
        holder.sendData(employ)
        holder.setListener()
    }

    //MyViewHolder class which initializes the Button present in the "recycler_view_item.xml" and assign the data into this.
    inner class MyViewHolder: RecyclerView.ViewHolder, View.OnClickListener {

        var button: Button

        //Getting button present in the "recycler_view_item.xml"
        constructor(viewItem: View?): super(viewItem) {
            button = viewItem?.findViewById(R.id.button)!!
        }

        //Setting button text present in the "recycler_view_item.xml" with employee name
        fun sendData(employ: Employ?) {
            button.text = employ?.name
        }

        //Setting click listener on button present in the "recycler_view_item.xml"
        fun setListener(){
            button.setOnClickListener(this)
        }

        //Displaying Toast on click of button present in the "recycler_view_item.xml"
        override fun onClick(v: View?) {
            Toast.makeText(layoutInflater?.context, "clicked: ${(v as Button).text}", Toast.LENGTH_SHORT).show()
        }
    }

    //Employee Demo data
    private fun getEmployee(): Unit {
        val employe1 = Employ()
        employe1.name = "Bijay"
        employee?.add(employe1)
        val employe2 = Employ()
        employe2.name = "Ajay"
        employee?.add(employe2)
        val employe3 = Employ()
        employe3.name = "Sanjay"
        employee?.add(employe3)
        val employe4 = Employ()
        employe4.name = "Manjay"
        employee?.add(employe4)
        val employe5 = Employ()
        employe5.name = "Danjay"
        employee?.add(employe5)
        val employe6 = Employ()
        employe6.name = "Bijay Kumay Yadav"
        employee?.add(employe6)
    }
}