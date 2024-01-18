package com.jsomven.pokedex.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.jsomven.pokedex.core.domain.model.EggGroups
import com.jsomven.pokedex.core.domain.model.EvolutionChainResource
import com.jsomven.pokedex.core.domain.model.PokemonSpecies

@Composable
fun PokemonDetail(
    modifier: Modifier = Modifier,
    pokemon: PokemonSpecies,
    onEvolutionChainClick: () -> Unit,
    onAbilitiesClick: () -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PokemonImageDetail(
            pokemonId = pokemon.id,
            name = pokemon.name,
            imageUrl = pokemon.imageUrl
        )

        PokemonStatsDetail(
            happiness = pokemon.baseHappiness,
            captureRate = pokemon.captureRate,
            eggGroups = pokemon.eggGroups
        )

        if (pokemon.id > 0){
            PokemonDetailsButtons(
                onEvolutionChainClick = onEvolutionChainClick,
                onAbilitiesClick = onAbilitiesClick
            )
        }

        Spacer(
            modifier = Modifier
                .weight(1f)
                .background(MaterialTheme.colorScheme.onBackground)
        )
    }
}

@Preview
@Composable
fun PokemonDetailPreview() {
    val pokemon = PokemonSpecies(
        id = -1,
        name = "bulbasaur",
        captureRate = -2,
        baseHappiness = -3,
        eggGroups = listOf(
            EggGroups("Dragon"),
            EggGroups("Hada")
        ),
        evolutionChain = EvolutionChainResource("")
    )

    PokemonDetail(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        pokemon = pokemon,
        onAbilitiesClick = {},
        onEvolutionChainClick = {}
    )
}
