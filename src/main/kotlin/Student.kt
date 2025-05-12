class Student(
    name: String,
    private var age: Int = 0,
    private var grades: List<Int> = listOf()
) {
    init {
        println("Створено об'єкт Student: $name")
    }

    constructor(name: String) : this(name.trim().replaceFirstChar { it.uppercase() })

    private var _name: String = name.trim().replaceFirstChar { it.uppercase() }
    var name: String
        get() = _name
        set(value) {
            _name = value.trim().replaceFirstChar { it.uppercase() }
        }

    var studentAge: Int
        get() = age
        set(value) {
            if (value >= 0) age = value
        }

    val isAdult: Boolean
        get() = age >= 18

    val status: String by lazy {
        if (isAdult) "Adult" else "Minor"
    }

    fun getAverage(): Double {
        return if (grades.isNotEmpty()) grades.average() else 0.0
    }

    fun processGrades(operation: (Int) -> Int) {
        grades = grades.map(operation)
    }

    fun updateGrades(newGrades: List<Int>) {
        grades = newGrades
        println("Оцінки оновлено для $name: $grades")
    }

    operator fun plus(other: Student): List<Int> {
        return this.grades + other.grades
    }

    operator fun times(factor: Int): Student {
        val newGrades = grades.map { it * factor }
        val newStudent = Student(name, age, newGrades)
        println("Оцінки $name після множення: ${newGrades}")
        return newStudent
    }

    override operator fun equals(other: Any?): Boolean {
        if (other !is Student) return false
        return this.name == other.name && this.getAverage() == other.getAverage()
    }

    override fun toString(): String {
        return "Student(name='$name', age=$age, grades=$grades, status=$status)"
    }
}
