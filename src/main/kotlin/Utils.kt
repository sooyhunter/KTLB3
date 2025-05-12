import kotlinx.coroutines.delay

suspend fun fetchGradesFromServer(): List<Int> {
    delay(2000)
    return listOf(85, 90, 78, 92, 88)
}
