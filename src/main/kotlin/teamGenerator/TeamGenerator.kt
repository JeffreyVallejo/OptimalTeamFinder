package teamGenerator

import Model.Pokemon
import Model.Team
import org.paukov.combinatorics3.Generator

private const val MAX_TEAM_SIZE = 6
class TeamGenerator {
    private var generatedTeams: MutableList<Team> = mutableListOf()
    private var allCombinations: MutableList<List<MutableList<Int>>> = mutableListOf()

    /**
     * Driver for generating all combinations.
     */
    fun generateAllTeamCombination(availablePokemon: List<Pokemon>, baseStatLimit: Int, threshold: Int): MutableList<Team> {
        val sTs = getSmallestTeam(availablePokemon, baseStatLimit)

        // Add all the combinations to the class list.
        for(r in sTs..MAX_TEAM_SIZE) {
            allCombinations.add(getCombinationsOfNChooseR(availablePokemon.size - 1, r))
        }

        for(combination in allCombinations) {
            for(c in combination) {
                generateASingleTeamCombination(availablePokemon, c, baseStatLimit, threshold)
            }
        }

        return generatedTeams
    }

    /**
     * Uses the combination indices, baseStatLimit, and threshold to create all the combinations from the list
     * availablePokemon
     */
    private fun generateASingleTeamCombination(availablePokemon: List<Pokemon>, combo: MutableList<Int>, baseStatLimit: Int, thresh: Int) {
        var currentTeam = Team("", 0)
        for(index in combo) {
            currentTeam.pokemon = currentTeam.pokemon + availablePokemon[index].name + ", "
            currentTeam.totalStat += availablePokemon[index].baseStat
        }

        if(currentTeam.totalStat in (thresh + 1) until baseStatLimit) {
            generatedTeams.add(currentTeam)
        }
    }

    /**
     * Gets all nCr combinations.
     */
    private fun getCombinationsOfNChooseR(n: Int, r: Int): List<MutableList<Int>> {
        val numbers = List(n){(it + 1) }
        return Generator.combination(numbers).simple(r).toList()
    }

    /**
     *  Determines the smallest team that would fit into the base stat limit.
     * The purpose is to limit the amount of combinations we calculate since we want to always maximize the base stat
     * of the ream
     */
    private fun getSmallestTeam(availablePokemon: List<Pokemon>, baseStatLimit: Int): Int {
        var largestBaseStat = 0
        for(pokemon in availablePokemon) {
            if(pokemon.baseStat > largestBaseStat) {
                largestBaseStat = pokemon.baseStat
            }
        }

        return baseStatLimit / largestBaseStat
    }
}