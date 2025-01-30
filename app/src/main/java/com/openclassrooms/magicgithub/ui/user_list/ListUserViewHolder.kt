package com.openclassrooms.magicgithub.ui.user_list

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.openclassrooms.magicgithub.R
import com.openclassrooms.magicgithub.databinding.ItemListUserBinding
import com.openclassrooms.magicgithub.model.User

// ViewHolder chargé de gérer l'affichage des détails d'un utilisateur
class ListUserViewHolder(private val binding: ItemListUserBinding) : RecyclerView.ViewHolder(binding.root) {

    // Associe les données de l'utilisateur aux composants visuels de l'élément
    fun bind(user: User, callback: UserListAdapter.Listener) {
        // Chargement de l'image de l'utilisateur avec Glide
        Glide.with(binding.root.context)  // Récupère le contexte de la vue racine
            .load(user.avatarUrl)  // Charge l'avatar à partir de l'URL de l'utilisateur
            .apply(RequestOptions.circleCropTransform())  // Applique une transformation circulaire à l'image
            .placeholder(R.drawable.ic_add_black_24dp)  // Image temporaire pendant le chargement
            .error(R.drawable.ic_add_black_24dp)  // Image en cas d'échec du chargement
            .into(binding.itemListUserAvatar)  // Injecte l'image dans la vue dédiée

        // Met à jour le nom d'utilisateur dans le champ texte
        binding.itemListUserUsername.text = user.login

        // Modifie l'apparence de l'élément en fonction de l'état actif de l'utilisateur
        binding.root.setBackgroundColor(
            if (user.isActive) Color.WHITE else Color.RED  // Blanc si actif, rouge sinon
        )

        // Déclenche l'action de suppression lorsque le bouton est cliqué
        binding.itemListUserDeleteButton.setOnClickListener {
            callback.onClickDelete(user)  // Appelle la méthode de suppression définie par le callback
        }
    }
}
