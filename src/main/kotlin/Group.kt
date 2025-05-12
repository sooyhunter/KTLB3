class Group(vararg students: Student) {
    private val members = students.toList()

    operator fun get(index: Int): Student {
        return members[index]
    }

    fun getTopStudent(): Student? {
        return members.maxByOrNull { it.getAverage() }
    }
}
