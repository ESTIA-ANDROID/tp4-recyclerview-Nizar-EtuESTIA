package com.openclassrooms.magicgithub.ui.user_list

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.openclassrooms.magicgithub.R
import com.openclassrooms.magicgithub.di.Injection.getRepository
import com.openclassrooms.magicgithub.model.User

class ListUserActivity : AppCompatActivity(), UserListAdapter.Listener {
    // FOR DESIGN ---
    lateinit var recyclerView: RecyclerView
    lateinit var fab: FloatingActionButton

    // FOR DATA ---
    private lateinit var adapter: UserListAdapter

    // OVERRIDE ---
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_user)
        configureFab()
        configureRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    // CONFIGURATION ---
    private fun configureRecyclerView() {
        recyclerView = findViewById(R.id.activity_list_user_rv)
        adapter = UserListAdapter(this)
        recyclerView.adapter = adapter
    }

    private fun configureFab() {
        fab = findViewById(R.id.activity_list_user_fab)
        fab.setOnClickListener(View.OnClickListener { view: View? ->
            getRepository().addRandomUser()
            loadData()
        })
    }

    private fun loadData() {
        adapter.updateList(getRepository().getUsers())
    }

    // ACTIONS ---
    override fun onClickDelete(user: User) {
        Log.d(ListUserActivity::class.java.name, "User tries to delete a item.")
        getRepository().deleteUser(user)
        loadData()
    }
}