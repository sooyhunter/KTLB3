import kotlinx.coroutines.*

fun main() = runBlocking {
    val student1 = Student("  андрій  ")
    student1.studentAge = 19
    student1.updateGrades(listOf(90, 80, 70))

    val student2 = Student(name = "марія", age = 20, grades = listOf(95, 85, 90))

    println("\n== Студенти ==")
    println(student1)
    println(student2)

    println("\n== Перевантаження + (об'єднання оцінок) ==")
    val combinedGrades = student1 + student2
    println("Об'єднані оцінки: $combinedGrades")

    println("\n== Перевантаження * (множення оцінок) ==")
    val boostedStudent = student1 * 2

    println("\n== Порівняння студентів ==")
    val anotherStudent = Student("андрій", age = 19, grades = listOf(90, 80, 70))
    println("student1 == anotherStudent: ${student1 == anotherStudent}")

    println("\n== Lazy властивість ==")
    println("${student1.name} is ${student1.status}")

    println("\n== Асинхронне оновлення оцінок ==")
    val deferred = async { fetchGradesFromServer() }
    val newGrades = deferred.await()
    student1.updateGrades(newGrades)

    println("\n== Група студентів ==")
    val group = Group(student1, student2, boostedStudent)
    println("Найкращий студент: ${group.getTopStudent()}")
}
