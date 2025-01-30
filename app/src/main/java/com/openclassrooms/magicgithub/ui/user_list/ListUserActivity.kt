package com.openclassrooms.magicgithub.ui.user_list

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.openclassrooms.magicgithub.databinding.ActivityListUserBinding
import com.openclassrooms.magicgithub.di.Injection.getRepository
import com.openclassrooms.magicgithub.model.User

class ListUserActivity : AppCompatActivity(), UserListAdapter.Listener {

    private lateinit var binding: ActivityListUserBinding
    private lateinit var adapter: UserListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialise la vue avec le fichier XML associé
        binding = ActivityListUserBinding.inflate(layoutInflater).apply { setContentView(root) }

        // Configure les événements de clic et initialise la liste
        configureFabClick()
        setupRecyclerView()
    }

    override fun onResume() {
        super.onResume()

        // Met à jour la liste d'utilisateurs à chaque reprise de l'activité
        updateUserList()
    }

    // Configure le RecyclerView et les interactions associées
    private fun setupRecyclerView() {
        adapter = UserListAdapter(this).also {
            binding.activityListUserRv.adapter = it
        }
        configureSwipeAction()
        configureDragAndDrop()
    }

    // Configure l'action du bouton flottant pour ajouter un utilisateur aléatoire
    private fun configureFabClick() {
        binding.activityListUserFab.setOnClickListener {
            getRepository().addRandomUser()
            updateUserList()
        }
    }

    // Rafraîchit la liste des utilisateurs affichés dans le RecyclerView
    private fun updateUserList() {
        adapter.updateList(getRepository().getUsers())
    }

    // Appelé lorsque l'utilisateur demande la suppression d'un élément
    override fun onClickDelete(user: User) {
        Log.d(TAG, "Suppression d'un utilisateur en cours.")
        getRepository().deleteUser(user)
        updateUserList()
    }

    // Configure le geste de balayage pour activer/désactiver un utilisateur
    private fun configureSwipeAction() {
        val swipeHandler = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ) = false

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                // Inverse l'état actif de l'utilisateur balayé
                val user = adapter.getUsers()[viewHolder.adapterPosition].apply { isActive = !isActive }
                adapter.notifyItemChanged(viewHolder.adapterPosition)
            }
        }

        // Associe le swipe handler au RecyclerView
        ItemTouchHelper(swipeHandler).attachToRecyclerView(binding.activityListUserRv)
    }

    // Configure le drag-and-drop pour réorganiser les éléments
    private fun configureDragAndDrop() {
        val dragHandler = object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN, 0) {

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                adapter.swapItems(viewHolder.adapterPosition, target.adapterPosition)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {}
        }

        // Associe le drag handler au RecyclerView
        ItemTouchHelper(dragHandler).attachToRecyclerView(binding.activityListUserRv)
    }

    companion object {
        private val TAG = ListUserActivity::class.java.simpleName
    }
}
