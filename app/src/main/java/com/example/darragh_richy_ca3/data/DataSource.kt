package com.example.darragh_richy_ca3.data

import com.example.darragh_richy_ca3.model.CardItem

object DataSource {
    fun getCardItems(): List<CardItem> {
        return listOf(
            CardItem(
                id = 1,
                title = "Aloe Vera",
                imageUrl = "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.D_ZCwXV7iRNM09I-uevYxAHaE7%26pid%3DApi&f=1&ipt=904354107358cbf57c5c37c209804890227fe39d66e59b057b65ec9357ac75f9&ipo=images"
            ),
            CardItem(
                id = 2,
                title = "Snake Plant",
                imageUrl = "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse3.mm.bing.net%2Fth%3Fid%3DOIP.dONsu4J4qcyupy4ncv97OgHaMo%26pid%3DApi&f=1&ipt=4da5ab0541fcdbe73efe4a2cc21aad6724b218357804e3f1889f7becce1733f6&ipo=images"
            ),
            CardItem(
                id = 3,
                title = "Spider Plant",
                imageUrl = "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.TL5EmIpD1gNv-EXjJiZNgwHaHa%26pid%3DApi&f=1&ipt=5fea2b80ec5954f88caf1cd51f19268bf235913bfea697723494c99c4edb45b2&ipo=images"
            ),
            CardItem(
                id = 4,
                title = "Peace Lily",
                imageUrl = "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.TL5EmIpD1gNv-EXjJiZNgwHaHa%26pid%3DApi&f=1&ipt=5fea2b80ec5954f88caf1cd51f19268bf235913bfea697723494c99c4edb45b2&ipo=images"
            ),
            CardItem(
                id = 5,
                title = "Fiddle Leaf Fig",
                imageUrl = "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fbloomscape.com%2Fwp-content%2Fuploads%2F2019%2F05%2Fbloomscape_product-fiddle-leaf-fig-charcoal-2-e1558203207444.jpg&f=1&nofb=1&ipt=6d75bd44c521091a7355341fcd0ddade06500aba62e12ea65165cb9b083c82ae&ipo=images"
            ),
            CardItem(
                id = 6,
                title = "Monstera",
                imageUrl = "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.ECr90Ko16V2NcVNfajGdowHaJQ%26pid%3DApi&f=1&ipt=52df532d22c8fdc8d0dd0b77a3d58da449272a7f2e1a3391bd9a98e4e8f9ebd6&ipo=images"
            )
        )
    }
}
