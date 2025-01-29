package com.openclassrooms.magicgithub.api

import com.openclassrooms.magicgithub.model.User
import java.util.*

object FakeApiServiceGenerator {

    @JvmField
    var FAKE_USERS = mutableListOf(
        User("001", "Jake", "https://api.adorable.io/AVATARS/512/1.png"),
        User("002", "Paul", "https://api.adorable.io/AVATARS/512/2.png"),
        User("003", "Phil", "https://api.adorable.io/AVATARS/512/3.png"),
        User("004", "Guillaume", "https://api.adorable.io/AVATARS/512/4.png"),
        User("005", "Francis", "https://api.adorable.io/AVATARS/512/5.png"),
        User("006", "George", "https://api.adorable.io/AVATARS/512/6.png"),
        User("007", "Louis", "https://api.adorable.io/AVATARS/512/7.png"),
        User("008", "Mateo", "https://api.adorable.io/AVATARS/512/8.png"),
        User("009", "April", "https://api.adorable.io/AVATARS/512/9.png"),
        User("010", "Louise", "https://api.adorable.io/AVATARS/512/10.png"),
        User("011", "Elodie", "https://api.adorable.io/AVATARS/512/11.png"),
        User("012", "Helene", "https://api.adorable.io/AVATARS/512/12.png"),
        User("013", "Fanny", "https://api.adorable.io/AVATARS/512/13.png"),
        User("014", "Laura", "https://api.adorable.io/AVATARS/512/14.png"),
        User("015", "Gertrude", "https://api.adorable.io/AVATARS/512/15.png"),
        User("016", "Chloé", "https://api.adorable.io/AVATARS/512/16.png"),
        User("017", "April", "https://api.adorable.io/AVATARS/512/17.png"),
        User("018", "Marie", "https://api.adorable.io/AVATARS/512/18.png"),
        User("019", "Henri", "https://api.adorable.io/AVATARS/512/19.png"),
        User("020", "Rémi", "https://api.adorable.io/AVATARS/512/20.png")
    )

    @JvmField
    var FAKE_USERS_RANDOM = Arrays.asList(
        User("021", "Lea", "https://api.adorable.io/AVATARS/512/21.png"),
        User("022", "Geoffrey", "https://api.adorable.io/AVATARS/512/22.png"),
        User("023", "Simon", "https://api.adorable.io/AVATARS/512/23.png"),
        User("024", "André", "https://api.adorable.io/AVATARS/512/24.png"),
        User("025", "Leopold", "https://api.adorable.io/AVATARS/512/25.png")
    )
}