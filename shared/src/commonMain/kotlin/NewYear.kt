import kotlinx.datetime.*

fun daysUntilNewYear(): Int {
    val today = Clock.System.todayAt(TimeZone.currentSystemDefault())
    val closesNewYear = LocalDate(today.year + 1,1,1)
    return today.daysUntil(closesNewYear)
}
