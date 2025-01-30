package com.openclassrooms.magicgithub.ui.user_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.openclassrooms.magicgithub.databinding.ItemListUserBinding
import com.openclassrooms.magicgithub.model.User
import com.openclassrooms.magicgithub.utils.UserDiffCallback

// Adaptateur pour gérer l'affichage d'une liste d'utilisateurs
class UserListAdapter(private val callback: Listener) : RecyclerView.Adapter<ListUserViewHolder>() {

    // Liste interne mutable d'utilisateurs
    private var users: MutableList<User> = mutableListOf()

    // Interface pour gérer les interactions utilisateur (par ex. suppression)
    interface Listener {
        fun onClickDelete(user: User)  // Méthode appelée lorsqu'on clique sur le bouton de suppression
    }

    // Crée un ViewHolder pour un élément de la liste
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListUserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListUserBinding.inflate(inflater, parent, false)
        return ListUserViewHolder(binding)
    }

    // Associe les données d'un utilisateur à l'élément de la liste
    override fun onBindViewHolder(holder: ListUserViewHolder, position: Int) {
        holder.bind(users[position], callback)
    }

    // Retourne le nombre total d'éléments affichés
    override fun getItemCount(): Int = users.size

    // Met à jour la liste d'utilisateurs avec une nouvelle liste et applique les changements
    fun updateList(newList: List<User>) {
        // Utilisation de DiffUtil pour comparer les listes et optimiser les mises à jour
        val diffResult = DiffUtil.calculateDiff(UserDiffCallback(newList, users))
        users = newList.toMutableList()
        diffResult.dispatchUpdatesTo(this)
    }

    // Retourne la liste actuelle des utilisateurs
    fun getUsers(): List<User> = users

    // Permet d'échanger deux utilisateurs dans la liste (utilisé pour le drag-and-drop)
    fun swapItems(fromIndex: Int, toIndex: Int) {
        users[fromIndex] = users[toIndex].also { users[toIndex] = users[fromIndex] }
        notifyItemMoved(fromIndex, toIndex)
    }
}
